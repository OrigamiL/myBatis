create table customer(
id int(10) primary key auto_increment,
name varchar(100),
age int(10)
);
insert into customer values(1,'张三',22),(2,'李四',26),(3,'王五',31);
create table orders(
id int primary key auto_increment,
orderNumber varchar(20) comment '订单编号',
orderPrice double comment '订单价格',
customer_id int(10),
foreign key(customer_id) references customer(id)
);
insert into orders values(10,10001,100.00,1),(11,12002,19.55,1),(12,10031,333.11,2);