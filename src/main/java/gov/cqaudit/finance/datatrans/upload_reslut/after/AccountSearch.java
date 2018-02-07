package gov.cqaudit.finance.datatrans.upload_reslut.after;

import org.hibernate.Session;

public final class AccountSearch {
	public  static void afterToDo(Session session,String trans_uuid){
        java.util.ArrayList<gov.cqaudit.finance.datatrans.model.DataTransD> dtds=gov.cqaudit.finance.datatrans.logic.DataTransDLogic.getArrayListModelFromArrayListView(gov.cqaudit.finance.hibernate.dao.VDataTransDDAO.getArrayListViewByTransUuid(session, trans_uuid));
        gov.cqaudit.finance.hibernate.dao.VBillDDAO vbddao=new gov.cqaudit.finance.hibernate.dao.VBillDDAO();
        
        for (int j=0,len=dtds.size();j<len;j++){
        	gov.cqaudit.finance.datatrans.model.DataTransD dtd=dtds.get(j);
        	String bill_uuid=dtd.getBill_uuid();
        	//得到查询单明细
        	java.util.ArrayList<gov.cqaudit.finance.bills.model.BillD> bds=vbddao.getArrayListModelByBillUuid(session, bill_uuid);
        	for (int k=0,len2=bds.size();k<len2;k++){
        		gov.cqaudit.finance.bills.model.BillD bd=bds.get(k);
        		String detail_uuid=bd.getDetail_uuid();
        		String bank_code=bd.getBank_code();
        		String search_par_code=bd.getSearch_par_code();
        		gov.cqaudit.finance.hibernate.dao.VDataCorePublicAccountInfoDAO padao=new gov.cqaudit.finance.hibernate.dao.VDataCorePublicAccountInfoDAO();
    			gov.cqaudit.finance.hibernate.dao.VDataCorePublicAccountTradeDetailDAO patdao=new gov.cqaudit.finance.hibernate.dao.VDataCorePublicAccountTradeDetailDAO();
        		gov.cqaudit.finance.hibernate.dao.VDataCorePrivateAccountInfoDAO prdao=new gov.cqaudit.finance.hibernate.dao.VDataCorePrivateAccountInfoDAO();
        		gov.cqaudit.finance.hibernate.dao.VDataCorePrivateAccountTradeDetailDAO prtdao=new gov.cqaudit.finance.hibernate.dao.VDataCorePrivateAccountTradeDetailDAO();
        		
        		
    			switch(search_par_code)
        		{
        		case "0001":
        		 //企业名称查询
        			gov.cqaudit.finance.hibernate.dao.VDataCorePublicCustomBaseDAO pcbdao=new gov.cqaudit.finance.hibernate.dao.VDataCorePublicCustomBaseDAO();
        			java.util.ArrayList<gov.cqaudit.finance.database.model.DataCorePublicCustomBase> pcbs=pcbdao.getArrayListViewByHqlSql(session, "from VDataCorePublicCustomBase where id.publicCustomName=\'"+bd.getSearch_par_value()+"\' and id.bankCode=\'"+bank_code+"\'");
        			
        			for (int i=0,len1=pcbs.size();i<len1;i++){
        				gov.cqaudit.finance.database.model.DataCorePublicCustomBase pcb=pcbs.get(i);
        				System.out.println(pcb.getPublic_custom_id());
        				java.util.ArrayList<gov.cqaudit.finance.database.model.DataCorePublicAccountInfo> pas=padao.getArrayListViewByHqlSql(session, 
        						"from VDataCorePublicAccountInfo where id.publicCustomId=\'"+pcb.getPublic_custom_id()+"\' and id.bankCode=\'"+pcb.getBank_code()+"\'");
        				//明细记录
        				for (int ii=0,len3=pas.size();ii<len3;ii++){
        					gov.cqaudit.finance.database.model.DataCorePublicAccountInfo pa=pas.get(ii);
        					String count=patdao.getCountByHqlSql(session, "select count(*) from VDataCorePublicAccountTradeDetail where id.bankCode=\'"+pcb.getBank_code()
        					+"\' and id.publicAccountId='"+pa.getPublic_account_id()+"\' and id.publicTradeDat between \'"+com.cqqyd2014.util.DateUtil.getPrintFullString(bd.getStart_dat())+
        					"\' and \'"+com.cqqyd2014.util.DateUtil.getPrintFullString(bd.getEnd_dat())+"\'");
        					gov.cqaudit.finance.hibernate.entities.BillDBack bdb=new gov.cqaudit.finance.hibernate.entities.BillDBack();
        					bdb.setAccountName(pa.getPublic_account_name());
        					bdb.setCustomId(pcb.getPublic_custom_id());
        					bdb.setDetailCount(new java.math.BigDecimal(count));
        					bdb.setId(new gov.cqaudit.finance.hibernate.entities.BillDBackId(bd.getBill_uuid(), bd.getDetail_uuid(), pa.getPublic_account_id()));
        					session.merge(bdb);
        					
        				}
        				
        				
        			}
        			
        			
        			
        			
        		  break;
        		case "0002":
        		  //企业账号查询
        			java.util.ArrayList<gov.cqaudit.finance.database.model.DataCorePublicAccountInfo> pas=padao.getArrayListViewByHqlSql(session,
        					"from VDataCorePublicAccountInfo where id.publicCustomId=\'"+bd.getSearch_par_value()+"\' and id.bankCode=\'"+bd.getBank_code()+"\'");
        			if (pas.size()==1){
        				gov.cqaudit.finance.database.model.DataCorePublicAccountInfo pa=pas.get(0);
        				String count=patdao.getCountByHqlSql(session, "select count(*) from VDataCorePublicAccountTradeDetail where id.bankCode=\'"+bd.getBank_code()
    					+"\' and id.publicAccountId='"+bd.getSearch_par_value()+"\' and id.publicTradeDat between \'"+com.cqqyd2014.util.DateUtil.getPrintFullString(bd.getStart_dat())+
    					"\' and \'"+com.cqqyd2014.util.DateUtil.getPrintFullString(bd.getEnd_dat())+"\'");
    					gov.cqaudit.finance.hibernate.entities.BillDBack bdb=new gov.cqaudit.finance.hibernate.entities.BillDBack();
    					bdb.setAccountName(pa.getPublic_account_name());
    					bdb.setCustomId(pa.getPublic_custom_id());
    					bdb.setDetailCount(new java.math.BigDecimal(count));
    					bdb.setId(new gov.cqaudit.finance.hibernate.entities.BillDBackId(bd.getBill_uuid(), bd.getDetail_uuid(), pa.getPublic_account_id()));
    					session.merge(bdb);
        			}
        			
        		  break;
        		case "0003":
        			//个人卡号查询
        			java.util.ArrayList<gov.cqaudit.finance.database.model.DataCorePrivateAccountInfo> prs=prdao.getArrayListViewByHqlSql(session, "from VDataCorePrivateAccountInfo where id.privateCardNo=\'"+bd.getSearch_par_value()+"\' and id.bankCode=\'"+bd.getBank_code()+"\'");
        			for (int i=0,len1=prs.size();i<len1;i++){
        				gov.cqaudit.finance.database.model.DataCorePrivateAccountInfo pr=prs.get(i);
        				String count=prtdao.getCountByHqlSql(session, "select count(*) from VDataCorePrivateAccountTradeDetail where id.bankCode=\'"+bd.getBank_code()
    					+"\' and id.privateAccountId='"+bd.getSearch_par_value()+"\' and id.privateTradeDat between \'"+com.cqqyd2014.util.DateUtil.getPrintFullString(bd.getStart_dat())+
    					"\' and \'"+com.cqqyd2014.util.DateUtil.getPrintFullString(bd.getEnd_dat())+"\'");
    					gov.cqaudit.finance.hibernate.entities.BillDBack bdb=new gov.cqaudit.finance.hibernate.entities.BillDBack();
    					bdb.setAccountName(pr.getPrivate_account_name());
    					bdb.setCustomId(pr.getPrivate_custom_id());
    					bdb.setDetailCount(new java.math.BigDecimal(count));
    					bdb.setId(new gov.cqaudit.finance.hibernate.entities.BillDBackId(bd.getBill_uuid(), bd.getDetail_uuid(), bd.getSearch_par_value()));
    					session.merge(bdb);
        			}
        			
        			
        			
        			break;
        		case "0004":
        			//个人身份证号查询
        			
        			
        			gov.cqaudit.finance.hibernate.dao.VDataCorePrivateCustomBaseDAO prbdao=new gov.cqaudit.finance.hibernate.dao.VDataCorePrivateCustomBaseDAO();
        			java.util.ArrayList<gov.cqaudit.finance.database.model.DataCorePrivateCustomBase> prbs=prbdao.getArrayListViewByHqlSql(session, "from VDataCorePrivateCustomBase where id.privateIdCard=\'"+bd.getSearch_par_value()+"\' and id.bankCode=\'"+bd.getBank_code()+"\'");
        			for (int iii=0,len3=prbs.size();iii<len3;iii++){
        				gov.cqaudit.finance.database.model.DataCorePrivateCustomBase prb=prbs.get(iii);
        				
        				java.util.ArrayList<gov.cqaudit.finance.database.model.DataCorePrivateAccountInfo> prss=prdao.getArrayListViewByHqlSql(session, "from VDataCorePrivateAccountInfo where id.privateCustomId=\'"+prb.getPrivate_custom_id()+"\' and id.bankCode=\'"+bd.getBank_code()+"\'");
            			for (int i=0,len1=prss.size();i<len1;i++){
            				gov.cqaudit.finance.database.model.DataCorePrivateAccountInfo pr=prss.get(i);
            				String count=prtdao.getCountByHqlSql(session, "select count(*) from VDataCorePrivateAccountTradeDetail where id.bankCode=\'"+bd.getBank_code()
        					+"\' and id.privateAccountId='"+pr.getPrivate_account_id()+"\' and id.privateTradeDat between \'"+com.cqqyd2014.util.DateUtil.getPrintFullString(bd.getStart_dat())+
        					"\' and \'"+com.cqqyd2014.util.DateUtil.getPrintFullString(bd.getEnd_dat())+"\'");
        					gov.cqaudit.finance.hibernate.entities.BillDBack bdb=new gov.cqaudit.finance.hibernate.entities.BillDBack();
        					bdb.setAccountName(pr.getPrivate_account_name());
        					bdb.setCustomId(pr.getPrivate_custom_id());
        					bdb.setDetailCount(new java.math.BigDecimal(count));
        					bdb.setId(new gov.cqaudit.finance.hibernate.entities.BillDBackId(bd.getBill_uuid(), bd.getDetail_uuid(), bd.getSearch_par_value()));
        					session.merge(bdb);
            			}
        				
        				
        			}
        			
        			
        			
        			break;
        		default:
        		  System.out.println("未知的查询类型"+search_par_code);
        		}
        		
        	}
        }
		
	}

}
