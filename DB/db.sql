drop database if exists gamecopilot;
create database gamecopilot default character set utf8mb4;
use gamecopilot;

create table user (
id int not null primary key auto_increment,
email varchar(50) not null,
password char(60) not null,
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


create table `order` (
id int not null primary key auto_increment,
order_date datetime not null,
buyer int not null
);

create table product_order(
id int not null primary key auto_increment,
`order` int not null,
product int not null,
quantity int not null
);

alter table `order` add foreign key (buyer) references user(id);
alter table product_order add foreign key (`order`) references `order`(id);
alter table product_order add foreign key (product) references product(id);

insert into user (email,password,name,surname,role) values 
('admin@gmail.com','$2y$10$WHV1bOXJTbMzrtZEIWO97.2ycbapSP0JweaAC1iP5luFC9wosSsk2','Admin','Test','admin'),
('oper@gmail.com','$2y$10$WHV1bOXJTbMzrtZEIWO97.2ycbapSP0JweaAC1iP5luFC9wosSsk2','Operater','Test','oper');

insert into product (name,price,description,quantity) values 
('Razer Mamba Elite', 50.00,'The Razer Mamba Elite is the iconic gaming mouse you know and love with the most Razer Chroma in our lineup—an impressive 20 lighting zones.',50),
('Razer BlackWidow',80.00,'Razer BlackWidow lets you experience full gaming immersion with Razer Chroma. It showcases up to 16.8 million colors in varying effects such as Spectrum Cycling.',40);

insert into `order` (order_date,buyer) values 
('2021-06-18 01:22:09',2);

insert into product_order (`order`,product,quantity) values 
(1,2,3);
