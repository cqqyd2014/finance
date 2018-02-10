package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-2-9 12:39:57 by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VDataCorePrivateAccountTradeDetail generated by hbm2java
 */
@Entity
@Table(name = "v_data_core_private_account_trade_detail", schema = "public")
public class VDataCorePrivateAccountTradeDetail implements java.io.Serializable {

	private VDataCorePrivateAccountTradeDetailId id;

	public VDataCorePrivateAccountTradeDetail() {
	}

	public VDataCorePrivateAccountTradeDetail(VDataCorePrivateAccountTradeDetailId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "bankCode", column = @Column(name = "bank_code", length = 4)),
			@AttributeOverride(name = "bankCodeName", column = @Column(name = "bank_code_name", length = 90)),
			@AttributeOverride(name = "privateAccountId", column = @Column(name = "private_account_id", length = 128)),
			@AttributeOverride(name = "privateTradeSeq", column = @Column(name = "private_trade_seq", length = 128)),
			@AttributeOverride(name = "privateAmount", column = @Column(name = "private_amount", precision = 131089, scale = 0)),
			@AttributeOverride(name = "privateOpAccountId", column = @Column(name = "private_op_account_id", length = 128)),
			@AttributeOverride(name = "privateOpBankId", column = @Column(name = "private_op_bank_id", length = 128)),
			@AttributeOverride(name = "privateOpBankName", column = @Column(name = "private_op_bank_name", length = 256)),
			@AttributeOverride(name = "privateOpAccountName", column = @Column(name = "private_op_account_name", length = 256)),
			@AttributeOverride(name = "privateTradeCode", column = @Column(name = "private_trade_code", length = 128)),
			@AttributeOverride(name = "privateTradeName", column = @Column(name = "private_trade_name", length = 256)),
			@AttributeOverride(name = "privateTradeDat", column = @Column(name = "private_trade_dat", length = 35)),
			@AttributeOverride(name = "privateBalance", column = @Column(name = "private_balance", precision = 131089, scale = 0)),
			@AttributeOverride(name = "privateBankOrgId", column = @Column(name = "private_bank_org_id", length = 64)),
			@AttributeOverride(name = "privateBankOrgName", column = @Column(name = "private_bank_org_name", length = 128)),
			@AttributeOverride(name = "privateRemark", column = @Column(name = "private_remark", length = 2048)),
			@AttributeOverride(name = "privateAccountName", column = @Column(name = "private_account_name", length = 256)) })
	public VDataCorePrivateAccountTradeDetailId getId() {
		return this.id;
	}

	public void setId(VDataCorePrivateAccountTradeDetailId id) {
		this.id = id;
	}

}
