package service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("bean2")
public class Bean2 {
    //ȡ������xml�ļ���bean���Ը�ֵ������ʹ�û�ȡ����@Value("${bean2_property}")��new��xml�ļ��еĸ�ֵ������@valueʧЧ
    @Value("${bean2_property}")
    private String bean2_property;

    public String getBean2_property() {
        return bean2_property;
    }
    public void  setBean2_property(String bean2_property){
        this.bean2_property = bean2_property;
    }
}


