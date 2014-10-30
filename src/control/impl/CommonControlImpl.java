package control.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Infuse;

import control.CommonControl;
import control.source.ConFactorySource;

public class CommonControlImpl extends CommonControl
{
	private static CommonControl  commonControl = new CommonControlImpl();
	private CommonControlImpl(){}
	
	public static CommonControl getInstance()
	{
		return commonControl;
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String urlPattern = request.getRequestURI().substring(request.getContextPath().length());
		
		String forward = null;
		
		if(ConFactorySource.getInstance().fillServerMap().containsKey(urlPattern))
		{
		 String result = Infuse.performance(ConFactorySource.getInstance().fillServerMap().get(urlPattern).getPath(),
				 					ConFactorySource.getInstance().fillServerMap().get(urlPattern).getMethod(), request, response);
		 
		 if(( forward=ConFactorySource.getInstance().fillServerMap().get(urlPattern).getResultMap().get(result) )!=null)
		 {
			 dispatcher(forward, request, response);	
		 }
		}
	}
	
	private static void dispatcher(String forward, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		if(forward!=null)
		{
			request.getRequestDispatcher(forward).forward(request, response);
		}
	}
	
}
