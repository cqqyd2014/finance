package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-16 13:34:04 by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VStatisticsBillsResult generated by hbm2java
 */
@Entity
@Table(name = "v_statistics_bills_result", schema = "public")
public class VStatisticsBillsResult implements java.io.Serializable {

	private VStatisticsBillsResultId id;

	public VStatisticsBillsResult() {
	}

	public VStatisticsBillsResult(VStatisticsBillsResultId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "deptId", column = @Column(name = "dept_id", length = 36)),
			@AttributeOverride(name = "deptType", column = @Column(name = "dept_type", length = 4)),
			@AttributeOverride(name = "deptName", column = @Column(name = "dept_name", length = 128)),
			@AttributeOverride(name = "createDat", column = @Column(name = "create_dat", length = 35)),
			@AttributeOverride(name = "billUuid", column = @Column(name = "bill_uuid", length = 36)),
			@AttributeOverride(name = "bankNames", column = @Column(name = "bank_names")),
			@AttributeOverride(name = "publicCount", column = @Column(name = "public_count")),
			@AttributeOverride(name = "privateCount", column = @Column(name = "private_count")),
			@AttributeOverride(name = "publicDetail", column = @Column(name = "public_detail", precision = 131089, scale = 0)),
			@AttributeOverride(name = "privateDetail", column = @Column(name = "private_detail", precision = 131089, scale = 0)),
			@AttributeOverride(name = "proName", column = @Column(name = "pro_name", length = 512)),
			@AttributeOverride(name = "downloadUserName", column = @Column(name = "download_user_name")),
			@AttributeOverride(name = "downloadUserId", column = @Column(name = "download_user_id")),
			@AttributeOverride(name = "downloadDat", column = @Column(name = "download_dat", length = 35)),
			@AttributeOverride(name = "typeName", column = @Column(name = "type_name", length = 90)) })
	public VStatisticsBillsResultId getId() {
		return this.id;
	}

	public void setId(VStatisticsBillsResultId id) {
		this.id = id;
	}

}
