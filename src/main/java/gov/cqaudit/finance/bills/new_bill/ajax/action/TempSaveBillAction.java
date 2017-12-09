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
public class TempSaveBillAction   extends LoginedAjaxAction {
	
	String bill_uuid;
	String pro_name;
	String search_reason;
	String contract_name;
	String contract_tell;
	
	
	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getSearch_reason() {
		return search_reason;
	}

	public void setSearch_reason(String search_reason) {
		this.search_reason = search_reason;
	}

	public String getContract_name() {
		return contract_name;
	}

	public void setContract_name(String contract_name) {
		this.contract_name = contract_name;
	}

	public String getContract_tell() {
		return contract_tell;
	}

	public void setContract_tell(String contract_tell) {
		this.contract_tell = contract_tell;
	}

	public String getBill_uuid() {
		return bill_uuid;
	}

	public void setBill_uuid(String bill_uuid) {
		this.bill_uuid = bill_uuid;
	}

	String contract_mail;

	public String getContract_mail() {
		return contract_mail;
	}

	public void setContract_mail(String contract_mail) {
		this.contract_mail = contract_mail;
	}

	@Action(value = "temp_save_bill", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "temp_save_bill", privilege = "[00010001]", error_url = "authority_ajax_error")
	@Override
	public String execute() {
	// TODO Auto-generated method stub
	super.execute();
	sm.setAuth_success(true);
			
			 session = HibernateSessionFactory.getSession();
			 tx = session.beginTransaction();
			try {
				super.init_js_par(session);
				
				gov.cqaudit.finance.bills.model.BillM bm=gov.cqaudit.finance.bills.logic.BillMLogic.getModelFromView(
						gov.cqaudit.finance.hibernate.dao.VBillMDAO.getViewByUuid(session, bill_uuid));
				@SuppressWarnings("unchecked")
				java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD> dbs=(java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD>)
						session_http.get("new_bill_temp_billdetails");
				bm.setBds(dbs);
				
				bm.setContract_mail(contract_mail);
				bm.setContract_name(contract_name);
				bm.setContract_tell(contract_tell);
				bm.setLast_modify_dat(new java.util.Date());
				bm.setPro_name(pro_name);
				bm.setSearch_reason(search_reason);
				java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VPicture> vps=gov.cqaudit.finance.hibernate.dao.VPictureDAO.getArrayListEntityByBillUuid(session, bill_uuid);
				bm.setPics_num(new java.math.BigDecimal(vps.size()));
				
				
				
				gov.cqaudit.finance.bills.logic.BillMLogic.save(session, bm);
						
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
}