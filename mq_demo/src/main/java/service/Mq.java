package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

public class Mq {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:\\applicationContext.xml"});
        DefaultMessageListenerContainer bean = (DefaultMessageListenerContainer) context.getBean("flightDynamicJmsContainer");
        bean.start();
    }
}
