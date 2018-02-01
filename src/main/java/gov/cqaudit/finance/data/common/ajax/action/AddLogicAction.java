package gov.cqaudit.finance.data.common.ajax.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.HibernateException;

import com.cqqyd2014.annotation.Authority;

import gov.cqaudit.finance.common.LoginedAjaxAction;
import gov.cqaudit.finance.data.common.action.LogicItem;
import gov.cqaudit.finance.hibernate.HibernateSessionFactory;
import net.sf.json.JSONArray;
@SuppressWarnings("serial")
@ParentPackage("bfkjs-json-default")
@Namespace("/data")
public class AddLogicAction extends LoginedAjaxAction {

	String logic_string;
	public String getCol_name() {
		return col_name;
	}




	public void setCol_name(String col_name) {
		this.col_name = col_name;
	}




	String view_name;
	String col;
	String col_name;
	String op;
	String value;

	
	

	public String getLogic_string() {
		return logic_string;
	}




	public void setLogic_string(String logic_string) {
		this.logic_string = logic_string;
	}




	public String getCol() {
		return col;
	}




	public void setCol(String col) {
		this.col = col;
	}




	public String getOp() {
		return op;
	}




	public void setOp(String op) {
		this.op = op;
	}




	public String getValue() {
		return value;
	}




	public void setValue(String value) {
		this.value = value;
	}




	@SuppressWarnings("unchecked")
	@Action(value = "add_logic", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			@InterceptorRef("authorityStack") })
@Authority(module = "add_logic", privilege = "*", error_url = "authority_ajax_error")
	@Override
	public String execute() {
	// TODO Auto-generated method stub
	super.execute();
	sm.setAuth_success(true);
			
	//测试列类型，看看是否适用参数
	
	java.util.ArrayList<LogicItem> logics=null;
	
	if (logic_string==null||logic_string.equals("null")){
		logics=new java.util.ArrayList<>();
		
		
	}
	else{
		JSONArray json = JSONArray.fromObject(logic_string);//userStr是json字符串
		  
		 
		LogicItem[] list2=(LogicItem[])JSONArray.toArray(json, LogicItem.class);
		  logics=(java.util.ArrayList<LogicItem>)com.cqqyd2014.util.ArrayTools.convertArrayToArrayList(list2);
		
	}
	LogicItem item=new LogicItem();
	item.setUuid(com.cqqyd2014.util.StringUtil.getUUID());
	item.setCol_field(col);
	item.setCol_name(col_name);
	item.setOp(op);
	item.setValue(value);
	
	logics.add(item);
	
	sm.setSuccess(true);
	sm.setO(logics);
			
			
			
		
		msg=sm.toMap();
		return SUCCESS;
	}
}