package gov.cqaudit.finance.datatrans.download_reqest.ajax.action;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cqqyd2014.common.action.DownloadFromServerAbstractAction;
import com.opensymphony.xwork2.ActionContext;

import gov.cqaudit.finance.hibernate.HibernateSessionFactory;

public class DownloadXmlRequestAction extends DownloadFromServerAbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3488761291458633572L;
	String bills;
	String trans_uuid;
	ByteArrayOutputStream baos;
	String xml_string;
	java.util.ArrayList<String> bank_arraylist;

	public java.util.ArrayList<String> getBank_arraylist() {
		return bank_arraylist;
	}

	public void setBank_arraylist(java.util.ArrayList<String> bank_arraylist) {
		this.bank_arraylist = bank_arraylist;
	}

	public String getXml_string() {
		return xml_string;
	}

	public void setXml_string(String xml_string) {
		this.xml_string = xml_string;
	}

	public String getTrans_uuid() {
		return trans_uuid;
	}

	public void setTrans_uuid(String trans_uuid) {
		this.trans_uuid = trans_uuid;
	}

	public String getBills() {
		return bills;
	}

	public void setBills(String bills) {
		this.bills = bills;
	}

	@Override
	public String setDownloadFileName() {
		// TODO Auto-generated method stub
		String file_name=trans_uuid+"_";
		for (int i=0,len=bank_arraylist.size();i<len;i++){
			file_name=file_name+bank_arraylist.get(i);
		}
		file_name=file_name+".xml";
		return file_name;
	}

	@Override
	public byte[] setByteDate() {
		// TODO Auto-generated method stub
		return baos.toByteArray();
	}

	@Override
	public String setContentType() {
		// TODO Auto-generated method stub
		return "text/xml";
	}
	 @Action(value="download_xml_request", results = { @Result(name = "success", type = "stream", params = {  
	 	        "contentType", "${content_type}",  
	 	        "inputName", "inputStream", "contentDisposition",  
	 	        "attachment;filename=\"${file_name}\"", "bufferSize",  
	 	        "4096"  }) })  

	@Override
	public String execute_download() {
		// TODO Auto-generated method stub
		 bank_arraylist=new java.util.ArrayList<>();
		 Session session = HibernateSessionFactory.getSession();
		 Transaction tx=session.beginTransaction();
         try {   
        	 Document document = DocumentHelper.createDocument(); 
        	 Element root = document.addElement("Request");
        	 root.addAttribute("service","account_search");
        	 root.addAttribute("lang","zh-CN");
        	 Element head=root.addElement("Head");
        	 trans_uuid=com.cqqyd2014.util.StringUtil.getUUID();
        	 head.addAttribute("trans_id", trans_uuid);
        	 Element body=root.addElement("Body");
        	 
        	 
        	 gov.cqaudit.finance.datatrans.model.DataTransM dm=new gov.cqaudit.finance.datatrans.model.DataTransM();
        	 java.util.Date now=new java.util.Date();
        	 dm.setDownload_dat(now);
        	 dm.setTrans_uuid(trans_uuid);
        	 dm.setUpload_user_id("");
        	 dm.setUpload_dat(com.cqqyd2014.util.DateUtil.ShortStringToJDate("1900-1-1"));
        	 dm.setBank_working_dat(com.cqqyd2014.util.DateUtil.ShortStringToJDate("1900-1-1"));
        	 Map<String,Object> session_http= ActionContext.getContext().getSession();

     		
     		String user_id = (String) session_http.get("user_id");
     		
     		
     		dm.setUser_id(user_id);
     		
        	 gov.cqaudit.finance.datatrans.logic.DataTransMLogic.save(session, dm);
        	 String[] bill_array=bills.split(",");
        	 for (int i=0;i<bill_array.length;i++){
        		 String bill_uuid=bill_array[i];
        		 //更新申请单状态
        		 gov.cqaudit.finance.hibernate.dao.VBillMDAO vbdao=new gov.cqaudit.finance.hibernate.dao.VBillMDAO();
        		 gov.cqaudit.finance.bills.model.BillM bm=vbdao.getModelByUuid(session, bill_uuid);
        		 
        		 bm.setLast_modify_dat(now);
        		 bm.setBill_status("等待返回");
        		 vbdao.save(session, bm);
        		 //处理传输明细
        		 gov.cqaudit.finance.datatrans.model.DataTransD dtd=new gov.cqaudit.finance.datatrans.model.DataTransD();
        		 dtd.setBill_uuid(bill_uuid);
        		 dtd.setDetail_uuid(com.cqqyd2014.util.StringUtil.getUUID());
        		 dtd.setTrans_uuid(trans_uuid);
        		 gov.cqaudit.finance.datatrans.logic.DataTransDLogic.save(session, dtd);
        		 //分析这个单子情况
        		 Element bill=body.addElement("bill");
        		 bill.addAttribute("bill_id", bill_uuid);
        		 java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD> bds=gov.cqaudit.finance.bills.logic.BillDLogic.getArrayListFromArrayListView(gov.cqaudit.finance.hibernate.dao.VBillDDAO.getArrayListViewByBillUuid(session, bill_uuid));
        		 for (int j=0,len_j=bds.size();j<len_j;j++){
        			 gov.cqaudit.finance.bills.model.BillD db=bds.get(j);
        			 Element item=bill.addElement("item");
        			 item.addAttribute("item_id", db.getDetail_uuid());
        			 if (bank_arraylist.indexOf(db.getBank_code())==-1){
        				 bank_arraylist.add(db.getBank_code());
        			 }
        			 
        			 item.addAttribute("bank_code", db.getBank_code());
        			 item.addAttribute("business_code", db.getBusiness_code());
        			 item.addAttribute("search_par_code", db.getSearch_par_code());
        			 item.addAttribute("search_par_value", db.getSearch_par_value());
        			 
        		 }
        		 
        	 }
        	 //创建字符串缓冲区 
             StringWriter stringWriter = new StringWriter();  
             //设置文件编码  
             OutputFormat xmlFormat = new OutputFormat();  
             xmlFormat.setEncoding("UTF-8"); 
             // 设置换行 
             xmlFormat.setNewlines(true); 
             // 生成缩进 
             xmlFormat.setIndent(true); 
             // 使用4个空格进行缩进, 可以兼容文本编辑器 
             xmlFormat.setIndent("    "); 
             try {
            	 baos=new ByteArrayOutputStream();
				XMLWriter xmlWriter = new XMLWriter(baos,xmlFormat);
				xmlWriter.write(document);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 //xml_string=document.asXML();
        	 tx.commit();
	             

         } catch (HibernateException e) {  
        	 if (null != tx) {
 				tx.rollback();// 撤销事务

 			}
	             e.printStackTrace();   
	         }  
         finally {
				HibernateSessionFactory.closeSession();
			}
	return SUCCESS;
	}

}
