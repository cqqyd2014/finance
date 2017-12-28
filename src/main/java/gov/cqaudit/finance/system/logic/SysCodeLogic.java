package gov.cqaudit.finance.system.logic;

import org.hibernate.Session;

public class SysCodeLogic {
	
	public static gov.cqaudit.finance.system.model.SysCode getModelFromEntity(gov.cqaudit.finance.hibernate.entities.SysCode sc_h) {
		gov.cqaudit.finance.system.model.SysCode sc=new gov.cqaudit.finance.system.model.SysCode();
		sc.setCode(sc_h.getId().getSCode());
		sc.setValue(sc_h.getSValue());
		return sc;
	}
	
	public static java.util.ArrayList<gov.cqaudit.finance.system.model.SysCode> getArrayListModelFromArrayListEntity(java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.SysCode> scs_h){
		java.util.ArrayList<gov.cqaudit.finance.system.model.SysCode> scs=new java.util.ArrayList<>();
		for (int i=0;i<scs_h.size();i++) {
			gov.cqaudit.finance.system.model.SysCode sc=getModelFromEntity(scs_h.get(i));
			scs.add(sc);
		}
		return scs;
	}
	
	public static java.util.ArrayList<gov.cqaudit.finance.system.model.SysCode> getArrayListModelBySId(Session session,String s_id){
		return getArrayListModelFromArrayListEntity(gov.cqaudit.finance.hibernate.dao.SysCodeDAO.getEntityByCode(session, s_id));
	}
	public static java.util.ArrayList<gov.cqaudit.finance.system.model.SysCode> getArrayListModelFromArrayListView(java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBusinessSearchPar> vbsps_h){
		java.util.ArrayList<gov.cqaudit.finance.system.model.SysCode> scs=new java.util.ArrayList<>();
		for (int i=0;i<vbsps_h.size();i++) {
			gov.cqaudit.finance.system.model.SysCode sc=getModelFromView(vbsps_h.get(i));
			scs.add(sc);
		}
		return scs;
	}
	
	public static gov.cqaudit.finance.system.model.SysCode getModelFromView(gov.cqaudit.finance.hibernate.entities.VBusinessSearchPar vbsp_h){
		gov.cqaudit.finance.system.model.SysCode sc=new gov.cqaudit.finance.system.model.SysCode();
		sc.setCode(vbsp_h.getId().getSCode());
		sc.setValue(vbsp_h.getId().getSValue());
		return sc;
	}

	
	public static java.util.ArrayList<gov.cqaudit.finance.system.model.SysCode> getArrayListModelByBusinessCode(Session session,String business_code){
		return getArrayListModelFromArrayListView(
				gov.cqaudit.finance.hibernate.dao.VBusinessSearchParDAO.getEntityByBusinessCode(session, business_code));
	}
 }
