package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-5 2:10:16 by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DataCorePrivateAccountInfoId generated by hbm2java
 */
@Embeddable
public class DataCorePrivateAccountInfoId implements java.io.Serializable {

	private String privateAccountId;
	private String bankCode;

	public DataCorePrivateAccountInfoId() {
	}

	public DataCorePrivateAccountInfoId(String privateAccountId, String bankCode) {
		this.privateAccountId = privateAccountId;
		this.bankCode = bankCode;
	}

	@Column(name = "private_account_id", nullable = false, length = 128)
	public String getPrivateAccountId() {
		return this.privateAccountId;
	}

	public void setPrivateAccountId(String privateAccountId) {
		this.privateAccountId = privateAccountId;
	}

	@Column(name = "bank_code", nullable = false, length = 4)
	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DataCorePrivateAccountInfoId))
			return false;
		DataCorePrivateAccountInfoId castOther = (DataCorePrivateAccountInfoId) other;

		return ((this.getPrivateAccountId() == castOther.getPrivateAccountId())
				|| (this.getPrivateAccountId() != null && castOther.getPrivateAccountId() != null
						&& this.getPrivateAccountId().equals(castOther.getPrivateAccountId())))
				&& ((this.getBankCode() == castOther.getBankCode()) || (this.getBankCode() != null
						&& castOther.getBankCode() != null && this.getBankCode().equals(castOther.getBankCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getPrivateAccountId() == null ? 0 : this.getPrivateAccountId().hashCode());
		result = 37 * result + (getBankCode() == null ? 0 : this.getBankCode().hashCode());
		return result;
	}

}
