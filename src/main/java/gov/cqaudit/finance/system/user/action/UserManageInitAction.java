package gov.cqaudit.finance.system.user.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.HibernateException;
import org.springframework.context.annotation.Scope;

import com.cqqyd2014.annotation.Authority;

import gov.cqaudit.finance.common.LoginedInitAction;
import gov.cqaudit.finance.hibernate.HibernateSessionFactory;

@SuppressWarnings("serial")
@Scope("prototype")//支持多例  
@ParentPackage("bfkjs-default") 
@Namespace(value="/system") //表示当前Action所在命名空间 
public class UserManageInitAction extends LoginedInitAction {
	@Actions({     
	    
		 @Action( //表示请求的Action及处理方法  
		            value="user_manage_init",  //表示action的请求名称  
		            results={  //表示结果跳转  
		                    @Result(name="success",location="/WEB-INF/system/user_manage.jsp")
		                    
		            },
		            interceptorRefs={  
                         @InterceptorRef("authorityInterceptor")  
         }
 )    

})  @Authority(module="user_manage_init", privilege="*",error_url="authority_error") 

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		super.execute();
		
		 session = HibernateSessionFactory.getSession();
		 
		
		
		try {
			
			
			
		}

		catch (HibernateException e) {

			

			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		 finally {
			HibernateSessionFactory.closeSession();
		}
		
		
		
		
		
		return "success";
	}

}