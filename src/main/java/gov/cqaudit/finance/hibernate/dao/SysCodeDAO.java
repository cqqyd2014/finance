package gov.cqaudit.finance.hibernate.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;

public class SysCodeDAO extends GetModelFromEntityViewDAO{
	@SuppressWarnings("unchecked")
	public  java.util.ArrayList<gov.cqaudit.finance.system.model.SysCode> getArrayListModelBySId(Session session, String s_id) {
		String hql = "from SysCode where id.SId=:s_id";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		q.setParameter("s_id", s_id);
		

		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.SysCode> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.SysCode>) q
				.list();
		return (java.util.ArrayList<gov.cqaudit.finance.system.model.SysCode>)getArrayListModelFromArrayListViewEntity(sws);
	}
	
	public  String getValueBySIdCode(Session session,String s_id,String s_code) {
		String hql = "from SysCode where id.SId=:s_id and id.SCode=:s_code";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		q.setParameter("s_id", s_id);
		q.setParameter("s_code", s_code);
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.SysCode> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.SysCode>) q
				.list();
		if (sws.size()==0) {
			return null;
		}
		else {
			return sws.get(0).getSValue();
		}
	}
	@SuppressWarnings("unchecked")
	public java.util.ArrayList<gov.cqaudit.finance.system.model.SysCode> getArrayListModel(Session session) {
		String hql = "from SysCode";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		

		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.SysCode> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.SysCode>) q
				.list();
		
		
		return (java.util.ArrayList<gov.cqaudit.finance.system.model.SysCode>)getArrayListModelFromArrayListViewEntity(sws);
		
	}

	@Override
	public <T> void save(Session session, T t) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.system.model.SysCode m=(gov.cqaudit.finance.system.model.SysCode)t;
		gov.cqaudit.finance.hibernate.entities.SysCode h=new gov.cqaudit.finance.hibernate.entities.SysCode();
		h.setId(new gov.cqaudit.finance.hibernate.entities.SysCodeId(m.getS_id(), m.getCode()));
		h.setSDesc(m.getS_desc());
		h.setSValue(m.getValue());
		session.merge(h);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, S> T getModelFromViewEntity(S s) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.hibernate.entities.SysCode h=(gov.cqaudit.finance.hibernate.entities.SysCode)s;
		gov.cqaudit.finance.system.model.SysCode sc=new gov.cqaudit.finance.system.model.SysCode();
		sc.setCode(h.getId().getSCode());
		sc.setValue(h.getSValue());
		sc.setS_id(h.getId().getSId());
		sc.setS_desc(h.getSDesc());;
		return (T)sc;
	}
}
