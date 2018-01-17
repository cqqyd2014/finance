package gov.cqaudit.finance.system.model;

public class SysUser {
	
	String create_dat_print;
	java.util.Date create_dat;
	public java.util.Date getCreate_dat() {
		return create_dat;
	}
	public void setCreate_dat(java.util.Date create_dat) {
		this.create_dat = create_dat;
	}
	public String getCreate_dat_print() {
		return create_dat_print;
	}
	public void setCreate_dat_print(String create_dat_print) {
		this.create_dat_print = create_dat_print;
	}
	public String getEffective_print() {
		return effective_print;
	}
	public void setEffective_print(String effective_print) {
		this.effective_print = effective_print;
	}
	public String getLast_online_dat_print() {
		return last_online_dat_print;
	}
	public void setLast_online_dat_print(String last_online_dat_print) {
		this.last_online_dat_print = last_online_dat_print;
	}
	String user_id;
	String user_name;
	
	String user_login_name;
	String dept_id;
	String dept_name;
	String password;
	String role_id;
	String role_name;
	String tell;
	String email;
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	boolean effective;
	String effective_print;
	boolean online;
	String last_online_dat_print;
	java.util.Date last_online_dat;
	public boolean isEffective() {
		return effective;
	}
	public void setEffective(boolean effective) {
		this.effective = effective;
	}
	public boolean isOnline() {
		return online;
	}
	public void setOnline(boolean online) {
		this.online = online;
	}
	public java.util.Date getLast_online_dat() {
		return last_online_dat;
	}
	public void setLast_online_dat(java.util.Date last_online_dat) {
		this.last_online_dat = last_online_dat;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_login_name() {
		return user_login_name;
	}
	public void setUser_login_name(String user_login_name) {
		this.user_login_name = user_login_name;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

}
