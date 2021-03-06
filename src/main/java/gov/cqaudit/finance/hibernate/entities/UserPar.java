package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-2-9 12:39:57 by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * UserPar generated by hbm2java
 */
@Entity
@Table(name = "user_par", schema = "public")
public class UserPar implements java.io.Serializable {

	private UserParId id;
	private String parDesc;
	private String parValue;
	private String parType;

	public UserPar() {
	}

	public UserPar(UserParId id) {
		this.id = id;
	}

	public UserPar(UserParId id, String parDesc, String parValue, String parType) {
		this.id = id;
		this.parDesc = parDesc;
		this.parValue = parValue;
		this.parType = parType;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false, length = 45)),
			@AttributeOverride(name = "parCode", column = @Column(name = "par_code", nullable = false, length = 45)) })
	public UserParId getId() {
		return this.id;
	}

	public void setId(UserParId id) {
		this.id = id;
	}

	@Column(name = "par_desc", length = 512)
	public String getParDesc() {
		return this.parDesc;
	}

	public void setParDesc(String parDesc) {
		this.parDesc = parDesc;
	}

	@Column(name = "par_value")
	public String getParValue() {
		return this.parValue;
	}

	public void setParValue(String parValue) {
		this.parValue = parValue;
	}

	@Column(name = "par_type", length = 4)
	public String getParType() {
		return this.parType;
	}

	public void setParType(String parType) {
		this.parType = parType;
	}

}
