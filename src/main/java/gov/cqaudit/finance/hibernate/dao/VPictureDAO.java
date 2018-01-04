package gov.cqaudit.finance.hibernate.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;

public class VPictureDAO {
	public static java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VPicture> getArrayListViewByBillUuid(Session session,String bill_uuid){
		String hql = "from VPicture where id.effective=true and id.billUuid=:bill_uuid order by id.opDat";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		q.setParameter("bill_uuid", bill_uuid);
		
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VPicture> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VPicture>) q
				.list();
		return sws;
	}
	
	public static gov.cqaudit.finance.hibernate.entities.VPicture getEntityByUuid(Session session,String uuid){
		String hql = "from VPicture where id.uuid=:uuid";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		q.setParameter("uuid", uuid);
		
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VPicture> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VPicture>) q
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