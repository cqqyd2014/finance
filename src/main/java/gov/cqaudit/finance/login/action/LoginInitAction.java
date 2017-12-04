package gov.cqaudit.finance.login.action;



import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.springframework.context.annotation.Scope;



import gov.cqaudit.finance.common.InitAction;
import gov.cqaudit.finance.hibernate.HibernateSessionFactory;

@SuppressWarnings("serial")
@Scope("prototype")//支持多例  
@ParentPackage("struts-default")  //表示继承的父包  
@Namespace(value="/login") //表示当前Action所在命名空间  
public class LoginInitAction extends InitAction{
	@Actions({     
	    
		 @Action( //表示请求的Action及处理方法  
		            value="login_init",  //表示action的请求名称  
		            results={  //表示结果跳转  
		                    @Result(name="success",location="/WEB-INF/login/login.jsp"), 
		                    
		                    
		            }
		    )    
	   
	   })  
	

	public String login_init()  {
Session session = HibernateSessionFactory.getSession();
		
		
		try {
		
		super.init_js_par(session);
		}

		catch (HibernateException e) {

			

		} 
		
		finally {
			HibernateSessionFactory.closeSession();
		}

		
		return "success";
	}

}