package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public class SysUserDAO {
	public gov.cqaudit.finance.hibernate.entites.SysUser getEntityByUserId(Session session, String user_id) {
		String hql = "from SysUser where effective=true and id=:user_id";

		Query q = session.createQuery(hql);
		q.setParameter("user_id", user_id);

		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.SysUser> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.SysUser>) q
				.list();
		if (sws.size() == 0) {
			System.out.println("不能得到用户数据，参数user_id:" + user_id);
			return null;
		} else {
			return sws.get(0);
		}
	}
	public gov.cqaudit.finance.hibernate.entites.SysUser getEntityByLoginName(Session session, String user_login_name) {
		String hql = "from SysUser where effective=true and userLogin=:user_login_name";

		Query q = session.createQuery(hql);
		q.setParameter("user_login_name", user_login_name);

		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.SysUser> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.SysUser>) q
				.list();
		if (sws.size() == 0) {
			System.out.println("不能得到用户数据，参数user_login_name:" + user_login_name);
			return null;
		} else {
			return sws.get(0);
		}
	}
}
