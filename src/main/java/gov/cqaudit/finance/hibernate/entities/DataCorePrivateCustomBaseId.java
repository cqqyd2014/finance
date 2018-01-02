package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-2 21:10:43 by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DataCorePrivateCustomBaseId generated by hbm2java
 */
@Embeddable
public class DataCorePrivateCustomBaseId implements java.io.Serializable {

	private String bankCode;
	private String privateCustomId;

	public DataCorePrivateCustomBaseId() {
	}

	public DataCorePrivateCustomBaseId(String bankCode, String privateCustomId) {
		this.bankCode = bankCode;
		this.privateCustomId = privateCustomId;
	}

	@Column(name = "bank_code", nullable = false, length = 4)
	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	@Column(name = "private_custom_id", nullable = false, length = 128)
	public String getPrivateCustomId() {
		return this.privateCustomId;
	}

	public void setPrivateCustomId(String privateCustomId) {
		this.privateCustomId = privateCustomId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DataCorePrivateCustomBaseId))
			return false;
		DataCorePrivateCustomBaseId castOther = (DataCorePrivateCustomBaseId) other;

		return ((this.getBankCode() == castOther.getBankCode()) || (this.getBankCode() != null
				&& castOther.getBankCode() != null && this.getBankCode().equals(castOther.getBankCode())))
				&& ((this.getPrivateCustomId() == castOther.getPrivateCustomId())
						|| (this.getPrivateCustomId() != null && castOther.getPrivateCustomId() != null
								&& this.getPrivateCustomId().equals(castOther.getPrivateCustomId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBankCode() == null ? 0 : this.getBankCode().hashCode());
		result = 37 * result + (getPrivateCustomId() == null ? 0 : this.getPrivateCustomId().hashCode());
		return result;
	}

}
