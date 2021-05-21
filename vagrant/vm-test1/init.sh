#!/bin/bash
apt update
apt install -y nginx mysql-server-5.7
mysql -e "create user 'phpuser'@'%' identified by 'pass';"
