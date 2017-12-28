package gov.cqaudit.finance.datatrans.download_reqest.ajax.action;

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
@Namespace("/trans")
public class GetTransDownloadBillsAction extends BillsReslutAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8675167402615908702L;
	@Action(value = "get_trans_download_bills", results = {
			@Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {

					@InterceptorRef("authorityStack") })
	@Authority(module = "get_trans_download_bills", privilege = "[00040001]", error_url = "authority_ajax_error")
	@Override
	public String getDataGrid() {
msg=new java.util.HashMap<String, Object>();
		
		msg.put("total", getTotal());
		msg.put("rows", getBills());
		return SUCCESS;
	}

	@Override
	public String getTotalImpl(Session session, String search_bill_bill_status, String search_bill_contract_name,
			String search_bill_pro_name, String create_user_id) {
		// TODO Auto-generated method stub
		
		
		return gov.cqaudit.finance.hibernate.dao.VBillMDAO.getBillUuidsCount(session,"等待传单", search_bill_contract_name, search_bill_pro_name, null).toString();
	}

	@Override
	public ArrayList<String> getBillsImpl(Session session, String rows, String page, String search_bill_bill_status,
			String search_bill_contract_name, String search_bill_pro_name, String create_user_id) {
		
java.util.ArrayList<String> bills_uuids=gov.cqaudit.finance.hibernate.dao.VBillMDAO.getArrayListBillUuids(session, rows, page, "等待传单", search_bill_contract_name, search_bill_pro_name, null);
		
		
		return bills_uuids;
	}

}
