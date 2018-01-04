package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-5 1:05:23 by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysRole generated by hbm2java
 */
@Entity
@Table(name = "sys_role", schema = "public")
public class SysRole implements java.io.Serializable {

	private String roleId;
	private String roleName;

	public SysRole() {
	}

	public SysRole(String roleId) {
		this.roleId = roleId;
	}

	public SysRole(String roleId, String roleName) {
		this.roleId = roleId;
		this.roleName = roleName;
	}

	@Id

	@Column(name = "role_id", unique = true, nullable = false, length = 45)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role_name", length = 45)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
