package util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Infuse
{
	private static void setAttributeToObject(Object obj, HttpServletRequest request) throws Exception
	{
		List<String> fieldNames = getFieldNames(obj.getClass());
		List<String> requestNames = getRequestNames(request);
							
		for(String requestName: requestNames)
		{
			for(String fieldName: fieldNames)
			{
				if(fieldName.equals(requestName))
				{
					inject(obj, requestName, fieldName, request);
				}
			}
		}		
	}
	
	//开始利用反射和setter方法将request中的数据写入相应的属性中
	private static void inject(Object obj, String requestName, 
			String fieldName, HttpServletRequest request) throws Exception
	{
		Class<?> valueClass = null ;
		String value = request.getParameter(requestName);
		String valueType = obj.getClass().getDeclaredField(fieldName).getType().getName();
		if(value!=null && !value.equals(""))
		{
			if(valueType.endsWith("String"))
			{
				valueClass = String.class;
				Method met = obj.getClass().getMethod(forSetter(requestName), valueClass);
				met.invoke(obj, (String) value);
			}
			else if(valueType.equals("int"))
			{
				valueClass = int.class;
				Method met = obj.getClass().getMethod(forSetter(requestName), valueClass);
				met.invoke(obj, Integer.parseInt(value));
			}
			else if(valueType.equals("double"))
			{
				valueClass = double.class;
				Method met = obj.getClass().getMethod(forSetter(requestName), valueClass);
				met.invoke(obj, Double.parseDouble(value));
			}
			else if(valueType.equals("float"))
			{
				valueClass = float.class;
				Method met = obj.getClass().getMethod(forSetter(requestName), valueClass);
				met.invoke(obj, Float.parseFloat(value));
			}
		}
	}
	
	//模拟setter方法
	private static String forSetter(String param)
	{
		return "set"+param.substring(0,1).toUpperCase() + param.substring(1);
	}
	
	//模拟getter方法
	private static String forGetter(String param)
	{
		return "get"+param.substring(0,1).toUpperCase() + param.substring(1);
	}
	
	
	
	//返回该类的所有属性名字
	public static List<String> getFieldNames(Class<?> cla)
	{
		List<String> fieldNames = new ArrayList<String>();
		
		Field[] fields = cla.getDeclaredFields();
		for(Field field: fields)
		{
			fieldNames.add(field.getName());
		}
		
		return fieldNames;
	}
	
	//返回request请求中所有的字段名字
	private static List<String> getRequestNames(HttpServletRequest request)
	{
		List<String> requestNames = new ArrayList<String>();
		
		Enumeration<String> requestNameEnums = request.getParameterNames();
		while (requestNameEnums.hasMoreElements())
		{
			String requestName = (String) requestNameEnums.nextElement();
			
			requestNames.add(requestName);
		}
		return requestNames;
	}
	
	private static Object getObject(String path)
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
	
	// 执行method方法后返回该方法的String类型的返回值	 
	public static String performance(String path,  String method,
			HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Object obj = getObject(path);
		setAttributeToObject(obj, request);
		
		StoreHttp.setHttp(request, response);  //暂存请求和响应对象
		
		Method met = obj.getClass().getMethod(method);
		String result = (String) met.invoke(obj);
		
		getAttributeToRequest(obj, request);
						
		return result;
	}	
	
	//利用getter方法将数据写入request中
	private static void getAttributeToRequest(Object obj, HttpServletRequest request) throws Exception
	{
		List<String> fieldNames = getFieldNames(obj.getClass());
			
		for(String fieldName: fieldNames)
		{
			Method met = obj.getClass().getMethod(forGetter(fieldName));
			Object value = met.invoke(obj);
			if(value!=null && !value.equals(""))
			{
				request.setAttribute(fieldName, value);
			}
		}
	}
}
