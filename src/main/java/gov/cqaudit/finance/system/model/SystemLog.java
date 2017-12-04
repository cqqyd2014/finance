package gov.cqaudit.finance.system.model;

import java.util.Date;

public class SystemLog {
	String user_id;
	java.util.Date action_time;
	String log_msg;
	String log_type;
	public SystemLog(String user_id, Date action_time, String log_msg, String log_type, String uuid) {
		super();
		this.user_id = user_id;
		this.action_time = action_time;
		this.log_msg = log_msg;
		this.log_type = log_type;
		this.uuid = uuid;
	}
	String uuid;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public java.util.Date getAction_time() {
		return action_time;
	}
	public void setAction_time(java.util.Date action_time) {
		this.action_time = action_time;
	}
	public String getLog_msg() {
		return log_msg;
	}
	public void setLog_msg(String log_msg) {
		this.log_msg = log_msg;
	}
	public String getLog_type() {
		return log_type;
	}
	public void setLog_type(String log_type) {
		this.log_type = log_type;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
