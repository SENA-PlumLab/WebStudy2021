CREATE TABLE memberProfile(
	memberNum char(8),
	grade varchar2(20),
	name varchar2(20),
	phone varchar2(20),
	pccc char(13), -- 고정형 데이터
	email varchar2(40),
	ableToGetInform varchar2(20)
);
INSERT INTO memberProfile values('M0002154','GRADE2',
		'홍길동','010-1234-5678',NULL,'qwerty@gamil.com', 'true');
INSERT INTO memberProfile values('M0002155','GRADE7',
		'한라봉','010-7878-1122',NULL,'rabong@gamil.com', 'false');
INSERT INTO memberProfile values('M0002156','GRADE10',
		'이민형','010-6666-0423',NULL,'marky@naver.com', 'true');
	
SELECT *
FROM MEMBERPROFILE;
//-----------------------------------------
	
	
CREATE TABLE coupons(
	memberNum char(8),
	couponNum char(16),
	name varchar2(40),
	lmit varchar2(40),
	status varchar2(40),
	regDate Date,
	limitDate Date,
	usedDate Date
);
INSERT INTO coupons values('M0002154', '0QTV8560PUIK0PQ1', '회원가입 쿠폰 - 10%할인', '최대 할인액 : 5,000원', 'NOTUSED',
				'2021-05-29', '2021-06-29',null);
INSERT INTO coupons values('M0002154', '2NSRO39ENRO2OSEM', '6월 쿠폰 - 1만원 배송쿠폰', '배송료 10,000원 할인', 'NOTUSED',
				'2021-06-01', '2021-06-30',null);
INSERT INTO coupons values('M0002154', 'U2SJDNSE2JEWP1A1', '전자제품 쿠폰 - 30%할인', '최대 할인액 : 15,000원', 'USED',
				'2021-04-23', '2021-06-05','2021-04-29');
			
SELECT *
FROM COUPONS;
DROP TABLE COUPONS;
//-----------------------------------------

CREATE TABLE deposit(
	memberNum char(8),
	balance number,
	orderNum char(7),
	productNum char(7),
	kind varchar2(40),
	amount number,
	usedDate Date,
	info varchar2(40)
);

INSERT INTO deposit values('M0002154', 125000, 'O-00454', 'P-04311', 'deposit_used', 500, 
							'2018-05-05', '예치금 사용');
INSERT INTO deposit values('M0002154', 25000, 'O-00884', 'P-05522', 'deposit_used', 100000, 
							'2018-07-01', '예치금 사용');
INSERT INTO deposit values('M0002154', 15000, 'O-01215', 'P-00121', 'deposit_used', 10000, 
							'2018-07-29', '예치금 사용');
SELECT *
FROM DEPOSIT;
//-----------------------------------------
						
						
CREATE TABLE guaranty(
	memberNum char(8),
	balance number,
	orderNum char(7),
	productNum char(7),
	kind varchar2(40),
	amount number,
	usedDate Date,
	info varchar2(40)
);

INSERT INTO guaranty values('M0002154', 125000, 'O-00454', 'P-04311', 'guaranty_used', 500, 
							'2018-05-05', '보증금 사용');
INSERT INTO guaranty values('M0002154', 25000, 'O-00884', 'P-05522', 'guaranty_used', 50000, 
							'2018-07-01', '보증금 사용');
INSERT INTO guaranty values('M0002154', 15000, 'O-01215', 'P-00121', 'guaranty_used', 8000, 
							'2018-07-29', '보증금 사용');
						
SELECT *
FROM GUARANTY;

//-----------------------------------------


CREATE TABLE ordered(
	memberNum char(8),
	orderNum char(7),
	orderDate Date,
	productNum char(7),
	name varchar2(40),
	price number,
	paidByCoupons number,
	paidByDeposit number,
	paidByGuaranty number,
	paidByMoney number
);

INSERT INTO ordered values('M0002154', 'O-00454', '2018-05-05', 'P-04311', '컵라면', 6000, 0, 500, 500, 5000);
INSERT INTO ordered values('M0002154', 'O-00884', '2018-07-01', 'P-05522', '모니터', 200000, 0, 100000, 50000, 50000);
INSERT INTO ordered values('M0002154', 'O-01215', '2018-07-29', 'P-00121', '거울', 50000, 0, 10000, 8000, 32000);
SELECT *
FROM ORDERED;
//-----------------------------------------


CREATE TABLE inquiry(
	memberNum char(8),
	inNum char(7),
	title varchar2(40),
	inDate date,
	status varchar2(20)
);
INSERT INTO inquiry values('M0002154', 'Q-01245', '문의제목1', '2017-05-02','REPLIED');
INSERT INTO inquiry values('M0002154', 'Q-05425', '문의제목2', '2017-12-29','REPLIED');
SELECT *
FROM INQUIRY;
//-----------------------------------------

CREATE TABLE collection(
	productNum char(7),
	name varchar2(40),
	price number
);
INSERT INTO collection VALUES ('P-00001', '마라탕', 15000);
INSERT INTO collection VALUES ('P-00462', '초코파이', 2000);
INSERT INTO collection VALUES ('P-04503', '선풍기', 50000);
SELECT *
FROM COLLECTION;
//-----------------------------------------
	