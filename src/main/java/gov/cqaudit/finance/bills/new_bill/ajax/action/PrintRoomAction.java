package gov.cqaudit.finance.bills.new_bill.ajax.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.HibernateException;

import com.opensymphony.xwork2.ActionContext;

import gov.cqaudit.finance.common.PdfPrintInitAbstractAction;
import gov.cqaudit.finance.hibernate.HibernateSessionFactory;

@ParentPackage("bfkjs-default")
@Namespace("/bills")
public class PrintRoomAction extends PdfPrintInitAbstractAction {

	String bill_uuid;

	public String getBill_uuid() {
		return bill_uuid;
	}

	public void setBill_uuid(String bill_uuid) {
		this.bill_uuid = bill_uuid;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 4539517901870069008L;

	@Override
	public String setDownloadFileName() {
		// TODO Auto-generated method stub
		return "银行数据分析室使用审批表" + bill_uuid;
	}

	@Override
	public String setJasperPath() {
		// TODO Auto-generated method stub
		return "/jasper/bill/";
	}

	@Override
	public String setJasperFileName() {
		// TODO Auto-generated method stub
		return "room.jasper";
	}

	@Action(value = "bill_room", results = { @Result(name = "success", type = "stream", params = { "contentType",
			"application/pdf", "inputName", "inputStream", "contentDisposition", "attachment;filename=\"${file_name}\"",
			"bufferSize", "4096" }) })
	@Override
	public String execute_pdf_print() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	@Override
	public ArrayList<? extends Object> initializeBeanArray() {
		session = HibernateSessionFactory.getSession();
		
		java.util.ArrayList<String> bill_uuids = com.cqqyd2014.util.StringUtil.ArrayToArrayList(bill_uuid.split(","));
		java.util.ArrayList<gov.cqaudit.finance.statistics.model.StatisticsBillsResult> bms = null;
		tx=session.beginTransaction();
		try {
			// TODO Auto-generated method stub
			gov.cqaudit.finance.hibernate.dao.VStatisticsBillsResultDAO vbdao=new gov.cqaudit.finance.hibernate.dao.VStatisticsBillsResultDAO();
			bms = vbdao.getArrayListModelByBillUuids(session, bill_uuids);
			gov.cqaudit.finance.hibernate.dao.VBillMDAO bmdao=new gov.cqaudit.finance.hibernate.dao.VBillMDAO();
			for (int i=0,len=bms.size();i<len;i++){
				gov.cqaudit.finance.bills.model.BillM bm=bmdao.getModelByUuid(session, bms.get(i).getBill_uuid());
				bm.setIf_room(true);
				bmdao.save(session, bm);
				
				
			}
			tx.commit();
			
			
			
		} catch (HibernateException e) {
			if (null != tx) {
				tx.rollback();// 撤销事务

			}
			System.out.println("Hibernate错误"+e.toString());

		} finally {
			HibernateSessionFactory.closeSession();
		}
		return bms;
	}

	@Override
	public String setImagesPath() {
		// TODO Auto-generated method stub

		HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+"util_web/common/get_qrcode.action?msg=";

		return basePath;
	}

}