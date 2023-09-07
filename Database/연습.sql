-- student, department 테이블을 이용하여 학번, 학생명, 제1학과명 조회
SELECT s.studno 학번, s.name 학생명, d.dname
FROM student s INNER JOIN department d
	ON s.deptno1 = d.deptno;
	
SELECT s.studno 학번, s.name 학생명, d.dname
FROM student s JOIN department d
	ON s.deptno1 = d.deptno;
	
SELECT s.studno 학번, s.name 학생명, d.dname
FROM student s, department d
WHERE s.deptno1 = d.deptno;

-- student, professor 테이블을 이용하여, 학번, 학생명, 담당교수명을 조회
SELECT s.studno, s.name, p.name
FROM student s JOIN professor p
	ON s.profno = p.profno;

-- student, department, professor 테이블을 이용하여 학번, 이름, 제1전공명, 담당교수명 조회
SELECT s.studno, s.name, d.dname, p.name
FROM student s JOIN department d ON s.deptno1 = d.deptno
	JOIN professor p ON s.deptno1 = p.deptno;


-- student, exam_01 테이블을 이용하여 학번, 이름, 시험점수 조회
SELECT s.studno, s.name, e.total
FROM student s JOIN exam_01 e ON s.studno = e.studno;

-- student, exam_01, hakjum 테이블을 이용하여 학번, 이름, 시험점수, 학점 조회
SELECT s.studno, s.name, e.total, h.grade
FROM student s JOIN exam_01 e ON s.studno = e.studno
	JOIN hakjum h ON e.total BETWEEN min_point AND max_point;


-- gogak, gift 테이블을 이용하여 고객의 모든정보와, 고객이 본인의 포인터로 받을 수 있는 가장 좋은 상품 조회
SELECT gogak.*, gift.gname
FROM gogak JOIN gift ON gogak.point BETWEEN gift.g_start AND gift.g_end;

-- emp2, p_grade 테이블을 이용하여 이름, 직위, 급여, 같은 직급의 최소/최대 급여 조회
SELECT e.NAME, e.position, e.pay, p.s_pay, p.e_pay
FROM emp2 e JOIN p_grade p ON e.position = p.position;

-- emp2, p_grade 테이블을 이용하여 이름, 직위, 나이, 본인의 나이에 해당하는 예상 직급 조회
SELECT e.NAME, e.position, YEAR(CURDATE())-YEAR(e.BIRTHDAY) age, p.position
FROM emp2 e JOIN p_grade p ON YEAR(CURDATE())-YEAR(e.BIRTHDAY) BETWEEN p.s_age AND p.e_age;

-- gogak, gift 테이블을 이용하여 노트북을 받을 수 있는 고객의 이름, 포인트, 상품명 조회
SELECT gogak.gname, gogak.point, gift.gname
FROM gogak JOIN gift ON gogak.point <= gift.g_start
WHERE gift.gname = '노트북';


-- self join : 자기자신과 join
-- dept2 테이블을 이용하여 부서의 모든 정보와 각 부서의 상위 부서명을 조회
SELECT d1.*, d2.DNAME
FROM dept2 d1 JOIN dept2 d2 ON d1.PDEPT = d2.PDEPT;

-- emp 테이블을 이용하여 직원의 사번, 이름, 담당매니저 사번과 이름 조회
SELECT e1.EMPNO, e1.ENAME, e2.empno, e2.ename
FROM emp e1 LEFT JOIN emp e2 ON e1.MGR = e2.empno;

-- student, department 테이블을 이용하여 학번, 이름, 제1전공명, 제2전공명 조회
SELECT s.studno, s.name, d.dname, d2.dname
FROM student s JOIN department d ON s.deptno1 = d.deptno
	LEFT JOIN department d2 ON s.deptno2 = d2.deptno;

-- 컴퓨터정보학부에 해당하는 학생의 학번, 이름, 학과번호, 학과명 조회
SELECT s.studno, s.name, d.deptno, d.dname, d2.part
FROM student s JOIN department d ON s.deptno1 = d.deptno -- 전공번호를 통해 join
	JOIN department d2 ON d.part = d2.deptno -- 전공번호와 학부를 join
WHERE d2.dname = '컴퓨터정보학부';

-- 전자제어관에서 수업을 듣는 학생 조회 (1,2 전공 모두 포함)
SELECT s.studno, s.name, d.dname, d2.dname, d.build, d2.build
FROM student s JOIN department d ON s.deptno1 = d.deptno -- 1전공
	LEFT JOIN department d2 ON s.deptno2 = d2.deptno -- 2전공
WHERE d.deptno = 201 OR d2.deptno = 201; -- WHERE d.build = '전자제어관' OR d2.build = '전자제어관';

-- emp 테이블을 이용하여 사번, 이름, 입사일, 자신보다 먼저 입사한 사람의 인원수 조회
SELECT e1.empno, e1.ename, e1.HIREDATE, COUNT(e2.HIREDATE)
FROM emp e1 LEFT JOIN emp e2 ON e1.HIREDATE > e2.HIREDATE
GROUP BY e1.HIREDATE, e1.ename;

-- professor 테이블을 이용하여 교수번호, 교수이름, 입사일, 자신보다 먼저 입사한 사람의 인원수 조회
SELECT p1.profno, p1.name, p1.hiredate, COUNT(p2.hiredate)
FROM professor p1 LEFT JOIN professor p2 ON p1.hiredate > p2.hiredate
GROUP BY p1.hiredate;












-- --------------------------------------------------------------------------------------------------
-- --------------------------------------------------------------------------------------------------
-- --------------------------------------------------------------------------------------------------

-- 서브쿼리

-- student, department 테이블을 이용하여 서진수 학생과 주전공이 동일한 학생들의 이름과 전공명 조회
SELECT s.name, d.dname
FROM student s JOIN department d ON s.deptno1 = d.deptno
WHERE s.deptno1 = (SELECT deptno1 FROM student WHERE NAME = '서진수');

-- professor, department 테이블을 이용하여 박원범 교수보다 나중에 입사한 사람의 이름과 입사일, 학과명 조회
SELECT p.name, p.hiredate, d.dname
FROM professor p JOIN department d USING(deptno)
WHERE p.hiredate > (SELECT hiredate FROM professor WHERE NAME = '박원범');

-- student 테이블에서 주전공이 201번인 학과의 평균 몸무게보다 몸무게가 많은 학생의 이름/몸무게 조회
SELECT NAME, weight
FROM student
WHERE weight > (SELECT AVG(weight) FROM student WHERE deptno1 = 201);

-- student 테이블에서 주전공이 전자공학과인 학과의 평균 몸무게보다 몸무게가 많은 학생의 이름/몸무게 조회
SELECT NAME, weight
FROM student
WHERE weight > (SELECT AVG(weight) 
						FROM student s JOIN department d ON s.deptno1 = d.deptno 
						WHERE d.dname = '전자공학과');
						
-- gogak, gift 테이블을 이용하여 노트북을 받을 수 있는 고객의 이름, 포인트, 상품명 조회
SELECT gogak.gname, gogak.point, gift.gname
FROM gogak JOIN gift ON gogak.point BETWEEN gift g_start AND e_start
WHERE gogak.point > (SELECT g_start FROM gift WHERE gname = '노트북');

-- emp, dept 테이블을 이용하여 'NEW_YORK'에서 근무하는 직원목록 조회


-- student, professor 테이블을 이용하여 박원범 교수가 지도하는 학생 목록 조회


-- gogak, gift 테이블을 사용하여 안광훈 고객이 포팅트로 받을 수 있는 상품 목록 조회

-- emp, dept 테이블을 이용하여 sales 부서를 제외한 나머지 부서에 속한 직원의 사번, 이름, 부서명 조회


-- student, exam_01, hakjum 테이블을 이용하여 학점이 b0미만인 학생의 학번, 이름, 점수 조회


-- student, exam_01, hakjum 테이블을 이용하여 학점이 A0인 학생의 학번, 이름, 점수 조회

						
-- emp2, dept2 테이블을 이용하여 '포항본사'에서 근무하는 직원들의 사번, 이름, 직급, 부서명 조회


-- emp2 테이블을 이용하여 '과장'직급의 최소연봉자보다 연봉이 높은 직원의 사번, 이름, 직급, 연봉 조회


-- 다중열 서브쿼리 -> where절 컬럼 짝을 맞춰주어야 함
-- 각 학년별 키가 가장 큰 학생의 이름과 학년 조회

-- student에서 2학년인 학생 중 체중이 가장 적은 학생보다 더 적은 학생의 이름, 학년, 몸무게 조회

-- emp2 테이블에서 본인이 속한 부서의 평균 연봉보다 적게 받는 직원의 이름, 연봉, 부서명 조회


-- emp2, dept2 테이블에서 각 부서별 평균 연봉을 구하고 
-- 그 중에서 평균 연봉이 가장 적은 부서의 평균 연봉보다 많이 받는 직원들의 직원명, 부서명, 연봉 조회


-- professor, department 테이블에서 각 학과별 입사일이 가장 오래된 교수의 
-- 교수번호, 이름, 입사일, 학과명 조회


-- emp2 테이블에서 직급별 최대 연봉을 받는 직원의 이름과 직급, 연봉 조회


-- student, exam_01, department 테이블에서 같은 학과 같은 학년 학생의 평균 점수보다 점수가 높은 학생의
-- 학번, 이름, 학과, 학년, 점수 조회


-- emp2 테이블에서 직원들 중 자신의 직급의 평균연봉과 같거나 많이 받는 사람들의 이름, 직급, 연봉 조회
-- 단, 직급이 없으면 조회하지 않는다.

-- student, professor 테이블에서 담당 학생이 있는 교수들의 교수번호, 교수명 조회


-- inline view 

-- student, professor 테이블에서 담당 학생이 없는 교수들의 교수번호, 교수명 조회

-- emp, dept 테이블에서 직원이 한 명도 소속되지 않은 부서의 부서번호와 부서명 조회

