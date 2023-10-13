use shop2 -- shop2 db 선택

-- product3테이블을 sql문으로 만들어보세요.

create table product3 (
	id varchar(100),
	name varchar(100),
	content varchar(100),
	price int,
	company varchar(100),
	img varchar(100)
)

-- 데이터를 넣어보세요.
insert into product3 values
('100', 'shoes1', 'fun shoes1', 1000, 'c100', '1.png'),
('101', 'shoes2', 'fun shoes1', 2000, 'c100', '2.png'),
('102', 'shoes3', 'fun shoes1', 3000, 'c100', '3.png'),
('103', 'shoes4', 'fun shoes1', 4000, 'c100', '4.png'),
('104', 'shoes5', 'fun shoes1', 4000, 'c100', '5.png'),
('105', 'shoes6', 'fun shoes1', 4000, 'c100', '6.png'),
('106', 'shoes7', 'fun shoes1', 4000, 'c100', '7.png'),
('107', 'shoes8', 'fun shoes1', 4000, 'c100', '8.png')

-- 테이블 전체 검색

select * from product3

-- id가 100인 name과 content를 검색

select name, content from product3 where id = '100'

-- id가 102인 제품의 가격을 검색

select price from product3 where id = '102'

-- name가 shoes1인 제품의 가격을 5000으로 수정

update product3 set price = 5000 where name = 'shoes1'

-- name이 shoes2인 제품의 company를 c555로 수정

update product3 set company = 'c555' where name = 'shoes2'

-- id가 103인 제품의 name을 fun으로, price를 9999로 수정

update product3 set name = 'fun', price = 9999  where id = '103'

--  id가 101인 제품 삭제

delete from product3 where id = '101'

-- 가격이 3000이거나 img가 4.png인 제품 삭제

delete from product3 where price = 3000 or img = '4.png'

-- 전체 데이터 삭제후 검색하여 확인

delete from product3

select * from product3
