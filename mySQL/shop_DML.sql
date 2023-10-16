use shop

show tables

desc `member` 

insert into member values ('melon', '1234', 'melon', '010')

select * from member

select tel, name from member where id = 'apple'

insert into member
values ('computer', '1234', 'com', null)

insert into member(id, pw, name)
values ('com2', '1111', 'com2')

insert into `member`
values ('ice2', '1234', 'ice2', '010', now())

delete from bbs

select * from bbs

insert into bbs
values (null, 'db', 'fun db', 'apple')

delete from `member` 

use shop

create table productorder(
id varchar(100) primary key,
title varchar(100) unique,
price int,
buydate date,
addr varchar(100) default 'home' not null
)

insert into productorder(id, buydate, addr)
values('100', now(), 'office')

select * from productorder

insert into productorder(id, title, buydate)
values('200', 'hat', null)

insert into productorder(id, title, addr)
values('300', 'mouse', default)

insert into productorder
values ('400', 'shoes', 5000, now(), default)
