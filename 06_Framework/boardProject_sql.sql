ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

-- 계정 생성
CREATE USER spring_lcw IDENTIFIED BY spring1234;

GRANT CONNECT, RESOURCE, CREATE VIEW TO spring_lcw;

ALTER USER spring_lcw DEFAULT TABLESPACE "A230724"
QUOTA 20M ON "A230724";

------------------------------------------------------------------

-- "" 작성 시 대/소문자 구분
--> "" 작성을 권장

-- VARCHAR2(10) : 10 바이트 문자열, 최대 4000 바이트
-- NVARCHAR2(10) : 10글자 문자열(유니코드), 최대 4000 바이트

/* MEMBER 테이블 생성 */
CREATE TABLE "MEMBER"(
	"MEMBER_NO" NUMBER CONSTRAINT MEMBER_PK PRIMARY KEY, 
	"MEMBER_EMAIL" VARCHAR2(50) NOT NULL,
	"MEMBER_PW" VARCHAR2(100) NOT NULL,
	"MEMBER_NICKNAME" NVARCHAR2(10) NOT NULL,
	"MEMBER_" CHAR(11) NOT NULL, 
	"MEMBER_ADDRESS" NVARCHAR2(200),
	"PROFILE_IMG" VARCHAR2(300),
	"ENROLL_DATE" DATE DEFAULT SYSDATE NOT NULL,
	"MEMBER_DEL_FL" CHAR(1) DEFAULT 'N'
		CHECK("MEMBER_DEL_FL" IN ('Y', 'N')), 
	"AUTHORITY" NUMBER DEFAULT 1 CHECK("AUTHORITY" IN (1,2))
);

COMMENT ON COLUMN "MEMBER". "MEMBER_NO" IS '회원 번호(SEQ_MEMBER_NO)';
COMMENT ON COLUMN "MEMBER". "MEMBER_EMAIL" IS '회원 이메일(ID역할)';
COMMENT ON COLUMN "MEMBER". "MEMBER_PW" IS '비밀번호(암호화)';
COMMENT ON COLUMN "MEMBER". "MEMBER_NICKNAME" IS '별명';
COMMENT ON COLUMN "MEMBER". "MEMBER_" IS '전화번호(- 없이)';
COMMENT ON COLUMN "MEMBER". "MEMBER_ADDRESS" IS '주소';
COMMENT ON COLUMN "MEMBER". "PROFILE_IMG" IS '프로필 이미지 저장 경로';
COMMENT ON COLUMN "MEMBER". "ENROLL_DATE" IS '가입일';
COMMENT ON COLUMN "MEMBER". "MEMBER_DEL_FL" IS '탈퇴 여부(Y:탈퇴, N:정상)';
COMMENT ON COLUMN "MEMBER". "AUTHORITY" IS '권한(1:일반 2: 관리자)';

-- 시퀀스 생성
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE;

-- 샘플 계정 추가
INSERT INTO "MEMBER"
VALUES(SEQ_MEMBER_NO.NEXTVAL , 'member01@naver.com', 'pass01', '회원1',
	'01012345678', '04540^^^ 서울시 중구 남대문로 120^^^', 
	NULL, DEFAULT, DEFAULT, DEFAULT 
);

COMMIT;

SELECT * FROM "MEMBER";

-- 로그인 
SELECT MEMBER_NO, MEMBER_EMAIL, MEMBER_NICKNAME, MEMBER_, MEMBER_ADDRESS, PROFILE_IMG, AUTHORITY,
	   TO_CHAR(ENROLL_DATE, 'YYYY"년" MM"월" DD"일" HH24"시" MI"분" SS"초"') AS ENROLL_DATE
FROM "MEMBER"
WHERE MEMBER_DEL_FL = 'N'
AND MEMBER_EMAIL = 'member01@naver.com'
AND MEMBER_PW ='pass01';

-- 샘플 회원 비밀번호 변경(암호화 적용)
UPDATE "MEMBER" SET 
MEMBER_PW = '$2a$10$1YM/Q4mRmaArI9rVNHMOT.N0pivXjldbadnjdsJrO5Ru.eYNuHIp.'
WHERE MEMBER_NO = '1';
COMMIT;

-- 회원 정보 수정 
UPDATE "MEMBER" SET 
MEMBER_NICKNAME = 'TEST',
MEMBER_TEL = '01012432122',
MEMBER_ADDRESS = 'AAA^^^BBB^^^CCC'
WHERE MEMBER_NO = '4';

ROLLBACK;

SELECT * FROM "MEMBER";

-- BCrypt 암호화 시 비밀번호를 조회한 후
-- matches() 메서드를 이용해서 비교

-- 로그인한 회원의 암호화 된 비밀번호 조회
SELECT MEMBER_PW 
FROM "MEMBER"
WHERE MEMBER_NO = '';

UPDATE "MEMBER" SET 
MEMBER_PW = ''
WHERE MEMBER_NO = '';

ROLLBACK;
SELECT * FROM "MEMBER";

UPDATE "MEMBER" SET 
MEMBER_DEL_FL = 'Y'
WHERE MEMBER_NO = 2;

SELECT MEMBER_NO, MEMBER_EMAIL, MEMBER_DEL_FL
FROM "MEMBER" 
ORDER BY MEMBER_NO DESC;

UPDATE "MEMBER" SET 
MEMBER_DEL_FL = 'Y'
WHERE MEMBER_NO = '7';
COMMIT;



DELETE FROM "MEMBER" 
WHERE MEMBER_NO = '7';

COMMIT;

SELECT * FROM "MEMBER";

-- 이메일 중복 검사(중복 되는 값이 있으면 0->1 없으면 -> 0)
SELECT COUNT(*) 
FROM "MEMBER"
WHERE MEMBER_DEL_FL = 'N'
AND MEMBER_EMAIL = 'member01@naver.com';

SELECT MEMBER_EMAIL
FROM "MEMBER"
WHERE MEMBER_EMAIL LIKE '%com%';


/* 이메일 인증키 테이블 */
DROP TABLE "TB_AUTH_KEY";

CREATE TABLE "TB_AUTH_KEY" (
   "KEY_NO"   NUMBER      NOT NULL,
   "AUTH_KEY"   CHAR(6)      NOT NULL,
   "EMAIL"   VARCHAR2(50)      NOT NULL,
   "CREATE_TIME"   DATE   DEFAULT SYSDATE   NOT NULL
);



COMMENT ON COLUMN "TB_AUTH_KEY"."KEY_NO" IS '인증키 구분 번호(SEQ_KEY_NO)';

COMMENT ON COLUMN "TB_AUTH_KEY"."AUTH_KEY" IS '코드';

COMMENT ON COLUMN "TB_AUTH_KEY"."EMAIL" IS '이메일';

COMMENT ON COLUMN "TB_AUTH_KEY"."CREATE_TIME" IS '인증 코드 생성 시간';

ALTER TABLE "TB_AUTH_KEY" ADD CONSTRAINT "PK_TB_AUTH_KEY" PRIMARY KEY (
   "KEY_NO"
);


CREATE SEQUENCE SEQ_KEY_NO NOCACHE;


SELECT * FROM TB_AUTH_KEY;

-----------------------------------------------------------------------------------------

DROP TABLE "MEMBER";

CREATE TABLE "MEMBER" (
	"MEMBER_NO"	NUMBER		NOT NULL,
	"MEMBER_EMAIL"	VARCHAR2(50)		NOT NULL,
	"MEMBER_PW"	VARCHAR2(100)		NOT NULL,
	"MEMBER_NICKNAME"	VARCHAR2(30)		NOT NULL,
	"MEMBER_TEL"	CHAR(11)		NOT NULL,
	"MEMBER_ADDRESS"	VARCHAR2(300)		NULL,
	"PROFILE_IMG"	VARCHAR2(300)		NULL,
	"ENROLL_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"MEMBER_DEL_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"AUTHORITY"	NUMBER	DEFAULT 1	NOT NULL
);

COMMENT ON COLUMN "MEMBER"."MEMBER_NO" IS '회원 번호(SEQ_MEMBER_NO)';

COMMENT ON COLUMN "MEMBER"."MEMBER_EMAIL" IS '회원 이메일(ID 역할)';

COMMENT ON COLUMN "MEMBER"."MEMBER_PW" IS '비밀번호(암호화)';

COMMENT ON COLUMN "MEMBER"."MEMBER_NICKNAME" IS '회원 닉네임(중복 X)';

COMMENT ON COLUMN "MEMBER"."MEMBER_TEL" IS '전화번호(- 없음)';

COMMENT ON COLUMN "MEMBER"."MEMBER_ADDRESS" IS '회원 주소';

COMMENT ON COLUMN "MEMBER"."PROFILE_IMG" IS '프로필 이미지 경로';

COMMENT ON COLUMN "MEMBER"."ENROLL_DATE" IS '회원 가입일';

COMMENT ON COLUMN "MEMBER"."MEMBER_DEL_FL" IS '탈퇴여부(N : 탈퇴X , Y : 탈퇴 O)';

COMMENT ON COLUMN "MEMBER"."AUTHORITY" IS '회원 권한(1 : 일반, 2 : 관리자)';

DROP TABLE "BOARD";

CREATE TABLE "BOARD" (
	"BOARD_NO"	NUMBER		NOT NULL,
	"BOARD_TITLE"	VARCHAR2(150)		NOT NULL,
	"BOARD_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"BOARD_WRITE_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"BOARD_UPDATE_DATE"	DATE		NULL,
	"READ_COUNT"	NUMBER	DEFAULT 0	NOT NULL,
	"BOARD_DEL_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL,
	"BOARD_CODE"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "BOARD"."BOARD_NO" IS '게시글 번호(SEQ_BOARD_NO)';

COMMENT ON COLUMN "BOARD"."BOARD_TITLE" IS '게시글 제목';

COMMENT ON COLUMN "BOARD"."BOARD_CONTENT" IS '게시글 내용';

COMMENT ON COLUMN "BOARD"."BOARD_WRITE_DATE" IS '게시글 작성일';

COMMENT ON COLUMN "BOARD"."BOARD_UPDATE_DATE" IS '마지막 수정일(수정 시 UPDATE)';

COMMENT ON COLUMN "BOARD"."READ_COUNT" IS '조회수';

COMMENT ON COLUMN "BOARD"."BOARD_DEL_FL" IS '삭제 여부(N : 삭제X , Y : 삭제O)';

COMMENT ON COLUMN "BOARD"."MEMBER_NO" IS '회원 번호(SEQ_MEMBER_NO)';

COMMENT ON COLUMN "BOARD"."BOARD_CODE" IS '게시판 종류별 코드 번호(SEQ_BOARD_CODE)';

DROP TABLE "BOARD_IMG";

CREATE TABLE "BOARD_IMG" (
	"IMG_NO"	NUMBER		NOT NULL,
	"IMG_PATH"	VARCHAR2(300)		NOT NULL,
	"IMG_RENAME"	VARCHAR2(30)		NOT NULL,
	"IMG_ORIGINAL_NAME"	VARCHAR2(300)		NOT NULL,
	"IMG_ORDER"	NUMBER		NOT NULL,
	"BOARD_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "BOARD_IMG"."IMG_NO" IS '이미지 번호(SEQ_IMG_NO)';

COMMENT ON COLUMN "BOARD_IMG"."IMG_PATH" IS '이미지 저장 폴더 경로';

COMMENT ON COLUMN "BOARD_IMG"."IMG_RENAME" IS '변경된 이미지 파일 이름';

COMMENT ON COLUMN "BOARD_IMG"."IMG_ORIGINAL_NAME" IS '원본 이미지 파일 이름';

COMMENT ON COLUMN "BOARD_IMG"."IMG_ORDER" IS '이미지 파일 순서 번호';

COMMENT ON COLUMN "BOARD_IMG"."BOARD_NO" IS '게시글 번호(SEQ_BOARD_NO)';

DROP TABLE "BOARD_LIKE";

CREATE TABLE "BOARD_LIKE" (
	"MEMBER_NO"	NUMBER		NOT NULL,
	"BOARD_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "BOARD_LIKE"."MEMBER_NO" IS '회원 번호(SEQ_MEMBER_NO)';

COMMENT ON COLUMN "BOARD_LIKE"."BOARD_NO" IS '게시글 번호(SEQ_BOARD_NO)';

DROP TABLE "COMMENT";

CREATE TABLE "COMMENT" (
	"COMMENT_NO"	NUMBER		NOT NULL,
	"COMMENT_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"COMMENT_WRITE_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"COMMENT_DEL_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL,
	"BOARD_NO"	NUMBER		NOT NULL,
	"PARENT_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "COMMENT"."COMMENT_NO" IS '댓글 번호(SEQ_COMMENT_NO)';

COMMENT ON COLUMN "COMMENT"."COMMENT_CONTENT" IS '댓글 내용';

COMMENT ON COLUMN "COMMENT"."COMMENT_WRITE_DATE" IS '댓글 작성일';

COMMENT ON COLUMN "COMMENT"."COMMENT_DEL_FL" IS '댓글 삭제 여부(N : 삭제X, Y : 삭제O)';

COMMENT ON COLUMN "COMMENT"."MEMBER_NO" IS '회원 번호(SEQ_MEMBER_NO)';

COMMENT ON COLUMN "COMMENT"."BOARD_NO" IS '게시글 번호(SEQ_BOARD_NO)';

COMMENT ON COLUMN "COMMENT"."PARENT_NO" IS '부모 댓글 번호';

DROP TABLE "BOARD_TYPE";

CREATE TABLE "BOARD_TYPE" (
	"BOARD_CODE"	NUMBER		NOT NULL,
	"BOARD_NAME"	VARCHAR2(300)		NOT NULL
);

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_CODE" IS '게시판 종류별 코드 번호(SEQ_BOARD_CODE)';

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_NAME" IS '게시판 이름';

DROP TABLE "TB_AUTH_KEY";

CREATE TABLE "TB_AUTH_KEY" (
	"KEY_NO"	NUMBER		NOT NULL,
	"AUTH_KEY"	CHAR(6)		NOT NULL,
	"EMAIL"	VARCHAR2(50)		NOT NULL,
	"CREATE_TIME"	DATE	DEFAULT SYSDATE	NOT NULL
);

COMMENT ON COLUMN "TB_AUTH_KEY"."KEY_NO" IS '인증키 구분 번호(SEQ_KEY_NO)';

COMMENT ON COLUMN "TB_AUTH_KEY"."AUTH_KEY" IS '코드';

COMMENT ON COLUMN "TB_AUTH_KEY"."EMAIL" IS '이메일';

COMMENT ON COLUMN "TB_AUTH_KEY"."CREATE_TIME" IS '인증 코드 생성 시간';

ALTER TABLE "MEMBER" ADD CONSTRAINT "PK_MEMBER" PRIMARY KEY (
	"MEMBER_NO"
);

ALTER TABLE "BOARD" ADD CONSTRAINT "PK_BOARD" PRIMARY KEY (
	"BOARD_NO"
);

ALTER TABLE "BOARD_IMG" ADD CONSTRAINT "PK_BOARD_IMG" PRIMARY KEY (
	"IMG_NO"
);

ALTER TABLE "BOARD_LIKE" ADD CONSTRAINT "PK_BOARD_LIKE" PRIMARY KEY (
	"MEMBER_NO",
	"BOARD_NO"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "PK_COMMENT" PRIMARY KEY (
	"COMMENT_NO"
);

ALTER TABLE "BOARD_TYPE" ADD CONSTRAINT "PK_BOARD_TYPE" PRIMARY KEY (
	"BOARD_CODE"
);

ALTER TABLE "TB_AUTH_KEY" ADD CONSTRAINT "PK_TB_AUTH_KEY" PRIMARY KEY (
	"KEY_NO"
);

ALTER TABLE "BOARD" ADD CONSTRAINT "FK_MEMBER_TO_BOARD_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "MEMBER" (
	"MEMBER_NO"
);

ALTER TABLE "BOARD" ADD CONSTRAINT "FK_BOARD_TYPE_TO_BOARD_1" FOREIGN KEY (
	"BOARD_CODE"
)
REFERENCES "BOARD_TYPE" (
	"BOARD_CODE"
);

ALTER TABLE "BOARD_IMG" ADD CONSTRAINT "FK_BOARD_TO_BOARD_IMG_1" FOREIGN KEY (
	"BOARD_NO"
)
REFERENCES "BOARD" (
	"BOARD_NO"
);

ALTER TABLE "BOARD_LIKE" ADD CONSTRAINT "FK_MEMBER_TO_BOARD_LIKE_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "MEMBER" (
	"MEMBER_NO"
);

ALTER TABLE "BOARD_LIKE" ADD CONSTRAINT "FK_BOARD_TO_BOARD_LIKE_1" FOREIGN KEY (
	"BOARD_NO"
)
REFERENCES "BOARD" (
	"BOARD_NO"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "FK_MEMBER_TO_COMMENT_1" FOREIGN KEY (
	"MEMBER_NO"
)
REFERENCES "MEMBER" (
	"MEMBER_NO"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "FK_BOARD_TO_COMMENT_1" FOREIGN KEY (
	"BOARD_NO"
)
REFERENCES "BOARD" (
	"BOARD_NO"
);

ALTER TABLE "COMMENT" ADD CONSTRAINT "FK_COMMENT_TO_COMMENT_1" FOREIGN KEY (
	"PARENT_NO"
)
REFERENCES "COMMENT" (
	"COMMENT_NO"
);

-- CHECK 제약 조건 추가


ALTER TABLE "BOARD" ADD CONSTRAINT CHECK_BOARD_DEL_FL
CHECK(BOARD_DEL_FL IN ('Y', 'N'));

ALTER TABLE "COMMENT" ADD CONSTRAINT CHECK_COMMENT_DEL_FL
CHECK(COMMENT_DEL_FL IN ('Y', 'N'));

CREATE SEQUENCE SEQ_BOARD_NO NOCACHE;
CREATE SEQUENCE SEQ_COMMENT_NO NOCACHE;
CREATE SEQUENCE SEQ_BOARD_CODE NOCACHE;
CREATE SEQUENCE SEQ_IMG_NO NOCACHE;

DELETE FROM BOARD

--------------------------------------------------------------------

/* 게시판 종류 */ 
INSERT INTO "BOARD_TYPE" VALUES(SEQ_BOARD_CODE.NEXTVAL, '공지사항');
INSERT INTO "BOARD_TYPE" VALUES(SEQ_BOARD_CODE.NEXTVAL, '자유 게시판');
INSERT INTO "BOARD_TYPE" VALUES(SEQ_BOARD_CODE.NEXTVAL, '질문 게시판');

DELETE FROM BOARD_TYPE
WHERE BOARD_CODE = '6';

SELECT * FROM "BOARD_TYPE";

/*BOARD 테이블 샘플 데이터 삽입(PL/SQL)*/

BEGIN
   FOR I IN 1..1500 LOOP
      INSERT INTO BOARD 
      VALUES( SEQ_BOARD_NO.NEXTVAL,
              SEQ_BOARD_NO.CURRVAL || '번째 게시글',
              SEQ_BOARD_NO.CURRVAL || '번째 게시글 내용 입니다.',
              DEFAULT, DEFAULT, DEFAULT, DEFAULT, 1, 
              CEIL(DBMS_RANDOM.VALUE(0,3))
      );
     
   END LOOP;
  
END;

SELECT COUNT(*) FROM "BOARD";

COMMIT;

SELECT COUNT(*) FROM "BOARD"
WHERE BOARD_CODE = '1';
 
-- COMMENT 테이블 샘플 데이터 삽입(PL/SQL)

--BEGIN
--   FOR I IN 1..500 LOOP
--      INSERT INTO "COMMENT" 
--      VALUES(SEQ_COMMENT_NO.NEXTVAL, 
--            SEQ_COMMENT_NO.CURRVAL || '번째 댓글',
--            DEFAULT, DEFAULT,
--             CEIL(DBMS_RANDOM.VALUE(0,1500)),
--             1, NULL);
--   END LOOP;
--END;

BEGIN
   FOR I IN 1..300 LOOP
      INSERT INTO "COMMENT" 
      VALUES(SEQ_COMMENT_NO.NEXTVAL, 
            SEQ_COMMENT_NO.CURRVAL || '번째 댓글',
            DEFAULT, DEFAULT,
            1, CEIL(DBMS_RANDOM.VALUE(0,1500)), NULL);
   END LOOP;
END;

SELECT COUNT(*) FROM "COMMENT";

COMMIT;

SELECT MIN(BOARD_NO), MAX(BOARD_NO) FROM "BOARD"; 

---------------------------------------------------------

-- 좋아요 샘플 데이터
INSERT INTO "BOARD_LIKE" VALUES(1, 1500); -- 2번 카테고리
INSERT INTO "BOARD_LIKE" VALUES(11, 1495); -- 3번 카테고리
INSERT INTO "BOARD_LIKE" VALUES(9, 1500);
INSERT INTO "BOARD_LIKE" VALUES(9, 1495);
INSERT INTO "BOARD_LIKE" VALUES(10, 1500);

COMMIT;

----------------------------------------------------------

-- 게시글 목록 조회
-- 특정 게시판 목록만 조회(BOARD_CODE) 
-- 최신 글이 먼저 조회(BOARD_NO 내림차순)
-- 삭제 되지 않은 글만 조회

-- 조회할 컬럼 : 
-- [BOARD] 게시글 번호, 제목, 조회수, 작성일
-- [MEMBER] 작성자 닉네임
-- [COMMENT] 댓글 수
-- [BOARD_LIKE] 좋아요 수
-- [BOARD_IMG] 썸네일

-- COMMENT, BOARD_LIKE, BOARD_IMG 테이블 상관 서브쿼리 필요

SELECT BOARD_NO, BOARD_TITLE, READ_COUNT, MEMBER_NICKNAME,

		CASE  		
	         WHEN SYSDATE - BOARD_WRITE_DATE < 1/24/60
	         THEN FLOOR( (SYSDATE - BOARD_WRITE_DATE) * 24 * 60 * 60 ) || '초 전'
	         WHEN SYSDATE - BOARD_WRITE_DATE < 1/24
	         THEN FLOOR( (SYSDATE - BOARD_WRITE_DATE) * 24 * 60) || '분 전'
	         WHEN SYSDATE - BOARD_WRITE_DATE < 1
	         THEN FLOOR( (SYSDATE - BOARD_WRITE_DATE) * 24) || '시간 전'
	         ELSE TO_CHAR(BOARD_WRITE_DATE, 'YYYY-MM-DD')       
    	END BOARD_WRITE_DATE, 
		
		
		(SELECT COUNT(*) FROM "COMMENT" C
		WHERE C.BOARD_NO = B.BOARD_NO) COMMENT_COUNT,
		
		(SELECT COUNT(*) FROM "BOARD_LIKE" L
		WHERE L.BOARD_NO = B.BOARD_NO) LIKE_COUNT,
		
		(SELECT IMG_PATH || IMG_RENAME FROM BOARD_IMG I
  		 WHERE I.BOARD_NO = B.BOARD_NO
   		AND IMG_ORDER = 0) THUMBNAIL
		
FROM "BOARD" B
JOIN "MEMBER" USING(MEMBER_NO)
WHERE BOARD_DEL_FL = 'N'
AND BOARD_CODE = '3'
ORDER BY BOARD_NO DESC;


SELECT COUNT(*) FROM "BOARD"
WHERE BOARD_DEL_FL = 'N'
AND BOARD_CODE = '3'

-- 작성일, 조회수, 멤버 닉네임, 좋아요수 
SELECT BOARD_NO, BOARD_TITLE, BOARD_CONTENT, READ_COUNT, 
         TO_CHAR(BOARD_WRITE_DATE, 'YYYY"년" MM"월" DD"일" HH24:MI:SS') BOARD_WRITE_DATE,
         TO_CHAR(BOARD_UPDATE_DATE, 'YYYY"년" MM"월" DD"일" HH24:MI:SS') BOARD_UPDATE_DATE,
         MEMBER_NICKNAME, PROFILE_IMG, MEMBER_NO,
         (SELECT COUNT(*) FROM "BOARRD_LIKE" L
         WHERE L.BOARD_NO = B.BOARD_NO) LIKE_COUNT
         
FROM "BOARD" B
JOIN "MEMBER" USING (MEMBER_NO)
WHERE BOARD_DEL_FL = 'N'
AND BOARD_CODE = #{boardCode}
AND BOARD_NO = #{boardNO}

-- 특정 게시글의 댓글 목록 조회(버전1)
-- 게시글 번호 1483 1480

SELECT LEVEL, C.* FROM
	(SELECT COMMENT_NO, COMMENT_CONTENT,
	TO_CHAR(COMMENT_WRITE_DATE, 'YYYY"년" MM"월" DD"일" HH24"시" MI"분" SS"초"') COMMENT_WRITE_DATE,
	BOARD_NO, MEMBER_NO, MEMBER_NICKNAME, PROFILE_IMG, PARENT_NO, COMMENT_DEL_FL
FROM "COMMENT"
JOIN MEMBER USING(MEMBER_NO)
WHERE BOARD_NO = 1480) C
WHERE COMMENT_DEL_FL = 'N'
START WITH PARENT_NO IS NULL
CONNECT BY PRIOR COMMENT_NO = PARENT_NO
ORDER SIBLINGS BY COMMENT_NO


-- START WITH PARENT_NO IS NULL : 
-- PARENT_NO가 없는 댓글이 계층의 시작 지점이다

-- CONNECT BY PRIOR COMMENT_NO = PARENT_NO : 
-- PARENT_NO COMMENT_NO가 같은 행을 연결

-- ORDER SIBLINGS BY COMMENT_NO :
-- 계층 구조 정렬 순서

-- LEVEL : 계층의 단계를 출력하는 가상 컬럼

-----------------------------------
-- 대댓글 샘플 데이터 삽입

 INSERT INTO "COMMENT" 
      VALUES(SEQ_COMMENT_NO.NEXTVAL, '자식 댓글 1', DEFAULT, DEFAULT,
            1, 1480, 762);

           
           
 
 SELECT * FROM BOARD_LIKE;   
           
SELECT FROM "BOARD_LIKE"
WHERE BOARD_NO = 1500
AND MEMBER_NO =1;


DELETE FROM "BOARD_LIKE"
WHERE MEMBER_NO = 10
AND BOARD_NO = 1500;

ROLLBACK;

UPDATE "MEMBER" SET 
PROFILE_IMG = '/images/member/OIP.jpg'
WHERE MEMBER_NO = '6';

COMMIT;

/* SEQ_IMG_NO 시퀀스 번호를 하나 생성해서 반환하는 함수 생성 */

CREATE OR REPLACE FUNCTION NEXT_IMG_NO
RETURN NUMBER 
IS NUM NUMBER;
BEGIN 
   SELECT SEQ_IMG_NO.NEXTVAL 
   INTO NUM
   FROM DUAL;
   
   RETURN NUM;
END;


/* 한 번에 여러행 삽입하기 (INSERT + 서브쿼리) */

INSERT INTO "BOARD_IMG"

SELECT SEQ_IMG_NO.NEXTVAL, '경로', '변경된 이름', '원본이름', 0, 1496 FROM DUAL
UNION
SELECT SEQ_IMG_NO.NEXTVAL, '경로2', '변경된 이름2', '원본이름2', 2, 1496 FROM DUAL
UNION
SELECT SEQ_IMG_NO.NEXTVAL, '경로3', '변경된 이름3', '원본이름3', 3, 1496 FROM DUAL;

ROLLBACK;

DELETE FROM "BOARD_IMG"
WHERE BOARD_NO = #{boardNo}
AND IMG_ORDER IN (0,1,2,3);

SELECT * FROM BOARD_IMG

-- 채팅

CREATE TABLE "CHATTING_ROOM" (
	"CHATTING_NO"	NUMBER		NOT NULL,
	"CREATE_DATE"	DATE	DEFAULT SYSDATE	NOT NULL,
	"OPEN_MEMBER"	NUMBER		NOT NULL,
	"PARTICIPANT"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "CHATTING_ROOM"."CHATTING_NO" IS '채팅방 번호';

COMMENT ON COLUMN "CHATTING_ROOM"."CREATE_DATE" IS '채팅방 생성일';

COMMENT ON COLUMN "CHATTING_ROOM"."OPEN_MEMBER" IS '개설자 회원 번호';

COMMENT ON COLUMN "CHATTING_ROOM"."PARTICIPANT" IS '참여자 회원 번호';

CREATE TABLE "MESSAGE" (
	"MESSAGE_NO"	NUMBER		NOT NULL,
	"MESSAGE_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"READ_FL"	CHAR	DEFAULT 'N'	NOT NULL,
	"SEND_TIME"	DATE	DEFAULT SYSDATE	NOT NULL,
	"SENDER_NO"	NUMBER		NOT NULL,
	"CHATTING_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "MESSAGE"."MESSAGE_NO" IS '메세지 번호';

COMMENT ON COLUMN "MESSAGE"."MESSAGE_CONTENT" IS '메세지 내용';

COMMENT ON COLUMN "MESSAGE"."READ_FL" IS '읽음 여부';

COMMENT ON COLUMN "MESSAGE"."SEND_TIME" IS '메세지 보낸 시간';

COMMENT ON COLUMN "MESSAGE"."SENDER_NO" IS '보낸 회원의 번호';

COMMENT ON COLUMN "MESSAGE"."CHATTING_NO" IS '채팅방 번호';



CREATE SEQUENCE SEQ_ROOM_NO NOCACHE;
CREATE SEQUENCE SEQ_MESSAGE_NO NOCACHE;


ALTER TABLE "CHATTING_ROOM" ADD CONSTRAINT "PK_CHATTING_ROOM" PRIMARY KEY (
	"CHATTING_NO"
);

ALTER TABLE "MESSAGE" ADD CONSTRAINT "PK_MESSAGE" PRIMARY KEY (
	"MESSAGE_NO"
);

ALTER TABLE "CHATTING_ROOM" ADD CONSTRAINT "FK_MEMBER_TO_CHATTING_ROOM_1" FOREIGN KEY (
	"OPEN_MEMBER"
)
REFERENCES "MEMBER" (
	"MEMBER_NO"
) ON DELETE CASCADE;

ALTER TABLE "CHATTING_ROOM" ADD CONSTRAINT "FK_MEMBER_TO_CHATTING_ROOM_2" FOREIGN KEY (
	"PARTICIPANT"
)
REFERENCES "MEMBER" (
	"MEMBER_NO"
) ON DELETE CASCADE;

ALTER TABLE "MESSAGE" ADD CONSTRAINT "FK_MEMBER_TO_MESSAGE_1" FOREIGN KEY (
	"SENDER_NO"
)
REFERENCES "MEMBER" (
	"MEMBER_NO"
) ON DELETE CASCADE;

ALTER TABLE "MESSAGE" ADD CONSTRAINT "FK_CHATTING_ROOM_TO_MESSAGE_1" FOREIGN KEY (
	"CHATTING_NO"
)
REFERENCES "CHATTING_ROOM" (
	"CHATTING_NO"
) ON DELETE CASCADE;