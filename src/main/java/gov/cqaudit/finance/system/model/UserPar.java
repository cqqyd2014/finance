package gov.cqaudit.finance.system.model;

public class UserPar {
	public String getPar_type() {
		return par_type;
	}
	public void setPar_type(String par_type) {
		this.par_type = par_type;
	}
	public String getPar_type_name() {
		return par_type_name;
	}
	public void setPar_type_name(String par_type_name) {
		this.par_type_name = par_type_name;
	}
	String param;
	String value;
	String userid;
	String param_desc;
	String par_type;
	String par_type_name;

	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getParam_desc() {
		return param_desc;
	}
	public void setParam_desc(String param_desc) {
		this.param_desc = param_desc;
	}



}
