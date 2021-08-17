package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("aop");
        Entity entity = (Entity) applicationContext.getBean("entity");
        entity.methodTest();
        entity.annotateTest();
        String[] s = {"ABCD","ABCDE"};
        List<String> stringList = new ArrayList<>();
        stringList.add("ABCD");
        stringList.add("ABCDE");
        
        stringList.forEach(object-> System.out.println(object.length()));
    }
}
