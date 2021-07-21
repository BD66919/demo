import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serialization {
    public static File file = null;
    public static void main(String[] args) throws Exception, IOException {

        /*序列化为json字符串
        Book test = new Book("java",100);
        String objectToJson = JSON.toJSONString(test);
        System.out.println(objectToJson);
        Book book = JSON.parseObject(objectToJson,Book.class);
        System.out.println(book);
        */

        /*//序列化到本地存储
        file = new File("serialize.txt");
        //序列化到指定的文本
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(new Book("Java Development",45.3));//自动序列化

        oos.flush();
        oos.close();
        //file = new File("serialize.txt");
        //反序列化到指定的文本
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
        Object obj=ois.readObject();
        Book book=(Book) obj;
        System.out.println("\n By using the byte stream serialization operation, "
                + "we can see the following information:\n"+book);
        ois.close();
         */

        //序列化网络传输
        // 监听指定的端口
        int port = 8989;
        ServerSocket server = new ServerSocket(port);

        System.out.println("服务端等待连接");
        // server将一直等待连接的到来
        Socket socket = server.accept();
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream in=new ObjectInputStream(inputStream);
        Book p = (Book) in.readObject();
        System.out.println("收到客户端消息:" +p);

        //返回给客户端消息
        OutputStream outputStream = socket.getOutputStream();
        Book s=new Book("服务端",102);
        //s为传送对象
        ObjectOutputStream out=new ObjectOutputStream(outputStream);
        out.writeObject(s);
        out.flush();

        inputStream.close();
        outputStream.close();
        out.close();
        in.close();
        socket.close();
        server.close();

    }
}