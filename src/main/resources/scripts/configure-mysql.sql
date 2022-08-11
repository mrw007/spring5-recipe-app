## Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to mysql and run as root user
#Create Databases
CREATE DATABASE mrw_dev;
CREATE DATABASE mrw_prod;

#Create database service accounts
CREATE USER 'mrw_dev_user'@'localhost' IDENTIFIED BY 'pass';
CREATE USER 'mrw_prod_user'@'localhost' IDENTIFIED BY 'pass';
CREATE USER 'mrw_dev_user'@'%' IDENTIFIED BY 'pass';
CREATE USER 'mrw_prod_user'@'%' IDENTIFIED BY 'pass';

#Database grants
GRANT SELECT ON mrw_dev.* to 'mrw_dev_user'@'localhost';
GRANT INSERT ON mrw_dev.* to 'mrw_dev_user'@'localhost';
GRANT DELETE ON mrw_dev.* to 'mrw_dev_user'@'localhost';
GRANT UPDATE ON mrw_dev.* to 'mrw_dev_user'@'localhost';
GRANT SELECT ON mrw_prod.* to 'mrw_prod_user'@'localhost';
GRANT INSERT ON mrw_prod.* to 'mrw_prod_user'@'localhost';
GRANT DELETE ON mrw_prod.* to 'mrw_prod_user'@'localhost';
GRANT UPDATE ON mrw_prod.* to 'mrw_prod_user'@'localhost';
GRANT SELECT ON mrw_dev.* to 'mrw_dev_user'@'%';
GRANT INSERT ON mrw_dev.* to 'mrw_dev_user'@'%';
GRANT DELETE ON mrw_dev.* to 'mrw_dev_user'@'%';
GRANT UPDATE ON mrw_dev.* to 'mrw_dev_user'@'%';
GRANT SELECT ON mrw_prod.* to 'mrw_prod_user'@'%';
GRANT INSERT ON mrw_prod.* to 'mrw_prod_user'@'%';
GRANT DELETE ON mrw_prod.* to 'mrw_prod_user'@'%';
GRANT UPDATE ON mrw_prod.* to 'mrw_prod_user'@'%';