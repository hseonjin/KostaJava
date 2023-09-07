-- 서브쿼리
-- from table
-- where 조건연산자 (select column_list from table where 조건);

-- 단일행 쿼리  = < > <= >= <>(!=)
-- word라는 이름을 가진 사람의 comm보다 큰 comm을 받은 사람의 이름과 comm
-- join 사용 - 16*16
SELECT e1.ename, e1.comm
FROM emp e1, emp e2
WHERE e2.ENAME = 'WARD' AND e1.COMM < e2.COMM;
-- subquery 사용 - 16+16 (효율적)
SELECT ename, comm 
FROM emp 
WHERE comm < (SELECT comm FROM emp WHERE ename = 'WARD');

-- student, department 테이블을 이용하여 서진수 학생과 주전공이 동일한 학생들의 이름과 전공 조회
SELECT s.name, d.dname
FROM student s JOIN department d ON s.deptno1 = d.deptno
WHERE s.deptno1 = (SELECT deptno1 FROM student WHERE NAME = '서진수')

-- professor, department 테이블을 이용하여 박원범 교수보다 나중에 입사한 사람의 이름과 입사일, 학과명 조회
SELECT p.name, p.hiredate, d.dname
FROM professor p JOIN department d ON p.deptno = d.deptno
WHERE p.hiredate > (SELECT hiredate FROM professor WHERE NAME = '박원범')

-- student 테이블에서 주전공이 201번인 학과의 평균 몸무게보다 몸무게가 많은 학생의 이름/몸무게 조회
SELECT NAME, weight
FROM student
WHERE weight > (SELECT AVG(weight) FROM student WHERE deptno1 = 201);

-- student 테이블에서 주전공이 전자공학과인 학과의 평균 몸무게보다 몸무게가 많은 학생의 이름/몸무게 조회
SELECT NAME, weight
FROM student
WHERE weight > (SELECT AVG(s.weight) 
						FROM student s JOIN department d ON s.deptno1 = d.deptno 
						WHERE d.dname = '전자공학과')
						
-- gogak, gift 테이블을 이용하여 노트북을 받을 수 있는 고객의 이름, 포인트, 상품명 조회
SELECT gname, POINT
FROM gogak
WHERE POINT >= (SELECT g_start FROM gift WHERE gname = '노트북')

-- emp, dept 테이블을 이용하여 'NEW_YORK'에서 근무하는 직원목록 조회
SELECT * FROM emp
WHERE deptno = (SELECT deptno FROM dept WHERE loc = 'NEW YORK');

-- student, professor 테이블을 이용하여 박원범 교수가 지도하는 학생 목록 조회
SELECT * FROM student
WHERE profno = (SELECT profno FROM professor WHERE NAME = '박원범');

-- gogak, gift 테이블을 사용하여 안광훈 고객이 포팅트로 받을 수 있는 상품 목록 조회
SELECT gname FROM gift
WHERE g_start <= (SELECT POINT FROM gogak WHERE gname = '안광훈');

-- emp, dept 테이블을 이용하여 sales 부서를 제외한 나머지 부서에 속한 직원의 사번, 이름, 부서명 조회
SELECT e.empno, e.ename, d.dname FROM emp e JOIN dept d ON e.deptno = d.DEPTNO
WHERE job NOT IN (SELECT dname FROM dept WHERE dname = 'SALES');

-- student, exam_01, hakjum 테이블을 이용하여 학점이 b미만인 학생의 학번, 이름, 점수 조회
SELECT s.studno, s.name, e.total
FROM student s JOIN exam_01 e USING (studno)
WHERE e.total < (SELECT min_point FROM hakjum WHERE grade = 'B0');

-- student, exam_01, hakjum 테이블을 이용하여 학점이 A0인 학생의 학번, 이름, 점수 조회
SELECT s.studno, s.name, e.total
FROM student s JOIN exam_01 e USING (studno)
WHERE e.total BETWEEN (SELECT min_point FROM hakjum WHERE grade = 'A0')
						AND (SELECT max_point FROM hakjum WHERE grade = 'A0');
						
-- 다중행 쿼리 -> IN, >ANY, <ANY, <ALL(min보다 작은 것), >ALL(max보다 큰 것), SAME, EXISTS
-- emp2, dept2 테이블을 이용하여 '포항본사'에서 근무하는 직원들의 사번, 이름, 직급, 부서명 조회
SELECT e.EMPNO, e.NAME, e.position, d.DNAME
FROM emp2 e JOIN dept2 d ON E.deptno = d.dcode 
WHERE e.DEPTNO IN (SELECT dcode FROM dept2 WHERE AREA = '포항본사');

-- emp2 테이블을 이용하여 '과장'직급의 최소연봉자보다 연봉이 높은 직원의 사번, 이름, 직급, 연봉 조회
SELECT empno, NAME, POSITION, pay FROM emp2
WHERE pay > ANY (SELECT pay FROM emp2 WHERE POSITION = '과장');

-- 다중열 서브쿼리 -> where절 컬럼 짝을 맞춰주어야 함
-- 각 학년별 키가 가장 큰 학생의 이름과 학년 조회
SELECT NAME, grade, height FROM student
WHERE (grade, height) IN (SELECT grade, max(height) FROM student GROUP BY grade)
ORDER BY 2;

-- student에서 2학년인 학생 중 체중이 가장 적은 학생보다 더 적은 학생의 이름, 학년, 몸무게 조회
SELECT NAME, grade, weight FROM student
WHERE weight < ALL (SELECT weight FROM student WHERE grade = 2);

-- emp2 테이블에서 본인이 속한 부서의 평균 연봉보다 적게 받는 직원의 이름, 연봉, 부서명 조회
SELECT e1.NAME, e1.pay, d.DNAME
FROM emp2 e1 JOIN dept2 d ON e1.DEPTNO = d.DCODE
WHERE e1.pay < (SELECT AVG(pay) FROM emp2 WHERE deptno = e1.deptno);

-- emp2, dept2 테이블에서 각 부서별 평균 연봉을 구하고 
-- 그 중에서 평균 연봉이 가장 적은 부서의 평균 연봉보다 많이 받는 직원들의 직원명, 부서명, 연봉 조회
SELECT e.name, d.DNAME, e.PAY
FROM emp2 e JOIN dept2 d ON e.DEPTNO = d.DCODE
WHERE pay > ANY (SELECT avg(pay) FROM emp2 GROUP BY deptno);

-- professor, department 테이블에서 각 학과별 입사일이 가장 오래된 교수의 
-- 교수번호, 이름, 입사일, 학과명 조회
SELECT p.profno, p.name, p.hiredate, d.dname
FROM professor p JOIN department d USING(deptno)
WHERE (deptno, hiredate) IN (SELECT deptno, MIN(hiredate) FROM professor GROUP BY deptno)
ORDER BY 3;

-- emp2 테이블에서 직급별 최대 연봉을 받는 직원의 이름과 직급, 연봉 조회
SELECT NAME, POSITION, pay FROM emp2
WHERE (POSITION, pay) IN (SELECT POSITION, MAX(pay) FROM emp2 GROUP BY POSITION);

-- student, exam_01, department 테이블에서 같은 학과 같은 학년 학생의 평균 점수보다 점수가 높은 학생의
-- 학번, 이름, 학과, 학년, 점수 조회
SELECT s.studno, s.name, d.dname, s.grade, e.total
FROM student s JOIN exam_01 e USING(studno)
	JOIN department d ON s.deptno1 = d.deptno
WHERE e.total >= (SELECT AVG(total) FROM student stu JOIN exam_01 ex USING(studno) 
	WHERE stu.deptno1 = s.deptno1 AND stu.grade = s.grade)
ORDER BY s.deptno1, s.grade;

-- emp2 테이블에서 직원들 중 자신의 직급의 평균연봉과 같거나 많이 받는 사람들의 이름, 직급, 연봉 조회
-- 단, 직급이 없으면 조회하지 않는다.
SELECT NAME, POSITION, pay
FROM emp2 e
WHERE (POSITION IS NOT NULL AND TRIM(POSITION) <> '') 
		AND pay >= (SELECT AVG(pay) 
							FROM emp2 WHERE position = e.position);

-- student, professor 테이블에서 담당 학생이 있는 교수들의 교수번호, 교수명 조회
SELECT DISTINCT s.profno, p.name
FROM student s JOIN professor p USING(profno)
WHERE profno IS NOT NULL;

SELECT profno, name
FROM professor p
WHERE EXISTS (SELECT * FROM student WHERE profno = p.profno); -- 결과가 하나라도 존재하면 조회

-- inline view 
SELECT profno, p.name
FROM (SELECT DISTINCT profno FROM student) e JOIN professor p USING(profno);

-- student, professor 테이블에서 담당 학생이 없는 교수들의 교수번호, 교수명 조회
SELECT profno, name
FROM professor p
WHERE NOT EXISTS (SELECT * FROM student WHERE profno = p.profno);


-- INSERT INTO dept VALUES(50, 'MARKETING', 'HONGKONG');
-- emp, dept 테이블에서 직원이 한 명도 소속되지 않은 부서의 부서번호와 부서명 조회
SELECT deptno, dname
FROM dept d
WHERE NOT EXISTS (SELECT * FROM emp WHERE deptno = d.deptno);

-- limit
SELECT * FROM emp ORDER BY sal DESC LIMIT 5;
SELECT * FROM emp ORDER BY sal DESC LIMIT 5,5;