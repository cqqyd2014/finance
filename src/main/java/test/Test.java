package test;


import org.hibernate.HibernateException;
import org.hibernate.Session;


import gov.cqaudit.finance.hibernate.HibernateSessionFactory;

public class Test {

	public static void main(String[] args) {
		java.util.ArrayList<String> cols=new java.util.ArrayList<>();
		cols.add("private_account_id");
		java.util.ArrayList<String> ops=new java.util.ArrayList<>();
		ops.add("=");
		java.util.ArrayList<String> values=new java.util.ArrayList<>();
		values.add("5001010125013377573");
		java.util.ArrayList<String> orders=new java.util.ArrayList<>();
		orders.add("private_trade_dat");
		orders.add("private_trade_seq");
		Session session = HibernateSessionFactory.getSession();
		try{
			@SuppressWarnings("unchecked")
			java.util.ArrayList<gov.cqaudit.finance.database.model.DataCorePrivateAccountTradeDetail> ms=(java.util.ArrayList<gov.cqaudit.finance.database.model.DataCorePrivateAccountTradeDetail>)gov.cqaudit.finance.database.common.logic.ExportView.getObject(session
					,"gov.cqaudit.finance.hibernate.dao", "gov.cqaudit.finance.database.model", "v_data_core_private_account_trade_detail"
					, cols, ops, values, orders);
			for (int i=0;i<ms.size();i++){
				gov.cqaudit.finance.database.model.DataCorePrivateAccountTradeDetail m=ms.get(i);
				System.out.println(m.getPrivate_account_id());
			}
			
		}
		catch (HibernateException e){
			
		}
		finally{
			HibernateSessionFactory.closeSession();
		}
		 
		

	}

}
