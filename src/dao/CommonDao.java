package dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class CommonDao
{
	
	public static Connection getConn() 
	{
		String DBDRIVER = "com.mysql.jdbc.Driver";
		String DBURL = "jdbc:mysql://localhost:3306/bank?useUnicode=true&characterEncoding=utf-8";
		String DBUSER = "root";
		String DBPASS = "111";
		
		Connection conn = null;
		try
		{
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return conn;
	}

	public static void closeConn(Connection conn)
	{
		if (conn != null)
		{
			try
			{
				conn.close();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
