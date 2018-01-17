package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-16 13:34:04 by Hibernate Tools 5.2.3.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DataTransM generated by hbm2java
 */
@Entity
@Table(name = "data_trans_m", schema = "public")
public class DataTransM implements java.io.Serializable {

	private String transUuid;
	private String userId;
	private Date downloadDat;
	private Date uploadDat;
	private Date bankWorkingDat;
	private String uploadUserId;

	public DataTransM() {
	}

	public DataTransM(String transUuid) {
		this.transUuid = transUuid;
	}

	public DataTransM(String transUuid, String userId, Date downloadDat, Date uploadDat, Date bankWorkingDat,
			String uploadUserId) {
		this.transUuid = transUuid;
		this.userId = userId;
		this.downloadDat = downloadDat;
		this.uploadDat = uploadDat;
		this.bankWorkingDat = bankWorkingDat;
		this.uploadUserId = uploadUserId;
	}

	@Id

	@Column(name = "trans_uuid", unique = true, nullable = false, length = 36)
	public String getTransUuid() {
		return this.transUuid;
	}

	public void setTransUuid(String transUuid) {
		this.transUuid = transUuid;
	}

	@Column(name = "user_id", length = 36)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "download_dat", length = 35)
	public Date getDownloadDat() {
		return this.downloadDat;
	}

	public void setDownloadDat(Date downloadDat) {
		this.downloadDat = downloadDat;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "upload_dat", length = 35)
	public Date getUploadDat() {
		return this.uploadDat;
	}

	public void setUploadDat(Date uploadDat) {
		this.uploadDat = uploadDat;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "bank_working_dat", length = 35)
	public Date getBankWorkingDat() {
		return this.bankWorkingDat;
	}

	public void setBankWorkingDat(Date bankWorkingDat) {
		this.bankWorkingDat = bankWorkingDat;
	}

	@Column(name = "upload_user_id", length = 36)
	public String getUploadUserId() {
		return this.uploadUserId;
	}

	public void setUploadUserId(String uploadUserId) {
		this.uploadUserId = uploadUserId;
	}

}
