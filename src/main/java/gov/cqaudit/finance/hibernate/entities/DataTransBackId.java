package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-2-9 12:39:57 by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DataTransBackId generated by hbm2java
 */
@Embeddable
public class DataTransBackId implements java.io.Serializable {

	private String transUuid;
	private String bankCode;
	private String tableCode;

	public DataTransBackId() {
	}

	public DataTransBackId(String transUuid, String bankCode, String tableCode) {
		this.transUuid = transUuid;
		this.bankCode = bankCode;
		this.tableCode = tableCode;
	}

	@Column(name = "trans_uuid", nullable = false, length = 36)
	public String getTransUuid() {
		return this.transUuid;
	}

	public void setTransUuid(String transUuid) {
		this.transUuid = transUuid;
	}

	@Column(name = "bank_code", nullable = false, length = 4)
	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	@Column(name = "table_code", nullable = false, length = 4)
	public String getTableCode() {
		return this.tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DataTransBackId))
			return false;
		DataTransBackId castOther = (DataTransBackId) other;

		return ((this.getTransUuid() == castOther.getTransUuid()) || (this.getTransUuid() != null
				&& castOther.getTransUuid() != null && this.getTransUuid().equals(castOther.getTransUuid())))
				&& ((this.getBankCode() == castOther.getBankCode()) || (this.getBankCode() != null
						&& castOther.getBankCode() != null && this.getBankCode().equals(castOther.getBankCode())))
				&& ((this.getTableCode() == castOther.getTableCode()) || (this.getTableCode() != null
						&& castOther.getTableCode() != null && this.getTableCode().equals(castOther.getTableCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTransUuid() == null ? 0 : this.getTransUuid().hashCode());
		result = 37 * result + (getBankCode() == null ? 0 : this.getBankCode().hashCode());
		result = 37 * result + (getTableCode() == null ? 0 : this.getTableCode().hashCode());
		return result;
	}

}
