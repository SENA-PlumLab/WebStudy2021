CREATE TABLE member(
	memNum varchar2(8) PRIMARY key, -- mem-0001
	memId varchar2(100), -- @를 포함하게
	mempw varchar2(20), -- 8~12자 영어 숫자 섞어서 + 정규표현식 필요
	memimg varchar2(500), -- 링크
	memnick varchar2(50),
	memtext varchar2(500),
	memphone varchar2(13), -- -포함 13자
	memreport number, --신고누적횟수
	memjoinDate date, --가입일자
	memmodDate date, --수정일자
	memgradenum NUMBER  -- 0 활동정지됨, 1 일반회원, 2크리에이터, 3 우수 크리에이터, 10 관리자
);

INSERT INTO member VALUES ('mem-0001', 'naver@naver.com', 'naver1999', '../image/naver.jpg',
'naverking', '안녕하세요~ 네이버 대표입니다.', '010-1588-3820', 0, sysdate, to_date('2021-8-5 09:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1);
INSERT INTO member VALUES ('mem-0002', 'nyanya@gmail.com', 'nyanya2', '../image/nyanya.jpg',
'nyanya', '안녕하세요~ 고양이를 사랑하는 냐냐입니다~', '010-5252-5252', 3, to_date('2021-7-12 14:21:33', 'YYYY-MM-DD HH24:MI:SS'), to_date('2021-8-8 12:52:00', 'YYYY-MM-DD HH24:MI:SS'), 2);
INSERT INTO member VALUES ('mem-0003', 'ducku@gmail.com', 'ducku5252', '../image/ducku.jpg',
'ducku', '포스트잇 메모지 스티커 제작하는 ducku입니다. 오리 넘나 사랑스러운 것♡', '010-2525-2525', 0, to_date('2021-6-10 17:32:15', 'YYYY-MM-DD HH24:MI:SS'), sysdate, 3);
INSERT INTO member VALUES ('mem-0004', 'MOPadmin@naver.com', 'MOP2021', '../image/MOPadmin.png',
'MOPadmin', 'My One Pick 관리자입니다.', '010-0000-0000', 0, to_date('1999-1-1 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), sysdate, 10);
INSERT INTO member VALUES ('mem-0005', 'guest@naver.com', 'guest1234', '../image/guest.jpg',
'ghost', '오늘은 어떤 크리에이터를 팔로우할까~?', '010-1234-1234', 15, to_date('2021-7-12 23:11:42', 'YYYY-MM-DD HH24:MI:SS'), to_date('2021-8-1 09:00:00', 'YYYY-MM-DD HH24:MI:SS'), 0);


INSERT INTO member08 VALUES ('mem-'||mem_seq.nextval, 'guest@naver.com', 'guest1234', '../image/guest.jpg',
'ghost', '오늘은 어떤 크리에이터를 팔로우할까~?', '010-1234-1234', 15, to_date('2021-7-12 23:11:42', 'YYYY-MM-DD HH24:MI:SS'), to_date('2021-8-1 09:00:00', 'YYYY-MM-DD HH24:MI:SS'), 0);

DELETE FROM MEMBER
WHERE memNum = 'mem-1004';

CREATE SEQUENCE mem_seq_8
	INCREMENT BY 1
	START WITH 1001
	MINVALUE 1001
	MAXVALUE 9999;
-- mem_seq.nextval 으로 사용

SELECT * FROM member;



SELECT * FROM member08;



CREATE TABLE portfolio(
	pfNum varchar2(8) PRIMARY key, -- pfn-0001
	memNum varchar2(8),
	pfTitle varchar2(90),
	pfContentvarchar2(3000),
	pfFile varchar2(300),
	pfLink varchar2(300),
	pfStateNum number
);

INSERT INTO portfolio VALUES ('pfn-0001', 'mem-0001', '떡메모지 굿즈 제작 포트폴리오', '떡메모지로 굿즈를 제작하여 판매한 경험이 있음', '../image/memo.jpg', 'http://www.meno.com/', 3);
INSERT INTO portfolio VALUES ('pfn-0002', 'mem-0001', '일러스트 포트폴리오', '첨부파일 확인', 'ai.zip', '', 0);
INSERT INTO portfolio VALUES ('pfn-0003', 'mem-0002', '공책 제작 판매 포트폴리오', '링크 확인', '', 'http://www.nyanya.com', 2);
INSERT INTO portfolio VALUES ('pfn-0004', 'mem-0003', '이벤트 부스 참가 포트폴리오', '링크 및 첨부파일 확인', '', 'http://www.duckt.com', 2);

SELECT * FROM portfolio;

DROP TABLE portfolio;




CREATE TABLE pfstate(
	pfStateNum number, -- 0 등록중, 1 제출, 2 심사완료-통과, 3 심사완료-미통과
	pfState varchar2(30) 
);

INSERT INTO pfstate values(0, '등록중');
INSERT INTO pfstate values(1, '제출');
INSERT INTO pfstate values(2, '심사완료(통과)');
INSERT INTO pfstate values(3, '심사완료(미통과)');

SELECT * FROM pfstate;

DROP table pfstate;


CREATE TABLE address(
	addressNum varchar2(8) PRIMARY key, -- add-0001
	memNum varchar2(8),
	defaultAddress varchar2(100),
	detailAddress varchar2(100)
);

INSERT INTO address VALUES ('add-0001', 'mem-0001', '경기도 성남시 분당구', '네이버빌딩 304호');
INSERT INTO address VALUES ('add-0002', 'mem-0001', '경기도 성남시 중원구', '네이버빌딩(중원구)');
INSERT INTO address VALUES ('add-0003', 'mem-0002', '서울 강남구 역삼동', '우주아파트 803호');
INSERT INTO address VALUES ('add-0004', 'mem-0003', '부산 동구 중앙대로', '시영여주아파트 1101호');
INSERT INTO address VALUES ('add-0005', 'mem-0004', '서울 강남구 테헤란로 132', '(역삼동) 한독약품 빌딩 8층');
INSERT INTO address VALUES ('add-0006', 'mem-0005', '강원도 춘천시 동내면 동내로', '봄내빌라 201호');

SELECT * FROM address;

CREATE TABLE payment(
	payNum varchar2(8) PRIMARY key, -- pay-0001
	memNum varchar2(8),
	bankName varchar2(20),
	cardNum varchar2(19) --  -포함 19자
);
-- 국민, 우리, 하나, 카카오, 농협 5개
INSERT INTO payment VALUES ('pay-0001', 'mem-0001', '국민', '0000-0000-0000-0000');
INSERT INTO payment VALUES ('pay-0002', 'mem-0001', '우리', '0000-0000-0000-0000');
INSERT INTO payment VALUES ('pay-0003', 'mem-0002', '하나', '0000-0000-0000-0000');
INSERT INTO payment VALUES ('pay-0004', 'mem-0003', '카카오', '0000-0000-0000-0000');
INSERT INTO payment VALUES ('pay-0005', 'mem-0004', '카카오', '0000-0000-0000-0000');
INSERT INTO payment VALUES ('pay-0006', 'mem-0005', '농협', '0000-0000-0000-0000');

SELECT * FROM PAYMENT;



CREATE TABLE MEMGRADE(
	MEMGRADENum number, -- 0 활동정지됨, 1 일반회원, 2크리에이터, 3 우수 크리에이터, 10 관리자
	memgrade varchar2(50) 
);

INSERT INTO MEMGRADE values(0, '활동정지됨');
INSERT INTO MEMGRADE values(1, '일반회원');
INSERT INTO MEMGRADE values(2, '크리에이터');
INSERT INTO MEMGRADE values(3, '우수크리에이터');
INSERT INTO MEMGRADE values(10, '관리자');

SELECT * FROM MEMGRADE;

/*
	mem-0001 : 회원번호
	pfn-0001 : 포트폴리오번호
	add-0001 : 주소번호
	pay-0001 : 결제수단번호
*/



-- 결제수단
SELECT p.memNum, p.PAYNUM, p.bankName, p.cardNum
FROM MEMBER m, payment p
WHERE m.memNum = p.memNum 
AND m.memNum = 'mem-0001';

-- 배송지
SELECT a.memNum, a.addressNum, a.defaultAddress, a.detailAddress
FROM MEMBER m, address a 
WHERE m.memNum = a.memNum
AND m.memNum = 'mem-0001';


-- 

SELECT * FROM MEMBER
WHERE MEMid = 'naver@naver.com'
AND mempw = 'naver1999';


SELECT pfNum, memNum, PFTITLE, nvl(PFCONTENT, ' ') PFCONTENT, nvl(PFFILE , ' ') PFFILE, nvl(PFLINK , ' '), pfStateNum PFLINK FROM portfolio 
WHERE memNum = 'mem-0001';



CREATE SEQUENCE pfn_seq_8
	INCREMENT BY 1
	START WITH 1001
	MINVALUE 1001
	MAXVALUE 9999;
-- pfn_seq_8.nextval 으로 사용



INSERT INTO portfolio VALUES ('pfn-'||pfn_seq_8.nextval, 'mem-1001', '떡메모지 굿즈 제작 포트폴리오', '떡메모지로 굿즈를 제작하여 판매한 경험이 있음', '../image/memo.jpg', 'http://www.meno.com/', 3);


SELECT * FROM PORTFOLIO;


DELETE FROM portfolio
WHERE pfnum = 'pfn-1003';


SELECT * FROM PORTFOLIO
WHERE PFNUM ='pfn-0001';


UPDATE portfolio
	SET PFTITLE = '',
		PFCONTENT ='',
		PFFILE = '',
		PFLINK = ''
	WHERE PFNUM = 'pfn-1007'

DELETE FROM portfolio WHERE PFNUM = 'pfn-1006';


/* 아이디 찾기 */
SELECT * FROM MEMBER
WHERE memphone='010-0000-0000';
