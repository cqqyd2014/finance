package gov.cqaudit.finance.data.common.ajax.action;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

public abstract class GetDetailDataAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1496372608999490232L;

	public Session session;
	//参数
	
	public String view_name;
	
	
	public String getView_name() {
		return view_name;
	}
	public void setView_name(String view_name) {
		this.view_name = view_name;
	}
	public abstract String getDataGrid();
	public java.math.BigDecimal page;
	public java.math.BigDecimal rows;
	public java.math.BigDecimal getPage() {
		return page;
	}
	public void setPage(java.math.BigDecimal page) {
		this.page = page;
	}

	public java.math.BigDecimal getRows() {
		return rows;
	}
	public void setRows(java.math.BigDecimal rows) {
		this.rows = rows;
	}
	public  String getTotal(Session session,String dao_package_name, String model_package_name,String view_name
			,java.util.ArrayList<String> cols,java.util.ArrayList<String> ops,java.util.ArrayList<String> values
			,java.util.ArrayList<String> orders,java.util.ArrayList<String> order_types,java.math.BigDecimal rows,java.math.BigDecimal page){
		gov.cqaudit.finance.database.common.logic.ExportViewPages evp=new gov.cqaudit.finance.database.common.logic.ExportViewPages();
		
		String count=
				evp.getCount(session
						,dao_package_name, model_package_name, view_name
						, cols, ops, values, orders,order_types);
		return count;
	}

	@SuppressWarnings("unchecked")
	public java.util.ArrayList<? extends Object>  getRows(Session session,String dao_package_name, String model_package_name,String view_name
			,java.util.ArrayList<String> cols,java.util.ArrayList<String> ops,java.util.ArrayList<String> values
			,java.util.ArrayList<String> orders,java.util.ArrayList<String> order_types,java.math.BigDecimal rows,java.math.BigDecimal page){
		gov.cqaudit.finance.database.common.logic.ExportViewPages evp=new gov.cqaudit.finance.database.common.logic.ExportViewPages();
		evp.setPage(page);
		evp.setPage_size(rows);
		java.util.ArrayList<? extends Object> ms=(java.util.ArrayList<? extends Object>)
				evp.getRows(session
						,dao_package_name, model_package_name, view_name
						, cols, ops, values, orders,order_types);
		return (java.util.ArrayList<? extends Object>)ms;
	}

}
