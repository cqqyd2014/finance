package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-30 16:21:58 by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CatalogTable generated by hbm2java
 */
@Entity
@Table(name = "catalog_table", schema = "public")
public class CatalogTable implements java.io.Serializable {

	private String tableCode;
	private String tableEName;
	private String tableName;

	public CatalogTable() {
	}

	public CatalogTable(String tableCode) {
		this.tableCode = tableCode;
	}

	public CatalogTable(String tableCode, String tableEName, String tableName) {
		this.tableCode = tableCode;
		this.tableEName = tableEName;
		this.tableName = tableName;
	}

	@Id

	@Column(name = "table_code", unique = true, nullable = false, length = 4)
	public String getTableCode() {
		return this.tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	@Column(name = "table_e_name", length = 128)
	public String getTableEName() {
		return this.tableEName;
	}

	public void setTableEName(String tableEName) {
		this.tableEName = tableEName;
	}

	@Column(name = "table_name", length = 128)
	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
