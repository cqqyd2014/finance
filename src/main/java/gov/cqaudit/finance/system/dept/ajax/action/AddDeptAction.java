package gov.cqaudit.finance.system.dept.ajax.action;

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
@Namespace("/system")
public class AddDeptAction extends LoginedAjaxAction {
	String  dept_name;
	String dept_type;
	

	
public String getDept_name() {
		return dept_name;
	}



	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}



	public String getDept_type() {
		return dept_type;
	}



	public void setDept_type(String dept_type) {
		this.dept_type = dept_type;
	}



@Action(value = "add_dept", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "add_dept", privilege = "*", error_url = "authority_ajax_error")
@Override
public String execute() {
// TODO Auto-generated method stub
super.execute();
sm.setAuth_success(true);
		
		 session = HibernateSessionFactory.getSession();
		 tx = session.beginTransaction();
		try {
			//检测是否有重复名称
			gov.cqaudit.finance.hibernate.dao.VSysDeptDAO vdao=new gov.cqaudit.finance.hibernate.dao.VSysDeptDAO();
			java.util.ArrayList<gov.cqaudit.finance.system.model.Dept> ms=vdao.getArrayListModelByDeptName(session, dept_name);
			if (ms.size()>0){
				sm.setSuccess(false);
				sm.setBody("处室名称重复");
			}
			else{
				gov.cqaudit.finance.system.model.Dept m=new gov.cqaudit.finance.system.model.Dept();
				m.setDept_name(dept_name);
				m.setDept_type(dept_type);
				m.setDept_uuid(com.cqqyd2014.util.StringUtil.getUUID());
				m.setUser_num(new java.math.BigDecimal(0));
				
				vdao.save(session, m);
				tx.commit();
				sm.setSuccess(true);
			}
			
			
		}

		catch (HibernateException e) {

			if (null != tx) {
				tx.rollback();// 撤销事务

			}

			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		 finally {
			HibernateSessionFactory.closeSession();
		}
		
		
		
		
		
		sm.setSuccess(true);
		msg=sm.toMap();
		return SUCCESS;

	}
}