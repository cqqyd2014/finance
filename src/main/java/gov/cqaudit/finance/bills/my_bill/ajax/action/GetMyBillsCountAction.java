package gov.cqaudit.finance.bills.my_bill.ajax.action;

import java.math.BigInteger;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Session;

import com.cqqyd2014.annotation.Authority;

import gov.cqaudit.finance.bills.common.ajax.action.BillCountAjaxAction;
@SuppressWarnings("serial")
@ParentPackage("bfkjs-json-default")
@Namespace("/bills")
public class GetMyBillsCountAction extends BillCountAjaxAction{



	@Override
	public BigInteger getBillsCount(Session session, String search_bill_bill_status, String search_bill_contract_name,
			String search_bill_pro_name, String create_user_id) {
		
		// TODO Auto-generated method stub
		if (search_bill_bill_status.equals("0")){
			search_bill_bill_status=null;
		}
		gov.cqaudit.finance.hibernate.dao.VBillMDAO vbmdao=new gov.cqaudit.finance.hibernate.dao.VBillMDAO();
		
		return vbmdao.getBillUuidsCount(session,search_bill_bill_status, search_bill_contract_name, search_bill_pro_name, user_id);
	}
	@Action(value = "get_my_bills_count", results = { @Result(type = "json", params = { "root", "bill_count" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "get_my_bills_count", privilege = "[00010002]", error_url = "authority_ajax_error")
	@Override
	public String getJson() {
		// TODO Auto-generated method stub
		setBill_count(getCountImpl());
		return SUCCESS;
	}

}
