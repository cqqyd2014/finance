package gov.cqaudit.finance.common.loadonstart;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import gov.cqaudit.finance.hibernate.HibernateSessionFactory;



@WebServlet(name="database_init_par",urlPatterns = "/database_init_par",loadOnStartup=1)
@SuppressWarnings("serial")
public class DataBaseInitPar extends HttpServlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		Session session = HibernateSessionFactory.getSession();
		try{
			
			 //取得Application对象   
	        ServletContext application=config.getServletContext();
	         //处理syspar
			java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.SysPar> sps=gov.cqaudit.finance.hibernate.dao.SysParDAO.getArrayListEntites(session);
			for (int i=0,len=sps.size();i<len;i++){
				gov.cqaudit.finance.hibernate.entities.SysPar sp=sps.get(i);
				application.setAttribute(sp.getCode(), sp.getValue());
			}
			//处理syscode，采用map<String,map>的方式存储
			java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.SysCode> codes=gov.cqaudit.finance.hibernate.dao.SysCodeDAO.getEntitis(session);
			java.util.HashMap<String, java.util.HashMap<String, String>> sys_code_map=new java.util.HashMap<>();
			for (int i=0,len=codes.size();i<len;i++){
				gov.cqaudit.finance.hibernate.entities.SysCode sc=codes.get(i);
				String id=sc.getId().getSId();
				String code=sc.getId().getSCode();
				String value=sc.getSValue();
				if (sys_code_map.get(id)==null){
					java.util.HashMap<String, String> map=new java.util.HashMap<>();
					map.put(code, value);
					sys_code_map.put(id, map);
				}
				else{
					java.util.HashMap<String, String> map=sys_code_map.get(id);
					map.put(code, value);
				}
			}
			application.setAttribute("sys_code_map", sys_code_map);
	}

	catch (HibernateException e) {

		System.out.println("启动顺序1错误："+e.toString());

	} 
	
	
	
	finally {
		HibernateSessionFactory.closeSession();
	}
		
		
	}

}