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
public class DelBillDetailAction   extends LoginedAjaxAction {
	
	String detail_uuid;
	

	public String getDetail_uuid() {
		return detail_uuid;
	}


	public void setDetail_uuid(String detail_uuid) {
		this.detail_uuid = detail_uuid;
	}


	@Action(value = "del_bill_detail", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "del_bill_detail", privilege = "[00010001]", error_url = "authority_ajax_error")
	@Override
	public String execute() {
	// TODO Auto-generated method stub
	super.execute();
	sm.setAuth_success(true);
			
			 session = HibernateSessionFactory.getSession();
			 tx = session.beginTransaction();
			try {
				
				
				@SuppressWarnings("unchecked")
				java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD> bds=(java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD>)session_http.get("new_bill_temp_billdetails");
				java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD> bds_new=new java.util.ArrayList<>();
				gov.cqaudit.finance.hibernate.dao.VBillDDAO vbddao=new gov.cqaudit.finance.hibernate.dao.VBillDDAO();
				for (int i=0;i<bds.size();i++) {
					gov.cqaudit.finance.bills.model.BillD bd=bds.get(i);
					if (bd.getDetail_uuid().equals(detail_uuid)) {
						//一致的不添加到新数组
						bd.setEffective(false);
						bd.setUn_effective_dat(new java.util.Date());
						bd.setUn_effective_userid(user_id);
						vbddao.save(session, bd);
					}
					else {
						bds_new.add(bd);
					}
				}
			
				session_http.put("new_bill_temp_billdetails", bds_new);
				
				tx.commit();
				
			sm.setSuccess(true);
			sm.setO(bds_new);
			
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