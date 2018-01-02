package gov.cqaudit.finance.database.model;

import org.apache.poi.xssf.usermodel.XSSFCell;



import gov.cqaudit.finance.annotation.Export;

public class DataCorePrivateAccountTradeDetail {
	@Export(name="户名",export_order=1)
	String private_account_name;
	public String getPrivate_account_name() {
		return private_account_name;
	}
	public void setPrivate_account_name(String private_account_name) {
		this.private_account_name = private_account_name;
	}
	
	@Export(if_export=false,name="银行编码")
	String bank_code;
	@Export(name="银行名称",export_order=13)
	String bank_name;
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	@Export(name="账号",export_order=0)
	String private_account_id;
	String private_trade_seq;
	@Export(name="交易金额",xlsxtype=XSSFCell.CELL_TYPE_NUMERIC,export_order=3)
	java.math.BigDecimal private_amount;
	@Export(name="对方账号",export_order=5)
	String private_op_account_id;
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
	public String getPrivate_trade_seq() {
		return private_trade_seq;
	}
	public void setPrivate_trade_seq(String private_trade_seq) {
		this.private_trade_seq = private_trade_seq;
	}

	public java.math.BigDecimal getPrivate_amount() {
		return private_amount;
	}
	public void setPrivate_amount(java.math.BigDecimal private_amount) {
		this.private_amount = private_amount;
	}
	public String getPrivate_op_account_id() {
		return private_op_account_id;
	}
	public void setPrivate_op_account_id(String private_op_account_id) {
		this.private_op_account_id = private_op_account_id;
	}
	public String getPrivate_op_bank_id() {
		return private_op_bank_id;
	}
	public void setPrivate_op_bank_id(String private_op_bank_id) {
		this.private_op_bank_id = private_op_bank_id;
	}
	public String getPrivate_op_bank_name() {
		return private_op_bank_name;
	}
	public void setPrivate_op_bank_name(String private_op_bank_name) {
		this.private_op_bank_name = private_op_bank_name;
	}
	public String getPrivate_op_account_name() {
		return private_op_account_name;
	}
	public void setPrivate_op_account_name(String private_op_account_name) {
		this.private_op_account_name = private_op_account_name;
	}


	public String getPrivate_trade_code() {
		return private_trade_code;
	}
	public void setPrivate_trade_code(String private_trade_code) {
		this.private_trade_code = private_trade_code;
	}
	public String getPrivate_trade_name() {
		return private_trade_name;
	}
	public void setPrivate_trade_name(String private_trade_name) {
		this.private_trade_name = private_trade_name;
	}
	public java.math.BigDecimal getPrivate_balance() {
		return private_balance;
	}
	public void setPrivate_balance(java.math.BigDecimal private_balance) {
		this.private_balance = private_balance;
	}
	public String getPrivate_bank_org_id() {
		return private_bank_org_id;
	}
	public void setPrivate_bank_org_id(String private_bank_org_id) {
		this.private_bank_org_id = private_bank_org_id;
	}
	public String getPrivate_bank_org_name() {
		return private_bank_org_name;
	}
	public void setPrivate_bank_org_name(String private_bank_org_name) {
		this.private_bank_org_name = private_bank_org_name;
	}
	public String getPrivate_remark() {
		return private_remark;
	}
	public void setPrivate_remark(String private_remark) {
		this.private_remark = private_remark;
	}
	@Export(name="对方行号",export_order=7)
	String private_op_bank_id;
	@Export(name="对方行名",export_order=8)
	String private_op_bank_name;
	@Export(name="对方户名",export_order=6)
	String private_op_account_name;
	@Export(name="交易码",export_order=9)
	String private_trade_code;
	@Export(name="交易码名",export_order=10)
	String private_trade_name;
	@Export(name="余额",xlsxtype=XSSFCell.CELL_TYPE_NUMERIC,export_order=4)
	java.math.BigDecimal private_balance;
	@Export(name="交易机构号",export_order=11)
	String private_bank_org_id;
	@Export(name="交易机构名",export_order=12)
	String private_bank_org_name;
	@Export(name="备注",export_order=14)
	String private_remark;
	@Export(if_export=false,name="交易日期")
	java.util.Date private_trade_dat;
	@Export(name="交易日期",if_database=false,export_order=2)
	String private_trade_dat_print;
	@Export(if_export=false,name="交易日期",if_database=false)
	String private_trade_dat_chinese_print;
	public java.util.Date getPrivate_trade_dat() {
		return private_trade_dat;
	}
	public void setPrivate_trade_dat(java.util.Date private_trade_dat) {
		this.private_trade_dat = private_trade_dat;
	}
	public String getPrivate_trade_dat_print() {
		return private_trade_dat_print;
	}
	public void setPrivate_trade_dat_print(String private_trade_dat_print) {
		this.private_trade_dat_print = private_trade_dat_print;
	}
	public String getPrivate_trade_dat_chinese_print() {
		return private_trade_dat_chinese_print;
	}
	public void setPrivate_trade_dat_chinese_print(String private_trade_dat_chinese_print) {
		this.private_trade_dat_chinese_print = private_trade_dat_chinese_print;
	}
}
