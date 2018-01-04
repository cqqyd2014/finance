package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-5 1:05:23 by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VBillDBack generated by hbm2java
 */
@Entity
@Table(name = "v_bill_d_back", schema = "public")
public class VBillDBack implements java.io.Serializable {

	private VBillDBackId id;

	public VBillDBack() {
	}

	public VBillDBack(VBillDBackId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "bankName", column = @Column(name = "bank_name", length = 90)),
			@AttributeOverride(name = "searchParName", column = @Column(name = "search_par_name", length = 90)),
			@AttributeOverride(name = "accountName", column = @Column(name = "account_name", length = 256)),
			@AttributeOverride(name = "businessName", column = @Column(name = "business_name", length = 90)),
			@AttributeOverride(name = "billUuid", column = @Column(name = "bill_uuid", length = 36)),
			@AttributeOverride(name = "detailUuid", column = @Column(name = "detail_uuid", length = 36)),
			@AttributeOverride(name = "bankCode", column = @Column(name = "bank_code", length = 4)),
			@AttributeOverride(name = "businessCode", column = @Column(name = "business_code", length = 4)),
			@AttributeOverride(name = "searchParCode", column = @Column(name = "search_par_code", length = 4)),
			@AttributeOverride(name = "searchParValue", column = @Column(name = "search_par_value", length = 1024)),
			@AttributeOverride(name = "effective", column = @Column(name = "effective")),
			@AttributeOverride(name = "unEffectiveDat", column = @Column(name = "un_effective_dat", length = 35)),
			@AttributeOverride(name = "unEffectiveUserid", column = @Column(name = "un_effective_userid", length = 36)),
			@AttributeOverride(name = "createUserid", column = @Column(name = "create_userid", length = 36)),
			@AttributeOverride(name = "createDat", column = @Column(name = "create_dat", length = 35)),
			@AttributeOverride(name = "accountId", column = @Column(name = "account_id", length = 128)),
			@AttributeOverride(name = "detailCount", column = @Column(name = "detail_count", precision = 131089, scale = 0)),
			@AttributeOverride(name = "customId", column = @Column(name = "custom_id", length = 128)) })
	public VBillDBackId getId() {
		return this.id;
	}

	public void setId(VBillDBackId id) {
		this.id = id;
	}

}
