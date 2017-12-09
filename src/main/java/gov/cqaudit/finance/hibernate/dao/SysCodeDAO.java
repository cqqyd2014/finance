package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public class SysCodeDAO {
	public static java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.SysCode> getEntityByCode(Session session, String s_id) {
		String hql = "from SysCode where id.SId=:s_id";

		Query q = session.createQuery(hql);
		q.setParameter("s_id", s_id);
		
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.SysCode> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.SysCode>) q
				.list();
		return sws;
	}
	
	public static String getValueBySIdCode(Session session,String s_id,String s_code) {
		String hql = "from SysCode where id.SId=:s_id and id.SCode=:s_code";

		Query q = session.createQuery(hql);
		q.setParameter("s_id", s_id);
		q.setParameter("s_code", s_code);
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.SysCode> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.SysCode>) q
				.list();
		if (sws.size()==0) {
			return null;
		}
		else {
			return sws.get(0).getSValue();
		}
	}
}