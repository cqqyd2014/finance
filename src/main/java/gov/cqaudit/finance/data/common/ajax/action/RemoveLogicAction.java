package gov.cqaudit.finance.data.common.ajax.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.cqqyd2014.annotation.Authority;

import gov.cqaudit.finance.common.LoginedAjaxAction;
import gov.cqaudit.finance.data.common.action.LogicItem;
import net.sf.json.JSONArray;

@SuppressWarnings("serial")
@ParentPackage("bfkjs-json-default")
@Namespace("/data")
public class RemoveLogicAction extends LoginedAjaxAction {

	String logic_string;





	public String getUuid() {
		return uuid;
	}




	public void setUuid(String uuid) {
		this.uuid = uuid;
	}






	String uuid;
	

	
	

	public String getLogic_string() {
		return logic_string;
	}




	public void setLogic_string(String logic_string) {
		this.logic_string = logic_string;
	}






	@SuppressWarnings("unchecked")
	@Action(value = "remove_logic", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "remove_logic", privilege = "[00020003]", error_url = "authority_ajax_error")
	@Override
	public String execute() {
	// TODO Auto-generated method stub
	super.execute();
	sm.setAuth_success(true);
			
	//测试列类型，看看是否适用参数
	
		JSONArray json = JSONArray.fromObject(logic_string);//userStr是json字符串
		  
		 
		LogicItem[] list2=(LogicItem[])JSONArray.toArray(json, LogicItem.class);
		java.util.ArrayList<LogicItem>  logics=(java.util.ArrayList<LogicItem>)com.cqqyd2014.util.ArrayTools.convertArrayToArrayList(list2);
		for (int i=0;i<logics.size();i++){
			LogicItem logic=logics.get(i);
			if (logic.getUuid().equals(uuid)){
				logics.remove(logic);
			}
		}
	
	
	sm.setSuccess(true);
	sm.setO(logics);
			
			
			
		
		msg=sm.toMap();
		return SUCCESS;
	}
}