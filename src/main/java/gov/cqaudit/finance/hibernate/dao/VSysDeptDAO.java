package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;

public class VSysDeptDAO extends GetModelFromEntityViewDAO<gov.cqaudit.finance.system.model.Dept>{
	
	public gov.cqaudit.finance.system.model.Dept getModelByDeptId(Session session,String dept_uuid){
		String hql = "from VSysDept where id.deptUuid=:dept_uuid";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		
		q.setParameter("dept_uuid", dept_uuid);

		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSysDept> sws = 
				(java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSysDept>)q.list();
		if (sws.size()==1){
			return getModelFromViewEntity(sws.get(0));
		}
		else{
			return null;
		}
		
	}
	
	
	public java.util.ArrayList<gov.cqaudit.finance.system.model.Dept> getArrayListModelByDeptName(Session session,String dept_name){
		String hql = "from VSysDept where id.deptName=:dept_name";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		
		q.setParameter("dept_name", dept_name);

		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.system.model.Dept> sws = 
				(java.util.ArrayList<gov.cqaudit.finance.system.model.Dept>) getArrayListModelFromArrayListViewEntity((java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSysDept>)q.list());
		return sws;
	}
	
	
	@SuppressWarnings("unchecked")
	public java.util.ArrayList<gov.cqaudit.finance.system.model.Dept> getAllModel(Session session){
		
			String hql = "from VSysDept";

			@SuppressWarnings("rawtypes")
			Query q = session.createQuery(hql);
			
			

			java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSysDept> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSysDept>) q
					.list();
			return (java.util.ArrayList<gov.cqaudit.finance.system.model.Dept>)getArrayListModelFromArrayListViewEntity(sws);
	}

	@Override
	public <T> void save(Session session, T t) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.hibernate.entities.SysDept h=new gov.cqaudit.finance.hibernate.entities.SysDept();
		gov.cqaudit.finance.system.model.Dept m=(gov.cqaudit.finance.system.model.Dept)t;
		h.setDeptName(m.getDept_name());
		h.setDeptType(m.getDept_type());
		h.setDeptUuid(m.getDept_uuid());
		h.setUserNum(m.getUser_num());
		session.saveOrUpdate(h);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, S> T getModelFromViewEntity(S s) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.hibernate.entities.VSysDept h=(gov.cqaudit.finance.hibernate.entities.VSysDept)s;
		gov.cqaudit.finance.system.model.Dept m=new gov.cqaudit.finance.system.model.Dept();
		m.setDept_name(h.getId().getDeptName());
		m.setDept_type(h.getId().getDeptType());
		m.setDept_type_name(h.getId().getTypeName());
		m.setUser_num(h.getId().getUserNum());
		m.setDept_uuid(h.getId().getDeptUuid());
		return (T)m;
	}

}
