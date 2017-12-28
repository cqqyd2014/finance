package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public class VDataTransDDAO {
	public static java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VDataTransD> getArrayListViewByTransUuid(Session session,String trans_uuid){
		String hql = "from VDataTransD where id.transUuid=:trans_id";

		Query q = session.createQuery(hql);
		q.setParameter("trans_id", trans_uuid);

		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VDataTransD> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VDataTransD>) q
				.list();
		
			return sws;
		
	}
}
