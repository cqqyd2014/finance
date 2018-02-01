package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-30 16:21:58 by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VBillM generated by hbm2java
 */
@Entity
@Table(name = "v_bill_m", schema = "public")
public class VBillM implements java.io.Serializable {

	private VBillMId id;

	public VBillM() {
	}

	public VBillM(VBillMId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "ifRoom", column = @Column(name = "if_room")),
			@AttributeOverride(name = "ifOutput", column = @Column(name = "if_output")),
			@AttributeOverride(name = "billType", column = @Column(name = "bill_type", length = 4)),
			@AttributeOverride(name = "billTypeName", column = @Column(name = "bill_type_name", length = 90)),
			@AttributeOverride(name = "uneffectiveDat", column = @Column(name = "uneffective_dat", length = 35)),
			@AttributeOverride(name = "uneffectiveUserId", column = @Column(name = "uneffective_user_id", length = 36)),
			@AttributeOverride(name = "detailNum", column = @Column(name = "detail_num", precision = 131089, scale = 0)),
			@AttributeOverride(name = "picsNum", column = @Column(name = "pics_num", precision = 131089, scale = 0)),
			@AttributeOverride(name = "deptName", column = @Column(name = "dept_name", length = 128)),
			@AttributeOverride(name = "createUserId", column = @Column(name = "create_user_id", length = 36)),
			@AttributeOverride(name = "createDat", column = @Column(name = "create_dat", length = 35)),
			@AttributeOverride(name = "billStatus", column = @Column(name = "bill_status", length = 4)),
			@AttributeOverride(name = "contractName", column = @Column(name = "contract_name", length = 64)),
			@AttributeOverride(name = "contractTell", column = @Column(name = "contract_tell", length = 64)),
			@AttributeOverride(name = "contractMail", column = @Column(name = "contract_mail", length = 256)),
			@AttributeOverride(name = "auditUserId", column = @Column(name = "audit_user_id", length = 36)),
			@AttributeOverride(name = "lastAuditDat", column = @Column(name = "last_audit_dat", length = 35)),
			@AttributeOverride(name = "proName", column = @Column(name = "pro_name", length = 512)),
			@AttributeOverride(name = "billUuid", column = @Column(name = "bill_uuid", length = 36)),
			@AttributeOverride(name = "deptId", column = @Column(name = "dept_id", length = 36)),
			@AttributeOverride(name = "lastModifyDat", column = @Column(name = "last_modify_dat", length = 35)),
			@AttributeOverride(name = "searchReason", column = @Column(name = "search_reason", length = 1024)),
			@AttributeOverride(name = "downloadUserId", column = @Column(name = "download_user_id", length = 36)),
			@AttributeOverride(name = "downloadDat", column = @Column(name = "download_dat", length = 35)),
			@AttributeOverride(name = "downloadUuid", column = @Column(name = "download_uuid", length = 36)),
			@AttributeOverride(name = "effective", column = @Column(name = "effective")),
			@AttributeOverride(name = "createUserName", column = @Column(name = "create_user_name")),
			@AttributeOverride(name = "auditUserName", column = @Column(name = "audit_user_name")),
			@AttributeOverride(name = "downloadUserName", column = @Column(name = "download_user_name")),
			@AttributeOverride(name = "uneffectiveUserName", column = @Column(name = "uneffective_user_name")) })
	public VBillMId getId() {
		return this.id;
	}

	public void setId(VBillMId id) {
		this.id = id;
	}

}
