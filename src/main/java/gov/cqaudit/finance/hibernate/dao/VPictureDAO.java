package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public class VPictureDAO {
	public static java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VPicture> getArrayListEntityByBillUuid(Session session,String bill_uuid){
		String hql = "from VPicture where id.effective=true and id.billUuid=:bill_uuid order by id.opDat";

		Query q = session.createQuery(hql);
		q.setParameter("bill_uuid", bill_uuid);
		
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VPicture> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VPicture>) q
				.list();
		return sws;
	}
	
	public static gov.cqaudit.finance.hibernate.entites.VPicture getEntityByUuid(Session session,String uuid){
		String hql = "from VPicture where id.uuid=:uuid";

		Query q = session.createQuery(hql);
		q.setParameter("uuid", uuid);
		
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VPicture> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VPicture>) q
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