package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Session;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;

public class UserRoleDAO extends GetModelFromEntityViewDAO<gov.cqaudit.finance.hibernate.entities.SysUserRole>{

	@Override
	public <T> void save(Session session, T t) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.hibernate.entities.SysUserRole h=new gov.cqaudit.finance.hibernate.entities.SysUserRole();
		gov.cqaudit.finance.system.model.UserRole m=(gov.cqaudit.finance.system.model.UserRole)t;
		h.setId(new gov.cqaudit.finance.hibernate.entities.SysUserRoleId(m.getUser_id(),m.getRole_id()));
		session.saveOrUpdate(h);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, S> T getModelFromViewEntity(S s) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.system.model.UserRole m=new gov.cqaudit.finance.system.model.UserRole();
		gov.cqaudit.finance.hibernate.entities.SysUserRole h=(gov.cqaudit.finance.hibernate.entities.SysUserRole)s;
		m.setRole_id(h.getId().getRoleId());
		m.setUser_id(h.getId().getUserId());
		return (T)m;
	}

}
