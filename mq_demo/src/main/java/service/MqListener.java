package service;

import org.springframework.jms.listener.SessionAwareMessageListener;

import javax.jms.*;

public class MqListener implements SessionAwareMessageListener<Message> {

    @Override
    public void onMessage(Message message, Session session)throws JMSException{
        String text = ((TextMessage) message).getText();
        System.out.println(text);
        ((TextMessage) message).acknowledge();
    }


}
