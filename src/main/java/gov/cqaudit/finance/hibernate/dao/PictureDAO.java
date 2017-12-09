package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public class PictureDAO {
	
	public static java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.Picture> getArrayListEntityByBillUuid(Session session,String bill_uuid){
		String hql = "from Picture where billUuid=:bill_uuid order by opDat";

		Query q = session.createQuery(hql);
		q.setParameter("bill_uuid", bill_uuid);
		
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.Picture> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.Picture>) q
				.list();
		return sws;
	}
	
	public static gov.cqaudit.finance.hibernate.entites.Picture getEntityByUuid(Session session,String uuid){
		String hql = "from Picture where uuid=:uuid";

		Query q = session.createQuery(hql);
		q.setParameter("uuid", uuid);
		
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.Picture> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.Picture>) q
				.list();
		if (sws.size()==0) {
			System.out.println("不能得到图片："+uuid);
			return null;
		}
		else {
			return sws.get(0);
		}
	}

}
