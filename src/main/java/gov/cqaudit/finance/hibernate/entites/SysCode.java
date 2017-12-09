package gov.cqaudit.finance.hibernate.entites;
// Generated 2017-12-9 9:31:50 by Hibernate Tools 5.2.6.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * SysCode generated by hbm2java
 */
@Entity
@Table(name = "sys_code", schema = "public")
public class SysCode implements java.io.Serializable {

	private SysCodeId id;
	private String SDesc;
	private String SValue;

	public SysCode() {
	}

	public SysCode(SysCodeId id) {
		this.id = id;
	}

	public SysCode(SysCodeId id, String SDesc, String SValue) {
		this.id = id;
		this.SDesc = SDesc;
		this.SValue = SValue;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "SId", column = @Column(name = "s_id", nullable = false, length = 45)),
			@AttributeOverride(name = "SCode", column = @Column(name = "s_code", nullable = false, length = 45)) })
	public SysCodeId getId() {
		return this.id;
	}

	public void setId(SysCodeId id) {
		this.id = id;
	}

	@Column(name = "s_desc", length = 45)
	public String getSDesc() {
		return this.SDesc;
	}

	public void setSDesc(String SDesc) {
		this.SDesc = SDesc;
	}

	@Column(name = "s_value", length = 90)
	public String getSValue() {
		return this.SValue;
	}

	public void setSValue(String SValue) {
		this.SValue = SValue;
	}

}
