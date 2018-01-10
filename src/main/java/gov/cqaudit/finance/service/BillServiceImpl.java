package gov.cqaudit.finance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import gov.cqaudit.finance.dao.BillMDAO;

@Service
@Scope("prototype")
public class BillServiceImpl  implements BillService{
	public BillMDAO getBillm_dao() {
		return billm_dao;
	}

	public void setBillm_dao(BillMDAO billm_dao) {
		this.billm_dao = billm_dao;
	}

	@Autowired
	BillMDAO billm_dao;

	@Override
	public void save(gov.cqaudit.finance.bills.model.BillM bm) {
		// TODO Auto-generated method stub
		billm_dao.saveModel(bm);
		
	}

}
