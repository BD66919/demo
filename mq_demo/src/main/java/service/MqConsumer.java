package service;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MqConsumer implements MessageListener {
    private String user = ActiveMQConnection.DEFAULT_USER;
    private String password = ActiveMQConnection.DEFAULT_PASSWORD;
    private String url = "tcp://127.0.0.1:61616";
    private String subject = "queue02";
    private Destination destination = null;
    private Connection connection = null;
    private Session session = null;
    private MessageConsumer consumer = null;

    // ��ʼ��
    private void initialize() throws JMSException, Exception {
        // ���ӹ������û��������ӵĶ�������ʹ�õ���ActiveMQ��ActiveMQConnectionFactory����url��username��password�������ӹ�����
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                user, password, url);
        // ���ӹ�������һ��jms connection
        connection = connectionFactory.createConnection();
        // �����������ѵ�һ�����߳������ġ��Ự���ڴ�����Ϣ�������ߣ������ߺ���Ϣ���Ự�ṩ��һ�������Ե������ġ�
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); // ��֧������
        // Ŀ�ĵ��ǿͻ�����ָ����������Ϣ��Ŀ�껹����������Ϣ����Դ�Ķ���������Ϣ���ݷ�ʽ����Ե�ͷ���/����
        destination = session.createQueue(subject);
        // �Ự������Ϣ�������߽���Ϣ���͵�Ŀ�ĵ�
        consumer = session.createConsumer(destination);
    }

    // ������Ϣ
    public void consumeMessage() throws JMSException, Exception {
        initialize();
        connection.start();
        // ��ʼ����
        consumer.setMessageListener(this);
    }

    // �ر�����
    public void close() throws JMSException {
        if (consumer != null)
            consumer.close();
        if (session != null)
            session.close();
        if (connection != null)
            connection.close();
    }

    // ��Ϣ������
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage txtMsg = (TextMessage) message;
                String msg = txtMsg.getText();
                if(msg.equals("1")){
                    new Thread().run();//��ʱ5����
                }else{
                    new Thread().run();//��ʱ10����
                }
                System.out.println("Consumer:->Received: " + msg);
            } else {
                System.out.println("Consumer:->Received: " + message);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        MqConsumer mqConsumer = new MqConsumer();
        mqConsumer.consumeMessage();
    }
}
