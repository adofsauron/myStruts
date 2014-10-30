package server.impl;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import bean.User;

import dao.MyDao;

public class DaoServer
{
	private String name;
	private String password;
	private String tel;
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getTel()
	{
		return tel;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}

	public String daoQuery() throws Exception
	{
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(name!=null)
			map.put("name", name);
		if(password!=null)
		map.put("password", password);
		if(tel!=null)
		map.put("tel", tel);

		List<User> users = MyDao.query(map, User.class);
		
		for(User user: users)
		{
			System.out.println("daoServer: "+user.getId()+","+
						user.getName()+", "+user.getPassword()+", "+user.getTel());
		}
		return "success";
	}
}
