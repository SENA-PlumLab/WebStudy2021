
CREATE TABLE CREATOR (
	creNum VARCHAR2(10) CONSTRAINT Creator_creNum PRIMARY KEY,
	memNum  VARCHAR2(8) CONSTRAINT Creator_memNum_fk NOT NULL REFERENCES MEMBER(MEMNUM)
						ON DELETE CASCADE,
	creProfile VARCHAR2(50),
	creNM VARCHAR2(100),
	creDetail VARCHAR2(500),
	crePage VARCHAR2(100)
	);
	
CREATE TABLE FUNDING (
	fdNum  VARCHAR2(10) CONSTRAINT FUNDING_fdNum PRIMARY KEY,
	creNum  VARCHAR2(10) CONSTRAINT FUNDING_creNum_fk NOT NULL REFERENCES CREATOR(creNum)
						ON DELETE CASCADE,
	fdThemeNum NUMBER CONSTRAINT FUNDING_fdThemeNum_fk NOT NULL REFERENCES fdTheme(fdThemeNum)
						ON DELETE CASCADE, 
	fdProjectNM  VARCHAR2(100),
	fdTargetPrice  NUMBER,
	fdImg  VARCHAR2(100),
	fdCategoryNum NUMBER CONSTRAINT FUNDING_fdCategoryNum_fk NOT NULL REFERENCES fdCategory(fdCategoryNum)
						ON DELETE CASCADE,
	fdRegiDT  DATE,
	fdExpDT  DATE,
	fdTags  VARCHAR2(100),
	fdStoryImg  VARCHAR2(100),
	fdStorySum  VARCHAR2(500),
	fdStory  VARCHAR2(2000),
	fdRefund  VARCHAR2(1000),
	fdPolicy  VARCHAR2(1000),
	statusnum  NUMBER CONSTRAINT FUNDING_statusnum_fk NOT NULL REFERENCES status(statusnum)
						ON DELETE CASCADE
);

DROP TABLE fdCategory;

CREATE TABLE fdCategory (
	fdCategoryNum NUMBER PRIMARY KEY,
	fdCategoryNM varchar2(30)
)

ALTER TABLE FDTHEME ADD CONSTRAINTS fdTheme_fdThemeNum_pk PRIMARY KEY (fdThemeNum);

CREATE SEQUENCE SEQ_crt 
    MINVALUE 1
    MAXVALUE 9999
    INCREMENT BY 1
    START WITH 1;

INSERT INTO member VALUES ('mem-0010', 'bebe@gmail.com', '7777', '../image/bebe.jpg',
'likerose', '이제껏 없었던 스트릿패션을 선보이고싶습니다 :) ', '010-9228-1919', 0, to_date('2021-8-14 20:21:33', 'YYYY-MM-DD HH24:MI:SS'), 
to_date('2021-8-14 08:50:00', 'YYYY-MM-DD HH24:MI:SS'), 2);

INSERT INTO CREATOR VALUES ('crt-'||LPAD(SEQ_crt.nextval, 4, '0'),'mem-0010','../image/bebe.jpg','ROSE UNDER THE LIGHT',
							'이제껏 세상에 없었던 새로운 스트릿패션를 제시합니다. #스트릿패션 #트렌디한의류','www.home.co.kr/roseunderthelight');
INSERT INTO CREATOR VALUES ('crt-0002','mem-0002','../image/nyanya.jpg','nyanya',
							'패션의 중심!','www.home.co.kr/nyanya');
DROP TABLE creator;

DROP SEQUENCE SEQ_crt;
DROP SEQUENCE SEQ_fud;
DROP TABLE funding;

CREATE SEQUENCE SEQ_fud 
    MINVALUE 1
    MAXVALUE 9999
    INCREMENT BY 1
    START WITH 1;
   
   
SELECT CRENUM 
FROM CREATOR c 
WHERE MEMNUM = 'mem-0010';

SELECT * FROM MEMBER;
   
DELETE 

CREATE TABLE FUNDING (

	fdStorySum  VARCHAR2(500),
	fdStory  VARCHAR2(2000),
	fdRefund  VARCHAR2(1000),
	fdPolicy  VARCHAR2(1000),
	statusnum  NUMBER CONSTRAINT FUNDING_statusnum_fk NOT NULL REFERENCES status(statusnum)
						ON DELETE CASCADE
);

INSERT INTO fdCategory VALUES (100, '의류');
INSERT INTO fdCategory VALUES (200, '스티커/지류');
INSERT INTO fdCategory VALUES (300, '문구/오피스');
INSERT INTO fdCategory VALUES (400, '기타');

SELECT * FROM fdCategory;
SELECT * FROM MEMBER;
SELECT * FROM STATUS s;
SELECT * FROM FDTHEME f;
SELECT * FROM creator;
SELECT * FROM funding;
SELECT * FROM COMMENTS c;

SELECT SEQ_fud.currval
FROM dual;

INSERT INTO funding VALUES ('fud-'||LPAD(SEQ_fud.nextval, 4, '0'), 'crt-0001', 2, 
'더블시프트 133 스트리트 탑', 5000000, '../image/clothes2.png', 100, 
to_date('2021-8-17 20:25:00', 'YYYY-MM-DD HH24:MI:SS'),
to_date('2021-12-31 23:59:59', 'YYYY-MM-DD HH24:MI:SS'), '#스트릿패션 #데일리패션', '../image/funding1.png', 
'Rose under the light는 시크하고 차분한 스트릿감성을 추구합니다.<br>스트릿패션은, 시크하지만 우리 일상에 밀접해 있으며 무엇보다 다수의 컬러로 어디에든 잘 어울립니다. 
<br>Rose under the light의 제품들은 오래 입고 오래 사용할 수 있지만 오래된 전통의 느낌이 아닌 
<br> 신선하고 깨끗한 화이트 감성을 담도록 노력하며 그 모습에 잘 어울리는 브랜드를 만들고자 합니다.',
'Rose under the light 는 Slow와 Archive의 조합으로 스트릿패션의 감성을 담는다는 의미로 만들어졌습니다.<br>
창의적으로 생각하고 여유롭게 행동하며 우리 삶에 꼭 필요한 최소한의 제품들로 구성되며 <br>
한 해 입고 버리는 옷이 아닌 5년 이상 사용할 수 있는 품질 좋은 제품을 만듭니다.<br>
이번에 제작된 트리플에이 AFA 스트릿 티셔츠의 모든 패키지는 재활용이 가능한 종이 재질로 제작되었습니다.<br>
 제품의 택, 1차 포장 봉투, 완충재, 2차 택배 봉투 모두 종이 재질로 디자인되었습니다.<br> 
(택배 봉투는 두꺼운 종이에 안쪽 방수 코팅으로 비에 젖지 않으며 제품을 안전하게 보호합니다)', 
'펀딩 결제는 예약 상태로 유지되다가, 펀딩 마감일 다음 영업일 2021.12.31 17시에 모두 함께 진행됩니다. <br>
 결제 정보 변경은 결제가 진행되기 전까지 언제나 가능합니다.<br>
 참여한 펀딩 정보 변경은 펀딩 내역에서 진행해주세요. <br>
마감일 이후에는 펀딩에 대한 리워드 제작 및 배송이 시작되어, 취소와 더불어 배송지 및 리워드 옵션 변경은 해당일 이후로는 불가합니다.', 
'서포터가 수령한 펀딩상품이 하자 기준에 해당할 경우, 배송 완료일로부터 7일 이내에 펀딩금 반환 신청을 할 수 있습니다. <br>
 이때 크리에이터는 하자 판단을 위한 증빙자료, 리워드 반송을 서포터에게 요청할 수 있습니다.',1,7400000); 
 



ALTER TABLE funding
ADD fdingPrice number;

ALTER TABLE funding
ADD fdPercent number;

ALTER TABLE funding
DROP COLUMN fdPercent;

UPDATE funding 
	SET creNum = 'crt-0002'
	WHERE fdingPrice IS NULL;

DELETE FROM funding
WHERE fdNum='fud-0032';
-------------주의하세!!!

	 
SELECT * FROM funding;




INSERT INTO funding VALUES ('fud-'||LPAD(SEQ_fud.nextval, 4, '0'), 'crt-0001', ?, 
?, ?, '../image/clothes2.png', 100, 
to_date('2021-8-17 20:25:00', 'YYYY-MM-DD HH24:MI:SS'),
to_date('2021-12-31 23:59:59', 'YYYY-MM-DD HH24:MI:SS'), '#스트릿패션 #데일리패션', '../image/funding1.png', 
'Rose under the light는 시크하고 차분한 스트릿감성을 추구합니다.<br>스트릿패션은, 시크하지만 우리 일상에 밀접해 있으며 무엇보다 다수의 컬러로 어디에든 잘 어울립니다. 
<br>Rose under the light의 제품들은 오래 입고 오래 사용할 수 있지만 오래된 전통의 느낌이 아닌 
<br> 신선하고 깨끗한 화이트 감성을 담도록 노력하며 그 모습에 잘 어울리는 브랜드를 만들고자 합니다.',
'Rose under the light 는 Slow와 Archive의 조합으로 스트릿패션의 감성을 담는다는 의미로 만들어졌습니다.<br>
창의적으로 생각하고 여유롭게 행동하며 우리 삶에 꼭 필요한 최소한의 제품들로 구성되며 <br>
한 해 입고 버리는 옷이 아닌 5년 이상 사용할 수 있는 품질 좋은 제품을 만듭니다.<br>
이번에 제작된 트리플에이 AFA 스트릿 티셔츠의 모든 패키지는 재활용이 가능한 종이 재질로 제작되었습니다.<br>
 제품의 택, 1차 포장 봉투, 완충재, 2차 택배 봉투 모두 종이 재질로 디자인되었습니다.<br> 
(택배 봉투는 두꺼운 종이에 안쪽 방수 코팅으로 비에 젖지 않으며 제품을 안전하게 보호합니다)', 
'펀딩 결제는 예약 상태로 유지되다가, 펀딩 마감일 다음 영업일 2021.12.31 17시에 모두 함께 진행됩니다. <br>
 결제 정보 변경은 결제가 진행되기 전까지 언제나 가능합니다.<br>
 참여한 펀딩 정보 변경은 펀딩 내역에서 진행해주세요. <br>
마감일 이후에는 펀딩에 대한 리워드 제작 및 배송이 시작되어, 취소와 더불어 배송지 및 리워드 옵션 변경은 해당일 이후로는 불가합니다.', 
'서포터가 수령한 펀딩상품이 하자 기준에 해당할 경우, 배송 완료일로부터 7일 이내에 펀딩금 반환 신청을 할 수 있습니다. <br>
 이때 크리에이터는 하자 판단을 위한 증빙자료, 리워드 반송을 서포터에게 요청할 수 있습니다.',1,7400000); 


INSERT INTO funding (fdNum, creNum, fdThemeNum, FDCATEGORYNUM, STATUSNUM) VALUES ('fud-'||LPAD(SEQ_fud.nextval, 4, '0'), 'crt-0002', 2, 100, 2); 

SELECT * FROM funding;

SELECT CRENM,
		CREPROFILE
FROM CREATOR 
WHERE CRENum = 'crt-0002';


UPDATE CREATOR 
	SET CREPROFILE = '../image/creator_logo.png'
	WHERE CRENUM = 'crt-0001';
	


UPDATE funding
	SET fdProjectNM = 'allname',
		fdTargetPrice = 1000000,
		fdingprice = 200000,
		fdImg = 'png',
		fdCategoryNum = 100,
		fdRegiDT = sysdate,
		fdExpDT = sysdate+1,
		fdTags = '#이야이야 #이야야 #아주좋은옷'
	WHERE FDNUM = (SELECT max(fdnum)
		FROM funding);
		
UPDATE funding
	SET fdStoryImg = ?,
	    fdStorySum = ?,
		fdStory = ?
	WHERE FDNUM = (SELECT max(fdnum)
		FROM funding);

	

	
SELECT fdNum 펀딩번호,
	c.creNum 크리에이터번호,
	c.CRENM 크리에이터명,
	f2.FDTHEMENM 펀딩테마번호,
	fdProjectNM 펀딩명,
	trunc((fdingprice/fdTargetPrice)*100) 펀딩율,
	TO_CHAR(fdingprice, '9,999,999')펀딩된금액,
	fdImg 펀딩대표이미지,
	f3.FDCATEGORYNM 카테고리명,
	ABS(TRUNC(sysdate-fdExpDT)) 펀딩마감일
	FROM CREATOR c , FUNDING f,
	FDTHEME f2, FDCATEGORY f3 
WHERE c.CRENUM = f.CRENUM
AND f.FDTHEMENUM = f2.FDTHEMENUM 
AND f.FDCATEGORYNUM = f3.FDCATEGORYNUM
AND c.CRENUM = 'crt-0001';
	

SELECT count(*)
FROM FUNDING f 
WHERE CRENUM = 'crt-0001';

UPDATE 
	
	