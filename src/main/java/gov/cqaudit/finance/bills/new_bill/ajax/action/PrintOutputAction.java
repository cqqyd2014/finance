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
public class PrintOutputAction extends PdfPrintInitAbstractAction {

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
		return "银行数据拷出审批表" + bill_uuid;
	}

	@Override
	public String setJasperPath() {
		// TODO Auto-generated method stub
		return "/jasper/bill/";
	}

	@Override
	public String setJasperFileName() {
		// TODO Auto-generated method stub
		return "data_out_put.jasper";
	}

	@Action(value = "bill_output", results = { @Result(name = "success", type = "stream", params = { "contentType",
			"application/pdf", "inputName", "inputStream", "contentDisposition", "attachment;filename=\"${file_name}\"",
			"bufferSize", "4096" }) })
	@Override
	public String execute_pdf_print() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	@Override
	public ArrayList<? extends Object> initializeBeanArray() {
		init_print();
		session = HibernateSessionFactory.getSession();
		tx=session.beginTransaction();
		java.util.ArrayList<String> bill_uuids = com.cqqyd2014.util.StringUtil.ArrayToArrayList(bill_uuid.split(","));
		java.util.ArrayList<gov.cqaudit.finance.statistics.model.StatisticsBillsResult> bms = null;
		try {
			// TODO Auto-generated method stub
			gov.cqaudit.finance.hibernate.dao.VStatisticsBillsResultDAO vbdao=new gov.cqaudit.finance.hibernate.dao.VStatisticsBillsResultDAO();
			bms = vbdao.getArrayListModelByBillUuids(session, bill_uuids);
			//设置审核人员，只有manager可以审核
			if (com.cqqyd2014.util.ArrayListTools.indexOfArrayList(sys_roles, "manager")!=-1){
				gov.cqaudit.finance.hibernate.dao.VBillMDAO vbmdao=new gov.cqaudit.finance.hibernate.dao.VBillMDAO();
				for (int i=0;i<bill_uuids.size();i++){
					gov.cqaudit.finance.bills.model.BillM bm=vbmdao.getModelByUuid(session, bill_uuids.get(i));
					bm.setAudit_user_id(user_id);
					bm.setLast_audit_dat(new java.util.Date());
					if (bm.getBill_status().equals("返回待审")){
						bm.setBill_status("查看结果");
					}
					
					vbmdao.save(session, bm);
					
					
				}
				tx.commit();
			}
			
			
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