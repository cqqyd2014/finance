package gov.cqaudit.finance.bills.model;

public class BillD {
	java.util.Date start_dat;
	java.util.Date end_dat;
	String start_dat_print;
	String end_dat_print;
	
	public java.util.Date getStart_dat() {
		return start_dat;
	}

	public void setStart_dat(java.util.Date start_dat) {
		this.start_dat = start_dat;
	}

	public java.util.Date getEnd_dat() {
		return end_dat;
	}

	public void setEnd_dat(java.util.Date end_dat) {
		this.end_dat = end_dat;
	}

	public String getStart_dat_print() {
		return start_dat_print;
	}

	public void setStart_dat_print(String start_dat_print) {
		this.start_dat_print = start_dat_print;
	}

	public String getEnd_dat_print() {
		return end_dat_print;
	}

	public void setEnd_dat_print(String end_dat_print) {
		this.end_dat_print = end_dat_print;
	}

	boolean effective;
	String un_effective_userid;
	java.util.Date un_effective_dat;
	String create_userid;
	public boolean isEffective() {
		return effective;
	}

	public void setEffective(boolean effective) {
		this.effective = effective;
	}

	public String getUn_effective_userid() {
		return un_effective_userid;
	}

	public void setUn_effective_userid(String un_effective_userid) {
		this.un_effective_userid = un_effective_userid;
	}

	public java.util.Date getUn_effective_dat() {
		return un_effective_dat;
	}

	public void setUn_effective_dat(java.util.Date un_effective_dat) {
		this.un_effective_dat = un_effective_dat;
	}

	public String getCreate_userid() {
		return create_userid;
	}

	public void setCreate_userid(String create_userid) {
		this.create_userid = create_userid;
	}

	public java.util.Date getCreate_dat() {
		return create_dat;
	}

	public void setCreate_dat(java.util.Date create_dat) {
		this.create_dat = create_dat;
	}

	java.util.Date create_dat;
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
