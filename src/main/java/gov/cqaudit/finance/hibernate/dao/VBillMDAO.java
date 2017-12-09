package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public class VBillMDAO {
	public static java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VBillM> getArrayListViewArrayListBillUuid(Session session,java.util.ArrayList<String> bill_uuids){
		
		String bill_uuids_array=com.cqqyd2014.util.StringUtil.arrayListToSQLInString(bill_uuids);
		
		String hql = "from VBillM where id.effective=true and id.billUuid in "+bill_uuids_array;

		Query q = session.createQuery(hql);
		

		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VBillM> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VBillM>) q
				.list();
		return sws;
	}
	
	
	public static gov.cqaudit.finance.hibernate.entites.VBillM  getViewByUuid(Session session,String uuid){
		String hql = "from VBillM where id.effective=true and id.billUuid=:uuid";

		Query q = session.createQuery(hql);
		q.setParameter("uuid", uuid);

		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VBillM> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VBillM>) q
				.list();
		if (sws.size() == 0) {
			System.out.println("不能得到查询单数据，参数uuid:" + uuid);
			return null;
		} else {
			return sws.get(0);
		}
	}
}
