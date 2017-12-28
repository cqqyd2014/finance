package gov.cqaudit.finance.data.core.logic;

import org.hibernate.Session;

import gov.cqaudit.finance.hibernate.entities.DataCorePrivateAccountTradeDetailId;

public final class CorePublicAccountTradeDetailLogic {
	public static gov.cqaudit.finance.data.core.model.CorePublicAccountTradeDetail getModelFromView(gov.cqaudit.finance.hibernate.entities.VDataCorePrivateAccountTradeDetail h){
		gov.cqaudit.finance.data.core.model.CorePublicAccountTradeDetail m=new gov.cqaudit.finance.data.core.model.CorePublicAccountTradeDetail();
		m.setBank_code(h.getId().getBankCode());
		m.setPublic_account_id(h.getId().getPrivateAccountId());
		m.setPublic_amount(h.getId().getPrivateAmount());
		m.setPublic_balance(h.getId().getPrivateBalance());
		m.setPublic_bank_org_id(h.getId().getPrivateBankOrgId());
		m.setPublic_bank_org_name(h.getId().getPrivateBankOrgName());
		m.setPublic_op_account_id(h.getId().getPrivateOpAccountId());
		m.setPublic_op_account_name(h.getId().getPrivateOpAccountName());
		m.setPublic_op_bank_id(h.getId().getPrivateOpBankId());
		m.setPublic_op_bank_name(h.getId().getPrivateOpBankName());
		m.setPublic_remark(h.getId().getPrivateRemark());
		m.setPublic_trade_code(h.getId().getPrivateTradeCode());
		m.setPublic_trade_name(h.getId().getPrivateTradeName());
		m.setPublic_trade_seq(h.getId().getPrivateTradeSeq());
		m.setPublic_trade_dat(h.getId().getPrivateTradeDat());
		m.setPublic_trade_dat_print(com.cqqyd2014.util.DateUtil.getPrintFullString(h.getId().getPrivateTradeDat()));
		m.setPublic_trade_dat_chinese_print(com.cqqyd2014.util.DateUtil.getLocalFullString(h.getId().getPrivateTradeDat()));
		return m;
	}
	public static java.util.ArrayList<gov.cqaudit.finance.data.core.model.CorePublicAccountTradeDetail> getArrayListModelArrayListEntity(java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VDataCorePrivateAccountTradeDetail> hs){
		java.util.ArrayList<gov.cqaudit.finance.data.core.model.CorePublicAccountTradeDetail> ms=new java.util.ArrayList<>();
		for (int i=0,len=hs.size();i<len;i++){
			gov.cqaudit.finance.data.core.model.CorePublicAccountTradeDetail m=getModelFromView(hs.get(i));
			ms.add(m);
		}
		return ms;
		
	}
	public static void save(Session session,gov.cqaudit.finance.data.core.model.CorePublicAccountTradeDetail m){
		gov.cqaudit.finance.hibernate.entities.DataCorePrivateAccountTradeDetail h=new gov.cqaudit.finance.hibernate.entities.DataCorePrivateAccountTradeDetail();
		h.setId(new gov.cqaudit.finance.hibernate.entities.DataCorePrivateAccountTradeDetailId(m.getBank_code(), m.getPublic_account_id(), m.getPublic_trade_seq(), m.getPublic_trade_dat()));
		h.setPrivateAmount(m.getPublic_amount());
		h.setPrivateBalance(m.getPublic_balance());
		h.setPrivateBankOrgId(m.getPublic_bank_org_id());
		h.setPrivateBankOrgName(m.getPublic_bank_org_name());
		h.setPrivateOpAccountId(m.getPublic_op_account_id());
		h.setPrivateOpAccountName(m.getPublic_op_account_name());
		h.setPrivateOpBankId(m.getPublic_op_bank_id());
		h.setPrivateOpBankName(m.getPublic_op_bank_name());
		h.setPrivateRemark(m.getPublic_remark());
		h.setPrivateTradeCode(m.getPublic_trade_code());
		h.setPrivateTradeName(m.getPublic_trade_name());
		
		session.merge(h);
	}

}
