/*
# CHECK
1. 특정한 데이터를 조건이나 범위를 지정해서 해당 범위의 데이터만 입력되도록 처리함
2. 형식
	컬럼명 데이터유형 CONSTRAINT 제약명 chek (조건문-where 하위의 sql문장과 같음)
*/
CREATE TABLE student05(
	gender varchar2(1) check( gender IN ('F', 'M'))
);
INSERT INTO STUDENT05 VALUES ('F');
INSERT INTO STUDENT05 VALUES ('M');
INSERT INTO STUDENT05 VALUES ('K'); --에러
--check constraint (SCOTT.SYS_C007088) violated
DROP TABLE student05;
--ex. student07 테이블, 이름, 학년(1~4), 국어(1~100)
CREATE table student07(
	name varchar2(30),
	grade number(1) CONSTRAINT student07_grade_ck check( grade BETWEEN 1 AND 4),
	kor NUMBER CHECK (kor BETWEEN 1 AND 100)
);
INSERT INTO student07 values('김이박', 1, 50);
INSERT INTO student07 values('김이박', null, 50); --에러X
INSERT INTO student07 values('김이박', 1, null); --에러X
INSERT INTO student07 values('김이박', 8, 50); --에러O
--check constraint (SCOTT.STUDENT07_GRADE_CK) violated
INSERT INTO student07 values('김이박', 1, 150); --에러O
--check constraint (SCOTT.SYS_C007090) violated


/*
# 외래 키 설정 관계 (foreign key)
1. 연관관계에 있는 두 테이블에 대해, 한쪽 테이블에 있는 데이터 기준으로 다른쪽 테이블의 데이터를 입력할 수 있게 하는 것
2. 기본 형식
	컬럼명, 데이터유형 CONSTRAINT 테이블명_컬럼명_kf REFERENCES 테이블명(컬럼명)
*/
CREATE table teacher01(
	tno NUMBER PRIMARY key
);
INSERT INTO teacher01 values(10);
INSERT INTO teacher01 values(11);
INSERT INTO teacher01 values(12);
CREATE TABLE student08(
	name varchar2(50),
	tno NUMBER CONSTRAINT student08_tno_fk REFERENCES teacher01(tno)
);
INSERT INTO student08 VALUES ('김김김', 10);
INSERT INTO student08 VALUES ('이이이', 11);
INSERT INTO student08 VALUES ('박박박', 13); -- 에러
--  integrity constraint (SCOTT.STUDENT08_TNO_FK) violated - parent key not found
--ex. 물건테이블(불건번호, 물건명, 가격, 재고량)
--		구매테이블(구매번호, 구매수량, 물건번호외래키)
CREATE TABLE product01(
	pdNum number(4) PRIMARY KEY,
	name varchar2(30),
	price NUMBER,
	stock number
);
CREATE TABLE purchase(
	pcNum number(4) PRIMARY KEY,
	cnt NUMBER,
	pdNum number(4) CONSTRAINT purchase_pcNum_fk REFERENCES product01(pdNum)
);

INSERT INTO product01 VALUES (1111, '마라탕', 15000, 200);
INSERT INTO product01 VALUES (2222, '텀블러', 8000, 100);
INSERT INTO purchase values(0111, 1, 1111);
INSERT INTO purchase values(0112, 5, 2222);
INSERT INTO purchase values(0113, 2, 3333);--에러
--integrity constraint (SCOTT.PURCHASE_PCNUM_FK) violated - parent key not found

SELECT a.pcNum||'이 '||b.name||'을 '||b.price||'원에 '||a.cnt||'개  구매했습니다.' msg
FROM purchase a, product01 B 
WHERE a.pdNum = b.pdNum;

DROP TABLE product01;
DROP TABLE purchase;