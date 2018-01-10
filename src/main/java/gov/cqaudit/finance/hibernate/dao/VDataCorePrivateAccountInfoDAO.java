package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Session;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;

import gov.cqaudit.finance.hibernate.entities.DataCorePrivateAccountInfoId;

public class VDataCorePrivateAccountInfoDAO extends GetModelFromEntityViewDAO<gov.cqaudit.finance.database.model.DataCorePrivateAccountInfo>{

	

	@Override
	public <T> T getArrayListViewByHqlSql(Session session, String hql_sql) {
		// TODO Auto-generated method stub
		return super.getArrayListViewByHqlSql(session, hql_sql);
	}

	@Override
	public <T> void save(Session session, T t) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.database.model.DataCorePrivateAccountInfo m=(gov.cqaudit.finance.database.model.DataCorePrivateAccountInfo)t;
		gov.cqaudit.finance.hibernate.entities.DataCorePrivateAccountInfo h=new gov.cqaudit.finance.hibernate.entities.DataCorePrivateAccountInfo();
		h.setId(new DataCorePrivateAccountInfoId(m.getPrivate_account_id(), m.getBank_code()));
		h.setPrivateAccountName(m.getPrivate_account_name());
		h.setPrivateAcountStatus(m.getPrivate_account_stauts());
		h.setPrivateCardNo(m.getPrivate_card_no());
		h.setPrivateCloseDat(m.getPrivate_close_dat());
		h.setPrivateCustomId(m.getPrivate_custom_id());
		h.setPrivateOpenDat(m.getPrivate_open_dat());
		session.merge(h);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, S> T getModelFromViewEntity(S s) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.hibernate.entities.VDataCorePrivateAccountInfo h=(gov.cqaudit.finance.hibernate.entities.VDataCorePrivateAccountInfo)s;
		gov.cqaudit.finance.database.model.DataCorePrivateAccountInfo m=new gov.cqaudit.finance.database.model.DataCorePrivateAccountInfo();
		m.setBank_code(h.getId().getBankCode());
		m.setPrivate_account_id(h.getId().getPrivateAccountId());
		m.setPrivate_account_name(h.getId().getPrivateAccountName());
		m.setPrivate_account_stauts(h.getId().getPrivateAcountStatus());
		m.setPrivate_card_no(h.getId().getPrivateCardNo());
		m.setPrivate_close_dat(h.getId().getPrivateCloseDat());
		m.setPrivate_close_dat(h.getId().getPrivateOpenDat());
		m.setPrivate_custom_id(h.getId().getPrivateCustomId());
		m.setPrivate_open_dat(h.getId().getPrivateOpenDat());
		m.setPrivate_open_dat_print(com.cqqyd2014.util.DateUtil.getPrintSimpleString(h.getId().getPrivateOpenDat()));
		m.setPrivate_open_dat_chinese_print(com.cqqyd2014.util.DateUtil.getLocalSimpleString(h.getId().getPrivateOpenDat()));
		m.setPrivate_close_dat_print(com.cqqyd2014.util.DateUtil.getPrintSimpleString(h.getId().getPrivateCloseDat()));
		m.setPrivate_close_dat_chinese_print(com.cqqyd2014.util.DateUtil.getLocalSimpleString(h.getId().getPrivateCloseDat()));
		return (T)m;
	}

}
