package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-2-9 12:39:57 by Hibernate Tools 5.2.3.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * BillMessage generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "bill_message", schema = "public")
public class BillMessage implements java.io.Serializable {

	private String messageUuid;
	private String billUuid;
	private String createMessageUserId;
	private String messageType;
	private Date createDat;
	private String ipAddr;
	private String deptId;
	private String message;

	public BillMessage() {
	}

	public BillMessage(String messageUuid) {
		this.messageUuid = messageUuid;
	}

	public BillMessage(String messageUuid, String billUuid, String createMessageUserId, String messageType,
			Date createDat, String ipAddr, String deptId, String message) {
		this.messageUuid = messageUuid;
		this.billUuid = billUuid;
		this.createMessageUserId = createMessageUserId;
		this.messageType = messageType;
		this.createDat = createDat;
		this.ipAddr = ipAddr;
		this.deptId = deptId;
		this.message = message;
	}

	@Id

	@Column(name = "message_uuid", unique = true, nullable = false, length = 36)
	public String getMessageUuid() {
		return this.messageUuid;
	}

	public void setMessageUuid(String messageUuid) {
		this.messageUuid = messageUuid;
	}

	@Column(name = "bill_uuid", length = 36)
	public String getBillUuid() {
		return this.billUuid;
	}

	public void setBillUuid(String billUuid) {
		this.billUuid = billUuid;
	}

	@Column(name = "create_message_user_id", length = 36)
	public String getCreateMessageUserId() {
		return this.createMessageUserId;
	}

	public void setCreateMessageUserId(String createMessageUserId) {
		this.createMessageUserId = createMessageUserId;
	}

	@Column(name = "message_type", length = 4)
	public String getMessageType() {
		return this.messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_dat", length = 35)
	public Date getCreateDat() {
		return this.createDat;
	}

	public void setCreateDat(Date createDat) {
		this.createDat = createDat;
	}

	@Column(name = "ip_addr", length = 64)
	public String getIpAddr() {
		return this.ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	@Column(name = "dept_id", length = 36)
	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Column(name = "message", length = 1024)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}