-- DML : insert, update, delete (데이터 삽입, 수정, 삭제)

-- insert into table_name values (value1, value2, ...) -> 모든 컬럼에 추가 (컬럼 순서에 맞게 데이터 삽입)
-- insert into table_name (column_name1, column_name2, ...) values (value1, value2, ...) -> 컬럼 선택하여 데이터 추가
INSERT INTO user VALUES('park', '박길동');
INSERT INTO user (id, NAME) VALUES ('kong', '공길동');
INSERT INTO user (NAME, id) VALUES ('공길동', 'kong');

-- article 데이터 삽입
-- 1. 'title1', 'content1'
INSERT INTO article (title, content) VALUES ('title1', 'content1');
INSERT INTO article VALUES (NULL, 'title1', 'content1', NULL);
-- 2. 'title2'
INSERT INTO article (title) VALUES ('title2');
-- 3. 'content2'
INSERT INTO article (content) VALUES ('content2');
-- 4. 'title3', 'content3', 'hong'
INSERT INTO user VALUES ('hong', '홍길동');
INSERT INTO article (title, content, writer) VALUES ('title3', 'content3', 'hong');
INSERT INTO article VALUES (NULL, 'title3', 'content3', 'hong');
-- 5. 'title4', 'cha'
INSERT INTO user VALUES ('cha', '차길동');
INSERT INTO article (title, writer) VALUES ('title4', 'cha');
-- 6. 'content5', 'park'
INSERT INTO user VALUES ('park', '박길동');
INSERT INTO article (content, writer) VALUES ('content5', 'park');

-- emp 데이터 삽입
-- 사번 9999, 이름 hong, 담당업무 salesman, 담당매니저 7369, 입사일 오늘, 급여 1800, 부서번호 40
INSERT INTO emp VALUES (9999, 'hong', 'SALESMAN', 7369, CURDATE(), 1800, NULL, 40);

CREATE TABLE emp_sub (
	id INT,
	NAME VARCHAR(30)
);

-- insert into select : select의 결과값을 테이블에 삽입
INSERT INTO emp_sub (id, NAME) 
SELECT empno, ename FROM emp WHERE deptno = 10;

-- update table_name set column_name1 = value1, column_name2 = value2, ... where 조건;
-- emp에서 hang이 담당업무가 CLERK로 변경, 담당매니저가 7782로 변경
UPDATE emp SET job = 'CLERK', mgr = 7782 WHERE ename='hong';

-- emp에서 커미션이 없는 사람은 100을 준다
UPDATE emp SET comm = 100 WHERE comm IS NULL OR comm = 0;

-- deptno이 10인 부서만 comm을 급여의 10% 더 준다
UPDATE emp SET comm = comm+sal*0.1 WHERE deptno = 10;

-- SMITH와 같은 업무를 담당하는 사람들의 급여를 30% 인상
UPDATE emp SET sal = sal*1.3 WHERE job = (SELECT job FROM emp WHERE ename = 'SMITH');

-- delete from table_name where 조건;
-- emp에서 이름이 hong인 데이터 삭제
DELETE FROM emp WHERE ename = 'hong';

-- emp에서 부서번호가 40인 데이터 삭제
DELETE FROM emp WHERE deptno = 40;

-- transaction 여러 명령을 하나하나 실행하여 rollback을 통해 되돌리기, commit을 통해 최종 저장이 가능하다
-- INSERT INTO emp (empno, deptno) VALUES (8988, 40);
START TRANSACTION;
DELETE FROM emp WHERE deptno=40;
ROLLBACK;
COMMIT;
