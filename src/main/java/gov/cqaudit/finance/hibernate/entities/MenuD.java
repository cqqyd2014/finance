package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-5 1:05:23 by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * MenuD generated by hbm2java
 */
@Entity
@Table(name = "menu_d", schema = "public")
public class MenuD implements java.io.Serializable {

	private MenuDId id;
	private String menuDName;
	private String menuDJsMethod;
	private String menuDJsUrl;
	private Integer orderId;
	private Boolean webAttention;
	private String webAttentionTips;
	private String getNumClass;
	private String getNumMethod;
	private String icon;

	public MenuD() {
	}

	public MenuD(MenuDId id) {
		this.id = id;
	}

	public MenuD(MenuDId id, String menuDName, String menuDJsMethod, String menuDJsUrl, Integer orderId,
			Boolean webAttention, String webAttentionTips, String getNumClass, String getNumMethod, String icon) {
		this.id = id;
		this.menuDName = menuDName;
		this.menuDJsMethod = menuDJsMethod;
		this.menuDJsUrl = menuDJsUrl;
		this.orderId = orderId;
		this.webAttention = webAttention;
		this.webAttentionTips = webAttentionTips;
		this.getNumClass = getNumClass;
		this.getNumMethod = getNumMethod;
		this.icon = icon;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "menuId", column = @Column(name = "menu_id", nullable = false, length = 4)),
			@AttributeOverride(name = "menuDId", column = @Column(name = "menu_d_id", nullable = false, length = 4)) })
	public MenuDId getId() {
		return this.id;
	}

	public void setId(MenuDId id) {
		this.id = id;
	}

	@Column(name = "menu_d_name", length = 45)
	public String getMenuDName() {
		return this.menuDName;
	}

	public void setMenuDName(String menuDName) {
		this.menuDName = menuDName;
	}

	@Column(name = "menu_d_js_method", length = 45)
	public String getMenuDJsMethod() {
		return this.menuDJsMethod;
	}

	public void setMenuDJsMethod(String menuDJsMethod) {
		this.menuDJsMethod = menuDJsMethod;
	}

	@Column(name = "menu_d_js_url", length = 256)
	public String getMenuDJsUrl() {
		return this.menuDJsUrl;
	}

	public void setMenuDJsUrl(String menuDJsUrl) {
		this.menuDJsUrl = menuDJsUrl;
	}

	@Column(name = "order_id")
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "web_attention")
	public Boolean getWebAttention() {
		return this.webAttention;
	}

	public void setWebAttention(Boolean webAttention) {
		this.webAttention = webAttention;
	}

	@Column(name = "web_attention_tips", length = 1024)
	public String getWebAttentionTips() {
		return this.webAttentionTips;
	}

	public void setWebAttentionTips(String webAttentionTips) {
		this.webAttentionTips = webAttentionTips;
	}

	@Column(name = "get_num_class", length = 1024)
	public String getGetNumClass() {
		return this.getNumClass;
	}

	public void setGetNumClass(String getNumClass) {
		this.getNumClass = getNumClass;
	}

	@Column(name = "get_num_method", length = 1024)
	public String getGetNumMethod() {
		return this.getNumMethod;
	}

	public void setGetNumMethod(String getNumMethod) {
		this.getNumMethod = getNumMethod;
	}

	@Column(name = "icon", length = 32)
	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
