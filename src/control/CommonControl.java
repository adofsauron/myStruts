package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * ˵��:���еĿ�����������̳д˳�����,�Ա㹤�����ܷ��ش�����ʵ��
 * init��destroyΪ�������͹ر�ʱ���õķ�����������Ҫ����������д
 */
public abstract class CommonControl
{
	public void init()
	{
		
	}
	
	/*
	 * ���е��������ʵ�ִ˷���������ҵ����߼���ͼ�����ݷ������ַ������п�����ƥ��
	 */
	public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws Exception ;
	
	public void destroy()
	{
		
	}
	
	
}
