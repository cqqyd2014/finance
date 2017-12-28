package gov.cqaudit.finance.data.core.logic;

import org.hibernate.Session;

import gov.cqaudit.finance.hibernate.entities.DataCorePrivateAccountInfoId;

public final class CorePrivateAccountInfoLogic {
	public static gov.cqaudit.finance.data.core.model.CorePrivateAccountInfo getModelFromView(gov.cqaudit.finance.hibernate.entities.VDataCorePrivateAccountInfo h){
		gov.cqaudit.finance.data.core.model.CorePrivateAccountInfo m=new gov.cqaudit.finance.data.core.model.CorePrivateAccountInfo();
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
		return m;
		
	}
	public static java.util.ArrayList<gov.cqaudit.finance.data.core.model.CorePrivateAccountInfo> getArrayListModelFromArrayListView(
			java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VDataCorePrivateAccountInfo> hs){
		java.util.ArrayList<gov.cqaudit.finance.data.core.model.CorePrivateAccountInfo> ms=new java.util.ArrayList<>();
		for (int i=0,len=hs.size();i<len;i++){
			gov.cqaudit.finance.data.core.model.CorePrivateAccountInfo m=getModelFromView(hs.get(i));
			ms.add(m);
		}
		return ms;
	}
	public static void save(Session session,gov.cqaudit.finance.data.core.model.CorePrivateAccountInfo m){
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

}
