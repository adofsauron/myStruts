package server.impl;

import bean.Person;
import server.CommonServer;

public class PersonServer extends CommonServer
{
	private Person person;
	public Person getPerson()
	{
		return person;
	}
	public void setPerson(Person person)
	{
		this.person = person;
	}

	private String name;
	private int age;
	private float money;
	private String address;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public float getMoney()
	{
		return money;
	}
	public void setMoney(float money)
	{
		this.money = money;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}

	public String execute() throws Exception
	{
		System.out.println(name+", "+age+", "+money+", "+address);
		String result = null;

		if(name.equalsIgnoreCase("fuck") && age>20 && money>50)
		{
			result = SUCCESS;
		}	
		else if(age<20)
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
