# 🍃Week08作业
## Week08 作业题目（周三）：
### 1.（选做）分析前面作业设计的表，是否可以做垂直拆分。
电商业务订单会是一个主要的业务，订单强相关的表可以垂直拆分出来；

### 2.（必做）设计对前面的订单表数据进行水平分库分表，拆分 2 个库，每个库 16 张表。并在新结构在演示常见的增删改查操作。代码、sql 和配置文件，上传到 Github。

[horizontal-sharding](12.horizontal-sharding)

### 3.（选做）模拟 1000 万的订单单表数据，迁移到上面作业 2 的分库分表中。

通过 `sharding-sphere-scaling` 迁移 `demo_ds` 数据到 `demo_ds_0` 和 `demo_ds_1`
1. 通过[Week_07/data_insert](../Week_07/data_insert) 往 `demo_ds.t_order` 插入 1000W order 数据
   > 确保MySQL 开启 `binlog`，`binlog-format=Row`
2. 启动 sharding-sphere-proxy，虚拟 `demo_ds_0` 和 `demo_ds_1` 为 `sharding_db`
   - [server.yaml](./13.data-scaling/proxy-server.yaml)
   - [config-sharding.yaml](./13.data-scaling/config-sharding.yaml)
3. 启动`zookeeper`、`sharding-sphere-ui`并配置注册服务器（可选）
4. 启动 sharding-sphere-scaling
   - [server.yaml](./13.data-scaling/scaling-server.yaml)
5. 执行命令`sh curl.txt`创建迁移任务

> 关于本题，另外写了一篇总结 [MySQL 数据库全量、增量数据迁移扩容](https://www.yuque.com/docs/share/95c84494-569c-481b-bf32-cce672b65e83)
> 
> 👏欢迎拍砖指正

### 4.（选做）重新搭建一套 4 个库各 64 个表的分库分表，将作业 2 中的数据迁移到新分库。
类似 题目3，把源数据库设置为 题目2 的虚拟库表，目标库为 4x64 的新库 做一次迁移

## Week08 作业题目（周日）：

### 1.（选做）列举常见的分布式事务，简单分析其使用场景和优缺点。
- XA分布式事务（2PC/3PC），强一致性事务，适用于短事务，并发性能差
- 柔性事务（TCC、 SAGA、AT），最终一致性事务，适用于长事务，强一致性要求不高、并发要求高的场景，缺点是实现复杂，业务侵入大，存在数据不一致的时刻
### 2.（必做）基于 hmily TCC 或 ShardingSphere 的 Atomikos XA 实现一个简单的分布式事务应用 demo（二选一），提交到 Github。
- [基于Hmily TCC](./22.distributed-transaction-demo/hmily-dubbo-demo)
### 3.（选做）基于 ShardingSphere narayana XA 实现一个简单的分布式事务 demo。
### 4.（选做）基于 seata 框架实现 TCC 或 AT 模式的分布式事务 demo。
### 5.（选做☆）设计实现一个简单的 XA 分布式事务框架 demo，只需要能管理和调用 2 个 MySQL 的本地事务即可，不需要考虑全局事务的持久化和恢复、高可用等。
### 6.（选做☆）设计实现一个 TCC 分布式事务框架的简单 Demo，需要实现事务管理器，不需要实现全局事务的持久化和恢复、高可用等。
### 7.（选做☆）设计实现一个 AT 分布式事务框架的简单 Demo，仅需要支持根据主键 id 进行的单个删改操作的 SQL 或插入操作的事务。