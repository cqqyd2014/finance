package gov.cqaudit.finance.datatrans.logic;

import org.hibernate.Session;

public class DataTransDLogic {
	public static gov.cqaudit.finance.datatrans.model.DataTransD getModelFromView(gov.cqaudit.finance.hibernate.entities.VDataTransD vtm){
		gov.cqaudit.finance.datatrans.model.DataTransD dm=new gov.cqaudit.finance.datatrans.model.DataTransD();
		dm.setBill_uuid(vtm.getId().getBillUuid());
		dm.setDetail_uuid(vtm.getId().getDetailUuid());
		dm.setTrans_uuid(vtm.getId().getTransUuid());
		
		return dm;
	}
	public static java.util.ArrayList<gov.cqaudit.finance.datatrans.model.DataTransD> getArrayListModelFromArrayListView(java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VDataTransD> vtms){
		java.util.ArrayList<gov.cqaudit.finance.datatrans.model.DataTransD> dms=new java.util.ArrayList<>();
		for (int i=0,len=vtms.size();i<len;i++){
			gov.cqaudit.finance.datatrans.model.DataTransD dm=getModelFromView(vtms.get(i));
			dms.add(dm);
		}
		return dms;
	}
	public static void save(Session session,gov.cqaudit.finance.datatrans.model.DataTransD dtd){
		gov.cqaudit.finance.hibernate.entities.DataTransD dtd_h=new gov.cqaudit.finance.hibernate.entities.DataTransD();
		dtd_h.setBillUuid(dtd.getBill_uuid());
		dtd_h.setId(new gov.cqaudit.finance.hibernate.entities.DataTransDId(dtd.getTrans_uuid(), dtd.getDetail_uuid()));
		session.saveOrUpdate(dtd_h);
	}
}
