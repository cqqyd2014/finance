package gov.cqaudit.finance.bills.new_bill.ajax.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cqqyd2014.annotation.Authority;


import gov.cqaudit.finance.common.LoginedAjaxAction;
import gov.cqaudit.finance.hibernate.HibernateSessionFactory;

@SuppressWarnings("serial")
@ParentPackage("bfkjs-json-default")
@Namespace("/bills")
public class GetSearchParCodeAction   extends LoginedAjaxAction {
	String business_code;
	
	public String getBusiness_code() {
		return business_code;
	}

	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}

	@Action(value = "get_search_par_code", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "get_search_par_code", privilege = "[00010001]", error_url = "authority_ajax_error")
	@Override
	public String execute() {
	// TODO Auto-generated method stub
	super.execute();
	sm.setAuth_success(true);
			
			 session = HibernateSessionFactory.getSession();
			 
			try {
				
				java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBusinessSearchPar> pars=gov.cqaudit.finance.hibernate.dao.VBusinessSearchParDAO.getArrayListByBusinessCode(session, business_code);
				
				java.util.ArrayList<gov.cqaudit.finance.system.model.SysCode> search_pars=new java.util.ArrayList<>();
				for (int i=0,len_pars=pars.size();i<len_pars;i++){
					gov.cqaudit.finance.system.model.SysCode sc=new gov.cqaudit.finance.system.model.SysCode();
					gov.cqaudit.finance.hibernate.entities.VBusinessSearchPar par=pars.get(i);
					
					sc.setCode(par.getId().getSearchParCode());
					sc.setValue(par.getId().getSValue());
					search_pars.add(sc);
				}
				
			
			
			sm.setSuccess(true);
			sm.setO(search_pars);
			
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
		sm.setSuccess(true);
		msg=sm.toMap();
		return SUCCESS;
	}
}