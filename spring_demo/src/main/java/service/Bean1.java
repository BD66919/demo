package service;

import org.springframework.stereotype.Service;

@Service("bean1")
public class Bean1 {
    private String bean1_property1;
    private String bean1_property2;
    private Bean2 bean2;


    public String getBean1_property() {
        return "“¿¿µ◊¢»Î∑√Œ "+bean1_property1+"“¿¿µ◊¢»Î∑√Œ " + bean1_property2 + "bean2"+bean2.getBean2_property();
    }

    public void setProperty1(String bean1_property1) {
        this.bean1_property1 = bean1_property1;
    }
    public void setProperty2(String bean1_property2){
        this.bean1_property2 = bean1_property2;
    }

    public  void setBean2(Bean2 bean2){
        this.bean2 = bean2;
    }
}