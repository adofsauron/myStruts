package dao;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import util.Infuse;

import bean.User;

public class  MyDao 
{
	private static PreparedStatement pstmt = null ;
	private static ResultSet rs = null ;	
	
	public static List<User> query(Map<String, Object> map, Class<?> objCla) throws Exception
	{
		String sql = "select * from user ";
		
		List<String> list = Infuse.getFieldNames(objCla); //得到该类的所有属性名字
		
		sql = transform(map, list, sql);
		
		System.out.println(sql);
		
		List<User> objList = new ArrayList<User>();
		pstmt = CommonDao.getConn().prepareStatement(sql);
		rs =  pstmt.executeQuery();
		while(rs.next())
		{
			User user = new User();
			
			Object id = rs.getObject("id");
			Object name = rs.getObject("name");
			Object password = rs.getObject("password");
			Object tel = rs.getObject("tel");
			Object email = rs.getObject("email");
			
			user.setId( (Integer) id);
			user.setName((String)name);
			user.setPassword((String)password);
			user.setTel((String)tel);
			user.setEmail((String)email);
			
			objList.add(user);
		}
		
		return objList;
	}
	
	public static String transform(Map<String, Object> map,List<String> list, String sql)
	{
		String where = "where";
		String and = "and";
		for(String key: list)
		{
			if(map.containsKey(key))
			{
				if(sql.contains(where))
				{	
					if(map.get(""+key+"") instanceof String)
						sql = sql +and+ " "+key+"='"+(String) map.get(""+key+"")+"'";
					if(map.get(""+key+"") instanceof Integer)
						sql = sql +and+ " "+key+"='"+(Integer) map.get(""+key+"")+"'";
					if(map.get(""+key+"") instanceof Double)
						sql = sql +and+ " "+key+"='"+(Double) map.get(""+key+"")+"'";
				}
				else
				{
					if(map.get(""+key+"") instanceof String)
						sql = sql + where + " "+key+"='"+(String) map.get(""+key+"")+"'";
					if(map.get(""+key+"") instanceof Integer)
						sql = sql +where+ " "+key+"='"+(Integer) map.get(""+key+"")+"'";
					if(map.get(""+key+"") instanceof Double)
						sql = sql +where+ " "+key+"='"+(Double) map.get(""+key+"")+"'";
				}
			}
		}
		
		return sql;
	}
	
}
