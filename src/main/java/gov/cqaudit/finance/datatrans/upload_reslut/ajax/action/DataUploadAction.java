package gov.cqaudit.finance.datatrans.upload_reslut.ajax.action;

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
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.hibernate.HibernateException;

import com.cqqyd2014.annotation.Authority;

import gov.cqaudit.finance.common.LoginedAjaxAction;
import gov.cqaudit.finance.datatrans.upload_reslut.XmlDataToolsResult;
import gov.cqaudit.finance.hibernate.HibernateSessionFactory;

@SuppressWarnings("serial")
@ParentPackage("bfkjs-json-default")
@Namespace("/trans")
public class DataUploadAction extends LoginedAjaxAction {

	

	
	
	



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

	@Action(value = "data_upload", results = { @Result(type = "json", params = { "root", "msg" }) }, interceptorRefs = {
			
			@InterceptorRef("defaultStack"),
			@InterceptorRef("authorityInterceptor") })
@Authority(module = "data_upload", privilege = "[00040002]", error_url = "authority_ajax_error")
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
		
		
		for (int i = 0; i < paper.size(); i++) {
			//文件长度，限制在1000M以内，1000*1024*1024=1048576000

			long file_size=paper.get(i).length();
			if (file_size>1048576000) {
				throw new com.cqqyd2014.util.exception.AjaxSuccessMessageException("文件大小不能超过1000M，当前大小："+file_size/1024/1024+"M。");
			}
			
			//文件类型只能为jpg等
			
			String content_type=paperContentType.get(i);
			if (content_type.equals("text/xml")) {
				//正常情况
			}
			else {
				throw new com.cqqyd2014.util.exception.AjaxSuccessMessageException("文件类型只能为xml");
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
				
				//gov.cqaudit.finance.bills.model.Picture pic=new gov.cqaudit.finance.bills.model.Picture();
				//byte[] input = new byte[is.available()];  
				
				//is.read(input); 
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
				SAXReader reader = new SAXReader();
				reader.setEncoding("UTF-8");
				 Document doc = reader.read(is);  
				 //doc.setXMLEncoding("UTF-8");
		            // 获取根节点  
		            
		            java.util.ArrayList<XmlDataToolsResult> rs=gov.cqaudit.finance.datatrans.upload_reslut.XmlDataTools.decode(session, doc, user_id);
		            is.close();
		            sm.setO(rs);
		            //分析查询单的情况
		            //从transd得到bills
		            Element root = doc.getRootElement();
		            Element head=root.element("Head");
		    		String trans_uuid=head.attributeValue("trans_id");
		    		session.flush();
		    		gov.cqaudit.finance.datatrans.upload_reslut.after.AccountSearch.afterToDo(session, trans_uuid,dept_id,user_id,ip_addr);
		    		
					
				} catch (IOException | DocumentException e) {
					e.printStackTrace();
				}
				finally {
					
				}
			
			
		}
		
		sm.setSuccess(true);
		
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