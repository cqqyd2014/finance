package gov.cqaudit.finance.common;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class InitAction extends ActionSupport  implements ServletResponseAware, ServletContextAware{


	@Override
	public String execute()  {
		// TODO Auto-generated method stub
		
		try {
			return super.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ServletContext servletContext;
	public HttpServletResponse response;

	@Override
	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub
		this.servletContext = servletContext;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

}
