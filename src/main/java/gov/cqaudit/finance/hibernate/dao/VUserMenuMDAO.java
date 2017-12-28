package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public final class VUserMenuMDAO {
	public static java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VUserMenuM> getArrayListViewByUserId(Session session,String user_id) {
		String hql = "from VUserMenuM where id.userId=:user_id order by id.orderId";

		Query q = session.createQuery(hql);
		q.setParameter("user_id", user_id);

		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VUserMenuM> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VUserMenuM>) q
				.list();
		return sws;
	}
}
