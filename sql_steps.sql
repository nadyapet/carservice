create database carservices_db
create user 'carservicesuser'@'%' identified by '12345' -- 12345 password
grant all on carservices_db.* to 'carservicesuser'@'%';