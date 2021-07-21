import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Book implements Serializable {
    //���л��ࣺjava.ioObjectOutputStream�������Ϊָ���Ķ���������
    private static final long serialVersionUID = 1L;
    @JSONField
    private String title;
    @JSONField
    private double price;
    public Book(String tit,double pri){
        this.title=tit;
        this.price=pri;
    }

    public  Book(){

    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title =title;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(Double price){
        this.price =price;
    }

    public String toString() {        Map<String, String> hashMap = new HashMap<String, String>();
//        hashMap.put("Computer base", "6.2");
//        hashMap.put("Computer webpage",  "45.2");
//        hashMap.put("Java", "105.2");
//        hashMap.put("Andriod", "89.2");
//
//        //��һ�֣�ʹ��keySet()����������ϣ��hashMap�е�һЩԪ��
//        System.out.println("ͨ��keySet()��������key��value��");
//        Set<String> keys = hashMap.keySet();
//        for (String key : keys) {
//            String value= hashMap.get(key);
//            System.out.println("BookName��"+ key + " ,BookPrice��" + value);
//        }
//
        return "BookName��"+this.title+" ,BookPrice��"+this.price;
    }
}