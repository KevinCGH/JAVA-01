#!/bin/bash
USER=root
MYSQL_PWD=123456

startTime=$(date +%s)

echo "Beginning..."
mysql -u$USER -p$MYSQL_PWD my_shop < $1 > /dev/nul 2>&1

endTime=$(date +%s)

durationTime=$((endTime - startTime))

echo "Cost "$durationTime" seconds"