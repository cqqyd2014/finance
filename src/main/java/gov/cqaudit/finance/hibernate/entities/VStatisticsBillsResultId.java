package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-5 1:05:23 by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VStatisticsBillsResultId generated by hbm2java
 */
@Embeddable
public class VStatisticsBillsResultId implements java.io.Serializable {

	private String deptId;
	private String deptName;
	private String deptType;
	private String typeName;
	private Date createDat;
	private String billUuid;
	private Long publicCount;
	private Long privateCount;
	private BigDecimal publicDetail;
	private BigDecimal privateDetail;

	public VStatisticsBillsResultId() {
	}

	public VStatisticsBillsResultId(String deptId, String deptName, String deptType, String typeName, Date createDat,
			String billUuid, Long publicCount, Long privateCount, BigDecimal publicDetail, BigDecimal privateDetail) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptType = deptType;
		this.typeName = typeName;
		this.createDat = createDat;
		this.billUuid = billUuid;
		this.publicCount = publicCount;
		this.privateCount = privateCount;
		this.publicDetail = publicDetail;
		this.privateDetail = privateDetail;
	}

	@Column(name = "dept_id", length = 36)
	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
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

	@Column(name = "create_dat", length = 35)
	public Date getCreateDat() {
		return this.createDat;
	}

	public void setCreateDat(Date createDat) {
		this.createDat = createDat;
	}

	@Column(name = "bill_uuid", length = 36)
	public String getBillUuid() {
		return this.billUuid;
	}

	public void setBillUuid(String billUuid) {
		this.billUuid = billUuid;
	}

	@Column(name = "public_count")
	public Long getPublicCount() {
		return this.publicCount;
	}

	public void setPublicCount(Long publicCount) {
		this.publicCount = publicCount;
	}

	@Column(name = "private_count")
	public Long getPrivateCount() {
		return this.privateCount;
	}

	public void setPrivateCount(Long privateCount) {
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VStatisticsBillsResultId))
			return false;
		VStatisticsBillsResultId castOther = (VStatisticsBillsResultId) other;

		return ((this.getDeptId() == castOther.getDeptId()) || (this.getDeptId() != null
				&& castOther.getDeptId() != null && this.getDeptId().equals(castOther.getDeptId())))
				&& ((this.getDeptName() == castOther.getDeptName()) || (this.getDeptName() != null
						&& castOther.getDeptName() != null && this.getDeptName().equals(castOther.getDeptName())))
				&& ((this.getDeptType() == castOther.getDeptType()) || (this.getDeptType() != null
						&& castOther.getDeptType() != null && this.getDeptType().equals(castOther.getDeptType())))
				&& ((this.getTypeName() == castOther.getTypeName()) || (this.getTypeName() != null
						&& castOther.getTypeName() != null && this.getTypeName().equals(castOther.getTypeName())))
				&& ((this.getCreateDat() == castOther.getCreateDat()) || (this.getCreateDat() != null
						&& castOther.getCreateDat() != null && this.getCreateDat().equals(castOther.getCreateDat())))
				&& ((this.getBillUuid() == castOther.getBillUuid()) || (this.getBillUuid() != null
						&& castOther.getBillUuid() != null && this.getBillUuid().equals(castOther.getBillUuid())))
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
								&& this.getPrivateDetail().equals(castOther.getPrivateDetail())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDeptId() == null ? 0 : this.getDeptId().hashCode());
		result = 37 * result + (getDeptName() == null ? 0 : this.getDeptName().hashCode());
		result = 37 * result + (getDeptType() == null ? 0 : this.getDeptType().hashCode());
		result = 37 * result + (getTypeName() == null ? 0 : this.getTypeName().hashCode());
		result = 37 * result + (getCreateDat() == null ? 0 : this.getCreateDat().hashCode());
		result = 37 * result + (getBillUuid() == null ? 0 : this.getBillUuid().hashCode());
		result = 37 * result + (getPublicCount() == null ? 0 : this.getPublicCount().hashCode());
		result = 37 * result + (getPrivateCount() == null ? 0 : this.getPrivateCount().hashCode());
		result = 37 * result + (getPublicDetail() == null ? 0 : this.getPublicDetail().hashCode());
		result = 37 * result + (getPrivateDetail() == null ? 0 : this.getPrivateDetail().hashCode());
		return result;
	}

}
