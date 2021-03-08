## 1. 准备
拷贝脚本到 docker container
```bash
# docker cp ./insert.sql <container_id>:/
docker cp ./insert_base_data.sql 4aa4ab552812:/
```
进入docker container 并执行脚本
```bash
docker exec -it 4aa4 /bin/bash
cd /
./execute.sh ./insert_base_data.sql
```
## 2.生成sql脚本
用python脚本生成`INSERT`脚本
```bash
python ./create_insert_sql.py
# _insert_line_100w.sql
# _insert_line_1000w.sql
# _insert_batch_100w.sql
# _insert_batch_1000w.sql
```

## 3.普通插入数据
用步骤1统计插入时间
```shell
root@4aa4ab552812:/# ./execute.sh ./_insert_line_100w.sql
Beginning...
Cost 536 seconds # 8min 56s
```
> 1000w 行记录插入太耗时，这里不做演示

## 4.批量插入数据
用步骤1执行`_insert_batch_100w.sql`批量插入100W数据
```shell
root@4aa4ab552812:/# ./execute.sh ./_insert_batch_100w.sql
Beginning...
Cost 8 seconds
```
执行性能提升67倍

同样方法执行`_insert_batch_1000w.sql`
```shell
root@4aa4ab552812:/# ./execute.sh ./_insert_batch_1000w.sql
Beginning...
Cost 71 seconds
```

## 5. 继续尝试优化
网上查询过资料，说频繁批量插入数据时，MyISAM引擎比InnoDB引擎性能更好；

但实际测试发现性能反而有所下降
```sql
-- 修改t_goods表引擎
alter table t_goods ENGINE=MyISAM;

select * from information_schema.TABLES where TABLE_NAME = 't_goods';
```
```shell
# 批量插入100W数据（MyISAM）
root@4aa4ab552812:/# ./execute.sh ./_insert_batch_100w.sql
Beginning...
Cost 12 seconds
```

```shell
# 批量插入1000W数据（MyISAM）
root@4aa4ab552812:/# ./execute.sh ./_insert_batch_1000w.sql
Beginning...
Cost 123 seconds
```