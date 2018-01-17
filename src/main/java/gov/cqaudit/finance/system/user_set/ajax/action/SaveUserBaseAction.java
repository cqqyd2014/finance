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
public class SaveUserBaseAction extends LoginedAjaxAction {

String tell;
String email;

String user_id;




public String getUser_id() {
	return user_id;
}




public void setUser_id(String user_id) {
	this.user_id = user_id;
}






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




@Action(value = "save_user_base", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "save_user_base", privilege = "*", error_url = "authority_ajax_error")
@Override
public String execute() {
// TODO Auto-generated method stub
super.execute();
sm.setAuth_success(true);
		
		 session = HibernateSessionFactory.getSession();
		 tx=session.beginTransaction();
		try {
			gov.cqaudit.finance.hibernate.dao.VSysUserDAO updao=new gov.cqaudit.finance.hibernate.dao.VSysUserDAO();
			gov.cqaudit.finance.system.model.SysUser up=updao.getModelByUserId(session, user_id);
			up.setTell(tell);
			up.setEmail(email);
			updao.save(session, up);
			sm.setSuccess(true);
			
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