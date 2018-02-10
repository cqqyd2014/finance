package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-2-9 12:39:57 by Hibernate Tools 5.2.3.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VBillDId generated by hbm2java
 */
@Embeddable
public class VBillDId implements java.io.Serializable {

	private Date startDat;
	private Date endDat;
	private Boolean effective;
	private Date unEffectiveDat;
	private String unEffectiveUserid;
	private Date createDat;
	private String createUserid;
	private String billUuid;
	private String detailUuid;
	private String bankCode;
	private String businessCode;
	private String searchParCode;
	private String searchParValue;
	private String bankName;
	private String businessName;
	private String searchParName;

	public VBillDId() {
	}

	public VBillDId(Date startDat, Date endDat, Boolean effective, Date unEffectiveDat, String unEffectiveUserid,
			Date createDat, String createUserid, String billUuid, String detailUuid, String bankCode,
			String businessCode, String searchParCode, String searchParValue, String bankName, String businessName,
			String searchParName) {
		this.startDat = startDat;
		this.endDat = endDat;
		this.effective = effective;
		this.unEffectiveDat = unEffectiveDat;
		this.unEffectiveUserid = unEffectiveUserid;
		this.createDat = createDat;
		this.createUserid = createUserid;
		this.billUuid = billUuid;
		this.detailUuid = detailUuid;
		this.bankCode = bankCode;
		this.businessCode = businessCode;
		this.searchParCode = searchParCode;
		this.searchParValue = searchParValue;
		this.bankName = bankName;
		this.businessName = businessName;
		this.searchParName = searchParName;
	}

	@Column(name = "start_dat", length = 35)
	public Date getStartDat() {
		return this.startDat;
	}

	public void setStartDat(Date startDat) {
		this.startDat = startDat;
	}

	@Column(name = "end_dat", length = 35)
	public Date getEndDat() {
		return this.endDat;
	}

	public void setEndDat(Date endDat) {
		this.endDat = endDat;
	}

	@Column(name = "effective")
	public Boolean getEffective() {
		return this.effective;
	}

	public void setEffective(Boolean effective) {
		this.effective = effective;
	}

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

	@Column(name = "create_dat", length = 35)
	public Date getCreateDat() {
		return this.createDat;
	}

	public void setCreateDat(Date createDat) {
		this.createDat = createDat;
	}

	@Column(name = "create_userid", length = 36)
	public String getCreateUserid() {
		return this.createUserid;
	}

	public void setCreateUserid(String createUserid) {
		this.createUserid = createUserid;
	}

	@Column(name = "bill_uuid", length = 36)
	public String getBillUuid() {
		return this.billUuid;
	}

	public void setBillUuid(String billUuid) {
		this.billUuid = billUuid;
	}

	@Column(name = "detail_uuid", length = 36)
	public String getDetailUuid() {
		return this.detailUuid;
	}

	public void setDetailUuid(String detailUuid) {
		this.detailUuid = detailUuid;
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

	@Column(name = "bank_name", length = 64)
	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Column(name = "business_name", length = 90)
	public String getBusinessName() {
		return this.businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	@Column(name = "search_par_name", length = 90)
	public String getSearchParName() {
		return this.searchParName;
	}

	public void setSearchParName(String searchParName) {
		this.searchParName = searchParName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VBillDId))
			return false;
		VBillDId castOther = (VBillDId) other;

		return ((this.getStartDat() == castOther.getStartDat()) || (this.getStartDat() != null
				&& castOther.getStartDat() != null && this.getStartDat().equals(castOther.getStartDat())))
				&& ((this.getEndDat() == castOther.getEndDat()) || (this.getEndDat() != null
						&& castOther.getEndDat() != null && this.getEndDat().equals(castOther.getEndDat())))
				&& ((this.getEffective() == castOther.getEffective()) || (this.getEffective() != null
						&& castOther.getEffective() != null && this.getEffective().equals(castOther.getEffective())))
				&& ((this.getUnEffectiveDat() == castOther.getUnEffectiveDat())
						|| (this.getUnEffectiveDat() != null && castOther.getUnEffectiveDat() != null
								&& this.getUnEffectiveDat().equals(castOther.getUnEffectiveDat())))
				&& ((this.getUnEffectiveUserid() == castOther.getUnEffectiveUserid())
						|| (this.getUnEffectiveUserid() != null && castOther.getUnEffectiveUserid() != null
								&& this.getUnEffectiveUserid().equals(castOther.getUnEffectiveUserid())))
				&& ((this.getCreateDat() == castOther.getCreateDat()) || (this.getCreateDat() != null
						&& castOther.getCreateDat() != null && this.getCreateDat().equals(castOther.getCreateDat())))
				&& ((this.getCreateUserid() == castOther.getCreateUserid())
						|| (this.getCreateUserid() != null && castOther.getCreateUserid() != null
								&& this.getCreateUserid().equals(castOther.getCreateUserid())))
				&& ((this.getBillUuid() == castOther.getBillUuid()) || (this.getBillUuid() != null
						&& castOther.getBillUuid() != null && this.getBillUuid().equals(castOther.getBillUuid())))
				&& ((this.getDetailUuid() == castOther.getDetailUuid()) || (this.getDetailUuid() != null
						&& castOther.getDetailUuid() != null && this.getDetailUuid().equals(castOther.getDetailUuid())))
				&& ((this.getBankCode() == castOther.getBankCode()) || (this.getBankCode() != null
						&& castOther.getBankCode() != null && this.getBankCode().equals(castOther.getBankCode())))
				&& ((this.getBusinessCode() == castOther.getBusinessCode())
						|| (this.getBusinessCode() != null && castOther.getBusinessCode() != null
								&& this.getBusinessCode().equals(castOther.getBusinessCode())))
				&& ((this.getSearchParCode() == castOther.getSearchParCode())
						|| (this.getSearchParCode() != null && castOther.getSearchParCode() != null
								&& this.getSearchParCode().equals(castOther.getSearchParCode())))
				&& ((this.getSearchParValue() == castOther.getSearchParValue())
						|| (this.getSearchParValue() != null && castOther.getSearchParValue() != null
								&& this.getSearchParValue().equals(castOther.getSearchParValue())))
				&& ((this.getBankName() == castOther.getBankName()) || (this.getBankName() != null
						&& castOther.getBankName() != null && this.getBankName().equals(castOther.getBankName())))
				&& ((this.getBusinessName() == castOther.getBusinessName())
						|| (this.getBusinessName() != null && castOther.getBusinessName() != null
								&& this.getBusinessName().equals(castOther.getBusinessName())))
				&& ((this.getSearchParName() == castOther.getSearchParName())
						|| (this.getSearchParName() != null && castOther.getSearchParName() != null
								&& this.getSearchParName().equals(castOther.getSearchParName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getStartDat() == null ? 0 : this.getStartDat().hashCode());
		result = 37 * result + (getEndDat() == null ? 0 : this.getEndDat().hashCode());
		result = 37 * result + (getEffective() == null ? 0 : this.getEffective().hashCode());
		result = 37 * result + (getUnEffectiveDat() == null ? 0 : this.getUnEffectiveDat().hashCode());
		result = 37 * result + (getUnEffectiveUserid() == null ? 0 : this.getUnEffectiveUserid().hashCode());
		result = 37 * result + (getCreateDat() == null ? 0 : this.getCreateDat().hashCode());
		result = 37 * result + (getCreateUserid() == null ? 0 : this.getCreateUserid().hashCode());
		result = 37 * result + (getBillUuid() == null ? 0 : this.getBillUuid().hashCode());
		result = 37 * result + (getDetailUuid() == null ? 0 : this.getDetailUuid().hashCode());
		result = 37 * result + (getBankCode() == null ? 0 : this.getBankCode().hashCode());
		result = 37 * result + (getBusinessCode() == null ? 0 : this.getBusinessCode().hashCode());
		result = 37 * result + (getSearchParCode() == null ? 0 : this.getSearchParCode().hashCode());
		result = 37 * result + (getSearchParValue() == null ? 0 : this.getSearchParValue().hashCode());
		result = 37 * result + (getBankName() == null ? 0 : this.getBankName().hashCode());
		result = 37 * result + (getBusinessName() == null ? 0 : this.getBusinessName().hashCode());
		result = 37 * result + (getSearchParName() == null ? 0 : this.getSearchParName().hashCode());
		return result;
	}

}
