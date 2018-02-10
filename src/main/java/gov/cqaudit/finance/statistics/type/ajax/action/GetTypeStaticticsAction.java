package gov.cqaudit.finance.statistics.type.ajax.action;

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
public class GetTypeStaticticsAction extends LoginedAjaxAction {

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


@Action(value = "get_type_statistic", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "get_type_statistic", privilege = "*", error_url = "authority_ajax_error")
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
			gov.cqaudit.finance.hibernate.dao.VStatisticsBillsResultByTypeDAO stdao=new gov.cqaudit.finance.hibernate.dao.VStatisticsBillsResultByTypeDAO();
			java.util.ArrayList<gov.cqaudit.finance.statistics.model.StatisticsTypeResult> ms=stdao.getArrayListModelBetweenCreateDate(session, start_date, end_date);
			
			gov.cqaudit.finance.statistics.model.StatisticsTypeResultTotal to=new gov.cqaudit.finance.statistics.model.StatisticsTypeResultTotal();
			to.setType_name("合计");
			to.setPrivate_account_count(com.cqqyd2014.util.ArrayListTools.sumFields(ms, "getPrivate_account_count"));
			to.setPrivate_detail_count(com.cqqyd2014.util.ArrayListTools.sumFields(ms, "getPrivate_detail_count"));
			to.setPublic_account_count(com.cqqyd2014.util.ArrayListTools.sumFields(ms, "getPublic_account_count"));
			to.setPublic_detail_count(com.cqqyd2014.util.ArrayListTools.sumFields(ms, "getPublic_detail_count"));
			to.setDept_count(com.cqqyd2014.util.ArrayListTools.sumFields(ms, "getDept_count"));
			java.util.ArrayList<gov.cqaudit.finance.statistics.model.StatisticsTypeResultTotal> tos=new java.util.ArrayList<>();
			tos.add(to);
			
			
			msg=new java.util.HashMap<String,Object>();
			msg.put("total", String.valueOf(ms.size()));
			msg.put("rows", ms);
			msg.put("footer", tos);
			
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