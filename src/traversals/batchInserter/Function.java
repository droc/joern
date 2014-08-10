package traversals.batchInserter;

import neo4j.EdgeTypes;
import neo4j.batchInserter.Neo4JBatchInserter;

import org.neo4j.graphdb.index.IndexHits;

import databaseNodes.NodeKeys;

public class Function
{

	public static IndexHits<Long> getFunctionsByName(String functionName)
	{
		return Neo4JBatchInserter
				.queryIndex(NodeKeys.NAME + ":" + functionName);
	}

	public static long getCFGForFunction(Long funcId)
	{
		return Elementary.getFirstChildWithEdgeType(funcId,
				EdgeTypes.IS_FUNCTION_OF_CFG);
	}

}
