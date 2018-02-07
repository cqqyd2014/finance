package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-2-2 15:03:25 by Hibernate Tools 5.2.3.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VDataTransMId generated by hbm2java
 */
@Embeddable
public class VDataTransMId implements java.io.Serializable {

	private String userId;
	private String transUuid;
	private String uploadUserId;
	private Date downloadDat;
	private Date uploadDat;

	public VDataTransMId() {
	}

	public VDataTransMId(String userId, String transUuid, String uploadUserId, Date downloadDat, Date uploadDat) {
		this.userId = userId;
		this.transUuid = transUuid;
		this.uploadUserId = uploadUserId;
		this.downloadDat = downloadDat;
		this.uploadDat = uploadDat;
	}

	@Column(name = "user_id", length = 36)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "trans_uuid", length = 36)
	public String getTransUuid() {
		return this.transUuid;
	}

	public void setTransUuid(String transUuid) {
		this.transUuid = transUuid;
	}

	@Column(name = "upload_user_id", length = 36)
	public String getUploadUserId() {
		return this.uploadUserId;
	}

	public void setUploadUserId(String uploadUserId) {
		this.uploadUserId = uploadUserId;
	}

	@Column(name = "download_dat", length = 35)
	public Date getDownloadDat() {
		return this.downloadDat;
	}

	public void setDownloadDat(Date downloadDat) {
		this.downloadDat = downloadDat;
	}

	@Column(name = "upload_dat", length = 35)
	public Date getUploadDat() {
		return this.uploadDat;
	}

	public void setUploadDat(Date uploadDat) {
		this.uploadDat = uploadDat;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VDataTransMId))
			return false;
		VDataTransMId castOther = (VDataTransMId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this.getUserId() != null
				&& castOther.getUserId() != null && this.getUserId().equals(castOther.getUserId())))
				&& ((this.getTransUuid() == castOther.getTransUuid()) || (this.getTransUuid() != null
						&& castOther.getTransUuid() != null && this.getTransUuid().equals(castOther.getTransUuid())))
				&& ((this.getUploadUserId() == castOther.getUploadUserId())
						|| (this.getUploadUserId() != null && castOther.getUploadUserId() != null
								&& this.getUploadUserId().equals(castOther.getUploadUserId())))
				&& ((this.getDownloadDat() == castOther.getDownloadDat())
						|| (this.getDownloadDat() != null && castOther.getDownloadDat() != null
								&& this.getDownloadDat().equals(castOther.getDownloadDat())))
				&& ((this.getUploadDat() == castOther.getUploadDat()) || (this.getUploadDat() != null
						&& castOther.getUploadDat() != null && this.getUploadDat().equals(castOther.getUploadDat())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result + (getTransUuid() == null ? 0 : this.getTransUuid().hashCode());
		result = 37 * result + (getUploadUserId() == null ? 0 : this.getUploadUserId().hashCode());
		result = 37 * result + (getDownloadDat() == null ? 0 : this.getDownloadDat().hashCode());
		result = 37 * result + (getUploadDat() == null ? 0 : this.getUploadDat().hashCode());
		return result;
	}

}
