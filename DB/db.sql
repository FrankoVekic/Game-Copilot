drop database if exists gamecopilot;
create database gamecopilot default character set utf8mb4;
use gamecopilot;

create table user (
id int not null primary key auto_increment,
email varchar(50) not null,
password varchar(30) not null,
name varchar(30) not null,
surname varchar(30) not null,
role varchar(15) not null
);

create table product (
id int not null primary key auto_increment,
name varchar(50) not null,
price decimal(18,2) not null,
description text,
quantity int not null
);


create table orders (
id int not null primary key auto_increment,
order_date datetime not null,
buyer int not null
);

create table product_order(
id int not null primary key auto_increment,
orders int not null,
product int not null,
quantity int not null
);

alter table orders add foreign key (buyer) references user(id);
alter table product_order add foreign key (orders) references orders(id);
alter table product_order add foreign key (product) references product(id);