-- book, checkq, shop, shop2, sys

-- db > table > 항목(field, item, property, attribute)

-- shop을 선택 후, SQL 버튼 클릭한 경우, shop이 이미 선택된 것.

-- create table a ==> shop db에 만들어짐

-- 다른 db를 사용하고 싶은 경우

-- use shop2

-- create table b ==> shop2 db에 만들어짐

-- DCL : create, alter, drop

-- id : summer3 / pw : 1234 사용자 생성하기

create user 'summer3'@'localhost' identified by '1234'

-- db명.테이블명 ==> *.* ==> 모든db.모든테이블

grant all privileges on *.* to 'summer3'@'localhost'

-- apple / 1234

create user 'apple'@'localhost' identified by '1234'

grant all privileges on *.* to 'apple'@'localhost'

