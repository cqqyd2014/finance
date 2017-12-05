package gov.cqaudit.finance.hibernate.entites;
// Generated 2017-12-5 16:09:39 by Hibernate Tools 5.2.6.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VUserMenuM generated by hbm2java
 */
@Entity
@Table(name = "v_user_menu_m", schema = "public")
public class VUserMenuM implements java.io.Serializable {

	private VUserMenuMId id;

	public VUserMenuM() {
	}

	public VUserMenuM(VUserMenuMId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "menuId", column = @Column(name = "menu_id", length = 4)),
			@AttributeOverride(name = "menuName", column = @Column(name = "menu_name", length = 45)),
			@AttributeOverride(name = "desc", column = @Column(name = "desc", length = 45)),
			@AttributeOverride(name = "userId", column = @Column(name = "user_id", length = 45)) })
	public VUserMenuMId getId() {
		return this.id;
	}

	public void setId(VUserMenuMId id) {
		this.id = id;
	}

}
