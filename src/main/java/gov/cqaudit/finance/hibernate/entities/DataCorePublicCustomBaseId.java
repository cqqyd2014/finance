package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-5 2:10:16 by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DataCorePublicCustomBaseId generated by hbm2java
 */
@Embeddable
public class DataCorePublicCustomBaseId implements java.io.Serializable {

	private String bankCode;
	private String publicCustomId;

	public DataCorePublicCustomBaseId() {
	}

	public DataCorePublicCustomBaseId(String bankCode, String publicCustomId) {
		this.bankCode = bankCode;
		this.publicCustomId = publicCustomId;
	}

	@Column(name = "bank_code", nullable = false, length = 4)
	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	@Column(name = "public_custom_id", nullable = false, length = 128)
	public String getPublicCustomId() {
		return this.publicCustomId;
	}

	public void setPublicCustomId(String publicCustomId) {
		this.publicCustomId = publicCustomId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DataCorePublicCustomBaseId))
			return false;
		DataCorePublicCustomBaseId castOther = (DataCorePublicCustomBaseId) other;

		return ((this.getBankCode() == castOther.getBankCode()) || (this.getBankCode() != null
				&& castOther.getBankCode() != null && this.getBankCode().equals(castOther.getBankCode())))
				&& ((this.getPublicCustomId() == castOther.getPublicCustomId())
						|| (this.getPublicCustomId() != null && castOther.getPublicCustomId() != null
								&& this.getPublicCustomId().equals(castOther.getPublicCustomId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBankCode() == null ? 0 : this.getBankCode().hashCode());
		result = 37 * result + (getPublicCustomId() == null ? 0 : this.getPublicCustomId().hashCode());
		return result;
	}

}
