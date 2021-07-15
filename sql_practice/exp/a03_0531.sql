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
	name varchar2(20),
	point NUMBER,
	joindate DATE
);

--ex3
-- char 고정형은 문자열데이터 길이를 변경할 수 없으므로 문자열 길이가 변하지 않는 값을 담을 때 사용
-- varchar2 가변형은 문자열 데이터를 담을 최대 사이즈를 지정함

--ex4
CREATE TABLE student(
	studentno char(20),
	name varchar2(20),
	kor number,
	eng number,
	math number
);
INSERT INTO student values('1416163', '가나다', 90, 80, 70);

--ex5
CREATE TABLE player(
	agency varchar2(50),
	name varchar2(20),
	genre varchar(20),
	playerrecord number
);
INSERT INTO player values('소속사1', '가나다', '수영', 1);
INSERT INTO player values('소속사3', '김수영', '멀리뛰기', 3);
SELECT * FROM player;
DROP TABLE player;

--ex6
--  select는 출력할 컬럼 전체 대상
--  where의 컬럼은 비교 연산을 수행할 대상 컬럼

--ex7
--  관계대수(=, >=, <=, >, <), and, or, null확인, 
--  between, in, like, ....등등 subquery

--ex8
--  in: or 조건을 편하게 표현함
SELECT ename, deptno
FROM emp
WHERE deptno IN (10, 20); --10이거나 20인 값
--  between: and 조건과 같이 범위 표현
SELECT * FROM emp
WHERE sal BETWEEN 1000 AND 2000; --1000이상 2000이하 값

--ex9
SELECT ename, deptno 
FROM emp
WHERE deptno IN (10, 20)
ORDER BY ename ASC;

--ex10
SELECT ename, deptno, HIREDATE 
FROM emp
WHERE HIREDATE LIKE '82%' ;

--ex11
SELECT ename, sal, comm, (nvl(comm,0)/sal) "percent"
FROM emp
WHERE deptno = 30 AND (nvl(comm,0)/sal) >0.2;

--ex12
--  %: 앞, 뒤의 자리에 어떤 값이 와도 상관 없다는 뜻
--  _: 자릿수를 세는 용도로 사용 됨
SELECT * 
FROM emp
WHERE ename LIKE '%E%' AND sal LIKE '1%';

--ex13
SELECT ename, hiredate
FROM emp
WHERE HIREDATE IN (SELECT max(HIREDATE) FROM EMP e )

