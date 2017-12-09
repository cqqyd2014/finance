package gov.cqaudit.finance.bills.model;

public class BillD {
	String detail_uuid;
	public String getDetail_uuid() {
		return detail_uuid;
	}

	public void setDetail_uuid(String detail_uuid) {
		this.detail_uuid = detail_uuid;
	}

	String bill_uuid;

	public String getBill_uuid() {
		return bill_uuid;
	}

	public void setBill_uuid(String bill_uuid) {
		this.bill_uuid = bill_uuid;
	}

	String bank_code;
	String bank_name;
	String business_code;
	String business_code_name;

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBusiness_code_name() {
		return business_code_name;
	}

	public void setBusiness_code_name(String business_code_name) {
		this.business_code_name = business_code_name;
	}

	public String getSearch_par_code_name() {
		return search_par_code_name;
	}

	public void setSearch_par_code_name(String search_par_code_name) {
		this.search_par_code_name = search_par_code_name;
	}

	public String getBank_code() {
		return bank_code;
	}

	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}

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

	public String getSearch_par_value() {
		return search_par_value;
	}

	public void setSearch_par_value(String search_par_value) {
		this.search_par_value = search_par_value;
	}

	String search_par_code;
	String search_par_code_name;
	String search_par_value;
}
