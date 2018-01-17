package gov.cqaudit.finance.system.user_set.ajax.action;

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
public class ChangePasswordAction extends LoginedAjaxAction {

String user_password;
String new_password1;
String new_password2;
String user_id;




public String getUser_id() {
	return user_id;
}




public void setUser_id(String user_id) {
	this.user_id = user_id;
}




public String getUser_password() {
	return user_password;
}




public void setUser_password(String user_password) {
	this.user_password = user_password;
}




public String getNew_password1() {
	return new_password1;
}




public void setNew_password1(String new_password1) {
	this.new_password1 = new_password1;
}




public String getNew_password2() {
	return new_password2;
}




public void setNew_password2(String new_password2) {
	this.new_password2 = new_password2;
}




@Action(value = "change_password", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "change_password", privilege = "*", error_url = "authority_ajax_error")
@Override
public String execute() {
// TODO Auto-generated method stub
super.execute();
sm.setAuth_success(true);
		
		 session = HibernateSessionFactory.getSession();
		 tx=session.beginTransaction();
		try {
			gov.cqaudit.finance.hibernate.dao.VSysUserDAO updao=new gov.cqaudit.finance.hibernate.dao.VSysUserDAO();
			if (user_password==null){
				gov.cqaudit.finance.system.model.SysUser up=updao.getModelByUserId(session, user_id);
				
					up.setPassword(com.cqqyd2014.util.StringUtil.md5(new_password1));
					updao.save(session, up);
					sm.setSuccess(true);
			}
			
			else{
				gov.cqaudit.finance.system.model.SysUser up=updao.getModelByUserId(session, user_id);
				if (up.getPassword().equals(com.cqqyd2014.util.StringUtil.md5(user_password))){
					up.setPassword(com.cqqyd2014.util.StringUtil.md5(new_password1));
					updao.save(session, up);
					sm.setSuccess(true);
					
				}
				else{
					sm.setSuccess(false);
					sm.setBody("原始密码错误");
					
				}
			}
			
			
			tx.commit();
			
		}

		catch (HibernateException e) {

			if (null != tx) {
				tx.rollback();// 撤销事务

			}

			System.out.println(e.getMessage());
			e.printStackTrace();
			sm.setSuccess(false);
			sm.setBody("Hibernate数据错误");
		}

		 finally {
			HibernateSessionFactory.closeSession();
		}
		
		
		
		
		
		msg=sm.toMap();
		
		return SUCCESS;

	}
}