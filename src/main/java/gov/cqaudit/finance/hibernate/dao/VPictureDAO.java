package gov.cqaudit.finance.hibernate.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;

public class VPictureDAO  extends GetModelFromEntityViewDAO<gov.cqaudit.finance.bills.model.Picture>{
	public java.util.ArrayList<gov.cqaudit.finance.bills.model.Picture> getArrayListModelFromArrayListViewEntityNoPics(
			java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VPicture> hs) {
		java.util.ArrayList<gov.cqaudit.finance.bills.model.Picture> ms = new java.util.ArrayList<>();
		for (int i = 0, len = hs.size(); i < len; i++) {
			@SuppressWarnings("unchecked")
			gov.cqaudit.finance.bills.model.Picture m = getModelFromViewEntityNoPics( hs.get(i));
			ms.add(m);
		}
		return ms;
	}
	
	
	
	public  java.util.ArrayList<gov.cqaudit.finance.bills.model.Picture> getArrayListModelByBillUuid(Session session,String bill_uuid){
		String hql = "from VPicture where id.effective=true and id.billUuid=:bill_uuid order by id.opDat";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		q.setParameter("bill_uuid", bill_uuid);
		
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VPicture> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VPicture>) q
				.list();
		return getArrayListModelFromArrayListViewEntityNoPics(sws);
	}
	
	public  gov.cqaudit.finance.bills.model.Picture getEntityByUuid(Session session,String uuid){
		String hql = "from VPicture where id.uuid=:uuid";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		q.setParameter("uuid", uuid);
		
		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VPicture> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VPicture>) q
				.list();
		if (sws.size()==0) {
			System.out.println("不能得到图片："+uuid);
			return null;
		}
		else {
			return getModelFromViewEntity(sws.get(0));
		}
}

	@Override
	public <T> void save(Session session, T t) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.bills.model.Picture p=(gov.cqaudit.finance.bills.model.Picture)t;
		gov.cqaudit.finance.hibernate.entities.Picture p_h=new gov.cqaudit.finance.hibernate.entities.Picture();
		p_h.setBillUuid(p.getBill_uuid());
		p_h.setBinData(p.getBin_data());
		p_h.setEffective(p.isEffective());
		p_h.setFileLength(p.getLength());
		p_h.setFileName(p.getFile_name());
		p_h.setFileType(p.getContent_type());
		p_h.setOpDat(p.getOp_dat());
		p_h.setUserId(p.getUser_id());
		p_h.setUuid(p.getUuid());
		session.saveOrUpdate(p_h);
		
	}
	public gov.cqaudit.finance.bills.model.Picture getModelFromViewEntityNoPics(gov.cqaudit.finance.hibernate.entities.VPicture s) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.hibernate.entities.VPicture vp=(gov.cqaudit.finance.hibernate.entities.VPicture)s;
		gov.cqaudit.finance.bills.model.Picture p=new gov.cqaudit.finance.bills.model.Picture();
		
		p.setContent_type(vp.getId().getFileType());
		p.setEffective(vp.getId().getEffective());
		p.setFile_name(vp.getId().getFileName());
		p.setLength(vp.getId().getFileLength());
		p.setOp_dat(vp.getId().getOpDat());
		p.setUser_id(vp.getId().getUserId());
		p.setUser_name(vp.getId().getUserName());
		p.setUuid(vp.getId().getUuid());
		p.setBill_uuid(vp.getId().getBillUuid());
		return p;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, S> T getModelFromViewEntity(S s) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.hibernate.entities.VPicture vp=(gov.cqaudit.finance.hibernate.entities.VPicture)s;
		gov.cqaudit.finance.bills.model.Picture p=new gov.cqaudit.finance.bills.model.Picture();
		p.setBin_data(vp.getId().getBinData());
		p.setContent_type(vp.getId().getFileType());
		p.setEffective(vp.getId().getEffective());
		p.setFile_name(vp.getId().getFileName());
		p.setLength(vp.getId().getFileLength());
		p.setOp_dat(vp.getId().getOpDat());
		p.setUser_id(vp.getId().getUserId());
		p.setUser_name(vp.getId().getUserName());
		p.setUuid(vp.getId().getUuid());
		p.setBill_uuid(vp.getId().getBillUuid());
		return (T)p;
	}
}