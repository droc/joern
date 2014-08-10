package cfg.nodes;

import java.util.HashMap;
import java.util.Map;

import databaseNodes.NodeKeys;

public abstract class AbstractCFGNode implements CFGNode
{

	@Override
	public String toString()
	{
		return getClass().getSimpleName();
	}

	@Override
	public Map<String, Object> getProperties()
	{
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(NodeKeys.CODE, toString());
		properties.put(NodeKeys.TYPE, getClass().getSimpleName());
		properties.put(NodeKeys.IS_CFG_NODE, "True");
		return properties;
	}

}
