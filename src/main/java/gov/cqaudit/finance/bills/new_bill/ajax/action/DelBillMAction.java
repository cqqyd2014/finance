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
public class DelBillMAction   extends LoginedAjaxAction {
	
	String bill_uuid;
	



	public String getBill_uuid() {
		return bill_uuid;
	}




	public void setBill_uuid(String bill_uuid) {
		this.bill_uuid = bill_uuid;
	}




	@Action(value = "del_bill_m", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "del_bill_m", privilege = "[00010001]", error_url = "authority_ajax_error")
	@Override
	public String execute() {
	// TODO Auto-generated method stub
	super.execute();
	sm.setAuth_success(true);
			
			 session = HibernateSessionFactory.getSession();
			 tx = session.beginTransaction();
			try {
				
				gov.cqaudit.finance.hibernate.dao.VBillMDAO vbdao=new gov.cqaudit.finance.hibernate.dao.VBillMDAO();
				gov.cqaudit.finance.bills.model.BillM bm=vbdao.getModelByUuid(session, bill_uuid);
				bm.setEffective(false);
				bm.setUneffecitve_user_id(user_id);
				java.util.Date now=new java.util.Date();
				bm.setUneffective_dat(now);
				vbdao.save(session, bm);
				tx.commit();
				
				
				
			sm.setSuccess(true);
			sm.setO(bm);
			
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