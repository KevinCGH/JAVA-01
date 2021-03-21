# Horizontal Sharding

## insert order
`curl -X POST -H 'Content-Type: application/json' -d '{"userId": 1, "status": "SUCCESS"}' http://localhost:8888/orders`

ShardingProxy Log
```text
[INFO ] 22:13:50.818 [ShardingSphere-Command-2] ShardingSphere-SQL - Logic SQL: insert into t_order (status, user_id) values ('SUCCESS', 1)
[INFO ] 22:13:50.819 [ShardingSphere-Command-2] ShardingSphere-SQL - SQLStatement: MySQLInsertStatement(setAssignment=Optional.empty, onDuplicateKeyColumns=Optional.empty)
[INFO ] 22:13:50.819 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: ds_1 ::: insert into t_order_0 (status, user_id, order_id) values ('SUCCESS', 1, 577981929388224512)
```
## delete order

Log
每一个分库会执行一遍 `delete`操作
```text
[INFO ] 22:20:41.881 [ShardingSphere-Command-10] ShardingSphere-SQL - Actual SQL: ds_0 ::: delete from t_order_0 where order_id=577983038018269184
[INFO ] 22:20:41.881 [ShardingSphere-Command-10] ShardingSphere-SQL - Actual SQL: ds_1 ::: delete from t_order_0 where order_id=577983038018269184
```
