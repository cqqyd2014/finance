package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public class VSearchPrivateCustomAccountDAO {
	public static gov.cqaudit.finance.hibernate.entities.VSearchPrivateCustomAccount getViewByCardNo(Session session,String card_no,String bank_code){
		String hql = "from VSearchPrivateCustomAccount where id.privateCardNo=:card_no and id.bankCode=:bank_code";
		Query q = session.createQuery(hql);
		q.setParameter("card_no", card_no);
		q.setParameter("bank_code", bank_code);
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSearchPrivateCustomAccount> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSearchPrivateCustomAccount>) q
				.list();
		if (sws.size()==1){
			return sws.get(0);
		}
		else{
			return null;
		}
			
		
		
	}
	public static java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSearchPrivateCustomAccount> getArrayListViewByIdCard(Session session,String id_card,String bank_code){
		String hql = "from VSearchPrivateCustomAccount where id.privateIdCard=:id_card and id.bankCode=:bank_code";
		Query q = session.createQuery(hql);
		q.setParameter("id_card", id_card);
		q.setParameter("bank_code", bank_code);
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSearchPrivateCustomAccount> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSearchPrivateCustomAccount>) q
				.list();
		
			return sws;
		}
		
		
	}

