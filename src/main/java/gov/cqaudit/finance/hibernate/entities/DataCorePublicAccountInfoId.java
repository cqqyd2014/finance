package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-2-9 12:39:57 by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DataCorePublicAccountInfoId generated by hbm2java
 */
@Embeddable
public class DataCorePublicAccountInfoId implements java.io.Serializable {

	private String bankCode;
	private String publicAccountId;

	public DataCorePublicAccountInfoId() {
	}

	public DataCorePublicAccountInfoId(String bankCode, String publicAccountId) {
		this.bankCode = bankCode;
		this.publicAccountId = publicAccountId;
	}

	@Column(name = "bank_code", nullable = false, length = 4)
	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	@Column(name = "public_account_id", nullable = false, length = 128)
	public String getPublicAccountId() {
		return this.publicAccountId;
	}

	public void setPublicAccountId(String publicAccountId) {
		this.publicAccountId = publicAccountId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DataCorePublicAccountInfoId))
			return false;
		DataCorePublicAccountInfoId castOther = (DataCorePublicAccountInfoId) other;

		return ((this.getBankCode() == castOther.getBankCode()) || (this.getBankCode() != null
				&& castOther.getBankCode() != null && this.getBankCode().equals(castOther.getBankCode())))
				&& ((this.getPublicAccountId() == castOther.getPublicAccountId())
						|| (this.getPublicAccountId() != null && castOther.getPublicAccountId() != null
								&& this.getPublicAccountId().equals(castOther.getPublicAccountId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBankCode() == null ? 0 : this.getBankCode().hashCode());
		result = 37 * result + (getPublicAccountId() == null ? 0 : this.getPublicAccountId().hashCode());
		return result;
	}

}
