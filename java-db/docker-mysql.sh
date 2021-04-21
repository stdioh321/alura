#!/bin/bash


docker run --rm -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root  -d mysql:8.0.18
echo "Waiting mysql start..."
echo "Grab a cup of coffee"
sleep 25
mysql --protocol tcp -uroot -proot -P3306 < startup_db.sql;
mysql --protocol tcp -uroot -proot -P3306;