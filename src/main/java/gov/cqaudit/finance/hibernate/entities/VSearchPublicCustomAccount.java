package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-5 2:10:16 by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VSearchPublicCustomAccount generated by hbm2java
 */
@Entity
@Table(name = "v_search_public_custom_account", schema = "public")
public class VSearchPublicCustomAccount implements java.io.Serializable {

	private VSearchPublicCustomAccountId id;

	public VSearchPublicCustomAccount() {
	}

	public VSearchPublicCustomAccount(VSearchPublicCustomAccountId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "bankCode", column = @Column(name = "bank_code", length = 4)),
			@AttributeOverride(name = "publicAccountName", column = @Column(name = "public_account_name", length = 256)),
			@AttributeOverride(name = "publicAccountId", column = @Column(name = "public_account_id", length = 128)),
			@AttributeOverride(name = "publicCustomId", column = @Column(name = "public_custom_id", length = 128)),
			@AttributeOverride(name = "publicCustomName", column = @Column(name = "public_custom_name", length = 256)),
			@AttributeOverride(name = "detailCount", column = @Column(name = "detail_count")) })
	public VSearchPublicCustomAccountId getId() {
		return this.id;
	}

	public void setId(VSearchPublicCustomAccountId id) {
		this.id = id;
	}

}
