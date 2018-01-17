package gov.cqaudit.finance.data.common.action;

import java.lang.reflect.Field;

import org.apache.poi.xssf.usermodel.XSSFCell;

import gov.cqaudit.finance.annotation.DataTableView;
import gov.cqaudit.finance.annotation.Export;

import gov.cqaudit.finance.common.LoginedInitAction;
import net.sf.json.JSONArray;

public class GetDataInitAction extends LoginedInitAction{
	//实质是view_name
	String view_name;
	String model_package_name;
	String field_json;
	public String getField_json() {
		return field_json;
	}

	public void setField_json(String field_json) {
		this.field_json = field_json;
	}



	String par_json;
	String default_order_json;

	public String getDefault_order_json() {
		return default_order_json;
	}

	public void setDefault_order_json(String default_order_json) {
		this.default_order_json = default_order_json;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPar_json() {
		return par_json;
	}

	public void setPar_json(String par_json) {
		this.par_json = par_json;
	}

	public String getModel_package_name() {
		return model_package_name;
	}

	public void setModel_package_name(String model_package_name) {
		this.model_package_name = model_package_name;
	}


	
	public String getView_name() {
		return view_name;
	}

	public void setView_name(String view_name) {
		this.view_name = view_name;
	}



	String table_view_chinese_name;

	public String getTable_view_chinese_name() {
		return table_view_chinese_name;
	}

	public void setTable_view_chinese_name(String table_view_chinese_name) {
		this.table_view_chinese_name = table_view_chinese_name;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2236811005284065465L;

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		super.execute();
		//根据view_name得到
		String table_class=com.cqqyd2014.util.StringUtil.underlineToCamel(view_name);
		table_class=table_class.substring(0,1).toUpperCase()+table_class.substring(1,table_class.length());
		try {
			
			Class<?> clazz = Class.forName(model_package_name+"."+table_class.substring(1,table_class.length()));
			DataTableView dtv= clazz.getAnnotation(DataTableView.class);
			//表的中文名
			table_view_chinese_name=dtv.table_name();
			//分析列得到
			JSONArray json_pars = new JSONArray();
			JSONArray order_pars = new JSONArray();
			JSONArray json_field = new JSONArray();
			for (Field field : clazz.getDeclaredFields()) {

				field.setAccessible(true);
				// 分析是否有注解
				if (field.isAnnotationPresent(Export.class)) {
				
					Export export=field.getAnnotation(Export.class);
					//是否导出字段规则
					if (export.if_export()){
						FieldItem item=new FieldItem();
						item.setField(field.getName());
						item.setTitle(export.name());
						item.setOrder_id(export.export_order());
						json_field.add(item);
					}
					
					//搜索规则
					if (export.indexed()){
						ColItem ci=new ColItem();
						
						 ci.setField_chinese_name(export.name());
						 switch(export.xlsxtype()){
						 case XSSFCell.CELL_TYPE_NUMERIC:
							 ci.setCol_type("NUM_");
							 break;
						 case XSSFCell.CELL_TYPE_STRING:
							 ci.setCol_type("STR_");
							 break;
						 }
						 ci.setField_name(field.getName());
						 json_pars.add(ci);
						 
						 
						
					}
					else{
						//未建立索引的，不要成为可以添加的选项
					}
					//排序规则
					if (export.default_order()){
						OrderItem item=new OrderItem();
						item.setCol_field(field.getName());
						item.setCol_chinese_name(export.name());
						item.setOrder_order(export.order_order());
						item.setType(export.order_type());
						switch (export.order_type()){
						case "asc":
							item.setType_name("升序");
							break;
						case "desc":
							item.setType_name("降序");
							break;
						}
						
						
						order_pars.add(item);
						
					}
				}
			}
			par_json=json_pars.toString();
			default_order_json=order_pars.toString();
			
			field_json=json_field.toString();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

}
