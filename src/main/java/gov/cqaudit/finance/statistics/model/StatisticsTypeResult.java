package gov.cqaudit.finance.statistics.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class StatisticsTypeResult {
	long dept_count;

	public StatisticsTypeResult(long dept_count, String dept_type, String type_name,
			BigDecimal public_account_count, BigDecimal private_account_count, BigDecimal public_detail_count,
			BigDecimal private_detail_count) {
		super();
		this.dept_count = dept_count;
		this.dept_type = dept_type;
		this.type_name = type_name;
		this.public_account_count = public_account_count;
		this.private_account_count = private_account_count;
		this.public_detail_count = public_detail_count;
		this.private_detail_count = private_detail_count;
	}
	public long getDept_count() {
		return dept_count;
	}
	public void setDept_count(long dept_count) {
		this.dept_count = dept_count;
	}
	String dept_type;
	String type_name;
	java.math.BigDecimal public_account_count;
	java.math.BigDecimal private_account_count;
	java.math.BigDecimal public_detail_count;
	java.math.BigDecimal private_detail_count;
	public String getDept_type() {
		return dept_type;
	}
	public void setDept_type(String dept_type) {
		this.dept_type = dept_type;
	}
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
