package gov.cqaudit.finance.statistics.model;

public class StatisticsTypeResultTotal {
	String type_name;
	java.math.BigDecimal dept_count;
	public java.math.BigDecimal getDept_count() {
		return dept_count;
	}
	public void setDept_count(java.math.BigDecimal dept_count) {
		this.dept_count = dept_count;
	}
	java.math.BigDecimal public_account_count;
	java.math.BigDecimal private_account_count;
	java.math.BigDecimal public_detail_count;
	java.math.BigDecimal private_detail_count;
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public java.math.BigDecimal getPublic_account_count() {
		return public_account_count;
	}
	public void setPublic_account_count(java.math.BigDecimal public_account_count) {
		this.public_account_count = public_account_count;
	}
	public java.math.BigDecimal getPrivate_account_count() {
		return private_account_count;
	}
	public void setPrivate_account_count(java.math.BigDecimal private_account_count) {
		this.private_account_count = private_account_count;
	}
	public java.math.BigDecimal getPublic_detail_count() {
		return public_detail_count;
	}
	public void setPublic_detail_count(java.math.BigDecimal public_detail_count) {
		this.public_detail_count = public_detail_count;
	}
	public java.math.BigDecimal getPrivate_detail_count() {
		return private_detail_count;
	}
	public void setPrivate_detail_count(java.math.BigDecimal private_detail_count) {
		this.private_detail_count = private_detail_count;
	}
}
