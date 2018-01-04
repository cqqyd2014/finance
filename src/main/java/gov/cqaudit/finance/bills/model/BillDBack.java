package gov.cqaudit.finance.bills.model;

public final class BillDBack {
	public String account_name;

	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
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
	String custom_id;
	public String getCustom_id() {
		return custom_id;
	}
	public void setCustom_id(String custom_id) {
		this.custom_id = custom_id;
	}
	String bill_uuid;
	String bill_d_uuid;
	String bank_code;
	String bank_name;
	String business_name;
	String business_code;
	String search_par_name;
	String search_par_code;
	public String getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}
	public String getSearch_par_code() {
		return search_par_code;
	}
	public void setSearch_par_code(String search_par_code) {
		this.search_par_code = search_par_code;
	}
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
