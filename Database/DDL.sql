-- DDL (Data Definition Language)
-- CREATE, ATLER, TRUNCATE, DROP

-- DML (Data Manipulation Language)
-- INSERT, UPDATE, DELETE, MERGE

-- DCL (Data Control Language)
-- GRANT, REVOKE

-- TCL (Transaction Control Language)
-- COMMIT, ROLLBACK

-- DQL (Data Query Language)
-- SELECT

CREATE DATABASE kotest; -- db 생성
DROP DATABASE kotest; -- db 삭제

CREATE TABLE person(
	NAME VARCHAR(100) NOT NULL,
	age INT DEFAULT 0,
	address VARCHAR(100),
	email VARCHAR(100) PRIMARY KEY,
	birthday DATE
);

DROP TABLE person;

-- emp 테이블 생성
CREATE TABLE EMP ( 
  EMPNO     int, 
  ENAME     VARCHAR(30), 
  JOB       VARCHAR(20), 
  MGR       int, 
  HIREDATE  DATE, 
  SAL       int,
  COMM      int, 
  DEPTNO    int) DEFAULT CHARSET=UTF8;

insert into emp values (7369,'SMITH','CLERK',7902,'1980-12-17',800,null,20);
insert into emp values (7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);
insert into emp values (7521,'WARD','SALESMAN',7698,'1982-02-22',1250,500,30);
insert into emp values (7566,'JONES','MANAGER',7839,'1981-04-02',2975,null,20);
insert into emp values (7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,1400,30);
insert into emp values (7698,'BLAKE','MANAGER',7839,'1981-05-01',2850,null,30);
insert into emp values (7782,'CLARK','MANAGER',7839,'1981-06-09',2450,null,10);
insert into emp values (7788,'SCOTT','ANALYST',7566,'1987-04-17',3000,null,20);
insert into emp values (7839,'KING','PRESIDENT',null,'1981-11-17',5000,null,10);
insert into emp values (7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);
insert into emp values (7876,'ADAMS','CLERK',7788,'1987-05-23',1100,null,20);
insert into emp values (7900,'JAMES','CLERK',7698,'1981-12-03',950,null,30);
insert into emp values (7902,'FORD','ANALYST',7566,'1981-12-03',3000,null,20);
insert into emp values (7934,'MILLER','CLERK',7782,'1982-01-23',1300,null,10);

CREATE UNIQUE INDEX PK_EMP ON EMP (EMPNO) ;
ALTER TABLE EMP ADD  CONSTRAINT PK_EMP PRIMARY KEY (EMPNO);

-- 조건에 만족하는 데이터를 추출하여 테이블 복사
CREATE TABLE emp_sub AS
SELECT empno, ename, job, HIREDATE, sal FROM emp WHERE deptno=10;

-- 테이블을 생성할 때 데이터를 삽입하지 않고 테이블 구조만 복사
CREATE TABLE emp_t AS
SELECT * FROM emp WHERE 1=2;

CREATE TABLE persons (
	id INT,
	last_name VARCHAR(255),
	first_name VARCHAR(255),
	address VARCHAR(255),
	city VARCHAR(200)
);

-- add column 테이블에 컬럼 추가
ALTER TABLE persons ADD email VARCHAR(255);
ALTER TABLE emp_sub ADD deptno int DEFAULT 10; -- default값 설정

-- modify column 테이블의 컬럼 정보 변경
ALTER TABLE persons MODIFY COLUMN city VARCHAR(255); -- 컬럼 타입 변경
ALTER TABLE emp_sub RENAME COLUMN deptno TO dcode; -- 컬럼명 변경

-- drop column 테이블의 컬럼 삭제
ALTER TABLE persons DROP COLUMN email;

-- rename table 테이블명 변경
RENAME TABLE emp_sub TO emp_10;

-- truncate table 비우기 
SELECT * FROM emp_10;
TRUNCATE TABLE emp_10;

-- delete
DELETE FROM emp;