package gov.cqaudit.finance.database.model;

import org.apache.poi.xssf.usermodel.XSSFCell;

import gov.cqaudit.finance.annotation.Export;

public class DataCorePublicAccountTradeDetail {
	@Export(name="户名",export_order=1)
	String public_account_name;
	@Export(if_export=false,name="银行编码")
	String bank_code;
	@Export(name="银行名称",export_order=13)
	String bank_name;
	@Export(name="账号",export_order=0)
	String public_account_id;
	String public_trade_seq;
	@Export(name="交易金额",xlsxtype=XSSFCell.CELL_TYPE_NUMERIC,export_order=3)
	java.math.BigDecimal public_amount;
	@Export(name="对方账号",export_order=5)
	String public_op_account_id;
	@Export(name="对方行号",export_order=7)
	String public_op_bank_id;
	@Export(name="对方行名",export_order=8)
	String public_op_bank_name;
	@Export(name="对方户名",export_order=6)
	String public_op_account_name;
	@Export(name="交易码",export_order=9)
	String public_trade_code;
	@Export(name="交易码名",export_order=10)
	String public_trade_name;
	@Export(name="余额",xlsxtype=XSSFCell.CELL_TYPE_NUMERIC,export_order=4)
	java.math.BigDecimal public_balance;
	@Export(name="交易机构号",export_order=11)
	String public_bank_org_id;
	@Export(name="交易机构名",export_order=12)
	String public_bank_org_name;
	@Export(name="备注",export_order=14)
	String public_remark;
	@Export(if_export=false,name="交易日期")
	java.util.Date public_trade_dat;
	@Export(name="交易日期",if_database=false,export_order=2)
	String public_trade_dat_print;
	@Export(if_export=false,name="交易日期",if_database=false)
	String public_trade_dat_chinese_print;
	public String getPublic_account_name() {
		return public_account_name;
	}
	public void setPublic_account_name(String public_account_name) {
		this.public_account_name = public_account_name;
	}
	public String getBank_code() {
		return bank_code;
	}
	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getPublic_account_id() {
		return public_account_id;
	}
	public void setPublic_account_id(String public_account_id) {
		this.public_account_id = public_account_id;
	}
	public String getPublic_trade_seq() {
		return public_trade_seq;
	}
	public void setPublic_trade_seq(String public_trade_seq) {
		this.public_trade_seq = public_trade_seq;
	}
	public java.math.BigDecimal getPublic_amount() {
		return public_amount;
	}
	public void setPublic_amount(java.math.BigDecimal public_amount) {
		this.public_amount = public_amount;
	}
	public String getPublic_op_account_id() {
		return public_op_account_id;
	}
	public void setPublic_op_account_id(String public_op_account_id) {
		this.public_op_account_id = public_op_account_id;
	}
	public String getPublic_op_bank_id() {
		return public_op_bank_id;
	}
	public void setPublic_op_bank_id(String public_op_bank_id) {
		this.public_op_bank_id = public_op_bank_id;
	}
	public String getPublic_op_bank_name() {
		return public_op_bank_name;
	}
	public void setPublic_op_bank_name(String public_op_bank_name) {
		this.public_op_bank_name = public_op_bank_name;
	}
	public String getPublic_op_account_name() {
		return public_op_account_name;
	}
	public void setPublic_op_account_name(String public_op_account_name) {
		this.public_op_account_name = public_op_account_name;
	}
	public String getPublic_trade_code() {
		return public_trade_code;
	}
	public void setPublic_trade_code(String public_trade_code) {
		this.public_trade_code = public_trade_code;
	}
	public String getPublic_trade_name() {
		return public_trade_name;
	}
	public void setPublic_trade_name(String public_trade_name) {
		this.public_trade_name = public_trade_name;
	}
	public java.math.BigDecimal getPublic_balance() {
		return public_balance;
	}
	public void setPublic_balance(java.math.BigDecimal public_balance) {
		this.public_balance = public_balance;
	}
	public String getPublic_bank_org_id() {
		return public_bank_org_id;
	}
	public void setPublic_bank_org_id(String public_bank_org_id) {
		this.public_bank_org_id = public_bank_org_id;
	}
	public String getPublic_bank_org_name() {
		return public_bank_org_name;
	}
	public void setPublic_bank_org_name(String public_bank_org_name) {
		this.public_bank_org_name = public_bank_org_name;
	}
	public String getPublic_remark() {
		return public_remark;
	}
	public void setPublic_remark(String public_remark) {
		this.public_remark = public_remark;
	}
	public java.util.Date getPublic_trade_dat() {
		return public_trade_dat;
	}
	public void setPublic_trade_dat(java.util.Date public_trade_dat) {
		this.public_trade_dat = public_trade_dat;
	}
	public String getPublic_trade_dat_print() {
		return public_trade_dat_print;
	}
	public void setPublic_trade_dat_print(String public_trade_dat_print) {
		this.public_trade_dat_print = public_trade_dat_print;
	}
	public String getPublic_trade_dat_chinese_print() {
		return public_trade_dat_chinese_print;
	}
	public void setPublic_trade_dat_chinese_print(String public_trade_dat_chinese_print) {
		this.public_trade_dat_chinese_print = public_trade_dat_chinese_print;
	}
}
