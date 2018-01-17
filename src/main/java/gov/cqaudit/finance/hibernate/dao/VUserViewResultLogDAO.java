package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Session;

import com.cqqyd2014.common.hibernate.GetModelFromEntityViewDAO;

@SuppressWarnings("serial")
public class VUserViewResultLogDAO extends GetModelFromEntityViewDAO<gov.cqaudit.finance.bills.model.UserViewResultLog>{

	

	@Override
	public <T> void save(Session session, T t) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.bills.model.UserViewResultLog m=(gov.cqaudit.finance.bills.model.UserViewResultLog)t;
		gov.cqaudit.finance.hibernate.entities.UserViewResultLog h=new gov.cqaudit.finance.hibernate.entities.UserViewResultLog();
		h.setId(new gov.cqaudit.finance.hibernate.entities.UserViewResultLogId(m.getUser_id(), m.getDept_id(), m.getView_dat()));
		h.setDeptId(m.getDept_id());
		h.setUserIp(m.getIp());
		session.saveOrUpdate(h);
		
	}

	@Override
	public <T, S> T getModelFromViewEntity(S s) {
		// TODO Auto-generated method stub
		gov.cqaudit.finance.bills.model.UserViewResultLog m=new gov.cqaudit.finance.bills.model.UserViewResultLog();
		gov.cqaudit.finance.hibernate.entities.VUserViewResultLog h=(gov.cqaudit.finance.hibernate.entities.VUserViewResultLog)s;
		m.setDept_id(h.getId().getDeptId());
		m.setDept_name(h.getId().getDeptName());
		m.setIp(h.getId().getUserIp());
		m.setUser_id(h.getId().getUserId());
		m.setUser_name(h.getId().getUserName());
		m.setView_dat(h.getId().getViewDat());
		m.setView_dat_print(com.cqqyd2014.util.DateUtil.getPrintFullString(h.getId().getViewDat()));
		m.setView_dat_chinese_print(com.cqqyd2014.util.DateUtil.getLocalFullString(h.getId().getViewDat()));
		return null;
	}

}
