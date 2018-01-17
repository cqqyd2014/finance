package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-16 13:34:04 by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VDataTransDId generated by hbm2java
 */
@Embeddable
public class VDataTransDId implements java.io.Serializable {

	private String transUuid;
	private String detailUuid;
	private String billUuid;

	public VDataTransDId() {
	}

	public VDataTransDId(String transUuid, String detailUuid, String billUuid) {
		this.transUuid = transUuid;
		this.detailUuid = detailUuid;
		this.billUuid = billUuid;
	}

	@Column(name = "trans_uuid", length = 36)
	public String getTransUuid() {
		return this.transUuid;
	}

	public void setTransUuid(String transUuid) {
		this.transUuid = transUuid;
	}

	@Column(name = "detail_uuid", length = 36)
	public String getDetailUuid() {
		return this.detailUuid;
	}

	public void setDetailUuid(String detailUuid) {
		this.detailUuid = detailUuid;
	}

	@Column(name = "bill_uuid", length = 36)
	public String getBillUuid() {
		return this.billUuid;
	}

	public void setBillUuid(String billUuid) {
		this.billUuid = billUuid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VDataTransDId))
			return false;
		VDataTransDId castOther = (VDataTransDId) other;

		return ((this.getTransUuid() == castOther.getTransUuid()) || (this.getTransUuid() != null
				&& castOther.getTransUuid() != null && this.getTransUuid().equals(castOther.getTransUuid())))
				&& ((this.getDetailUuid() == castOther.getDetailUuid()) || (this.getDetailUuid() != null
						&& castOther.getDetailUuid() != null && this.getDetailUuid().equals(castOther.getDetailUuid())))
				&& ((this.getBillUuid() == castOther.getBillUuid()) || (this.getBillUuid() != null
						&& castOther.getBillUuid() != null && this.getBillUuid().equals(castOther.getBillUuid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTransUuid() == null ? 0 : this.getTransUuid().hashCode());
		result = 37 * result + (getDetailUuid() == null ? 0 : this.getDetailUuid().hashCode());
		result = 37 * result + (getBillUuid() == null ? 0 : this.getBillUuid().hashCode());
		return result;
	}

}
