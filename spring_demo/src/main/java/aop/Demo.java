package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("aop");
        Entity entity = (Entity) applicationContext.getBean("entity");
        entity.methodTest();
        entity.annotateTest();
    }
}
