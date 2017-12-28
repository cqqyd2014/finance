package gov.cqaudit.finance.data.core.logic;

import org.hibernate.Session;

import gov.cqaudit.finance.hibernate.entities.DataCorePrivateAccountInfoId;

public class CorePrivateAccountTradeDetailLogic {
	public static gov.cqaudit.finance.data.core.model.CorePrivateAccountTradeDetail getModelFromView(gov.cqaudit.finance.hibernate.entities.VDataCorePrivateAccountTradeDetail h){
		gov.cqaudit.finance.data.core.model.CorePrivateAccountTradeDetail m=new gov.cqaudit.finance.data.core.model.CorePrivateAccountTradeDetail();
		m.setBank_code(h.getId().getBankCode());
		m.setPrivate_account_id(h.getId().getPrivateAccountId());
		m.setPrivate_balance(h.getId().getPrivateBalance());
		m.setPrivate_bank_org_id(h.getId().getPrivateBankOrgId());
		m.setPrivate_bank_org_name(h.getId().getPrivateBankOrgName());
		m.setPrivate_op_account_id(h.getId().getPrivateOpAccountId());
		m.setPrivate_op_account_name(h.getId().getPrivateOpAccountName());
		m.setPrivate_op_bank_id(h.getId().getPrivateOpBankId());
		m.setPrivate_op_bank_name(h.getId().getPrivateBankOrgName());
		m.setPrivate_remark(h.getId().getPrivateRemark());
		m.setPrivate_trade_seq(h.getId().getPrivateTradeSeq());
		m.setPrivate_trade_code(h.getId().getPrivateTradeCode());
		m.setPrivate_trade_name(h.getId().getPrivateTradeName());
		m.setPrivate_trade_dat(h.getId().getPrivateTradeDat());
		m.setPrivate_trade_dat_print(com.cqqyd2014.util.DateUtil.getPrintFullString(h.getId().getPrivateTradeDat()));
		m.setPrivate_trade_dat_chinese_print(com.cqqyd2014.util.DateUtil.getLocalFullString(h.getId().getPrivateTradeDat()));
		
		return m;
		
	}
	public static java.util.ArrayList<gov.cqaudit.finance.data.core.model.CorePrivateAccountTradeDetail>
	getArrayListModelFromArrayListView(java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VDataCorePrivateAccountTradeDetail> hs){
		java.util.ArrayList<gov.cqaudit.finance.data.core.model.CorePrivateAccountTradeDetail> ms=new java.util.ArrayList<>();
		for (int i=0,len=hs.size();i<len;i++){
			gov.cqaudit.finance.data.core.model.CorePrivateAccountTradeDetail m=getModelFromView(hs.get(i));
			ms.add(m);
		}
		return ms;
	}
	public static void save(Session session,gov.cqaudit.finance.data.core.model.CorePrivateAccountTradeDetail m){
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
		session.merge(h);
	}
	
}
