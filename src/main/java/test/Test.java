package test;




import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;



@ComponentScan

public class Test {
	
	


  public static void main(String[] args) {
	  ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext-database.xml");
	  MessagePrinter mp=(MessagePrinter) ctx.getBean("messagePrinter");
	  mp.printMessage();
	  System.out.println(mp.billMDAOPostgresql.getAbb());
	  System.out.println(com.cqqyd2014.util.StringUtil.getUUID());
	  System.out.println(new java.math.BigDecimal("dsfsdfsd"));
  }

}
