/**
   Elementrary traversals starting at AST nodes.
*/

/** 
    Traverse from root of AST to all nodes it contains
    (including the node itself) This is refered to as 'TNODES' in the
    paper simply because otherwise its definition would not fit in a
    column ;)
*/


astNodes = {
	delegate.repeat(_children()).until(noMoreChildren()).emit{true}
}

/**
   Traverse to parent-nodes of AST nodes.
*/

parents = {
	delegate.in(AST_EDGE)
}

/**
   Traverse to child-nodes of AST nodes.
*/

children = {
	delegate.out(AST_EDGE)
}

noMoreChildren = {
	outE(AST_EDGE).count().is(0)
}

/**
   Traverse to i'th children.
   
   @param i The child index
*/

ithChildren = { args ->
 i = args[0];
 delegate.children().has(NODE_CHILDNUM, i)	
}

isStatement = { it ->
  it.isCFGNode == 'True'
}


/**
 * Traverse to siblings.
 */
siblings = {
	_().sideEffect{ nodeId = it.id }
	.parents()
	.children()
	.filter{ it.id != nodeId }
}

/**
   Traverse to statements enclosing supplied AST nodes. This may be
   the node itself.
*/

statements = {
  delegate.until(has(NODE_ISCFGNODE, 'True')).repeat(_parents())
}

/**
   Get number of children of an AST node.
*/

numChildren = {
	_().transform{ numChildren(it)  }
}

numChildren = { it ->
	it.out('IS_AST_PARENT').toList().size()
}