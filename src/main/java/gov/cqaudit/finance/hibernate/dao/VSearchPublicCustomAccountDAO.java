package gov.cqaudit.finance.hibernate.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;

public final class VSearchPublicCustomAccountDAO {
	public static gov.cqaudit.finance.hibernate.entities.VSearchPublicCustomAccount getViewByAccountId(Session session,String account_id,String bank_code){
		String hql = "from VSearchPublicCustomAccount where id.publicAccountId=:account_id and id.bankCode=:bank_code";
		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		q.setParameter("account_id", account_id);
		q.setParameter("bank_code", bank_code);
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSearchPublicCustomAccount> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSearchPublicCustomAccount>) q
				.list();
		if (sws.size()==1){
			return sws.get(0);
		}
		else{
			return null;
		}
		
	}
	
	
	public static java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSearchPublicCustomAccount> getArrayListViewByCustomName(Session session, String custom_name,String bank_code) {
		String hql = "from VSearchPublicCustomAccount where id.publicCustomName=:custom_name and id.bankCode=:bank_code";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		q.setParameter("custom_name", custom_name);
		q.setParameter("bank_code", bank_code);
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSearchPublicCustomAccount> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSearchPublicCustomAccount>) q
				.list();
		return sws;
	}
}
