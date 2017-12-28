package gov.cqaudit.finance.common;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cqqyd2014.common.print.action.PdfPrintAbstractAction;


public abstract class PdfPrintInitAbstractAction extends PdfPrintAbstractAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Session session;
	public Transaction tx;
	public Transaction getTx() {
		return tx;
	}

	public void setTx(Transaction tx) {
		this.tx = tx;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}



	


}