drop table if exists book;
create table book(
bookid int not null auto_increment primary key,
bookname varchar(255) not null comment '图书名称'
)engine = InnoDB default charset = utf8mb4;
insert into book values(1,'java基础'),(2,'sql基础');
select * from book;
