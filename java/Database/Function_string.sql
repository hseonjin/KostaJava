-- function
-- <문자열 함수> 
-- concat : 문자열을 이을 때 사용
SELECT CONCAT(ename, '(', job, ')') AS 'ename_job' FROM emp;

-- SMITH's sal is $800
SELECT CONCAT (ename, '\'s sal is $' , sal) AS 'ename_sal' FROM emp;

-- format
SELECT FORMAT(250500.1254, 2);
SELECT empno, ename, sal FROM emp;
SELECT empno, ename, FORMAT(sal, 0) FROM emp; -- 문자열타입으로 formatting

-- insert : 문자열 내의 지정된 위치에 특정 문자열 변경
SELECT INSERT('http://naver.com', 8, 5, 'kosta');


-- student 테이블의 주민번호 뒷자리를 '*'로 변경
SELECT studno, NAME, INSERT(jumin, 7, 7, '*******') jumin, grade FROM student;

-- gogak 테이블의 고객번호와 이름 조회 (단, 이름은 가운데 글자를 '*' 표시)
SELECT gno 고객번호, INSERT(gname, 2, 1, '*') 이름 FROM gogak;

-- instr : 문자열 내에서 특정 문자의 위치를 구함
SELECT INSTR('http://naver.com', 'n'); -- 8번째 위치가 출력됨

-- student 테이블의 전화번호에서 괄호가 오는 위치 출력
SELECT INSTR(tel, ')') FROM student;

-- substr : 부분문자열, 문자열 내에서 부분 문자열을 추출
SELECT SUBSTR('http://naver.com', 8, 5);
SELECT SUBSTR(tel, 1, INSTR(tel, ')') -1) FROM student;

-- student 테이블에서 주민번호 생년월일이 9월인 학생 조회
SELECT studno, NAME, jumin FROM student WHERE SUBSTR(jumin, 3, 2) = '09'; -- '' 안써도 자동형변환 됨

SELECT SUBSTR(tel, INSTR(tel, ')')+1, INSTR(tel, '-') - INSTR(tel, ')')-1) 국번 FROM student;

-- length() : 문자열 길이(byte 수) 구하기
SELECT LENGTH(tel) FROM student;
SELECT LENGTH(email) FROM professor;
SELECT email, INSTR(email, '@') FROM professor;
SELECT email, INSERT(email, SUBSTR(email, '@') + 1), LENGTH(SUBSTR(email, INSTR(email, '@')+1

SELECT ename, LENGTH(ename) FROM emp; -- 영어 - 1byte
SELECT NAME, LENGTH(NAME) FROM student; -- 한글 - 3byte

-- char_length : 문자열의 글자수 구하기
SELECT ename, CHAR_LENGTH(ename) FROM emp;
SELECT NAME, CHAR_LENGTH(NAME) FROM student;

-- substring == substr
SELECT SUBSTR('http://naver.com', 8, 5);
SELECT SUBSTRING('http://naver.com', 8, 5);

-- 소문자로 변경 : Lower, Lcase
SELECT ename, LOWER(ename) FROM emp;
SELECT ename, LCASE(ename) FROM emp;

-- 대문자로 변경 : Upper, Ucase
SELECT id, UPPER(id) FROM professor;
SELECT id, UCASE(id) FROM professor;

-- trim : 앞뒤 공백 제거
SELECT LENGTH('   test   '), LENGTH(TRIM('   test   '));
SELECT LENGTH('t e s t'), LENGTH(TRIM('t e s t'));

-- ltrim : 왼쪽 공백 제거
SELECT LENGTH('   test   '), LENGTH(LTRIM('   test   '));

-- rtrim : 오른쪽 공백 제거
SELECT LENGTH('   test   '), LENGTH(RTRIM('   test   '));

SELECT sal, ename FROM emp; -- 문자열은 왼쪽, 숫자는 오른쪽 정렬
-- lpad : 왼쪽을 특정 문자로 채워넣기
SELECT sal, LPAD(ename, 20, '*') 이름 FROM emp;
-- rpad : 오른쪽을 특정 문자로 채워넣기
SELECT sal, RPAD(ename, 20, '*') 이름 FROM emp;