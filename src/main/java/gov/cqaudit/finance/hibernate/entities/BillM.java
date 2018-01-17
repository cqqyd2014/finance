package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-16 13:34:04 by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * BillM generated by hbm2java
 */
@Entity
@Table(name = "bill_m", schema = "public")
public class BillM implements java.io.Serializable {

	private String billUuid;
	private String createUserId;
	private Date createDat;
	private String billStatus;
	private String contractName;
	private String contractTell;
	private String contractMail;
	private String auditUserId;
	private Date lastAuditDat;
	private String proName;
	private String deptId;
	private Date lastModifyDat;
	private String searchReason;
	private String downloadUserId;
	private Date downloadDat;
	private String downloadUuid;
	private Boolean effective;
	private BigDecimal picsNum;
	private BigDecimal detailNum;
	private Date uneffectiveDat;
	private String uneffectiveUserId;
	private String billType;

	public BillM() {
	}

	public BillM(String billUuid) {
		this.billUuid = billUuid;
	}

	public BillM(String billUuid, String createUserId, Date createDat, String billStatus, String contractName,
			String contractTell, String contractMail, String auditUserId, Date lastAuditDat, String proName,
			String deptId, Date lastModifyDat, String searchReason, String downloadUserId, Date downloadDat,
			String downloadUuid, Boolean effective, BigDecimal picsNum, BigDecimal detailNum, Date uneffectiveDat,
			String uneffectiveUserId, String billType) {
		this.billUuid = billUuid;
		this.createUserId = createUserId;
		this.createDat = createDat;
		this.billStatus = billStatus;
		this.contractName = contractName;
		this.contractTell = contractTell;
		this.contractMail = contractMail;
		this.auditUserId = auditUserId;
		this.lastAuditDat = lastAuditDat;
		this.proName = proName;
		this.deptId = deptId;
		this.lastModifyDat = lastModifyDat;
		this.searchReason = searchReason;
		this.downloadUserId = downloadUserId;
		this.downloadDat = downloadDat;
		this.downloadUuid = downloadUuid;
		this.effective = effective;
		this.picsNum = picsNum;
		this.detailNum = detailNum;
		this.uneffectiveDat = uneffectiveDat;
		this.uneffectiveUserId = uneffectiveUserId;
		this.billType = billType;
	}

	@Id

	@Column(name = "bill_uuid", unique = true, nullable = false, length = 36)
	public String getBillUuid() {
		return this.billUuid;
	}

	public void setBillUuid(String billUuid) {
		this.billUuid = billUuid;
	}

	@Column(name = "create_user_id", length = 36)
	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	@Temporal(TemporalType.TIMESTAMP)
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

	@Temporal(TemporalType.TIMESTAMP)
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

	@Column(name = "dept_id", length = 36)
	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Temporal(TemporalType.TIMESTAMP)
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

	@Temporal(TemporalType.TIMESTAMP)
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

	@Column(name = "pics_num", precision = 131089, scale = 0)
	public BigDecimal getPicsNum() {
		return this.picsNum;
	}

	public void setPicsNum(BigDecimal picsNum) {
		this.picsNum = picsNum;
	}

	@Column(name = "detail_num", precision = 131089, scale = 0)
	public BigDecimal getDetailNum() {
		return this.detailNum;
	}

	public void setDetailNum(BigDecimal detailNum) {
		this.detailNum = detailNum;
	}

	@Temporal(TemporalType.TIMESTAMP)
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

	@Column(name = "bill_type", length = 4)
	public String getBillType() {
		return this.billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

}
