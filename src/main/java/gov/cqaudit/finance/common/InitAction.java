package gov.cqaudit.finance.common;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class InitAction extends ActionSupport{
	String jquery_version;
	String easyi_version;
	public String getEasyi_version() {
		return easyi_version;
	}

	public void setEasyi_version(String easyi_version) {
		this.easyi_version = easyi_version;
	}

	public String getJquery_ui_version() {
		return jquery_ui_version;
	}

	public void setJquery_ui_version(String jquery_ui_version) {
		this.jquery_ui_version = jquery_ui_version;
	}

	String jquery_ui_version;

	public String getJquery_version() {
		return jquery_version;
	}

	public void setJquery_version(String jquery_version) {
		this.jquery_version = jquery_version;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		return super.execute();
	}
	public void init_js_par(Session session) {
		gov.cqaudit.finance.hibernate.dao.SysParDAO spdao=new gov.cqaudit.finance.hibernate.dao.SysParDAO();
		gov.cqaudit.finance.hibernate.entites.SysPar sp_jquery_ver=spdao.getEntityByCode(session, "jquery_ver");
		jquery_version=sp_jquery_ver.getValue();
		gov.cqaudit.finance.hibernate.entites.SysPar sp_jquery_ui_ver=spdao.getEntityByCode(session, "jquery_ui_ver");
		jquery_ui_version=sp_jquery_ui_ver.getValue();
		gov.cqaudit.finance.hibernate.entites.SysPar sp_easyui_ver=spdao.getEntityByCode(session, "easyui_ver");
		easyi_version=sp_easyui_ver.getValue();
	}

}