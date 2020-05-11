# CardOrderRestApp

Rest Api is create for order entry in table tb_order & tb_product.

# Query Used

create table tb_order(orderId int not null Auto_Increment, 
customerNo varchar(50)default null,
 orderCreatedDate  date default null,
primary key ( orderId )
);

create table  tb_product ( id  int not null Auto_increment,
 productNo  varchar(50) default null,
 p_name  varchar(50) default null,
 price  double default null,
 description  varchar(50) default null,
 quantity  int default null,
 orderId  int default null,
primary key ( id ),
FOREIGN KEY (orderId) REFERENCES tb_order(orderID)
);




