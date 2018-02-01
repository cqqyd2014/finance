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
public class PostAddOnAction   extends LoginedAjaxAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6604935288931674366L;
	String bill_uuid;
	



	@Action(value = "post_addon", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			@InterceptorRef("authorityStack") })
@Authority(module = "post_addon", privilege = "[00010001]", error_url = "authority_ajax_error")
	@Override
	public String execute() {
	// TODO Auto-generated method stub
	super.execute();
	sm.setAuth_success(true);
			
			 session = HibernateSessionFactory.getSession();
			 tx = session.beginTransaction();
			try {
				
				gov.cqaudit.finance.hibernate.dao.VPictureDAO vpdao=new gov.cqaudit.finance.hibernate.dao.VPictureDAO();
				java.util.ArrayList<gov.cqaudit.finance.bills.model.Picture> ps=vpdao.getArrayListModelByBillUuid(session, bill_uuid);
				if (ps.size()==0){
					sm.setSuccess(false);
					sm.setBody("附件数量为0，不能提交附件");
				}
				else{
					gov.cqaudit.finance.hibernate.dao.VBillMDAO vbmdao=new gov.cqaudit.finance.hibernate.dao.VBillMDAO();
					gov.cqaudit.finance.bills.model.BillM bm=vbmdao.getModelByUuid(session, bill_uuid);
					bm.setBill_status("等待传单");
					vbmdao.save(session, bm);
					//日志
					gov.cqaudit.finance.hibernate.dao.VBillMessageDAO mdao=new gov.cqaudit.finance.hibernate.dao.VBillMessageDAO();
					gov.cqaudit.finance.bills.model.BillMessage message=new gov.cqaudit.finance.bills.model.BillMessage();
					message.setBill_uuid(bill_uuid);
					message.setCreate_dat(new java.util.Date());
					message.setDept_id(dept_id);
					message.setIp_addr(ip_addr);
					message.setMessage("提交附件成功");
					message.setMessage_uuid(com.cqqyd2014.util.StringUtil.getUUID());
					message.setType_id("0001");
					message.setUser_id(user_id);
					mdao.save(session, message);
					
					
				}
				
				
				
				
				
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






}