-- join

-- -------------------------------------------------
-- CREATE TABLE test1 (
-- A VARCHAR(10),
-- B VARCHAR(20));
-- 
-- CREATE TABLE test2(
-- A VARCHAR(10),
-- C VARCHAR(20),
-- D VARCHAR(20));

-- INSERT INTO test1 VALUES('a1', 'b1');
-- INSERT INTO test1 VALUES('a2', 'b2');
-- 
-- INSERT INTO test2 VALUES('a3', 'c3', 'd3');
-- INSERT INTO test2 VALUES('a4', 'c4', 'd4');
-- INSERT INTO test2 VALUES('a5', 'c5', 'd5');
-- -------------------------------------------------


-- test1 * test2 모든 가능한 조합으로 나타남 (n*m) (== cross join)
SELECT t1.*, t2.* FROM test1 t1, test2 t2; 
SELECT t1.A, t2.A, t2.C FROM test1 t1, test2 t2 WHERE t1.A = 'a1'; 

SELECT e.empno, e.ename, d.dname
FROM emp e CROSS JOIN dept d;
WHERE e.deptno = d.deptno;

-- ANSI join (표준 조인)
SELECT e.empno, e.ename, d.dname
FROM emp e INNER JOIN dept d;

ON e.deptno = d.deptno;

-- student, department 테이블을 이용하여 학번, 학생명, 제1학과명 조회
SELECT s.studno 학번, s.name 학생명, d.dname 제1학과명
FROM student s INNER JOIN department d
WHERE s.deptno1 = d.deptno;

-- student, professor 테이블을 이용하여, 학번, 학생명, 담당교수명을 조회
SELECT s.studno 학번, s.name 학생명, p.name 담당교수명
FROM student s LEFT JOIN professor p
ON s.profno = p.profno;

SELECT s.studno 학번, s.name 학생명, p.name 담당교수명
FROM student s RIGHT JOIN professor p
ON s.profno = p.profno;

-- union 
SELECT s.studno 학번, s.name 학생명, p.name 담당교수명
FROM student s LEFT JOIN professor p
ON s.profno = p.profno;
UNION
SELECT s.studno 학번, s.name 학생명, p.name 담당교수명
FROM student s RIGHT JOIN professor p
ON s.profno = p.profno;

-- student, department, professor 테이블을 이용하여 학번, 이름, 제1전공명, 담당교수명 조회
SELECT s.studno, s.name, d.dname, p.name
FROM student s, department d, professor p
WHERE s.deptno1 = d.deptno AND s.profno=p.profno;

SELECT s.studno, s.name, d.dname, p.name
FROM student s JOIN department d ON s.deptno1 = d.deptno 
LEFT JOIN professor p ON s.profno=p.profno;

-- student, exam_01 테이블을 이용하여 학번, 이름, 시험점수 조회
-- ANSI JOIN 사용
SELECT s.studno 학번, s.name 이름, e.total 시험점수
FROM student s, exam_01 e
WHERE s.studno = e.studno;

-- LEFT JOIN 사용 (학생 기준 조인)
SELECT s.studno 학번, s.name 이름, e.total 시험점수
FROM student s LEFT JOIN exam_01 e ON s.studno = e.studno
ORDER BY 3 DESC; -- 성적순 조회

-- student, exam_01, hakjum 테이블을 이용하여 학번, 이름, 시험점수, 학점 조회
SELECT s.studno, s.name, e.total, h.grade
FROM student s JOIN exam_01 e ON s.studno = e.studno
	JOIN hakjum h ON e.total BETWEEN h.min_point AND h.max_point;
	
SELECT s.studno, s.name, e.total, h.grade
FROM student s, exam_01 e, hakjum h
WHERE s.studno = e.studno AND (e.total BETWEEN h.min_point AND h.max_point);

-- gogak, gift 테이블을 이용하여 고객의 모든정보와, 고객이 본인의 포인터로 받을 수 있는 가장 좋은 상품 조회
SELECT go.*, gi.gname
FROM gogak go, gift gi
WHERE go.point BETWEEN gi.g_start AND gi.g_end;

SELECT go.*, gi.gname
FROM gogak go JOIN gift gi ON go.point BETWEEN gi.g_start AND gi.g_end;

-- emp2, p_grade 테이블을 이용하여 이름, 직위, 급여, 같은 직급의 최소/최대 급여 조회
SELECT e.name, e.pay, g.s_pay, g.e_pay
FROM emp2 e JOIN p_grade g
ON e.position = g.position;

-- emp2, p_grade 테이블을 이용하여 이름, 직위, 나이, 본인의 나이에 해당하는 예상 직급 조회
SELECT e.name, e.position, YEAR(CURDATE())-YEAR(e.birthday) age, g.position
FROM emp2 e JOIN p_grade g ON YEAR(CURDATE())-YEAR(e.birthday) BETWEEN g.s_age AND g.e_age;

-- gogak, gift 테이블을 이용하여 노트북을 받을 수 있는 고객의 이름, 포인트, 상품명 조회
SELECT go.gname, go.point, gi.gname
FROM gogak go, gift gi
WHERE gi.gname = '노트북' and go.point >= gi.g_start

SELECT go.gname, go.point, gi.gname
FROM gogak go JOIN gift gi ON go.point >= gi.g_start
WHERE gi.gname = '노트북';

-- self join : 자기자신과 join
-- dept2 테이블을 이용하여 부서의 모든 정보와 각 부서의 상위 부서명을 조회
SELECT d1.*, d2.pdept
FROM dept2 d1 LEFT JOIN dept2 d2 ON d1.PDEPT = d2.PDEPT;

-- emp 테이블을 이용하여 직원의 사번, 이름, 담당매니저 사번과 이름 조회
SELECT e.empno, e.ename, e.mgr, em.ename 
FROM emp e JOIN emp em ON e.MGR = em.EMPNO;

-- student, department 테이블을 이용하여 학번, 이름, 제1전공명, 제2전공명 조회
SELECT s.studno, s.name, d1.dname, d2.dname
FROM student s JOIN department d1 ON s.deptno1 = d1.deptno
	LEFT JOIN department d2 ON s.deptno2 = d2.deptno;
	
-- 컴퓨터정보학부에 해당하는 학생의 학번, 이름, 학과번호, 학과명 조회
SELECT s.studno, s.name, s.deptno1, d1.dname
FROM student s JOIN department d1 ON s.deptno1 = d1.deptno
	JOIN department d2 ON d1.part = d2.deptno
WHERE d2.dname = '컴퓨터정보학부'; 

-- 전자제어관에서 수업을 듣는 학생 조회 (1,2 전공 모두 포함)
SELECT s.studno, s.name,d1.dname, d2.dname, d1.build, d2.build
FROM student s JOIN department d1 ON s.deptno1 = d1.deptno
	LEFT JOIN department d2 ON s.deptno2 = d2.deptno
WHERE d1.build = '전자제어관' OR d2.build = '전자제어관';

-- emp 테이블을 이용하여 사번, 이름, 입사일, 자신보다 먼저 입사한 사람의 인원수 조회
SELECT e.EMPNO, e.ENAME, e.HIREDATE, COUNT(em.HIREDATE) 입사선배수
FROM emp e LEFT JOIN emp em ON e.HIREDATE > em.HIREDATE
GROUP BY e.HIREDATE, e.ENAME
ORDER BY 4;

-- professor 테이블을 이용하여 교수번호, 교수이름, 입사일, 자신보다 먼저 입사한 사람의 인원수 조회
SELECT p1.profno, p1.name, p1.hiredate, COUNT(p2.hiredate) 입사선배수
FROM professor p1 LEFT JOIN professor p2 ON p1.hiredate > p2.hiredate
GROUP BY p1.hiredate
ORDER BY 4;

SELECT e.*, d.dname
FROM emp e JOIN dept d ON e.deptno=d.deptno;

SELECT e.*, d.dname
FROM emp e JOIN dept d USING(deptno); -- join하는 컬럼명이 같을 때는 using 써주어도 됨

SELECT e.*, d.dname
FROM emp e CROSS JOIN dept d; 

SELECT e.*, d.dname
FROM emp e NATURAL JOIN dept d; -- natural join은 각 테이블에서 동일한 모든 컬럼을 join -> using, on, where X

SELECT s.*, p.name
FROM student s LEFT JOIN professor p ON s.profno = p.profno
UNION 
SELECT s.*, p.name
FROM student s RIGHT JOIN professor p ON s.profno = p.profno