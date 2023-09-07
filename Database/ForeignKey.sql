-- foreign key

DROP TABLE article;
DROP TABLE user;

CREATE TABLE USER(
	id VARCHAR(20),
	NAME VARCHAR(20) NOT NULL
);

CREATE TABLE article (
	num INT AUTO_INCREMENT PRIMARY KEY, -- 일련번호, 자동입력
	title VARCHAR(50),
	content VARCHAR(1000),
	writer VARCHAR(20)
);

ALTER TABLE user ADD CONSTRAINT USER_PK PRIMARY KEY(id); -- pk 지정
ALTER TABLE article ADD CONSTRAINT ARTICLE_USER_FK FOREIGN KEY(writer) REFERENCES user(id); -- fk 지정

INSERT INTO article VALUES(NULL, '제목', '내용', 'hong'); -- error 'hong'이 참조 테이블(user)에 없으면 fk 제약조건 위배
INSERT INTO article VALUES(NULL, '제목', '내용', NULL); -- 단, null은 가능

INSERT INTO user VALUES ('hong', '홍길동');
INSERT INTO article VALUES(NULL, '제목', '내용', 'hong'); -- success 'hong'이 user의 id를 참조

-- 외부 테이블(article)에서 'hong'을 참조하고 있으므로 삭제/변경할 수 없다
DELETE FROM user WHERE id='hong'; -- error 
UPDATE user SET id='kong' WHERE id='hong'; -- error
UPDATE user SET NAME = '홍홍' WHERE id = 'hong'; -- success 참조하지 않는 컬럼의 내용 변경 가능

ALTER TABLE article DROP CONSTRAINT ARTICLE_USER_FK; -- fk 제약조건 삭제
INSERT INTO article VALUES(NULL, '송제목', '송내용', 'song'); -- success


ALTER TABLE article ADD CONSTRAINT ARTICLE_USER_FK FOREIGN KEY(writer) REFERENCES user(id) 
	ON DELETE CASCADE; -- error 설정하려는 fk 컬럼 데이터 중 제약조건에 위배되는 데이터가 있음 ('song')
UPDATE article SET writer='hong' WHERE writer<>'hong'; -- 'song'을 변경 후 다시 fk 지정시 success
-- on delete cascade : B가 fk로 A을 가리키고 있을 때, A를 삭제하면 B도 같이 삭제되는 기능 
-- (참조하는 모든 데이터 같이 삭제)
DELETE FROM user WHERE id='hong'; -- success user의 id, article의 writer가 'hong'인 데이터 모두 삭제됨

-- ------------------------
-- 제약조건 약식 (테이블 생성시 제약조건 지정)
-- 1. PK 지정 방법
-- 1-1
CREATE TABLE USER(
	id VARCHAR(20) PRIMARY KEY,
	NAME VARCHAR(20) NOT NULL
);
-- 1-2
CREATE TABLE USER(
	id VARCHAR(20),
	NAME VARCHAR(20) NOT NULL,
	PRIMARY KEY(id)
);

-- 2. FK 지정 방법
-- 2-1
CREATE TABLE article (
	num INT AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(50),
	content VARCHAR(1000),
	writer VARCHAR(20) REFERENCE user(id)
);
-- 2-2
CREATE TABLE article (
	num INT AUTO_INCREMENT,
	title VARCHAR(50),
	content VARCHAR(1000),
	writer VARCHAR(20),
	PRIMARY KEY(num),
	FOREIGN KEY(writer) REFERENCE user(id)
);