package gov.cqaudit.finance.bills.new_bill.ajax.action;

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
public class GetBillPicsAction   extends LoginedAjaxAction {
	String bill_uuid;
	

	public String getBill_uuid() {
		return bill_uuid;
	}


	public void setBill_uuid(String bill_uuid) {
		this.bill_uuid = bill_uuid;
	}


	@Action(value = "get_bill_pics", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "get_bill_pics", privilege = "[00010001]", error_url = "authority_ajax_error")
	@Override
	public String execute() {
	// TODO Auto-generated method stub
	super.execute();
	
			
			 session = HibernateSessionFactory.getSession();
			 
			try {
				
				
				gov.cqaudit.finance.hibernate.dao.VPictureDAO vpdao=new gov.cqaudit.finance.hibernate.dao.VPictureDAO();
				java.util.ArrayList<gov.cqaudit.finance.bills.model.Picture> pics=vpdao.getArrayListViewByBillUuid(session, bill_uuid);
				
			
			
			sm.setSuccess(true);
			sm.setO(pics);
			
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