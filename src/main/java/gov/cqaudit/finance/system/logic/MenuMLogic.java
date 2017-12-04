package gov.cqaudit.finance.system.logic;

public class MenuMLogic {
	public static gov.cqaudit.finance.system.model.MenuM getModelFromView(gov.cqaudit.finance.hibernate.entites.VUserMenuM vumm){
		gov.cqaudit.finance.system.model.MenuM mm=new gov.cqaudit.finance.system.model.MenuM();
		mm.setM_id(vumm.getId().getMenuId());
		mm.setM_name(vumm.getId().getMenuName());
		mm.setM_desc(vumm.getId().getDesc());
		return mm;
		
	}
	public static java.util.ArrayList<gov.cqaudit.finance.system.model.MenuM> getArrayListModelFromArrayListView(java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VUserMenuM> vumms){
		java.util.ArrayList<gov.cqaudit.finance.system.model.MenuM> mms=new java.util.ArrayList<>();
		for (int i=0;i<vumms.size();i++) {
			gov.cqaudit.finance.system.model.MenuM mm=getModelFromView(vumms.get(i));
			mms.add(mm);
		}
		return mms;
	}

}
