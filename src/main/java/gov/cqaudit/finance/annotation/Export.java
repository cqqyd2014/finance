package gov.cqaudit.finance.annotation;

import static java.lang.annotation.ElementType.FIELD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.poi.xssf.usermodel.XSSFCell;

@Target(FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Export {
	/** 是否导出 */
	 boolean if_export() default true;
	 
	 /** 类型 */
	 int xlsxtype() default XSSFCell.CELL_TYPE_STRING;
	 
	 /**名称**/
	 String name() ;
	 
	 /**是否来源数据库字段*/
	 boolean if_database() default true;
	 
	 /**输出顺序**/
	 
	 int export_order()  default -1;
}
