
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import service.Bean1;
import service.Bean2;

/**
 * Hello world!
 *
 */
public class Run
{
    public static void main( String[] args )  {

        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });

        Bean1 bean1 = (Bean1) context.getBean("bean1");
        Bean2 bean2 = (Bean2) context.getBean("bean2");

        Bean2 bean2_test = new Bean2();
        System.out.println(bean2_test.getBean2_property());
        System.out.println(bean1.getBean1_property());
        System.out.println(bean2.getBean2_property());
    }
}