package service;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MqProducer {

    public static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";
    public static final String QUEUE_NAME = "queue02";

    public static void main(String[ ] args) throws JMSException {
        //1 �������ӹ��������ո�����url��ַ������Ĭ���û���������
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        //2 ͨ�����ӹ�������ȡ����connection ����������
        Connection connection = activeMQConnectionFactory.createConnection();

        connection.start();

        //3 �����Ựsession
        //������������һ��������/�ڶ�����ǩ��
        Session session = connection.createSession(false,Session.CLIENT_ACKNOWLEDGE);
        //4 ����Ŀ�ĵ�(�����Ƕ��л�������topic)
        Queue queue = session.createQueue(QUEUE_NAME);

        //5 ������Ϣ��������
        MessageProducer messageProducer = session.createProducer(queue);
        //6 ͨ��ʹ��messageProducer����3����Ϣ���͵�MQ�Ķ�������
        for(int i = 1; i <= 6; i++) {
            //7 ������Ϣ���ñ�ѧ��������ʦҪ��д�õ���������Ϣ
            TextMessage textMessage = session.createTextMessage("��3����Ϣ---" + i);
            //8 ͨ��messageProducer���͸�mq
            messageProducer.send(textMessage);
        }
        //9 �ر���Դ
        messageProducer.close();
        session.close();
        connection.close();
        System.out.println("*********��Ϣ������MQ���");
    }
}