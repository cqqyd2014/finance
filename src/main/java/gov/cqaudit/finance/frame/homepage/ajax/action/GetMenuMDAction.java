package gov.cqaudit.finance.frame.homepage.ajax.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.HibernateException;

import com.cqqyd2014.annotation.Authority;
import com.opensymphony.xwork2.ActionSupport;

import gov.cqaudit.finance.common.LoginedAjaxAction;
import gov.cqaudit.finance.hibernate.HibernateSessionFactory;

@SuppressWarnings("serial")
@ParentPackage("bfkjs-json-default")
@Namespace("/frame")
public class GetMenuMDAction   extends LoginedAjaxAction{
	private Map<String, Object> msg;

	public Map<String, Object> getMsg() {
		return msg;
	}

	public void setMsg(Map<String, Object> msg) {
		this.msg = msg;
	}
	@Action(value = "get_menu_md", results = { @Result(type = "json", params = { "root", "msg" })  }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "get_menu_md", privilege = "*", error_url = "authority_ajax_error")
@Override
public String execute() {
// TODO Auto-generated method stub
super.execute();
sm.setAuth_success(true);
		session = HibernateSessionFactory.getSession();
			
			
			
			try {
				//System.out.println(par_code);
				
				
				java.util.ArrayList<gov.cqaudit.finance.system.model.MenuM> mms=gov.cqaudit.finance.system.logic.MenuMLogic.getArrayListModelFromArrayListView(
						gov.cqaudit.finance.hibernate.dao.VUserMenuMDAO.getArrayListViewByUserId(session, user_id));
				for (int i=0;i<mms.size();i++){
					gov.cqaudit.finance.system.model.MenuM mm=mms.get(i);
					java.util.ArrayList<gov.cqaudit.finance.system.model.MenuD> mds=gov.cqaudit.finance.system.logic.MenuDLogic.getArrayListModelFromArrayListView(
							gov.cqaudit.finance.hibernate.dao.VUserMenuDDAO.getArrayListEntityByIdUserId(session, mm.getM_id(), user_id));
					mm.setMds(mds);
					
					}
				sm.setSuccess(true);
				sm.setO(mms);
				//tx.commit();

			}

			catch (HibernateException e) {

				if (null != tx) {
					tx.rollback();// 撤销事务

				}

				sm.setSuccess(false);
				sm.setBody(e.toString());

			} 
			

			finally {
				HibernateSessionFactory.closeSession();
			}
		
		
		msg=sm.toMap();
		return ActionSupport.SUCCESS;
	}



}
