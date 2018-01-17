package gov.cqaudit.finance.system.user_set.ajax.action;

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
public class SaveUserParItemAction extends LoginedAjaxAction {

String code;
String value;


public String getValue() {
	return value;
}


public void setValue(String value) {
	this.value = value;
}


public String getCode() {
	return code;
}


public void setCode(String code) {
	this.code = code;
}


@Action(value = "save_user_par_item", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "save_user_par_item", privilege = "*", error_url = "authority_ajax_error")
@Override
public String execute() {
// TODO Auto-generated method stub
super.execute();
sm.setAuth_success(true);
		
		 session = HibernateSessionFactory.getSession();
		 tx=session.beginTransaction();
		try {
			gov.cqaudit.finance.hibernate.dao.UserParDAO updao=new gov.cqaudit.finance.hibernate.dao.UserParDAO();
			gov.cqaudit.finance.system.model.UserPar up=updao.getModelByUserIdDesc(session, user_id, code);
			switch (up.getPar_type()){
			case "NUM_":
				//校验是否为数字
				try{
					new java.math.BigDecimal(value);
					up.setValue(value);
					sm.setSuccess(true);
					updao.save(session, up);
					session_http.put(up.getParam(),up.getValue());
				}
				catch (java.lang.NumberFormatException e){
					sm.setBody(up.getParam_desc()+"的值需要为数字");
					sm.setSuccess(false);
					
				}
				
				break;
			case "TEXT":
				up.setValue(value);
				sm.setSuccess(true);
				updao.save(session, up);
				session_http.put(up.getParam(),up.getValue());
				break;
			}
			tx.commit();
			
			
		}

		catch (HibernateException e) {

			if (null != tx) {
				tx.rollback();// 撤销事务

			}

			System.out.println(e.getMessage());
			e.printStackTrace();
			sm.setSuccess(false);
			sm.setBody("Hibernate数据错误");
		}

		 finally {
			HibernateSessionFactory.closeSession();
		}
		
		
		
		
		
		msg=sm.toMap();
		
		return SUCCESS;

	}
}