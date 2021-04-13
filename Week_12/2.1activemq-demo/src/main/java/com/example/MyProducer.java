package com.example;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MyProducer implements Runnable {

    private String name;
    private boolean isQueue;

    public MyProducer(String name, boolean isQueue) {
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

            // Create a session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination
            Destination destination = isQueue ? session.createQueue("QUEUE_" + name) : session.createTopic("TOPIC_" + name);

            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            String text = "Say Hello From " + Thread.currentThread().getName() + ":" + this.hashCode();
            TextMessage message = session.createTextMessage(text);

            System.out.println("Message sent: " + Thread.currentThread().getName() + "(" + this.hashCode() + ")");
            producer.send(message);


            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
