package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-30 16:21:58 by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DataTransDId generated by hbm2java
 */
@Embeddable
public class DataTransDId implements java.io.Serializable {

	private String transUuid;
	private String detailUuid;

	public DataTransDId() {
	}

	public DataTransDId(String transUuid, String detailUuid) {
		this.transUuid = transUuid;
		this.detailUuid = detailUuid;
	}

	@Column(name = "trans_uuid", nullable = false, length = 36)
	public String getTransUuid() {
		return this.transUuid;
	}

	public void setTransUuid(String transUuid) {
		this.transUuid = transUuid;
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
		if (!(other instanceof DataTransDId))
			return false;
		DataTransDId castOther = (DataTransDId) other;

		return ((this.getTransUuid() == castOther.getTransUuid()) || (this.getTransUuid() != null
				&& castOther.getTransUuid() != null && this.getTransUuid().equals(castOther.getTransUuid())))
				&& ((this.getDetailUuid() == castOther.getDetailUuid())
						|| (this.getDetailUuid() != null && castOther.getDetailUuid() != null
								&& this.getDetailUuid().equals(castOther.getDetailUuid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTransUuid() == null ? 0 : this.getTransUuid().hashCode());
		result = 37 * result + (getDetailUuid() == null ? 0 : this.getDetailUuid().hashCode());
		return result;
	}

}
