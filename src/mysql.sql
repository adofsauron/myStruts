create database bank;  //������Ϊbank�����ݿ�

//����user��
create table user
(
	id 			int				auto_increment,
	name 		varchar(20) 	not null,
	password 	varchar(20) 	not null,
	tel 		varchar(11) 	not null,
	email 		varchar(50) 	not null,	
	
	primary key(id)
)DEFAULT CHARSET=utf8;