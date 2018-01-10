package gov.cqaudit.finance.hibernate.entities;
// Generated 2018-1-5 2:10:16 by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VSysDept generated by hbm2java
 */
@Entity
@Table(name = "v_sys_dept", schema = "public")
public class VSysDept implements java.io.Serializable {

	private VSysDeptId id;

	public VSysDept() {
	}

	public VSysDept(VSysDeptId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "deptUuid", column = @Column(name = "dept_uuid", length = 36)),
			@AttributeOverride(name = "deptName", column = @Column(name = "dept_name", length = 128)),
			@AttributeOverride(name = "userNum", column = @Column(name = "user_num", precision = 131089, scale = 0)),
			@AttributeOverride(name = "typeName", column = @Column(name = "type_name", length = 90)),
			@AttributeOverride(name = "deptType", column = @Column(name = "dept_type", length = 4)) })
	public VSysDeptId getId() {
		return this.id;
	}

	public void setId(VSysDeptId id) {
		this.id = id;
	}

}
