package gov.cqaudit.finance.data.private_trade_detail.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.HibernateException;
import org.springframework.context.annotation.Scope;

import com.cqqyd2014.annotation.Authority;

import gov.cqaudit.finance.data.common.action.GetDataInitAction;
import gov.cqaudit.finance.hibernate.HibernateSessionFactory;

@SuppressWarnings("serial")
@Scope("prototype")//支持多例  
@ParentPackage("bfkjs-default")  
@Namespace(value = "/data") // 表示当前Action所在命名空间
public class PrivateTradeDetailInitAction extends GetDataInitAction{
	
	
	@Actions({     
	    
		 @Action( //表示请求的Action及处理方法  
		            value="private_trade_detail_init",  //表示action的请求名称  
		            results={  //表示结果跳转  
		                    @Result(name="success",location="/WEB-INF/data/data_main.jsp")}, interceptorRefs = {
									@InterceptorRef("authorityInterceptor") })

	})
	@Authority(module="private_trade_detail_init", privilege="*",error_url="authority_error") 
			@Override
			public String execute() {
				// TODO Auto-generated method stub
		//设置参数
		this.setView_name("v_data_core_private_account_trade_detail");
		this.setModel_package_name("gov.cqaudit.finance.database.model");
				super.execute();
				
				 session = HibernateSessionFactory.getSession();
				
				
				try {
					
					
			
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