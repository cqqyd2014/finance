package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-5 1:05:23 by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VDataCorePrivateAccountInfo generated by hbm2java
 */
@Entity
@Table(name = "v_data_core_private_account_info", schema = "public")
public class VDataCorePrivateAccountInfo implements java.io.Serializable {

	private VDataCorePrivateAccountInfoId id;

	public VDataCorePrivateAccountInfo() {
	}

	public VDataCorePrivateAccountInfo(VDataCorePrivateAccountInfoId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "privateAccountId", column = @Column(name = "private_account_id", length = 128)),
			@AttributeOverride(name = "privateAccountName", column = @Column(name = "private_account_name", length = 256)),
			@AttributeOverride(name = "privateCustomId", column = @Column(name = "private_custom_id", length = 128)),
			@AttributeOverride(name = "privateCardNo", column = @Column(name = "private_card_no", length = 64)),
			@AttributeOverride(name = "bankCode", column = @Column(name = "bank_code", length = 4)),
			@AttributeOverride(name = "privateOpenDat", column = @Column(name = "private_open_dat", length = 35)),
			@AttributeOverride(name = "privateCloseDat", column = @Column(name = "private_close_dat", length = 35)),
			@AttributeOverride(name = "privateAcountStatus", column = @Column(name = "private_acount_status", length = 32)) })
	public VDataCorePrivateAccountInfoId getId() {
		return this.id;
	}

	public void setId(VDataCorePrivateAccountInfoId id) {
		this.id = id;
	}

}
