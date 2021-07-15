/*
# 테이블 추가
1. ALTER TABLE로 컬럼 추가/삭제, 타입이나 길이 재정의
2. 컬럼 추가
	- ALTER TABLE ... ADD 명령문 사용
	- 테이블 마지막 부분에 생성, 위치 지정 불가능..
		(꼭 필요하다면 심시 테이블 변경..)
# 테이블 구조 변경
1. 테이블 컬럼의 타입, 크기, 기본값 변경 가능
2. ALTER TABLE 테이블명 MODIFY 컬럼명 ...
3. 기존 데이터가 없는 경우에는 타입/크기 변경이 자유롭다.
4. 기존 데이터가 있는 경우
	1) 타입 변경은 char와 varchar2만 허용 됨
	2) 변경한 컬럼의 크기가 저장된 데이터의 크기보다 같거나 큰 경우만 가능
	3) 숫자 타입에는 정밀도 증가 가능
5. 기본 값의 변경은 변경 후에 입력되는 데이터부터 적용 됨.
*/

CREATE TABLE emp09
AS SELECT * FROM emp WHERE 1=0;

SELECT * FROM emp09;

-- 기존 데이터가 없으면 데이터 유형 변경이 자유롭다.
--1. 크기 변경
ALTER TABLE EMP09 MODIFY ename varchar2(100);
--2. 타입 변경
ALTER TABLE emp09 MODIFY mgr varchar2(30);
--3. 같은 유형의 데이터 변경
--	1) 작은 데이터유형->큰 데이터 유형 가능
CREATE TABLE emp10 AS SELECT * FROM emp;
ALTER TABLE emp10
MODIFY ename varchar2(50);
--	2) 큰 데이터유형 -> 작은 데이터 유형은 저장된 데이터크기의 범위 안에서만 가능
SELECT max(length(ename)) FROM emp10; --결과:6
ALTER TABLE emp10 
MODIFY ename varchar(10); 
ALTER TABLE EMP10 
MODIFY ename varchar(5); --cannot decrease column length because some value is too big
-- 4. 데이터가 있을 때 다른 유형의 데이터 type 변경 불가
ALTER TABLE EMP10 
MODIFY empno varchar2(10); --column to be modified must be empty to change datatype
ALTER TABLE EMP10 
MODIFY hiredate varchar2(30);
-- 5. 기존 데이터가 있을 때 데이터유형 변경하기
-- 		1) 기존 데이터 변경한채로 복사
--		2) 기존 테이블 비우고 데이터유형 변경
--		3) 복사테이블의 데이터를 다시 기존 테이블에 입력
CREATE TABLE hiredate_cpy
AS SELECT empno, to_char(hiredate, 'YYYY/MM/DD') hiredate
FROM emp10;
UPDATE EMP10
	SET hiredate = NULL;
ALTER able emp10
MODIFY hiredate varchar2(10);
UPDATE EMP10 a
	SET hiredate = (SELECT b.hiredate FROM hiredate_cpy b WHERE a.empno = b.empno);



DROP TABLE emp10;
--ex. emp10 문자->숫자, 숫자->문자, 날짜->문자
CREATE TABLE emp10 AS SELECT * FROM emp WHERE 1=0;
ALTER TABLE emp10 MODIFY ename NUMBER;
ALTER TABLE emp10 MODIFY job NUMBER;
ALTER TABLE emp10 MODIFY deptno varchar2(30);
ALTER TABLE emp10 MODIFY empno varchar2(30);
ALTER TABLE emp10 MODIFY sal varchar2(30);
ALTER TABLE emp10 MODIFY comm varchar2(30);
ALTER TABLE emp10 MODIFY mgr varchar2(30);
ALTER TABLE emp10 MODIFY hiredate varchar2(30);
--ex. emp10 문자열형 데이터 50, 최대크기 확인 후 변경
select max(LENGTH(job)) FROM emp10;
ALTER TABLE EMP10 
MODIFY job varchar(50);
--ex. emp10 기준, mgr을 문자형으로 변경, 복사테이블 만들고 mgr null 까지.
DROP TABLE emp10;
DROP TABLE emp10_cpy;

create TABLE emp10
AS SELECT * FROM emp;
CREATE TABLE emp10_cpy
AS SELECT empno, to_char(mgr) mgr FROM emp10;

SELECT * FROM emp10;
SELECT * FROM emp10_cpy;
SELECT max(LENGTH(mgr)) FROM emp10_cpy;

UPDATE emp10
	SET mgr = NULL;
ALTER TABLE EMP10 
MODIFY mgr varchar(40);

UPDATE emp10 a 
	SET a.mgr = (SELECT b.mgr FROM emp10_cpy b WHERE a.empno = b.empno);

SELECT b.mgr FROM emp10 a, emp10_cpy b WHERE a.empno = b.empno;
