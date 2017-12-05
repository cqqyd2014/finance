package gov.cqaudit.finance.bills.new_bill.action;

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
@Namespace(value = "/bills") // 表示当前Action所在命名空间
public class NewBillInitAction extends LoginedInitAction{
	
	java.util.ArrayList<gov.cqaudit.finance.system.model.SysCode> business_code;
	public java.util.ArrayList<gov.cqaudit.finance.system.model.SysCode> getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(java.util.ArrayList<gov.cqaudit.finance.system.model.SysCode> business_code) {
		this.business_code = business_code;
	}
	java.util.ArrayList<gov.cqaudit.finance.system.model.SysCode> bank_code;
	public java.util.ArrayList<gov.cqaudit.finance.system.model.SysCode> getBank_code() {
		return bank_code;
	}
	public void setBank_code(java.util.ArrayList<gov.cqaudit.finance.system.model.SysCode> bank_code) {
		this.bank_code = bank_code;
	}
	String chinese_date;
	String bill_uuid;
	public String getBill_uuid() {
		return bill_uuid;
	}
	public void setBill_uuid(String bill_uuid) {
		this.bill_uuid = bill_uuid;
	}
	public String getChinese_date() {
		return chinese_date;
	}
	public void setChinese_date(String chinese_date) {
		this.chinese_date = chinese_date;
	}
	@Actions({     
	    
		 @Action( //表示请求的Action及处理方法  
		            value="new_bill_init",  //表示action的请求名称  
		            results={  //表示结果跳转  
		                    @Result(name="success",location="/WEB-INF/bills/new_bill.jsp"),  
		                    
		            }
		    )    
	  
	  }) 
	@Authority(module="new_bill_init", privilege="[00010001]",error_url="authority_error") 
			@Override
			public String execute() {
				// TODO Auto-generated method stub
				
				

				super.execute();
				
				 session = HibernateSessionFactory.getSession();
				 
				
				
				try {
					super.init_js_par(session);
					
					chinese_date=com.cqqyd2014.util.DateUtil.getLocalFullString(new java.util.Date());
					bill_uuid=com.cqqyd2014.util.StringUtil.getUUID();
					bank_code=gov.cqaudit.finance.system.logic.SysCodeLogic.getArrayListModelBySId(session, "bank_code");
					business_code=gov.cqaudit.finance.system.logic.SysCodeLogic.getArrayListModelBySId(session, "business_code");
			
			
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