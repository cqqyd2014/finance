package gov.cqaudit.finance.bills.all_bills.ajax.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.HibernateException;

import com.cqqyd2014.annotation.Authority;

import gov.cqaudit.finance.common.LoginedAjaxAction;
import gov.cqaudit.finance.hibernate.HibernateSessionFactory;

@ParentPackage("bfkjs-json-default")
@Namespace("/bills")
public class PermitBillAction   extends LoginedAjaxAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6604935288931674366L;
	String bill_uuid;
	String permit;
	String permit_message;



	@Action(value = "permit_bill", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			@InterceptorRef("authorityStack") })
@Authority(module = "permit_bill", privilege = "[00010004]", error_url = "authority_ajax_error")
	@Override
	public String execute() {
	// TODO Auto-generated method stub
	super.execute();
	sm.setAuth_success(true);
			
			 session = HibernateSessionFactory.getSession();
			 tx = session.beginTransaction();
			try {
				java.util.Date now=new java.util.Date();
				
				gov.cqaudit.finance.hibernate.dao.VBillMDAO vbmdao=new gov.cqaudit.finance.hibernate.dao.VBillMDAO();
				gov.cqaudit.finance.bills.model.BillM bm=vbmdao.getModelByUuid(session, bill_uuid);
				bm.setAudit_user_id(user_id);
				bm.setLast_audit_dat(now);
				
				//日志
				gov.cqaudit.finance.hibernate.dao.VBillMessageDAO mdao=new gov.cqaudit.finance.hibernate.dao.VBillMessageDAO();
				gov.cqaudit.finance.bills.model.BillMessage message=new gov.cqaudit.finance.bills.model.BillMessage();
				message.setBill_uuid(bill_uuid);
				message.setCreate_dat(now);
				message.setDept_id(dept_id);
				message.setIp_addr(ip_addr);
				if (permit.equals("同意")){
					message.setMessage("审核通过,备注："+permit_message);
					bm.setBill_status("打印待签");
				}
				else{
					bm.setBill_status("起草申请");
					message.setMessage("审核未通过,备注："+permit_message);
				}
				message.setMessage_uuid(com.cqqyd2014.util.StringUtil.getUUID());
				message.setType_id("0002");
				message.setUser_id(user_id);
				mdao.save(session, message);
				vbmdao.save(session, bm);
				sm.setBoolean_flag(true);
				
				
			sm.setSuccess(true);
			tx.commit();
			
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



	public String getBill_uuid() {
		return bill_uuid;
	}



	public void setBill_uuid(String bill_uuid) {
		this.bill_uuid = bill_uuid;
	}



	public String getPermit() {
		return permit;
	}



	public void setPermit(String permit) {
		this.permit = permit;
	}



	public String getPermit_message() {
		return permit_message;
	}



	public void setPermit_message(String permit_message) {
		this.permit_message = permit_message;
	}



}