-- 설명/comments

-- 1. DB생성 : ctrl + enter

create database book

use book 

-- 2. table 생성 : 항목명 결정

-- TOP10

create table book (
	id varchar(100),
	category varchar(100),
	name varchar(100),
	writer varchar(100),
	pub varchar(100),
	issue varchar(100)
)

-- 신간

create table newbook (
	id varchar(100),
	category varchar(100),
	name varchar(100),
	writer varchar(100),
	pub varchar(100),
	issue varchar(100)
)


-- Data Definition Language (DDL)
-- 여기까지는 데이터를 어떤 것을 저장할지 정의하는 문법

-- 아래는 데이터를 어떻게 할지 조작하는 문법
-- Data Manipulation Language (DML)

-- 3. data 넣어보고, 수정/검색/삭제
-- varchar == String
-- 데이터 삽입

insert into book values
('001', '경제/경영', '트렌드 코리아 2024', '김난도,전미영,최지혜,이수진,권정윤,한다혜,이준영,이향은,이혜원,추예린,전다현', '미래의창', '2023.10.12'),
('002', '자기계발', '퓨처 셀프', '벤저민 하디', '상상스퀘어', '2023.08.30'),
('003', '경제/경영', '시대예보: 핵개인의 시대', '송길영', '교보문고', '2023.09.25'),
('004', '소설', '도시와 그 불확실한 벽', '무라카미 하루키', '문학동네', '2023.08.30'),
('005', '자기계발', '세이노의 가르침', '세이노', '데이원', '2023.03.02'),
('006', '수험서/자격증', '2023 하반기 해커스 GSAT 삼성직무적성검사 실전모의고사 10회분', '해커스 GSAT 취업교육연구소', '해커스잡', '2023.08.18'),
('007', '인문', '도둑맞은 집중력', '요한 하리', '어크로스', '2023.04.28'),
('008', '수험서/자격증', '2023 하반기 해커스 GSAT 삼성직무적성검사 통합 기본서 최신기출유형+실전모의고사', '해커스 GSAT 취업교육연구소', '챔프스터디', '2023.08.01'),
('009', '어린이', '흔한 남매 14', '흔한남매,백난도', '미래엔아이세움', '2023.09.21'),
('010', '소설', '아침 그리고 저녁', '욘 포세', '문학동네', '2019.07.26')

insert into newbook values
('101', '외국도서', '[대만판] 불편한 편의점 2 不便利的便利店 2', '김호연', '적막출판사', '2023.10.10'),
('102', '국어/외국어', '뉴스 영어의 결정적 심화 표현들', '박종홍', '사람in', '2023.10.04'),
('103', '자연과학', '잠 못들 정도로 재미있는 이야기: 신장', '고즈키 마사히로', '성안당', '2023.09.13'),
('104', '자기계발', '비즈니스 협상론', '김병국', '알에이치코리아', '2023.09.18')

-- 검색

select * from book -- 데이터 전체 검색

select * from newbook -- 데이터 전체 검색

select name, category from book where id = '002' or id = '003' -- 002번, 003번의 제목, 카테고리 검색

select name, category, writer from newbook where id = '101' -- 101번의 제목, 카테고리, 저자 검색

-- 데이터 수정

update book set writer = '박경희' where id = '010'

update newbook set category = '외국어' where name = '뉴스 영어의 결정적 심화 표현들'



-- 데이터 삭제. 조건에서 and, or

delete from book where id = '009'

delete from book where category = '소설'

delete from newbook where pub = '알에이치코리아'
