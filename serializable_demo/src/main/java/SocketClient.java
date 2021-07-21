import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
public class SocketClient {
    public static void main(String args[]) throws Exception {
        // Ҫ���ӵķ����IP��ַ�Ͷ˿�
        String host = "127.0.0.1";
        int port = 8989;
        // �����˽�������
        Socket socket = new Socket(host, port);
        // �������Ӻ��������
        OutputStream outputStream = socket.getOutputStream();
        Book p=new Book("�ͻ�1",12);
        //pΪ���Ͷ���
        ObjectOutputStream o= new ObjectOutputStream(socket.getOutputStream());
        o.writeObject(p);
        o.flush();
        //ͨ��shutdownOutput���ٷ������Ѿ����������ݣ�����ֻ�ܽ�������
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        ObjectInputStream in=new ObjectInputStream(inputStream);
        Book s= (Book) in.readObject();
        System.out.println("����˻ظ���Ϣ��" + s);
        in.close();
        o.close();
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}