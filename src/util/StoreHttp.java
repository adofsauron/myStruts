package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * ������ʱ��ŵ����������Ӧ��Ϣ,������Ҫ�����Ƿ�����
 */
public class StoreHttp
{
	private static HttpServletRequest request ;
	private static HttpServletResponse response;
	
	public static void setHttp(HttpServletRequest _request, HttpServletResponse _response)
	{
		request = _request;
		response =  _response;
	}
	
	public static HttpServletRequest getRequest()
	{
		return request;
	}
	
	public static HttpServletResponse getResponse()
	{
		return response;
	}
}
