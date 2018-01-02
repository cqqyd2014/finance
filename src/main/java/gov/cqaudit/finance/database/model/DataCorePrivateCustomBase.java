package gov.cqaudit.finance.database.model;

import gov.cqaudit.finance.annotation.Export;

public class DataCorePrivateCustomBase {
	String bank_code;
	@Export(name="客户号",export_order=0)
	String private_custom_id;
	@Export(name="客户姓名",export_order=1)
	String private_custom_name;
	@Export(name="工作单位",export_order=2)
	String private_company;
	@Export(name="通信地址",export_order=3)
	String private_post_address;
	@Export(name="单位地址",export_order=4)
	String private_work_address;
	@Export(name="身份证号",export_order=5)
	String private_id_card;
	public String getBank_code() {
		return bank_code;
	}
	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}
	public String getPrivate_custom_id() {
		return private_custom_id;
	}
	public void setPrivate_custom_id(String private_custom_id) {
		this.private_custom_id = private_custom_id;
	}
	public String getPrivate_custom_name() {
		return private_custom_name;
	}
	public void setPrivate_custom_name(String private_custom_name) {
		this.private_custom_name = private_custom_name;
	}
	public String getPrivate_company() {
		return private_company;
	}
	public void setPrivate_company(String private_company) {
		this.private_company = private_company;
	}
	public String getPrivate_post_address() {
		return private_post_address;
	}
	public void setPrivate_post_address(String private_post_address) {
		this.private_post_address = private_post_address;
	}
	public String getPrivate_work_address() {
		return private_work_address;
	}
	public void setPrivate_work_address(String private_work_address) {
		this.private_work_address = private_work_address;
	}
	public String getPrivate_id_card() {
		return private_id_card;
	}
	public void setPrivate_id_card(String private_id_card) {
		this.private_id_card = private_id_card;
	}

}
