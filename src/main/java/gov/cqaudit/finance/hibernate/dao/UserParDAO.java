package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public final class UserParDAO {
	public static java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.UserPar> getArrayListEntityByUserId(Session session,String user_id){
		String hql="from UserPar where id.userId=:user_id";
		Query q = session.createQuery(hql);
		
		

		q.setParameter("user_id", user_id);
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.UserPar> rs = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.UserPar>) q
				.list();
		return rs;
	}
}
