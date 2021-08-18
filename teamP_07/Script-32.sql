SELECT * FROM MEMBER;



--java에 쓰는 쿼리문
SELECT m.memnum, memid, memgrade, pftitle, pfnum, pfstatenum
FROM MEMBER m, MEMGRADE m2, PORTFOLIO p
WHERE m.memnum=p.memnum AND m.memgradenum = m2.memgradenum 
AND m.memgradenum=1 AND pfstatenum=1;
-- 0:등록중, 1: 제출, 2: 통과, 3:반려

SELECT memnum, memid, memnick, memreport, memjoindate, memgrade 
FROM MEMBER m, MEMGRADE m2 
WHERE m.memgradenum = m2.memgradenum
ORDER BY m.memgradenum;

UPDATE MEMBER m SET (memgradenum, memmodDate)=(
				SELECT memgradenum+1, sysdate 
				FROM MEMBER 
				WHERE memnum='mem-1022') 
		WHERE (memnum='mem-1022');
		
UPDATE MEMBER m SET (memgradenum, memmodDate)
				=(SELECT 1, sysdate FROM dual) 
		WHERE memnum IN ('mem-0002', 'mem-1005');
	
UPDATE PORTFOLIO m SET PFSTATENUM=1
		WHERE memnum IN ('mem-0002', 'mem-1005');	
	
INSERT INTO PORTFOLIO VALUES ('pfn-1005', 'mem-1005', '어쩌구 테스트 포트폴리오', '스티커 일러스트', '', '', 1);




--------------------
--직원유저 권한
CREATE TABLE emp_auth_tb (
	emp_auth_pk number CONSTRAINTS emp_auth_pk PRIMARY KEY,
	auth_name varchar2(100) CONSTRAINTS auth_name_nn NOT NULL
);
DROP TABLE emp_auth_tb;
INSERT INTO emp_auth_tb VALUES (1, '사원'); --조회만 가능
INSERT INTO emp_auth_tb VALUES (2, '회원관리 가능'); 
INSERT INTO emp_auth_tb VALUES (3, '신고관리 가능'); 
INSERT INTO emp_auth_tb VALUES (4, '상품관리 가능'); 
INSERT INTO emp_auth_tb VALUES (10, '직원 관리 가능'); 
--직원 직책
CREATE TABLE emp_pos_tb (
	emp_pos_pk number CONSTRAINTS emp_pos_pk PRIMARY KEY,
	pos_name varchar2(100) CONSTRAINTS pos_name_nn NOT NULL
);
DROP TABLE emp_pos_tb;
INSERT INTO emp_pos_tb VALUES (1011, '인사팀 사원'); 
INSERT INTO emp_pos_tb VALUES (1030, '인사팀 팀장'); 
INSERT INTO emp_pos_tb VALUES (2011, '개발팀 사원'); 
INSERT INTO emp_pos_tb VALUES (2030, '개발팀 팀장'); 
INSERT INTO emp_pos_tb VALUES (3011, '총무팀 사원'); 
INSERT INTO emp_pos_tb VALUES (3030, '총무팀 팀장'); 
SELECT * FROM emp_pos_tb;
----------------------------------------------------


-- 직원 테이블
CREATE SEQUENCE emp_SEQ --시퀀스이름 EX_SEQ
INCREMENT BY 1 --증감숫자 1
START WITH 1 --시작숫자 1
MINVALUE 1 --최소값 1
MAXVALUE 1000 --최대값 1000
NOCYCLE;

CREATE TABLE emp_tb (
	eeeNum_PK varchar2(9) CONSTRAINT emptb_eeenum_pk PRIMARY KEY,
	emp_Auth NUMBER, 
	emp_Pos NUMBER,
	emp_id varchar2(16) CONSTRAINTS emptb_id_nn NOT NULL,
	emp_pw varchar2(16) CONSTRAINTS emptb_pw_nn NOT NULL,
	emp_name varchar2(16) CONSTRAINTS emptb_name_nn NOT NULL,
	emp_tel varchar2(16) CONSTRAINTS emptb_tel_nn NOT NULL,
	emp_email varchar2(16) CONSTRAINTS emptb_email_nn NOT NULL,
	income_date DATE,
	edit_date DATE,
	CONSTRAINT emptb_Auth_fk FOREIGN KEY (emp_Auth) references emp_Auth_tb(emp_Auth_pk),
	 CONSTRAINTS emptb_Pos_fk FOREIGN KEY (emp_Pos) references emp_pos_tb(emp_Pos_pk)
);
ALTER TABLE emp_tb ADD CONSTRAINT emptb_id_uq UNIQUE(emp_id);

DROP TABLE emp_tb;

ALTER TABLE emp_tb MODIFY eeeNum_PK default 'eee-'||trim(to_char(emp_SEQ.nextval,'0000'));
INSERT INTO emp_tb(emp_Auth, emp_Pos, emp_id, emp_pw, emp_name, emp_tel, emp_email, income_date) 
		values(10, 1030, 'himan', 'tiger', '곽두철', '010-1234-1234', '1234@naver.com', sysdate);
INSERT INTO emp_tb(emp_Auth, emp_Pos, emp_id, emp_pw, emp_name, emp_tel, emp_email, income_date) 
		values(2, 1011, 'himan2', 'tiger', '정형돈', '010-1234-1234', '1234@naver.com', sysdate);
INSERT INTO emp_tb(emp_Auth, emp_Pos, emp_id, emp_pw, emp_name, emp_tel, emp_email, income_date) 
		values(3, 3030, 'himan3', 'tiger', '케이팝', '010-1234-1234', '1234@naver.com', sysdate);
SELECT * FROM emp_tb;

---------------------------------------------------
-- 멤버 로그 트리거

CREATE SEQUENCE mblog_SEQ --시퀀스이름 EX_SEQ
INCREMENT BY 1 --증감숫자 1
START WITH 1 --시작숫자 1
MINVALUE 1 --최소값 1
MAXVALUE 1000 --최대값 1000
NOCYCLE;


CREATE TABLE member_log(
	memlog_pk varchar2(16) CONSTRAINTS mblog_memlog_pk PRIMARY KEY,
    memo VARCHAR2(20),
    income_date DATE DEFAULT SYSDATE
);
ALTER TABLE member_log MODIFY memlog_pk default 'memlog-'||trim(to_char(emp_SEQ.nextval,'0000'));

DROP TABLE member_log;
DROP TRIGGER member_trigger;

CREATE OR REPLACE TRIGGER member_trigger
   AFTER DELETE OR INSERT OR UPDATE ON member
BEGIN
  -- 삽입할 때
   IF INSERTING THEN -- 이 트리거를 가진 ExamData에 insert 문장이 실행되면 밑에것(ExamMeno에 insert)도 실행
      INSERT INTO member_log(memo) VALUES ('insert');
  -- 수정할 때
   ELSIF UPDATING THEN -- 이 트리거를 가진 ExamData에 update 문장이 실행되면 밑에것(ExamMeno에 update)도 실행
      INSERT INTO member_log(memo) VALUES ('update');
  -- 삭제할 때
   ELSIF DELETING THEN -- 이 트리거를 가진 ExamData에 delete 문장이 실행되면 밑에것(ExamMeno에 delete)도 실행
      INSERT INTO member_log(memo) VALUES ('delete');
   END IF;
END;

UPDATE MEMBER SET memgradenum=1 WHERE memnum='mem-0002';
SELECT * FROM member_log;
--------------------------------------------------------------



--------------------------------------------------------



----------------------------------------------
--콘텐츠 로그 트리거

CREATE SEQUENCE cttlog_SEQ --시퀀스이름 EX_SEQ
INCREMENT BY 1 --증감숫자 1
START WITH 1 --시작숫자 1
MINVALUE 1 --최소값 1
MAXVALUE 9999 --최대값 1000
NOCYCLE;

CREATE TABLE ctt_log(
	cttlog_pk varchar2(16) CONSTRAINTS cttlog_pk PRIMARY KEY,
	kind varchar2(20),
    memo VARCHAR2(20),
    income_date DATE DEFAULT SYSDATE
);
DROP TABLE ctt_log;
ALTER TABLE ctt_log MODIFY cttlog_pk default 'cttlog-'||trim(to_char(cttlog_SEQ.nextval,'0000'));

SELECT * FROM ctt_log;

CREATE OR REPLACE TRIGGER fd_trigger
   AFTER DELETE OR INSERT OR UPDATE ON funding
BEGIN
  -- 삽입할 때
   IF INSERTING THEN -- 이 트리거를 가진 ExamData에 insert 문장이 실행되면 밑에것(ExamMeno에 insert)도 실행
      INSERT INTO ctt_log(kind, memo) VALUES ('funding','0000'),'insert');
  -- 수정할 때
   ELSIF UPDATING THEN -- 이 트리거를 가진 ExamData에 update 문장이 실행되면 밑에것(ExamMeno에 update)도 실행
      INSERT INTO ctt_log(kind, memo) VALUES ('funding', 'update');
  -- 삭제할 때
   ELSIF DELETING THEN -- 이 트리거를 가진 ExamData에 delete 문장이 실행되면 밑에것(ExamMeno에 delete)도 실행
      INSERT INTO ctt_log(kind, memo) VALUES ('funding', 'delete');
   END IF;
END;

CREATE OR REPLACE TRIGGER cmt_trigger
   AFTER DELETE OR INSERT OR UPDATE ON COMMENTs
BEGIN
  -- 삽입할 때
   IF INSERTING THEN -- 이 트리거를 가진 ExamData에 insert 문장이 실행되면 밑에것(ExamMeno에 insert)도 실행
      INSERT INTO ctt_log(kind, memo) VALUES ('funding', 'insert');
  -- 수정할 때
   ELSIF UPDATING THEN -- 이 트리거를 가진 ExamData에 update 문장이 실행되면 밑에것(ExamMeno에 update)도 실행
      INSERT INTO ctt_log(kind, memo) VALUES ('comment', 'update');
  -- 삭제할 때
   ELSIF DELETING THEN -- 이 트리거를 가진 ExamData에 delete 문장이 실행되면 밑에것(ExamMeno에 delete)도 실행
      INSERT INTO ctt_log(kind, memo) VALUES ('comment', 'delete');
   END IF;
END;

UPDATE COMMENTS SET CMTCONTENT='수정해보고싶어요' WHERE cmtnum='cmt-0031';

CREATE OR REPLACE TRIGGER bbs_trigger
   AFTER DELETE OR INSERT OR UPDATE ON bbs
BEGIN
  -- 삽입할 때
   IF INSERTING THEN -- 이 트리거를 가진 ExamData에 insert 문장이 실행되면 밑에것(ExamMeno에 insert)도 실행
      INSERT INTO ctt_log(kind, memo) VALUES ('bbs', 'insert');
  -- 수정할 때
   ELSIF UPDATING THEN -- 이 트리거를 가진 ExamData에 update 문장이 실행되면 밑에것(ExamMeno에 update)도 실행
      INSERT INTO ctt_log(kind, memo) VALUES ('bbs','update');
  -- 삭제할 때
   ELSIF DELETING THEN -- 이 트리거를 가진 ExamData에 delete 문장이 실행되면 밑에것(ExamMeno에 delete)도 실행
      INSERT INTO ctt_log(kind, memo) VALUES ('bbs','delete');
   END IF;
END;

UPDATE bbs SET bbstitle='수정해보고싶어요' WHERE bbsnum='bbs-0057';


SELECT * FROM ctt_log ORDER BY INCOME_DATE desc;
SELECT * FROM member_log;




----------------------------------------------
--신고 테이블

CREATE SEQUENCE report_SEQ --시퀀스이름 EX_SEQ
INCREMENT BY 1 --증감숫자 1
START WITH 1 --시작숫자 1
MINVALUE 1 --최소값 1
MAXVALUE 9999 --최대값 1000
NOCYCLE;


CREATE TABLE report (
	rptnum varchar2(9) CONSTRAINTS report_rptnum_pk PRIMARY KEY,
	memnum varchar2(8),
	memnum2 varchar2(8),
	income DATE DEFAULT sysdate,
	edit_Date DATE,
	statusnum NUMBER DEFAULT 2,
	eeenum varchar2(9),
	cttnum varchar2(8) CONSTRAINTS report_cttnum_nn NOT NULL,
	CONSTRAINT report_memnum_fk FOREIGN KEY (memnum) references member(memnum),
	CONSTRAINT report_memnum2_fk FOREIGN KEY (memnum2) references member(memnum),
	CONSTRAINT report_statusnum_fk FOREIGN KEY (statusnum) references status(statusnum),
	CONSTRAINT report_eeenum_fk FOREIGN KEY (eeenum) references emp_tb(eeenum_pk)
);
DROP TABLE report;
ALTER TABLE report MODIFY rptnum default 'rpt-'||trim(to_char(report_SEQ.nextval,'0000'));
ALTER TABLE report MODIFY edit_date DEFAULT sysdate;

CREATE OR REPLACE TRIGGER report_trigger
   AFTER DELETE OR INSERT OR UPDATE ON report
BEGIN
  -- 삽입할 때
   IF INSERTING THEN -- 이 트리거를 가진 ExamData에 insert 문장이 실행되면 밑에것(ExamMeno에 insert)도 실행
      INSERT INTO ctt_log(kind, memo) VALUES ('report', 'insert');
  -- 수정할 때
   ELSIF UPDATING THEN -- 이 트리거를 가진 ExamData에 update 문장이 실행되면 밑에것(ExamMeno에 update)도 실행
      INSERT INTO ctt_log(kind, memo) VALUES ('report','update');
  -- 삭제할 때
   ELSIF DELETING THEN -- 이 트리거를 가진 ExamData에 delete 문장이 실행되면 밑에것(ExamMeno에 delete)도 실행
      INSERT INTO ctt_log(kind, memo) VALUES ('report','delete');
   END IF;
END;

SELECT * FROM CTT_LOG cl ;

--신고접수
INSERT INTO report(memnum, memnum2, cttnum) VALUES ('mem-0002', 'mem-0003', 'cmt-0041');
--신고 조작
UPDATE report SET (edit_date, statusnum, eeenum)=(
					SELECT sysdate, 1, 'eee-0005'
					FROM dual) 
WHERE rptnum='rpt-0004';
UPDATE MEMBER SET memreport=memreport+1 WHERE memnum='mem-0003';
--확인
SELECT * FROM report;
SELECT * FROM MEMBER;
SELECT * FROM CTT_LOG cl ORDER BY INCOME_DATE desc;

---------------------------------------------------------------

--로그인
SELECT EEENUM_PK ,EMP_ID , EMP_PW , EMP_NAME, EMP_AUTH , auth_name, pos_name
FROM EMP_TB et, EMP_AUTH_TB eat, EMP_POS_TB ept
WHERE et.EMP_AUTH = eat.EMP_AUTH_PK AND et.EMP_POS =ept.EMP_POS_PK
AND EMP_ID ='himan';

--정보 조회
SELECT et.*, auth_name, pos_name
FROM EMP_TB et, EMP_AUTH_TB eat, EMP_POS_TB ept
WHERE et.EMP_AUTH = eat.EMP_AUTH_PK AND et.EMP_POS =ept.EMP_POS_PK 



/*
CREATE TABLE member_log (
	memlog_pk varchar2(16) CONSTRAINTS mblog_memlog_pk PRIMARY KEY,
	eeenum varchar2(9) CONSTRAINTS mblog_eeenum_nn NOT NULL, 
	memnum varchar2(9) CONSTRAINTS mblog_memnum_nn NOT NULL, 
	event varchar2(3),
	value varchar2(30),
	income_DATE DATE,
	CONSTRAINTS mblog_eeenum_fk FOREIGN KEY (eeenum) references emp(eeenum_pk),
	CONSTRAINTS mblog_memnum_fk foreign KEY (memnum) references member(memnum)
);
DROP TABLE member_log;

ALTER TABLE member_log MODIFY memlog_pk default 'memlog-'||trim(to_char(emp_SEQ.nextval,'0000'));


CREATE OR REPLACE TRIGGER member_trigger
      AFTER DELETE OR INSERT OR UPDATE ON member
      FOR EACH ROW
    BEGIN
		IF inserting THEN 
			INSERT INTO member_log (eeenum, memnum, event, value, income_date)
					values('eee-0005', 'mem-0002', 'I', :NEW.memnum, sysdate )
		elseif updating THEN
			INSERT INTO member_log (eeenum, memnum, event, income_date)
					values('eee-0005','mem-0002', 'U', :NEW.memnum, sysdate )
		elseif deleting THEN
			INSERT INTO member_log (eeenum, memnum, event, income_date)
					values('eee-0005', 'mem-0002', 'D', :NEW.memnum, sysdate )
		END IF;
    END; 

DROP TRIGGER member_trigger;*/