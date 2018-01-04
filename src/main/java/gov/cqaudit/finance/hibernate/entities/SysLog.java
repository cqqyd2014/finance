package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-5 1:05:23 by Hibernate Tools 5.2.3.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SysLog generated by hbm2java
 */
@Entity
@Table(name = "sys_log", schema = "public")
public class SysLog implements java.io.Serializable {

	private String uuid;
	private Date actionTime;
	private String logMsg;
	private String logType;
	private String userId;

	public SysLog() {
	}

	public SysLog(String uuid) {
		this.uuid = uuid;
	}

	public SysLog(String uuid, Date actionTime, String logMsg, String logType, String userId) {
		this.uuid = uuid;
		this.actionTime = actionTime;
		this.logMsg = logMsg;
		this.logType = logType;
		this.userId = userId;
	}

	@Id

	@Column(name = "uuid", unique = true, nullable = false, length = 36)
	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "action_time", length = 35)
	public Date getActionTime() {
		return this.actionTime;
	}

	public void setActionTime(Date actionTime) {
		this.actionTime = actionTime;
	}

	@Column(name = "log_msg")
	public String getLogMsg() {
		return this.logMsg;
	}

	public void setLogMsg(String logMsg) {
		this.logMsg = logMsg;
	}

	@Column(name = "log_type", length = 45)
	public String getLogType() {
		return this.logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	@Column(name = "user_id", length = 36)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
