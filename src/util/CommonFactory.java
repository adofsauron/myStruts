package util;

import server.CommonServer;
import control.CommonControl;
import control.conbean.ServerConBean;

public class CommonFactory
{
	public static Object getObject(String path)
	{
		Object obj = null;
		try
		{
			obj = Class.forName(path).newInstance();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return obj;
	}
	
	public static ServerConBean getServerConbean(String path)
	{
		ServerConBean serverConbean = null;
		try
		{
			serverConbean = (ServerConBean) getObject(path);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return serverConbean ;
	}
	
	public static <T extends CommonControl> CommonControl getCommonControl(String path)
	{
		CommonControl commanControl = null;
		try
		{
			commanControl = (CommonControl) getObject(path);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return commanControl ;
	}
	
	public static <T extends CommonServer> CommonServer getCommonServer(String path)
	{
		CommonServer commonServer = null;
		try
		{
			commonServer = (CommonServer) getObject(path);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return commonServer;
	}
}
