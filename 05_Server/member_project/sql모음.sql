-- 로그인 (test_member1, pw1234)

SELECT MEMBER_NO , MEMBER_ID , MEMBER_NAME , GENDER ,
	TO_CHAR(ENROLL_DATE, 'YYYY"년" MM"월" DD"일" HH24:MI:SS') ENROLL_DATE 
FROM TB_MEMBER
WHERE MEMBER_ID = 'test_member1'
AND MEMBER_PW = 'pw1234';

-- 회원 목록 조회
SELECT MEMBER_NO, MEMBER_ID, MEMBER_NAME, MEMBER_PW
	DECODE(GENDER, 'M', '남성', 'F', '여성') AS GENDER,
	TO_CHAR(ENROLL_DATE, 'YYYY"년" MM"월" DD"일" HH24:MI:SS') ENROLL_DATE
FROM TB_MEMBER 
ORDER BY MEMBER_NO DESC;

-- 회원 가입(Insert)

INSERT INTO TB_MEMBER 
VALUES(SEQ_MEMBER_NO.NEXTVAL, ?, ?, ?, ? ,DEFAULT)

