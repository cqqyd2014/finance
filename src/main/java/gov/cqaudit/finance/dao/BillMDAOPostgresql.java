package gov.cqaudit.finance.dao;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


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
