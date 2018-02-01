package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Session;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;

public class VBillMessageDAO extends GetModelFromEntityViewDAO<gov.cqaudit.finance.bills.model.BillMessage>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4535116473060736364L;
	
	
	
	public java.util.ArrayList<gov.cqaudit.finance.bills.model.BillMessage> getArrayListModelByBillUuid(Session session,String bill_uuid){
		
		String str="from VBillMessage where id.billUuid=\'"+bill_uuid+"\'";
		return getArrayListViewByHqlSql(session,str);
	}

	@Override
	public <T> void save(Session session, T t) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.hibernate.entities.BillMessage e=new gov.cqaudit.finance.hibernate.entities.BillMessage();
		gov.cqaudit.finance.bills.model.BillMessage m=(gov.cqaudit.finance.bills.model.BillMessage)t;
		e.setBillUuid(m.getBill_uuid());
		e.setCreateDat(m.getCreate_dat());
		e.setCreateMessageUserId(m.getUser_id());
		e.setDeptId(m.getDept_id());
		e.setIpAddr(m.getIp_addr());
		e.setMessage(m.getMessage());
		e.setMessageType(m.getType_id());
		e.setMessageUuid(m.getMessage_uuid());
		session.saveOrUpdate(e);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T, S> T getModelFromViewEntity(S s) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.bills.model.BillMessage m=new gov.cqaudit.finance.bills.model.BillMessage();
		gov.cqaudit.finance.hibernate.entities.VBillMessage e=(gov.cqaudit.finance.hibernate.entities.VBillMessage)s;
		m.setCraete_dat_print(com.cqqyd2014.util.DateUtil.getPrintFullString(e.getId().getCreateDat()));
		m.setCreate_dat(e.getId().getCreateDat());
		m.setDept_id(e.getId().getDeptId());
		m.setDept_name(e.getId().getDeptName());
		m.setIp_addr(e.getId().getIpAddr());
		m.setMessage_uuid(e.getId().getMessageUuid());
		m.setMessage(e.getId().getMessage());
		m.setType_id(e.getId().getMessageType());
		m.setType_name(e.getId().getMessageTypeName());
		m.setUser_id(e.getId().getCreateMessageUserId());
		m.setUser_name(e.getId().getUserName());
		m.setBill_uuid(e.getId().getBillUuid());
		
		return (T)m;
	}

}
