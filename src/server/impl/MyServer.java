package server.impl;

import javax.servlet.http.HttpServletRequest;

import server.CommonServer;
import util.StoreHttp;

public class MyServer extends CommonServer
{
	private String name;
	private double age;
	private String address;
	private int id;
	
	public int getId()
	{
		return this.id;
	}
	
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public double getAge()
	{
		return age;
	}
	public void setAge(double age)
	{
		this.age = age;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
		
	public String login() 
	{
		id = 17;
		HttpServletRequest request = StoreHttp.getRequest();
		
		System.out.println(request.getParameter("address"));
		
		System.out.println("name: "+name+", age: "+age+", address: "+address);
		
		String result = null;
	
		if(name.equals("fuck") && age>20)
		{
			result = SUCCESS;
		}
		else if(name.equals("god"))
		{
			result = ERROR;
		}
		else
		{
			result = INPUT;
		}
		return result;
		
		
	}

}
