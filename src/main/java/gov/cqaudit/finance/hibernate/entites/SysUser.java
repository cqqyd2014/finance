package gov.cqaudit.finance.hibernate.entites;
// Generated 2017-12-5 16:09:39 by Hibernate Tools 5.2.6.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SysUser generated by hbm2java
 */
@Entity
@Table(name = "sys_user", schema = "public")
public class SysUser implements java.io.Serializable {

	private String id;
	private String name;
	private Date createTime;
	private String pwd;
	private String userLogin;
	private String tel;
	private Boolean effective;
	private Boolean online;
	private Date lastOnlineTime;
	private String email;

	public SysUser() {
	}

	public SysUser(String id) {
		this.id = id;
	}

	public SysUser(String id, String name, Date createTime, String pwd, String userLogin, String tel, Boolean effective,
			Boolean online, Date lastOnlineTime, String email) {
		this.id = id;
		this.name = name;
		this.createTime = createTime;
		this.pwd = pwd;
		this.userLogin = userLogin;
		this.tel = tel;
		this.effective = effective;
		this.online = online;
		this.lastOnlineTime = lastOnlineTime;
		this.email = email;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 35)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "pwd", length = 45)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "user_login", length = 45)
	public String getUserLogin() {
		return this.userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	@Column(name = "tel", length = 45)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "effective")
	public Boolean getEffective() {
		return this.effective;
	}

	public void setEffective(Boolean effective) {
		this.effective = effective;
	}

	@Column(name = "online")
	public Boolean getOnline() {
		return this.online;
	}

	public void setOnline(Boolean online) {
		this.online = online;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_online_time", length = 35)
	public Date getLastOnlineTime() {
		return this.lastOnlineTime;
	}

	public void setLastOnlineTime(Date lastOnlineTime) {
		this.lastOnlineTime = lastOnlineTime;
	}

	@Column(name = "email", length = 521)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
