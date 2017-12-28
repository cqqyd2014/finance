package gov.cqaudit.finance.data.core.logic;

import org.hibernate.Session;

public final class CorePublicAccountInfoLogic {
	public static gov.cqaudit.finance.data.core.model.CorePublicAccountInfo getModelFromView(gov.cqaudit.finance.hibernate.entities.VDataCorePublicAccountInfo h){
		gov.cqaudit.finance.data.core.model.CorePublicAccountInfo m=new gov.cqaudit.finance.data.core.model.CorePublicAccountInfo();
		m.setBank_code(h.getId().getBankCode());
		m.setPublic_account_id(h.getId().getPublicAccountId());
		m.setPublic_account_name(h.getId().getPublicAccountName());
		m.setPublic_account_stauts(h.getId().getPublicAccountStatus());
		m.setPublic_open_dat(h.getId().getPublicOpenDat());
		m.setPublic_close_dat(h.getId().getPublicCloseDat());
		m.setPublic_open_dat_print(com.cqqyd2014.util.DateUtil.getPrintSimpleString(h.getId().getPublicOpenDat()));
		m.setPublic_open_dat_chinese_print(com.cqqyd2014.util.DateUtil.getLocalSimpleString(h.getId().getPublicOpenDat()));
		m.setPublic_close_dat_print(com.cqqyd2014.util.DateUtil.getPrintSimpleString(h.getId().getPublicCloseDat()));
		m.setPublic_close_dat_chinese_print(com.cqqyd2014.util.DateUtil.getLocalSimpleString(h.getId().getPublicCloseDat()));
		return m;
	}
	public static java.util.ArrayList<gov.cqaudit.finance.data.core.model.CorePublicAccountInfo> getArrayListModelFromArrayListEntity(java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VDataCorePublicAccountInfo> hs){
		java.util.ArrayList<gov.cqaudit.finance.data.core.model.CorePublicAccountInfo> ms=new java.util.ArrayList<>();
		for (int i=0,len=hs.size();i<len;i++){
			gov.cqaudit.finance.data.core.model.CorePublicAccountInfo m=getModelFromView(hs.get(i));
			ms.add(m);
		}
		return ms;
	}
	public static void save(Session session,gov.cqaudit.finance.data.core.model.CorePublicAccountInfo m){
		gov.cqaudit.finance.hibernate.entities.DataCorePublicAcountInfo h=new gov.cqaudit.finance.hibernate.entities.DataCorePublicAcountInfo();
		h.setId(new gov.cqaudit.finance.hibernate.entities.DataCorePublicAcountInfoId(m.getBank_code(), m.getPublic_account_id()));
		h.setPublicAccountName(m.getPublic_account_name());
		h.setPublicAccountStatus(m.getPublic_account_stauts());
		h.setPublicCloseDat(m.getPublic_close_dat());
		h.setPublicCustomId(m.getPublic_custom_id());
		h.setPublicOpenDat(m.getPublic_open_dat());
		session.merge(h);
	}

}
