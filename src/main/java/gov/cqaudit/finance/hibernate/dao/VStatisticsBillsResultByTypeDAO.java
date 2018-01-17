package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;

public class VStatisticsBillsResultByTypeDAO extends GetModelFromEntityViewDAO<gov.cqaudit.finance.statistics.model.StatisticsTypeResult>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2719159480986830732L;
	
	
	
	@SuppressWarnings("unchecked")
	public java.util.ArrayList<gov.cqaudit.finance.statistics.model.StatisticsTypeResult> getArrayListModelBetweenCreateDate(Session session,java.util.Date start_date,java.util.Date end_date){
		String hql = "select new gov.cqaudit.finance.statistics.model.StatisticsTypeResult(count(id.deptType),id.deptType,id.typeName,sum(id.publicCount),sum(id.privateCount),sum(id.publicDetail),sum(id.privateDetail)) from VStatisticsBillsResultByType where id.createDate between :start_date and :end_date group by id.deptType,id.typeName";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		q.setParameter("end_date", end_date);
		q.setParameter("start_date", start_date);
		java.util.ArrayList<gov.cqaudit.finance.statistics.model.StatisticsTypeResult> rs=(java.util.ArrayList<gov.cqaudit.finance.statistics.model.StatisticsTypeResult>)q.list();
	return rs;
	}

	@Override
	public <T> void save(Session session, T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T, S> T getModelFromViewEntity(S s) {
		// TODO Auto-generated method stub
		return null;
	}

}
