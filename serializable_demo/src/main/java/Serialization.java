import com.alibaba.fastjson.JSON;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Serialization {
    public static File file = null;
    public static void main(String[] args) throws Exception, IOException {

        /*���л�Ϊjson�ַ���
        Book test = new Book("java",100);
        String objectToJson = JSON.toJSONString(test);
        System.out.println(objectToJson);
        Book book = JSON.parseObject(objectToJson,Book.class);
        System.out.println(book);
        */

        /*//���л������ش洢
        file = new File("serialize.txt");
        //���л���ָ�����ı�
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(new Book("Java Development",45.3));//�Զ����л�

        oos.flush();
        oos.close();
        //file = new File("serialize.txt");
        //�����л���ָ�����ı�
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
        Object obj=ois.readObject();
        Book book=(Book) obj;
        System.out.println("\n By using the byte stream serialization operation, "
                + "we can see the following information:\n"+book);
        ois.close();
         */

        //���л����紫��
        // ����ָ���Ķ˿�
        int port = 8989;
        ServerSocket server = new ServerSocket(port);

        System.out.println("����˵ȴ�����");
        // server��һֱ�ȴ����ӵĵ���
        Socket socket = server.accept();
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream in=new ObjectInputStream(inputStream);
        Book p = (Book) in.readObject();
        System.out.println("�յ��ͻ�����Ϣ:" +p);

        //���ظ��ͻ�����Ϣ
        OutputStream outputStream = socket.getOutputStream();
        Book s=new Book("�����",102);
        //sΪ���Ͷ���
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