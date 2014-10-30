package control.conbean;

import java.util.Map;

import com.sun.servicetag.UnauthorizedAccessException;

public class ServerConBean 
{
	private String path;
	private Map<String, String> resultMap;
	private String method;
	
	public ServerConBean(){};
	
	public ServerConBean(String path, String method, Map<String, String> map)
	{
		setParams(path, map, method);
	}

	public void setParams(String _path, Map<String, String> _map, String _method)
	{
		this.path = _path;
		this.resultMap = _map;
		this.method = _method;
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public Map<String, String> getResultMap()
	{
		return resultMap;
	}

	public void setResultMap(Map<String, String> resultMap)
	{
		this.resultMap = resultMap;
	}

	public String getMethod()
	{
		return method;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}	
	
	
}	
