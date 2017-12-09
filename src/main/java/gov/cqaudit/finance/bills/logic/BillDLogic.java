package gov.cqaudit.finance.bills.logic;

import org.hibernate.Session;

public class BillDLogic {
	
	public static gov.cqaudit.finance.bills.model.BillD getModelFromView(gov.cqaudit.finance.hibernate.entites.VBillD vbd_h){
		gov.cqaudit.finance.bills.model.BillD bd=new gov.cqaudit.finance.bills.model.BillD();
		bd.setBank_code(vbd_h.getId().getBankCode());
		bd.setBank_name(vbd_h.getId().getBankName());
		bd.setBill_uuid(vbd_h.getId().getBillUuid());
		bd.setBusiness_code(vbd_h.getId().getBusinessCode());
		bd.setBusiness_code_name(vbd_h.getId().getBusinessName());
		bd.setDetail_uuid(vbd_h.getId().getDetailUuid());
		bd.setSearch_par_code(vbd_h.getId().getSearchParCode());
		bd.setSearch_par_code_name(vbd_h.getId().getSearchParName());
		bd.setSearch_par_value(vbd_h.getId().getSearchParValue());
		
		return bd;
	}
	
	public static java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD> getArrayListFromArrayListView(java.util.ArrayList<gov.cqaudit.finance.hibernate.entites.VBillD> vbds){
		java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD> bds=new java.util.ArrayList<>();
		for (int i=0;i<vbds.size();i++) {
			gov.cqaudit.finance.bills.model.BillD bd=getModelFromView(vbds.get(i));
			bds.add(bd);
		}
		return bds;
	}
	
	public static void save(Session session,gov.cqaudit.finance.bills.model.BillD bd) {
		gov.cqaudit.finance.hibernate.entites.BillD bd_h=new gov.cqaudit.finance.hibernate.entites.BillD();
		bd_h.setBankCode(bd.getBank_code());
		bd_h.setBusinessCode(bd.getBusiness_code());
		bd_h.setId(new gov.cqaudit.finance.hibernate.entites.BillDId(bd.getBill_uuid(), bd.getDetail_uuid()));
		bd_h.setSearchParCode(bd.getSearch_par_code());
		bd_h.setSearchParValue(bd.getSearch_par_value());
		session.saveOrUpdate(bd_h);
	}
	
	public static void save(Session session,java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD> bds) {
		for (int i=0;i<bds.size();i++) {
			save(session,bds.get(i));
		}
	}

}
