package gov.cqaudit.finance.hibernate.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;

public class CatalogTableFieldDAO {
	public static java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.CatalogTableField> getEntityByTableCpde(Session session, String table_e_name) {
		String hql = "from CatalogTableField where id.tableEName=:table_e_name";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		q.setParameter("table_e_name", table_e_name);
		
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.CatalogTableField> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.CatalogTableField>) q
				.list();
		
			return sws;
		
		
	}
}
