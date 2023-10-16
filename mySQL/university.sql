create database usniversity

use university

create table DEPT (
  DEPTNO INT,
  DNAME varchar(100),
  LOC varchar(100)
)

create table STUDENT (
  ID varchar(100),
  NAME varchar(100),
  TEL varchar(100),
  DEPTID INT,
  PROFESSORID varchar(100)
)

create table PROFESSOR (
  ID varchar(100),
  NAME varchar(100),
  TEL varchar(100),	
  DEPTID INT,
  ADDR varchar(100),
  ROOMNO varchar(100)
)

create table EMP (
  EMPNO INT,
  ENAME varchar(100),
  JOB varchar(100),
  MGR INT,
  HIREDATE DATE,
  SAL INT,
  COMM INT,
  DEPTNO INT
)

create table depart2 (
id varchar(100) primary key,
name varchar(100),
instructor varchar(100)
)

create table student2 (
id varchar(100) primary key,
name varchar(100),
tel varchar(100),
depart_id varchar(100)
)

alter table university.student2 
add constraint student2_FK foreign key (depart_id) references university.depart2(id)

drop table student2 

drop table depart2 

show tables

desc depart2 

ALTER TABLE university.dept ADD CONSTRAINT dept_pk PRIMARY KEY (DEPTNO);

ALTER TABLE university.student ADD CONSTRAINT STUDENT_pk PRIMARY KEY (ID);

ALTER TABLE university.professor ADD CONSTRAINT PROFESSOR_pk PRIMARY KEY (ID);

ALTER TABLE university.emp ADD CONSTRAINT EMP_pk PRIMARY KEY (EMPNO);

ALTER TABLE university.student ADD CONSTRAINT student_FK FOREIGN KEY (DEPTID) REFERENCES university.dept(DEPTNO);

ALTER TABLE university.professor ADD CONSTRAINT PROFFESOR_FK FOREIGN KEY (DEPTID) REFERENCES university.dept(DEPTNO);

ALTER TABLE university.emp ADD CONSTRAINT EMP_FK FOREIGN KEY (DEPTNO) REFERENCES university.dept(DEPTNO);


insert into dept values
(101, 'ABC', 'EAST'),
(102, 'XYZ', 'WEST')


insert into student values
('apple', 'apple', '011', 101, '1023001'),
('banana', 'banana', '012', 102, '1023002')

insert into professor values
('coconut', 'coconut', '014', 101, 'seoul', '1003'),
('cherry', 'cherry', '015', 102, 'busan', '1004')

insert into emp values
(1, 'ice', 'manager', 1, '2023-10-16', 1000000, 1, 101),
(2, 'cherry', 'assistant', 2, '2023-09-16', 2000000, 2, 102)




select * from dept

select * from student

select * from professor

select * from EMP



-- DDL 생성

-- university.dept definition

-- CREATE TABLE `dept` (
--   `DEPTNO` int NOT NULL,
--   `DNAME` varchar(100) DEFAULT NULL,
--   `LOC` varchar(100) DEFAULT NULL,
--   PRIMARY KEY (`DEPTNO`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- university.emp definition

-- CREATE TABLE `emp` (
--   `EMPNO` int NOT NULL,
--   `ENAME` varchar(100) DEFAULT NULL,
--   `JOB` varchar(100) DEFAULT NULL,
--   `MGR` int DEFAULT NULL,
--   `HIREDATE` date DEFAULT NULL,
--   `SAL` int DEFAULT NULL,
--   `COMM` int DEFAULT NULL,
--   `DEPTNO` int DEFAULT NULL,
--   PRIMARY KEY (`EMPNO`),
--   KEY `EMP_FK` (`DEPTNO`),
--   CONSTRAINT `EMP_FK` FOREIGN KEY (`DEPTNO`) REFERENCES `dept` (`DEPTNO`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- university.professor definition

-- CREATE TABLE `professor` (
--   `ID` varchar(100) NOT NULL,
--   `NAME` varchar(100) DEFAULT NULL,
--   `TEL` varchar(100) DEFAULT NULL,
--   `DEPTID` int DEFAULT NULL,
--   `ADDR` varchar(100) DEFAULT NULL,
--   `ROOMNO` varchar(100) DEFAULT NULL,
--   PRIMARY KEY (`ID`),
--   KEY `PROFFESOR_FK` (`DEPTID`),
--   CONSTRAINT `PROFFESOR_FK` FOREIGN KEY (`DEPTID`) REFERENCES `dept` (`DEPTNO`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- university.student definition

-- CREATE TABLE `student` (
--   `ID` varchar(100) NOT NULL,
--   `NAME` varchar(100) DEFAULT NULL,
--   `TEL` varchar(100) DEFAULT NULL,
--   `DEPTID` int DEFAULT NULL,
--   `PROFESSORID` varchar(100) DEFAULT NULL,
--   PRIMARY KEY (`ID`),
--   KEY `student_FK` (`DEPTID`),
--   CONSTRAINT `student_FK` FOREIGN KEY (`DEPTID`) REFERENCES `dept` (`DEPTNO`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
