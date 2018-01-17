package gov.cqaudit.finance.system.user_set.action;

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
public class UserSetInitAction extends LoginedInitAction {
	
	gov.cqaudit.finance.system.model.SysUser su;
	public gov.cqaudit.finance.system.model.SysUser getSu() {
		return su;
	}
	public void setSu(gov.cqaudit.finance.system.model.SysUser su) {
		this.su = su;
	}
	@Actions({     
	    
		 @Action( //表示请求的Action及处理方法  
		            value="user_set_init",  //表示action的请求名称  
		            results={  //表示结果跳转  
		                    @Result(name="success",location="/WEB-INF/system/user_set.jsp")
		                    
		            },
		            interceptorRefs={  
                         @InterceptorRef("authorityInterceptor")  
         }
 )    

})  @Authority(module="user_set_init", privilege="*",error_url="authority_error") 

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		super.execute();
		
		 session = HibernateSessionFactory.getSession();
		 
		
		
		try {
			gov.cqaudit.finance.hibernate.dao.VSysUserDAO sudao=new gov.cqaudit.finance.hibernate.dao.VSysUserDAO();
			su=sudao.getModelByUserId(session, user_id);
			
			
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