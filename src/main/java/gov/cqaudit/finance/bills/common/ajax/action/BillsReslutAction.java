package gov.cqaudit.finance.bills.common.ajax.action;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import gov.cqaudit.finance.common.LoginedAjaxAction;
import gov.cqaudit.finance.hibernate.HibernateSessionFactory;

public abstract class BillsReslutAction extends LoginedAjaxAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6472697541103745438L;
	


	String page;
	String rows;
	String search_bill_bill_status;
	String search_bill_contract_name;

	String search_bill_pro_name;

	String create_user_id;
	

	public String getCreate_user_id() {
		return create_user_id;
	}

	public void setCreate_user_id(String create_user_id) {
		this.create_user_id = create_user_id;
	}


	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getSearch_bill_bill_status() {
		return search_bill_bill_status;
	}

	public void setSearch_bill_bill_status(String search_bill_bill_status) {
		this.search_bill_bill_status = search_bill_bill_status;
	}

	public String getSearch_bill_contract_name() {
		return search_bill_contract_name;
	}

	public void setSearch_bill_contract_name(String search_bill_contract_name) {
		this.search_bill_contract_name = search_bill_contract_name;
	}

	public String getSearch_bill_pro_name() {
		return search_bill_pro_name;
	}

	public void setSearch_bill_pro_name(String search_bill_pro_name) {
		this.search_bill_pro_name = search_bill_pro_name;
	}
	public abstract String getDataGrid();
	public abstract String getTotalImpl(Session session, String search_bill_bill_status,
			String search_bill_contract_name, String search_bill_pro_name, String create_user_id);

	public abstract java.util.ArrayList<String> getBillsImpl(Session session, String rows, String page, String search_bill_bill_status,
			String search_bill_contract_name, String search_bill_pro_name, String create_user_id); 
	
	
	public java.util.ArrayList<gov.cqaudit.finance.bills.model.BillM> getBills()  {
		
		

		// TODO Auto-generated method stub


		super.execute();
		
		session = HibernateSessionFactory.getSession();

		java.util.ArrayList<gov.cqaudit.finance.bills.model.BillM> items=new java.util.ArrayList<>();
		
		try {
			
			
			//java.util.ArrayList<String> order_no_list=vomgbdao.getOrderNos(session, start_date, end_date, com_id, rows, page, order_status, user_name, user_tell, goods_name, original_id, barcode, express_no,package_user,send_user);
			
			
			java.util.ArrayList<String> bills_uuids=getBillsImpl(session,  rows, page, search_bill_bill_status, search_bill_contract_name, search_bill_pro_name, create_user_id);
			
			
			
			if (bills_uuids.size()==0) {
				items=new java.util.ArrayList<>();
			}
			else {
				
				
				
				items=gov.cqaudit.finance.bills.logic.BillMLogic.getArrayListModelWithDetailsPics(session, bills_uuids);
			}
			
			
			
			
			
			
			
			
			
			
			
			
		}

		catch (HibernateException e) {
			
			if (null != tx) {
				tx.rollback();// 撤销事务

			}
			System.out.println(e.getMessage());
			e.printStackTrace();
			

			
		}
		finally {
			HibernateSessionFactory.closeSession();
		}
		return items;
		
		
	}
	public String getTotal() {

		String bill_total = "0";

		// TODO Auto-generated method stub

		super.execute();

		session = HibernateSessionFactory.getSession();


		try {
			
			bill_total = getTotalImpl(session,  search_bill_bill_status,
					search_bill_contract_name, search_bill_pro_name, create_user_id);

			

		}

		catch (Exception e) {

			if (null != tx) {
				tx.rollback();// 撤销事务

			}
			System.out.println(e.getMessage());
			e.printStackTrace();

		} finally {
			HibernateSessionFactory.closeSession();
		}
		return bill_total;

	}
}
