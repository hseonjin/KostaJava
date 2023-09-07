-- 사용자 계정 생성(root계정의 권한) : create user table_name identified by 'password'
CREATE user kosta IDENTIFIED BY '1234';

-- 사용자 계정 삭제(root계정의 권한) : drop user table_name
DROP user kosta;

-- 계정 비밀번호 변경
ALTER user kosta IDENTIFIED BY '2345';

-- kosta 계정 권한 부여
GRANT SELECT, INSERT, UPDATE ON kotest.* TO kosta; -- kotest DB에 select, insert, update 권한 부여
GRANT ALL PRIVILEGES ON kotest.`*` TO kosta; -- kosta 계정에 kotest DB의 모든 권한 부여
GRANT ALL PRIVILEGES ON *.* TO kosta;

SHOW GRANTS FOR 'kosta';

-- kosta 계정에서 update 권한 삭제
REVOKE UPDATE ON kotest.`*` FROM 'kosta';

-- kosta 계정에서 모든 권한 삭제
REVOKE UPDATE ON *.* FROM 'kosta';


-- kosta 계정에서 확인
SELECT * FROM ACCOUNT;
DELETE FROM ACCOUNT WHERE id = '10001'; -- error delete 권한 없음