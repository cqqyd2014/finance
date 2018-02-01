package gov.cqaudit.finance.hibernate.dao;

import java.math.BigDecimal;

import org.hibernate.Session;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;

public class VDataCorePublicAccountInfoDAO extends GetModelFromEntityViewDAO<gov.cqaudit.finance.database.model.DataCorePublicAccountInfo>{

	@Override
	public String getCountByHqlSql(Session session, String hql_sql) {
		// TODO Auto-generated method stub
		return super.getCountByHqlSql(session, hql_sql);
	}

	@Override
	public <T> T getArrayListViewByHqlSql(Session session, String hql_sql, BigDecimal page_size, BigDecimal page) {
		// TODO Auto-generated method stub
		return super.getArrayListViewByHqlSql(session, hql_sql, page_size, page);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1388734556852602013L;

	@Override
	public <T> void save(Session session, T t) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.database.model.DataCorePublicAccountInfo m=(gov.cqaudit.finance.database.model.DataCorePublicAccountInfo)t;
		gov.cqaudit.finance.hibernate.entities.DataCorePublicAccountInfo h=new gov.cqaudit.finance.hibernate.entities.DataCorePublicAccountInfo();
		h.setId(new gov.cqaudit.finance.hibernate.entities.DataCorePublicAccountInfoId(m.getBank_code(), m.getPublic_account_id()));
		h.setPublicAccountName(m.getPublic_account_name());
		h.setPublicAccountStatus(m.getPublic_account_stauts());
		h.setPublicCloseDat(m.getPublic_close_dat());
		h.setPublicCustomId(m.getPublic_custom_id());
		h.setPublicOpenDat(m.getPublic_open_dat());
		h.setTimepoint(m.getTimepoint());
		session.merge(h);
		
	}

	@Override
	public <T> T getArrayListViewByHqlSql(Session session, String hql_sql) {
		// TODO Auto-generated method stub
		return super.getArrayListViewByHqlSql(session, hql_sql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, S> T getModelFromViewEntity(S s) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.hibernate.entities.VDataCorePublicAccountInfo h=(gov.cqaudit.finance.hibernate.entities.VDataCorePublicAccountInfo)s;
		gov.cqaudit.finance.database.model.DataCorePublicAccountInfo m=new gov.cqaudit.finance.database.model.DataCorePublicAccountInfo();
		m.setBank_code(h.getId().getBankCode());
		m.setPublic_custom_id(h.getId().getPublicCustomId());
		m.setPublic_account_id(h.getId().getPublicAccountId());
		m.setPublic_account_name(h.getId().getPublicAccountName());
		m.setPublic_account_stauts(h.getId().getPublicAccountStatus());
		m.setPublic_open_dat(h.getId().getPublicOpenDat());
		m.setPublic_close_dat(h.getId().getPublicCloseDat());
		m.setPublic_open_dat_print(com.cqqyd2014.util.DateUtil.getPrintSimpleString(h.getId().getPublicOpenDat()));
		m.setPublic_open_dat_chinese_print(com.cqqyd2014.util.DateUtil.getLocalSimpleString(h.getId().getPublicOpenDat()));
		m.setPublic_close_dat_print(com.cqqyd2014.util.DateUtil.getPrintSimpleString(h.getId().getPublicCloseDat()));
		m.setPublic_close_dat_chinese_print(com.cqqyd2014.util.DateUtil.getLocalSimpleString(h.getId().getPublicCloseDat()));
		m.setTimepoint(h.getId().getTimepoint());
		m.setTimepoint_print(com.cqqyd2014.util.DateUtil.getPrintSimpleString(h.getId().getTimepoint()));
		return (T)m;
	}

}
