package gov.cqaudit.finance.database.model;

import gov.cqaudit.finance.annotation.Export;

public class DataCorePrivateAccountInfo {

	
	public String getPrivate_close_dat_print() {
		return private_close_dat_print;
	}
	public void setPrivate_close_dat_print(String private_close_dat_print) {
		this.private_close_dat_print = private_close_dat_print;
	}

	public String getPrivate_close_dat_chinese_print() {
		return private_close_dat_chinese_print;
	}
	public void setPrivate_close_dat_chinese_print(String private_close_dat_chinese_print) {
		this.private_close_dat_chinese_print = private_close_dat_chinese_print;
	}
	public String getPrivate_open_dat_print() {
		return private_open_dat_print;
	}
	public void setPrivate_open_dat_print(String private_open_dat_print) {
		this.private_open_dat_print = private_open_dat_print;
	}
	public String getPrivate_open_dat_chinese_print() {
		return private_open_dat_chinese_print;
	}
	public void setPrivate_open_dat_chinese_print(String private_open_dat_chinese_print) {
		this.private_open_dat_chinese_print = private_open_dat_chinese_print;
	}
	@Export(name="销户日期",export_order=6)
	String private_close_dat_print;
	String private_close_dat_chinese_print;
	@Export(name="开户日期",export_order=5)
	String private_open_dat_print;
	String private_open_dat_chinese_print;
	String bank_code;
	@Export(name="账号",export_order=0)
	String private_account_id;
	@Export(name="账号姓名",export_order=1)
	String private_account_name;
	@Export(name="账户状态",export_order=2)
	String private_account_stauts;
	java.util.Date private_open_dat;
	java.util.Date private_close_dat;
	@Export(name="客户号",export_order=3)
	String private_custom_id;
	@Export(name="卡号",export_order=4)
	String private_card_no;
	public String getBank_code() {
		return bank_code;
	}
	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}
	public String getPrivate_account_id() {
		return private_account_id;
	}
	public void setPrivate_account_id(String private_account_id) {
		this.private_account_id = private_account_id;
	}
	public String getPrivate_account_name() {
		return private_account_name;
	}
	public void setPrivate_account_name(String private_account_name) {
		this.private_account_name = private_account_name;
	}
	public String getPrivate_account_stauts() {
		return private_account_stauts;
	}
	public void setPrivate_account_stauts(String private_account_stauts) {
		this.private_account_stauts = private_account_stauts;
	}
	public java.util.Date getPrivate_open_dat() {
		return private_open_dat;
	}
	public void setPrivate_open_dat(java.util.Date private_open_dat) {
		this.private_open_dat = private_open_dat;
	}
	public java.util.Date getPrivate_close_dat() {
		return private_close_dat;
	}
	public void setPrivate_close_dat(java.util.Date private_close_dat) {
		this.private_close_dat = private_close_dat;
	}
	public String getPrivate_custom_id() {
		return private_custom_id;
	}
	public void setPrivate_custom_id(String private_custom_id) {
		this.private_custom_id = private_custom_id;
	}
	public String getPrivate_card_no() {
		return private_card_no;
	}
	public void setPrivate_card_no(String private_card_no) {
		this.private_card_no = private_card_no;
	}

}
