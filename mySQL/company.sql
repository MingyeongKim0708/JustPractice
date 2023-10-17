use company

CREATE TABLE SALGRADE
(
  GRADE  int primary key,
  LOSAL  int,
  HISAL  int
)

-- 부서

CREATE TABLE DEPT
(
  DEPTNO  int primary key,
  DNAME   VARCHAR(100),
  LOC     VARCHAR(100)
)

CREATE TABLE EMP
(
  EMPNO     int primary key,
  ENAME     VARCHAR(100),
  JOB       VARCHAR(100),
  MGR       int,
  HIREDATE  DATE,
  SAL       decimal(7,2),
  COMM      decimal(7,2),
  DEPTNO    int
)

desc emp

-- 파일이 저장되는 위치를 알고 싶으면 alt + enter

select * from emp -- select 컬럼명(열이름), * ==> all columns

select empno from emp 

select hiredate from emp
where deptno = 10 -- = 동일연산자

select DISTINCT DEPTNO from EMP -- DISTINCT 중복제거

-- sql은 대소문자를 구분하지 않음
-- 내부적으로 처리할 때 모두 대문자로 변경해서 실행하기 때문
-- oracle에서는 대문자로 변경해서 실행 --> 버그
-- oracle에서는 모두 대문자로 쓰기 권장

select ename, sal * 12 as '연봉' from emp

select * from emp
order by sal -- 작-->큰 (오름차순) asc = ascending 생략 가능

select * from emp
order by sal desc -- 큰-->작 (내림차순) desc = descending

select * from emp
where job = 'MANAGER' -- 조건. 컬럼명, 문법은 대소문자 상관 X. '인스턴스'는 우리가 넣은 것이기 때문에 대소문자 구분 O
order by sal desc -- 정렬은 마지막에 한다

select * from emp e 
where DEPTNO = 30

select * from emp e 
where NOT DEPTNO = 30

select * from emp e 
where DEPTNO = 30 and JOB = 'SALESMAN'

select * from emp e 
where DEPTNO = 30 or JOB = 'SALESMAN'

select * from emp e 
where SAL >= 3000

select * from emp e 
where SAL != 3000

select distinct JOB from EMP -- 중복제거하면 종류를 알 수 있음

select * from emp e
where JOB = 'CLERK' OR JOB = 'SALESMAN' or JOB = 'MANAGER'

select * from emp e
where JOB in ('CLERK', 'SALESMAN', 'MANAGER')

-- EMP를 E, DEPTNO를 D로 정함

select E.EMPNO, D.DEPTNO from EMP E, DEPT D
where JOB in ('CLERK', 'SALESMAN', 'MANAGER')

select * from emp e
where JOB not in ('CLERK', 'SALESMAN', 'MANAGER')

select * from emp e
where SAL between 2000 and 3000 -- 사이값

select * from emp e 
where ENAME like '_L%' -- L앞에 한글자, L뒤에는 글자수상관X

select * from emp e 
where ENAME not like '%AM%'

select * from emp e 
where COMM is null 



-- shop2.product3 definition
CREATE TABLE `product3` (
  `id` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `company` varchar(100) DEFAULT NULL,
  `img` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- PPT Oracle 2 p.64
-- 1. price= number(oracle), int(mysql)
-- 2. price로 내림차순 정렬하여 전체컬럼 검색

select * from product3 p 
order by price desc

-- 3. company로 오름차순 정렬하여 제품의 이름, 내용, 가격 검색

select name, content, price from product3 p 
order by company 

-- 4. company의 목록을 검색(중복제거)

select distinct company from product3 p 

-- 5. 각 신발을 5개씩 주문했을 때의 가격을 price5라고 항목명을 지정하여 출력

select name, price * 5 as price5 from product3 p 


-- 6. price가 5000인 제품명과 회사명

select name, company from product3 p
where price = 5000

-- 7. price가 3000와 6000사이인 제품명과 가격, 회사명 검색
select name, company, price from product3 p
where price between 3000 and 6000

-- 8. 회사명이 c100이 아닌 회사명과 제품명

select company, name from product3 p 
where company != 'c100'

-- 9. 회사명이 c100, c200인 제품명과 가격

select name, price from product3 p 
where company in ('c100', 'c200')

-- 10. 제품명에 4로 끝나는 제품의 전체 정보 검색

select * from product3 p 
where name like '%4'

-- 11. 제품내용에 food를 포함하는 제품의 전체 정보 검색

select * from product3 p 
where content like '%food%'

-- 12. price가 5000원인 제품의 content를 품절로 수정

select * from product3 p 

update product3 set content = '품절' where price = 5000

-- 13. id가 100, 102번 제품의 img를 o.png로, price를 10000으로 수정

update product3 set img = 'o.png', price = 10000 where id = 100 or id = 102


-- 14. 회사명이 c100인 경우 모든 정보 삭제

delete from product3
where company = 'c100'

-- 15. 테이블의 모든 정보 삭제

delete from product3 -- data 삭제

drop table product3 -- table 삭제 (스키마+데이터)

select * from product3 p 


-- PPT Oracle 2 p.49
-- 1.price로 내림차순 정렬하여 전체컬럼 검색

select * from product3 p 
order by price desc

-- 2.company로 오름차순 정렬하여 제품의 이름, 내용, 가격 검색

select name, content, price from product3 p 
order by company 

-- 3.id가 100인 제품의 이름과 가격 검색

select name, price from product3 p 
where id = 100

-- 4.price가 5000인 제품명과 회사명
select name, company from product3 p 
where price = 5000

-- 5.id가 100이고 가격이 1000인 제품명과 이미지 검색
select name, img from product3 p 
where id = 100 and price = 1000

-- 6.회사명이 c100인 회사명과 제품명
select company, name from product3 p 
where company = 'c100'

-- 7.회사명이 c100, c200인 제품명과 가격
select name, company from product3 p 
where company in ('c100', 'c200')

-- 8.price가 5000원인 제품의 content를 품절로 수정

update product3 set content = '품절'
where price = 5000

select * from product3 p 

-- 9.id가 100, 102번 제품의 img를 o.png로, price를 10000으로 수정

update product3 set img = 'o.png', price = 10000
where id = 100

select * from product3 p 

-- 10.id가 101번 제품의 company를 apple, name은 appleshoes로 수정

update product3 set company = 'apple', name = 'appleshoes'
where id = 101

select * from product3 p 


-- 11.name이 food1이거나 id가 107인 제품 삭제
delete from product3 
where name = 'food1' or id = 107

select * from product3 p 


-- 12.회사명이 c100인 경우 모든 정보 삭제
delete from product3 
where company = 'c100'

select * from product3 p 


-- 13.테이블의 모든 정보 삭제

delete from product3 

select * from product3 p 

-- 14.테이블 삭제

drop table product3 

show databases

desc company -- 아무것도 없다고 뜸


CREATE TABLE `product3` (
  `id` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `company` varchar(100) DEFAULT NULL,
  `img` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- PPT 04 Oracle


select * from emp

select CONCAT(empno, ename) as 붙인글자 from emp

select length(ename) as 사람이름글자수 from emp e 

select replace(ename, 'E', 'AAA') from emp

select now()

select now(),
year(now()) as 년,
month(now()) as 월,
hour(now()) as 시, 
minute(now()) as 분, 
second(now()) as 초

select SAL+COMM from emp

select SAL, COMM, SAL+COMM from EMP

-- null을 이용해서 연산을 하면 연산결과가 이상하게 나올 수 있다.
-- null을 0으로 미리 변경하기. --> update

update EMP set COMM = 0 where COMM is null 

select SAL, COMM, SAL+COMM from EMP

select concat(ename, job) from emp

update emp set ename = null
where empno = 7499

update emp set ename = ''
where ename is null

update EMP set COMM = null where COMM = 0

-- 1. ENAME의 글자수 검색

select length(ename) as 사람이름글자수 from emp e 

-- 2. JOB이 MANAGER인 사람의 ENAME 글자수 검색
select ENAME, length(ename) as 사람이름글자수 from emp e 
where JOB = 'MANAGER'

-- 3. COMM이 null인 사람의 ENAME, JOB 검색

select ENAME, JOB from emp e 
where COMM is null

-- 4. COMM이 null이 아닌 사람의 HIREDATE 검색

select HIREDATE from emp e 
where COMM is not NULL

-- 5. ENAME의 2번째글자부터 끝까지 검색

select substr(ENAME, 2) from emp e 


-- 6. JOB의 1번째 글자부터 3번째 글자까지 검색

select substr(ENAME, 1, 3) from emp e 

-- 7. ENAME의 글자 중 K를 P으로 변경하여 검색

select replace(ENAME, 'K', 'P') from EMP

select * from EMP

-- 8. ENAME과 EMPNO을 이용하여 '7369번은 SMITH입니다'로 출력

select concat(EMPNO, '번은 ' ,ENAME, '입니다') from EMP 

-- 9. HIREDATE 이용하여 입사한 월과 요일을 출력

select MONTH(HIREDATE), DAYNAME(HIREDATE) from EMP

-- 10. JOB이| MANAGER이면 level1, SALESMAN이면 level2, 기타이면 level3라고 LEVEL_RESULT컬럼에 출력

select 
case JOB
when 'MANAGER' then 'LEVEL1'
when 'SALESMAN' then 'LEVEL2'
ELSE 'LEVEL3'
end as LEVEL_RESULT
from emp e 

select * from emp

select job, count(SAL), sum(sal), round(avg(sal)), min(sal), max(sal)
from emp e 
group by job


-- 조건 having

select job, count(SAL), sum(sal), round(avg(sal)), min(sal), max(sal)
from emp e 
group by job
having count(sal) >= 4 
order by job desc


-- 집계/그룹함수 정리 문제
-- PPT ORACLE 4 P.32

select * from emp

-- 1.전체 직원수 출력

select count(empno) as 직원수 from emp

-- 2.DEPTNO가 20이거나 MGR이 7700이하인 직원수 출력

select count(empno) as 직원수
from emp
where deptno = 20 or mgr <= 7700

-- 3.DEPTNO가 10 또는 20인 직원의 SAL최저 출력

select min(sal)
from emp e
where deptno = 10 or deptno = 20


-- 4.직원의 SAL 최저, 최고, 합계 출력
select min(sal), max(sal), sum(sal)
from emp e 


-- 5.DEPTNO별 SAL 평균 출력 --> group by

select deptno, avg(sal), max(sal), min(sal)
from emp e 
group by deptno

-- 6.DEPTNO별 SAL 합계를 DEPTNO 오름차순으로 출력

select deptno, sum(sal)
from emp e 
group by DEPTNO 
order by DEPTNO 


-- 7.DEPTNO별 SAL 평균이 2000이상인 SAL평균을 DEPTNO역순으로 출력 - 내림차순

select deptno, avg(sal)
from emp e 
group by deptno
having avg(sal) >= 2000
order by deptno desc


-- 8.JOB이 MANAGER인 직원의 전체 수, 월급의 평균 검색

select count(DEPTNO), avg(sal)
from emp e 
where job = 'MANAGER'

-- 9.ENAME에 S를 포함하는 직원의 전체 수를 검색

select COUNT(DEPTNO)
from emp e 
where ENAME like '%S%'

-- 10 SAL이 3000이상이고, COMM이 0이 아닌 직원의 전체 수 검색, SAL의 역순으로 출력
update emp set COMM = '0' where COMM is null

select COUNT(DEPTNO) as DEPT_COUNT
from emp e 
where SAL >= 3000 and COMM != 0
order by SAL desc



-- JOIN : 2개 이상의 테이블을 합해서 검색하는 것
-- INNER JOIN 특정 컬럼을 기준으로 테이블을 합함. 조인 조건이 공통적인 것만 검색

select * 
from dept d, emp e 
where D.DEPTNO = E.DEPTNO 

-- SELECT 테이블1.컬럼, 테이블2.컬럼 : 원하는 컬럼만 선택해서 검색

select D.DEPTNO,  D.DNAME , E.ENAME, E.JOB
from dept d, emp e 
where D.DEPTNO = E.DEPTNO 

-- OUTER JOIN. 한쪽은 다 보이게 하고 다른 한 쪽은 일치하는 것만
-- LEFT JOIN

select D.DEPTNO,  D.DNAME , E.ENAME, E.JOB
from dept d
left outer join emp e 
ON (D.DEPTNO = E.DEPTNO) 

-- RIGHT JOIN
select D.DEPTNO,  D.DNAME , E.ENAME, E.JOB
from dept d
RIGHT outer join emp e 
ON (D.DEPTNO = E.DEPTNO) 


-- SELF JOIN
-- EMPNO, ENAME, <-의 관리자(mgr NAME), MGR SAL

select E.EMPNO, E.ENAME, E2.ENAME, E2.SAL
from emp e, emp e2 
where E.MGR = E2.EMPNO 

select * from EMP



-- UNION (집합)
-- 컬럼의 개수가 다르면 집합으로 만들 수 없다
use COMPANY

select *
from emp e 
WHERE DEPTNO = 10
union 
select *
from EMP 
where DEPTNO = 20



select *
from emp e 
intersect 
select *
from EMP 
where DEPTNO = 20
