package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-5 1:05:23 by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VSearchPrivateCustomAccount generated by hbm2java
 */
@Entity
@Table(name = "v_search_private_custom_account", schema = "public")
public class VSearchPrivateCustomAccount implements java.io.Serializable {

	private VSearchPrivateCustomAccountId id;

	public VSearchPrivateCustomAccount() {
	}

	public VSearchPrivateCustomAccount(VSearchPrivateCustomAccountId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "bankCode", column = @Column(name = "bank_code", length = 4)),
			@AttributeOverride(name = "privateAccountName", column = @Column(name = "private_account_name", length = 256)),
			@AttributeOverride(name = "privateAccountId", column = @Column(name = "private_account_id", length = 128)),
			@AttributeOverride(name = "privateCustomId", column = @Column(name = "private_custom_id", length = 128)),
			@AttributeOverride(name = "privateIdCard", column = @Column(name = "private_id_card", length = 64)),
			@AttributeOverride(name = "detailCount", column = @Column(name = "detail_count")),
			@AttributeOverride(name = "privateCardNo", column = @Column(name = "private_card_no", length = 64)) })
	public VSearchPrivateCustomAccountId getId() {
		return this.id;
	}

	public void setId(VSearchPrivateCustomAccountId id) {
		this.id = id;
	}

}
