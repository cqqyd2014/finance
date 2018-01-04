package gov.cqaudit.finance.datatrans.upload_reslut.after;

import org.hibernate.Session;

public final class AccountSearch {
	public  static void afterToDo(Session session,String trans_uuid){
        java.util.ArrayList<gov.cqaudit.finance.datatrans.model.DataTransD> dtds=gov.cqaudit.finance.datatrans.logic.DataTransDLogic.getArrayListModelFromArrayListView(gov.cqaudit.finance.hibernate.dao.VDataTransDDAO.getArrayListViewByTransUuid(session, trans_uuid));
        for (int j=0,len=dtds.size();j<len;j++){
        	gov.cqaudit.finance.datatrans.model.DataTransD dtd=dtds.get(j);
        	String bill_uuid=dtd.getBill_uuid();
        	//得到查询单明细
        	java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD> bds=gov.cqaudit.finance.bills.logic.BillDLogic.getArrayListFromArrayListView(gov.cqaudit.finance.hibernate.dao.VBillDDAO.getArrayListViewByBillUuid(session, bill_uuid));
        	for (int k=0,len2=bds.size();k<len2;k++){
        		gov.cqaudit.finance.bills.model.BillD bd=bds.get(k);
        		String detail_uuid=bd.getDetail_uuid();
        		String bank_code=bd.getBank_code();
        		String search_par_code=bd.getSearch_par_code();
        		switch(search_par_code)
        		{
        		case "0001":
        		 //企业名称查询
        			java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSearchPublicCustomAccount> 
        			public_name_searchs=gov.cqaudit.finance.hibernate.dao.VSearchPublicCustomAccountDAO.getArrayListViewByCustomName(session, bd.getSearch_par_value(),bank_code);
        			
        			for (int l=0,len3=public_name_searchs.size();l<len3;l++){
        				gov.cqaudit.finance.hibernate.entities.VSearchPublicCustomAccount public_name_search=public_name_searchs.get(l);
        				gov.cqaudit.finance.hibernate.entities.BillDBack bdb=new gov.cqaudit.finance.hibernate.entities.BillDBack();
        				bdb.setDetailCount(new java.math.BigDecimal(public_name_search.getId().getDetailCount()));
        				bdb.setCustomId(public_name_search.getId().getPublicCustomId());
        				bdb.setId(new gov.cqaudit.finance.hibernate.entities.BillDBackId(bill_uuid, detail_uuid, public_name_search.getId().getPublicAccountId()));
        				bdb.setAccountName(public_name_search.getId().getPublicAccountName());
        				session.saveOrUpdate(bdb);
        			}
        			
        		  break;
        		case "0002":
        		  //企业账号查询
        			gov.cqaudit.finance.hibernate.entities.VSearchPublicCustomAccount public_account_search=gov.cqaudit.finance.hibernate.dao.VSearchPublicCustomAccountDAO.getViewByAccountId(session, bd.getSearch_par_value(), bank_code);
        			if (public_account_search!=null){
        				gov.cqaudit.finance.hibernate.entities.BillDBack bdb=new gov.cqaudit.finance.hibernate.entities.BillDBack();
        				bdb.setDetailCount(new java.math.BigDecimal(public_account_search.getId().getDetailCount()));
        				bdb.setCustomId(public_account_search.getId().getPublicCustomId());
        				bdb.setId(new gov.cqaudit.finance.hibernate.entities.BillDBackId(bill_uuid, detail_uuid, public_account_search.getId().getPublicAccountId()));
        				bdb.setAccountName(public_account_search.getId().getPublicAccountName());
        				session.saveOrUpdate(bdb);
        			}
        		  break;
        		case "0003":
        			//个人卡号查询
        			gov.cqaudit.finance.hibernate.entities.VSearchPrivateCustomAccount private_card_no_search=gov.cqaudit.finance.hibernate.dao.VSearchPrivateCustomAccountDAO.getViewByCardNo(session, bd.getSearch_par_value(), bank_code);
        			if (private_card_no_search!=null){
        				gov.cqaudit.finance.hibernate.entities.BillDBack bdb=new gov.cqaudit.finance.hibernate.entities.BillDBack();
        				bdb.setDetailCount(new java.math.BigDecimal(private_card_no_search.getId().getDetailCount()));
        				bdb.setCustomId(private_card_no_search.getId().getPrivateCustomId());
        				bdb.setAccountName(private_card_no_search.getId().getPrivateAccountName());
        				bdb.setId(new gov.cqaudit.finance.hibernate.entities.BillDBackId(bill_uuid, detail_uuid, private_card_no_search.getId().getPrivateAccountId()));
        				
        				session.saveOrUpdate(bdb);
        				
        			}
        			break;
        		case "0004":
        			//个人身份证号查询
        			java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VSearchPrivateCustomAccount> private_id_card_searchs=gov.cqaudit.finance.hibernate.dao.VSearchPrivateCustomAccountDAO.getArrayListViewByIdCard(session, bd.getSearch_par_value(), bank_code);

        			for (int l=0,len4=private_id_card_searchs.size();l<len4;l++){
        				gov.cqaudit.finance.hibernate.entities.VSearchPrivateCustomAccount private_id_card_search=private_id_card_searchs.get(l);
        				gov.cqaudit.finance.hibernate.entities.BillDBack bdb=new gov.cqaudit.finance.hibernate.entities.BillDBack();
        				bdb.setCustomId(private_id_card_search.getId().getPrivateCustomId());
        				bdb.setDetailCount(new java.math.BigDecimal(private_id_card_search.getId().getDetailCount()));
        				bdb.setId(new gov.cqaudit.finance.hibernate.entities.BillDBackId(bill_uuid, detail_uuid, private_id_card_search.getId().getPrivateAccountId()));
        				bdb.setAccountName(private_id_card_search.getId().getPrivateAccountName());
        				session.saveOrUpdate(bdb);
        			}
        			break;
        		default:
        		  System.out.println("未知的查询类型"+search_par_code);
        		}
        		
        	}
        }
		
	}

}
