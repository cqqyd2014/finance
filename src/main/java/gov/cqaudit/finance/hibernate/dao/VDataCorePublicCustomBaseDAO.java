package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Session;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;

public class VDataCorePublicCustomBaseDAO   extends GetModelFromEntityViewDAO<gov.cqaudit.finance.database.model.DataCorePublicCustomBase>{

	@Override
	public <T> void save(Session session, T t) {
		// TODO Auto-generated method stub
		
		gov.cqaudit.finance.database.model.DataCorePublicCustomBase m=(gov.cqaudit.finance.database.model.DataCorePublicCustomBase)t;
		gov.cqaudit.finance.hibernate.entities.DataCorePublicCustomBase h=new gov.cqaudit.finance.hibernate.entities.DataCorePublicCustomBase();
		h.setId(new gov.cqaudit.finance.hibernate.entities.DataCorePublicCustomBaseId(m.getBank_code(), m.getPublic_custom_id()));
		h.setPublicBusiness(m.getPublic_business());
		h.setPublicCustomName(m.getPublic_custom_name());
		h.setPublicIdCard(m.getPublic_id_card());
		h.setPublicLawManIdCard(m.getPublic_law_man_id_card());
		h.setPublicLawManName(m.getPublic_law_man_name());
		h.setPublicRegCapital(m.getPublic_reg_capital());
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
		
		gov.cqaudit.finance.database.model.DataCorePublicCustomBase m=new gov.cqaudit.finance.database.model.DataCorePublicCustomBase();
		gov.cqaudit.finance.hibernate.entities.VDataCorePublicCustomBase h=(gov.cqaudit.finance.hibernate.entities.VDataCorePublicCustomBase)s;
		
		m.setBank_code(h.getId().getBankCode());
		m.setPublic_business(h.getId().getPublicBusiness());
		m.setPublic_custom_id(h.getId().getPublicCustomId());
		m.setPublic_custom_name(h.getId().getPublicCustomName());
		m.setPublic_id_card(h.getId().getPublicIdCard());
		m.setPublic_law_man_name(h.getId().getPublicLawManName());
		m.setPublic_law_man_id_card(h.getId().getPublicLawManIdCard());
		m.setPublic_reg_capital(h.getId().getPublicRegCapital());
		return (T)m;
	}

}
