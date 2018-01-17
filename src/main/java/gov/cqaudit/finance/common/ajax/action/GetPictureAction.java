package gov.cqaudit.finance.common.ajax.action;


import org.apache.struts2.convention.annotation.Action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import org.hibernate.HibernateException;
import org.hibernate.Session;



import com.cqqyd2014.common.action.DownloadFromServerAbstractAction;

import gov.cqaudit.finance.hibernate.HibernateSessionFactory;

@SuppressWarnings("serial")
@ParentPackage("bfkjs-default")
@Namespace("/bills")



public class GetPictureAction   extends DownloadFromServerAbstractAction {
	

	String uuid;
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}



	String file_name;
	

	     
	     


		@Override
		public String setDownloadFileName() {
			// TODO Auto-generated method stub
			return pic.getFile_name();
		}

		@Override
		public byte[] setByteDate() {
			// TODO Auto-generated method stub
						
			
			return pic.getBin_data();
		}
		   @Action(value="get_pic", results = { @Result(name = "success", type = "stream", params = {  
		 	        "contentType", "${content_type}",  
		 	        "inputName", "inputStream", "contentDisposition",  
		 	        "attachment;filename=\"${file_name}\"", "bufferSize",  
		 	        "4096"  }) })  
		@Override
		public String execute_download() {
			// TODO Auto-generated method stub
			   Session session = HibernateSessionFactory.getSession();
		         try {   
		        	 gov.cqaudit.finance.hibernate.dao.VPictureDAO vpdao=new gov.cqaudit.finance.hibernate.dao.VPictureDAO();
		        	 pic=vpdao.getEntityByUuid(session, uuid);
		        	 
		        	 
			             

		         } catch (HibernateException e) {   
			             e.printStackTrace();   
			         }  
		         finally {
						HibernateSessionFactory.closeSession();
					}
			return SUCCESS;
		}
		   gov.cqaudit.finance.bills.model.Picture pic;

		@Override
		public String setContentType() {
			// TODO Auto-generated method stub
			
			
			return pic.getContent_type();
		}  
}