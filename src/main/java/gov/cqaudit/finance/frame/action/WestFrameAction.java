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
public class WestFrameAction extends LoginedInitAction  {
	

java.util.ArrayList<gov.cqaudit.finance.system.model.MenuM> menu;
	
	
	java.util.ArrayList<gov.cqaudit.finance.system.model.MenuD> javascrpits_method;

	
	
	public java.util.ArrayList<gov.cqaudit.finance.system.model.MenuM> getMenu() {
		return menu;
	}



	public void setMenu(java.util.ArrayList<gov.cqaudit.finance.system.model.MenuM> menu) {
		this.menu = menu;
	}



	public java.util.ArrayList<gov.cqaudit.finance.system.model.MenuD> getJavascrpits_method() {
		return javascrpits_method;
	}



	public void setJavascrpits_method(java.util.ArrayList<gov.cqaudit.finance.system.model.MenuD> javascrpits_method) {
		this.javascrpits_method = javascrpits_method;
	}



	@Actions({     
	    
		 @Action( //表示请求的Action及处理方法  
		            value="west_frame",  //表示action的请求名称  
		            results={  //表示结果跳转  
		                    @Result(name="success",location="/WEB-INF/frame/west.jsp"),  
		                    
		            }
		    )    
	   
	   })  
	
   
	@Authority(module="west_frame", privilege="*",error_url="authority_error") 
	@Override
	public String execute() {
		// TODO Auto-generated method stub
		
		

		super.execute();
		
		 session = HibernateSessionFactory.getSession();
		 
		
		
		try {
			
			//gov.cqaudit.finance.hibernate.dao.VUserMenuDDAO vumddao=new gov.cqaudit.finance.hibernate.dao.VUserMenuDDAO();
			javascrpits_method=gov.cqaudit.finance.system.logic.MenuDLogic.getArrayListModelFromArrayListView(
					gov.cqaudit.finance.hibernate.dao.VUserMenuDDAO.getArrayListEntityByUserId(session, user_id));
			
		//gov.cqaudit.finance.hibernate.dao.VUserMenuMDAO vummdao=new gov.cqaudit.finance.hibernate.dao.VUserMenuMDAO();
		
		
		menu=gov.cqaudit.finance.system.logic.MenuMLogic.getArrayListModelFromArrayListView(
				gov.cqaudit.finance.hibernate.dao.VUserMenuMDAO.getArrayListViewByUserId(session, user_id));
		for (int i=0;i<menu.size();i++) {
			gov.cqaudit.finance.system.model.MenuM mm=menu.get(i);
			java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VUserMenuD> vumds=gov.cqaudit.finance.hibernate.dao.VUserMenuDDAO.getArrayListEntityByIdUserId(session, mm.getM_id(), user_id);
			mm.setMds(gov.cqaudit.finance.system.logic.MenuDLogic.getArrayListModelFromArrayListView(vumds));
		}
		
		
		
		
		
		
		}
		catch (HibernateException e) {
			if (null != tx) {
				tx.rollback();// 撤销事务

			}
			System.out.println(e.getMessage());
			e.printStackTrace();
			
			
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return "success";
	}




}