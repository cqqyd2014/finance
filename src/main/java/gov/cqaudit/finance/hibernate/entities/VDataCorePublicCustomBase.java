package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-2-9 12:39:57 by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VDataCorePublicCustomBase generated by hbm2java
 */
@Entity
@Table(name = "v_data_core_public_custom_base", schema = "public")
public class VDataCorePublicCustomBase implements java.io.Serializable {

	private VDataCorePublicCustomBaseId id;

	public VDataCorePublicCustomBase() {
	}

	public VDataCorePublicCustomBase(VDataCorePublicCustomBaseId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "bankCode", column = @Column(name = "bank_code", length = 4)),
			@AttributeOverride(name = "publicCustomId", column = @Column(name = "public_custom_id", length = 128)),
			@AttributeOverride(name = "publicCustomName", column = @Column(name = "public_custom_name", length = 256)),
			@AttributeOverride(name = "publicLawManName", column = @Column(name = "public_law_man_name", length = 128)),
			@AttributeOverride(name = "publicIdCard", column = @Column(name = "public_id_card", length = 128)),
			@AttributeOverride(name = "publicLawManIdCard", column = @Column(name = "public_law_man_id_card", length = 128)),
			@AttributeOverride(name = "publicBusiness", column = @Column(name = "public_business", length = 1024)),
			@AttributeOverride(name = "publicRegCapital", column = @Column(name = "public_reg_capital", precision = 131089, scale = 0)) })
	public VDataCorePublicCustomBaseId getId() {
		return this.id;
	}

	public void setId(VDataCorePublicCustomBaseId id) {
		this.id = id;
	}

}
