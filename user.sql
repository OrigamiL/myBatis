drop table if exists user; 
create table user(
id int(11) auto_increment primary key,
username varchar(32) comment '用户名称',
birthday date default null  comment '生日',
sex char(2) default null  comment '性别',
address varchar(255) default null  comment '地址'
) engine = InnoDB default charset = utf8mb4;
insert into user(username, birthday, sex, address ) values('张三','2002-04-14','2','青岛');
insert into user(username, birthday, sex, address ) values('李四','2011-01-27','1','潍坊');
insert into user(username, birthday, sex, address ) values('王五','2004-11-01','1','北京');
insert into user(username, birthday, sex, address ) values('赵六','1999-08-23','2','上海');
insert into user(username, birthday, sex, address ) values('陈七','2006-12-12','1','天津');
insert into user(username, birthday, sex, address ) values('秦八','2003-10-31','2','重庆');
insert into user(username, birthday, sex, address ) values('钱九','2008-05-09','2','武汉');
select * from user;