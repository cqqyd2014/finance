package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-16 13:34:04 by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * CatalogTableField generated by hbm2java
 */
@Entity
@Table(name = "catalog_table_field", schema = "public")
public class CatalogTableField implements java.io.Serializable {

	private CatalogTableFieldId id;
	private String fieldType;
	private String fieldName;
	private Boolean code;

	public CatalogTableField() {
	}

	public CatalogTableField(CatalogTableFieldId id) {
		this.id = id;
	}

	public CatalogTableField(CatalogTableFieldId id, String fieldType, String fieldName, Boolean code) {
		this.id = id;
		this.fieldType = fieldType;
		this.fieldName = fieldName;
		this.code = code;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "tableEName", column = @Column(name = "table_e_name", nullable = false, length = 128)),
			@AttributeOverride(name = "fieldEName", column = @Column(name = "field_e_name", nullable = false, length = 128)) })
	public CatalogTableFieldId getId() {
		return this.id;
	}

	public void setId(CatalogTableFieldId id) {
		this.id = id;
	}

	@Column(name = "field_type", length = 4)
	public String getFieldType() {
		return this.fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	@Column(name = "field_name", length = 128)
	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Column(name = "code")
	public Boolean getCode() {
		return this.code;
	}

	public void setCode(Boolean code) {
		this.code = code;
	}

}
