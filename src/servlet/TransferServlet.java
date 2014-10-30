package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.impl.CommonControlImpl;

@SuppressWarnings("serial")
public class TransferServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//this.log("do get.....");
		try
		{
			CommonControlImpl.getInstance().execute(request, response);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//this.log("do post...");
		try
		{
			CommonControlImpl.getInstance().execute(request, response);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
