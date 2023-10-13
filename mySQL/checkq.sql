-- ERD 엔티티 관계도
-- sql 문에서 alt + enter ==> 경로 확인 가능

-- SQL (Structured Query Language, 체계적으로 정리된 명령문의 모음)
-- 명령어의 역할에 따라 DDL, DML, DCL 그리고 TCL로 나뉨
-- DCL (Data Control Language, DBMS 제어(계정관리, 백업/복원), grant / revoke / backup / restore ==> 잘 안씀)
-- TCL (Transaction Control Language, 트랜잭션 제어, commit / rollback ==> 잘 안씀)

-- DDL (Data Definition Language, 데이터 항목 정의, create / alter / drop / truncate)

create database checkq

use checkq

create table hobby (
hobbyid varchar(100),
content varchar(100),
location varchar(100)
)

create table hobby2 (
hobbyid varchar(100),
content varchar(100),
location varchar(100)
)

create table movie (
id varchar(100),
title varchar(100),
content varchar(100),
actor varchar(100)
)

create table place (
id varchar(100),
name varchar(100),
addr varchar(100),
tel varchar(100)
)

-- DML (Data Manipulation Language, 데이터 조작, insert / select / update / delete ==> CRUD)

insert into hobby values
('100', 'run', 'seoul'),
('200', 'book', 'busan')

insert into movie values
('m1', '블랙아담', '액션', '드웨인 존슨'),
('m2', '리멤버', '드라마', '남주혁'),
('m3', '자백', '스릴러', '소지섭')

insert into place values
('p1', 'cgv', '강남구 삼성동', '02-555'),
('p2', 'megabox', '강남구 역삼동', '02-666'),
('p3', 'lotte', '강남구 대치동', '02-777')


select * from hobby

select content from hobby

select location, content from hobby

select * from movie

select * from place


update movie set content = '스릴러' where id = 'm1'

update place set tel = '02-888' where name = 'lotte'


delete from movie where id = 'm1'

delete from place where id = 'p3'

delete from movie -- DML

delete from place -- DML

drop table movie -- DDL
