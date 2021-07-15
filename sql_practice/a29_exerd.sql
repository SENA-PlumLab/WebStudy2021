CREATE TABLE entityexp01(
	classroom varchar2(50)
);
INSERT INTO entityexp01 values('101호');

CREATE TABLE lecture(
	classroom varchar2(50),
	subject varchar2(50),
	instructor varchar2(50)
);
INSERT INTO lecture values('101호', '데이터베이스', '김라이언');



-------- a02_identifier.exerd -----
CREATE TABLE visit(
	vDate DATE,
	vPlaceNum number(10),
	vPersonalNum number(13),
	CONSTRAINTS visit_com_pk PRIMARY KEY (vdate, vPlaceNum, vPersonalNum)
); -- 세개의 컬럼 혼합한 PRIMARY KEY 지정

CREATE TABLE visit(
	visitNum number(10) CONSTRAINTS visit_visitNum_pk PRIMARY KEY,
	vDate DATE,
	vPlaceNum number(10),
	vPersonalNum number(13)
);