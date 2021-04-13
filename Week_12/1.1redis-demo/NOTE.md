# 配置 redis 的主从复制，sentinel 高可用，Cluster 集群

## 配置redis 的主从复制
### 启动主节点
```shell
redis-server --port 6379
```
### 启动从节点，并配置主从

方法一：（启动参数）
```shell
redis-server --port 6380 --slaveof 127.0.0.1 6379
```
方法二：（配置文件）
**主库**的配置文件中增加配置`replicaof 127.0.0.1 6380`

方法三：
从库的客户端中执行：
```shell
127.0.0.1:6380> slaveof 127.0.0.1 6379
## 解除主从，可以在从库执行：
127.0.0.1:6380> slaveof no one
```

## sentinel 高可用
### 启动redis主从实例
通过配置文件[redis-6379.conf](./redis-6379.conf)、[redis-6380.conf](./redis-6380.conf)分别启动主从库
```shell
redis-server redis-6379.conf
redis-server redis-6380.conf
## 设置主从
127.0.0.1:6380> slaveof localhost 6379
```

### 启动Sentinel
```shell
redis-server sentinel01.conf --sentinel
redis-server sentinel02.conf --sentinel
```

## Cluster 集群
启动redis
```shell
redis-server redis-cluster-6379.conf
redis-server redis-cluster-6380.conf
redis-server redis-cluster-6381.conf
```

组建集群，在其中一个节点执行：
```shell
cluster meet 127.0.0.1 6380
cluster meet 127.0.0.1 6381
```
通过Shell脚本 [add_slots.sh](./add_slots.sh) 增加分片槽位（slots）
```shell
sh add_slots.sh 0 5500 6379
sh add_slots.sh 5501 11000 6380
sh add_slots.sh 11001 16383 6381
```
测试Cluster集群
```shell
> redis-cli -c -p 6379

127.0.0.1:6379> keys *
(empty list or set)

127.0.0.1:6379> set foo bar
-> Redirected to slot [12182] located at 127.0.0.1:6381
OK

127.0.0.1:6381> set hello world
-> Redirected to slot [866] located at 127.0.0.1:6379
OK

127.0.0.1:6379> get foo
-> Redirected to slot [12182] located at 127.0.0.1:6381
"bar"
```