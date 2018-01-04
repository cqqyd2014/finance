package gov.cqaudit.finance.hibernate.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;

public final class CatalogTableDAO {
	public static gov.cqaudit.finance.hibernate.entities.CatalogTable getEntityByTableCpde(Session session, String table_code) {
		String hql = "from CatalogTable where tableCode=:table_code";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		q.setParameter("table_code", table_code);
		
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.CatalogTable> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.CatalogTable>) q
				.list();
		if (sws.size()==1){
			return sws.get(0);
		}
		else{
			System.out.println("找不到CatalogTable，table_code为："+table_code);
			return null;
		}
		
	}

}
