package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-3 12:12:28 by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VSysDeptId generated by hbm2java
 */
@Embeddable
public class VSysDeptId implements java.io.Serializable {

	private String deptUuid;
	private String deptName;
	private BigDecimal userNum;
	private String typeName;
	private String deptType;

	public VSysDeptId() {
	}

	public VSysDeptId(String deptUuid, String deptName, BigDecimal userNum, String typeName, String deptType) {
		this.deptUuid = deptUuid;
		this.deptName = deptName;
		this.userNum = userNum;
		this.typeName = typeName;
		this.deptType = deptType;
	}

	@Column(name = "dept_uuid", length = 36)
	public String getDeptUuid() {
		return this.deptUuid;
	}

	public void setDeptUuid(String deptUuid) {
		this.deptUuid = deptUuid;
	}

	@Column(name = "dept_name", length = 128)
	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "user_num", precision = 131089, scale = 0)
	public BigDecimal getUserNum() {
		return this.userNum;
	}

	public void setUserNum(BigDecimal userNum) {
		this.userNum = userNum;
	}

	@Column(name = "type_name", length = 90)
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Column(name = "dept_type", length = 4)
	public String getDeptType() {
		return this.deptType;
	}

	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VSysDeptId))
			return false;
		VSysDeptId castOther = (VSysDeptId) other;

		return ((this.getDeptUuid() == castOther.getDeptUuid()) || (this.getDeptUuid() != null
				&& castOther.getDeptUuid() != null && this.getDeptUuid().equals(castOther.getDeptUuid())))
				&& ((this.getDeptName() == castOther.getDeptName()) || (this.getDeptName() != null
						&& castOther.getDeptName() != null && this.getDeptName().equals(castOther.getDeptName())))
				&& ((this.getUserNum() == castOther.getUserNum()) || (this.getUserNum() != null
						&& castOther.getUserNum() != null && this.getUserNum().equals(castOther.getUserNum())))
				&& ((this.getTypeName() == castOther.getTypeName()) || (this.getTypeName() != null
						&& castOther.getTypeName() != null && this.getTypeName().equals(castOther.getTypeName())))
				&& ((this.getDeptType() == castOther.getDeptType()) || (this.getDeptType() != null
						&& castOther.getDeptType() != null && this.getDeptType().equals(castOther.getDeptType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDeptUuid() == null ? 0 : this.getDeptUuid().hashCode());
		result = 37 * result + (getDeptName() == null ? 0 : this.getDeptName().hashCode());
		result = 37 * result + (getUserNum() == null ? 0 : this.getUserNum().hashCode());
		result = 37 * result + (getTypeName() == null ? 0 : this.getTypeName().hashCode());
		result = 37 * result + (getDeptType() == null ? 0 : this.getDeptType().hashCode());
		return result;
	}

}
