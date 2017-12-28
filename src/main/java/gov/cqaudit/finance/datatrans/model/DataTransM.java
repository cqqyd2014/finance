package gov.cqaudit.finance.datatrans.model;

public class DataTransM {
	String upload_user_id;
	public String getUpload_user_id() {
		return upload_user_id;
	}
	public void setUpload_user_id(String upload_user_id) {
		this.upload_user_id = upload_user_id;
	}
	String user_id;
	String trans_uuid;
	java.util.Date download_dat;
	java.util.Date bank_working_dat;
	public java.util.Date getBank_working_dat() {
		return bank_working_dat;
	}
	public void setBank_working_dat(java.util.Date bank_working_dat) {
		this.bank_working_dat = bank_working_dat;
	}
	java.util.Date upload_dat;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTrans_uuid() {
		return trans_uuid;
	}
	public void setTrans_uuid(String trans_uuid) {
		this.trans_uuid = trans_uuid;
	}
	public java.util.Date getDownload_dat() {
		return download_dat;
	}
	public void setDownload_dat(java.util.Date download_dat) {
		this.download_dat = download_dat;
	}
	public java.util.Date getUpload_dat() {
		return upload_dat;
	}
	public void setUpload_dat(java.util.Date upload_dat) {
		this.upload_dat = upload_dat;
	}
}
