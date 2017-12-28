package gov.cqaudit.finance.bills.my_bill.ajax.action;

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
@Namespace("/bills")
public class GetSearchResultAction   extends LoginedAjaxAction {
	String search_rs_uuid;
	

	public String getSearch_rs_uuid() {
		return search_rs_uuid;
	}


	public void setSearch_rs_uuid(String search_rs_uuid) {
		this.search_rs_uuid = search_rs_uuid;
	}


	@Action(value = "get_search_result", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("authorityStack") })
@Authority(module = "get_search_result", privilege = "[00010002]", error_url = "authority_ajax_error")
	@Override
	public String execute() {
	// TODO Auto-generated method stub
	super.execute();
	sm.setAuth_success(true);
			
			 session = HibernateSessionFactory.getSession();
			 
			try {
				
				
				@SuppressWarnings("unchecked")
				java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD> bds=(java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD>)session_http.get("new_bill_temp_billdetails");
				
				
				
				
			sm.setSuccess(true);
			sm.setO(bds);
			
		}

		catch (HibernateException e) {
			
			if (null != tx) {
				tx.rollback();// 撤销事务

			}
			sm.setSuccess(false);
			sm.setBody(e.toString());
			
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