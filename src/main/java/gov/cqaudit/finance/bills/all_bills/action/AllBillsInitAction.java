package gov.cqaudit.finance.bills.all_bills.action;

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
@Namespace(value = "/bills") // 表示当前Action所在命名空间
public class AllBillsInitAction extends LoginedInitAction{
	String bill_status;

	public String getBill_status() {
		return bill_status;
	}

	public void setBill_status(String bill_status) {
		this.bill_status = bill_status;
	}

	@Actions({     
	    
		 @Action( //表示请求的Action及处理方法  
		            value="all_bills_init",  //表示action的请求名称  
		            results={  //表示结果跳转  
		                    @Result(name="success",location="/WEB-INF/bills/all_bills.jsp")}, interceptorRefs = {
									@InterceptorRef("authorityStack") })

	})
	@Authority(module="all_bills_init", privilege="[00010003]",error_url="authority_error") 
			@Override
			public String execute() {
				// TODO Auto-generated method stub
				super.execute();
				
				 session = HibernateSessionFactory.getSession();
				 
				 if (bill_status==null){
					 bill_status="0";
				 }
				 else{
					 switch(bill_status){
					 case "wait_permit":
						 bill_status="申请待审";
						 break;
					 case "view_result":
						 bill_status="查看结果";
						 break;
					 
					 }
				 }
				 
				 
				
				
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
