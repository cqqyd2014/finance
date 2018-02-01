package gov.cqaudit.finance.bills.model;

public class BillMessage {
	String bill_uuid;
	public String getBill_uuid() {
		return bill_uuid;
	}
	public void setBill_uuid(String bill_uuid) {
		this.bill_uuid = bill_uuid;
	}
	String user_id;
	String user_name;
	String type_id;
	String type_name;
	String message;
	java.util.Date create_dat;
	public void setCreate_dat(java.util.Date create_dat) {
		this.create_dat = create_dat;
	}
	String craete_dat_print;
	String message_uuid;
	String ip_addr;
	String dept_id;
	String dept_name;
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
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}


	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public java.util.Date getCreate_dat() {
		return create_dat;
	}
	public String getCraete_dat_print() {
		return craete_dat_print;
	}
	public void setCraete_dat_print(String craete_dat_print) {
		this.craete_dat_print = craete_dat_print;
	}
	public String getMessage_uuid() {
		return message_uuid;
	}
	public void setMessage_uuid(String message_uuid) {
		this.message_uuid = message_uuid;
	}
	public String getIp_addr() {
		return ip_addr;
	}
	public void setIp_addr(String ip_addr) {
		this.ip_addr = ip_addr;
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
	
	

}
