package gov.cqaudit.finance.datatrans.logic;

import org.hibernate.Session;

public final class DataTransBackLogic {
	public static gov.cqaudit.finance.datatrans.model.DataTransBack getModelFromView(gov.cqaudit.finance.hibernate.entities.VDataTransBack h){
		gov.cqaudit.finance.datatrans.model.DataTransBack m=new gov.cqaudit.finance.datatrans.model.DataTransBack();
		m.setBank_code(h.getId().getBankCode());
		m.setRows_count(h.getId().getRowsCount());
		m.setTable_code(h.getId().getBankCode());
		m.setTrans_uuid(h.getId().getTransUuid());
		return m;
		
	}
	public static java.util.ArrayList<gov.cqaudit.finance.datatrans.model.DataTransBack> getArrayListModelFromArrayListView(java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VDataTransBack> hs){
		java.util.ArrayList<gov.cqaudit.finance.datatrans.model.DataTransBack> ms=new java.util.ArrayList<>();
		for (int i=0,len=hs.size();i<len;i++){
			gov.cqaudit.finance.datatrans.model.DataTransBack m=getModelFromView(hs.get(i));
			ms.add(m);
		}
		return ms;
	}

	public static void save(Session session,gov.cqaudit.finance.datatrans.model.DataTransBack m){
		gov.cqaudit.finance.hibernate.entities.DataTransBack h=new gov.cqaudit.finance.hibernate.entities.DataTransBack();
		h.setId(new gov.cqaudit.finance.hibernate.entities.DataTransBackId(m.getTrans_uuid(), m.getBank_code(), m.getTable_code()));
		h.setRowsCount(m.getRows_count());
		session.saveOrUpdate(h);
	}
}
