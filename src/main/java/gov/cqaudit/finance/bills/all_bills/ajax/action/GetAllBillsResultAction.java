package gov.cqaudit.finance.bills.all_bills.ajax.action;

import java.util.ArrayList;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Session;

import com.cqqyd2014.annotation.Authority;

import gov.cqaudit.finance.bills.common.ajax.action.BillsReslutAction;
@ParentPackage("bfkjs-json-default")
@Namespace("/bills")
public class GetAllBillsResultAction extends BillsReslutAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8297682151018541768L;

	@Override
	public String getTotalImpl(Session session, String search_bill_bill_status, String search_bill_contract_name,
			String search_bill_pro_name, String create_user_id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String bill_status=null;
				if (search_bill_bill_status.equals("0")){
					bill_status=null;
				}
				else{
					bill_status=search_bill_bill_status;
				}
				gov.cqaudit.finance.hibernate.dao.VBillMDAO vbmdao=new gov.cqaudit.finance.hibernate.dao.VBillMDAO();
				return vbmdao.getBillUuidsCount(session,bill_status, search_bill_contract_name, search_bill_pro_name, null).toString();
	}

	@Override
	public ArrayList<String> getBillsImpl(Session session, String rows, String page, String search_bill_bill_status,
			String search_bill_contract_name, String search_bill_pro_name, String create_user_id) {
		// TODO Auto-generated method stub
		String bill_status=null;
		if (search_bill_bill_status.equals("0")){
			bill_status=null;
		}
		else{
			bill_status=search_bill_bill_status;
		}
		gov.cqaudit.finance.hibernate.dao.VBillMDAO vbmdao=new gov.cqaudit.finance.hibernate.dao.VBillMDAO();
java.util.ArrayList<String> bills_uuids=vbmdao.getArrayListBillUuids(session, rows, page, bill_status, search_bill_contract_name, search_bill_pro_name, null);
		
		
		return bills_uuids;
	}

	@Action(value = "get_all_bills", results = {
			@Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {

					@InterceptorRef("authorityStack") })
	@Authority(module = "get_all_bills", privilege = "[00010002]", error_url = "authority_ajax_error")
	@Override
	public String getDataGrid() {
		// TODO Auto-generated method stub
		msg=new java.util.HashMap<String, Object>();
		
		msg.put("total", getTotal());
		msg.put("rows", getBills());
		return SUCCESS;
	}

}