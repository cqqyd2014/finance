package test;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import gov.cqaudit.finance.dao.BillMDAOPostgresql;

@Component
@Scope("prototype")
public class MessagePrinter {
	@Resource
	BillMDAOPostgresql billMDAOPostgresql;

    

	public void printMessage() {
        System.out.println("testok");
    }
}