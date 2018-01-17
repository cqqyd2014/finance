package gov.cqaudit.finance.hibernate.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;

public class VBillDBackDAO extends GetModelFromEntityViewDAO<gov.cqaudit.finance.bills.model.BillDBack>{
	@SuppressWarnings("unchecked")
	public  java.util.ArrayList<gov.cqaudit.finance.bills.model.BillDBack> getArrayListModelByBillUuid(Session session,String bill_uuid){
		String hql = "from VBillDBack where id.billUuid=:bill_uuid";

		@SuppressWarnings("rawtypes")
		Query q = session.createQuery(hql);
		q.setParameter("bill_uuid", bill_uuid);


		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBillDBack> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBillDBack>) q
				.list();
		
			return (java.util.ArrayList<gov.cqaudit.finance.bills.model.BillDBack>)getArrayListModelFromArrayListViewEntity(sws);
		
	}

	@Override
	public <T> void save(Session session, T t) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.bills.model.BillDBack m=(gov.cqaudit.finance.bills.model.BillDBack)t;
		gov.cqaudit.finance.hibernate.entities.BillDBack h=new gov.cqaudit.finance.hibernate.entities.BillDBack();
		h.setDetailCount(m.getRows_count());
		h.setCustomId(m.getCustom_id());
		h.setId(new gov.cqaudit.finance.hibernate.entities.BillDBackId(m.getBill_d_uuid(), m.getBill_d_uuid(), m.getAccount_id()));
		session.saveOrUpdate(m);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, S> T getModelFromViewEntity(S s) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.hibernate.entities.VBillDBack h=(gov.cqaudit.finance.hibernate.entities.VBillDBack)s;
		gov.cqaudit.finance.bills.model.BillDBack m=new gov.cqaudit.finance.bills.model.BillDBack();
		m.setAccount_id(h.getId().getAccountId());
		m.setBill_d_uuid(h.getId().getBillUuid());
		m.setBill_uuid(h.getId().getBillUuid());
		m.setBusiness_code(h.getId().getBusinessCode());
		m.setBusiness_name(h.getId().getBusinessName());
		m.setBank_code(h.getId().getBankCode());
		m.setBank_name(h.getId().getBankName());
		m.setRows_count(h.getId().getDetailCount());
		m.setSearch_par_code(h.getId().getSearchParCode());
		m.setSearch_par_name(h.getId().getSearchParName());
		m.setSearch_value(h.getId().getSearchParValue());
		m.setCustom_id(h.getId().getCustomId());
		m.setAccount_name(h.getId().getAccountName());
		return (T)m;
	}
}
