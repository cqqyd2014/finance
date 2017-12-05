package gov.cqaudit.finance.system.action;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.HibernateException;



import gov.cqaudit.finance.common.LoginedAjaxAction;
import gov.cqaudit.finance.hibernate.HibernateSessionFactory;

@SuppressWarnings("serial")
@ParentPackage("bfkjs-default") 
@Namespace("/system")
public class ExitAction extends LoginedAjaxAction {


	@Actions({

		@Action( // 表示请求的Action及处理方法
				value = "exit", // 表示action的请求名称
				results = { // 表示结果跳转

						/*
						@Result(name = "success", params = { "actionName", "login_init", "namespace", "/login",
								"method", "login_init" }, type = "chain")

*/
						@Result(name = "success",location="/", type = "redirect")
				})

})
@Override
public String execute() {
// TODO Auto-generated method stub

super.execute();
if (user_id==null||user_id.equals("")) {
	return "success";
}
		
		 session = HibernateSessionFactory.getSession();
		 tx = session.beginTransaction();
		try {
			super.init_js_par(session);
			gov.cqaudit.finance.hibernate.dao.SysUserDAO sudao=new gov.cqaudit.finance.hibernate.dao.SysUserDAO();
			gov.cqaudit.finance.hibernate.entites.SysUser su=sudao.getEntityByUserId(session, user_id);
			su.setLastOnlineTime(new java.util.Date());
			su.setOnline(false);
			session.saveOrUpdate(su);

			tx.commit();
			sm.setSuccess(true);
			session_http.put("user_id", "");
			session_http.put("user_name", "");
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