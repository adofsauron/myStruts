package bean;

/*
 * ���� ר�Ŵ洢�û���Ϣ
 * ���������ϵ�� ��Ψһ��ʶΪ�����������account��
 */
public class User
{
	private int id;  //Ψһ��ʶ
	private String name; //����
	private String password; //����
	private String tel; //�绰����, ��11λ�ַ����洢
	private String email; //��������
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
