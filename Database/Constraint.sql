-- constraint : 제약조건
-- not null, unique, primary key, foreien key, check 

CREATE TABLE temp(
	id INT PRIMARY KEY,
	NAME VARCHAR(20) NOT NULL
);

INSERT INTO temp VALUES(NULL, 'jang'); -- error pk: not null
INSERT INTO temp VALUES(1, 'kang'); -- error pk: unique
INSERT INTO temp VALUES(1, 'king');
INSERT INTO temp VALUES(2, NULL); -- not null

CREATE TABLE temp2(
	email VARCHAR(50) UNIQUE
);
-- unique 제약조건: null 허용, 중복 불가
INSERT INTO temp2 VALUES(NULL); 
INSERT INTO temp2 VALUES('kosta@kosta.com');
INSERT INTO temp2 VALUES('kosta@kosta.com'); -- error

-- check 제약조건 : 값의 범위 제한
CREATE TABLE temp3( 
	name VARCHAR(20) NOT NULL,
	age INT DEFAULT 1 CHECK(age>0)
);

INSERT INTO temp3 (NAME) VALUES('hong');
INSERT INTO temp3 VALUES('kong', 1);
INSERT INTO temp3 VALUES('kong', -1); -- error



-- 제약조건 설정 연습
-- CREATE TABLE tcons (
-- 	NO INT,
-- 	NAME VARCHAR(20) NOT NULL,
-- 	jumin VARCHAR(13) NOT NULL UNIQUE,
-- 	AREA INT CHECK(AREA>0 AND AREA<5),
-- 	deptno VARCHAR(6) REFERENCE dept2(dcode),
-- 	CONSTRAINT tcons_no_pk PRIMARY KEY(no),
-- 	CONSTRAINT tcons_deptno_fk FOREIGN KEY(deptno) REFERENCE dept2(dcode)
-- );

CREATE TABLE dept2 (
	dcode VARCHAR(6) PRIMARY KEY,
	dname VARCHAR(30) NOT NULL,
	pdept VARCHAR(16),
	AREA VARCHAR(26)
);

CREATE TABLE tcons (
	NO INT,
	NAME VARCHAR(20),
	jumin VARCHAR(13),
	AREA INT,
	deptno VARCHAR(6)
);

ALTER TABLE tcons ADD CONSTRAINT tcons_no_pk PRIMARY KEY(NO);
ALTER TABLE tcons MODIFY COLUMN NAME VARCHAR(20) NOT NULL;
ALTER TABLE tcons MODIFY COLUMN jumin VARCHAR(13) NOT NULL;
ALTER TABLE tcons ADD CONSTRAINT tcons_jumin_uk UNIQUE(jumin);
ALTER TABLE tcons ADD CONSTRAINT tcons_area_ck CHECK(AREA IN(1,2,3,4));
ALTER TABLE tcons ADD CONSTRAINT tcons_deptno_fk FOREIGN KEY(deptno) REFERENCE dept2(dcode);