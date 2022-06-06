create database ssm default charset utf8mb4;
use ssm;
create table student(
id int(11) auto_increment primary key,
name varchar(255) default null,
email varchar(255) default null,
age int(11) default null
) engine = InnoDB default charset = utf8mb4;
insert into student(name,email,age) values('张三','zhangsan@126.com',22);
insert into student(name,email,age) values('李四','lisi@126.com',21);
insert into student(name,email,age) values('王五','wangwu@126.com',22);
insert into student(name,email,age) values('赵六','zhaoliu@qq.com',25);
select * from student;