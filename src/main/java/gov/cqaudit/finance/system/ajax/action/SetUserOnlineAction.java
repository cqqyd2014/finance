package gov.cqaudit.finance.system.ajax.action;

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
public class SetUserOnlineAction extends LoginedAjaxAction {
	String  interval_time;
	String chinese_date;
	
	public String getInterval_time() {
		return interval_time;
	}
	public String getChinese_date() {
		return chinese_date;
	}
	public void setChinese_date(String chinese_date) {
		this.chinese_date = chinese_date;
	}
	public void setInterval_time(String interval_time) {
		this.interval_time = interval_time;
	}

	
@Action(value = "set_user_online", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "set_user_online", privilege = "*", error_url = "authority_ajax_error")
@Override
public String execute() {
// TODO Auto-generated method stub
super.execute();
sm.setAuth_success(true);
		
		 session = HibernateSessionFactory.getSession();
		 tx = session.beginTransaction();
		try {
			
			
			gov.cqaudit.finance.hibernate.dao.VSysUserDAO sudao=new gov.cqaudit.finance.hibernate.dao.VSysUserDAO();
			gov.cqaudit.finance.system.model.SysUser su=sudao.getEntityByUserId(session, user_id);
			su.setOnline(true);
			su.setLast_online_dat(new java.util.Date());
			sudao.save(session, su);
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