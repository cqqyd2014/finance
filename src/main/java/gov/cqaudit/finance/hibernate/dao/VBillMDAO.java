package gov.cqaudit.finance.hibernate.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;

public final class VBillMDAO extends GetModelFromEntityViewDAO<gov.cqaudit.finance.bills.model.BillM>{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3976518198145080029L;
	
	

	//查询用户可用的查询单
	@SuppressWarnings("unchecked")
	public java.util.ArrayList<gov.cqaudit.finance.bills.model.BillM> getArrayListModelByCreateUserId(Session session,String create_user_id){
		String hql = "from VBillM where id.effective=true and id.createUserId=:create_user_id";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		q.setParameter("create_user_id", create_user_id);


		return  (java.util.ArrayList<gov.cqaudit.finance.bills.model.BillM>)getArrayListModelFromArrayListViewEntity((java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBillM>)q.list());
		
	
	}
	
	public java.util.ArrayList<gov.cqaudit.finance.bills.model.BillM> getArrayListModelWithDetailsPics(Session session,java.util.ArrayList<String> bill_uuids){
		java.util.ArrayList<gov.cqaudit.finance.bills.model.BillM> bms=new java.util.ArrayList<>();
		gov.cqaudit.finance.hibernate.dao.VBillDDAO vddao=new gov.cqaudit.finance.hibernate.dao.VBillDDAO();
		gov.cqaudit.finance.hibernate.dao.VPictureDAO vpdao=new gov.cqaudit.finance.hibernate.dao.VPictureDAO();
		gov.cqaudit.finance.hibernate.dao.VBillMessageDAO messagedao=new gov.cqaudit.finance.hibernate.dao.VBillMessageDAO();
		for (int i=0,len=bill_uuids.size();i<len;i++){
			String bill_uuid=bill_uuids.get(i);
			//System.out.println(bill_uuid);
			gov.cqaudit.finance.bills.model.BillM bm=getModelByUuid(session, bill_uuid);
			
			java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD> bds=vddao.getArrayListModelByBillUuid(session, bill_uuid);
			
			java.util.ArrayList<gov.cqaudit.finance.bills.model.Picture> pics=vpdao.getArrayListModelByBillUuid(session, bill_uuid);
			
			java.util.ArrayList<gov.cqaudit.finance.bills.model.BillMessage> messages=messagedao.getArrayListModelByBillUuid(session, bill_uuid);
			bm.setMessages(messages);
			bm.setBill_details(bds);
			bm.setPictures(pics);
			bms.add(bm);
			
			
		}
		return bms;
	}
	
	//订单数量的查询
	
		public java.math.BigInteger getBillUuidsCount(Session session, String bill_status,
				String contract_name, String pro_name, String create_user_id){
			String hql="select count(*) from ( select bill_uuid from v_bill_m where   effective=true and";

			
			if (create_user_id!=null&&!create_user_id.equals("")){
				hql=hql+" create_user_id=\'"+create_user_id+"\' and";
			}
			if (bill_status!=null&&!bill_status.equals("")){
				hql=hql+" bill_status=\'"+bill_status+"\' and";
			}
			if (contract_name!=null&&!contract_name.equals("")){
				hql=hql+"  contract_name like \'%"+contract_name+"%\' and";
			}
			if (pro_name!=null&&!pro_name.equals("")){
				hql=hql+" pro_name like \'%"+pro_name+"%\' and";
			}
			hql=hql.substring(0, hql.length()-3);
			hql=hql+" group by bill_uuid) t1";
			System.out.println(hql);
			//hql=hql.replaceAll("where     group", "   group");
			return (java.math.BigInteger)session.createSQLQuery(hql).uniqueResult();

			
		}
	
	public java.util.ArrayList<String> getArrayListBillUuids(Session session, String rows, String page, String bill_status,
			String contract_name, String pro_name, String create_user_id){
		int currentPage=Integer.parseInt(page);
		int pageSize=Integer.parseInt(rows);
		
		//长一点方便 后面去除三个字母
		String hql="select id.billUuid from VBillM where       ";
		if (create_user_id!=null&&!create_user_id.equals("")){
			hql=hql+"id.createUserId=:create_user_id  and ";
		}
	
		if (bill_status!=null&&!bill_status.equals("")){
			hql=hql+"id.billStatus=:bill_status  and ";
		}
		if (contract_name!=null&&!contract_name.equals("")){
			hql=hql+"id.contractName like :contract_name  and ";
		}
		if (pro_name!=null&&!pro_name.equals("")){
			hql=hql+"id.proName like :pro_name  and ";
		}
		hql=hql+"id.effective=true ";
		hql=hql+ " group by id.billUuid,id.createDat order by id.createDat desc";
		//System.out.print(hql);
		int offset = pageSize * (currentPage - 1);
		
		@SuppressWarnings("rawtypes")
		Query q=session.createQuery(hql).setFirstResult(offset)
				.setMaxResults(pageSize);
		
				if (create_user_id!=null&&!create_user_id.equals("")){
			q.setParameter("create_user_id", create_user_id);
		}
				if (bill_status!=null&&!bill_status.equals("")){
			q.setParameter("bill_status",bill_status);
		}
				if (contract_name!=null&&!contract_name.equals("")){
			q.setParameter("contract_name", "%"+contract_name+"%");
		}
		
		
				if (pro_name!=null&&!pro_name.equals("")){
			q.setParameter("pro_name", "%"+pro_name+"%");
		}
		
		
		
		@SuppressWarnings("unchecked")
		java.util.ArrayList<String> voms=(java.util.ArrayList<String>)q.list();
		
		return voms;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public java.util.ArrayList<gov.cqaudit.finance.bills.model.BillM> getArrayListViewArrayListWithBackMessageByBillUuid(Session session,java.util.ArrayList<String> bill_uuids){
		
		String bill_uuids_array=com.cqqyd2014.util.ArrayListTools.arrayListToSQLInString(bill_uuids);
		
		String hql = "from VBillM where id.effective=true and id.billUuid in "+bill_uuids_array;

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		


		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBillM> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBillM>) q
				.list();
		return (java.util.ArrayList<gov.cqaudit.finance.bills.model.BillM>)getArrayListModelFromArrayListViewEntity(sws);
	}
	
	
	
	@SuppressWarnings("unchecked")
	public java.util.ArrayList<gov.cqaudit.finance.bills.model.BillM> getArrayListViewArrayListBillUuid(Session session,java.util.ArrayList<String> bill_uuids){
		
		String bill_uuids_array=com.cqqyd2014.util.ArrayListTools.arrayListToSQLInString(bill_uuids);
		
		String hql = "from VBillM where id.effective=true and id.billUuid in "+bill_uuids_array;

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		


		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBillM> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBillM>) q
				.list();
		return (java.util.ArrayList<gov.cqaudit.finance.bills.model.BillM>)getArrayListModelFromArrayListViewEntity(sws);
	}
	
	
	public gov.cqaudit.finance.bills.model.BillM  getModelByUuid(Session session,String uuid){
		String hql = "from VBillM where id.effective=true and id.billUuid=:uuid";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		q.setParameter("uuid", uuid);

		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBillM> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBillM>) q
				.list();
		if (sws.size() == 0) {
			System.out.println("不能得到查询单数据，参数uuid:" + uuid);
			return null;
		} else {
			return getModelFromViewEntity(sws.get(0));
		}
	}

	@Override
	public <T> void save(Session session, T t) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.bills.model.BillM bm=(gov.cqaudit.finance.bills.model.BillM)t;
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
		bm_h.setBillType(bm.getBill_type());
		bm_h.setIfRoom(bm.isIf_room());
		bm_h.setIfOutput(bm.isIf_output());
		session.saveOrUpdate(bm_h);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, S> T getModelFromViewEntity(S s) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.hibernate.entities.VBillM vbm_h=(gov.cqaudit.finance.hibernate.entities.VBillM)s;
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
		bm.setBill_type(vbm_h.getId().getBillType());
		bm.setBill_type_name(vbm_h.getId().getBillTypeName());
		bm.setCreate_dat_print(com.cqqyd2014.util.DateUtil.getPrintFullString(vbm_h.getId().getCreateDat()));
		bm.setIf_room(vbm_h.getId().getIfRoom());
		bm.setIf_room_print(vbm_h.getId().getIfRoom()?"已打印":"未打印");
		bm.setIf_output(vbm_h.getId().getIfOutput());
		bm.setIf_output_print(vbm_h.getId().getIfOutput()?"已打印":"未打印");
		return (T)bm;
	}
}
