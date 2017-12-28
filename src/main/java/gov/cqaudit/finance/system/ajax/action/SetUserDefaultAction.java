package gov.cqaudit.finance.system.ajax.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.cqqyd2014.annotation.Authority;



import com.opensymphony.xwork2.ActionSupport;

import gov.cqaudit.finance.common.LoginedAjaxAction;
import gov.cqaudit.finance.hibernate.HibernateSessionFactory;

@SuppressWarnings("serial")
@ParentPackage("bfkjs-json-default")
@Namespace("/system")
public class SetUserDefaultAction  extends LoginedAjaxAction{
	private Map<String, Object> msg;
	String par_code;
	String par_value;
	public String getPar_code() {
		return par_code;
	}

	public void setPar_code(String par_code) {
		this.par_code = par_code;
	}

	public String getPar_value() {
		return par_value;
	}

	public void setPar_value(String par_value) {
		this.par_value = par_value;
	}

	public Map<String, Object> getMsg() {
		return msg;
	}

	public void setMsg(Map<String, Object> msg) {
		this.msg = msg;
	}
	@Action(value = "set_user_default", results = { @Result(type = "json", params = { "root", "msg" })  }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "set_user_default", privilege = "*", error_url = "authority_ajax_error")
@Override
public String execute() {
// TODO Auto-generated method stub
super.execute();
sm.setAuth_success(true);
		session = HibernateSessionFactory.getSession();
			
			
			tx = session.beginTransaction();
			try {
				//System.out.println(par_code);
				
				
				
				
				gov.cqaudit.finance.hibernate.dao.SysUserDAO.setValue(session,user_id, par_code, par_value);
				
				session_http.put(par_code, par_value);

				sm.setSuccess(true);
				tx.commit();

			}

			catch (HibernateException e) {

				if (null != tx) {
					tx.rollback();// 撤销事务

				}

				sm.setSuccess(false);
				sm.setBody(e.toString());

			} 
			

			finally {
				HibernateSessionFactory.closeSession();
			}
		
		
		msg=sm.toMap();
		return ActionSupport.SUCCESS;
	}

}