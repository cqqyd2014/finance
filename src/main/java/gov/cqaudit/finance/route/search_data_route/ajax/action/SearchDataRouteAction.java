package gov.cqaudit.finance.route.search_data_route.ajax.action;

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
@Namespace("/route")
public class SearchDataRouteAction extends LoginedAjaxAction {

	String account_name;
	


public String getAccount_name() {
		return account_name;
	}



	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}



@Action(value = "search_data_route", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "search_data_route", privilege = "*", error_url = "authority_ajax_error")
@Override
public String execute() {
// TODO Auto-generated method stub
super.execute();
sm.setAuth_success(true);
		
		 session = HibernateSessionFactory.getSession();
		 
		try {
			gov.cqaudit.finance.hibernate.dao.VBillDBackDAO vbdao=new gov.cqaudit.finance.hibernate.dao.VBillDBackDAO();
			java.util.ArrayList<gov.cqaudit.finance.bills.model.BillDBack> ms=vbdao.getArrayListModelLikeAccountName(session, account_name);
 			
			
			
			msg=new java.util.HashMap<String,Object>();
			msg.put("total", String.valueOf(ms.size()));
			msg.put("rows", ms);
			
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
		
		
		
		
		
		
		return SUCCESS;

	}
}