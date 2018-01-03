package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-3 12:12:28 by Hibernate Tools 5.2.3.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	private Boolean effective;
	private Date unEffectiveDat;
	private String unEffectiveUserid;
	private String createUserid;
	private Date createDat;

	public BillD() {
	}

	public BillD(BillDId id) {
		this.id = id;
	}

	public BillD(BillDId id, String bankCode, String businessCode, String searchParCode, String searchParValue,
			Boolean effective, Date unEffectiveDat, String unEffectiveUserid, String createUserid, Date createDat) {
		this.id = id;
		this.bankCode = bankCode;
		this.businessCode = businessCode;
		this.searchParCode = searchParCode;
		this.searchParValue = searchParValue;
		this.effective = effective;
		this.unEffectiveDat = unEffectiveDat;
		this.unEffectiveUserid = unEffectiveUserid;
		this.createUserid = createUserid;
		this.createDat = createDat;
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

	@Column(name = "effective")
	public Boolean getEffective() {
		return this.effective;
	}

	public void setEffective(Boolean effective) {
		this.effective = effective;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "un_effective_dat", length = 35)
	public Date getUnEffectiveDat() {
		return this.unEffectiveDat;
	}

	public void setUnEffectiveDat(Date unEffectiveDat) {
		this.unEffectiveDat = unEffectiveDat;
	}

	@Column(name = "un_effective_userid", length = 36)
	public String getUnEffectiveUserid() {
		return this.unEffectiveUserid;
	}

	public void setUnEffectiveUserid(String unEffectiveUserid) {
		this.unEffectiveUserid = unEffectiveUserid;
	}

	@Column(name = "create_userid", length = 36)
	public String getCreateUserid() {
		return this.createUserid;
	}

	public void setCreateUserid(String createUserid) {
		this.createUserid = createUserid;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_dat", length = 35)
	public Date getCreateDat() {
		return this.createDat;
	}

	public void setCreateDat(Date createDat) {
		this.createDat = createDat;
	}

}
