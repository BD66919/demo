package multiThread;

import redis.clients.jedis.Jedis;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class multiThread {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,5,20, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        Jedis jedis = new Jedis("127.0.0.1",6379);
        HashMap<String,String> map = new HashMap<>();
        map.put("a","1000");
        map.put("b","2000");
        map.put("c","3000");
        jedis.hmset("map",map);
        Map<String,String> taskMap = jedis.hgetAll("map");
        taskMap.forEach((key,value)->threadPoolExecutor.execute(new task(value)));
    }


    private static class task implements Runnable {
        private final String number;

        task(String number){
            this.number = number;
        }

        public void run(){
            int num = Integer.parseInt(number);
            while(num!=0)
                System.out.println(Thread.currentThread().getId()+" "+num--);
        }
    }







}
