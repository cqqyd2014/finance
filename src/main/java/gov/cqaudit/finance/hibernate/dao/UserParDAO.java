package gov.cqaudit.finance.hibernate.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;

public final class UserParDAO extends GetModelFromEntityViewDAO<gov.cqaudit.finance.hibernate.entities.UserPar>{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3279066842766387611L;
	
	
	public java.util.ArrayList<com.cqqyd2014.easyui.PropertygridItem> getProGrid(Session session,String user_id){
		java.util.ArrayList<gov.cqaudit.finance.system.model.UserPar> list=getArrayListModelByUserId(session,user_id);
		java.util.ArrayList<com.cqqyd2014.easyui.PropertygridItem> list2=new java.util.ArrayList<>();
		for (int i=0;i<list.size();i++){
			com.cqqyd2014.easyui.PropertygridItem item=new com.cqqyd2014.easyui.PropertygridItem();
			gov.cqaudit.finance.system.model.UserPar up=list.get(i);
			item.setName(up.getParam_desc());
			item.setValue(up.getValue());
			item.setGroup("");
			item.setEditor("text");
			list2.add(item);
		}
		return list2;
	}
	
	
	
	public gov.cqaudit.finance.system.model.UserPar getModelByUserIdDesc(Session session,String user_id,String code){
		String hql="from UserPar where id.userId=:user_id and parDesc=:code";
		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		
		

		q.setParameter("user_id", user_id);
		q.setParameter("code", code);
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.UserPar> rs = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.UserPar>) q
				.list();
		if (rs.size()==1){
			return (gov.cqaudit.finance.system.model.UserPar)getModelFromViewEntity(rs.get(0));
		}
		else{
			return null;
		}
	}

	public gov.cqaudit.finance.system.model.UserPar getModelByUserIdCode(Session session,String user_id,String code){
		String hql="from UserPar where id.userId=:user_id and id.parCode=:code";
		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		
		

		q.setParameter("user_id", user_id);
		q.setParameter("code", code);
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.UserPar> rs = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.UserPar>) q
				.list();
		if (rs.size()==1){
			return (gov.cqaudit.finance.system.model.UserPar)getModelFromViewEntity(rs.get(0));
		}
		else{
			return null;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public  java.util.ArrayList<gov.cqaudit.finance.system.model.UserPar> getArrayListModelByUserId(Session session,String user_id){
		String hql="from UserPar where id.userId=:user_id";
		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		
		

		q.setParameter("user_id", user_id);

		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.UserPar> rs = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.UserPar>) q
				.list();
		return (java.util.ArrayList<gov.cqaudit.finance.system.model.UserPar>)getArrayListModelFromArrayListViewEntity(rs);
	}

	@Override
	public <T> void save(Session session, T t) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.system.model.UserPar m=(gov.cqaudit.finance.system.model.UserPar)t;
		gov.cqaudit.finance.hibernate.entities.UserPar up_h=new gov.cqaudit.finance.hibernate.entities.UserPar();
		up_h.setId(new gov.cqaudit.finance.hibernate.entities.UserParId(m.getUserid(), m.getParam()));
		up_h.setParDesc(m.getParam_desc());
		up_h.setParValue(m.getValue());
		up_h.setParType(m.getPar_type());
		session.merge(up_h);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, S> T getModelFromViewEntity(S s) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.hibernate.entities.UserPar h=(gov.cqaudit.finance.hibernate.entities.UserPar)s;
gov.cqaudit.finance.system.model.UserPar up=new gov.cqaudit.finance.system.model.UserPar();
		
		up.setParam(h.getId().getParCode());
		up.setParam_desc(h.getParDesc());
		up.setUserid(h.getId().getUserId());
		up.setValue(h.getParValue());
		up.setPar_type(h.getParType());
		switch(h.getParType()){
		case "NUM_":
			up.setPar_type_name("数字");
			break;
		}
		return (T)up;
	}
}
