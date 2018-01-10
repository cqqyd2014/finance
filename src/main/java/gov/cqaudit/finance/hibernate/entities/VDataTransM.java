package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-5 2:10:16 by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VDataTransM generated by hbm2java
 */
@Entity
@Table(name = "v_data_trans_m", schema = "public")
public class VDataTransM implements java.io.Serializable {

	private VDataTransMId id;

	public VDataTransM() {
	}

	public VDataTransM(VDataTransMId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "userId", column = @Column(name = "user_id", length = 36)),
			@AttributeOverride(name = "transUuid", column = @Column(name = "trans_uuid", length = 36)),
			@AttributeOverride(name = "uploadUserId", column = @Column(name = "upload_user_id", length = 36)),
			@AttributeOverride(name = "downloadDat", column = @Column(name = "download_dat", length = 35)),
			@AttributeOverride(name = "uploadDat", column = @Column(name = "upload_dat", length = 35)) })
	public VDataTransMId getId() {
		return this.id;
	}

	public void setId(VDataTransMId id) {
		this.id = id;
	}

}
