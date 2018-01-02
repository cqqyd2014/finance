package gov.cqaudit.finance.bills.new_bill.ajax.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.List;

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
public class PicUploadAction extends LoginedAjaxAction {

	String bill_uuid;

	public String getBill_uuid() {
		return bill_uuid;
	}

	public void setBill_uuid(String bill_uuid) {
		this.bill_uuid = bill_uuid;
	}

	
	
	



	private List<File> paper;

	public List<File> getPaper() {
		return paper;
	}

	public void setPaper(List<File> paper) {
		this.paper = paper;
	}

	private List<String> paperFileName;

	private List<String> paperContentType;

	public List<String> getPaperFileName() {
		return paperFileName;
	}

	public void setPaperFileName(List<String> paperFileName) {
		this.paperFileName = paperFileName;
	}

	public List<String> getPaperContentType() {
		return paperContentType;
	}

	public void setPaperContentType(List<String> paperContentType) {
		this.paperContentType = paperContentType;
	}

	// 上传的文件，struts会自动帮我们填充至此，因为多文件，所以用List
	private List<File> file;
	// 上传的文件的文件名，因为多文件，所以用List
	private List<String> fileFileName;
	// 上传的文件的类型，因为多文件，所以用List
	private List<String> fileContentType;

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}

	/**
	 * 文件上传关键方法。
	 */
	@SuppressWarnings("resource")
	@Action(value = "pic_upload", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "pic_upload", privilege = "[00010001]", error_url = "authority_ajax_error")
@Override
public String execute() {
// TODO Auto-generated method stub
super.execute();
sm.setAuth_success(true);
session = HibernateSessionFactory.getSession();
tx = session.beginTransaction();
try {
		// 文件所放的文件夹。，
		// 有关路径问题，请参考另一篇博文：http://www.cnblogs.com/xiaoMzjm/p/3878758.html
		//String root = ServletActionContext.getServletContext().getRealPath("/") + File.separator+"upload"+File.separator;
		// 循环上传的文件	
		java.util.ArrayList<String> pic_uuids=new java.util.ArrayList<>();
		java.util.ArrayList<String> pic_names=new java.util.ArrayList<>();
		
		for (int i = 0; i < paper.size(); i++) {
			//文件长度，限制在10M以内，10*1024*1024=10485760

			long file_size=paper.get(i).length();
			if (file_size>10485760) {
				throw new com.cqqyd2014.util.exception.AjaxSuccessMessageException("文件大小不能超过10M，当前大小："+file_size/1024/1024+"M。");
			}
			
			//文件类型只能为jpg等
			
			String content_type=paperContentType.get(i);
			if (content_type.equals("image/jpeg")||content_type.equals("image/png")||content_type.equals("image/tiff")) {
				//正常情况
			}
			else {
				throw new com.cqqyd2014.util.exception.AjaxSuccessMessageException("文件类型只能为JPG/PNG/TIFF");
			}
			//文件名长度
			String file_name=paperFileName.get(i);
			//文件名长度
			if (file_name.length()>1024) {
				throw new com.cqqyd2014.util.exception.AjaxSuccessMessageException("上传文件名长度不能超过1024个字符");
			}
			InputStream is = null;
			//OutputStream os = null;
			try {
				
				
				
				// 获取当前遍历到的文件，new 一个文件输入流，连接到该文件。
				is = new FileInputStream(paper.get(i));
				gov.cqaudit.finance.bills.model.Picture pic=new gov.cqaudit.finance.bills.model.Picture();
				byte[] input = new byte[is.available()];  
				
				is.read(input); 
				/*
				String barcode=gov.cqaudit.finance.bills.logic.PictureLogic.decode_barcode(input);
				if (barcode==null||barcode.equals("")) {
					throw new com.cqqyd2014.util.exception.AjaxSuccessMessageException("图片中二维码数据错误，请核实图片是否为系统生成的图片");
				}
				
				System.out.println(barcode);
				//测试是否为为当前单号
				if (!barcode.equals(bill_uuid)) {
					throw new com.cqqyd2014.util.exception.AjaxSuccessMessageException("图片中二维码数据错误，该图片不是对应本查询");
				}
				*/
				pic.setBill_uuid(bill_uuid);
				pic.setBin_data(input);
				pic.setContent_type(content_type);
				pic.setFile_name(file_name);
				pic.setLength(file_size);
				pic.setOp_dat(new java.util.Date());
				pic.setUser_id(user_id);
				String pic_uuid=com.cqqyd2014.util.StringUtil.getUUID();
				
				pic.setEffective(true);
				
				
				pic_names.add(file_name);
				pic_uuids.add(pic_uuid);
				pic.setUuid(pic_uuid);
				
				
			
				gov.cqaudit.finance.bills.logic.PictureLogic.save(session, pic);
				session.flush();
				//得到图片数量，更新申请单
				java.math.BigDecimal pictures_num=gov.cqaudit.finance.hibernate.dao.PictureDAO.getEntityCountByBillUuid(session, bill_uuid);
				gov.cqaudit.finance.bills.model.BillM bm=gov.cqaudit.finance.bills.logic.BillMLogic.getModelFromView(gov.cqaudit.finance.hibernate.dao.VBillMDAO.getViewByUuid(session, bill_uuid));
				bm.setPics_num(pictures_num);
				gov.cqaudit.finance.bills.logic.BillMLogic.save(session, bm);
				session.flush();
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				finally {
					
				}
			
			
		}
		sm.setSuccess(true);
		sm.setO(pic_uuids);
		sm.setO2(pic_names);
		tx.commit();
	}
catch(HibernateException e) {

			if (null != tx) {
				tx.rollback();// 撤销事务

			}

			sm.setSuccess(false);
			sm.setBody(e.toString());

		} 
		catch(com.cqqyd2014.util.exception.AjaxSuccessMessageException e) {
			if (null != tx) {
				tx.rollback();// 撤销事务

			}
			sm.setSuccess(false);
			sm.setBody(e.getMessage());
		}
		
		
		finally {
			HibernateSessionFactory.closeSession();
		}
		
		
		msg=sm.toMap();
		return SUCCESS;
	}
}