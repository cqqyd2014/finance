package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public class VBillBackDAO {
	public static java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBillDBack> getArrayListViewByBillUuid(Session session,String bill_uuid){
		String hql = "from VBillBack where id.billUuid=:bill_uuid";

		Query q = session.createQuery(hql);
		q.setParameter("bill_uuid", bill_uuid);

		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBillDBack> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBillDBack>) q
				.list();
		
			return sws;
		
	}
}
