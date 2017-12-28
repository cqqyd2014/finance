package gov.cqaudit.finance.bills.logic;

import org.hibernate.Session;

public class BillMLogic {
	
	public static java.util.ArrayList<gov.cqaudit.finance.bills.model.BillM> getArrayListModelWithDetailsPics(Session session,java.util.ArrayList<String> bill_uuids){
		java.util.ArrayList<gov.cqaudit.finance.bills.model.BillM> bms=new java.util.ArrayList<>();
		for (int i=0,len=bill_uuids.size();i<len;i++){
			String bill_uuid=bill_uuids.get(i);
			gov.cqaudit.finance.bills.model.BillM bm=getModelFromView(gov.cqaudit.finance.hibernate.dao.VBillMDAO.getViewByUuid(session, bill_uuid));
			
			java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD> bds=gov.cqaudit.finance.bills.logic.BillDLogic.getArrayListFromArrayListView(gov.cqaudit.finance.hibernate.dao.VBillDDAO.getArrayListViewByBillUuid(session, bill_uuid));
			java.util.ArrayList<gov.cqaudit.finance.bills.model.Picture> pics=gov.cqaudit.finance.bills.logic.PictureLogic.getArrayListModelFromArrayListView(gov.cqaudit.finance.hibernate.dao.VPictureDAO.getArrayListViewByBillUuid(session, bill_uuid));
			bm.setBill_details(bds);
			bm.setPictures(pics);
			bms.add(bm);
			
			
		}
		return bms;
	}
	
	
	
	
	public static gov.cqaudit.finance.bills.model.BillM getModelFromView(gov.cqaudit.finance.hibernate.entities.VBillM vbm_h){
		gov.cqaudit.finance.bills.model.BillM bm=new gov.cqaudit.finance.bills.model.BillM();
		bm.setPics_num(vbm_h.getId().getPicsNum());
		bm.setAudit_user_id(vbm_h.getId().getAuditUserId());
		bm.setAudit_user_name(vbm_h.getId().getAuditUserName());
		bm.setEffective(vbm_h.getId().getEffective());
		bm.setBill_status(vbm_h.getId().getBillStatus());
		bm.setBill_uuid(vbm_h.getId().getBillUuid());
		bm.setContract_mail(vbm_h.getId().getContractMail());
		bm.setContract_name(vbm_h.getId().getContractName());
		bm.setContract_tell(vbm_h.getId().getContractTell());
		bm.setCreate_dat(vbm_h.getId().getCreateDat());
		bm.setCreate_user_id(vbm_h.getId().getCreateUserId());
		bm.setCreate_dat(vbm_h.getId().getCreateDat());
		bm.setCreate_user_name(vbm_h.getId().getCreateUserName());
		bm.setDept_id(vbm_h.getId().getDeptId());
		bm.setDept_name(vbm_h.getId().getDeptName());
		bm.setDownload_dat(vbm_h.getId().getDownloadDat());
		bm.setDownload_user_id(vbm_h.getId().getDownloadUserId());
		bm.setDownload_user_name(vbm_h.getId().getDownloadUserName());
		bm.setDownload_uuid(vbm_h.getId().getDownloadUuid());
		bm.setLast_modify_dat(vbm_h.getId().getLastModifyDat());
		bm.setLast_audit_dat(vbm_h.getId().getLastAuditDat());
		bm.setPro_name(vbm_h.getId().getProName());
		bm.setSearch_reason(vbm_h.getId().getSearchReason());
		bm.setCreate_dat_chinese_print(com.cqqyd2014.util.DateUtil.getLocalFullString(vbm_h.getId().getCreateDat()));
		bm.setDownload_dat_chinese_print(com.cqqyd2014.util.DateUtil.getLocalFullString(vbm_h.getId().getDownloadDat()));
		bm.setLast_audit_dat_chinese_print(com.cqqyd2014.util.DateUtil.getLocalFullString(vbm_h.getId().getLastAuditDat()));
		bm.setLast_modify_dat_chinese_print(com.cqqyd2014.util.DateUtil.getLocalFullString(vbm_h.getId().getLastModifyDat()));
		bm.setUneffecitve_user_id(vbm_h.getId().getUneffectiveUserId());
		bm.setUneffecitve_user_name(vbm_h.getId().getUneffectiveUserName());
		bm.setUneffective_dat(vbm_h.getId().getUneffectiveDat());
		bm.setUneffective_dat_chinese_print(com.cqqyd2014.util.DateUtil.getLocalFullString(vbm_h.getId().getUneffectiveDat()));
		bm.setDetail_num(vbm_h.getId().getDetailNum());
		return bm;
		
	}
	public static java.util.ArrayList<gov.cqaudit.finance.bills.model.BillM> getArrayListModelFromArrayListView(java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBillM> vbms_h){
		java.util.ArrayList<gov.cqaudit.finance.bills.model.BillM> bms=new java.util.ArrayList<>();
		for (int i=0;i<vbms_h.size();i++) {
			gov.cqaudit.finance.bills.model.BillM bm=getModelFromView(vbms_h.get(i));
			bms.add(bm);
		}
		return bms;
	}
	public static void save(Session session,gov.cqaudit.finance.bills.model.BillM bm) {
		gov.cqaudit.finance.hibernate.entities.BillM bm_h=new gov.cqaudit.finance.hibernate.entities.BillM();
		bm_h.setAuditUserId(bm.getAudit_user_id());
		bm_h.setBillStatus(bm.getBill_status());
		bm_h.setBillUuid(bm.getBill_uuid());
		bm_h.setContractMail(bm.getContract_mail());
		bm_h.setContractName(bm.getContract_name());
		bm_h.setContractTell(bm.getContract_tell());
		bm_h.setCreateDat(bm.getCreate_dat());
		bm_h.setCreateUserId(bm.getCreate_user_id());
		bm_h.setDeptId(bm.getDept_id());
		bm_h.setDownloadDat(bm.getDownload_dat());
		bm_h.setDownloadUserId(bm.getDownload_user_id());
		bm_h.setDownloadUuid(bm.getDownload_uuid());
		bm_h.setLastAuditDat(bm.getLast_audit_dat());
		bm_h.setLastModifyDat(bm.getLast_modify_dat());
		bm_h.setProName(bm.getPro_name());
		bm_h.setSearchReason(bm.getSearch_reason());
		bm_h.setEffective(bm.isEffective());
		bm_h.setPicsNum(bm.getPics_num());
		bm_h.setDetailNum(bm.getDetail_num());
		bm_h.setUneffectiveDat(bm.getUneffective_dat());
		bm_h.setUneffectiveUserId(bm.getUneffecitve_user_id());
		
		session.saveOrUpdate(bm_h);
		
	}

}
