package gov.cqaudit.finance.hibernate.entites;
// Generated 2017-12-10 17:02:37 by Hibernate Tools 5.2.6.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Picture generated by hbm2java
 */
@Entity
@Table(name = "picture", schema = "public")
public class Picture implements java.io.Serializable {

	private String uuid;
	private Date opDat;
	private String userId;
	private String billUuid;
	private Boolean effective;
	private String fileType;
	private String fileName;
	private Long fileLength;
	private byte[] binData;

	public Picture() {
	}

	public Picture(String uuid) {
		this.uuid = uuid;
	}

	public Picture(String uuid, Date opDat, String userId, String billUuid, Boolean effective, String fileType,
			String fileName, Long fileLength, byte[] binData) {
		this.uuid = uuid;
		this.opDat = opDat;
		this.userId = userId;
		this.billUuid = billUuid;
		this.effective = effective;
		this.fileType = fileType;
		this.fileName = fileName;
		this.fileLength = fileLength;
		this.binData = binData;
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
	@Column(name = "op_dat", length = 35)
	public Date getOpDat() {
		return this.opDat;
	}

	public void setOpDat(Date opDat) {
		this.opDat = opDat;
	}

	@Column(name = "user_id", length = 36)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "bill_uuid", length = 36)
	public String getBillUuid() {
		return this.billUuid;
	}

	public void setBillUuid(String billUuid) {
		this.billUuid = billUuid;
	}

	@Column(name = "effective")
	public Boolean getEffective() {
		return this.effective;
	}

	public void setEffective(Boolean effective) {
		this.effective = effective;
	}

	@Column(name = "file_type", length = 1024)
	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Column(name = "file_name", length = 1024)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "file_length")
	public Long getFileLength() {
		return this.fileLength;
	}

	public void setFileLength(Long fileLength) {
		this.fileLength = fileLength;
	}

	@Column(name = "bin_data")
	public byte[] getBinData() {
		return this.binData;
	}

	public void setBinData(byte[] binData) {
		this.binData = binData;
	}

}
