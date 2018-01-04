package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-5 1:05:23 by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CatalogTableFieldId generated by hbm2java
 */
@Embeddable
public class CatalogTableFieldId implements java.io.Serializable {

	private String tableEName;
	private String fieldEName;

	public CatalogTableFieldId() {
	}

	public CatalogTableFieldId(String tableEName, String fieldEName) {
		this.tableEName = tableEName;
		this.fieldEName = fieldEName;
	}

	@Column(name = "table_e_name", nullable = false, length = 128)
	public String getTableEName() {
		return this.tableEName;
	}

	public void setTableEName(String tableEName) {
		this.tableEName = tableEName;
	}

	@Column(name = "field_e_name", nullable = false, length = 128)
	public String getFieldEName() {
		return this.fieldEName;
	}

	public void setFieldEName(String fieldEName) {
		this.fieldEName = fieldEName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CatalogTableFieldId))
			return false;
		CatalogTableFieldId castOther = (CatalogTableFieldId) other;

		return ((this.getTableEName() == castOther.getTableEName()) || (this.getTableEName() != null
				&& castOther.getTableEName() != null && this.getTableEName().equals(castOther.getTableEName())))
				&& ((this.getFieldEName() == castOther.getFieldEName())
						|| (this.getFieldEName() != null && castOther.getFieldEName() != null
								&& this.getFieldEName().equals(castOther.getFieldEName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTableEName() == null ? 0 : this.getTableEName().hashCode());
		result = 37 * result + (getFieldEName() == null ? 0 : this.getFieldEName().hashCode());
		return result;
	}

}
