package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-2 21:10:43 by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VDataCorePublicCustomBaseId generated by hbm2java
 */
@Embeddable
public class VDataCorePublicCustomBaseId implements java.io.Serializable {

	private String bankCode;
	private String publicCustomId;
	private String publicCustomName;
	private String publicLawManName;
	private String publicIdCard;
	private String publicLawManIdCard;
	private String publicBusiness;
	private BigDecimal publicRegCapital;

	public VDataCorePublicCustomBaseId() {
	}

	public VDataCorePublicCustomBaseId(String bankCode, String publicCustomId, String publicCustomName,
			String publicLawManName, String publicIdCard, String publicLawManIdCard, String publicBusiness,
			BigDecimal publicRegCapital) {
		this.bankCode = bankCode;
		this.publicCustomId = publicCustomId;
		this.publicCustomName = publicCustomName;
		this.publicLawManName = publicLawManName;
		this.publicIdCard = publicIdCard;
		this.publicLawManIdCard = publicLawManIdCard;
		this.publicBusiness = publicBusiness;
		this.publicRegCapital = publicRegCapital;
	}

	@Column(name = "bank_code", length = 4)
	public String getBankCode() {
		return this.bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	@Column(name = "public_custom_id", length = 128)
	public String getPublicCustomId() {
		return this.publicCustomId;
	}

	public void setPublicCustomId(String publicCustomId) {
		this.publicCustomId = publicCustomId;
	}

	@Column(name = "public_custom_name", length = 256)
	public String getPublicCustomName() {
		return this.publicCustomName;
	}

	public void setPublicCustomName(String publicCustomName) {
		this.publicCustomName = publicCustomName;
	}

	@Column(name = "public_law_man_name", length = 128)
	public String getPublicLawManName() {
		return this.publicLawManName;
	}

	public void setPublicLawManName(String publicLawManName) {
		this.publicLawManName = publicLawManName;
	}

	@Column(name = "public_id_card", length = 128)
	public String getPublicIdCard() {
		return this.publicIdCard;
	}

	public void setPublicIdCard(String publicIdCard) {
		this.publicIdCard = publicIdCard;
	}

	@Column(name = "public_law_man_id_card", length = 128)
	public String getPublicLawManIdCard() {
		return this.publicLawManIdCard;
	}

	public void setPublicLawManIdCard(String publicLawManIdCard) {
		this.publicLawManIdCard = publicLawManIdCard;
	}

	@Column(name = "public_business", length = 1024)
	public String getPublicBusiness() {
		return this.publicBusiness;
	}

	public void setPublicBusiness(String publicBusiness) {
		this.publicBusiness = publicBusiness;
	}

	@Column(name = "public_reg_capital", precision = 131089, scale = 0)
	public BigDecimal getPublicRegCapital() {
		return this.publicRegCapital;
	}

	public void setPublicRegCapital(BigDecimal publicRegCapital) {
		this.publicRegCapital = publicRegCapital;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VDataCorePublicCustomBaseId))
			return false;
		VDataCorePublicCustomBaseId castOther = (VDataCorePublicCustomBaseId) other;

		return ((this.getBankCode() == castOther.getBankCode()) || (this.getBankCode() != null
				&& castOther.getBankCode() != null && this.getBankCode().equals(castOther.getBankCode())))
				&& ((this.getPublicCustomId() == castOther.getPublicCustomId())
						|| (this.getPublicCustomId() != null && castOther.getPublicCustomId() != null
								&& this.getPublicCustomId().equals(castOther.getPublicCustomId())))
				&& ((this.getPublicCustomName() == castOther.getPublicCustomName())
						|| (this.getPublicCustomName() != null && castOther.getPublicCustomName() != null
								&& this.getPublicCustomName().equals(castOther.getPublicCustomName())))
				&& ((this.getPublicLawManName() == castOther.getPublicLawManName())
						|| (this.getPublicLawManName() != null && castOther.getPublicLawManName() != null
								&& this.getPublicLawManName().equals(castOther.getPublicLawManName())))
				&& ((this.getPublicIdCard() == castOther.getPublicIdCard())
						|| (this.getPublicIdCard() != null && castOther.getPublicIdCard() != null
								&& this.getPublicIdCard().equals(castOther.getPublicIdCard())))
				&& ((this.getPublicLawManIdCard() == castOther.getPublicLawManIdCard())
						|| (this.getPublicLawManIdCard() != null && castOther.getPublicLawManIdCard() != null
								&& this.getPublicLawManIdCard().equals(castOther.getPublicLawManIdCard())))
				&& ((this.getPublicBusiness() == castOther.getPublicBusiness())
						|| (this.getPublicBusiness() != null && castOther.getPublicBusiness() != null
								&& this.getPublicBusiness().equals(castOther.getPublicBusiness())))
				&& ((this.getPublicRegCapital() == castOther.getPublicRegCapital())
						|| (this.getPublicRegCapital() != null && castOther.getPublicRegCapital() != null
								&& this.getPublicRegCapital().equals(castOther.getPublicRegCapital())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBankCode() == null ? 0 : this.getBankCode().hashCode());
		result = 37 * result + (getPublicCustomId() == null ? 0 : this.getPublicCustomId().hashCode());
		result = 37 * result + (getPublicCustomName() == null ? 0 : this.getPublicCustomName().hashCode());
		result = 37 * result + (getPublicLawManName() == null ? 0 : this.getPublicLawManName().hashCode());
		result = 37 * result + (getPublicIdCard() == null ? 0 : this.getPublicIdCard().hashCode());
		result = 37 * result + (getPublicLawManIdCard() == null ? 0 : this.getPublicLawManIdCard().hashCode());
		result = 37 * result + (getPublicBusiness() == null ? 0 : this.getPublicBusiness().hashCode());
		result = 37 * result + (getPublicRegCapital() == null ? 0 : this.getPublicRegCapital().hashCode());
		return result;
	}

}