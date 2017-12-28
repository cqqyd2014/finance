package gov.cqaudit.finance.data.core.logic;

import org.hibernate.Session;

public final class CorePrivateCustomBaseLogic {
	public static gov.cqaudit.finance.data.core.model.CorePrivateCustomBase getModelFromView(gov.cqaudit.finance.hibernate.entities.VDataCorePrivateCustomBase h){
		gov.cqaudit.finance.data.core.model.CorePrivateCustomBase m=new gov.cqaudit.finance.data.core.model.CorePrivateCustomBase();
		m.setBank_code(h.getId().getBankCode());
		m.setPrivate_company(h.getId().getPrivateCompany());
		m.setPrivate_custom_id(h.getId().getPrivateCustomId());
		m.setPrivate_custom_name(h.getId().getPrivateCustomName());
		m.setPrivate_id_card(h.getId().getPrivateIdCard());
		m.setPrivate_post_address(h.getId().getPrivatePostAddress());
		m.setPrivate_work_address(h.getId().getPrivateWorkAddress());
		return m;
		
	}
	public static java.util.ArrayList<gov.cqaudit.finance.data.core.model.CorePrivateCustomBase> getArrayListModelFromArrayListView(java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VDataCorePrivateCustomBase> hs){
		java.util.ArrayList<gov.cqaudit.finance.data.core.model.CorePrivateCustomBase> ms=new java.util.ArrayList<>();
		for (int i=0,len=hs.size();i<len;i++){
			gov.cqaudit.finance.data.core.model.CorePrivateCustomBase m=getModelFromView(hs.get(i));
			ms.add(m);
		}
		return ms;
	}
	public static void save(Session session,gov.cqaudit.finance.data.core.model.CorePrivateCustomBase m){
		gov.cqaudit.finance.hibernate.entities.DataCorePrivateCustomBase h=new gov.cqaudit.finance.hibernate.entities.DataCorePrivateCustomBase();
		h.setId(new gov.cqaudit.finance.hibernate.entities.DataCorePrivateCustomBaseId(m.getBank_code(), m.getPrivate_custom_id()));
		h.setPrivateCompany(m.getPrivate_company());
		h.setPrivateCustomName(m.getPrivate_custom_name());
		h.setPrivateIdCard(m.getPrivate_id_card());
		h.setPrivatePostAddress(m.getPrivate_post_address());
		h.setPrivateWorkAddress(m.getPrivate_work_address());
		session.merge(h);
	}

}
