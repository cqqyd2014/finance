package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-2-9 12:39:57 by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * DataCorePublicCustomBase generated by hbm2java
 */
@Entity
@Table(name = "data_core_public_custom_base", schema = "public")
public class DataCorePublicCustomBase implements java.io.Serializable {

	private DataCorePublicCustomBaseId id;
	private String publicCustomName;
	private String publicLawManName;
	private String publicIdCard;
	private String publicLawManIdCard;
	private String publicBusiness;
	private BigDecimal publicRegCapital;

	public DataCorePublicCustomBase() {
	}

	public DataCorePublicCustomBase(DataCorePublicCustomBaseId id) {
		this.id = id;
	}

	public DataCorePublicCustomBase(DataCorePublicCustomBaseId id, String publicCustomName, String publicLawManName,
			String publicIdCard, String publicLawManIdCard, String publicBusiness, BigDecimal publicRegCapital) {
		this.id = id;
		this.publicCustomName = publicCustomName;
		this.publicLawManName = publicLawManName;
		this.publicIdCard = publicIdCard;
		this.publicLawManIdCard = publicLawManIdCard;
		this.publicBusiness = publicBusiness;
		this.publicRegCapital = publicRegCapital;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "bankCode", column = @Column(name = "bank_code", nullable = false, length = 4)),
			@AttributeOverride(name = "publicCustomId", column = @Column(name = "public_custom_id", nullable = false, length = 128)) })
	public DataCorePublicCustomBaseId getId() {
		return this.id;
	}

	public void setId(DataCorePublicCustomBaseId id) {
		this.id = id;
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

}
