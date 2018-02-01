package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-30 16:21:58 by Hibernate Tools 5.2.3.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VDataCorePublicAccountInfoId generated by hbm2java
 */
@Embeddable
public class VDataCorePublicAccountInfoId implements java.io.Serializable {

	private String bankCode;
	private String publicAccountId;
	private Date timepoint;
	private String publicAccountName;
	private String publicAccountStatus;
	private Date publicOpenDat;
	private Date publicCloseDat;
	private String publicCustomId;

	public VDataCorePublicAccountInfoId() {
	}

	public VDataCorePublicAccountInfoId(String bankCode, String publicAccountId, Date timepoint,
			String publicAccountName, String publicAccountStatus, Date publicOpenDat, Date publicCloseDat,
			String publicCustomId) {
		this.bankCode = bankCode;
		this.publicAccountId = publicAccountId;
		this.timepoint = timepoint;
		this.publicAccountName = publicAccountName;
		this.publicAccountStatus = publicAccountStatus;
		this.publicOpenDat = publicOpenDat;
		this.publicCloseDat = publicCloseDat;
		this.publicCustomId = publicCustomId;
	}

	@Column(name = "bank_code", length = 4)
	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	@Column(name = "public_account_id", length = 128)
	public String getPublicAccountId() {
		return this.publicAccountId;
	}

	public void setPublicAccountId(String publicAccountId) {
		this.publicAccountId = publicAccountId;
	}

	@Column(name = "timepoint", length = 35)
	public Date getTimepoint() {
		return this.timepoint;
	}

	public void setTimepoint(Date timepoint) {
		this.timepoint = timepoint;
	}

	@Column(name = "public_account_name", length = 256)
	public String getPublicAccountName() {
		return this.publicAccountName;
	}

	public void setPublicAccountName(String publicAccountName) {
		this.publicAccountName = publicAccountName;
	}

	@Column(name = "public_account_status", length = 32)
	public String getPublicAccountStatus() {
		return this.publicAccountStatus;
	}

	public void setPublicAccountStatus(String publicAccountStatus) {
		this.publicAccountStatus = publicAccountStatus;
	}

	@Column(name = "public_open_dat", length = 35)
	public Date getPublicOpenDat() {
		return this.publicOpenDat;
	}

	public void setPublicOpenDat(Date publicOpenDat) {
		this.publicOpenDat = publicOpenDat;
	}

	@Column(name = "public_close_dat", length = 35)
	public Date getPublicCloseDat() {
		return this.publicCloseDat;
	}

	public void setPublicCloseDat(Date publicCloseDat) {
		this.publicCloseDat = publicCloseDat;
	}

	@Column(name = "public_custom_id", length = 128)
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
		if (!(other instanceof VDataCorePublicAccountInfoId))
			return false;
		VDataCorePublicAccountInfoId castOther = (VDataCorePublicAccountInfoId) other;

		return ((this.getBankCode() == castOther.getBankCode()) || (this.getBankCode() != null
				&& castOther.getBankCode() != null && this.getBankCode().equals(castOther.getBankCode())))
				&& ((this.getPublicAccountId() == castOther.getPublicAccountId())
						|| (this.getPublicAccountId() != null && castOther.getPublicAccountId() != null
								&& this.getPublicAccountId().equals(castOther.getPublicAccountId())))
				&& ((this.getTimepoint() == castOther.getTimepoint()) || (this.getTimepoint() != null
						&& castOther.getTimepoint() != null && this.getTimepoint().equals(castOther.getTimepoint())))
				&& ((this.getPublicAccountName() == castOther.getPublicAccountName())
						|| (this.getPublicAccountName() != null && castOther.getPublicAccountName() != null
								&& this.getPublicAccountName().equals(castOther.getPublicAccountName())))
				&& ((this.getPublicAccountStatus() == castOther.getPublicAccountStatus())
						|| (this.getPublicAccountStatus() != null && castOther.getPublicAccountStatus() != null
								&& this.getPublicAccountStatus().equals(castOther.getPublicAccountStatus())))
				&& ((this.getPublicOpenDat() == castOther.getPublicOpenDat())
						|| (this.getPublicOpenDat() != null && castOther.getPublicOpenDat() != null
								&& this.getPublicOpenDat().equals(castOther.getPublicOpenDat())))
				&& ((this.getPublicCloseDat() == castOther.getPublicCloseDat())
						|| (this.getPublicCloseDat() != null && castOther.getPublicCloseDat() != null
								&& this.getPublicCloseDat().equals(castOther.getPublicCloseDat())))
				&& ((this.getPublicCustomId() == castOther.getPublicCustomId())
						|| (this.getPublicCustomId() != null && castOther.getPublicCustomId() != null
								&& this.getPublicCustomId().equals(castOther.getPublicCustomId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBankCode() == null ? 0 : this.getBankCode().hashCode());
		result = 37 * result + (getPublicAccountId() == null ? 0 : this.getPublicAccountId().hashCode());
		result = 37 * result + (getTimepoint() == null ? 0 : this.getTimepoint().hashCode());
		result = 37 * result + (getPublicAccountName() == null ? 0 : this.getPublicAccountName().hashCode());
		result = 37 * result + (getPublicAccountStatus() == null ? 0 : this.getPublicAccountStatus().hashCode());
		result = 37 * result + (getPublicOpenDat() == null ? 0 : this.getPublicOpenDat().hashCode());
		result = 37 * result + (getPublicCloseDat() == null ? 0 : this.getPublicCloseDat().hashCode());
		result = 37 * result + (getPublicCustomId() == null ? 0 : this.getPublicCustomId().hashCode());
		return result;
	}

}
