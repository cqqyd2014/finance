package gov.cqaudit.finance.data.common.action;

public class OrderItem {
	String col_field;
	String col_chinese_name;
	int order_order;
	String type;
	public String getCol_field() {
		return col_field;
	}
	public void setCol_field(String col_field) {
		this.col_field = col_field;
	}

	public String getCol_chinese_name() {
		return col_chinese_name;
	}
	public void setCol_chinese_name(String col_chinese_name) {
		this.col_chinese_name = col_chinese_name;
	}
	public int getOrder_order() {
		return order_order;
	}
	public void setOrder_order(int order_order) {
		this.order_order = order_order;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	String type_name;

}
