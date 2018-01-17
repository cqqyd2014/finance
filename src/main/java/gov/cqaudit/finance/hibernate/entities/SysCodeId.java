package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-16 13:34:04 by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SysCodeId generated by hbm2java
 */
@Embeddable
public class SysCodeId implements java.io.Serializable {

	private String SId;
	private String SCode;

	public SysCodeId() {
	}

	public SysCodeId(String SId, String SCode) {
		this.SId = SId;
		this.SCode = SCode;
	}

	@Column(name = "s_id", nullable = false, length = 45)
	public String getSId() {
		return this.SId;
	}

	public void setSId(String SId) {
		this.SId = SId;
	}

	@Column(name = "s_code", nullable = false, length = 45)
	public String getSCode() {
		return this.SCode;
	}

	public void setSCode(String SCode) {
		this.SCode = SCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SysCodeId))
			return false;
		SysCodeId castOther = (SysCodeId) other;

		return ((this.getSId() == castOther.getSId())
				|| (this.getSId() != null && castOther.getSId() != null && this.getSId().equals(castOther.getSId())))
				&& ((this.getSCode() == castOther.getSCode()) || (this.getSCode() != null
						&& castOther.getSCode() != null && this.getSCode().equals(castOther.getSCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getSId() == null ? 0 : this.getSId().hashCode());
		result = 37 * result + (getSCode() == null ? 0 : this.getSCode().hashCode());
		return result;
	}

}
