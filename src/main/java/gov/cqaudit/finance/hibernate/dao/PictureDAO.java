package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public final class PictureDAO {
	public static java.math.BigDecimal getEntityCountByBillUuid(Session session,String bill_uuid){
		String hql = "select count(*) from Picture where billUuid=:bill_uuid and effective=true";
		Query q = session.createQuery(hql);
		q.setParameter("bill_uuid", bill_uuid);
		Long count = (Long)q.uniqueResult();
		return new java.math.BigDecimal(count);
	}
	
	
	
	public static java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.Picture> getArrayListEntityByBillUuid(Session session,String bill_uuid){
		String hql = "from Picture where billUuid=:bill_uuid order by opDat";

		Query q = session.createQuery(hql);
		q.setParameter("bill_uuid", bill_uuid);
		
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.Picture> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.Picture>) q
				.list();
		return sws;
	}
	
	public static gov.cqaudit.finance.hibernate.entities.Picture getEntityByUuid(Session session,String uuid){
		String hql = "from Picture where uuid=:uuid";

		Query q = session.createQuery(hql);
		q.setParameter("uuid", uuid);
		
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.Picture> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.Picture>) q
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
