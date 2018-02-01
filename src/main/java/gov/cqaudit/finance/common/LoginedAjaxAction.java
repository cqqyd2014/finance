package gov.cqaudit.finance.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
public class LoginedAjaxAction extends InitAction{
	

	public Map<String, Object> msg;

	public Map<String, Object> getMsg() {
		return msg;
	}

	public void setMsg(Map<String, Object> msg) {
		this.msg = msg;
	}
	
	public com.cqqyd2014.util.AjaxSuccessMessage sm;
	public String dept_id;
	public String ip_addr;
	public String getDept_id() {
		return dept_id;
	}

	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}

	public String getIp_addr() {
		return ip_addr;
	}

	public void setIp_addr(String ip_addr) {
		this.ip_addr = ip_addr;
	}

	public String user_id;
	public String user_name;
	public String user_login;
	public java.util.ArrayList<String> sys_roles;
	public java.util.ArrayList<String> getSys_roles() {
		return sys_roles;
	}

	public void setSys_roles(java.util.ArrayList<String> sys_roles) {
		this.sys_roles = sys_roles;
	}

	public Map<String,Object> session_http;

	public Session session;
	public Transaction tx;

	public Session getSession() {
		return session;
	}


	public void setSession(Session session) {
		this.session = session;
	}


	public Transaction getTx() {
		return tx;
	}


	public void setTx(Transaction tx) {
		this.tx = tx;
	}


	public com.cqqyd2014.util.AjaxSuccessMessage getSm() {
		return sm;
	}


	public void setSm(com.cqqyd2014.util.AjaxSuccessMessage sm) {
		this.sm = sm;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}




	public String getUser_login() {
		return user_login;
	}


	public void setUser_login(String user_login) {
		this.user_login = user_login;
	}





	public Map<String, Object> getSession_http() {
		return session_http;
	}


	public void setSession_http(Map<String, Object> session_http) {
		this.session_http = session_http;
	}


	@SuppressWarnings("unchecked")
	@Override
	public String execute()  {
		// TODO Auto-generated method stub
		super.execute();
		session_http= ActionContext.getContext().getSession();

		dept_id=(String)session_http.get("dept_id");
		user_login = (String) session_http.get("user_login");
		user_name = (String) session_http.get("user_name");
		user_id = (String) session_http.get("user_id");
		sys_roles=(java.util.ArrayList<String>) session_http.get("sys_roles");
		HttpServletRequest
		 request = ServletActionContext.getRequest();
		ip_addr=com.cqqyd2014.util.IPUtil.getIpAddr(request);
		sm = new com.cqqyd2014.util.AjaxSuccessMessage();
		
		return null;
	}

}
