package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 说明:所有的控制器都必须继承此抽象类,以便工厂类能返回此类型实例
 * init和destroy为在启动和关闭时调用的方法，根据需要由子类来复写
 */
public abstract class CommonControl
{
	public void init()
	{
		
	}
	
	/*
	 * 所有的子类必须实现此方法，返回业务的逻辑视图，根据返还的字符串进行控制器匹配
	 */
	public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws Exception ;
	
	public void destroy()
	{
		
	}
	
	
}
