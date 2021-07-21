package service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("bean2")
public class Bean2 {
    //取消配置xml文件中bean属性赋值，即可使用获取到的@Value("${bean2_property}")，new和xml文件中的赋值都会让@value失效
    @Value("${bean2_property}")
    private String bean2_property;

    public String getBean2_property() {
        return bean2_property;
    }
    public void  setBean2_property(String bean2_property){
        this.bean2_property = bean2_property;
    }
}


