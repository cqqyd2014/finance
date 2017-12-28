package gov.cqaudit.finance.system.logic;

import org.hibernate.Session;

public final class UserParLogic {
	
	
	public static void save(Session session,gov.cqaudit.finance.system.model.UserPar up) {
		gov.cqaudit.finance.hibernate.entities.UserPar up_h=new gov.cqaudit.finance.hibernate.entities.UserPar();
		up_h.setId(new gov.cqaudit.finance.hibernate.entities.UserParId(up.getUserid(), up.getParam()));
		up_h.setParDesc(up.getParam_desc());
		up_h.setParValue(up.getValue());
		session.saveOrUpdate(up_h);
	}
	
	public static java.util.LinkedHashMap<String, String> getMapFromArrayListEntity(java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.UserPar> ups_h){
		java.util.LinkedHashMap<String, String> map=new java.util.LinkedHashMap<>();
for (int i=0;i<ups_h.size();i++) {
			
	gov.cqaudit.finance.system.model.UserPar up=getModelFromEntity(ups_h.get(i));
			map.put(up.getParam(), up.getValue());
		}
return map;
	}
	
	public static java.util.ArrayList<gov.cqaudit.finance.system.model.UserPar> getArrayListModelEntityFromArrayListEntity(java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.UserPar> ups_h){
		java.util.ArrayList<gov.cqaudit.finance.system.model.UserPar> ups=new java.util.ArrayList<>();
		for (int i=0;i<ups_h.size();i++) {
			
			gov.cqaudit.finance.system.model.UserPar up=getModelFromEntity(ups_h.get(i));
			ups.add(up);
		}
		return ups;
	}
	
	public static gov.cqaudit.finance.system.model.UserPar getModelFromEntity(gov.cqaudit.finance.hibernate.entities.UserPar up_h){
		gov.cqaudit.finance.system.model.UserPar up=new gov.cqaudit.finance.system.model.UserPar();
		
		up.setParam(up_h.getId().getParCode());
		up.setParam_desc(up_h.getParDesc());
		up.setUserid(up_h.getId().getUserId());
		up.setValue(up_h.getParValue());
		return up;
	}

}
