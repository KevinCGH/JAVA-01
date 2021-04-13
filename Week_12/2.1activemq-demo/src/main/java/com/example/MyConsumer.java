package com.example;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MyConsumer implements Runnable, ExceptionListener {
    private String name;
    private boolean isQueue;

    public MyConsumer(String name, boolean isQueue) {
        this.name = name;
        this.isQueue = isQueue;
    }

    @Override
    public void run() {
        // Create a ConnectionFactory
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(Constants.BROKER_URL);

        try {
            // Create a Connection
            Connection connection = factory.createConnection();
            connection.start();

            connection.setExceptionListener(this);

            // Create a session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination
            Destination destination = isQueue ? session.createQueue("QUEUE_" + name) : session.createTopic("TOPIC_" + name);

            // Create a MessageConsumer from Session
            MessageConsumer consumer = session.createConsumer(destination);
            Message message = consumer.receive(1000);

            if (message instanceof TextMessage) {
                String text = ((TextMessage) message).getText();
                System.out.println("Received message: " + text);
            } else {
                System.out.println("Received message: " + message);
            }

            consumer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onException(JMSException e) {
        System.out.println("JMS Exception :" + e.getMessage());
    }
}
