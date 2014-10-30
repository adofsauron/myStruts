create database bank;  //创建名为bank的数据库

//创建user表
create table user
(
	id 			int				auto_increment,
	name 		varchar(20) 	not null,
	password 	varchar(20) 	not null,
	tel 		varchar(11) 	not null,
	email 		varchar(50) 	not null,	
	
	primary key(id)
)DEFAULT CHARSET=utf8;