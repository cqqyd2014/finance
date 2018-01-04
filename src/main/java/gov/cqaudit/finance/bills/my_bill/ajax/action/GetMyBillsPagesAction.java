package gov.cqaudit.finance.bills.my_bill.ajax.action;

import java.util.ArrayList;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Session;

import com.cqqyd2014.annotation.Authority;

import gov.cqaudit.finance.bills.common.ajax.action.BillPagesAjaxAction;

@SuppressWarnings("serial")
@ParentPackage("bfkjs-json-default")
@Namespace("/bills")
public class GetMyBillsPagesAction extends BillPagesAjaxAction{



	@Action(value = "get_my_bills_pages", results = { @Result(type = "json", params = { "root", "bills" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "get_my_bills_pages", privilege = "[00010002]", error_url = "authority_ajax_error")
	public String getJson()  {
		// TODO Auto-generated method stub
		setBills(getList());
		return SUCCESS;
	}

	@Override
	public ArrayList<String> getBills(Session session, String rows, String page, String bill_status,
			String contract_name, String pro_name, String create_user_id) {
		
		gov.cqaudit.finance.hibernate.dao.VBillMDAO vbmdao=new gov.cqaudit.finance.hibernate.dao.VBillMDAO();
		
		java.util.ArrayList<String> bills_uuids=vbmdao.getArrayListBillUuids(session, rows, page, bill_status, contract_name, pro_name, user_id);
		
		
		return bills_uuids;
	}
	
	
}
