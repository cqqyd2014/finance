package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-2-9 12:39:57 by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MenuM generated by hbm2java
 */
@Entity
@Table(name = "menu_m", schema = "public")
public class MenuM implements java.io.Serializable {

	private String menuId;
	private String menuName;
	private String desc;
	private String orderId;

	public MenuM() {
	}

	public MenuM(String menuId) {
		this.menuId = menuId;
	}

	public MenuM(String menuId, String menuName, String desc, String orderId) {
		this.menuId = menuId;
		this.menuName = menuName;
		this.desc = desc;
		this.orderId = orderId;
	}

	@Id

	@Column(name = "menu_id", unique = true, nullable = false, length = 4)
	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	@Column(name = "menu_name", length = 45)
	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Column(name = "desc", length = 45)
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "order_id", length = 4)
	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

}
