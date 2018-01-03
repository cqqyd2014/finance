package gov.cqaudit.finance.system.model;

public class Dept {
	String dept_uuid;
	String dept_name;
	String dept_type;
	java.math.BigDecimal user_num;
	public java.math.BigDecimal getUser_num() {
		return user_num;
	}
	public void setUser_num(java.math.BigDecimal user_num) {
		this.user_num = user_num;
	}
	public String getDept_uuid() {
		return dept_uuid;
	}
	public void setDept_uuid(String dept_uuid) {
		this.dept_uuid = dept_uuid;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getDept_type() {
		return dept_type;
	}
	public void setDept_type(String dept_type) {
		this.dept_type = dept_type;
	}
	public String getDept_type_name() {
		return dept_type_name;
	}
	public void setDept_type_name(String dept_type_name) {
		this.dept_type_name = dept_type_name;
	}
	String dept_type_name;

}
