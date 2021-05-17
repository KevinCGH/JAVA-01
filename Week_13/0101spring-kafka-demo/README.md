启动3个节点的Kafka集群
```shell
nohup bin/kafka-server-start.sh ./kafka9001.properties > ./nohup_kafka_9001.log &
nohup bin/kafka-server-start.sh ./kafka9002.properties > ./nohup_kafka_9002.log &
nohup bin/kafka-server-start.sh ./kafka9003.properties > ./nohup_kafka_9003.log &
```

创建带有副本的topic：
```shell
> bin/kafka-topics.sh --zookeeper localhost:2181 --create --topic test32 --partitions 3 --replication-factor 2
Created topic test32.

# 查看
> bin/kafka-topics.sh --zookeeper localhost:2181 --describe --topic test32
Topic: test32	TopicId: KzXvD6GDSqS2MMZevAdpvg	PartitionCount: 3	ReplicationFactor: 2	Configs:
	Topic: test32	Partition: 0	Leader: 2	Replicas: 2,3	Isr: 2,3
	Topic: test32	Partition: 1	Leader: 3	Replicas: 3,1	Isr: 3,1
	Topic: test32	Partition: 2	Leader: 1	Replicas: 1,2	Isr: 1,2
```

功能测试
```shell
# consumer
> bin/kafka-console-consumer.sh --bootstrap-server localhost:9001 --topic test32 --from-beginning

# producer
> bin/kafka-console-producer.sh --bootstrap-server localhost:9003 --topic test32
```

性能测试
```shell
# producer
> bin/kafka-producer-perf-test.sh --topic test32 --num-records 100000 --record-size 1024 --throughput 200000 --producer-props bootstrap.servers=localhost:9002
100000 records sent, 36832.412523 records/sec (35.97 MB/sec), 591.98 ms avg latency, 1050.00 ms max latency, 568 ms 50th, 951 ms 95th, 1018 ms 99th, 1046 ms 99.9th.

# consumer
> bin/kafka-consumer-perf-test.sh --bootstrap-server localhost:9002 --topic test32 --fetch-size 1048576 --messages 100000 -threads 2
WARNING: option [threads] and [num-fetch-threads] have been deprecated and will be ignored by the test

start.time, end.time, data.consumed.in.MB, MB.sec, data.consumed.in.nMsg, nMsg.sec, rebalance.time.ms, fetch.time.ms, fetch.MB.sec, fetch.nMsg.sec
2021-04-20 23:54:11:038, 2021-04-20 23:54:11:658, 97.6563, 157.5101, 100001, 161291.9355, 319, 301, 324.4394, 332229.2359
```