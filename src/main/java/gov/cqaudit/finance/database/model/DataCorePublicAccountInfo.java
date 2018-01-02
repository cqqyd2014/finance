package gov.cqaudit.finance.database.model;

import gov.cqaudit.finance.annotation.Export;

public class DataCorePublicAccountInfo {
	String bank_code;
	@Export(name="账号",export_order=0)
	String public_account_id;
	@Export(name="账户名称",export_order=1)
	String public_account_name;
	@Export(name="账户状态",export_order=2)
	String public_account_stauts;
	java.util.Date public_open_dat;
	@Export(name="开户日期",export_order=4)
	String public_open_dat_print;
	String public_open_dat_chinese_print;
	public String getPublic_open_dat_print() {
		return public_open_dat_print;
	}
	public void setPublic_open_dat_print(String public_open_dat_print) {
		this.public_open_dat_print = public_open_dat_print;
	}
	public String getPublic_open_dat_chinese_print() {
		return public_open_dat_chinese_print;
	}
	public void setPublic_open_dat_chinese_print(String public_open_dat_chinese_print) {
		this.public_open_dat_chinese_print = public_open_dat_chinese_print;
	}
	java.util.Date public_close_dat;
	@Export(name="销户日期",export_order=5)
	String public_close_dat_print;
	String public_close_dat_chinese_print;
	public String getPublic_close_dat_print() {
		return public_close_dat_print;
	}
	public void setPublic_close_dat_print(String public_close_dat_print) {
		this.public_close_dat_print = public_close_dat_print;
	}
	public String getPublic_close_dat_chinese_print() {
		return public_close_dat_chinese_print;
	}
	public void setPublic_close_dat_chinese_print(String public_close_dat_chinese_print) {
		this.public_close_dat_chinese_print = public_close_dat_chinese_print;
	}
	@Export(name="客户号",export_order=3)
	String public_custom_id;
	public String getBank_code() {
		return bank_code;
	}
	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}
	public String getPublic_account_id() {
		return public_account_id;
	}
	public void setPublic_account_id(String public_account_id) {
		this.public_account_id = public_account_id;
	}
	public String getPublic_account_name() {
		return public_account_name;
	}
	public void setPublic_account_name(String public_account_name) {
		this.public_account_name = public_account_name;
	}
	public String getPublic_account_stauts() {
		return public_account_stauts;
	}
	public void setPublic_account_stauts(String public_account_stauts) {
		this.public_account_stauts = public_account_stauts;
	}
	public java.util.Date getPublic_open_dat() {
		return public_open_dat;
	}
	public void setPublic_open_dat(java.util.Date public_open_dat) {
		this.public_open_dat = public_open_dat;
	}
	public java.util.Date getPublic_close_dat() {
		return public_close_dat;
	}
	public void setPublic_close_dat(java.util.Date public_close_dat) {
		this.public_close_dat = public_close_dat;
	}
	public String getPublic_custom_id() {
		return public_custom_id;
	}
	public void setPublic_custom_id(String public_custom_id) {
		this.public_custom_id = public_custom_id;
	}
}
