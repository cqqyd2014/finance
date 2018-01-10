package gov.cqaudit.finance.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;
@Repository
@Scope("prototype")
public class BillMDAOPostgresql {
	String abb="sdff";
	
	
	public String getAbb() {
		return abb;
	}

	public void setAbb(String abb) {
		this.abb = abb;
	}

	

}
