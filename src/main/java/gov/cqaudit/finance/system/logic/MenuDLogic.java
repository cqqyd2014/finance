package gov.cqaudit.finance.system.logic;

public class MenuDLogic {
	public gov.cqaudit.finance.system.model.MenuD getModelFromView(gov.cqaudit.finance.hibernate.entites.VUserMenuD vumd){
		gov.cqaudit.finance.system.model.MenuD md=new gov.cqaudit.finance.system.model.MenuD();
		md.setD_id(vumd.getId().getMenuDId());
		md.setId(vumd.getId().getMenuId());
		md.setD_name(vumd.getId().getMenuDName());
		md.setMenu_d_js_method(vumd.getId().getMenuDJsMethod());
		md.setMd_desc(vumd.getId().getWebAttentionTips());
		return md;
	}
	public java.util.ArrayList<gov.cqaudit.finance.system.model.MenuD> getArrayListModelFromArrayListView(java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VUserMenuD> vumds){
		java.util.ArrayList<gov.cqaudit.finance.system.model.MenuD> mds=new java.util.ArrayList<>();
		for (int i=0;i<vumds.size();i++) {
			gov.cqaudit.finance.system.model.MenuD md=getModelFromView(vumds.get(i));
			mds.add(md);
		}
		return mds;
	}

}
