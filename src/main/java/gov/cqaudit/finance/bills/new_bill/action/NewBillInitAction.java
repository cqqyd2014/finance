package gov.cqaudit.finance.bills.new_bill.action;

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
public class NewBillInitAction extends LoginedInitAction{
	
	String bill_type;
	
	public String getBill_type() {
		return bill_type;
	}
	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}
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
		                    @Result(name="success",location="/WEB-INF/bills/new_bill.jsp")}, interceptorRefs = {
									@InterceptorRef("authorityStack") })

	})
	@Authority(module="new_bill_init", privilege="[00010001]",error_url="authority_error") 
			@Override
			public String execute() {
				// TODO Auto-generated method stub
				super.execute();
				
				 session = HibernateSessionFactory.getSession();
				 tx = session.beginTransaction();
				 java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD> bds=new java.util.ArrayList<>();
				 
				 session_http.put("new_bill_temp_billdetails", bds);
				
				try {
					
					
					chinese_date=com.cqqyd2014.util.DateUtil.getLocalFullString(new java.util.Date());
					bill_uuid=com.cqqyd2014.util.StringUtil.getUUID();
					gov.cqaudit.finance.hibernate.dao.SysCodeDAO scdao=new gov.cqaudit.finance.hibernate.dao.SysCodeDAO();
					bank_code=scdao.getArrayListModelBySId(session, "bank_code");
					business_code=scdao.getArrayListModelBySId(session, "business_code");
					
					//得到用户基本信息
					gov.cqaudit.finance.hibernate.dao.VSysUserDAO vsudao=new gov.cqaudit.finance.hibernate.dao.VSysUserDAO();
					gov.cqaudit.finance.system.model.SysUser su=vsudao.getModelByUserId(session, user_id);
					
			
					//初始化生产bill
					 gov.cqaudit.finance.bills.model.BillM bm=new gov.cqaudit.finance.bills.model.BillM();
					 bm.setAudit_user_id("");
					 bm.setBill_type(bill_type);
					 bm.setBill_status("起草申请");
					 bm.setBill_uuid(bill_uuid);
					 bm.setContract_mail(su.getEmail());
					 bm.setContract_name(su.getUser_name());
					 bm.setContract_tell(su.getTell());
					 java.util.Date now=new java.util.Date();
					 bm.setCreate_dat(now);
					 bm.setCreate_user_id(user_id);
					 bm.setDept_id(dept_id);
					 bm.setDept_name(dept_name);
					 bm.setDownload_dat(com.cqqyd2014.util.DateUtil.ShortStringToJDate("1900-1-1"));
					 bm.setDownload_user_id("");
					 bm.setDownload_uuid("");
					 bm.setLast_audit_dat(com.cqqyd2014.util.DateUtil.ShortStringToJDate("1900-1-1"));
					 bm.setLast_modify_dat(now);
					 bm.setPro_name("");
					 bm.setSearch_reason("");
					 bm.setEffective(true);
					 bm.setPics_num(new java.math.BigDecimal(0));
					 bm.setDetail_num(new java.math.BigDecimal(0));
					 bm.setUneffecitve_user_id("");
					 bm.setUneffective_dat(com.cqqyd2014.util.DateUtil.ShortStringToJDate("1900-1-1"));
					 gov.cqaudit.finance.hibernate.dao.VBillMDAO vbdao=new gov.cqaudit.finance.hibernate.dao.VBillMDAO();
					 vbdao.save(session, bm);
					 tx.commit();
			
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