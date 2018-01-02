package gov.cqaudit.finance.datatrans.upload_reslut;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.dom4j.Document;
import org.dom4j.Element;
import org.hibernate.Session;

public final class XmlDataTools {
	public static java.util.ArrayList<XmlDataToolsResult> decode(Session session,Document doc,String decode_user_id){
		java.util.ArrayList<XmlDataToolsResult> rs=new java.util.ArrayList<>();
		Element root = doc.getRootElement();
		Element head=root.element("Head");
		String trans_uuid=head.attributeValue("trans_id");
		String op_dat=head.attributeValue("op_dat");
		java.util.Date op_dat_dat=com.cqqyd2014.util.DateUtil.FullStringToJDate(op_dat);
		//更新trans_m信息
		gov.cqaudit.finance.datatrans.model.DataTransM dtm=gov.cqaudit.finance.datatrans.logic.DataTransMLogic.getModelFromView(gov.cqaudit.finance.hibernate.dao.VDataTransMDAO.getViewArrayListByTransId(session, trans_uuid));
		dtm.setUpload_user_id(decode_user_id);
		java.util.Date now=new java.util.Date();
		dtm.setBank_working_dat(op_dat_dat);
		dtm.setUpload_dat(now);
		gov.cqaudit.finance.datatrans.logic.DataTransMLogic.save(session, dtm);
		//更新查询单状态
		
		java.util.ArrayList<gov.cqaudit.finance.datatrans.model.DataTransD> dtds=gov.cqaudit.finance.datatrans.logic.DataTransDLogic.getArrayListModelFromArrayListView(gov.cqaudit.finance.hibernate.dao.VDataTransDDAO.getArrayListViewByTransUuid(session, trans_uuid));
		for (int i=0,len=dtds.size();i<len;i++){
			gov.cqaudit.finance.datatrans.model.DataTransD dtd=dtds.get(i);
			gov.cqaudit.finance.bills.model.BillM bm=gov.cqaudit.finance.bills.logic.BillMLogic.getModelFromView(gov.cqaudit.finance.hibernate.dao.VBillMDAO.getViewByUuid(session, dtd.getBill_uuid()));
			bm.setBill_status("结果返回");
			gov.cqaudit.finance.bills.logic.BillMLogic.save(session, bm);
		}
		//在session中保存本次导入的客户资料和分户账资料，以便统计对应查询单的结果
		
		//导入数据
		Element body=root.element("Body");
		@SuppressWarnings("unchecked")
		java.util.ArrayList<Element> bank_nodes=(java.util.ArrayList<Element>)body.elements();
		for (int i=0,bank_len=bank_nodes.size();i<bank_len;i++){
			//得到银行编码
			Element bank_node=bank_nodes.get(i);
			String bank_code=bank_node.attributeValue("bank_code");
			
			@SuppressWarnings("unchecked")
			java.util.ArrayList<Element> table_nodes=(java.util.ArrayList<Element>)bank_node.elements();
			for (int j=0,table_len=table_nodes.size();j<table_len;j++){
				Element table_node=table_nodes.get(j);
				String table_code=table_node.attributeValue("table_code");
				gov.cqaudit.finance.hibernate.entities.CatalogTable ct=gov.cqaudit.finance.hibernate.dao.CatalogTableDAO.getEntityByTableCpde(session, table_code);
				Class<?> threadClazz = null;
				try {
					threadClazz = Class.forName("gov.cqaudit.finance.datatrans.upload_reslut.XmlDataTools");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				Method method = null;
				try {
					method = threadClazz.getDeclaredMethod(ct.getTableEName(), Session.class,Element.class,String.class);
				} catch (NoSuchMethodException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				try {
					java.math.BigDecimal back_count=(java.math.BigDecimal)(method.invoke(null, session,table_node,bank_code));
					XmlDataToolsResult r=new XmlDataToolsResult();
					r.setBank_code(bank_code);
					r.setRows_count(back_count);
					r.setTable_code(table_code);
					r.setTable_name(ct.getTableEName());
					rs.add(r);
					
					//保存到数据库
					gov.cqaudit.finance.datatrans.model.DataTransBack db=new gov.cqaudit.finance.datatrans.model.DataTransBack();
					db.setBank_code(table_code);
					db.setRows_count(back_count);
					db.setTable_code(table_code);
					db.setTrans_uuid(trans_uuid);
					gov.cqaudit.finance.datatrans.logic.DataTransBackLogic.save(session, db);
					session.flush();
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				
				
				
			}
			
			
			
			
		}
		
		
		
		
		
		
		
		
		return rs;
		
		
		
		//生成每个查询单明细与客户基本信息表，分户账，流水的关联map<>
	}
	//解析对公客户基本信息表
	@SuppressWarnings("unused")
	private static java.math.BigDecimal data_core_public_custom_base(Session session,Element e,String bank_code){
		
		@SuppressWarnings("unchecked")
		java.util.ArrayList<Element> rows=(java.util.ArrayList<Element>)e.elements();
		int flag=0;
		for (int i=0,row_len=rows.size();i<row_len;i++){
			Element row=rows.get(i);
			//处理记录
			gov.cqaudit.finance.database.model.DataCorePublicCustomBase m=new gov.cqaudit.finance.database.model.DataCorePublicCustomBase();
			m.setBank_code(bank_code);
			m.setPublic_business(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Cust_ScopeBus")));
			m.setPublic_custom_id(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Cust_No")));
			m.setPublic_custom_name(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Cust_Name")));
			m.setPublic_id_card(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Cust_IdCard")));
			m.setPublic_law_man_id_card(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Cust_LegalIdCard")));
			m.setPublic_law_man_name(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Cust_LegalName")));
			m.setPublic_reg_capital(com.cqqyd2014.util.StringUtil.cleanToDec(row.attributeValue("Pub_Cust_RegCap")));
			gov.cqaudit.finance.hibernate.dao.VDataCorePublicCustomBaseDAO vdao=new gov.cqaudit.finance.hibernate.dao.VDataCorePublicCustomBaseDAO();
			vdao.save(session, m);
			flag++;
		}
		return new java.math.BigDecimal(flag);
	}
	//解析对公客户分户账表
	@SuppressWarnings("unused")
	private static java.math.BigDecimal data_core_public_account_info(Session session,Element e,String bank_code){
		@SuppressWarnings("unchecked")
		java.util.ArrayList<Element> rows=(java.util.ArrayList<Element>)e.elements();
		int flag=0;
		for (int i=0,row_len=rows.size();i<row_len;i++){
			Element row=rows.get(i);
			//处理记录
			gov.cqaudit.finance.database.model.DataCorePublicAccountInfo m=new gov.cqaudit.finance.database.model.DataCorePublicAccountInfo();
			m.setBank_code(bank_code);
			m.setPublic_account_id(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Leg_AcctNo")));
			m.setPublic_account_name(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Leg_AcctName")));
			m.setPublic_account_stauts(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Leg_AcctStatus")));
			m.setPublic_open_dat(com.cqqyd2014.util.StringUtil.cleanToDate(row.attributeValue("Pub_Leg_OpenDate")+" 00:00:00"));
			
			m.setPublic_custom_id(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Leg_CustNo")));
			m.setPublic_close_dat(com.cqqyd2014.util.StringUtil.cleanToDate(row.attributeValue("Pub_Leg_CancelDate")+" 00:00:00"));
			
			gov.cqaudit.finance.hibernate.dao.VDataCorePublicAccountInfoDAO vdao=new gov.cqaudit.finance.hibernate.dao.VDataCorePublicAccountInfoDAO();
			vdao.save(session, m);
			flag++;
		}
		return new java.math.BigDecimal(flag);
		}
		//解析对公客户明细账
		public static java.math.BigDecimal data_core_public_account_trade_detail(Session session,Element e,String bank_code){
		@SuppressWarnings("unchecked")
		java.util.ArrayList<Element> rows=(java.util.ArrayList<Element>)e.elements();
		int flag=0;
		for (int i=0,row_len=rows.size();i<row_len;i++){
			Element row=rows.get(i);
			//处理记录
			gov.cqaudit.finance.database.model.DataCorePublicAccountTradeDetail m=new gov.cqaudit.finance.database.model.DataCorePublicAccountTradeDetail();
			m.setBank_code(bank_code);
			m.setPublic_account_id(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Det_AcctNo")));
			m.setPublic_account_name(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Det_AcctName")));
			m.setPublic_amount(com.cqqyd2014.util.StringUtil.cleanToDec(row.attributeValue("Pub_Det_TransAmt")));
			m.setPublic_balance(com.cqqyd2014.util.StringUtil.cleanToDec(row.attributeValue("Pub_Det_AcctBalance")));
			m.setPublic_bank_org_id(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Det_TransOrgNo")));
			m.setPublic_bank_org_name(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Det_TransOrgName")));
			m.setPublic_op_account_id(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Det_OthAcctNo")));
			m.setPublic_op_account_name(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Det_OthAcctName")));
			m.setPublic_op_bank_id(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Det_OthOrgNo")));
			m.setPublic_op_bank_name(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Det_OthOrgName")));
			m.setPublic_remark(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Det_Remark")));
			m.setPublic_trade_code(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Det_TransCode")));
			m.setPublic_trade_name(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Det_TransName")));
			m.setPublic_trade_dat(com.cqqyd2014.util.StringUtil.cleanToDate(row.attributeValue("Pub_Det_TransDate")+" "+row.attributeValue("Pub_Det_TransTime")));
			m.setPublic_trade_seq(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pub_Det_TransNo")));
			
			gov.cqaudit.finance.hibernate.dao.VDataCorePublicAccountTradeDetailDAO vdao=new gov.cqaudit.finance.hibernate.dao.VDataCorePublicAccountTradeDetailDAO();
			vdao.save(session, m);
			flag++;
		}
		return new java.math.BigDecimal(flag);
	}
		//解析对私基本信息表
		@SuppressWarnings("unused")
		private static java.math.BigDecimal data_core_private_custom_base(Session session,Element e,String bank_code){
			@SuppressWarnings("unchecked")
			java.util.ArrayList<Element> rows=(java.util.ArrayList<Element>)e.elements();
			int flag=0;
			for (int i=0,row_len=rows.size();i<row_len;i++){
				Element row=rows.get(i);
				//处理记录
				gov.cqaudit.finance.database.model.DataCorePrivateCustomBase m=new gov.cqaudit.finance.database.model.DataCorePrivateCustomBase();
				m.setBank_code(bank_code);
				m.setPrivate_company(row.attributeValue("Pri_Cust_WorkUnit"));
				m.setPrivate_custom_id(row.attributeValue("Pri_Cust_No"));
				m.setPrivate_custom_name(row.attributeValue("Pri_Cust_Name"));
				m.setPrivate_id_card(row.attributeValue("Pri_Cust_IdCardNo"));
				m.setPrivate_post_address(row.attributeValue("Pri_Cust_PostAddr"));
				m.setPrivate_work_address(row.attributeValue("Pri_Cust_WorkAddr"));
				gov.cqaudit.finance.hibernate.dao.VDataCorePrivateCustomBaseDAO vdao=new gov.cqaudit.finance.hibernate.dao.VDataCorePrivateCustomBaseDAO();
				vdao.save(session, m);
				flag++;
			}
			return new java.math.BigDecimal(flag);
		}
		//解析对私分户账
		@SuppressWarnings("unused")
		private static java.math.BigDecimal data_core_private_account_info(Session session,Element e,String bank_code){
			@SuppressWarnings("unchecked")
			java.util.ArrayList<Element> rows=(java.util.ArrayList<Element>)e.elements();
			int flag=0;
			for (int i=0,row_len=rows.size();i<row_len;i++){
				Element row=rows.get(i);
				//处理记录
				gov.cqaudit.finance.database.model.DataCorePrivateAccountInfo m=new gov.cqaudit.finance.database.model.DataCorePrivateAccountInfo();
				m.setBank_code(bank_code);
				m.setPrivate_account_id(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pri_Leg_AcctNo")));
				m.setPrivate_account_name(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pri_Leg_AcctName")));
				m.setPrivate_account_stauts(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pri_Leg_AcctStatus")));
				m.setPrivate_open_dat(com.cqqyd2014.util.StringUtil.cleanToDate(row.attributeValue("Pri_Leg_OpenDate")+" 00:00:00"));
				m.setPrivate_card_no(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pri_Leg_CardNo")));
				m.setPrivate_custom_id(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pri_Leg_CustNo")));
				m.setPrivate_close_dat(com.cqqyd2014.util.StringUtil.cleanToDate(row.attributeValue("Pri_Leg_CancelDate")+" 00:00:00"));
				
				gov.cqaudit.finance.hibernate.dao.VDataCorePrivateAccountInfoDAO vdao=new gov.cqaudit.finance.hibernate.dao.VDataCorePrivateAccountInfoDAO();
				vdao.save(session, m);
				flag++;
			}
			return new java.math.BigDecimal(flag);
		}
		//解析对私明细账
		@SuppressWarnings("unused")
		private static java.math.BigDecimal data_core_private_account_trade_detail(Session session,Element e,String bank_code){
			@SuppressWarnings("unchecked")
			java.util.ArrayList<Element> rows=(java.util.ArrayList<Element>)e.elements();
			int flag=0;
			for (int i=0,row_len=rows.size();i<row_len;i++){
				Element row=rows.get(i);
				//处理记录
				gov.cqaudit.finance.database.model.DataCorePrivateAccountTradeDetail m=new gov.cqaudit.finance.database.model.DataCorePrivateAccountTradeDetail();
				m.setBank_code(bank_code);
				m.setPrivate_account_id(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pri_Det_AcctNo")));
				m.setPrivate_account_name(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pri_Det_AcctName")));
				m.setPrivate_amount(com.cqqyd2014.util.StringUtil.cleanToDec(row.attributeValue("Pri_Det_TransAmt")));
				m.setPrivate_balance(com.cqqyd2014.util.StringUtil.cleanToDec(row.attributeValue("Pri_Det_AcctBalance")));
				m.setPrivate_bank_org_id(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pri_Det_TransOrgNo")));
				m.setPrivate_bank_org_name(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pri_Det_TransOrgName")));
				m.setPrivate_op_account_id(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pri_Det_OthAcctNo")));
				m.setPrivate_op_account_name(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pri_Det_OthAcctName")));
				m.setPrivate_op_bank_id(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pri_Det_OthOrgNo")));
				m.setPrivate_op_bank_name(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pri_Det_OthOrgName")));
				m.setPrivate_remark(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pri_Det_Remark")));
				m.setPrivate_trade_code(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pri_Det_TransCode")));
				m.setPrivate_trade_name(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pri_Det_TransName")));
				/*
				System.out.println("---------");
				System.out.println(row.attributeValue("Pri_Det_TransDate")+" "+row.attributeValue("Pri_Det_TransTime"));
				System.out.println(com.cqqyd2014.util.StringUtil.cleanToDate(row.attributeValue("Pri_Det_TransDate")+" "+row.attributeValue("Pri_Det_TransTime")));
				*/
				m.setPrivate_trade_dat(com.cqqyd2014.util.StringUtil.cleanToDate(row.attributeValue("Pri_Det_TransDate")+" "+row.attributeValue("Pri_Det_TransTime")));
				
				m.setPrivate_trade_seq(com.cqqyd2014.util.StringUtil.cleanToString(row.attributeValue("Pri_Det_TransNo")));
				
				gov.cqaudit.finance.hibernate.dao.VDataCorePrivateAccountTradeDetailDAO vdao=new gov.cqaudit.finance.hibernate.dao.VDataCorePrivateAccountTradeDetailDAO();
				vdao.save(session, m);
				flag++;
			}
			return new java.math.BigDecimal(flag);
		}

}
