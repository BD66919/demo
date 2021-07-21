import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Book implements Serializable {
    //序列化类：java.ioObjectOutputStream讲对象变为指定的二进制数据
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
//        //第一种：使用keySet()方法遍历哈希表hashMap中的一些元素
//        System.out.println("通过keySet()方法遍历key和value：");
//        Set<String> keys = hashMap.keySet();
//        for (String key : keys) {
//            String value= hashMap.get(key);
//            System.out.println("BookName："+ key + " ,BookPrice：" + value);
//        }
//
        return "BookName："+this.title+" ,BookPrice："+this.price;
    }
}