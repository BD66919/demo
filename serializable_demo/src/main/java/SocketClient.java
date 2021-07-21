import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
public class SocketClient {
    public static void main(String args[]) throws Exception {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 8989;
        // 与服务端建立连接
        Socket socket = new Socket(host, port);
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        Book p=new Book("客户1",12);
        //p为传送对象
        ObjectOutputStream o= new ObjectOutputStream(socket.getOutputStream());
        o.writeObject(p);
        o.flush();
        //通过shutdownOutput高速服务器已经发送完数据，后续只能接受数据
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        ObjectInputStream in=new ObjectInputStream(inputStream);
        Book s= (Book) in.readObject();
        System.out.println("服务端回复消息：" + s);
        in.close();
        o.close();
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}