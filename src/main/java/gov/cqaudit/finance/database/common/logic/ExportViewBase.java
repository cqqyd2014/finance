package gov.cqaudit.finance.database.common.logic;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.hibernate.Session;

public abstract class ExportViewBase {
	
	//得到rows数据
		public abstract Method getCountMethod(@SuppressWarnings("rawtypes") Class clazz) throws NoSuchMethodException, SecurityException;
		public abstract String getCountString(Method get_list_by_hql_sql_method,Object dao,Session session,String hql)  throws IllegalAccessException, IllegalArgumentException, InvocationTargetException ;
		public   String getCount(Session session,String dao_package_name,String model_package_name
				,String table_name,java.util.ArrayList<String> cols,java.util.ArrayList<String> ops
				,java.util.ArrayList<String> values,java.util.ArrayList<String> orders,java.util.ArrayList<String> order_types){
			String hql=getCountHql(session,dao_package_name,model_package_name,table_name,cols,ops,values,orders,order_types);
			Object dao=null;
			String table_class=com.cqqyd2014.util.StringUtil.underlineToCamel(table_name);
			
			
			table_class=table_class.substring(0,1).toUpperCase()+table_class.substring(1,table_class.length());
			String dao_class=table_class+"DAO";
			Class<?> clazz = null;
			try {
				clazz = Class.forName(dao_package_name+"."+dao_class);
				dao = clazz.newInstance();
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Method get_list_by_hql_sql_method=null;
			try {
				get_list_by_hql_sql_method=getCountMethod(clazz);
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String ms=null;
			//System.out.println("ready");
			try {
				ms = getCountString(get_list_by_hql_sql_method,dao,session,hql);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return ms;
		}
	
	
	
	//得到rows数据
	public abstract Method getRowsMethod(@SuppressWarnings("rawtypes") Class clazz) throws NoSuchMethodException, SecurityException;
	public abstract java.util.ArrayList<? extends Object> getRowsList(Method get_list_by_hql_sql_method,Object dao,Session session,String hql)  throws IllegalAccessException, IllegalArgumentException, InvocationTargetException ;

	public   java.util.ArrayList<? extends Object> getRows(Session session,String dao_package_name,String model_package_name
			,String table_name,java.util.ArrayList<String> cols,java.util.ArrayList<String> ops
			,java.util.ArrayList<String> values,java.util.ArrayList<String> orders,java.util.ArrayList<String> order_types){
		String hql=getRowsHql(session,dao_package_name,model_package_name,table_name,cols,ops,values,orders,order_types);
		Object dao=null;
		String table_class=com.cqqyd2014.util.StringUtil.underlineToCamel(table_name);
		
		
		table_class=table_class.substring(0,1).toUpperCase()+table_class.substring(1,table_class.length());
		String dao_class=table_class+"DAO";
		Class<?> clazz = null;
		try {
			clazz = Class.forName(dao_package_name+"."+dao_class);
			dao = clazz.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Method get_list_by_hql_sql_method=null;
		try {
			get_list_by_hql_sql_method=getRowsMethod(clazz);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.util.ArrayList<? extends Object> ms=null;
		//System.out.println("ready");
		try {
			ms = getRowsList(get_list_by_hql_sql_method,dao,session,hql);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ms;
	}
	
	
	public String getCountHql(Session session,String dao_package_name,String model_package_name,String table_name
			,java.util.ArrayList<String> cols,java.util.ArrayList<String> ops,java.util.ArrayList<String> values
			,java.util.ArrayList<String> orders,java.util.ArrayList<String> order_types){
		String rowsHql=getRowsHql(session,dao_package_name,model_package_name,table_name,cols,ops,values,orders,order_types);
		return "select count(*) "+rowsHql;
	}

	public  String getRowsHql(Session session,String dao_package_name
			,String model_package_name,String table_name,java.util.ArrayList<String> cols
			,java.util.ArrayList<String> ops,java.util.ArrayList<String> values
			,java.util.ArrayList<String> orders,java.util.ArrayList<String> order_types){
		//构建sql
		String table_class=com.cqqyd2014.util.StringUtil.underlineToCamel(table_name);
		
		
		table_class=table_class.substring(0,1).toUpperCase()+table_class.substring(1,table_class.length());
		//String model_class=table_class.substring(1,table_class.length());

		//System.out.println(table_class);
		String hql="from "+table_class+" ";
		
		//三个参数的长度需要一致
		int cols_len=cols.size();
		int ops_len=ops.size();
		int values_len=values.size();
		if (cols_len>0){
			hql=hql+" where ";
			int max=Math.max(cols_len, Math.max(ops_len, values_len));
			int min=Math.min(cols_len, Math.min(ops_len, values_len));
			if (max==min){
				//三个参数一致
				for (int i=0;i<cols_len;i++){
					String col=cols.get(i);
					//String col_camel=com.cqqyd2014.util.StringUtil.underlineToCamel(col);
					String op=ops.get(i);
					//System.out.println("op is "+op);
					String value=values.get(i);
					if (i>0){
						hql=hql+" and ";
					}
					hql=hql+"id."+com.cqqyd2014.util.StringUtil.underlineToCamel(col);
					//得到类，分析其
					
						Class<?> clazz=null;
						try {
							//实体类，没有V
							clazz = Class.forName(model_package_name+"."+table_class.substring(1,table_class.length()));
							
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Field field=null;
						try {
							
							field = clazz.getDeclaredField(col);
						} catch (NoSuchFieldException | SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							field.setAccessible(true);
							String type_name = field.getGenericType().getTypeName();
							switch (type_name) {
							case ("java.lang.String"):
								switch(op){
								case ("="):
									hql=hql+"=\'"+value+"\'";
									break;
								case ("in"):
									//in这个方法内容为逗号分隔符“a,b,c”
									String[] value_array=value.split(",");
									java.util.ArrayList<String> value_arraylist=com.cqqyd2014.util.StringUtil.ArrayToArrayList(value_array);
									String sql_in=com.cqqyd2014.util.ArrayListTools.arrayListToSQLInString(value_arraylist);
									hql=hql+" in "+sql_in;
									break;
								case ("like"):
									hql=hql+" like \'%"+value+"%\'";
									break;
								
								
								
								}
								
								break;
							case ("java.math.BigDecimal"):
								switch(op){
								case ("="):
									hql=hql+"="+value+"";
									break;
								case (">"):
									hql=hql+">"+value+"";
									break;
								case ("<"):
									hql=hql+"<"+value+"";
									break;
								
								
								
								
								
								}
								
								break;
							case ("java.util.Date"):
								
								break;
							default:

							}
						
						
				
			
		}
				
			}
			else{
				System.out.println("获取数据的三个参数长度不一致，分别为：cols"+cols_len+",ops"+ops_len+",values"+values_len);
				//不构建where语句
			}
			
			
		}
		else{
			//不构建where语句
		}
			//构建order by
			int order_len=orders.size();
			if (order_len>0){
				hql=hql+" order by ";
				for (int i=0;i<order_len;i++){
					if (i>0){
						hql=hql+",";
					}
					hql=hql+"id."+com.cqqyd2014.util.StringUtil.underlineToCamel(orders.get(i))+" "+order_types.get(i);
					
				}
			}
			else{
				//不构建orderby语句
				
			}
			return hql;
		
		}
		
	
		
	

}
