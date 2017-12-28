package gov.cqaudit.finance.hibernate.entities;
// Generated 2017-12-28 13:03:11 by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * DataTransD generated by hbm2java
 */
@Entity
@Table(name = "data_trans_d", schema = "public")
public class DataTransD implements java.io.Serializable {

	private DataTransDId id;
	private String billUuid;

	public DataTransD() {
	}

	public DataTransD(DataTransDId id) {
		this.id = id;
	}

	public DataTransD(DataTransDId id, String billUuid) {
		this.id = id;
		this.billUuid = billUuid;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "transUuid", column = @Column(name = "trans_uuid", nullable = false, length = 36)),
			@AttributeOverride(name = "detailUuid", column = @Column(name = "detail_uuid", nullable = false, length = 36)) })
	public DataTransDId getId() {
		return this.id;
	}

	public void setId(DataTransDId id) {
		this.id = id;
	}

	@Column(name = "bill_uuid", length = 36)
	public String getBillUuid() {
		return this.billUuid;
	}

	public void setBillUuid(String billUuid) {
		this.billUuid = billUuid;
	}

}
