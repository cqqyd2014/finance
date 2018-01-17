package gov.cqaudit.finance.common;

import java.util.Map;

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

		user_login = (String) session_http.get("user_login");
		user_name = (String) session_http.get("user_name");
		user_id = (String) session_http.get("user_id");
		sys_roles=(java.util.ArrayList<String>) session_http.get("sys_roles");
		sm = new com.cqqyd2014.util.AjaxSuccessMessage();
		
		return null;
	}

}
