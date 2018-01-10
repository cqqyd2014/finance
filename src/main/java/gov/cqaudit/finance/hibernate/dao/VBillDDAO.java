package gov.cqaudit.finance.hibernate.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;

public class VBillDDAO extends GetModelFromEntityViewDAO<gov.cqaudit.finance.bills.model.BillD>{
	
	@SuppressWarnings("unchecked")
	public  java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD> getArrayListModelByBillUuid(Session session,String bill_uuid){
		String hql = "from VBillD where id.effective=true and id.billUuid=:bill_uuid";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		q.setParameter("bill_uuid", bill_uuid);


		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBillD> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBillD>) q
				.list();
		
			return (java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD>)getArrayListModelFromArrayListViewEntity(sws);
		
	}

	@Override
	public <T> void save(Session session, T t) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.bills.model.BillD bd=(gov.cqaudit.finance.bills.model.BillD)t;
		gov.cqaudit.finance.hibernate.entities.BillD bd_h=new gov.cqaudit.finance.hibernate.entities.BillD();
		bd_h.setBankCode(bd.getBank_code());
		bd_h.setBusinessCode(bd.getBusiness_code());
		bd_h.setId(new gov.cqaudit.finance.hibernate.entities.BillDId(bd.getBill_uuid(), bd.getDetail_uuid()));
		bd_h.setSearchParCode(bd.getSearch_par_code());
		bd_h.setSearchParValue(bd.getSearch_par_value());
		bd_h.setEffective(bd.isEffective());
		bd_h.setCreateDat(bd.getCreate_dat());
		bd_h.setCreateUserid(bd.getCreate_userid());
		bd_h.setUnEffectiveDat(bd.getUn_effective_dat());
		bd_h.setUnEffectiveUserid(bd.getUn_effective_userid());
		
		session.saveOrUpdate(bd_h);
		
	}
	public  void save(Session session,java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD> bds) {
		for (int i=0;i<bds.size();i++) {
			save(session,bds.get(i));
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, S> T getModelFromViewEntity(S s) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.hibernate.entities.VBillD vbd_h=(gov.cqaudit.finance.hibernate.entities.VBillD)s;
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
		bd.setEffective(vbd_h.getId().getEffective());
		bd.setCreate_dat(vbd_h.getId().getCreateDat());
		bd.setCreate_userid(vbd_h.getId().getCreateUserid());
		bd.setUn_effective_dat(vbd_h.getId().getUnEffectiveDat());
		bd.setUn_effective_userid(vbd_h.getId().getUnEffectiveUserid());
		
		
		return (T)bd;
	}

}
