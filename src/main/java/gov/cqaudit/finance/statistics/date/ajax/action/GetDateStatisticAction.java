package gov.cqaudit.finance.statistics.date.ajax.action;

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
@Namespace("/statistic")
public class GetDateStatisticAction extends LoginedAjaxAction {

	String start_dat;
	String end_dat;

	
public String getStart_dat() {
		return start_dat;
	}


	public void setStart_dat(String start_dat) {
		this.start_dat = start_dat;
	}


	public String getEnd_dat() {
		return end_dat;
	}


	public void setEnd_dat(String end_dat) {
		this.end_dat = end_dat;
	}


@Action(value = "get_date_statistic", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "get_date_statistic", privilege = "*", error_url = "authority_ajax_error")
@Override
public String execute() {
// TODO Auto-generated method stub
super.execute();
sm.setAuth_success(true);
		
		 session = HibernateSessionFactory.getSession();
		 tx = session.beginTransaction();
		try {
			java.util.Date start_date=com.cqqyd2014.util.DateUtil.FullStringToJDate(start_dat+" 00:00:00");
			java.util.Date end_date=com.cqqyd2014.util.DateUtil.FullStringToJDate(end_dat+" 23:59:59");
			gov.cqaudit.finance.hibernate.dao.VStatisticsBillsResultDAO stdao=new gov.cqaudit.finance.hibernate.dao.VStatisticsBillsResultDAO();
			java.util.ArrayList<gov.cqaudit.finance.statistics.model.StatisticsBillsResult> ms=stdao.getArrayListModelBetweenCreateDate(session, start_date, end_date);
			
			
			
			
			msg=new java.util.HashMap<String,Object>();
			msg.put("total", String.valueOf(ms.size()));
			msg.put("rows", ms);
			
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
		
		
		
		
		
		
		return SUCCESS;

	}
}