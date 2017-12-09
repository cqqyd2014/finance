package gov.cqaudit.finance.common.jasper_data_factory;

import java.util.ArrayList;

public class BillFactory {
	public static ArrayList<gov.cqaudit.finance.bills.model.BillM> getBeanCollection(){
        ArrayList<gov.cqaudit.finance.bills.model.BillM> dataList=new ArrayList<>();
         dataList.add(new gov.cqaudit.finance.bills.model.BillM());
         
     return dataList;
 }

}
