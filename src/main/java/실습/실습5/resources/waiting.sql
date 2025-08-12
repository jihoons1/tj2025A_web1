drop database if exists waiting0812;
create database waiting0812;
use waiting0812;

create table waiting(
	num int auto_increment,
    phone varchar(20) not null,
    count int not null,
    constraint primary key(num)
	);
    
insert into waiting (phone, count) values ('010-1234-5678', 5);
insert into waiting (phone, count) values ('010-1111-2222', 2);
insert into waiting (phone, count) values ('010-3333-4444', 4);
insert into waiting (phone, count) values ('010-5555-6666', 1);
insert into waiting (phone, count) values ('010-7777-8888', 3);
insert into waiting (phone, count) values ('010-9999-0000', 6);
insert into waiting (phone, count) values ('010-2222-3333', 2);
insert into waiting (phone, count) values ('010-4444-5555', 5);
insert into waiting (phone, count) values ('010-6666-7777', 4);
insert into waiting (phone, count) values ('010-8888-9999', 1);

select * from waiting;