package aop;

import org.springframework.stereotype.Service;

@Service
public class Entity {
    @Action(name = "action value")
    public void annotateTest(){
        System.out.println("annotateTest");
    }

    public void methodTest(){
        System.out.println("methodTest");
    }
}
