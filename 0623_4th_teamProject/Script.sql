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
INSERT INTO memberProfile values('M0002154', '상점이름1', 'c:\\\\profile_M0002154.jpg', '상점 소개를 입력하세요.',
								'2021-02-15', 20, 5, 5, 'true');
INSERT INTO memberProfile values('M0002155','상점이름2', 'c:\\\\profile_M0002155.jpg', '상점 소개를 써볼까요',
								'2021-05-29', 15, 0, 0, 'false');
INSERT INTO memberProfile values('M0002156','거래합니다', 'c:\\\\profile_M0002156.jpg', '쿨거 부탁',
								'2020-08-19', 450, 150, 145, 'true');
	
SELECT *
FROM MEMBERPROFILE;
//-----------------------------------------
	
DROP TABLE MEMBERPROFILE;

SELECT shopName, shopImageURL, shopIntro, 
		trunc(sysdate)-trunc(OPENDATE) "countOfOpenDate",
		countVisit, countSell, countShipping, isCertified
FROM memberProfile
WHERE memberNum = 'M0002154';

