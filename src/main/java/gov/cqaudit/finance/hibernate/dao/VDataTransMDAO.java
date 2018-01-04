package gov.cqaudit.finance.hibernate.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;

public class VDataTransMDAO {
public static gov.cqaudit.finance.hibernate.entities.VDataTransM getViewArrayListByTransId(Session session,String trans_id){
		
		
		
		String hql = "from VDataTransM where id.transUuid=:trans_id";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		
		q.setParameter("trans_id", trans_id);
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VDataTransM> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VDataTransM>) q
				.list();
		if (sws.size()>0){
			return sws.get(0);
		}
		else{
			System.out.println("找不到这个trans_id："+trans_id);
			return null;
		}
	}

}
