package dto;

public class Member {
	private String name;
	private String id;
	private String password;
	private String email;
	private String addr;
	
	public Member(){}
	public Member(String name, String id, String password, String email, String addr) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.email = email;
		this.addr = addr;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
}
