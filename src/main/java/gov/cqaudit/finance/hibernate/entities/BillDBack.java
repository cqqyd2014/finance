package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-30 16:21:58 by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * BillDBack generated by hbm2java
 */
@Entity
@Table(name = "bill_d_back", schema = "public")
public class BillDBack implements java.io.Serializable {

	private BillDBackId id;
	private BigDecimal detailCount;
	private String customId;
	private String accountName;

	public BillDBack() {
	}

	public BillDBack(BillDBackId id) {
		this.id = id;
	}

	public BillDBack(BillDBackId id, BigDecimal detailCount, String customId, String accountName) {
		this.id = id;
		this.detailCount = detailCount;
		this.customId = customId;
		this.accountName = accountName;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "billUuid", column = @Column(name = "bill_uuid", nullable = false, length = 36)),
			@AttributeOverride(name = "detailUuid", column = @Column(name = "detail_uuid", nullable = false, length = 36)),
			@AttributeOverride(name = "accountId", column = @Column(name = "account_id", nullable = false, length = 128)) })
	public BillDBackId getId() {
		return this.id;
	}

	public void setId(BillDBackId id) {
		this.id = id;
	}

	@Column(name = "detail_count", precision = 131089, scale = 0)
	public BigDecimal getDetailCount() {
		return this.detailCount;
	}

	public void setDetailCount(BigDecimal detailCount) {
		this.detailCount = detailCount;
	}

	@Column(name = "custom_id", length = 128)
	public String getCustomId() {
		return this.customId;
	}

	public void setCustomId(String customId) {
		this.customId = customId;
	}

	@Column(name = "account_name", length = 256)
	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

}
