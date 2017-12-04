package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public class VUserMenuDDAO {
	public java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VUserMenuD> getArrayListEntityByIdUserId(Session session, String id,String user_id) {
		String hql = "from VUserMenuD where id.menuId=:id and userId=:user_id order by id.orderId";

		Query q = session.createQuery(hql);
		q.setParameter("id", id);
		q.setParameter("user_id", user_id);
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VUserMenuD> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VUserMenuD>) q
				.list();
		return sws;
	}
	public java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VUserMenuD> getArrayListEntityByUserId(Session session, String user_id) {
		String hql = "from VUserMenuD where userId=:user_id order by id.orderId";

		Query q = session.createQuery(hql);

		q.setParameter("user_id", user_id);
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VUserMenuD> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VUserMenuD>) q
				.list();
		return sws;
	}
}
