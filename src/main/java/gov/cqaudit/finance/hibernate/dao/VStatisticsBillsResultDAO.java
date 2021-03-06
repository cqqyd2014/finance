package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;

public class VStatisticsBillsResultDAO extends GetModelFromEntityViewDAO<gov.cqaudit.finance.statistics.model.StatisticsBillsResult>{


	/**
	 * 
	 */
	private static final long serialVersionUID = -6088137393018136712L;
	
	//单一查询的情况
	public gov.cqaudit.finance.statistics.model.StatisticsBillsResult getModelByBillUuid(Session session,String bill_uuid){
		String hql = "from VStatisticsBillsResult where id.billUuid=:bill_uuid";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		q.setParameter("bill_uuid", bill_uuid);
		

		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VStatisticsBillsResult> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VStatisticsBillsResult>) q
				.list();
		if (sws.size()==0){
			return null;
		}
		else{
			return getModelFromViewEntity(sws.get(0));
		}
		
	
	}
	//查询多个
	public java.util.ArrayList<gov.cqaudit.finance.statistics.model.StatisticsBillsResult> 
	getArrayListModelByBillUuids(Session session,java.util.ArrayList<String> bill_uuids){
		java.util.ArrayList<gov.cqaudit.finance.statistics.model.StatisticsBillsResult> rs=new java.util.ArrayList<>();
		for (int i=0;i<bill_uuids.size();i++){
			rs.add(getModelByBillUuid(session,bill_uuids.get(i)));
		}
		
	return rs;
	}
	
	
	
	

	public java.math.BigDecimal
	getCountBetweenCreateDate(Session session,java.util.Date start_date,java.util.Date end_date){
		
			
			String hql = "select count(*) from VStatisticsBillsResult where id.createDat between :start_date and :end_date order by id.createDat";

			@SuppressWarnings("rawtypes")
			Query q = session.createQuery(hql);
			q.setParameter("end_date", end_date);
			q.setParameter("start_date", start_date);

			return new java.math.BigDecimal(((java.math.BigInteger)q.uniqueResult()).longValue());
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	public java.util.ArrayList<gov.cqaudit.finance.statistics.model.StatisticsBillsResult>
	getArrayListModelBetweenCreateDate(Session session,java.util.Date start_date,java.util.Date end_date){
		
			
			String hql = "from VStatisticsBillsResult where id.createDat between :start_date and :end_date order by id.createDat";

			@SuppressWarnings("rawtypes")
			Query q = session.createQuery(hql);
			q.setParameter("end_date", end_date);
			q.setParameter("start_date", start_date);

			java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VStatisticsBillsResult> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VStatisticsBillsResult>) q
					.list();
			return (java.util.ArrayList<gov.cqaudit.finance.statistics.model.StatisticsBillsResult>)getArrayListModelFromArrayListViewEntity(sws);
		
	}

	@Override
	public <T> void save(Session session, T t) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, S> T getModelFromViewEntity(S s) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.hibernate.entities.VStatisticsBillsResult h=(gov.cqaudit.finance.hibernate.entities.VStatisticsBillsResult)s;
		gov.cqaudit.finance.statistics.model.StatisticsBillsResult m=new gov.cqaudit.finance.statistics.model.StatisticsBillsResult();
		m.setBill_uuid(h.getId().getBillUuid());
		m.setCreate_date(h.getId().getCreateDat());
		m.setCreate_date_chinese_print(com.cqqyd2014.util.DateUtil.getLocalSimpleString(h.getId().getCreateDat()));
		m.setCreate_date_print(com.cqqyd2014.util.DateUtil.getPrintSimpleString(h.getId().getCreateDat()));
		m.setDept_name(h.getId().getDeptName());
		m.setDept_type_code(h.getId().getDeptType());
		m.setDept_type_name(h.getId().getTypeName());
		m.setDept_uuid(h.getId().getDeptId());
		m.setPrivate_account_count(new java.math.BigDecimal(h.getId().getPrivateCount()));
		m.setPrivate_detail_count(h.getId().getPrivateDetail());
		m.setPublic_account_count(new java.math.BigDecimal(h.getId().getPublicCount()));
		m.setPublic_detail_count(h.getId().getPublicDetail());
		m.setPro_name(h.getId().getProName());
		String bank_names=com.cqqyd2014.util.ArrayTools.toString(
				com.cqqyd2014.util.ArrayTools.eliminateDuplicates(h.getId().getBankNames().split(",")));
		m.setBank_names(bank_names.substring(1, bank_names.length()-1));
		m.setDownload_user_id(h.getId().getDownloadUserId());
		m.setDownload_user_name(h.getId().getDownloadUserName());
		m.setDownload_dat(h.getId().getDownloadDat());
		m.setDownload_dat_print(com.cqqyd2014.util.DateUtil.getPrintSimpleString(h.getId().getDownloadDat()));
		m.setDownlaod_dat_chinese_print(com.cqqyd2014.util.DateUtil.getLocalSimpleString(h.getId().getDownloadDat()));
		return (T)m;
	}

}
