package gov.cqaudit.finance.common;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
public class LoginedInitAction extends InitAction{
	
	public com.cqqyd2014.util.AjaxSuccessMessage sm;
	public String user_id;
	public String user_name;
	public String user_login;
	public String sys_role;
	public String dept_id;
	public String dept_name;
	public String getDept_id() {
		return dept_id;
	}


	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}


	public String getDept_name() {
		return dept_name;
	}


	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
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


	public String getSys_role() {
		return sys_role;
	}


	public void setSys_role(String sys_role) {
		this.sys_role = sys_role;
	}


	public Map<String, Object> getSession_http() {
		return session_http;
	}


	public void setSession_http(Map<String, Object> session_http) {
		this.session_http = session_http;
	}


	@Override
	public String execute()  {
		// TODO Auto-generated method stub
		super.execute();
		session_http= ActionContext.getContext().getSession();

		user_login = (String) session_http.get("user_login");
		user_name = (String) session_http.get("user_name");
		user_id = (String) session_http.get("user_id");
		dept_name=(String)session_http.get("dept_name");
		dept_id=(String)session_http.get("dept_id");
		sm = new com.cqqyd2014.util.AjaxSuccessMessage();
		
		return null;
	}

}
