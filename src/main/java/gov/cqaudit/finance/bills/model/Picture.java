package gov.cqaudit.finance.bills.model;

public class Picture {
	String bill_uuid;
	public String getBill_uuid() {
		return bill_uuid;
	}
	public void setBill_uuid(String bill_uuid) {
		this.bill_uuid = bill_uuid;
	}
	String user_id;
	String user_name;
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
	String content_type;
	long length;
	String file_name;
	byte[] bin_data;
	java.util.Date op_dat;
	boolean effective;
	String uuid;
	public String getContent_type() {
		return content_type;
	}
	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public byte[] getBin_data() {
		return bin_data;
	}
	public void setBin_data(byte[] bin_data) {
		this.bin_data = bin_data;
	}
	public java.util.Date getOp_dat() {
		return op_dat;
	}
	public void setOp_dat(java.util.Date op_dat) {
		this.op_dat = op_dat;
	}
	public boolean isEffective() {
		return effective;
	}
	public void setEffective(boolean effective) {
		this.effective = effective;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
