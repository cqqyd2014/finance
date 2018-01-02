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
	String bill_uuid;
	

	

	public String getBill_uuid() {
		return bill_uuid;
	}




	public void setBill_uuid(String bill_uuid) {
		this.bill_uuid = bill_uuid;
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
				
				

				gov.cqaudit.finance.hibernate.dao.VBillDBackDAO vbdao=new gov.cqaudit.finance.hibernate.dao.VBillDBackDAO();
				java.util.ArrayList<gov.cqaudit.finance.bills.model.BillDBack> bds=vbdao.getArrayListViewByBillUuid(session, bill_uuid);
				msg=new java.util.HashMap<>();
				msg.put("total", String.valueOf(bds.size()));
				msg.put("rows", bds);
				
				
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
		
		return SUCCESS;
	}
}