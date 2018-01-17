package gov.cqaudit.finance.data.common.action;

public class LogicItem {
	String uuid;
	String col_field;
	String col_name;
	String op;
	String value;
	public String getCol_field() {
		return col_field;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public void setCol_field(String col_field) {
		this.col_field = col_field;
	}
	public String getCol_name() {
		return col_name;
	}
	public void setCol_name(String col_name) {
		this.col_name = col_name;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

}
