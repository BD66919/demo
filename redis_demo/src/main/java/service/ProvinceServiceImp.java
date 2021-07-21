package service;



import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;


public class ProvinceServiceImp implements ProvinceService {

    @Override
    public List<String> findAll() {
        return null;
    }

    @Override
    public String findAllJson()  {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("jedis.properties");
        Properties pro = new Properties();
        try {
            pro.load(in);
        }catch (Exception e){
            System.out.println(e);
        }
        JedisPool jedisPool;
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        String ip = pro.getProperty("host");
        System.out.println(ip);

        int port = 6379;
        int timeout = 2000;
        jedisPoolConfig.setMaxTotal(1024);
        jedisPoolConfig.setMaxIdle(100);
        jedisPoolConfig.setMaxWaitMillis(100);
        //jedisPoolConfig.setTestOnBorrow(false);//jedis 第一次启动时，会报错
        //jedisPoolConfig.setTestOnReturn(true);
        jedisPool = new JedisPool(jedisPoolConfig, ip, port, timeout);

        //1从redis中查询数据
        Jedis jedis = jedisPool.getResource();
        String province_json = jedis.get("123");
        if (province_json==null ||province_json.length()==0) {
            System.out.println("redis没有数据");

            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString("123");
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province",province_json);
            jedis.close();
        }else{
            System.out.println("redis有数据");
            System.out.println(province_json);

        }
        return province_json;
    }

    public static void main(String[] args) {
        ProvinceServiceImp provinceServiceImp = new ProvinceServiceImp();
            provinceServiceImp.findAllJson();
    }

}
