package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public class SysParDAO {
	public gov.cqaudit.finance.hibernate.entites.SysPar getEntityByCode(Session session, String code) {
		String hql = "from SysPar where code=:code";

		Query q = session.createQuery(hql);
		q.setParameter("code", code);
		
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.SysPar> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.SysPar>) q
				.list();
		if (sws.size() == 0) {
			System.out.println("不能得到SysPar数据，参数code:" + code);
			return null;
		} else {
			return sws.get(0);
		}
	}
}
