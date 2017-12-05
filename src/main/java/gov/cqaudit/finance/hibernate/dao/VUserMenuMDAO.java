package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public class VUserMenuMDAO {
	public java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VUserMenuM> getArrayListEntity(Session session,String user_id) {
		String hql = "from VUserMenuM where id.userId=:user_id";

		Query q = session.createQuery(hql);
		q.setParameter("user_id", user_id);

		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VUserMenuM> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VUserMenuM>) q
				.list();
		return sws;
	}
}
