package control.source;

import java.util.HashMap;
import java.util.Map;


import control.conbean.ServerConBean;

public class ConFactorySource
{
	private static ConFactorySource conFactorySource = new ConFactorySource();
	
	private  Map<String, ServerConBean> serverMap = new HashMap<String, ServerConBean>();
	private  Map<String, String> resultMap;
	
	private ConFactorySource()
	{
		resultMap = new HashMap<String, String>();
		resultMap.put("success", "/view/success.jsp");
		resultMap.put("error", "/view/error.jsp");
		resultMap.put("input", "/view/input.jsp");
		serverMap.put("/name.action", new ServerConBean("server.impl.MyServer", "login", resultMap));
		
		resultMap = new HashMap<String, String>();
		resultMap.put("success", "/view/success.jsp");
		resultMap.put("error", "/view/error.jsp");
		resultMap.put("input", "/view/input.jsp");
		serverMap.put("/person.action", new ServerConBean("server.impl.PersonServer", "execute", resultMap));
		
		resultMap = new HashMap<String, String>();
		serverMap.put("/ajax.action", new ServerConBean("server.impl.AjaxServer", "ajax", resultMap));
		
		
		resultMap = new HashMap<String, String>();
		resultMap.put("success", "/view/success.jsp");
		serverMap.put("/dao.action", new ServerConBean("server.impl.DaoServer", "daoQuery", resultMap));
	}
	
	public static ConFactorySource getInstance()
	{
		return conFactorySource;
	}
	
	public  Map<String, ServerConBean>  fillServerMap()
	{
		return serverMap;
	}
}
