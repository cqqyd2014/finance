package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public class MenuDDAO {
	public gov.cqaudit.finance.hibernate.entities.MenuD getEntityByIdDId(Session session, String id,String d_id) {
		String hql = "from MenuD where id.menuDId=:d_id and menuId=:id";

		Query q = session.createQuery(hql);
		q.setParameter("id", id);
		q.setParameter("d_id", d_id);
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.MenuD> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.MenuD>) q
				.list();
		if (sws.size() == 0) {
			System.out.println("不能得到MenuD数据，参数d_id:" + d_id+"，参数id:"+id);
			return null;
		} else {
			return sws.get(0);
		}
	}
}
