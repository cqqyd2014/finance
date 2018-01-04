package gov.cqaudit.finance.statistics.model;

public class StatisticsBillsResult {
	String pro_name;
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	String dept_name;
	String dept_uuid;
	String dept_type_name;
	String dept_type_code;
	java.util.Date create_date;
	String create_date_print;
	String create_date_chinese_print;
	String bill_uuid;
	java.math.BigDecimal public_account_count;
	java.math.BigDecimal private_account_count;
	java.math.BigDecimal public_detail_count;
	java.math.BigDecimal private_detail_count;
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public String getDept_uuid() {
		return dept_uuid;
	}
	public void setDept_uuid(String dept_uuid) {
		this.dept_uuid = dept_uuid;
	}
	public String getDept_type_name() {
		return dept_type_name;
	}
	public void setDept_type_name(String dept_type_name) {
		this.dept_type_name = dept_type_name;
	}
	public String getDept_type_code() {
		return dept_type_code;
	}
	public void setDept_type_code(String dept_type_code) {
		this.dept_type_code = dept_type_code;
	}
	public java.util.Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(java.util.Date create_date) {
		this.create_date = create_date;
	}
	public String getCreate_date_print() {
		return create_date_print;
	}
	public void setCreate_date_print(String create_date_print) {
		this.create_date_print = create_date_print;
	}
	public String getCreate_date_chinese_print() {
		return create_date_chinese_print;
	}
	public void setCreate_date_chinese_print(String create_date_chinese_print) {
		this.create_date_chinese_print = create_date_chinese_print;
	}
	public String getBill_uuid() {
		return bill_uuid;
	}
	public void setBill_uuid(String bill_uuid) {
		this.bill_uuid = bill_uuid;
	}
	public java.math.BigDecimal getPublic_account_count() {
		return public_account_count;
	}
	public void setPublic_account_count(java.math.BigDecimal public_account_count) {
		this.public_account_count = public_account_count;
	}
	public java.math.BigDecimal getPrivate_account_count() {
		return private_account_count;
	}
	public void setPrivate_account_count(java.math.BigDecimal private_account_count) {
		this.private_account_count = private_account_count;
	}
	public java.math.BigDecimal getPublic_detail_count() {
		return public_detail_count;
	}
	public void setPublic_detail_count(java.math.BigDecimal public_detail_count) {
		this.public_detail_count = public_detail_count;
	}
	public java.math.BigDecimal getPrivate_detail_count() {
		return private_detail_count;
	}
	public void setPrivate_detail_count(java.math.BigDecimal private_detail_count) {
		this.private_detail_count = private_detail_count;
	}

}
