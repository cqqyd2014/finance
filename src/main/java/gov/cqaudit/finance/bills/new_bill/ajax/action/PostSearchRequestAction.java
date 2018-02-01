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
public class PostSearchRequestAction   extends LoginedAjaxAction {
	
	String bill_uuid;
	



	public String getBill_uuid() {
		return bill_uuid;
	}




	public void setBill_uuid(String bill_uuid) {
		this.bill_uuid = bill_uuid;
	}




	@Action(value = "post_search_request", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("authorityStack") })
@Authority(module = "post_search_request", privilege = "[00010001]", error_url = "authority_ajax_error")
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
					bm.setBill_status("申请待审");
					vbdao.save(session, bm);
					
					
					//写入事件
					gov.cqaudit.finance.hibernate.dao.VBillMessageDAO vbmdao=new gov.cqaudit.finance.hibernate.dao.VBillMessageDAO();
					gov.cqaudit.finance.bills.model.BillMessage message=new gov.cqaudit.finance.bills.model.BillMessage();
					message.setBill_uuid(bill_uuid);
					message.setCreate_dat(new java.util.Date());
					message.setDept_id(dept_id);
					message.setIp_addr(ip_addr);
					message.setMessage("提交查询单，等待金融处审核");
					message.setMessage_uuid(com.cqqyd2014.util.StringUtil.getUUID());
					message.setType_id("0001");
					message.setUser_id(user_id);
					
					vbmdao.save(session, message);
					
					sm.setBoolean_flag(true);
					
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