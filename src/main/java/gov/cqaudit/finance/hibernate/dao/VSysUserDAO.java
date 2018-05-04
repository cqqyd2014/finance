package gov.cqaudit.finance.hibernate.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;

public class VSysUserDAO extends GetModelFromEntityViewDAO<gov.cqaudit.finance.system.model.SysUser>{
	@SuppressWarnings("unchecked")
	public java.util.ArrayList<gov.cqaudit.finance.system.model.SysUser> getAllModel(Session session) {
		String hql = "from VSysUser order by id.deptName,id.userName";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		


		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSysUser> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSysUser>) q
				.list();
		return (java.util.ArrayList<gov.cqaudit.finance.system.model.SysUser>)getArrayListModelFromArrayListViewEntity(sws);
	}
	
	@SuppressWarnings("unchecked")
	public java.util.ArrayList<gov.cqaudit.finance.system.model.SysUser> getAllModelPages(Session session,String page,String rows) {
		int i_page=Integer.parseInt(page);
		int i_rows=Integer.parseInt(rows);
		
		String hql = "from VSysUser order by id.deptName,id.userName";
		int offset = i_rows * (i_page - 1);
		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql).setFirstResult(offset)
				.setMaxResults(i_rows);
		

		
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSysUser> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSysUser>) q
				.list();
		return (java.util.ArrayList<gov.cqaudit.finance.system.model.SysUser>)getArrayListModelFromArrayListViewEntity(sws);
	}
	
	
	public gov.cqaudit.finance.system.model.SysUser getModelByUserId(Session session, String user_id) {
		String hql = "from VSysUser where id.userId=:user_id";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		q.setParameter("user_id", user_id);

		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSysUser> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSysUser>) q
				.list();
		if (sws.size() == 0) {
			System.out.println("不能得到用户数据，参数user_id:" + user_id);
			return null;
		} else {
			return getModelFromViewEntity(sws.get(0));
		}
	}
	public gov.cqaudit.finance.system.model.SysUser getModelByLoginName(Session session, String user_login_name) {
		String hql = "from VSysUser where id.effective=true and id.userLogin=:user_login_name";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		q.setParameter("user_login_name", user_login_name);

		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSysUser> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSysUser>) q
				.list();
		if (sws.size() == 0) {
			System.out.println("不能得到用户数据，参数user_login_name:" + user_login_name);
			return null;
		} else {
			return getModelFromViewEntity(sws.get(0));
		}
	}
	@Override
	public <T> void save(Session session, T t) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.system.model.SysUser m=(gov.cqaudit.finance.system.model.SysUser)t;
		gov.cqaudit.finance.hibernate.entities.SysUser su_h=new gov.cqaudit.finance.hibernate.entities.SysUser();
		su_h.setCreateTime(m.getCreate_dat());
		su_h.setDeptId(m.getDept_id());
		su_h.setEffective(m.isEffective());
		su_h.setEmail(m.getEmail());
		su_h.setUserId(m.getUser_id());
		su_h.setLastOnlineTime(m.getLast_online_dat());
		su_h.setUserName(m.getUser_name());
		su_h.setOnline(m.isOnline());
		su_h.setPwd(m.getPassword());
		su_h.setTel(m.getTell());
		su_h.setUserLogin(m.getUser_login_name());
		
		
		
		
		session.saveOrUpdate(su_h);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public <T, S> T getModelFromViewEntity(S s) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.hibernate.entities.VSysUser h=(gov.cqaudit.finance.hibernate.entities.VSysUser)s;
		gov.cqaudit.finance.system.model.SysUser su=new gov.cqaudit.finance.system.model.SysUser();
		su.setDept_id(h.getId().getDeptId());
		su.setDept_name(h.getId().getDeptName());
		su.setPassword(h.getId().getPwd());
		su.setRole_id(h.getId().getRoleId());
		su.setRole_name(h.getId().getRoleName());
		su.setUser_id(h.getId().getUserId());
		su.setUser_login_name(h.getId().getUserLogin());
		su.setUser_name(h.getId().getUserName());
		su.setEffective(h.getId().getEffective());
		su.setOnline(h.getId().getOnline());
		su.setLast_online_dat(h.getId().getLastOnlineTime());
		su.setCreate_dat(h.getId().getCreateTime());
		su.setEmail(h.getId().getEmail());
		su.setTell(h.getId().getTel());
		su.setCreate_dat_print(com.cqqyd2014.util.DateUtil.getPrintSimpleString(h.getId().getCreateTime()));
		su.setLast_online_dat_print(com.cqqyd2014.util.DateUtil.getPrintFullString(h.getId().getLastOnlineTime()));
		if (h.getId().getEffective()){
			su.setEffective_print("有效");
		}
		else{
			su.setEffective_print("停用");
		}
		
		return (T)su;
	}
}
