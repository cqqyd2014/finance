package gov.cqaudit.finance.database.model;

import gov.cqaudit.finance.annotation.Export;

public class DataCorePublicCustomBase {
	String bank_code;
	@Export(name="客户号",export_order=0)
	String public_custom_id;
	@Export(name="客户姓名",export_order=1)
	String public_custom_name;
	@Export(name="法人姓名",export_order=2)
	String public_law_man_name;
	@Export(name="法人证件号",export_order=3)
	String public_law_man_id_card;
	@Export(name="营业范围",export_order=4)
	String public_business;
	java.math.BigDecimal public_reg_capital;
	String public_id_card;
	public String getBank_code() {
		return bank_code;
	}
	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}
	public String getPublic_custom_id() {
		return public_custom_id;
	}
	public void setPublic_custom_id(String public_custom_id) {
		this.public_custom_id = public_custom_id;
	}
	public String getPublic_custom_name() {
		return public_custom_name;
	}
	public void setPublic_custom_name(String public_custom_name) {
		this.public_custom_name = public_custom_name;
	}

	public String getPublic_law_man_name() {
		return public_law_man_name;
	}
	public void setPublic_law_man_name(String public_law_man_name) {
		this.public_law_man_name = public_law_man_name;
	}
	public String getPublic_law_man_id_card() {
		return public_law_man_id_card;
	}
	public void setPublic_law_man_id_card(String public_law_man_id_card) {
		this.public_law_man_id_card = public_law_man_id_card;
	}
	public String getPublic_business() {
		return public_business;
	}
	public void setPublic_business(String public_business) {
		this.public_business = public_business;
	}
	public java.math.BigDecimal getPublic_reg_capital() {
		return public_reg_capital;
	}
	public void setPublic_reg_capital(java.math.BigDecimal public_reg_capital) {
		this.public_reg_capital = public_reg_capital;
	}
	public String getPublic_id_card() {
		return public_id_card;
	}
	public void setPublic_id_card(String public_id_card) {
		this.public_id_card = public_id_card;
	}
}
