/*
# 테이블 구조의 변경
1. 개요
	테이블 구조 변경
	1)유형: 컬럼 추가, 컬럼 삭제, 컬럼 속성 변경, 제약조건 변경 등
2. 컬럼 추가
	ALTER TABLE 테이블명
	ADD 컬럼명 데이터유형 [default 디폴트데이터, 제약조건]
3. 컬럼 삭제
	alter table 테이블명
	drop column 컬럼명;
*/

CREATE TABLE emp14
AS SELECT empno, ename, job, sal FROM emp;
SELECT * FROM emp14;

ALTER TABLE emp14 
ADD address varchar2(20) DEFAULT '주소입력없음';

CREATE TABLE emp15
AS (SELECT d.dname, e.ename, e.job, e.sal FROM emp e, dept d WHERE e.deptno=d.deptno);
ALTER TABLE emp15
ADD bonus NUMBER DEFAULT 0;

SELECT * FROM emp15;


--삭제
 SELECT e.deptno, d.dname, e.sal, e2.ename
 	FROM (SELECT max(sal) sal, deptno FROM EMP e GROUP BY deptno) e
 		INNER JOIN emp e2 ON e.sal=e2.sal
 		INNER JOIN DEPT d ON e.deptno=d.deptno;
 
create TABLE emp16
AS SELECT e.deptno, d.dname, e.sal, e2.ename
 			FROM (SELECT max(sal) sal, deptno FROM EMP e GROUP BY deptno) e
 			INNER JOIN emp e2 ON e.sal=e2.sal
 			INNER JOIN DEPT d ON e.deptno=d.deptno;
ALTER TABLE emp16
DROP COLUMN deptno;
SELECT * FROM emp16;

DROP TABLE emp16;