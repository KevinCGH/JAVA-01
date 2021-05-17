# 动手写MQ

## 第一个版本——内存Queue

基于内存`Queue`实现生产和消费API

- [x] 创建内存`BlockingQueue`，作为底层消息存储
- [x] 定义`Topic`，支持多个`Topic`
- [x] 定义`Producer`，支持`Send`消息
- [x] 定义`Consumer`，支持`Poll`消息

> [kmq-core / KmqDemo](./kmq-core/src/main/java/io/kimmking/kmq/demo/KmqDemo.java)


## 第二个版本——自定义Queue

去掉内存`Queue`，设计自定义`Queue`，实现消息确认和消费offset

- [x] 自定义内存`Message`数组模拟`Queue`。

  在`Kmq`中使用`ArrayList`（`this.queue = Collections.synchronizedList(new ArrayList<>(capacity))`） 模拟 `Queue`

- [x] 使用指针记录当前消息写入位置。

  在`Kmq` 中记录消息写入位置 `putIndex`

- [x] 对于每个命名消费者，用指针记录消费位置。

  在`KmqConsumer` 中记录消费位置 `offset`，并在poll操作时传入

> [kmq-v2 / KmqDemoV2](./kmq-v2/src/main/java/com/kevin/kmq/demo/KmqDemoV2.java)



## 第三个版本——给予SpringMVC实现MQServer

拆分`broker`和`client`(包括`producer`和`consumer`) 

- [x] 将`Queue`保存到web server端 

- [x] 设计消息读写API接口，确认接口，提交offset接口 

- [ ] `producer`和`consumer`通过`httpclient`访问`Queue` 

- [ ] 实现消息确认，`offset`提交 

- [ ] 实现`consumer`从`offset`增量拉取 



## 第四个版本——功能完善MQ

增加多种策略（各条之间没有关系，可以任意选择实现） 

- [ ] 考虑实现消息过期，消息重试，消息定时投递等策略 
- [ ] 考虑批量操作，包括读写，可以打包和压缩 
- [ ] 考虑消息清理策略，包括定时清理，按容量清理、LRU等 
- [ ] 考虑消息持久化，存入数据库，或`WAL`日志文件，或`BookKeeper` 
- [ ] 考虑将`spring mvc`替换成`netty`下的`tcp`传输协议，`rsocket/websocket `





## 第五个版本——体系完善MQ

对接各种技术（各条之间没有关系，可以任意选择实现）

- [ ] 考虑封装 JMS 1.1 接口规范 
- [ ] 考虑实现 STOMP 消息规范 
- [ ] 考虑实现消息事务机制与事务管理器 
- [ ] 对接Spring 
- [ ] 对接Camel或Spring Integration 
- [ ] 优化内存和磁盘的使用 



