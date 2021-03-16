# 🍃Week07作业题目：

## 2月24日课程

### 1.（选做）用今天课上学习的知识，分析自己系统的 SQL 和表结构

### 2.（必做）按自己设计的表结构，插入100万订单模拟数据，测试不同方式的插入效率。
[数据插入实验](./data_insert/README.md)

### 3.（选做）按自己设计的表结构，插入1000万订单模拟数据，测试不同方式的插入效率。
[数据插入实验](./data_insert/README.md)

### 4.（选做）使用不同的索引或组合，测试不同方式查询效率。

### 5.（选做）调整测试数据，使得数据尽量均匀，模拟1年时间内的交易，计算一年的销售报表：销售总额，订单数，客单价，每月销售量，前十的商品等等（可以自己设计更多指标）。

### 6.（选做）尝试自己做一个 ID 生成器（可以模拟 Seq 或 Snowflake）。

### 7.（选做）尝试实现或改造一个非精确分页的程序。

---
## 3月2日课程

### 1.（选做）配置一遍异步复制，半同步复制、组复制。 
#### 异步复制
[docker-compose.yml](./docker-compose.yml)
     
配置Master Node：

`docker exec -it master_node /bin/bash`

```bash
mysql> CREATE USER 'repl'@'%' IDENTIFIED BY '123456';
Query OK, 0 rows affected (0.11 sec)

mysql> GRANT REPLICATION SLAVE ON *.* TO 'repl'@'%';
Query OK, 0 rows affected (0.12 sec)

mysql> flush privileges;
Query OK, 0 rows affected (0.10 sec)

mysql> show master status;
+------------------+----------+--------------+------------------+-------------------+
| File             | Position | Binlog_Do_DB | Binlog_Ignore_DB | Executed_Gtid_Set |
+------------------+----------+--------------+------------------+-------------------+
| mysql-bin.000004 |      747 |              |                  |                   |
+------------------+----------+--------------+------------------+-------------------+
1 row in set (0.00 sec)
```

设置Slave Node：

```bash
CHANGE MASTER TO
    MASTER_HOST='master_node',  
    MASTER_PORT=3316,
    MASTER_USER='repl',      
    MASTER_PASSWORD='123456',   
    MASTER_LOG_FILE='mysql-bin.000004',
    MASTER_LOG_POS=747;
```
#### 半同步复制
#### 组复制


### 2.（必做）读写分离-动态切换数据源版本1.0
[DynamicDataSourceApplication](./dynamic-data-source/src/main/java/com/example/dynamicdatasource/DynamicDataSourceApplication.java)

配置数据源`master`、`slave1`、`slave2`，其中`master`和`slave1`组成异步主从复制，`slave2`为不相关的一个数据库（保持有同样的表，但无数据）

查询过数据时会在`slave1`和`slave2`之间切换（当切换到`slave2`时查无数据），插入数据时会使用`master`


### 3.（必做）读写分离-数据库框架版本2.0
> 使用 ShardingSphere-jdbc 5.0.0-alpha 实现读写分离配置

配置题目2的两个主从数据库 [config-replica-query.yaml](./config-replica-query.yaml)
```bash
# 启动 ShardingSphere
./bin/start.sh
```

### 4.（选做）读写分离-数据库中间件版本3.0


### 5.（选做）配置 MHA，模拟 master 宕机

### 6.（选做）配置 MGR，模拟 master 宕机


### 7.（选做）配置 Orchestrator，模拟 master 宕机，演练 UI 调整拓扑结构