package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;

public class VDataCorePrivateAccountTradeDetailDAO  extends GetModelFromEntityViewDAO{
	
	
	
	
	
	
	
	@Override
	public <T> T getArrayListViewByHqlSql(Session session, String hql_sql) {
		// TODO Auto-generated method stub
		return super.getArrayListViewByHqlSql(session, hql_sql);
	}

	@SuppressWarnings("unchecked")
	public java.util.ArrayList<gov.cqaudit.finance.database.model.DataCorePrivateAccountTradeDetail>
	getArrayListViewByAccountIdBankId(Session session,String account_id,String bank_id){
		
			String hql = "from VDataCorePrivateAccountTradeDetail where id.privateAccountId=:account_id order by id.privateTradeDat,id.privateTradeSeq";

			@SuppressWarnings("rawtypes")
			Query q = session.createQuery(hql);
			q.setParameter("account_id", account_id);


			java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VDataCorePrivateAccountTradeDetail> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VDataCorePrivateAccountTradeDetail>) q
					.list();
			
				return (java.util.ArrayList<gov.cqaudit.finance.database.model.DataCorePrivateAccountTradeDetail>)getArrayListModelFromArrayListViewEntity(sws);
			
		}

	@Override
	public <T> void save(Session session, T t) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.database.model.DataCorePrivateAccountTradeDetail m=(gov.cqaudit.finance.database.model.DataCorePrivateAccountTradeDetail)t;
		gov.cqaudit.finance.hibernate.entities.DataCorePrivateAccountTradeDetail h=new gov.cqaudit.finance.hibernate.entities.DataCorePrivateAccountTradeDetail();
		h.setId(new gov.cqaudit.finance.hibernate.entities.DataCorePrivateAccountTradeDetailId(m.getBank_code(), m.getPrivate_account_id(), m.getPrivate_trade_seq(), m.getPrivate_trade_dat()));
		h.setPrivateAmount(m.getPrivate_amount());
		h.setPrivateBalance(m.getPrivate_balance());
		h.setPrivateBankOrgId(m.getPrivate_bank_org_id());
		h.setPrivateBankOrgName(m.getPrivate_bank_org_name());
		h.setPrivateOpAccountId(m.getPrivate_op_account_id());
		h.setPrivateOpAccountName(m.getPrivate_op_account_name());
		h.setPrivateOpBankId(m.getPrivate_op_bank_id());
		h.setPrivateOpBankName(m.getPrivate_op_bank_name());
		h.setPrivateRemark(m.getPrivate_remark());
		h.setPrivateTradeCode(m.getPrivate_trade_code());
		h.setPrivateTradeName(m.getPrivate_trade_name());
		h.setPrivateAccountName(m.getPrivate_account_name());
		session.merge(h);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, S> T getModelFromViewEntity(S s) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.hibernate.entities.VDataCorePrivateAccountTradeDetail h=(gov.cqaudit.finance.hibernate.entities.VDataCorePrivateAccountTradeDetail)s;
		gov.cqaudit.finance.database.model.DataCorePrivateAccountTradeDetail m=new gov.cqaudit.finance.database.model.DataCorePrivateAccountTradeDetail();
		m.setBank_code(h.getId().getBankCode());
		m.setPrivate_amount(h.getId().getPrivateAmount());
		m.setPrivate_account_id(h.getId().getPrivateAccountId());
		m.setPrivate_account_name(h.getId().getPrivateAccountName());
		m.setPrivate_balance(h.getId().getPrivateBalance());
		m.setPrivate_bank_org_id(h.getId().getPrivateBankOrgId());
		m.setPrivate_bank_org_name(h.getId().getPrivateBankOrgName());
		m.setPrivate_op_account_id(h.getId().getPrivateOpAccountId());
		m.setPrivate_op_account_name(h.getId().getPrivateOpAccountName());
		m.setPrivate_op_bank_id(h.getId().getPrivateOpBankId());
		m.setPrivate_op_bank_name(h.getId().getPrivateOpBankName());
		m.setPrivate_remark(h.getId().getPrivateRemark());
		m.setPrivate_trade_seq(h.getId().getPrivateTradeSeq());
		m.setPrivate_trade_code(h.getId().getPrivateTradeCode());
		m.setPrivate_trade_name(h.getId().getPrivateTradeName());
		m.setPrivate_trade_dat(h.getId().getPrivateTradeDat());
		m.setPrivate_trade_dat_print(com.cqqyd2014.util.DateUtil.getPrintFullString(h.getId().getPrivateTradeDat()));
		m.setPrivate_trade_dat_chinese_print(com.cqqyd2014.util.DateUtil.getLocalFullString(h.getId().getPrivateTradeDat()));
		
		return (T) m;
	}

	
	
	

}