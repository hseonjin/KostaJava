-- SELECT FROM : 테이블의 데이터를 조회할 떄 사용
SELECT * FROM emp;

-- SELECT 조회할 컬럼 FROM 테이블명;
SELECT empno, ename FROM emp;

-- dept 테이블에서 전체 컬럼 조회
SELECT * FROM dept;

-- dept 테이블에서 deptno, dname 조회
SELECT deptno, dname FROM dept;

-- student 테이블에서 학번, 이름 ,생일, 전화번호 조회
SELECT studno, name, birthday, tel FROM student;

-- WHERE : 행에 대한 조건문 (조건에 만족하는 행만 조회할 때 사용)
SELECT * FROM emp WHERE deptno = 10;

-- emp 테이블에서 deptno가 10보다 큰 직원의 사번, 이름, 직무, 부서번호 조회
SELECT empno, ename, job, deptno
FROM emp
WHERE deptno > 10;

-- student 테이블에서 4학년 학생들의 학번, 이름, 생일, 전화번호, 학년 조회
SELECT studno, name, birthday, tel, grade
FROM student
WHERE grade = 4;

-- where절 연산자
-- student 테이블에서 2학년 또는 3학년인 학생의 정보를 조회하시오.
SELECT * FROM student WHERE grade = 2 OR grade = 3;
SELECT * FROM student WHERE grade >= 2 and grade <= 3;
SELECT * FROM student WHERE IN(2,3);

-- student 테이블에서 4학년이 아닌 학생의 정보를 조회하시오.
SELECT * FROM student WHERE NOT grade = 4;
SELECT * FROM student WHERE grade NOT IN(4);

-- emp 테이블에서 직무가 clerk 이거나 salesman인 직원의 사번, 이름, 직무를 조회하시오
SELECT empno, ename, job FROM emp WHERE job IN ('clerk', 'salesman'); -- 문자열 사용시 작은따옴표 사용

-- alias : 칼럼명을 바꿔서 조회
SELECT empno 사번, ename AS 이름, job "직 무" FROM emp WHERE job IN ('clerk', 'salesman');
-- alias명 내에 공백이 들어가는 경우 문자열로 표현해준다 -> 큰 따옴표 사용

-- student 테이블에서 4학년 학생들의 학번, 이름, 학년을 조회하시오 (컬럼명: 학번, 이름, 학년)
SELECT studno 학번, NAME 이름, grade 학년
FROM student
WHERE grade = 4;

-- professor 테이블에서 hpage가 null이 아닌 컬럼만 조회하시오 (is null/is not null 사용, equal 비교 사용하지 않음)
SELECT * FROM professor WHERE hpage IS NULL;
SELECT * FROM professor WHERE hpage IS NOT NULL;

-- 날짜 비교연산 가능
SELECT * FROM emp WHERE hiredate >= '1985-01-01';

-- student 테이블에서 1976년생 학생 조회
SELECT * FROM student WHERE birthday >= '1976-01-01' AND birthday <= '1976-12-31';
SELECT * FROM student WHERE birthday BETWEEN '1976-01-01' AND '1976-12-31';

-- emp 테이블에서 부서번호가 10이고 급여가 2000이상인 직원의 목록 조회
SELECT * FROM emp WHERE deptno=10 AND sal>=2000;

-- professor 테이블에서 학과번호가 101이면서 정교수인 컬럼 조회
SELECT * FROM professor WHERE deptno = 101 AND POSITION = '정교수';

-- student 테이블에서 전공이나 부전공이 101인 학생 조회
SELECT * FROM student WHERE deptno1=101 OR deptno2 = 101;

-- student 테이블에서 전공이나 부전공이 101인 학생 중 1학년 또는 2학년 학생 조회
SELECT * FROM student WHERE (deptno1=101 OR deptno2 = 101) AND grade IN(1,2) ;

-- emp2 테이블에서 정규직 중 급여가 5000이상인 직원의 이름과 직급, 급여 조회
SELECT NAME, emp_type, pay FROM emp2 WHERE emp_type = '정규직' and pay >= 5000;

-- 컴퓨터정보학부에 소속된 교수의 이름, 직급, 소속학과 조회
SELECT NAME, POSITION, deptno FROM professor WHERE deptno IN (101,102,103);

-- 조인형 교수를 담당교수로 하는 학생의 학번, 이름, 학년, 학과번호, 교수번호 조회
SELECT studno, NAME, grade, deptno1, profno from student WHERE profno = 1001;

-- 노트북을 선물로 받을 수 있는 고객의 고객번호, 이름, 포인트  조회
SELECT gno, gname, point FROM gogak WHERE POINT >= 600001;

-- exam01 테이블에서 학점이 B0, B+인 학생의 학번화 점수 조회
SELECT studno, total FROM exam_01 WHERE total BETWEEN 80 AND 89;

-- student 테이블에서 1976년생 학생 조회(between A and B 사용)
SELECT * FROM student WHERE birthday BETWEEN '1976-01-01' AND '1976-12-31';
SELECT * FROM student WHERE birthday LIKE '1976%';

-- order by: 정렬
SELECT * FROM emp ORDER BY sal;
SELECT * FROM emp ORDER BY sal DESC;
SELECT * FROM emp deptno=10 ORDER BY sal DESC;

SELECT studno, NAME FROM student ORDER BY 2; -- select 절에서 선택한 컬럼의 순서
SELECT studno, NAME FROM student ORDER BY NAME;

-- student 테이블에서 4학년 학생들의 학번, 이름, 생일, 학과번호를 생일순으로 정렬하여 조회
SELECT studno, NAME, birthday, deptno1 FROM student WHERE grade = 4 ORDER BY 3;

SELECT * FROM emp ORDER BY deptno, sal DESC;

-- student 테이블에서 학년순 정렬, 같은 학년은 키가 큰 학생을 먼저 조회
SELECT * FROM student ORDER BY grade, height DESC;

-- DISTINCT 중복행 제거
SELECT DISTINCT deptno1 FROM student;

-- LIKE 연산자 : 컬럼의 문자열에 특정 문자열이 포함된 것을 거를 때 사용
-- 이름의 성이 '서'인 학생을 조회
SELECT * FROM student WHERE NAME LIKE '서%';
SELECT * FROM emp WHERE job LIKE '%MAN%';
SELECT * FROM emp WHERE job LIKE '_A%'; -- 두 번째 글자가 'A'인 것을 조회 (_는 자리수 표시)

-- student 테이블에서 9월 생일인 학생의 학번, 이름, 학년, 주민번호 조회
SELECT studno, name, grade, jumin FROM student WHERE jumin LIKE '__09%';

-- professor 테이블에서 bonus가 있는 교수의 교수번호, 이름, 급여, 보너스를 조회
SELECT profno, NAME, pay, bonus FROM professor WHERE bonus IS NOT NULL;
SELECT profno, NAME, pay, bonus, pay+IFNULL(bonus, 0) FROM professor;

-- emp테이블에서 sal 이 1000보다 크고 comm이 1000보다 작거나 없는 직원의 사번, 이름, 급여, 커미션 조회
SELECT empno, ename, sal, comm FROM emp WHERE sal > 1000 AND (comm < 1000 OR comm IS NULL);
