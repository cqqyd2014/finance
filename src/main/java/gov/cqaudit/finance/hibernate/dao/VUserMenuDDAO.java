package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public final class VUserMenuDDAO {
	public static java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VUserMenuD> getArrayListEntityByIdUserId(Session session, String id,String user_id) {
		String hql = "from VUserMenuD where id.menuId=:id and id.userId=:user_id order by id.orderId";

		Query q = session.createQuery(hql);
		q.setParameter("id", id);
		q.setParameter("user_id", user_id);
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VUserMenuD> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VUserMenuD>) q
				.list();
		return sws;
	}
	public static java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VUserMenuD> getArrayListEntityByUserId(Session session, String user_id) {
		String hql = "from VUserMenuD where id.userId=:user_id order by id.orderId";

		Query q = session.createQuery(hql);

		q.setParameter("user_id", user_id);
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VUserMenuD> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VUserMenuD>) q
				.list();
		return sws;
	}
}
