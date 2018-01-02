package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-2 21:10:43 by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BillDBackId generated by hbm2java
 */
@Embeddable
public class BillDBackId implements java.io.Serializable {

	private String billUuid;
	private String detailUuid;
	private String accountId;

	public BillDBackId() {
	}

	public BillDBackId(String billUuid, String detailUuid, String accountId) {
		this.billUuid = billUuid;
		this.detailUuid = detailUuid;
		this.accountId = accountId;
	}

	@Column(name = "bill_uuid", nullable = false, length = 36)
	public String getBillUuid() {
		return this.billUuid;
	}

	public void setBillUuid(String billUuid) {
		this.billUuid = billUuid;
	}

	@Column(name = "detail_uuid", nullable = false, length = 36)
	public String getDetailUuid() {
		return this.detailUuid;
	}

	public void setDetailUuid(String detailUuid) {
		this.detailUuid = detailUuid;
	}

	@Column(name = "account_id", nullable = false, length = 128)
	public String getAccountId() {
		return this.accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BillDBackId))
			return false;
		BillDBackId castOther = (BillDBackId) other;

		return ((this.getBillUuid() == castOther.getBillUuid()) || (this.getBillUuid() != null
				&& castOther.getBillUuid() != null && this.getBillUuid().equals(castOther.getBillUuid())))
				&& ((this.getDetailUuid() == castOther.getDetailUuid()) || (this.getDetailUuid() != null
						&& castOther.getDetailUuid() != null && this.getDetailUuid().equals(castOther.getDetailUuid())))
				&& ((this.getAccountId() == castOther.getAccountId()) || (this.getAccountId() != null
						&& castOther.getAccountId() != null && this.getAccountId().equals(castOther.getAccountId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBillUuid() == null ? 0 : this.getBillUuid().hashCode());
		result = 37 * result + (getDetailUuid() == null ? 0 : this.getDetailUuid().hashCode());
		result = 37 * result + (getAccountId() == null ? 0 : this.getAccountId().hashCode());
		return result;
	}

}