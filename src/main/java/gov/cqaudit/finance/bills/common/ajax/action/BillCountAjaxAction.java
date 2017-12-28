package gov.cqaudit.finance.bills.common.ajax.action;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import gov.cqaudit.finance.common.LoginedAjaxAction;
import gov.cqaudit.finance.hibernate.HibernateSessionFactory;

public abstract class BillCountAjaxAction extends LoginedAjaxAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract java.math.BigInteger getBillsCount(Session session, String search_bill_bill_status,
			String search_bill_contract_name, String search_bill_pro_name, String create_user_id);

	java.math.BigInteger bill_count;

	public java.math.BigInteger getBill_count() {
		return bill_count;
	}

	public void setBill_count(java.math.BigInteger bill_count) {
		this.bill_count = bill_count;
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

	String search_bill_bill_status;
	String search_bill_contract_name;
	String create_user_id;
	public String getCreate_user_id() {
		return create_user_id;
	}

	public void setCreate_user_id(String create_user_id) {
		this.create_user_id = create_user_id;
	}

	String search_bill_pro_name;




	public abstract String getJson() ;

	public java.math.BigInteger getCountImpl() {

		java.math.BigInteger order_count = new java.math.BigInteger("0");

		// TODO Auto-generated method stub

		super.execute();

		session = HibernateSessionFactory.getSession();


		try {
			
			order_count = getBillsCount(session,  search_bill_bill_status,
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
		return order_count;

	}

}