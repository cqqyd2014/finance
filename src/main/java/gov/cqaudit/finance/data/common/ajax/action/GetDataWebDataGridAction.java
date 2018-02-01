package gov.cqaudit.finance.data.common.ajax.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.HibernateException;

import com.cqqyd2014.annotation.Authority;

import gov.cqaudit.finance.data.common.action.LogicItem;
import gov.cqaudit.finance.data.common.action.OrderItem;
import gov.cqaudit.finance.hibernate.HibernateSessionFactory;
import net.sf.json.JSONArray;
@ParentPackage("bfkjs-json-default")
@Namespace("/data")
public class GetDataWebDataGridAction extends GetDetailDataAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2243045303784081159L;
	
	String logics;
	String orders;
	


	public String getOrders() {
		return orders;
	}

	public void setOrders(String orders) {
		this.orders = orders;
	}

	public String getView_name() {
		return view_name;
	}

	public void setView_name(String view_name) {
		this.view_name = view_name;
	}

	public String getLogics() {
		return logics;
	}

	public void setLogics(String logics) {
		this.logics = logics;
	}

	public java.util.Map<String, Object> getMsg() {
		return msg;
	}

	public void setMsg(java.util.Map<String, Object> msg) {
		this.msg = msg;
	}

java.util.Map<String, Object> msg;

	@Action(value = "get_data_web_datagrid", results = {
			@Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {

					@InterceptorRef("authorityStack") })
	@Authority(module = "get_data_web_datagrid", privilege = "[00020003]", error_url = "authority_ajax_error")
	@Override
	public String getDataGrid() {
		JSONArray json_logics = JSONArray.fromObject(logics);//userStr是json字符串
		LogicItem[] list_logic=(LogicItem[])JSONArray.toArray(json_logics, LogicItem.class);
		@SuppressWarnings("unchecked")
		java.util.ArrayList<LogicItem> logics_array=(java.util.ArrayList<LogicItem>)com.cqqyd2014.util.ArrayTools.convertArrayToArrayList(list_logic);
		
		JSONArray json_orders = JSONArray.fromObject(orders);//userStr是json字符串
		OrderItem[] list_order=(OrderItem[])JSONArray.toArray(json_orders, OrderItem.class);
		@SuppressWarnings("unchecked")
		java.util.ArrayList<LogicItem> orders_array=(java.util.ArrayList<LogicItem>)com.cqqyd2014.util.ArrayTools.convertArrayToArrayList(list_order);
		
		
		@SuppressWarnings("unchecked")
		java.util.ArrayList<String> cols=com.cqqyd2014.util.ArrayListTools.getStringFieldArrayList(logics_array, LogicItem.class, "getCol_field");
		@SuppressWarnings("unchecked")
		java.util.ArrayList<String> ops=com.cqqyd2014.util.ArrayListTools.getStringFieldArrayList(logics_array, LogicItem.class, "getOp");
		@SuppressWarnings("unchecked")
		java.util.ArrayList<String> values=com.cqqyd2014.util.ArrayListTools.getStringFieldArrayList(logics_array, LogicItem.class, "getValue");
		@SuppressWarnings("unchecked")
		java.util.ArrayList<String> orders=com.cqqyd2014.util.ArrayListTools.getStringFieldArrayList(orders_array, OrderItem.class, "getCol_field");
		@SuppressWarnings("unused")
		java.util.ArrayList<String> order_types=com.cqqyd2014.util.ArrayListTools.getStringFieldArrayList(orders_array, OrderItem.class, "getType");
		orders=new java.util.ArrayList<>();
		session = HibernateSessionFactory.getSession();

msg=new java.util.HashMap<String, Object>();
		
		msg.put("total", getTotal(session,"gov.cqaudit.finance.hibernate.dao", "gov.cqaudit.finance.database.model"
				,view_name
				,cols,ops,values
				,orders,order_types,rows,page));
		
		msg.put("rows", getRows(session,"gov.cqaudit.finance.hibernate.dao", "gov.cqaudit.finance.database.model"
				,view_name
				,cols,ops,values
				,orders,order_types,rows,page));
		
		try {
			
	
}

catch (HibernateException e) {

	

	System.out.println(e.getMessage());
	e.printStackTrace();
}

 finally {
	HibernateSessionFactory.closeSession();
}
		
		
		return SUCCESS;
	}

	

}
