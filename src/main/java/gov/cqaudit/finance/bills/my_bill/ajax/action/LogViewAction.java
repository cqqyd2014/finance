package gov.cqaudit.finance.bills.my_bill.ajax.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.HibernateException;

import com.cqqyd2014.annotation.Authority;

import gov.cqaudit.finance.common.LoginedAjaxAction;
import gov.cqaudit.finance.hibernate.HibernateSessionFactory;

@SuppressWarnings("serial")
@ParentPackage("bfkjs-json-default")
@Namespace("/bills")
public class LogViewAction   extends LoginedAjaxAction {
	
	String bill_uuid;
	
	
	public String getBill_uuid() {
		return bill_uuid;
	}

	public void setBill_uuid(String bill_uuid) {
		this.bill_uuid = bill_uuid;
	}



	@Action(value = "log_view", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("authorityStack") })
@Authority(module = "log_view", privilege = "[00010001]", error_url = "authority_ajax_error")
	@Override
	public String execute() {
	// TODO Auto-generated method stub
	super.execute();
	sm.setAuth_success(true);
			
			 session = HibernateSessionFactory.getSession();
			 tx = session.beginTransaction();
			try {
				
					//记录user角色的数据访问
					if (com.cqqyd2014.util.ArrayListTools.indexOfArrayList(sys_roles, "users")!=-1){
						HttpServletRequest
						 request = ServletActionContext.getRequest();
						String ip=com.cqqyd2014.util.IPUtil.getIpAddr(request);
						gov.cqaudit.finance.bills.model.UserViewResultLog m=new gov.cqaudit.finance.bills.model.UserViewResultLog();
						gov.cqaudit.finance.hibernate.dao.VSysUserDAO sudao=new gov.cqaudit.finance.hibernate.dao.VSysUserDAO();
						gov.cqaudit.finance.system.model.SysUser su=sudao.getModelByUserId(session, user_id);
						m.setDept_id(su.getDept_id());
						m.setIp(ip);
						m.setUser_id(user_id);
						m.setView_dat(new java.util.Date());
						gov.cqaudit.finance.hibernate.dao.VUserViewResultLogDAO logdao=new gov.cqaudit.finance.hibernate.dao.VUserViewResultLogDAO();
						logdao.save(session, m);
						tx.commit();
					
					
					
					
				}
				
					sm.setSuccess(true);
			
			
		}

		catch (HibernateException e) {
			
			if (null != tx) {
				tx.rollback();// 撤销事务

			}
			sm.setSuccess(false);
			sm.setBody(e.toString());
			
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		 finally {
				HibernateSessionFactory.closeSession();
			}
		
		msg=sm.toMap();
		return SUCCESS;
	}
}