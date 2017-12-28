package gov.cqaudit.finance.frame.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
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
@Namespace(value="/frame") //表示当前Action所在命名空间 
public class TopFrameAction  extends LoginedInitAction {

	String chinese_date;
	

	public String getChinese_date() {
		return chinese_date;
	}
	public void setChinese_date(String chinese_date) {
		this.chinese_date = chinese_date;
	}


	
	@Actions({     
	    
		 @Action( //表示请求的Action及处理方法  
		            value="top_frame",  //表示action的请求名称  
		            results={  //表示结果跳转  
		                    @Result(name="success",location="/WEB-INF/frame/top.jsp"),  
		                    
		            }
		    )    
	   
	   }) 
	@Authority(module="topframe", privilege="*",error_url="authority_error") 
	@Override
	public String execute() {
		// TODO Auto-generated method stub
		super.execute();
		
		 session = HibernateSessionFactory.getSession();
		
		try {
			
			
			
			
			chinese_date=com.cqqyd2014.util.DateUtil.getLocalFullString(new java.util.Date());
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
		
		
		
		
		
		return "success";

	}
}