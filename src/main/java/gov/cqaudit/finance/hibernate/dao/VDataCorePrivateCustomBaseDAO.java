package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Session;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;

public class VDataCorePrivateCustomBaseDAO extends GetModelFromEntityViewDAO<gov.cqaudit.finance.database.model.DataCorePrivateCustomBase>{

	@Override
	public <T> T getArrayListViewByHqlSql(Session session, String hql_sql) {
		// TODO Auto-generated method stub
		return super.getArrayListViewByHqlSql(session, hql_sql);
	}

	@Override
	public <T> void save(Session session, T t) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.database.model.DataCorePrivateCustomBase m=(gov.cqaudit.finance.database.model.DataCorePrivateCustomBase)t;
		gov.cqaudit.finance.hibernate.entities.DataCorePrivateCustomBase h=new gov.cqaudit.finance.hibernate.entities.DataCorePrivateCustomBase();
		h.setId(new gov.cqaudit.finance.hibernate.entities.DataCorePrivateCustomBaseId(m.getBank_code(), m.getPrivate_custom_id()));
		h.setPrivateCompany(m.getPrivate_company());
		h.setPrivateCustomName(m.getPrivate_custom_name());
		h.setPrivateIdCard(m.getPrivate_id_card());
		h.setPrivatePostAddress(m.getPrivate_post_address());
		h.setPrivateWorkAddress(m.getPrivate_work_address());
		session.merge(h);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, S> T getModelFromViewEntity(S s) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.hibernate.entities.VDataCorePrivateCustomBase h=(gov.cqaudit.finance.hibernate.entities.VDataCorePrivateCustomBase)s;
		gov.cqaudit.finance.database.model.DataCorePrivateCustomBase m=new gov.cqaudit.finance.database.model.DataCorePrivateCustomBase();
		m.setBank_code(h.getId().getBankCode());
		m.setPrivate_company(h.getId().getPrivateCompany());
		m.setPrivate_custom_id(h.getId().getPrivateCustomId());
		m.setPrivate_custom_name(h.getId().getPrivateCustomName());
		m.setPrivate_id_card(h.getId().getPrivateIdCard());
		m.setPrivate_post_address(h.getId().getPrivatePostAddress());
		m.setPrivate_work_address(h.getId().getPrivateWorkAddress());
		return (T)m;
	}

}
