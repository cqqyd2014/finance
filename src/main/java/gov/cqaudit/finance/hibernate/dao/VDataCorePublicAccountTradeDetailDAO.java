package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;

public class VDataCorePublicAccountTradeDetailDAO  extends GetModelFromEntityViewDAO<gov.cqaudit.finance.database.model.DataCorePublicAccountTradeDetail>{
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public java.util.ArrayList<gov.cqaudit.finance.database.model.DataCorePublicAccountTradeDetail>
	getArrayListViewByAccountIdBankId(Session session,String account_id,String bank_id){
		
			String hql = "from VDataCorePublicAccountTradeDetail where id.PublicAccountId=:account_id order by id.PublicTradeDat,id.PublicTradeSeq";

			@SuppressWarnings("rawtypes")
			Query q = session.createQuery(hql);
			q.setParameter("account_id", account_id);


			java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VDataCorePublicAccountTradeDetail> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VDataCorePublicAccountTradeDetail>) q
					.list();
			
				return (java.util.ArrayList<gov.cqaudit.finance.database.model.DataCorePublicAccountTradeDetail>)getArrayListModelFromArrayListViewEntity(sws);
			
		}

	@Override
	public <T> void save(Session session, T t) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.database.model.DataCorePublicAccountTradeDetail m=(gov.cqaudit.finance.database.model.DataCorePublicAccountTradeDetail)t;
		gov.cqaudit.finance.hibernate.entities.DataCorePublicAccountTradeDetail h=new gov.cqaudit.finance.hibernate.entities.DataCorePublicAccountTradeDetail();
		h.setId(new gov.cqaudit.finance.hibernate.entities.DataCorePublicAccountTradeDetailId(m.getBank_code(), m.getPublic_account_id(), m.getPublic_trade_seq(), m.getPublic_trade_dat()));
		h.setPublicAmount(m.getPublic_amount());
		h.setPublicBalance(m.getPublic_balance());
		h.setPublicBankOrgId(m.getPublic_bank_org_id());
		h.setPublicBankOrgName(m.getPublic_bank_org_name());
		h.setPublicOpAccountId(m.getPublic_op_account_id());
		h.setPublicOpAccountName(m.getPublic_op_account_name());
		h.setPublicOpBankId(m.getPublic_op_bank_id());
		h.setPublicOpBankName(m.getPublic_op_bank_name());
		h.setPublicRemark(m.getPublic_remark());
		h.setPublicTradeCode(m.getPublic_trade_code());
		h.setPublicTradeName(m.getPublic_trade_name());
		h.setPublicAccountName(m.getPublic_account_name());
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
		gov.cqaudit.finance.hibernate.entities.VDataCorePublicAccountTradeDetail h=(gov.cqaudit.finance.hibernate.entities.VDataCorePublicAccountTradeDetail)s;
		gov.cqaudit.finance.database.model.DataCorePublicAccountTradeDetail m=new gov.cqaudit.finance.database.model.DataCorePublicAccountTradeDetail();
		m.setBank_code(h.getId().getBankCode());
		m.setPublic_amount(h.getId().getPublicAmount());
		m.setPublic_account_id(h.getId().getPublicAccountId());
		m.setPublic_account_name(h.getId().getPublicAccountName());
		m.setPublic_balance(h.getId().getPublicBalance());
		m.setPublic_bank_org_id(h.getId().getPublicBankOrgId());
		m.setPublic_bank_org_name(h.getId().getPublicBankOrgName());
		m.setPublic_op_account_id(h.getId().getPublicOpAccountId());
		m.setPublic_op_account_name(h.getId().getPublicOpAccountName());
		m.setPublic_op_bank_id(h.getId().getPublicOpBankId());
		m.setPublic_op_bank_name(h.getId().getPublicOpBankName());
		m.setPublic_remark(h.getId().getPublicRemark());
		m.setPublic_trade_seq(h.getId().getPublicTradeSeq());
		m.setPublic_trade_code(h.getId().getPublicTradeCode());
		m.setPublic_trade_name(h.getId().getPublicTradeName());
		m.setPublic_trade_dat(h.getId().getPublicTradeDat());
		m.setPublic_trade_dat_print(com.cqqyd2014.util.DateUtil.getPrintFullString(h.getId().getPublicTradeDat()));
		m.setPublic_trade_dat_chinese_print(com.cqqyd2014.util.DateUtil.getLocalFullString(h.getId().getPublicTradeDat()));
		
		return (T) m;
	}

	
	
	

}