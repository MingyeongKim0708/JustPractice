-- 설명/comments

-- 1. DB생성 : ctrl + enter

create database shop2

use shop2 -- shop2 db 선택

-- 2. table 생성 : 항목명 결정

create table member (
	id varchar(100),
	pw varchar(100),
	name varchar(100),
	tel varchar(100)
)

-- Data Definition Language (DDL)
-- 여기까지는 데이터를 어떤 것을 저장할지 정의하는 문법

-- 아래는 데이터를 어떻게 할지 조작하는 문법
-- Data Manipulation Language (DML)

-- 3. data 넣어보고, 수정/검색/삭제
-- varchar == String
-- 데이터 삽입

insert into member values ('100', '100', 'park', '011')

insert into member values ('200', '200', 'park', '011')

insert into member values ('300', '300', 'park', '011')

insert into member values ('200', '200', 'park', '000')

-- 데이터 수정

update member set tel = '999' where id = '100'

update member set name = 'hong' where id = '200'

-- 데이터 검색
-- ,,적은 순서대로 검색됨

select * from member

select id, tel, name from member

-- 데이터 삭제
-- 조건에서 and, or

delete from member where id = '100'

delete from member where id = '200' and tel = '000'
