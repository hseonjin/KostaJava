-- CASE문

SELECT empno, ename, deptno,
	case when deptno = 10 then 'ACOOUNTINT'
		  when deptno = 20 then 'RESEARCH'
	  	  when deptno = 30 then 'SALES'
	  	  when deptno = 40 then 'POERATIONS'
	END AS dname
FROM emp;

-- STUDENT 테이블에서 주민번호를 이용해서 성별을 조회
-- 주민번호 7번째 숫자가 1, 3이면 man, 2 ,4이면 woman으로 조회
SELECT name 이름, jumin 주민번호, 
	case when SUBSTRING(jumin, 7, 1) = '1' OR SUBSTRING(jumin, 7, 1) = '3' then 'MAN'
		when SUBSTRING(jumin, 7,1) = '2' OR SUBSTRING(jumin, 7, 1) = '4' then 'WOMAN'
	END AS 성별
FROM student;

-- case SUBSTR(jumin, 7,1)
-- 	when '1' then 'MAN'
-- 	when '2' then 'WOMAN'
-- 	when '3' then 'MAN'
-- 	when '4' then 'WOMAN'
-- END AS 성별

-- student 테이블에서 1전공이 101번인 학생의 이름, 전화번호, 지역을 조회
-- 단, 지역은 전화번호의 지역번호로 구분
-- 02 서울, 031 경기, 051 부산, 052 울산, 055 경남으로 표시
SELECT NAME 이름, tel 전화번호, 
	case SUBSTR(tel, 1, INSTR(tel, ')') - 1)
		when '02' then '서울'
		when '031' then '경기'
		when '051' then '부산'
		when '052' then '울산'
		when '055' then '경남'
	END AS 지역
FROM student
WHERE deptno1 = '101';

-- student 테이블에서 생년월일을 참조하여 태어난 달과 분기를 조회하여
-- 태어난 달이 1~3월이면 1/4분기, 4~6월이면 2/4분기, 7~9월이면 3/4분기, 10~12월이면 4/4분기로 출력
-- 이름, 생년월일, 태어난 달, 분기 조회
SELECT NAME 이름, birthday 생년월일, MONTH(birthday) '태어난 달', 
	case QUARTER(birthday)
		 when '1' then '1/4분기'
		 when '2' then '2/4분기'
		 when '3' then '3/4분기'
		 when '4' then '4/4분기' -- else '4/4분기' 로 작성해도 됨
	END AS '분기'
FROM student;

-- professor 테이블에서 학과번호, 교수명, 학과명 조회
-- 단, 학과번호가 101인 교수만 학과명을 Computer Engineering으로 하고 나머지는 아무것도 출력하지 않음
SELECT deptno 학과번호, NAME 교수명, 
	case when deptno = '101' then 'Computer Engineering' ELSE '' END AS 학과명
FROM professor;