
-- 회원 테이블
CREATE SEQUENCE USER_SQ
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 9999
nocycle;

DROP SEQUENCE member_seq;

CREATE TABLE SY_USER_TB (
	user_cd_pk varchar(9) CONSTRAINT SY_USER_PK PRIMARY KEY,
	user_gb NUMBER, --0:회원탈퇴 1:일반회원 2:SNS가입회원
	user_id varchar2(12), --아이디 6~12
	user_pw varchar2(20), --비밀번호 8~20
	user_nm varchar2(15), --이름
	user_ymd varchar(8),--생년월일
	user_tel varchar2(16), --전화번호
	USER_mail varchar2(60), --이메일
	user_income_dt date, --가입일자
	user_edit_dt DATE --수정일자
);
	 
ALTER TABLE sy_user_tb MODIFY user_pk default 'usr-'||trim(to_char(USER_SQ.nextval,'0000'));
ALTER TABLE sy_user_tb MODIFY user_income_dt DEFAULT sysdate;
ALTER TABLE sy_user_tb MODIFY user_gb DEFAULT 1; 
ALTER TABLE sy_user_tb MODIFY user_id NOT NULL;
ALTER TABLE sy_user_tb MODIFY user_pw NOT NULL;
ALTER TABLE sy_user_tb MODIFY user_nm NOT NULL;
ALTER TABLE sy_user_tb MODIFY user_ymd NOT NULL;
ALTER TABLE sy_user_tb MODIFY user_tel NOT NULL;
ALTER TABLE sy_user_tb MODIFY user_mail NOT NULL;

ALTER TABLE sy_user_tb ADD CONSTRAINT SY_USER_GB_CK CHECK (user_gb BETWEEN 0 AND 2);
ALTER TABLE sy_user_tb ADD CONSTRAINT sy_USER_ID_UQ unique(user_id);
ALTER TABLE sy_user_tb ADD CONSTRAINT sy_user_tel_UQ unique(user_tel);
ALTER TABLE sy_user_tb ADD CONSTRAINT sy_user_mail_UQ unique(user_mail);

INSERT INTO sy_user_tb(user_id, user_pw, user_nm, user_ymd) values('himan', 'tiger', '곽두철', '19670511');
UPDATE sy_user_tb SET (user_tel, user_mail) = (SELECT '01011112222' user_tel, '1234@naver.com' user_mal FROM dual) WHERE user_cd_pk = 'usr-0001';
SELECT * FROM sy_user_tb;

ALTER TABLE sy_user_tb RENAME COLUMN user_pk TO user_cd_pk;

--회원 로그
CREATE SEQUENCE USERLOG_SQ
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 9999
nocycle;

CREATE TABLE SY_USERLOG_TB (
	userLOG_pk varchar(12) CONSTRAINT SY_USERLOG_PK PRIMARY KEY,
	user_cd varchar(9),
	userlog_st NUMBER(1), --1:로그인 0:로그아웃
	userlog_dt DATE DEFAULT sysdate
);
ALTER TABLE sy_userlog_tb ADD CONSTRAINT sy_USER_CD_FK FOREIGN KEY(user_cd) REFERENCES sy_user_tb(user_cd_pk);
ALTER TABLE sy_userlog_tb ADD CONSTRAINT sy_userlog_st_CK check(userlog_st between 0 AND 1); 

ALTER TABLE sy_userlog_tb MODIFY userlog_pk default 'usrlog-'||trim(to_char(USERlog_SQ.nextval,'0000'));


DROP TABLE sy_userlog_tb;
INSERT INTO sy_userlog_tb(user_cd, userlog_st) values('usr-0001', 1);
INSERT INTO sy_userlog_tb(user_cd, userlog_st) values('usr-0001', 0);
SELECT * FROM sy_userlog_tb;

---
--회원가입 sql
INSERT INTO sy_user_tb(user_id, user_pw, user_nm, user_ymd) values('himan', 'tiger', '곽두철', '19670511');
--로그인 로그 sql 
INSERT INTO sy_userlog_tb(user_cd, userlog_st) values('usr-0001', 1);
INSERT INTO sy_userlog_tb(user_cd, userlog_st) values('usr-0001', 0);

