package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-2 21:10:43 by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * SysRoleMenuD generated by hbm2java
 */
@Entity
@Table(name = "sys_role_menu_d", schema = "public")
public class SysRoleMenuD implements java.io.Serializable {

	private SysRoleMenuDId id;

	public SysRoleMenuD() {
	}

	public SysRoleMenuD(SysRoleMenuDId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "roleId", column = @Column(name = "role_id", nullable = false, length = 45)),
			@AttributeOverride(name = "menuId", column = @Column(name = "menu_id", nullable = false, length = 4)),
			@AttributeOverride(name = "menuDId", column = @Column(name = "menu_d_id", nullable = false, length = 4)) })
	public SysRoleMenuDId getId() {
		return this.id;
	}

	public void setId(SysRoleMenuDId id) {
		this.id = id;
	}

}
