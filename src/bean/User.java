package bean;

/*
 * 描叙： 专门存储用户信息
 * 与其他表关系： 以唯一标识为外键，关联到account表
 */
public class User
{
	private int id;  //唯一标识
	private String name; //姓名
	private String password; //密码
	private String tel; //电话号码, 用11位字符串存储
	private String email; //电子邮箱
	
	
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
