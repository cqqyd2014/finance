package gov.cqaudit.finance.system.logic;

import org.hibernate.Session;

public class SysUserLogic {
	
	public static gov.cqaudit.finance.system.model.SysUser getModelFromView(gov.cqaudit.finance.hibernate.entities.VSysUser vsu){
		gov.cqaudit.finance.system.model.SysUser su=new gov.cqaudit.finance.system.model.SysUser();
		su.setDept_id(vsu.getId().getDeptId());
		su.setDept_name(vsu.getId().getDeptName());
		su.setPassword(vsu.getId().getPwd());
		su.setRole_id(vsu.getId().getRoleId());
		su.setRole_name(vsu.getId().getRoleName());
		su.setUser_id(vsu.getId().getId());
		su.setUser_login_name(vsu.getId().getUserLogin());
		su.setUser_name(vsu.getId().getName());
		su.setEffective(vsu.getId().getEffective());
		su.setOnline(vsu.getId().getOnline());
		su.setLast_online_dat(vsu.getId().getLastOnlineTime());
		su.setCreate_dat(vsu.getId().getCreateTime());
		su.setEmail(vsu.getId().getEmail());
		su.setTell(vsu.getId().getTel());
		return su;
	}
	public static java.util.ArrayList<gov.cqaudit.finance.system.model.SysUser> getArrayListModelFromArrayListView(java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSysUser> vsus){
		java.util.ArrayList<gov.cqaudit.finance.system.model.SysUser> sus=new java.util.ArrayList<>();
		for (int i=0;i<vsus.size();i++) {
			gov.cqaudit.finance.system.model.SysUser su=getModelFromView(vsus.get(i));
			sus.add(su);
		}
		return sus;
		
	}
	public static void save(Session session,gov.cqaudit.finance.system.model.SysUser su) {
		gov.cqaudit.finance.hibernate.entities.SysUser su_h=new gov.cqaudit.finance.hibernate.entities.SysUser();
		su_h.setCreateTime(su.getCreate_dat());
		su_h.setDeptId(su.getDept_id());
		su_h.setEffective(su.isEffective());
		su_h.setEmail(su.getEmail());
		su_h.setId(su.getUser_id());
		su_h.setLastOnlineTime(su.getLast_online_dat());
		su_h.setName(su.getUser_name());
		su_h.setOnline(su.isOnline());
		su_h.setPwd(su.getPassword());
		su_h.setTel(su.getTell());
		su_h.setUserLogin(su.getUser_login_name());
		
		
		
		
		session.saveOrUpdate(su_h);
	}
	

}
