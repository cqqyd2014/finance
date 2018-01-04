package gov.cqaudit.finance.system.user.ajax.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.HibernateException;

import com.cqqyd2014.annotation.Authority;

import gov.cqaudit.finance.common.LoginedAjaxAction;
import gov.cqaudit.finance.hibernate.HibernateSessionFactory;

@SuppressWarnings("serial")
@ParentPackage("bfkjs-json-default")
@Namespace("/system")
public class AddUserAction extends LoginedAjaxAction {
	String  user_login;
	String user_name;
	String dept_id;
	String password1;
	String role_id;
	String tell;
	String email;
	





public String getTell() {
		return tell;
	}






	public void setTell(String tell) {
		this.tell = tell;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






public String getUser_login() {
		return user_login;
	}






	public void setUser_login(String user_login) {
		this.user_login = user_login;
	}






	public String getUser_name() {
		return user_name;
	}






	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}






	public String getDept_id() {
		return dept_id;
	}






	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}






	public String getPassword1() {
		return password1;
	}






	public void setPassword1(String password1) {
		this.password1 = password1;
	}






	public String getRole_id() {
		return role_id;
	}






	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}






@Action(value = "add_user", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "add_user", privilege = "*", error_url = "authority_ajax_error")
@Override
public String execute() {
// TODO Auto-generated method stub
super.execute();
sm.setAuth_success(true);
		
		 session = HibernateSessionFactory.getSession();
		 tx = session.beginTransaction();
		try {
			//检测是否有重复名称
			gov.cqaudit.finance.hibernate.dao.VSysUserDAO vdao=new gov.cqaudit.finance.hibernate.dao.VSysUserDAO();
			gov.cqaudit.finance.system.model.SysUser ms=vdao.getModelByLoginName(session, user_login);
			
			if (ms!=null){
				sm.setSuccess(false);
				sm.setBody("用户登录名重复");
			}
			else{
				gov.cqaudit.finance.system.model.SysUser m=new gov.cqaudit.finance.system.model.SysUser();
				m.setCreate_dat(new java.util.Date());
				m.setDept_id(dept_id);
				m.setEffective(true);
				m.setEmail(email);
				m.setLast_online_dat(com.cqqyd2014.util.DateUtil.ShortStringToJDate("1900-1-1"));
				m.setOnline(false);
				m.setPassword(com.cqqyd2014.util.StringUtil.md5(password1));
				m.setRole_id(role_id);
				m.setTell(tell);
				String user_uuid=com.cqqyd2014.util.StringUtil.getUUID();
				m.setUser_id(user_uuid);
				m.setUser_login_name(user_login);
				m.setUser_name(user_name);
				vdao.save(session, m);
				//更新处室人数
				gov.cqaudit.finance.hibernate.dao.VSysDeptDAO deptdao=new gov.cqaudit.finance.hibernate.dao.VSysDeptDAO();
				gov.cqaudit.finance.system.model.Dept m2=deptdao.getModelByDeptId(session,dept_id);
				java.math.BigDecimal num_old=m2.getUser_num();
				m2.setUser_num(num_old.add(new java.math.BigDecimal(1)));
				deptdao.save(session, m2);
				//默认用户参数
				gov.cqaudit.finance.system.model.UserPar upm=new gov.cqaudit.finance.system.model.UserPar();
				upm.setParam("default_rows_in_page");
				upm.setUserid(user_uuid);
				upm.setValue("50");
				upm.setParam_desc("默认一页显示行数");
				 gov.cqaudit.finance.hibernate.dao.UserParDAO updao=new gov.cqaudit.finance.hibernate.dao.UserParDAO();
				 updao.save(session, upm);
				//分配角色
				 
				 gov.cqaudit.finance.system.model.UserRole ur=new gov.cqaudit.finance.system.model.UserRole();
				 ur.setRole_id(role_id);
				 ur.setUser_id(user_uuid);
				 gov.cqaudit.finance.hibernate.dao.UserRoleDAO urdao=new gov.cqaudit.finance.hibernate.dao.UserRoleDAO();
				 urdao.save(session, ur);
				tx.commit();
				sm.setSuccess(true);
			}
			
			
		}

		catch (HibernateException e) {

			if (null != tx) {
				tx.rollback();// 撤销事务

			}

			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		 finally {
			HibernateSessionFactory.closeSession();
		}
		
		
		
		
		
		sm.setSuccess(true);
		msg=sm.toMap();
		return SUCCESS;

	}
}