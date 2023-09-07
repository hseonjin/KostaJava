-- 숫자 함수

-- COUNT : 조건에 만족하는 레코드(행) 수
SELECT COUNT(*) FROM emp; -- 전체 행의 개수
SELECT COUNT(ename) FROM emp; -- ename이 있는 행의 개수(null 제외)
SELECT COUNT(comm) FROM emp; -- null인 레코드 제외

-- SUM : 레코드(행) 값 덧셈
SELECT SUM(sal) FROM emp;

-- AVG : 레코드(행) 값 곱셈
SELECT AVG(sal) FROM emp; -- null인 레코드 제외
SELECT SUM(sal), COUNT(*), SUM(sal)/COUNT(*), AVG(sal) FROM emp;
SELECT SUM(comm), COUNT(*), SUM(comm)/COUNT(*), AVG(comm) FROM emp;
SELECT SUM(comm), SUM(comm)/COUNT(*), AVG(comm), AVG(IFNULL(comm,0)) FROM emp;

-- MAX 
SELECT ename, MAX(sal) FROM emp;

-- MIN
SELECT ename, MIN(sal) FROM emp;

-- professor 테이블에서 각 교수들의 연봉을 조회하시오
-- 교수번호, 이름, 월급여, 보너스, 연봉
SELECT profno 교수번호, NAME 이름, pay 월급여, IFNULL(bonus, 0) 보너스, pay*12+IFNULL(bonus, 0) 연봉 FROM professor;

-- groub by
SELECT deptno, job, COUNT(*), SUM(sal) FROM emp
GROUP BY deptno, job;

-- student 테이블에서 메인 학과별 학생 수
SELECT deptno1, COUNT(*) "학생 수" FROM student GROUP BY deptno1;

-- student 테이블에서 학년별 평균 키 조회
SELECT grade 학년, AVG(height) 평균키 FROM student GROUP BY grade;

SELECT deptno, MAX(sal) FROM emp GROUP BY deptno;

-- 그룹핑한 것에 대한 조건은 having절 사용
-- emp 테이블에서 평균 급여가 2000이상인 부서의 부서번호와 평균급여 조회
SELECT deptno, AVG(sal) 
FROM emp 
GROUP BY deptno
HAVING AVG(sal) >= 2000;

-- student 테이블에서 각 학과와 학년별 평균 몸무게, 최대/최소 몸무게를 조회하시오
SELECT deptno1 학과, grade 학년, avg(weight) 평균몸무게, MAX(weight) 최대몸무게, MIN(weight) 최소몸무게
FROM student;
GROUP BY deptno1, grade
HAVING AVG(weight) >= 50 -- 평균 몸무게가 50 이상인 행만 조회
ORDER BY 1, 2;