package server.impl;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import server.CommonServer;
import util.StoreHttp;

public class AjaxServer extends CommonServer
{
	private String value;
	
	public String getValue()
	{
		return value;
	}
	public void setValue(String value)
	{
		this.value = value;
	}

	public String ajax() throws Exception
	{
		HttpServletResponse response = StoreHttp.getResponse();
		
		PrintWriter out = response.getWriter();
		if(value!=null && !value.equals(""))
		{
			if(value.equals("Jame"))
			{
				out.println("you have come in!");
			}	
			else
			{
				out.println("LIMIT!!");
			}
		}
		else
		{
			out.println("NULL!!");
		}
	
		return "success";
	}


}
