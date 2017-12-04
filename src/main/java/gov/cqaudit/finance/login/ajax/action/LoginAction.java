package gov.cqaudit.finance.login.ajax.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.cqqyd2014.util.exception.AjaxSuccessMessageException;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import gov.cqaudit.finance.hibernate.HibernateSessionFactory;

@ParentPackage("json-default")
@Namespace("/login")
@Results({ @Result(name = ActionSupport.SUCCESS, type = "json"),
		@Result(name = ActionSupport.ERROR, type = "json", params = { "root", "msg" }) })
@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
	private Map<String, Object> msg;
	String user_name;
	String password;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Action(value = "login", results = { @Result(type = "json", params = { "root", "msg" }) })
	public String login() {
		com.cqqyd2014.util.AjaxSuccessMessage sm = new com.cqqyd2014.util.AjaxSuccessMessage();
		
		Session session = HibernateSessionFactory.getSession();
		
		Map<String,Object> session_http = ActionContext.getContext().getSession();

		
		
		Transaction tx = session.beginTransaction();
		try {

			if (user_name.trim().length() == 0 || user_name == null) {
				
				throw new com.cqqyd2014.util.exception.AjaxSuccessMessageException("用户名为空");

			}
			if (password.trim().length() == 0 || password == null) {
				throw new com.cqqyd2014.util.exception.AjaxSuccessMessageException("密码为空");
			}

			gov.cqaudit.finance.hibernate.dao.SysUserDAO sudao=new gov.cqaudit.finance.hibernate.dao.SysUserDAO();
			gov.cqaudit.finance.hibernate.entites.SysUser su=sudao.getEntityByLoginName(session, user_name);
			
			if (su==null) {
				throw new com.cqqyd2014.util.exception.AjaxSuccessMessageException("用户不存在");
			}
			if (!su.getPwd().equals(com.cqqyd2014.util.StringUtil.md5(password))) {
				throw new com.cqqyd2014.util.exception.AjaxSuccessMessageException("密码错误");
			}
			
				// System.out.println("设置信息");
				session_http.put("user_name",su.getName());
				session_http.put("user_login", su.getUserLogin());
				session_http.put("user_id", su.getId());
				//设置权限
				gov.cqaudit.finance.hibernate.dao.VUserMenuDDAO mddao=new gov.cqaudit.finance.hibernate.dao.VUserMenuDDAO();
				java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VUserMenuD> menuds=mddao.getArrayListEntityByUserId(session, su.getId());
				java.util.ArrayList<String> menu_array=new java.util.ArrayList<String>();
				for (int i=0;i<menuds.size();i++) {
					menu_array.add(menuds.get(i).getId().getMenuId()+menuds.get(i).getId().getMenuDId());
				}
				
				
				session_http.put("menu_array", menu_array);
				su.setOnline(true);
				java.util.Date now=new java.util.Date();
				su.setLastOnlineTime(now);

				HttpServletRequest request = ServletActionContext.getRequest();
				String ip = com.cqqyd2014.util.IPUtil.getIpAddr(request);
				gov.cqaudit.finance.system.logic.SystemLogLogic.save_log(session, new gov.cqaudit.finance.system.model.SystemLog(su.getId(), now, "登录系统，来自IP:"+ip, "Info0001", com.cqqyd2014.util.StringUtil.getUUID()));
				
				sm.setSuccess(true);
				sm.setAuth_success(true);

			
			tx.commit();

		}

		catch (HibernateException e) {

			if (null != tx) {
				tx.rollback();// 撤销事务

			}

			sm.setSuccess(false);
			sm.setBody(e.toString());

		} 
		
		catch (AjaxSuccessMessageException e) {

			if (null != tx) {
				tx.rollback();// 撤销事务

			}

			sm.setSuccess(false);
			sm.setBody(e.getMessageString());

		} 
		
		finally {
			HibernateSessionFactory.closeSession();
		}
		msg=sm.toMap();
		return SUCCESS;
	}

	public Map<String, Object> getMsg() {
		return msg;
	}

	public void setMsg(Map<String, Object> msg) {
		this.msg = msg;
	}
}
