package gov.cqaudit.finance.bills.new_bill.ajax.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.HibernateException;

import com.cqqyd2014.annotation.Authority;

import gov.cqaudit.finance.common.LoginedAjaxAction;
import gov.cqaudit.finance.hibernate.HibernateSessionFactory;

@SuppressWarnings("serial")
@ParentPackage("bfkjs-json-default")
@Namespace("/bills")
public class DelPicAction   extends LoginedAjaxAction {
	
	String pic_uuid;
	



	@Action(value = "del_pic", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "del_pic", privilege = "[00010001]", error_url = "authority_ajax_error")
	@Override
	public String execute() {
	// TODO Auto-generated method stub
	super.execute();
	sm.setAuth_success(true);
			
			 session = HibernateSessionFactory.getSession();
			 tx = session.beginTransaction();
			try {
				
				
				gov.cqaudit.finance.bills.model.Picture pic=gov.cqaudit.finance.bills.logic.PictureLogic.getModelFromView(gov.cqaudit.finance.hibernate.dao.VPictureDAO.getEntityByUuid(session, pic_uuid));
				pic.setEffective(false);
				String bill_uuid=pic.getBill_uuid();
				gov.cqaudit.finance.bills.logic.PictureLogic.save(session, pic);
				session.flush();
				//得到图片数量，更新申请单
				java.math.BigDecimal pictures_num=gov.cqaudit.finance.hibernate.dao.PictureDAO.getEntityCountByBillUuid(session, bill_uuid);
				gov.cqaudit.finance.bills.model.BillM bm=gov.cqaudit.finance.bills.logic.BillMLogic.getModelFromView(gov.cqaudit.finance.hibernate.dao.VBillMDAO.getViewByUuid(session, bill_uuid));
				bm.setPics_num(pictures_num);
				gov.cqaudit.finance.bills.logic.BillMLogic.save(session, bm);
				session.flush();
				
			sm.setSuccess(true);
			tx.commit();
			
		}

		catch (HibernateException e) {
			
			if (null != tx) {
				tx.rollback();// 撤销事务

			}
			sm.setSuccess(false);
			sm.setBody(e.toString());
			
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		 finally {
				HibernateSessionFactory.closeSession();
			}
		sm.setSuccess(true);
		msg=sm.toMap();
		return SUCCESS;
	}




	public String getPic_uuid() {
		return pic_uuid;
	}




	public void setPic_uuid(String pic_uuid) {
		this.pic_uuid = pic_uuid;
	}
}