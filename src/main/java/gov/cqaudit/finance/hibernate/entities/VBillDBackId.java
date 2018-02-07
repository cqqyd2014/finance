package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-2-2 15:03:25 by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VBillDBackId generated by hbm2java
 */
@Embeddable
public class VBillDBackId implements java.io.Serializable {

	private Date startDat;
	private Date endDat;
	private String proName;
	private String deptId;
	private String bankName;
	private String searchParName;
	private String accountName;
	private String deptName;
	private String deptType;
	private String typeName;
	private String businessName;
	private Date downloadDat;
	private String billUuid;
	private String detailUuid;
	private String bankCode;
	private String businessCode;
	private String searchParCode;
	private String searchParValue;
	private Boolean effective;
	private Date unEffectiveDat;
	private String downloadUserName;
	private String unEffectiveUserid;
	private String createUserid;
	private Date billDCreateDat;
	private String accountId;
	private BigDecimal detailCount;
	private String customId;
	private Date billMCreateDat;
	private Integer publicCount;
	private Integer privateCount;
	private BigDecimal publicDetail;
	private BigDecimal privateDetail;
	private String createUserName;
	private String downloadUserId;

	public VBillDBackId() {
	}

	public VBillDBackId(Date startDat, Date endDat, String proName, String deptId, String bankName,
			String searchParName, String accountName, String deptName, String deptType, String typeName,
			String businessName, Date downloadDat, String billUuid, String detailUuid, String bankCode,
			String businessCode, String searchParCode, String searchParValue, Boolean effective, Date unEffectiveDat,
			String downloadUserName, String unEffectiveUserid, String createUserid, Date billDCreateDat,
			String accountId, BigDecimal detailCount, String customId, Date billMCreateDat, Integer publicCount,
			Integer privateCount, BigDecimal publicDetail, BigDecimal privateDetail, String createUserName,
			String downloadUserId) {
		this.startDat = startDat;
		this.endDat = endDat;
		this.proName = proName;
		this.deptId = deptId;
		this.bankName = bankName;
		this.searchParName = searchParName;
		this.accountName = accountName;
		this.deptName = deptName;
		this.deptType = deptType;
		this.typeName = typeName;
		this.businessName = businessName;
		this.downloadDat = downloadDat;
		this.billUuid = billUuid;
		this.detailUuid = detailUuid;
		this.bankCode = bankCode;
		this.businessCode = businessCode;
		this.searchParCode = searchParCode;
		this.searchParValue = searchParValue;
		this.effective = effective;
		this.unEffectiveDat = unEffectiveDat;
		this.downloadUserName = downloadUserName;
		this.unEffectiveUserid = unEffectiveUserid;
		this.createUserid = createUserid;
		this.billDCreateDat = billDCreateDat;
		this.accountId = accountId;
		this.detailCount = detailCount;
		this.customId = customId;
		this.billMCreateDat = billMCreateDat;
		this.publicCount = publicCount;
		this.privateCount = privateCount;
		this.publicDetail = publicDetail;
		this.privateDetail = privateDetail;
		this.createUserName = createUserName;
		this.downloadUserId = downloadUserId;
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

	@Column(name = "pro_name", length = 512)
	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	@Column(name = "dept_id", length = 36)
	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Column(name = "bank_name", length = 64)
	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Column(name = "search_par_name", length = 90)
	public String getSearchParName() {
		return this.searchParName;
	}

	public void setSearchParName(String searchParName) {
		this.searchParName = searchParName;
	}

	@Column(name = "account_name", length = 256)
	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Column(name = "dept_name", length = 128)
	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "dept_type", length = 4)
	public String getDeptType() {
		return this.deptType;
	}

	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}

	@Column(name = "type_name", length = 90)
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Column(name = "business_name", length = 90)
	public String getBusinessName() {
		return this.businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	@Column(name = "download_dat", length = 35)
	public Date getDownloadDat() {
		return this.downloadDat;
	}

	public void setDownloadDat(Date downloadDat) {
		this.downloadDat = downloadDat;
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

	@Column(name = "download_user_name", length = 45)
	public String getDownloadUserName() {
		return this.downloadUserName;
	}

	public void setDownloadUserName(String downloadUserName) {
		this.downloadUserName = downloadUserName;
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

	@Column(name = "bill_d_create_dat", length = 35)
	public Date getBillDCreateDat() {
		return this.billDCreateDat;
	}

	public void setBillDCreateDat(Date billDCreateDat) {
		this.billDCreateDat = billDCreateDat;
	}

	@Column(name = "account_id", length = 128)
	public String getAccountId() {
		return this.accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Column(name = "detail_count", precision = 131089, scale = 0)
	public BigDecimal getDetailCount() {
		return this.detailCount;
	}

	public void setDetailCount(BigDecimal detailCount) {
		this.detailCount = detailCount;
	}

	@Column(name = "custom_id", length = 128)
	public String getCustomId() {
		return this.customId;
	}

	public void setCustomId(String customId) {
		this.customId = customId;
	}

	@Column(name = "bill_m_create_dat", length = 35)
	public Date getBillMCreateDat() {
		return this.billMCreateDat;
	}

	public void setBillMCreateDat(Date billMCreateDat) {
		this.billMCreateDat = billMCreateDat;
	}

	@Column(name = "public_count")
	public Integer getPublicCount() {
		return this.publicCount;
	}

	public void setPublicCount(Integer publicCount) {
		this.publicCount = publicCount;
	}

	@Column(name = "private_count")
	public Integer getPrivateCount() {
		return this.privateCount;
	}

	public void setPrivateCount(Integer privateCount) {
		this.privateCount = privateCount;
	}

	@Column(name = "public_detail", precision = 131089, scale = 0)
	public BigDecimal getPublicDetail() {
		return this.publicDetail;
	}

	public void setPublicDetail(BigDecimal publicDetail) {
		this.publicDetail = publicDetail;
	}

	@Column(name = "private_detail", precision = 131089, scale = 0)
	public BigDecimal getPrivateDetail() {
		return this.privateDetail;
	}

	public void setPrivateDetail(BigDecimal privateDetail) {
		this.privateDetail = privateDetail;
	}

	@Column(name = "create_user_name", length = 45)
	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	@Column(name = "download_user_id", length = 36)
	public String getDownloadUserId() {
		return this.downloadUserId;
	}

	public void setDownloadUserId(String downloadUserId) {
		this.downloadUserId = downloadUserId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VBillDBackId))
			return false;
		VBillDBackId castOther = (VBillDBackId) other;

		return ((this.getStartDat() == castOther.getStartDat()) || (this.getStartDat() != null
				&& castOther.getStartDat() != null && this.getStartDat().equals(castOther.getStartDat())))
				&& ((this.getEndDat() == castOther.getEndDat()) || (this.getEndDat() != null
						&& castOther.getEndDat() != null && this.getEndDat().equals(castOther.getEndDat())))
				&& ((this.getProName() == castOther.getProName()) || (this.getProName() != null
						&& castOther.getProName() != null && this.getProName().equals(castOther.getProName())))
				&& ((this.getDeptId() == castOther.getDeptId()) || (this.getDeptId() != null
						&& castOther.getDeptId() != null && this.getDeptId().equals(castOther.getDeptId())))
				&& ((this.getBankName() == castOther.getBankName()) || (this.getBankName() != null
						&& castOther.getBankName() != null && this.getBankName().equals(castOther.getBankName())))
				&& ((this.getSearchParName() == castOther.getSearchParName())
						|| (this.getSearchParName() != null && castOther.getSearchParName() != null
								&& this.getSearchParName().equals(castOther.getSearchParName())))
				&& ((this.getAccountName() == castOther.getAccountName())
						|| (this.getAccountName() != null && castOther.getAccountName() != null
								&& this.getAccountName().equals(castOther.getAccountName())))
				&& ((this.getDeptName() == castOther.getDeptName()) || (this.getDeptName() != null
						&& castOther.getDeptName() != null && this.getDeptName().equals(castOther.getDeptName())))
				&& ((this.getDeptType() == castOther.getDeptType()) || (this.getDeptType() != null
						&& castOther.getDeptType() != null && this.getDeptType().equals(castOther.getDeptType())))
				&& ((this.getTypeName() == castOther.getTypeName()) || (this.getTypeName() != null
						&& castOther.getTypeName() != null && this.getTypeName().equals(castOther.getTypeName())))
				&& ((this.getBusinessName() == castOther.getBusinessName())
						|| (this.getBusinessName() != null && castOther.getBusinessName() != null
								&& this.getBusinessName().equals(castOther.getBusinessName())))
				&& ((this.getDownloadDat() == castOther.getDownloadDat())
						|| (this.getDownloadDat() != null && castOther.getDownloadDat() != null
								&& this.getDownloadDat().equals(castOther.getDownloadDat())))
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
				&& ((this.getEffective() == castOther.getEffective()) || (this.getEffective() != null
						&& castOther.getEffective() != null && this.getEffective().equals(castOther.getEffective())))
				&& ((this.getUnEffectiveDat() == castOther.getUnEffectiveDat())
						|| (this.getUnEffectiveDat() != null && castOther.getUnEffectiveDat() != null
								&& this.getUnEffectiveDat().equals(castOther.getUnEffectiveDat())))
				&& ((this.getDownloadUserName() == castOther.getDownloadUserName())
						|| (this.getDownloadUserName() != null && castOther.getDownloadUserName() != null
								&& this.getDownloadUserName().equals(castOther.getDownloadUserName())))
				&& ((this.getUnEffectiveUserid() == castOther.getUnEffectiveUserid())
						|| (this.getUnEffectiveUserid() != null && castOther.getUnEffectiveUserid() != null
								&& this.getUnEffectiveUserid().equals(castOther.getUnEffectiveUserid())))
				&& ((this.getCreateUserid() == castOther.getCreateUserid())
						|| (this.getCreateUserid() != null && castOther.getCreateUserid() != null
								&& this.getCreateUserid().equals(castOther.getCreateUserid())))
				&& ((this.getBillDCreateDat() == castOther.getBillDCreateDat())
						|| (this.getBillDCreateDat() != null && castOther.getBillDCreateDat() != null
								&& this.getBillDCreateDat().equals(castOther.getBillDCreateDat())))
				&& ((this.getAccountId() == castOther.getAccountId()) || (this.getAccountId() != null
						&& castOther.getAccountId() != null && this.getAccountId().equals(castOther.getAccountId())))
				&& ((this.getDetailCount() == castOther.getDetailCount())
						|| (this.getDetailCount() != null && castOther.getDetailCount() != null
								&& this.getDetailCount().equals(castOther.getDetailCount())))
				&& ((this.getCustomId() == castOther.getCustomId()) || (this.getCustomId() != null
						&& castOther.getCustomId() != null && this.getCustomId().equals(castOther.getCustomId())))
				&& ((this.getBillMCreateDat() == castOther.getBillMCreateDat())
						|| (this.getBillMCreateDat() != null && castOther.getBillMCreateDat() != null
								&& this.getBillMCreateDat().equals(castOther.getBillMCreateDat())))
				&& ((this.getPublicCount() == castOther.getPublicCount())
						|| (this.getPublicCount() != null && castOther.getPublicCount() != null
								&& this.getPublicCount().equals(castOther.getPublicCount())))
				&& ((this.getPrivateCount() == castOther.getPrivateCount())
						|| (this.getPrivateCount() != null && castOther.getPrivateCount() != null
								&& this.getPrivateCount().equals(castOther.getPrivateCount())))
				&& ((this.getPublicDetail() == castOther.getPublicDetail())
						|| (this.getPublicDetail() != null && castOther.getPublicDetail() != null
								&& this.getPublicDetail().equals(castOther.getPublicDetail())))
				&& ((this.getPrivateDetail() == castOther.getPrivateDetail())
						|| (this.getPrivateDetail() != null && castOther.getPrivateDetail() != null
								&& this.getPrivateDetail().equals(castOther.getPrivateDetail())))
				&& ((this.getCreateUserName() == castOther.getCreateUserName())
						|| (this.getCreateUserName() != null && castOther.getCreateUserName() != null
								&& this.getCreateUserName().equals(castOther.getCreateUserName())))
				&& ((this.getDownloadUserId() == castOther.getDownloadUserId())
						|| (this.getDownloadUserId() != null && castOther.getDownloadUserId() != null
								&& this.getDownloadUserId().equals(castOther.getDownloadUserId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getStartDat() == null ? 0 : this.getStartDat().hashCode());
		result = 37 * result + (getEndDat() == null ? 0 : this.getEndDat().hashCode());
		result = 37 * result + (getProName() == null ? 0 : this.getProName().hashCode());
		result = 37 * result + (getDeptId() == null ? 0 : this.getDeptId().hashCode());
		result = 37 * result + (getBankName() == null ? 0 : this.getBankName().hashCode());
		result = 37 * result + (getSearchParName() == null ? 0 : this.getSearchParName().hashCode());
		result = 37 * result + (getAccountName() == null ? 0 : this.getAccountName().hashCode());
		result = 37 * result + (getDeptName() == null ? 0 : this.getDeptName().hashCode());
		result = 37 * result + (getDeptType() == null ? 0 : this.getDeptType().hashCode());
		result = 37 * result + (getTypeName() == null ? 0 : this.getTypeName().hashCode());
		result = 37 * result + (getBusinessName() == null ? 0 : this.getBusinessName().hashCode());
		result = 37 * result + (getDownloadDat() == null ? 0 : this.getDownloadDat().hashCode());
		result = 37 * result + (getBillUuid() == null ? 0 : this.getBillUuid().hashCode());
		result = 37 * result + (getDetailUuid() == null ? 0 : this.getDetailUuid().hashCode());
		result = 37 * result + (getBankCode() == null ? 0 : this.getBankCode().hashCode());
		result = 37 * result + (getBusinessCode() == null ? 0 : this.getBusinessCode().hashCode());
		result = 37 * result + (getSearchParCode() == null ? 0 : this.getSearchParCode().hashCode());
		result = 37 * result + (getSearchParValue() == null ? 0 : this.getSearchParValue().hashCode());
		result = 37 * result + (getEffective() == null ? 0 : this.getEffective().hashCode());
		result = 37 * result + (getUnEffectiveDat() == null ? 0 : this.getUnEffectiveDat().hashCode());
		result = 37 * result + (getDownloadUserName() == null ? 0 : this.getDownloadUserName().hashCode());
		result = 37 * result + (getUnEffectiveUserid() == null ? 0 : this.getUnEffectiveUserid().hashCode());
		result = 37 * result + (getCreateUserid() == null ? 0 : this.getCreateUserid().hashCode());
		result = 37 * result + (getBillDCreateDat() == null ? 0 : this.getBillDCreateDat().hashCode());
		result = 37 * result + (getAccountId() == null ? 0 : this.getAccountId().hashCode());
		result = 37 * result + (getDetailCount() == null ? 0 : this.getDetailCount().hashCode());
		result = 37 * result + (getCustomId() == null ? 0 : this.getCustomId().hashCode());
		result = 37 * result + (getBillMCreateDat() == null ? 0 : this.getBillMCreateDat().hashCode());
		result = 37 * result + (getPublicCount() == null ? 0 : this.getPublicCount().hashCode());
		result = 37 * result + (getPrivateCount() == null ? 0 : this.getPrivateCount().hashCode());
		result = 37 * result + (getPublicDetail() == null ? 0 : this.getPublicDetail().hashCode());
		result = 37 * result + (getPrivateDetail() == null ? 0 : this.getPrivateDetail().hashCode());
		result = 37 * result + (getCreateUserName() == null ? 0 : this.getCreateUserName().hashCode());
		result = 37 * result + (getDownloadUserId() == null ? 0 : this.getDownloadUserId().hashCode());
		return result;
	}

}
