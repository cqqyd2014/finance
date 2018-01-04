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
public class DelUserAction extends LoginedAjaxAction {
	String user_uuid;
	


public String getUser_uuid() {
		return user_uuid;
	}



	public void setUser_uuid(String user_uuid) {
		this.user_uuid = user_uuid;
	}



@Action(value = "del_user", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "del_user", privilege = "*", error_url = "authority_ajax_error")
@Override
public String execute() {
// TODO Auto-generated method stub
super.execute();
sm.setAuth_success(true);
		
		 session = HibernateSessionFactory.getSession();
		 tx = session.beginTransaction();
		try {
			
				
					gov.cqaudit.finance.hibernate.dao.VSysUserDAO vudao=new gov.cqaudit.finance.hibernate.dao.VSysUserDAO();
					gov.cqaudit.finance.system.model.SysUser su=vudao.getModelByUserId(session, user_uuid);
					su.setEffective(false);
					vudao.save(session, su);
					
					
					
					tx.commit();
					sm.setSuccess(true);
				
				
			
			
			
			
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