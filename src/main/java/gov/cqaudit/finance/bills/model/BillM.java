package gov.cqaudit.finance.bills.model;

public class BillM {
	
	String bill_type;
	String bill_type_name;
	
	public String getBill_type() {
		return bill_type;
	}
	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}
	public String getBill_type_name() {
		return bill_type_name;
	}
	public void setBill_type_name(String bill_type_name) {
		this.bill_type_name = bill_type_name;
	}

	java.util.Date uneffective_dat;
	String uneffective_dat_chinese_print;
	public String getUneffective_dat_chinese_print() {
		return uneffective_dat_chinese_print;
	}
	public void setUneffective_dat_chinese_print(String uneffective_dat_chinese_print) {
		this.uneffective_dat_chinese_print = uneffective_dat_chinese_print;
	}

	String uneffecitve_user_id;
	String uneffecitve_user_name;
	
	public java.util.Date getUneffective_dat() {
		return uneffective_dat;
	}
	public void setUneffective_dat(java.util.Date uneffective_dat) {
		this.uneffective_dat = uneffective_dat;
	}
	public String getUneffecitve_user_id() {
		return uneffecitve_user_id;
	}
	public void setUneffecitve_user_id(String uneffecitve_user_id) {
		this.uneffecitve_user_id = uneffecitve_user_id;
	}
	public String getUneffecitve_user_name() {
		return uneffecitve_user_name;
	}
	public void setUneffecitve_user_name(String uneffecitve_user_name) {
		this.uneffecitve_user_name = uneffecitve_user_name;
	}

	java.util.ArrayList<Picture> pictures;


	java.math.BigDecimal pics_num;
	java.math.BigDecimal detail_num;
	
	public java.math.BigDecimal getDetail_num() {
		return detail_num;
	}
	public void setDetail_num(java.math.BigDecimal detail_num) {
		this.detail_num = detail_num;
	}
	public java.math.BigDecimal getPics_num() {
		return pics_num;
	}
	public void setPics_num(java.math.BigDecimal pics_num) {
		this.pics_num = pics_num;
	}

	public java.util.ArrayList<Picture> getPictures() {
		return pictures;
	}
	public void setPictures(java.util.ArrayList<Picture> pictures) {
		this.pictures = pictures;
	}
	public java.util.ArrayList<BillD> getBill_details() {
		return bill_details;
	}
	public void setBill_details(java.util.ArrayList<BillD> bill_details) {
		this.bill_details = bill_details;
	}

	java.util.ArrayList<BillD> bill_details;


	boolean effective;
	public boolean isEffective() {
		return effective;
	}
	public void setEffective(boolean effective) {
		this.effective = effective;
	}

	String create_user_id;
	String create_user_name;
	java.util.Date create_dat;
	String create_dat_chinese_print;
	public String getCreate_dat_chinese_print() {
		return create_dat_chinese_print;
	}
	public void setCreate_dat_chinese_print(String create_dat_chinese_print) {
		this.create_dat_chinese_print = create_dat_chinese_print;
	}

	String bill_status;
	

	String contract_name;
	String contract_tell;
	String contract_mail;
	String audit_user_id;
	String audit_user_name;
	java.util.Date last_audit_dat;
	String last_audit_dat_chinese_print;
	String pro_name;
	String bill_uuid;
	String dept_id;
	String dept_name;
	java.util.Date last_modify_dat;
	String last_modify_dat_chinese_print;
	String search_reason;
	String download_user_id;
	String download_user_name;
	java.util.Date download_dat;
	String download_dat_chinese_print;
	public String getLast_audit_dat_chinese_print() {
		return last_audit_dat_chinese_print;
	}
	public void setLast_audit_dat_chinese_print(String last_audit_dat_chinese_print) {
		this.last_audit_dat_chinese_print = last_audit_dat_chinese_print;
	}
	public String getLast_modify_dat_chinese_print() {
		return last_modify_dat_chinese_print;
	}
	public void setLast_modify_dat_chinese_print(String last_modify_dat_chinese_print) {
		this.last_modify_dat_chinese_print = last_modify_dat_chinese_print;
	}

	public String getDownload_dat_chinese_print() {
		return download_dat_chinese_print;
	}
	public void setDownload_dat_chinese_print(String download_dat_chinese_print) {
		this.download_dat_chinese_print = download_dat_chinese_print;
	}

	String download_uuid;
	public String getCreate_user_id() {
		return create_user_id;
	}
	public void setCreate_user_id(String create_user_id) {
		this.create_user_id = create_user_id;
	}
	public String getCreate_user_name() {
		return create_user_name;
	}
	public void setCreate_user_name(String create_user_name) {
		this.create_user_name = create_user_name;
	}
	public java.util.Date getCreate_dat() {
		return create_dat;
	}
	public void setCreate_dat(java.util.Date create_dat) {
		this.create_dat = create_dat;
	}
	public String getBill_status() {
		return bill_status;
	}
	public void setBill_status(String bill_status) {
		this.bill_status = bill_status;
	}
	public String getContract_name() {
		return contract_name;
	}
	public void setContract_name(String contract_name) {
		this.contract_name = contract_name;
	}
	public String getContract_tell() {
		return contract_tell;
	}
	public void setContract_tell(String contract_tell) {
		this.contract_tell = contract_tell;
	}
	public String getContract_mail() {
		return contract_mail;
	}
	public void setContract_mail(String contract_mail) {
		this.contract_mail = contract_mail;
	}
	public String getAudit_user_id() {
		return audit_user_id;
	}
	public void setAudit_user_id(String audit_user_id) {
		this.audit_user_id = audit_user_id;
	}
	public String getAudit_user_name() {
		return audit_user_name;
	}
	public void setAudit_user_name(String audit_user_name) {
		this.audit_user_name = audit_user_name;
	}
	public java.util.Date getLast_audit_dat() {
		return last_audit_dat;
	}
	public void setLast_audit_dat(java.util.Date last_audit_dat) {
		this.last_audit_dat = last_audit_dat;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getBill_uuid() {
		return bill_uuid;
	}
	public void setBill_uuid(String bill_uuid) {
		this.bill_uuid = bill_uuid;
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
	public java.util.Date getLast_modify_dat() {
		return last_modify_dat;
	}
	public void setLast_modify_dat(java.util.Date last_modify_dat) {
		this.last_modify_dat = last_modify_dat;
	}
	public String getSearch_reason() {
		return search_reason;
	}
	public void setSearch_reason(String search_reason) {
		this.search_reason = search_reason;
	}
	public String getDownload_user_id() {
		return download_user_id;
	}
	public void setDownload_user_id(String download_user_id) {
		this.download_user_id = download_user_id;
	}
	public String getDownload_user_name() {
		return download_user_name;
	}
	public void setDownload_user_name(String download_user_name) {
		this.download_user_name = download_user_name;
	}
	public java.util.Date getDownload_dat() {
		return download_dat;
	}
	public void setDownload_dat(java.util.Date download_dat) {
		this.download_dat = download_dat;
	}
	public String getDownload_uuid() {
		return download_uuid;
	}
	public void setDownload_uuid(String download_uuid) {
		this.download_uuid = download_uuid;
	}

}
