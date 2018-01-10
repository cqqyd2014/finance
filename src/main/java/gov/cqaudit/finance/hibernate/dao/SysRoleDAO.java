package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;

public class SysRoleDAO extends GetModelFromEntityViewDAO<gov.cqaudit.finance.system.model.SysRole>{
	@SuppressWarnings("unchecked")
	public java.util.ArrayList<gov.cqaudit.finance.system.model.SysRole> getAllModel(Session session) {
		String hql = "from SysRole ";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		


		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.SysRole> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.SysRole>) q
				.list();
		return (java.util.ArrayList<gov.cqaudit.finance.system.model.SysRole>)getArrayListModelFromArrayListViewEntity(sws);
	}

	@Override
	public <T> void save(Session session, T t) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.hibernate.entities.SysRole h=new gov.cqaudit.finance.hibernate.entities.SysRole();
		gov.cqaudit.finance.system.model.SysRole m=(gov.cqaudit.finance.system.model.SysRole)t;
		h.setRoleId(m.getRole_id());
		h.setRoleName(m.getRole_name());
		session.saveOrUpdate(h);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, S> T getModelFromViewEntity(S s) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.hibernate.entities.SysRole h=(gov.cqaudit.finance.hibernate.entities.SysRole)s;
		gov.cqaudit.finance.system.model.SysRole m=new gov.cqaudit.finance.system.model.SysRole();
		m.setRole_id(h.getRoleId());
		m.setRole_name(h.getRoleName());
		return (T)m;
	}

}
