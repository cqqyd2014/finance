package gov.cqaudit.finance.hibernate.entites;
// Generated 2017-12-9 9:31:50 by Hibernate Tools 5.2.6.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * BillD generated by hbm2java
 */
@Entity
@Table(name = "bill_d", schema = "public")
public class BillD implements java.io.Serializable {

	private BillDId id;
	private String bankCode;
	private String businessCode;
	private String searchParCode;
	private String searchParValue;

	public BillD() {
	}

	public BillD(BillDId id) {
		this.id = id;
	}

	public BillD(BillDId id, String bankCode, String businessCode, String searchParCode, String searchParValue) {
		this.id = id;
		this.bankCode = bankCode;
		this.businessCode = businessCode;
		this.searchParCode = searchParCode;
		this.searchParValue = searchParValue;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "billUuid", column = @Column(name = "bill_uuid", nullable = false, length = 36)),
			@AttributeOverride(name = "detailUuid", column = @Column(name = "detail_uuid", nullable = false, length = 36)) })
	public BillDId getId() {
		return this.id;
	}

	public void setId(BillDId id) {
		this.id = id;
	}

	@Column(name = "bank_code", length = 4)
	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	@Column(name = "business_code", length = 4)
	public String getBusinessCode() {
		return this.businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	@Column(name = "search_par_code", length = 4)
	public String getSearchParCode() {
		return this.searchParCode;
	}

	public void setSearchParCode(String searchParCode) {
		this.searchParCode = searchParCode;
	}

	@Column(name = "search_par_value", length = 1024)
	public String getSearchParValue() {
		return this.searchParValue;
	}

	public void setSearchParValue(String searchParValue) {
		this.searchParValue = searchParValue;
	}

}
