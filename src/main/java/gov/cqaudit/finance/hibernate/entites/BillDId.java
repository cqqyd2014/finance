package gov.cqaudit.finance.hibernate.entites;
// Generated 2017-12-10 17:02:37 by Hibernate Tools 5.2.6.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BillDId generated by hbm2java
 */
@Embeddable
public class BillDId implements java.io.Serializable {

	private String billUuid;
	private String detailUuid;

	public BillDId() {
	}

	public BillDId(String billUuid, String detailUuid) {
		this.billUuid = billUuid;
		this.detailUuid = detailUuid;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BillDId))
			return false;
		BillDId castOther = (BillDId) other;

		return ((this.getBillUuid() == castOther.getBillUuid()) || (this.getBillUuid() != null
				&& castOther.getBillUuid() != null && this.getBillUuid().equals(castOther.getBillUuid())))
				&& ((this.getDetailUuid() == castOther.getDetailUuid())
						|| (this.getDetailUuid() != null && castOther.getDetailUuid() != null
								&& this.getDetailUuid().equals(castOther.getDetailUuid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBillUuid() == null ? 0 : this.getBillUuid().hashCode());
		result = 37 * result + (getDetailUuid() == null ? 0 : this.getDetailUuid().hashCode());
		return result;
	}

}
