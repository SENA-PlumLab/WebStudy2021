CREATE TABLE memberProfile(
	memberNum char(8),
	shopName varchar2(20),
	shopImageURL varchar2(100),
	shopIntro varchar2(300),
	OpenDate Date,
	countVisit number,
	countSell number,
	countShipping number,
	isCertified varchar2(20)
);
INSERT INTO memberProfile values('M0002154', '상점이름1', 'images/profile_M0002154.jpg', '상점 소개를 입력하세요.',
								'2021-02-15', 20, 5, 5, 'true');
INSERT INTO memberProfile values('M0002155','상점이름2', 'images/profile_M0002155.jpg', '상점 소개를 써볼까요',
								'2021-05-29', 15, 0, 0, 'false');
INSERT INTO memberProfile values('M0002156','거래합니다', 'images/profile_M0002156.jpg', '쿨거 부탁',
								'2020-08-19', 450, 150, 145, 'true');
INSERT INTO memberProfile values('M0001212', '왕바보', 'images/profile_M0001212.jpg', '농담곰이 좋아요', '2019-11-22', 20, 8, 8, 'true');
INSERT INTO memberProfile values('M0000606', '동그리동동', 'images/profile_M0000606.jpg', '동그라미가..좋다!', '2018-06-06', 825, 450, 402, 'true');
INSERT INTO memberProfile values('M0001122', '별과음악', 'images/profile_M0001122.jpg', '눈동자에 Cheers...★', '2019-03-23', 600, 212, 150, 'true');
INSERT INTO memberProfile values('M0000323', '막걸리에파전', 'images/profile_M0000323.jpg', '파전 바삭바삭', '2017-04-23', 126, 30, 30, 'true');
INSERT INTO memberProfile values('M0001589', '왕싸게팔음', 'images/profile_M0001589.jpg', '마참내! 드디어! 왕 싸다!', '2020-11-22', 230, 82, 78, 'true');
INSERT INTO memberProfile values('M0001522', '훠궈먹자', 'images/profile_M0001522.jpg', '일주일에 4번 훠궈 먹는 사람', '2021-04-23', 522, 128, 115, 'true');
	
SELECT *
FROM MEMBERPROFILE
ORDER BY MEMBERNUM;

SELECT shopName, shopImageURL, shopIntro, 
		trunc(sysdate)-trunc(OPENDATE) "countOfOpenDate",
		countVisit, countSell, countShipping, isCertified
FROM memberProfile
WHERE memberNum = 'M0002154';
-----------------------------------------------

CREATE TABLE productList(
	memberNum char(8),
	productNum char(8),
	imageURL varchar2(100),
	productName varchar2(100),
	price NUMBER,
	uploadDate DATE,
	region varchar2(100),
	isSoldOut varchar2(20)
);

INSERT INTO productList values('M0002154', 'P0101524', 'images/product_1524.jpg', '커피머신', 50000, '2021-04-01', '서울시 양천구', 'true');
INSERT INTO productList values('M0002154', 'P0101851', 'images/product_1851.jpg', '모니터', 80000, '2021-04-19', '서울시 양천구', 'true');
INSERT INTO productList values('M0002154', 'P0102345', 'images/product_2345.jpg', '인형4개', 8000, '2021-06-05', '서울시 양천구', 'true');
INSERT INTO productList values('M0002154', 'P0103720', 'images/product_3720.jpg', '텀블러', 12000, '2021-06-10', '서울시 양천구', 'false');
INSERT INTO productList values('M0002154', 'P0104520', 'images/product_4520.jpg', '젤네일 스티커', 3000, '2021-06-15', '서울시 양천구', 'false');
INSERT INTO productList values('M0001484', 'P0103756', 'images/product_3756.jpg', '2G 휴대폰', 50000, '2021-06-10', '서울시 송파구', 'false');
INSERT INTO productList values('M0002388', 'P0104888', 'images/product_4888.jpg', '2DS 본체+놀동숲', 60000, '2021-06-17', '경기 부천시', 'false');
INSERT INTO productList values('M0002751', 'P0104554', 'images/product_4554.jpg', '어쿠스틱 기타', 40000, '2021-06-15', '서울 강남구', 'false');



SELECT *
FROM PRODUCTLIST
ORDER BY PRODUCTNUM ;

SELECT imageURL, productName, price,
		trunc(sysdate)-trunc(uploadDate) "countOfUploadedDay",
		region, isSoldout
FROM PRODUCTLIST 
WHERE memberNum = 'M0002154'
ORDER BY UPLOADDATE DESC , ISSOLDOUT ;
-----------------------------------------------

CREATE TABLE inboundList(
	toMemberNum char(8),
	fromMemberNum char(8),
	comm varchar(300),
	uploadDate DATE,
	priority number
);

INSERT INTO inboundList values('M0002154', 'M0001212', '님 농담곰 인형은 없나요', '2021-06-12', 0);
INSERT INTO inboundList values('M0001212', 'M0002154', '있어요', '2021-06-20', 1);
INSERT INTO inboundList values('M0002154', 'M0002154', '다시 보니까 없는 듯...ㅋㅋ', '2021-06-20', 2);
INSERT INTO inboundList values('M0002154', 'M0001212', '님님 잠만보 인형은 있어요???', '2021-06-17', 0);
INSERT INTO inboundList values('M0001212', 'M0002154', '있음요', '2021-06-20', 1);

SELECT b.SHOPNAME, b.SHOPIMAGEURL, a.comm, 
		trunc(sysdate)-trunc(a.UPLOADDATE) "countOfUploadedDay",
		a.PRIORITY 
FROM inboundList a, MEMBERPROFILE b
WHERE b.MEMBERNUM = a.FROMMEMBERNUM ;
-----------------------------------------------

CREATE TABLE bookmarkList(
	byMemberNum char(8),
	productNum char(8),
	addedDate DATE
);
INSERT INTO bookmarkList values('M0002154', 'P0103756', '2021-05-01');
INSERT INTO bookmarkList values('M0002154', 'P0104888', '2021-06-03');
INSERT INTO bookmarkList values('M0002154', 'P0104554', '2021-06-21');
		
SELECT *
FROM bookmarkList;

SELECT b.imageURL, b.productName, b.price,
		trunc(sysdate)-trunc(b.uploadDate) "countOfUploadedDay",
		b.region, b.isSoldout
FROM PRODUCTLIST b, BOOKMARKLIST c
WHERE c.PRODUCTNUM = b.PRODUCTNUM AND c.byMemberNum = 'M0002154'
ORDER BY addedDate DESC, b.ISSOLDOUT;
----------------------------------------------
CREATE TABLE shopReview(
	ToMemberNum char(8),
	fromMemberNum char(8),
	productNum char(8),
	comm varchar(300),
	uploadDate DATE,
	starRate number
);
INSERT INTO shopReview values('M0002154', 'M0000606', 'P0101524', '잘 받았어요^^', '2021-03-28', 3);
INSERT INTO shopReview values('M0002154', 'M0001122', 'P0101851', '잘쓰겠읍니다.. 건강하세요,,~! ', '2021-04-15', 4);
INSERT INTO shopReview values('M0002154', 'M0000323', 'P0102345', '귀 엽 다 . . . !', '2021-06-07', 5);
		
SELECT *
FROM SHOPREVIEW;

SELECT a.SHOPIMAGEURL, a.SHOPNAME, b.IMAGEURL, b.PRODUCTNAME, c.comm,
			trunc(sysdate)-trunc(c.UPLOADDATE) "countOfUploadedDay",
			c.starRate
FROM MEMBERPROFILE a, PRODUCTLIST b, shopReview c
WHERE a.MEMBERNUM = c.fromMemberNum AND b.PRODUCTNUM = c.productNum
ORDER BY c.uploadDate desc;

------------------------------------------------
CREATE TABLE followList(
	toMemberNum char(8),
	fromMemberNum char(8)
);
--팔로잉 (내가 팔로우 함)
INSERT INTO followList values('M0001589', 'M0002154');
INSERT INTO followList values('M0001522', 'M0002154');
--팔로워 (나를 팔로우 함)
INSERT INTO followList values('M0002154', 'M0000606');
INSERT INTO followList values('M0002154', 'M0001122');
INSERT INTO followList values('M0002154', 'M0000323');

SELECT *
FROM followList;


getCountSell()); //임의의 값
			System.out.println("팔로워: "+p.getCountVisit()%10); //임의의 값
			
--팔로잉 (내가 팔로우 함)
SELECT a.SHOPNAME, a.SHOPIMAGEURL, a.COUNTSELL , mod(a.COUNTVISIT,10) "FOLLOWER" --임의의값
FROM MEMBERPROFILE a, followList b
WHERE b.toMembernum = a.MEMBERNUM
	AND b.frommembernum = 'M0002154';
--팔로워 (나를 팔로우 함)
SELECT a.SHOPNAME, a.SHOPIMAGEURL, a.COUNTSELL , mod(a.COUNTVISIT,10) "FOLLOWER" --임의의값
FROM MEMBERPROFILE a, followList b
WHERE b.fromMembernum = a.MEMBERNUM
	AND b.tomembernum = 'M0002154';
//-----------------------------------------
	
DROP TABLE MEMBERPROFILE;
DROP TABLE INBOUNDLIST;
DROP TABLE PRODUCTLIST;
DROP TABLE BOOKMARKPDLIST;
DROP TABLE SHOPREVIEW;
DROP TABLE FOLLOWLIST;



