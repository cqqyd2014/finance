package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-2-2 15:03:25 by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VDataTransD generated by hbm2java
 */
@Entity
@Table(name = "v_data_trans_d", schema = "public")
public class VDataTransD implements java.io.Serializable {

	private VDataTransDId id;

	public VDataTransD() {
	}

	public VDataTransD(VDataTransDId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "transUuid", column = @Column(name = "trans_uuid", length = 36)),
			@AttributeOverride(name = "detailUuid", column = @Column(name = "detail_uuid", length = 36)),
			@AttributeOverride(name = "billUuid", column = @Column(name = "bill_uuid", length = 36)) })
	public VDataTransDId getId() {
		return this.id;
	}

	public void setId(VDataTransDId id) {
		this.id = id;
	}

}
