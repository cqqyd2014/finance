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
public class AddBillDetailAction   extends LoginedAjaxAction {
	String business_code;
	String bill_uuid;
	String search_par_code;
	String search_par_value;
	String bank_code;
	
	public String getBill_uuid() {
		return bill_uuid;
	}

	public void setBill_uuid(String bill_uuid) {
		this.bill_uuid = bill_uuid;
	}


	public String getSearch_par_code() {
		return search_par_code;
	}

	public void setSearch_par_code(String search_par_code) {
		this.search_par_code = search_par_code;
	}

	public String getSearch_par_value() {
		return search_par_value;
	}

	public void setSearch_par_value(String search_par_value) {
		this.search_par_value = search_par_value;
	}

	public String getBank_code() {
		return bank_code;
	}

	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}

	public String getBusiness_code() {
		return business_code;
	}

	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}

	@Action(value = "add_bill_detail", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "add_bill_detail", privilege = "[00010001]", error_url = "authority_ajax_error")
	@Override
	public String execute() {
	// TODO Auto-generated method stub
	super.execute();
	sm.setAuth_success(true);
			
			 session = HibernateSessionFactory.getSession();
			 
			try {
				super.init_js_par(session);
				
				@SuppressWarnings("unchecked")
				java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD> bds=(java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD>)session_http.get("new_bill_temp_billdetails");
				gov.cqaudit.finance.bills.model.BillD bd=new gov.cqaudit.finance.bills.model.BillD();
				bd.setBill_uuid(bill_uuid);
				bd.setDetail_uuid(com.cqqyd2014.util.StringUtil.getUUID());
				bd.setBank_code(bank_code);
				bd.setBank_name(gov.cqaudit.finance.hibernate.dao.SysCodeDAO.getValueBySIdCode(session, "bank_code", bank_code));
				bd.setBusiness_code(business_code);
				bd.setBusiness_code_name(gov.cqaudit.finance.hibernate.dao.SysCodeDAO.getValueBySIdCode(session, "business_code", business_code));
				
				bd.setSearch_par_code(search_par_code);
				bd.setSearch_par_code_name(gov.cqaudit.finance.hibernate.dao.SysCodeDAO.getValueBySIdCode(session, "search_par_code", search_par_code));
				bd.setSearch_par_value(search_par_value);
				bds.add(bd);
			
				session_http.put("new_bill_temp_billdetails", bds);
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