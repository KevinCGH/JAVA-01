#!/usr/bin/python
# -*- coding: UTF-8 -*-

# from datetime import datetime

def create_line_sql(length):
    sql_file = open("./_insert_line_%dw.sql" % (length), 'w', encoding='utf-8')

    _len = length * 10000
    # _len=20
    _idx = 0
    # _date=datetime.now().strftime("%Y-%m-%d %H:%M:%S")
    while _idx < _len:
        line = "INSERT INTO t_goods (`name`, `catalog_id`, `create_by`, `update_by`) VALUES ('%s', %d, %d, %d);" \
            % ("Goods_%s" % _idx, 1, 1, 1)

        sql_file.write(line+'\n')
        _idx += 1


def create_batch_sql(length):
    sql_file = open("./_insert_batch_%dw.sql" %
                    (length), 'w', encoding='utf-8')
    _len = length * 10
    _idx = 0
    while _idx < _len:
        line = "INSERT INTO t_goods (`name`, `catalog_id`, `create_by`, `update_by`) VALUES"
        val = []
        for _ in range(1, 1001):
            val.append((("Goods_%s" % _idx), 1, 1, 1))
        _val=str(val)
        _sql=line + _val.strip('[]')
        sql_file.write(_sql+';\n')
        _idx += 1


if __name__ == "__main__":
    # create_line_sql(100)
#     create_line_sql(1000)
    create_batch_sql(100)
    create_batch_sql(1000)
