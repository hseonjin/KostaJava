-- -------------------------------------------------
-- root 계정에서 실행
-- -------------------------------------------------

CREATE user kosta IDENTIFIED BY '1234'; -- 계정 생성 (root 만 가능)

ALTER user kosta IDENTIFIED BY '2345'; -- 계정의 비밀번호 변경
DROP user kosta;

-- kosta 계정에 kotest SELECT, INSERT, UPDATE 권한 부여
GRANT SELECT,INSERT, UPDATE ON kotest.* TO kosta;

-- kosta 계정에 kotest의 모든 권한 부여
GRANT ALL PRIVILEGES ON kotest.* TO kosta;

-- kosta 계정에 모든 DB의 모든 권한 부여
grant ALL PRIVILEGES ON *.* TO kosta;

SHOW GRANTS FOR 'kosta';

-- kosta 계정에 kotest SELECT, INSERT, UPDATE 권한 삭제
REVOKE SELECT, INSERT, UPDATE ON kotest.* FROM 'kosta';
-- kosta 계정에서 update 권한 삭제
REVOKE UPDATE ON kotest.* FROM 'kosta';
-- kosta 계정에서  모든 권한 삭제
REVOKE ALL PRIVILEGES ON *.* from 'kosta';

-- -------------------------------------------------------
-- kosta 계정에서 확인
-- -------------------------------------------------------

SELECT*FROM ACCOUNT;
DELETE FROM ACCOUNT WHERE id='10001'; -- error : delete 권한 없음