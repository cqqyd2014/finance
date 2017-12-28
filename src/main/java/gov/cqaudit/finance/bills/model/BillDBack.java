package gov.cqaudit.finance.bills.model;

public final class BillDBack {
	String bill_uuid;
	String bill_d_uuid;
	String business_name;
	String search_par_name;
	String search_value;
	String account_id;
	java.math.BigDecimal rows_count;
	public String getBill_uuid() {
		return bill_uuid;
	}
	public void setBill_uuid(String bill_uuid) {
		this.bill_uuid = bill_uuid;
	}
	public String getBill_d_uuid() {
		return bill_d_uuid;
	}
	public void setBill_d_uuid(String bill_d_uuid) {
		this.bill_d_uuid = bill_d_uuid;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getSearch_par_name() {
		return search_par_name;
	}
	public void setSearch_par_name(String search_par_name) {
		this.search_par_name = search_par_name;
	}
	public String getSearch_value() {
		return search_value;
	}
	public void setSearch_value(String search_value) {
		this.search_value = search_value;
	}
	public String getAccount_id() {
		return account_id;
	}
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	public java.math.BigDecimal getRows_count() {
		return rows_count;
	}
	public void setRows_count(java.math.BigDecimal rows_count) {
		this.rows_count = rows_count;
	}
	

}
