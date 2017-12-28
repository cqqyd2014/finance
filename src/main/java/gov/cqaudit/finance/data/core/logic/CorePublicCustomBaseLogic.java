package gov.cqaudit.finance.data.core.logic;

import org.hibernate.Session;

public final class CorePublicCustomBaseLogic {
	public static gov.cqaudit.finance.data.core.model.CorePublicCustomBase getModelFromView(gov.cqaudit.finance.hibernate.entities.VDataCorePublicCustomBase h){
		gov.cqaudit.finance.data.core.model.CorePublicCustomBase m=new gov.cqaudit.finance.data.core.model.CorePublicCustomBase();
		m.setBank_code(h.getId().getBankCode());
		m.setPublic_business(h.getId().getPublicBusiness());
		m.setPublic_custom_id(h.getId().getPublicCustomId());
		m.setPublic_custom_name(h.getId().getPublicCustomName());
		m.setPublic_id_card(h.getId().getPublicIdCard());
		m.setPublic_law_man_name(h.getId().getPublicLawManName());
		m.setPublic_law_man_id_card(h.getId().getPublicLawManIdCard());
		m.setPublic_reg_capital(h.getId().getPublicRegCapital());
		return m;
	}
	public static java.util.ArrayList<gov.cqaudit.finance.data.core.model.CorePublicCustomBase> getArrayListModelFromArrayView(java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VDataCorePublicCustomBase> hs){
		java.util.ArrayList<gov.cqaudit.finance.data.core.model.CorePublicCustomBase> ms=new java.util.ArrayList<>();
		for (int i=0,len=hs.size();i<len;i++){
			gov.cqaudit.finance.data.core.model.CorePublicCustomBase m=getModelFromView(hs.get(i));
			ms.add(m);
		}
		return ms;
	}
	public static void save(Session session,gov.cqaudit.finance.data.core.model.CorePublicCustomBase m){
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

}
