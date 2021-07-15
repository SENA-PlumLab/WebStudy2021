--ex1
-- 	null값과의 연산 결과는 null로 표기된다. 
--  nvl으로 null을 0으로 치환하여 연산하여야 정상적인 연산결과를 볼 수 있다.
SELECT sal+comm "sal+com",
		sal + nvl(comm,0) "sal+comm(nvl)"
FROM emp;

--ex2
--  char(size) 고정길이 문자, varchar2(size) 가변 길이 문자
--  number 숫자 데이터
--  date 날짜 시간
--  nvarchar2(size) 국가별 문자 집합에 따른 문자 데이터 타입
--  rowid 행의 고유주소 64진수
--  blob clob bfile 대용량 데이터 저장
--  timestamp(n)
CREATE TABLE personal(
	civilnum char(20),
	name varvhar2(20),
	point NUMBER,
	joindate DATE
);


