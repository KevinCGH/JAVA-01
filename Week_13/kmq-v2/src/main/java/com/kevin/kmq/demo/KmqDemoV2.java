package com.kevin.kmq.demo;

import com.kevin.kmq.core.KmqBroker;
import com.kevin.kmq.core.KmqConsumer;
import com.kevin.kmq.core.KmqMessage;
import com.kevin.kmq.core.KmqProducer;
import lombok.SneakyThrows;

public class KmqDemoV2 {

    private static final int MESSAGE_COUNT = 10;

    @SneakyThrows
    public static void main(String[] args) {
        String topic = "kk.test";
        KmqBroker broker = new KmqBroker();
        broker.createTopic(topic);


        KmqProducer producer = broker.createProducer();
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            Order order = new Order(1000L + i, System.currentTimeMillis(), "USD2CNY", 6.51d);
            producer.send(topic, new KmqMessage(null, order));
        }
        System.out.println("============Consumer-1");
        DemoConsumer consumer1 = new DemoConsumer(broker, topic);
        new Thread(consumer1, "Consumer-1").start();
        Thread.sleep(3000);
        System.out.println("\n============Consumer-2");
        DemoConsumer consumer2 = new DemoConsumer(broker, topic);
        new Thread(consumer2, "Consumer-2").start();

        Thread.sleep(500);
        System.out.println("点击任何键，发送一条消息；点击q或e，退出程序。");

        while (true) {
            char c = (char) System.in.read();
            if (c == 'q' || c == 'e') break;
            if (c > 20) {
                System.out.println(c);
                producer.send(topic, new KmqMessage(null, new Order(100000L + c, System.currentTimeMillis(), "USD2CNY", 6.52d)));
            }
        }
        consumer1.stop();
        consumer2.stop();
    }

    private static class DemoConsumer implements Runnable {

        private KmqBroker broker;
        private String topic;

        public DemoConsumer(KmqBroker broker, String topic) {
            this.broker = broker;
            this.topic = topic;
        }

        final boolean[] flag = new boolean[1];

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            KmqConsumer consumer = broker.createConsumer();
            consumer.subscribe(topic);
            flag[0] = true;
            while (flag[0]) {
                KmqMessage<Order> message = consumer.poll();
                if (null != message) {
                    System.out.println(name + ": " + message.getBody());
                }
            }
            System.out.println(name + " 程序退出！");
        }

        public void stop() {
            flag[0] = false;
        }
    }
}
