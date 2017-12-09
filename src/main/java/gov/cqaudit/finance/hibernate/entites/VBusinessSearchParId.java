package gov.cqaudit.finance.hibernate.entites;
// Generated 2017-12-9 9:31:50 by Hibernate Tools 5.2.6.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VBusinessSearchParId generated by hbm2java
 */
@Embeddable
public class VBusinessSearchParId implements java.io.Serializable {

	private String businessCode;
	private String searchParCode;
	private String SId;
	private String SDesc;
	private String SCode;
	private String SValue;

	public VBusinessSearchParId() {
	}

	public VBusinessSearchParId(String businessCode, String searchParCode, String SId, String SDesc, String SCode,
			String SValue) {
		this.businessCode = businessCode;
		this.searchParCode = searchParCode;
		this.SId = SId;
		this.SDesc = SDesc;
		this.SCode = SCode;
		this.SValue = SValue;
	}

	@Column(name = "business_code", length = 4)
	public String getBusinessCode() {
		return this.businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	@Column(name = "search_par_code", length = 4)
	public String getSearchParCode() {
		return this.searchParCode;
	}

	public void setSearchParCode(String searchParCode) {
		this.searchParCode = searchParCode;
	}

	@Column(name = "s_id", length = 45)
	public String getSId() {
		return this.SId;
	}

	public void setSId(String SId) {
		this.SId = SId;
	}

	@Column(name = "s_desc", length = 45)
	public String getSDesc() {
		return this.SDesc;
	}

	public void setSDesc(String SDesc) {
		this.SDesc = SDesc;
	}

	@Column(name = "s_code", length = 45)
	public String getSCode() {
		return this.SCode;
	}

	public void setSCode(String SCode) {
		this.SCode = SCode;
	}

	@Column(name = "s_value", length = 90)
	public String getSValue() {
		return this.SValue;
	}

	public void setSValue(String SValue) {
		this.SValue = SValue;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VBusinessSearchParId))
			return false;
		VBusinessSearchParId castOther = (VBusinessSearchParId) other;

		return ((this.getBusinessCode() == castOther.getBusinessCode()) || (this.getBusinessCode() != null
				&& castOther.getBusinessCode() != null && this.getBusinessCode().equals(castOther.getBusinessCode())))
				&& ((this.getSearchParCode() == castOther.getSearchParCode())
						|| (this.getSearchParCode() != null && castOther.getSearchParCode() != null
								&& this.getSearchParCode().equals(castOther.getSearchParCode())))
				&& ((this.getSId() == castOther.getSId()) || (this.getSId() != null && castOther.getSId() != null
						&& this.getSId().equals(castOther.getSId())))
				&& ((this.getSDesc() == castOther.getSDesc()) || (this.getSDesc() != null
						&& castOther.getSDesc() != null && this.getSDesc().equals(castOther.getSDesc())))
				&& ((this.getSCode() == castOther.getSCode()) || (this.getSCode() != null
						&& castOther.getSCode() != null && this.getSCode().equals(castOther.getSCode())))
				&& ((this.getSValue() == castOther.getSValue()) || (this.getSValue() != null
						&& castOther.getSValue() != null && this.getSValue().equals(castOther.getSValue())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBusinessCode() == null ? 0 : this.getBusinessCode().hashCode());
		result = 37 * result + (getSearchParCode() == null ? 0 : this.getSearchParCode().hashCode());
		result = 37 * result + (getSId() == null ? 0 : this.getSId().hashCode());
		result = 37 * result + (getSDesc() == null ? 0 : this.getSDesc().hashCode());
		result = 37 * result + (getSCode() == null ? 0 : this.getSCode().hashCode());
		result = 37 * result + (getSValue() == null ? 0 : this.getSValue().hashCode());
		return result;
	}

}