package gov.cqaudit.finance.bills.new_bill.ajax.action;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

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



public class PrintBillAction extends PdfPrintInitAbstractAction {

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
		return "账户查询单" + bill_uuid;
	}

	@Override
	public String setJasperPath() {
		// TODO Auto-generated method stub
		return "/jasper/bill/";
	}

	@Override
	public String setJasperFileName() {
		// TODO Auto-generated method stub
		return "BillM20171210.jasper";
	}

	@Action(value = "bill_print", results = { @Result(name = "success", type = "stream", params = { "contentType",
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
		tx=session.beginTransaction();
		java.util.ArrayList<String> uuids = com.cqqyd2014.util.StringUtil.ArrayToArrayList(bill_uuid.split(","));
		java.util.ArrayList<gov.cqaudit.finance.bills.model.BillM> bms = null;
		try {
			// TODO Auto-generated method stub
			bms = gov.cqaudit.finance.bills.logic.BillMLogic.getArrayListModelFromArrayListView(
					gov.cqaudit.finance.hibernate.dao.VBillMDAO.getArrayListViewArrayListBillUuid(session, uuids));

			for (int i = 0; i < bms.size(); i++) {
				gov.cqaudit.finance.bills.model.BillM bm = bms.get(i);
				bm.setBill_details(gov.cqaudit.finance.bills.logic.BillDLogic
						.getArrayListFromArrayListView(gov.cqaudit.finance.hibernate.dao.VBillDDAO
								.getArrayListViewByBillUuid(session, bm.getBill_uuid())));
				if (bm.getBill_status().equals("起草申请")){
					bm.setBill_status("打印待签");
					gov.cqaudit.finance.bills.logic.BillMLogic.save(session, bm);
				}
				

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