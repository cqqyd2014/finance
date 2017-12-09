package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public class VSysUserDAO {
	public gov.cqaudit.finance.hibernate.entites.VSysUser getEntityByUserId(Session session, String user_id) {
		String hql = "from VSysUser where id.effective=true and id.id=:user_id";

		Query q = session.createQuery(hql);
		q.setParameter("user_id", user_id);

		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VSysUser> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VSysUser>) q
				.list();
		if (sws.size() == 0) {
			System.out.println("不能得到用户数据，参数user_id:" + user_id);
			return null;
		} else {
			return sws.get(0);
		}
	}
	public gov.cqaudit.finance.hibernate.entites.VSysUser getEntityByLoginName(Session session, String user_login_name) {
		String hql = "from VSysUser where id.effective=true and id.userLogin=:user_login_name";

		Query q = session.createQuery(hql);
		q.setParameter("user_login_name", user_login_name);

		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VSysUser> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VSysUser>) q
				.list();
		if (sws.size() == 0) {
			System.out.println("不能得到用户数据，参数user_login_name:" + user_login_name);
			return null;
		} else {
			return sws.get(0);
		}
	}
}
