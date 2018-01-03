package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-3 12:12:28 by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VBillMId generated by hbm2java
 */
@Embeddable
public class VBillMId implements java.io.Serializable {

	private Date uneffectiveDat;
	private String uneffectiveUserId;
	private BigDecimal detailNum;
	private BigDecimal picsNum;
	private String deptName;
	private String createUserId;
	private Date createDat;
	private String billStatus;
	private String contractName;
	private String contractTell;
	private String contractMail;
	private String auditUserId;
	private Date lastAuditDat;
	private String proName;
	private String billUuid;
	private String deptId;
	private Date lastModifyDat;
	private String searchReason;
	private String downloadUserId;
	private Date downloadDat;
	private String downloadUuid;
	private Boolean effective;
	private String createUserName;
	private String auditUserName;
	private String downloadUserName;
	private String uneffectiveUserName;

	public VBillMId() {
	}

	public VBillMId(Date uneffectiveDat, String uneffectiveUserId, BigDecimal detailNum, BigDecimal picsNum,
			String deptName, String createUserId, Date createDat, String billStatus, String contractName,
			String contractTell, String contractMail, String auditUserId, Date lastAuditDat, String proName,
			String billUuid, String deptId, Date lastModifyDat, String searchReason, String downloadUserId,
			Date downloadDat, String downloadUuid, Boolean effective, String createUserName, String auditUserName,
			String downloadUserName, String uneffectiveUserName) {
		this.uneffectiveDat = uneffectiveDat;
		this.uneffectiveUserId = uneffectiveUserId;
		this.detailNum = detailNum;
		this.picsNum = picsNum;
		this.deptName = deptName;
		this.createUserId = createUserId;
		this.createDat = createDat;
		this.billStatus = billStatus;
		this.contractName = contractName;
		this.contractTell = contractTell;
		this.contractMail = contractMail;
		this.auditUserId = auditUserId;
		this.lastAuditDat = lastAuditDat;
		this.proName = proName;
		this.billUuid = billUuid;
		this.deptId = deptId;
		this.lastModifyDat = lastModifyDat;
		this.searchReason = searchReason;
		this.downloadUserId = downloadUserId;
		this.downloadDat = downloadDat;
		this.downloadUuid = downloadUuid;
		this.effective = effective;
		this.createUserName = createUserName;
		this.auditUserName = auditUserName;
		this.downloadUserName = downloadUserName;
		this.uneffectiveUserName = uneffectiveUserName;
	}

	@Column(name = "uneffective_dat", length = 35)
	public Date getUneffectiveDat() {
		return this.uneffectiveDat;
	}

	public void setUneffectiveDat(Date uneffectiveDat) {
		this.uneffectiveDat = uneffectiveDat;
	}

	@Column(name = "uneffective_user_id", length = 36)
	public String getUneffectiveUserId() {
		return this.uneffectiveUserId;
	}

	public void setUneffectiveUserId(String uneffectiveUserId) {
		this.uneffectiveUserId = uneffectiveUserId;
	}

	@Column(name = "detail_num", precision = 131089, scale = 0)
	public BigDecimal getDetailNum() {
		return this.detailNum;
	}

	public void setDetailNum(BigDecimal detailNum) {
		this.detailNum = detailNum;
	}

	@Column(name = "pics_num", precision = 131089, scale = 0)
	public BigDecimal getPicsNum() {
		return this.picsNum;
	}

	public void setPicsNum(BigDecimal picsNum) {
		this.picsNum = picsNum;
	}

	@Column(name = "dept_name", length = 128)
	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "create_user_id", length = 36)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@Column(name = "create_dat", length = 35)
	public Date getCreateDat() {
		return this.createDat;
	}

	public void setCreateDat(Date createDat) {
		this.createDat = createDat;
	}

	@Column(name = "bill_status", length = 4)
	public String getBillStatus() {
		return this.billStatus;
	}

	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}

	@Column(name = "contract_name", length = 64)
	public String getContractName() {
		return this.contractName;
	}

	public void setContractName(String contractName) {
		this.contractName = contractName;
	}

	@Column(name = "contract_tell", length = 64)
	public String getContractTell() {
		return this.contractTell;
	}

	public void setContractTell(String contractTell) {
		this.contractTell = contractTell;
	}

	@Column(name = "contract_mail", length = 256)
	public String getContractMail() {
		return this.contractMail;
	}

	public void setContractMail(String contractMail) {
		this.contractMail = contractMail;
	}

	@Column(name = "audit_user_id", length = 36)
	public String getAuditUserId() {
		return this.auditUserId;
	}

	public void setAuditUserId(String auditUserId) {
		this.auditUserId = auditUserId;
	}

	@Column(name = "last_audit_dat", length = 35)
	public Date getLastAuditDat() {
		return this.lastAuditDat;
	}

	public void setLastAuditDat(Date lastAuditDat) {
		this.lastAuditDat = lastAuditDat;
	}

	@Column(name = "pro_name", length = 512)
	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	@Column(name = "bill_uuid", length = 36)
	public String getBillUuid() {
		return this.billUuid;
	}

	public void setBillUuid(String billUuid) {
		this.billUuid = billUuid;
	}

	@Column(name = "dept_id", length = 36)
	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Column(name = "last_modify_dat", length = 35)
	public Date getLastModifyDat() {
		return this.lastModifyDat;
	}

	public void setLastModifyDat(Date lastModifyDat) {
		this.lastModifyDat = lastModifyDat;
	}

	@Column(name = "search_reason", length = 1024)
	public String getSearchReason() {
		return this.searchReason;
	}

	public void setSearchReason(String searchReason) {
		this.searchReason = searchReason;
	}

	@Column(name = "download_user_id", length = 36)
	public String getDownloadUserId() {
		return this.downloadUserId;
	}

	public void setDownloadUserId(String downloadUserId) {
		this.downloadUserId = downloadUserId;
	}

	@Column(name = "download_dat", length = 35)
	public Date getDownloadDat() {
		return this.downloadDat;
	}

	public void setDownloadDat(Date downloadDat) {
		this.downloadDat = downloadDat;
	}

	@Column(name = "download_uuid", length = 36)
	public String getDownloadUuid() {
		return this.downloadUuid;
	}

	public void setDownloadUuid(String downloadUuid) {
		this.downloadUuid = downloadUuid;
	}

	@Column(name = "effective")
	public Boolean getEffective() {
		return this.effective;
	}

	public void setEffective(Boolean effective) {
		this.effective = effective;
	}

	@Column(name = "create_user_name")
	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	@Column(name = "audit_user_name")
	public String getAuditUserName() {
		return this.auditUserName;
	}

	public void setAuditUserName(String auditUserName) {
		this.auditUserName = auditUserName;
	}

	@Column(name = "download_user_name")
	public String getDownloadUserName() {
		return this.downloadUserName;
	}

	public void setDownloadUserName(String downloadUserName) {
		this.downloadUserName = downloadUserName;
	}

	@Column(name = "uneffective_user_name")
	public String getUneffectiveUserName() {
		return this.uneffectiveUserName;
	}

	public void setUneffectiveUserName(String uneffectiveUserName) {
		this.uneffectiveUserName = uneffectiveUserName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VBillMId))
			return false;
		VBillMId castOther = (VBillMId) other;

		return ((this.getUneffectiveDat() == castOther.getUneffectiveDat())
				|| (this.getUneffectiveDat() != null && castOther.getUneffectiveDat() != null
						&& this.getUneffectiveDat().equals(castOther.getUneffectiveDat())))
				&& ((this.getUneffectiveUserId() == castOther.getUneffectiveUserId())
						|| (this.getUneffectiveUserId() != null && castOther.getUneffectiveUserId() != null
								&& this.getUneffectiveUserId().equals(castOther.getUneffectiveUserId())))
				&& ((this.getDetailNum() == castOther.getDetailNum()) || (this.getDetailNum() != null
						&& castOther.getDetailNum() != null && this.getDetailNum().equals(castOther.getDetailNum())))
				&& ((this.getPicsNum() == castOther.getPicsNum()) || (this.getPicsNum() != null
						&& castOther.getPicsNum() != null && this.getPicsNum().equals(castOther.getPicsNum())))
				&& ((this.getDeptName() == castOther.getDeptName()) || (this.getDeptName() != null
						&& castOther.getDeptName() != null && this.getDeptName().equals(castOther.getDeptName())))
				&& ((this.getCreateUserId() == castOther.getCreateUserId())
						|| (this.getCreateUserId() != null && castOther.getCreateUserId() != null
								&& this.getCreateUserId().equals(castOther.getCreateUserId())))
				&& ((this.getCreateDat() == castOther.getCreateDat()) || (this.getCreateDat() != null
						&& castOther.getCreateDat() != null && this.getCreateDat().equals(castOther.getCreateDat())))
				&& ((this.getBillStatus() == castOther.getBillStatus()) || (this.getBillStatus() != null
						&& castOther.getBillStatus() != null && this.getBillStatus().equals(castOther.getBillStatus())))
				&& ((this.getContractName() == castOther.getContractName())
						|| (this.getContractName() != null && castOther.getContractName() != null
								&& this.getContractName().equals(castOther.getContractName())))
				&& ((this.getContractTell() == castOther.getContractTell())
						|| (this.getContractTell() != null && castOther.getContractTell() != null
								&& this.getContractTell().equals(castOther.getContractTell())))
				&& ((this.getContractMail() == castOther.getContractMail())
						|| (this.getContractMail() != null && castOther.getContractMail() != null
								&& this.getContractMail().equals(castOther.getContractMail())))
				&& ((this.getAuditUserId() == castOther.getAuditUserId())
						|| (this.getAuditUserId() != null && castOther.getAuditUserId() != null
								&& this.getAuditUserId().equals(castOther.getAuditUserId())))
				&& ((this.getLastAuditDat() == castOther.getLastAuditDat())
						|| (this.getLastAuditDat() != null && castOther.getLastAuditDat() != null
								&& this.getLastAuditDat().equals(castOther.getLastAuditDat())))
				&& ((this.getProName() == castOther.getProName()) || (this.getProName() != null
						&& castOther.getProName() != null && this.getProName().equals(castOther.getProName())))
				&& ((this.getBillUuid() == castOther.getBillUuid()) || (this.getBillUuid() != null
						&& castOther.getBillUuid() != null && this.getBillUuid().equals(castOther.getBillUuid())))
				&& ((this.getDeptId() == castOther.getDeptId()) || (this.getDeptId() != null
						&& castOther.getDeptId() != null && this.getDeptId().equals(castOther.getDeptId())))
				&& ((this.getLastModifyDat() == castOther.getLastModifyDat())
						|| (this.getLastModifyDat() != null && castOther.getLastModifyDat() != null
								&& this.getLastModifyDat().equals(castOther.getLastModifyDat())))
				&& ((this.getSearchReason() == castOther.getSearchReason())
						|| (this.getSearchReason() != null && castOther.getSearchReason() != null
								&& this.getSearchReason().equals(castOther.getSearchReason())))
				&& ((this.getDownloadUserId() == castOther.getDownloadUserId())
						|| (this.getDownloadUserId() != null && castOther.getDownloadUserId() != null
								&& this.getDownloadUserId().equals(castOther.getDownloadUserId())))
				&& ((this.getDownloadDat() == castOther.getDownloadDat())
						|| (this.getDownloadDat() != null && castOther.getDownloadDat() != null
								&& this.getDownloadDat().equals(castOther.getDownloadDat())))
				&& ((this.getDownloadUuid() == castOther.getDownloadUuid())
						|| (this.getDownloadUuid() != null && castOther.getDownloadUuid() != null
								&& this.getDownloadUuid().equals(castOther.getDownloadUuid())))
				&& ((this.getEffective() == castOther.getEffective()) || (this.getEffective() != null
						&& castOther.getEffective() != null && this.getEffective().equals(castOther.getEffective())))
				&& ((this.getCreateUserName() == castOther.getCreateUserName())
						|| (this.getCreateUserName() != null && castOther.getCreateUserName() != null
								&& this.getCreateUserName().equals(castOther.getCreateUserName())))
				&& ((this.getAuditUserName() == castOther.getAuditUserName())
						|| (this.getAuditUserName() != null && castOther.getAuditUserName() != null
								&& this.getAuditUserName().equals(castOther.getAuditUserName())))
				&& ((this.getDownloadUserName() == castOther.getDownloadUserName())
						|| (this.getDownloadUserName() != null && castOther.getDownloadUserName() != null
								&& this.getDownloadUserName().equals(castOther.getDownloadUserName())))
				&& ((this.getUneffectiveUserName() == castOther.getUneffectiveUserName())
						|| (this.getUneffectiveUserName() != null && castOther.getUneffectiveUserName() != null
								&& this.getUneffectiveUserName().equals(castOther.getUneffectiveUserName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUneffectiveDat() == null ? 0 : this.getUneffectiveDat().hashCode());
		result = 37 * result + (getUneffectiveUserId() == null ? 0 : this.getUneffectiveUserId().hashCode());
		result = 37 * result + (getDetailNum() == null ? 0 : this.getDetailNum().hashCode());
		result = 37 * result + (getPicsNum() == null ? 0 : this.getPicsNum().hashCode());
		result = 37 * result + (getDeptName() == null ? 0 : this.getDeptName().hashCode());
		result = 37 * result + (getCreateUserId() == null ? 0 : this.getCreateUserId().hashCode());
		result = 37 * result + (getCreateDat() == null ? 0 : this.getCreateDat().hashCode());
		result = 37 * result + (getBillStatus() == null ? 0 : this.getBillStatus().hashCode());
		result = 37 * result + (getContractName() == null ? 0 : this.getContractName().hashCode());
		result = 37 * result + (getContractTell() == null ? 0 : this.getContractTell().hashCode());
		result = 37 * result + (getContractMail() == null ? 0 : this.getContractMail().hashCode());
		result = 37 * result + (getAuditUserId() == null ? 0 : this.getAuditUserId().hashCode());
		result = 37 * result + (getLastAuditDat() == null ? 0 : this.getLastAuditDat().hashCode());
		result = 37 * result + (getProName() == null ? 0 : this.getProName().hashCode());
		result = 37 * result + (getBillUuid() == null ? 0 : this.getBillUuid().hashCode());
		result = 37 * result + (getDeptId() == null ? 0 : this.getDeptId().hashCode());
		result = 37 * result + (getLastModifyDat() == null ? 0 : this.getLastModifyDat().hashCode());
		result = 37 * result + (getSearchReason() == null ? 0 : this.getSearchReason().hashCode());
		result = 37 * result + (getDownloadUserId() == null ? 0 : this.getDownloadUserId().hashCode());
		result = 37 * result + (getDownloadDat() == null ? 0 : this.getDownloadDat().hashCode());
		result = 37 * result + (getDownloadUuid() == null ? 0 : this.getDownloadUuid().hashCode());
		result = 37 * result + (getEffective() == null ? 0 : this.getEffective().hashCode());
		result = 37 * result + (getCreateUserName() == null ? 0 : this.getCreateUserName().hashCode());
		result = 37 * result + (getAuditUserName() == null ? 0 : this.getAuditUserName().hashCode());
		result = 37 * result + (getDownloadUserName() == null ? 0 : this.getDownloadUserName().hashCode());
		result = 37 * result + (getUneffectiveUserName() == null ? 0 : this.getUneffectiveUserName().hashCode());
		return result;
	}

}
