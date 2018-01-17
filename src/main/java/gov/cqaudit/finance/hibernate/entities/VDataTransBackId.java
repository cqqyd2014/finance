package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-16 13:34:04 by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VDataTransBackId generated by hbm2java
 */
@Embeddable
public class VDataTransBackId implements java.io.Serializable {

	private String transUuid;
	private String bankCode;
	private String tableCode;
	private BigDecimal rowsCount;

	public VDataTransBackId() {
	}

	public VDataTransBackId(String transUuid, String bankCode, String tableCode, BigDecimal rowsCount) {
		this.transUuid = transUuid;
		this.bankCode = bankCode;
		this.tableCode = tableCode;
		this.rowsCount = rowsCount;
	}

	@Column(name = "trans_uuid", length = 36)
	public String getTransUuid() {
		return this.transUuid;
	}

	public void setTransUuid(String transUuid) {
		this.transUuid = transUuid;
	}

	@Column(name = "bank_code", length = 4)
	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	@Column(name = "table_code", length = 4)
	public String getTableCode() {
		return this.tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	@Column(name = "rows_count", precision = 131089, scale = 0)
	public BigDecimal getRowsCount() {
		return this.rowsCount;
	}

	public void setRowsCount(BigDecimal rowsCount) {
		this.rowsCount = rowsCount;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VDataTransBackId))
			return false;
		VDataTransBackId castOther = (VDataTransBackId) other;

		return ((this.getTransUuid() == castOther.getTransUuid()) || (this.getTransUuid() != null
				&& castOther.getTransUuid() != null && this.getTransUuid().equals(castOther.getTransUuid())))
				&& ((this.getBankCode() == castOther.getBankCode()) || (this.getBankCode() != null
						&& castOther.getBankCode() != null && this.getBankCode().equals(castOther.getBankCode())))
				&& ((this.getTableCode() == castOther.getTableCode()) || (this.getTableCode() != null
						&& castOther.getTableCode() != null && this.getTableCode().equals(castOther.getTableCode())))
				&& ((this.getRowsCount() == castOther.getRowsCount()) || (this.getRowsCount() != null
						&& castOther.getRowsCount() != null && this.getRowsCount().equals(castOther.getRowsCount())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTransUuid() == null ? 0 : this.getTransUuid().hashCode());
		result = 37 * result + (getBankCode() == null ? 0 : this.getBankCode().hashCode());
		result = 37 * result + (getTableCode() == null ? 0 : this.getTableCode().hashCode());
		result = 37 * result + (getRowsCount() == null ? 0 : this.getRowsCount().hashCode());
		return result;
	}

}
