package gov.cqaudit.finance.datatrans.model;

public class DataTransBack {
	String bank_code;
	String trans_uuid;
	String table_code;
	String table_name;
	java.math.BigDecimal rows_count;
	public String getBank_code() {
		return bank_code;
	}
	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}
	public String getTrans_uuid() {
		return trans_uuid;
	}
	public void setTrans_uuid(String trans_uuid) {
		this.trans_uuid = trans_uuid;
	}
	public String getTable_code() {
		return table_code;
	}
	public void setTable_code(String table_code) {
		this.table_code = table_code;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public java.math.BigDecimal getRows_count() {
		return rows_count;
	}
	public void setRows_count(java.math.BigDecimal rows_count) {
		this.rows_count = rows_count;
	}
}
