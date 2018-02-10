package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Session;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;

public class VTransNotBackDAO extends GetModelFromEntityViewDAO<gov.cqaudit.finance.bills.model.TransNotBack>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2394039709913444823L;

	@Override
	public <T> void save(Session session, T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T, S> T getModelFromViewEntity(S s) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.hibernate.entities.VTransNotBack h=(gov.cqaudit.finance.hibernate.entities.VTransNotBack)s;
		gov.cqaudit.finance.bills.model.TransNotBack m=new gov.cqaudit.finance.bills.model.TransNotBack();
		m.setBank_code(h.getId().getBankCode());
		m.setBank_code(h.getId().getBillUuid());
		return null;
	}

	@Override
	public String getCountByHqlSql(Session session, String hql_sql) {
		// TODO Auto-generated method stub
		return super.getCountByHqlSql(session, hql_sql);
	}

}
