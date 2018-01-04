package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-5 1:05:23 by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VBillD generated by hbm2java
 */
@Entity
@Table(name = "v_bill_d", schema = "public")
public class VBillD implements java.io.Serializable {

	private VBillDId id;

	public VBillD() {
	}

	public VBillD(VBillDId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "effective", column = @Column(name = "effective")),
			@AttributeOverride(name = "unEffectiveDat", column = @Column(name = "un_effective_dat", length = 35)),
			@AttributeOverride(name = "unEffectiveUserid", column = @Column(name = "un_effective_userid", length = 36)),
			@AttributeOverride(name = "createDat", column = @Column(name = "create_dat", length = 35)),
			@AttributeOverride(name = "createUserid", column = @Column(name = "create_userid", length = 36)),
			@AttributeOverride(name = "billUuid", column = @Column(name = "bill_uuid", length = 36)),
			@AttributeOverride(name = "detailUuid", column = @Column(name = "detail_uuid", length = 36)),
			@AttributeOverride(name = "bankCode", column = @Column(name = "bank_code", length = 4)),
			@AttributeOverride(name = "businessCode", column = @Column(name = "business_code", length = 4)),
			@AttributeOverride(name = "searchParCode", column = @Column(name = "search_par_code", length = 4)),
			@AttributeOverride(name = "searchParValue", column = @Column(name = "search_par_value", length = 1024)),
			@AttributeOverride(name = "bankName", column = @Column(name = "bank_name", length = 90)),
			@AttributeOverride(name = "businessName", column = @Column(name = "business_name", length = 90)),
			@AttributeOverride(name = "searchParName", column = @Column(name = "search_par_name", length = 90)) })
	public VBillDId getId() {
		return this.id;
	}

	public void setId(VBillDId id) {
		this.id = id;
	}

}
