package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 用来暂时存放单次请求和响应信息,根据需要决定是否启用
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
