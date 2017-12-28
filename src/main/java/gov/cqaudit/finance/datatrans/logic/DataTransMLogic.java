package gov.cqaudit.finance.datatrans.logic;

import org.hibernate.Session;

public final class DataTransMLogic {
	public static gov.cqaudit.finance.datatrans.model.DataTransM getModelFromView(gov.cqaudit.finance.hibernate.entities.VDataTransM vtm){
		gov.cqaudit.finance.datatrans.model.DataTransM dm=new gov.cqaudit.finance.datatrans.model.DataTransM();
		dm.setDownload_dat(vtm.getId().getDownloadDat());
		dm.setTrans_uuid(vtm.getId().getTransUuid());
		dm.setUpload_dat(vtm.getId().getUploadDat());
		dm.setUser_id(vtm.getId().getUserId());
		dm.setBank_working_dat(vtm.getId().getDownloadDat());
		dm.setUpload_user_id(vtm.getId().getUploadUserId());
		return dm;
	}
	public static java.util.ArrayList<gov.cqaudit.finance.datatrans.model.DataTransM> getArrayListModelFromArrayListView(java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VDataTransM> vtms){
		java.util.ArrayList<gov.cqaudit.finance.datatrans.model.DataTransM> dms=new java.util.ArrayList<>();
		for (int i=0,len=vtms.size();i<len;i++){
			gov.cqaudit.finance.datatrans.model.DataTransM dm=getModelFromView(vtms.get(i));
			dms.add(dm);
		}
		return dms;
	}
	public static void save(Session session,gov.cqaudit.finance.datatrans.model.DataTransM dtm){
		gov.cqaudit.finance.hibernate.entities.DataTransM dm=new gov.cqaudit.finance.hibernate.entities.DataTransM();
		dm.setDownloadDat(dtm.getDownload_dat());
		dm.setTransUuid(dtm.getTrans_uuid());
		dm.setUploadDat(dtm.getUpload_dat());
		dm.setUserId(dtm.getUser_id());
		dm.setBankWorkingDat(dtm.getBank_working_dat());
		dm.setUploadUserId(dtm.getUpload_user_id());
		session.saveOrUpdate(dm);
	}

}
