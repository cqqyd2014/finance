package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public final class SysUserDAO {
	
	public static gov.cqaudit.finance.hibernate.entities.UserPar getEntityByPar(Session session,String user_id,String par_code){
		String hql="from UserPar where id.userId=:user_id and id.parCode=:par_code";
		Query q = session.createQuery(hql);
		
		q.setParameter("par_code", par_code);

		q.setParameter("user_id", user_id);
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.UserPar> rs = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.UserPar>) q
				.list();
		if (rs.size()>0){
			return rs.get(0);
		}
		else{
			System.out.println("不能得到用户："+",参数："+par_code+"的值,输入参数user_id="+user_id);
			return null;
		}
	}
	
	public static void setValue(Session session,String user_id,String par_code,String par_value){
		gov.cqaudit.finance.hibernate.entities.UserPar o=getEntityByPar(session,user_id,par_code);
		if (o==null){
			gov.cqaudit.finance.hibernate.entities.UserPar up=new gov.cqaudit.finance.hibernate.entities.UserPar();
			gov.cqaudit.finance.hibernate.entities.UserParId upid=new gov.cqaudit.finance.hibernate.entities.UserParId();
			
			upid.setParCode(par_code);
			upid.setUserId(user_id);
			up.setId(upid);
			up.setParDesc("");
			up.setParValue(par_value);
			session.save(up);
			session.flush();
			
		}
		else{
			o.setParValue(par_value);
			session.saveOrUpdate(o);
			session.flush();
			
		}
	}
	
	
	
	public static gov.cqaudit.finance.hibernate.entities.SysUser getEntityByUserId(Session session, String user_id) {
		String hql = "from SysUser where effective=true and id=:user_id";

		Query q = session.createQuery(hql);
		q.setParameter("user_id", user_id);

		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.SysUser> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.SysUser>) q
				.list();
		if (sws.size() == 0) {
			System.out.println("不能得到用户数据，参数user_id:" + user_id);
			return null;
		} else {
			return sws.get(0);
		}
	}
	public static gov.cqaudit.finance.hibernate.entities.SysUser getEntityByLoginName(Session session, String user_login_name) {
		String hql = "from SysUser where effective=true and userLogin=:user_login_name";

		Query q = session.createQuery(hql);
		q.setParameter("user_login_name", user_login_name);

		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.SysUser> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.SysUser>) q
				.list();
		if (sws.size() == 0) {
			System.out.println("不能得到用户数据，参数user_login_name:" + user_login_name);
			return null;
		} else {
			return sws.get(0);
		}
	}
}
