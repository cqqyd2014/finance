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
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "post_search_request", privilege = "[00010001]", error_url = "authority_ajax_error")
	@Override
	public String execute() {
	// TODO Auto-generated method stub
	super.execute();
	sm.setAuth_success(true);
			
			 session = HibernateSessionFactory.getSession();
			 tx = session.beginTransaction();
			try {
				//检查图片附件数量
				gov.cqaudit.finance.hibernate.dao.VPictureDAO vpdao=new gov.cqaudit.finance.hibernate.dao.VPictureDAO();
				java.util.ArrayList<gov.cqaudit.finance.bills.model.Picture> pics=vpdao.getArrayListViewByBillUuid(session, bill_uuid);
				if (pics.size()==0){
					sm.setSuccess(true);
					sm.setBoolean_flag(false);
					sm.setBody("提交的申请，图片附件数量为0，至少提交一个附件");
					tx.rollback();
				}
				else{
					gov.cqaudit.finance.hibernate.dao.VBillMDAO vbdao=new gov.cqaudit.finance.hibernate.dao.VBillMDAO();
					gov.cqaudit.finance.bills.model.BillM bm=vbdao.getModelByUuid(session, bill_uuid);
					bm.setBill_status("等待传单");
					vbdao.save(session, bm);
					sm.setBoolean_flag(true);
					tx.commit();
					sm.setSuccess(true);
					sm.setO(bm);
					
				}
				
				
				
				
				
				
				
			
			
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