package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public class VBusinessSearchParDAO {
	
	
	
	
	public static java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBusinessSearchPar> getArrayListByBusinessCode(Session session, String business_code) {
		String hql = "from VBusinessSearchPar where id.businessCode=:business_code";

		Query q = session.createQuery(hql);
		q.setParameter("business_code", business_code);
		
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBusinessSearchPar> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBusinessSearchPar>) q
				.list();
		return sws;
	}

}
