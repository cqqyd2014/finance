package gov.cqaudit.finance.bills.my_bill.ajax.action;

import com.cqqyd2014.annotation.Authority;
import com.cqqyd2014.util.AjaxSuccessMessage;
import gov.cqaudit.finance.bills.model.BillDBack;
import gov.cqaudit.finance.common.LoginedAjaxAction;
import gov.cqaudit.finance.hibernate.HibernateSessionFactory;
import gov.cqaudit.finance.hibernate.dao.VBillDBackDAO;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

@ParentPackage("bfkjs-json-default")
@Namespace("/bills")
public class GetSearchResultAction
  extends LoginedAjaxAction
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 4735612752837017836L;
String bill_uuid;
  
  public String getBill_uuid()
  {
    return this.bill_uuid;
  }
  
  public void setBill_uuid(String bill_uuid)
  {
    this.bill_uuid = bill_uuid;
  }
  
  @Action(value="get_search_result", results={@org.apache.struts2.convention.annotation.Result(type="json", params={"root", "msg"})}, interceptorRefs={@org.apache.struts2.convention.annotation.InterceptorRef("authorityStack")})
  @Authority(module="get_search_result", privilege="[00010002]", error_url="authority_ajax_error")
  public String execute()
  {
    super.execute();
    this.sm.setAuth_success(true);
    
    this.session = HibernateSessionFactory.getSession();
    try
    {
      VBillDBackDAO vbdao = new VBillDBackDAO();
      ArrayList<BillDBack> bds = vbdao.getArrayListModelByBillUuid(this.session, this.bill_uuid);
      this.msg = new HashMap();
      this.msg.put("total", String.valueOf(bds.size()));
      this.msg.put("rows", bds);
      

      this.sm.setSuccess(true);
      this.sm.setO(bds);
    }
    catch (HibernateException e)
    {
      if (null != this.tx) {
        this.tx.rollback();
      }
      this.sm.setSuccess(false);
      this.sm.setBody(e.toString());
      
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
    finally
    {
      HibernateSessionFactory.closeSession();
    }
    return "success";
  }
}
