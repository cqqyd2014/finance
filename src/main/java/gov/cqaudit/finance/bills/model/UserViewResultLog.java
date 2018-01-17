package gov.cqaudit.finance.bills.model;

public class UserViewResultLog {
	String user_id;
	String user_name;
	String dept_id;
	String dept_name;
	String ip;
	java.util.Date view_dat;
	String view_dat_print;
	String view_dat_chinese_print;
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
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public java.util.Date getView_dat() {
		return view_dat;
	}
	public void setView_dat(java.util.Date view_dat) {
		this.view_dat = view_dat;
	}
	public String getView_dat_print() {
		return view_dat_print;
	}
	public void setView_dat_print(String view_dat_print) {
		this.view_dat_print = view_dat_print;
	}
	public String getView_dat_chinese_print() {
		return view_dat_chinese_print;
	}
	public void setView_dat_chinese_print(String view_dat_chinese_print) {
		this.view_dat_chinese_print = view_dat_chinese_print;
	}
}
