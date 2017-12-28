package gov.cqaudit.finance.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public final class VBillMDAO {
	
	//订单数量的查询
	
		public static java.math.BigInteger getBillUuidsCount(Session session, String bill_status,
				String contract_name, String pro_name, String create_user_id){
			String hql="select count(*) from ( select bill_uuid from v_bill_m where       ";

			
			if (create_user_id!=null&&!create_user_id.equals("")){
				hql=hql+" create_user_id=\'"+create_user_id+"\' and";
			}
			if (bill_status!=null&&!bill_status.equals("")){
				hql=hql+" bill_status=\'"+bill_status+"\' and";
			}
			if (contract_name!=null&&!contract_name.equals("")){
				hql=hql+" and  contract_name like \'%"+contract_name+"%\' and";
			}
			if (pro_name!=null&&!pro_name.equals("")){
				hql=hql+" pro_name like \'%"+pro_name+"%\' and";
			}
			hql=hql.substring(0, hql.length()-3);
			hql=hql+" group by bill_uuid) t1";
			//System.out.println(hql);
			
			return (java.math.BigInteger)session.createSQLQuery(hql).uniqueResult();

			
		}
	
	public static java.util.ArrayList<String> getArrayListBillUuids(Session session, String rows, String page, String bill_status,
			String contract_name, String pro_name, String create_user_id){
		int currentPage=Integer.parseInt(page);
		int pageSize=Integer.parseInt(rows);
		
		//长一点方便 后面去除三个字母
		String hql="select id.billUuid from VBillM where       ";
		if (create_user_id!=null&&!create_user_id.equals("")){
			hql=hql+"id.createUserId=:create_user_id  and ";
		}
	
		if (bill_status!=null&&!bill_status.equals("")){
			hql=hql+"id.billStatus=:bill_status  and ";
		}
		if (contract_name!=null&&!contract_name.equals("")){
			hql=hql+"id.contractName like :contract_name  and ";
		}
		if (pro_name!=null&&!pro_name.equals("")){
			hql=hql+"id.proName like :pro_name  and ";
		}
		hql=hql+"id.effective=true ";
		hql=hql+ " group by id.billUuid,id.createDat order by id.createDat desc";
		//System.out.print(hql);
		int offset = pageSize * (currentPage - 1);
		
		Query q=session.createQuery(hql).setFirstResult(offset)
				.setMaxResults(pageSize);;
		
				if (create_user_id!=null&&!create_user_id.equals("")){
			q.setParameter("create_user_id", create_user_id);
		}
				if (bill_status!=null&&!bill_status.equals("")){
			q.setParameter("bill_status",bill_status);
		}
				if (contract_name!=null&&!contract_name.equals("")){
			q.setParameter("contract_name", "%"+contract_name+"%");
		}
		
		
				if (pro_name!=null&&!pro_name.equals("")){
			q.setParameter("pro_name", "%"+pro_name+"%");
		}
		
		
		
		java.util.ArrayList<String> voms=(java.util.ArrayList<String>)q.list();
		
		return voms;
		
	}
	
	
	
	
	public static java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBillM> getArrayListViewArrayListBillUuid(Session session,java.util.ArrayList<String> bill_uuids){
		
		String bill_uuids_array=com.cqqyd2014.util.StringUtil.arrayListToSQLInString(bill_uuids);
		
		String hql = "from VBillM where id.effective=true and id.billUuid in "+bill_uuids_array;

		Query q = session.createQuery(hql);
		

		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBillM> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBillM>) q
				.list();
		return sws;
	}
	
	
	public static gov.cqaudit.finance.hibernate.entities.VBillM  getViewByUuid(Session session,String uuid){
		String hql = "from VBillM where id.effective=true and id.billUuid=:uuid";

		Query q = session.createQuery(hql);
		q.setParameter("uuid", uuid);

		@SuppressWarnings("unchecked")
		java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBillM> sws = (java.util.ArrayList<gov.cqaudit.finance.hibernate.entities.VBillM>) q
				.list();
		if (sws.size() == 0) {
			System.out.println("不能得到查询单数据，参数uuid:" + uuid);
			return null;
		} else {
			return sws.get(0);
		}
	}
}
