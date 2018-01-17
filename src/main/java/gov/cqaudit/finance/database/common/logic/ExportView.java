package gov.cqaudit.finance.database.common.logic;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


import org.hibernate.Session;

public class ExportView extends ExportViewBase{

	@SuppressWarnings("unchecked")
	@Override
	public Method getRowsMethod(@SuppressWarnings("rawtypes") Class clazz) throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		return clazz.getDeclaredMethod("getArrayListViewByHqlSql", Session.class,String.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<? extends Object> getRowsList(Method get_list_by_hql_sql_method,Object dao,Session session,String hql) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		return (java.util.ArrayList<? extends Object>) get_list_by_hql_sql_method.invoke(dao,session,hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Method getCountMethod(@SuppressWarnings("rawtypes") Class clazz) throws NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		return clazz.getDeclaredMethod("getCountByHqlSql", Session.class,String.class);
	}

	@Override
	public String getCountString(Method get_list_by_hql_sql_method, Object dao, Session session, String hql)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		return  (String)get_list_by_hql_sql_method.invoke(dao,session,hql);
	}

	
	
	
	
	

}
