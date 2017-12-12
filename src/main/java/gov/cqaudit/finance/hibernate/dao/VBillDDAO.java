package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public class VBillDDAO {
	
	public static java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VBillD> getArrayListViewByBillUuid(Session session,String bill_uuid){
		String hql = "from VBillD where id.effective=true and id.billUuid=:bill_uuid";

		Query q = session.createQuery(hql);
		q.setParameter("bill_uuid", bill_uuid);

		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VBillD> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VBillD>) q
				.list();
		
			return sws;
		
	}

}
