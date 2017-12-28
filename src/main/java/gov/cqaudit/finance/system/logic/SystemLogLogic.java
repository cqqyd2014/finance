package gov.cqaudit.finance.system.logic;

import org.hibernate.Session;

public class SystemLogLogic {
	public static void save_log(Session session,gov.cqaudit.finance.system.model.SystemLog log) {
		gov.cqaudit.finance.hibernate.entities.SysLog log_h=new gov.cqaudit.finance.hibernate.entities.SysLog();
		log_h.setActionTime(log.getAction_time());
		log_h.setLogMsg(log.getLog_msg());
		log_h.setLogType(log.getLog_type());
		log_h.setUserId(log.getUser_id());
		log_h.setUuid(log.getUuid());
		
		session.save(log_h);
	}

}
