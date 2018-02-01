package gov.cqaudit.finance.bills.new_bill.ajax.action;

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
@Namespace("/bills")
public class TempSaveBillAction   extends LoginedAjaxAction {

	java.math.BigDecimal detail_num;


	String bill_status;

	public String getBill_status() {
		return bill_status;
	}

	public void setBill_status(String bill_status) {
		this.bill_status = bill_status;
	}

	public java.math.BigDecimal getDetail_num() {
		return detail_num;
	}

	public void setDetail_num(java.math.BigDecimal detail_num) {
		this.detail_num = detail_num;
	}
	String create_date;

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	String bill_uuid;
	String pro_name;
	String search_reason;
	String contract_name;
	String contract_tell;

	
	
	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getSearch_reason() {
		return search_reason;
	}

	public void setSearch_reason(String search_reason) {
		this.search_reason = search_reason;
	}

	public String getContract_name() {
		return contract_name;
	}

	public void setContract_name(String contract_name) {
		this.contract_name = contract_name;
	}

	public String getContract_tell() {
		return contract_tell;
	}

	public void setContract_tell(String contract_tell) {
		this.contract_tell = contract_tell;
	}

	public String getBill_uuid() {
		return bill_uuid;
	}

	public void setBill_uuid(String bill_uuid) {
		this.bill_uuid = bill_uuid;
	}

	String contract_mail;

	public String getContract_mail() {
		return contract_mail;
	}

	public void setContract_mail(String contract_mail) {
		this.contract_mail = contract_mail;
	}

	@Action(value = "temp_save_bill", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "temp_save_bill", privilege = "[00010001]", error_url = "authority_ajax_error")
	@Override
	public String execute() {
	// TODO Auto-generated method stub
	super.execute();
	sm.setAuth_success(true);
			
			 session = HibernateSessionFactory.getSession();
			 tx = session.beginTransaction();
			 java.util.Date now=null;
			 gov.cqaudit.finance.bills.model.BillM bm=null;
			try {
				gov.cqaudit.finance.hibernate.dao.VBillMDAO vbdao=new gov.cqaudit.finance.hibernate.dao.VBillMDAO();
				
				bm=vbdao.getModelByUuid(session, bill_uuid);
				
				gov.cqaudit.finance.hibernate.dao.VBillDDAO vbddao=new gov.cqaudit.finance.hibernate.dao.VBillDDAO();
				if (create_date==null){
					now=new java.util.Date();;
				}
				else{
					now=com.cqqyd2014.util.DateUtil.FullStringToJDate(create_date);
					bm.setCreate_dat(now);
					bm.setBill_status(bill_status);
				}
				bm.setDetail_num(detail_num);
				bm.setContract_mail(contract_mail);
				bm.setContract_name(contract_name);
				bm.setContract_tell(contract_tell);
				bm.setLast_modify_dat(now);
				bm.setLast_audit_dat_chinese_print(com.cqqyd2014.util.DateUtil.getLocalFullString(now));
				bm.setPro_name(pro_name);
				bm.setSearch_reason(search_reason);
				gov.cqaudit.finance.hibernate.dao.VPictureDAO vpdao=new gov.cqaudit.finance.hibernate.dao.VPictureDAO();
				java.util.ArrayList<gov.cqaudit.finance.bills.model.Picture> vps=vpdao.getArrayListModelByBillUuid(session, bill_uuid);
				bm.setPics_num(new java.math.BigDecimal(vps.size()));
				java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD> vbds=vbddao.getArrayListModelByBillUuid(session, bill_uuid);
				bm.setDetail_num(new java.math.BigDecimal(vbds.size()));
				
				
				
				vbdao.save(session, bm);
						
			sm.setSuccess(true);
			sm.setO(bm);
			tx.commit();
			
			
		}

		catch (HibernateException e) {
			
			if (null != tx) {
				tx.rollback();// 撤销事务

			}
			sm.setSuccess(false);
			sm.setBody(e.toString());
			
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		 finally {
				HibernateSessionFactory.closeSession();
			}
		
		msg=sm.toMap();
		return SUCCESS;
	}
}