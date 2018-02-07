package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-2-2 15:03:25 by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BusinessSearchParId generated by hbm2java
 */
@Embeddable
public class BusinessSearchParId implements java.io.Serializable {

	private String businessCode;
	private String searchParCode;

	public BusinessSearchParId() {
	}

	public BusinessSearchParId(String businessCode, String searchParCode) {
		this.businessCode = businessCode;
		this.searchParCode = searchParCode;
	}

	@Column(name = "business_code", nullable = false, length = 4)
	public String getBusinessCode() {
		return this.businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	@Column(name = "search_par_code", nullable = false, length = 4)
	public String getSearchParCode() {
		return this.searchParCode;
	}

	public void setSearchParCode(String searchParCode) {
		this.searchParCode = searchParCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BusinessSearchParId))
			return false;
		BusinessSearchParId castOther = (BusinessSearchParId) other;

		return ((this.getBusinessCode() == castOther.getBusinessCode()) || (this.getBusinessCode() != null
				&& castOther.getBusinessCode() != null && this.getBusinessCode().equals(castOther.getBusinessCode())))
				&& ((this.getSearchParCode() == castOther.getSearchParCode())
						|| (this.getSearchParCode() != null && castOther.getSearchParCode() != null
								&& this.getSearchParCode().equals(castOther.getSearchParCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getBusinessCode() == null ? 0 : this.getBusinessCode().hashCode());
		result = 37 * result + (getSearchParCode() == null ? 0 : this.getSearchParCode().hashCode());
		return result;
	}

}
