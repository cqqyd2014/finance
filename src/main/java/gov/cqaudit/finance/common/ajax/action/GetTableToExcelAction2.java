package gov.cqaudit.finance.common.ajax.action;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.cqqyd2014.common.action.DownloadFromServerAbstractAction;

import gov.cqaudit.finance.annotation.Export;
import gov.cqaudit.finance.database.model.DataCorePrivateAccountTradeDetail;
import gov.cqaudit.finance.hibernate.HibernateSessionFactory;

@SuppressWarnings("serial")
@ParentPackage("bfkjs-default")
@Namespace("/data_export")
public class GetTableToExcelAction2 extends DownloadFromServerAbstractAction {

	String table_name;
	String filter_cols;
	String filter_ops;
	String filter_orders;
	String filter_ordertypes;


	public String getFilter_ops() {
		return filter_ops;
	}

	public void setFilter_ops(String filter_ops) {
		this.filter_ops = filter_ops;
	}

	String filter_values;



	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String getFilter_cols() {
		return filter_cols;
	}

	public void setFilter_cols(String filter_cols) {
		this.filter_cols = filter_cols;
	}

	public String getFilter_values() {
		return filter_values;
	}

	public void setFilter_values(String filter_values) {
		this.filter_values = filter_values;
	}

	String file_name;

	@Override
	public String setDownloadFileName() {
		// TODO Auto-generated method stub
		return table_name + ".xlsx";
	}

	byte[] bs;

	@Override
	public byte[] setByteDate() {
		// TODO Auto-generated method stub

		return bs;
	}

	@Action(value = "get_table_to_excel2", results = { @Result(name = "success", type = "stream", params = {
			"contentType", "${content_type}", "inputName", "inputStream", "contentDisposition",
			"attachment;filename=\"${file_name}\"", "bufferSize", "4096" }) })
	@Override
	public String execute_download() {
		// 创建新的Excel 工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();

		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		try {

			String[] filter_col_array = filter_cols.split(",");
			String[] filter_value_array = filter_values.split(",");
			String[] filter_op_array=filter_ops.split(",");
			String[] orders_array = filter_orders.split(",");
			String[] ordertype_array=filter_ordertypes.split(",");
			String table_camel_name=com.cqqyd2014.util.StringUtil.underlineToCamel(table_name);
			String view_name="v_"+table_name;
			String model_name=table_camel_name.substring(0,1).toUpperCase()+table_camel_name.substring(1,table_camel_name.length());
			String model_package_name="gov.cqaudit.finance.database.model";
			String dao_package_name="gov.cqaudit.finance.hibernate.dao";
			Class<?> model_clazz=Class.forName(model_package_name+"."+model_name);  
 			
			export(workbook,dao_package_name,model_package_name, view_name, model_clazz,session,filter_col_array, filter_op_array,filter_value_array,orders_array,ordertype_array);
				

			// gov.cqaudit.finance.dataexport.xls.Ooxml.exportWorkBook(workbook,
			// session, table_code, filter_cols, filter_values);

			// 新建一输出文件流
			ByteArrayOutputStream fos = new ByteArrayOutputStream();
			// 把相应的Excel 工作簿存盘
			workbook.write(fos);
			fos.flush();
			bs = fos.toByteArray();
			// 操作结束，关闭文件
			fos.close();

		} catch (HibernateException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return SUCCESS;
	}

	public String getFilter_ordertypes() {
		return filter_ordertypes;
	}

	public void setFilter_ordertypes(String filter_ordertypes) {
		this.filter_ordertypes = filter_ordertypes;
	}

	public String getFilter_orders() {
		return filter_orders;
	}

	public void setFilter_orders(String filter_orders) {
		this.filter_orders = filter_orders;
	}

	@Override
	public String setContentType() {
		// TODO Auto-generated method stub

		return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	}

	private static void export(XSSFWorkbook workbook, String dao_package_name,String model_package_name,String view_name,@SuppressWarnings("rawtypes") java.lang.Class clazz,Session session, String[] filter_col_array,String[] filter_op_array,
			String[] filter_value_array,String[] orders_array,String[] ordertype_array) {
		// 检测参数是否正确

		// 在Excel工作簿中建一工作表，其名为缺省值
		XSSFSheet sheet = workbook.createSheet();
		XSSFRow head = sheet.createRow(0);
		// 在索引0的位置创建行（最顶端的行）

		for (Field field : clazz.getDeclaredFields()) {

			field.setAccessible(true);
			// 分析是否有注解
			if (field.isAnnotationPresent(Export.class)) {
				Export export = (Export) field.getAnnotation(Export.class);
				String name = export.name();
				int xlsxtype = export.xlsxtype();
				int export_order = export.export_order();
				boolean if_export = export.if_export();
				if (if_export) {

					XSSFCell cell = head.createCell(export_order);
					cell.setCellType(xlsxtype);
					cell.setCellValue(name);

				}

			}
		}

		// 开始查询数据库
		java.util.ArrayList<String> cols=com.cqqyd2014.util.StringUtil.ArrayToArrayList(filter_col_array);
		//cols.add("private_account_id");
		java.util.ArrayList<String> ops=com.cqqyd2014.util.StringUtil.ArrayToArrayList(filter_op_array);
		//ops.add("=");
		java.util.ArrayList<String> values=com.cqqyd2014.util.StringUtil.ArrayToArrayList(filter_value_array);
		//values.add("5001010125013377573");
		java.util.ArrayList<String> orders=com.cqqyd2014.util.StringUtil.ArrayToArrayList(orders_array);
		java.util.ArrayList<String> order_types=com.cqqyd2014.util.StringUtil.ArrayToArrayList(ordertype_array);
		
		
		
		gov.cqaudit.finance.database.common.logic.ExportView ev=new gov.cqaudit.finance.database.common.logic.ExportView();
		
		java.util.ArrayList<? extends Object> ms=(java.util.ArrayList<? extends Object>)
		ev.getRows(session
				,dao_package_name, model_package_name, view_name
				, cols, ops, values, orders,order_types);

		// ===============================================================
		// 添加数据
		for (int n = 0, len = ms.size(); n < len; n++) {
			Object m = ms.get(n);

			XSSFRow row_value = sheet.createRow(n + 1);
			for (Field field : clazz.getDeclaredFields()) {

				field.setAccessible(true);
				// 分析是否有注解
				if (field.isAnnotationPresent(Export.class)) {
					Export export = (Export) field.getAnnotation(Export.class);

					boolean if_export = export.if_export();
					if (if_export) {

						String field_name = field.getName();
						int export_order = export.export_order();
						int xlsxtype = export.xlsxtype();
						// Class<? extends Field> field_class=field.getClass();

						String type_name = field.getGenericType().getTypeName();
						

						try {

							@SuppressWarnings("unchecked")
							Method m1 = clazz
									.getDeclaredMethod(com.cqqyd2014.util.StringUtil.getMethod(field_name));
							switch (type_name) {
							case ("java.lang.String"):
								String field_string_value = (String) m1.invoke(m);
								XSSFCell celld = row_value.createCell(export_order);
								celld.setCellType(xlsxtype);
								celld.setCellValue(field_string_value);
								break;
							case ("java.math.BigDecimal"):
								java.math.BigDecimal field_dec_value = (java.math.BigDecimal) m1.invoke(m);
								XSSFCell celld_dec = row_value.createCell(export_order);
								celld_dec.setCellType(xlsxtype);
								celld_dec.setCellValue(field_dec_value.doubleValue());
								
								break;
							default:

							}

						} catch (NoSuchMethodException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				}
			}

		}

	}

}