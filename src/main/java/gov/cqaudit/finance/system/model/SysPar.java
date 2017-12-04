package gov.cqaudit.finance.system.model;

public class SysPar {
	String code;
	String value;
	String desc;
	java.util.ArrayList<gov.cqaudit.finance.system.model.SysParItem> items;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public java.util.ArrayList<gov.cqaudit.finance.system.model.SysParItem> getItems() {
		return items;
	}
	public void setItems(java.util.ArrayList<gov.cqaudit.finance.system.model.SysParItem> items) {
		this.items = items;
	}

}
