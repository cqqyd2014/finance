package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-5 2:10:16 by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VPicture generated by hbm2java
 */
@Entity
@Table(name = "v_picture", schema = "public")
public class VPicture implements java.io.Serializable {

	private VPictureId id;

	public VPicture() {
	}

	public VPicture(VPictureId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "uuid", column = @Column(name = "uuid", length = 36)),
			@AttributeOverride(name = "opDat", column = @Column(name = "op_dat", length = 35)),
			@AttributeOverride(name = "userId", column = @Column(name = "user_id", length = 36)),
			@AttributeOverride(name = "billUuid", column = @Column(name = "bill_uuid", length = 36)),
			@AttributeOverride(name = "effective", column = @Column(name = "effective")),
			@AttributeOverride(name = "fileType", column = @Column(name = "file_type", length = 1024)),
			@AttributeOverride(name = "fileName", column = @Column(name = "file_name", length = 1024)),
			@AttributeOverride(name = "fileLength", column = @Column(name = "file_length")),
			@AttributeOverride(name = "binData", column = @Column(name = "bin_data")),
			@AttributeOverride(name = "userName", column = @Column(name = "user_name", length = 45)) })
	public VPictureId getId() {
		return this.id;
	}

	public void setId(VPictureId id) {
		this.id = id;
	}

}
