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

-- forein key
CREATE TABLE USER(
	id VARCHAR(20) PRIMARY KEY,
	NAME VARCHAR(20) NOT NULL
);

CREATE TABLE article (
	num INT AUTO_INCREMENT PRIMARY KEY, -- 일련번호, 자동입력
	title VARCHAR(50),
	content VARCHAR(1000),
	writer VARCHAR(20) REFERENCES USER(id) -- user 테이블의 id를 참조
);

INSERT INTO article (title, content) VALUES ('제목', '내용');
INSERT INTO article (title, content, writer) VALUES('제목', '내용', 'hong'); -- error

INSERT INTO user VALUES ('hong', '홍길동');
INSERT INTO article (title, content, writer) VALUES('제목', '내용', 'hong'); -- success

DELETE FROM user WHERE id='hong'; -- error 외부 테이블에서 id 컬럼을 FK로 사용하고 있으므로 삭제/변경할 수 없다
UPDATE user SET id='kong' WHERE id='hong'; -- error

UPDATE user SET NAME='공길동' WHERE id='hong'; -- success 참조되는 컬럼이 아닌 컬럼은 삭제/변경 가능
INSERT INTO user VALUES('song','송길동');
DELETE FROM user WHERE id='song'; -- success

ALTER TABLE article DROP FOREIGN KEY article_ibfk_1; -- fk 삭제
ALTER TABLE article ADD CONSTRAINT ARTICLE_USER_FK FOREIGN KEY(writer) REFERENCES user(id);