/*
# 테이블 이름 변경
	RENAME 테이블명 TO 변경할 테이블명;
# 컬럼명 변경
	ALTER TABLE 테이블명
	RENAME COLUMN 컬럼명 TO 변경할컬럼명;
*/
SELECT * FROM emp10;
SELECT * FROM emp10y;
RENAME emp10 TO emp10_new;
ALTER TABLE EMP10_NEW 
RENAME COLUMN empno TO NO;

--ex. 분기별 최고 연봉자 테이믈 emp11, job 데이터유형 최대크기 확인하며 해당 크기 유형으로 변경.
--		EMPNO는 CHAR(4)로, 테이블명은 EMP_UPT, SAL은 salary로 변경
DROP TABLE emp11;
CREATE TABLE emp11
AS SELECT a.*, TO_NUMBER(to_char(a.hiredate, 'Q')) quater
FROM emp a, (SELECT max(sal) sal, TO_NUMBER(to_char(hiredate, 'Q')) quater 
				FROM emp 
				GROUP BY TO_NUMBER(TO_CHAR(hiredate, 'Q'))) b
WHERE a.sal = b.sal
ORDER BY quater;

SELECT * FROM emp11;
SELECT max(LENGTH(job)) FROM emp11;
......

--풀이
DROP TABLE emp11;
DROP TABLE emp11_cpy;
CREATE TABLE emp11
AS SELECT a.*, TO_NUMBER(to_char(a.hiredate, 'Q')) quater
FROM emp a
WHERE (to_char(hiredate, 'Q'), sal) IN (
	SELECT to_char(hiredate, 'Q') quater, max(SAL)
	FROM EMP
	GROUP BY to_char(hiredate, 'Q')
);
SELECT * FROM emp11;

ALTER TABLE EMP11 
ADD empnos char(4);

CREATE TABLE EMP11_CPY 
AS SELECT empno, to_char(empno) empnos
FROM emp;

UPDATE emp11 a 
	SET empnos = (SELECT empnos 
				FROM EMP11_CPY B
				WHERE a.empno = b.empno);
SELECT * FROM emp11;

RENAME emp11 TO emp_upt;
ALTER TABLE EMP_UPT 
RENAME COLUMN sal TO salary;

SELECT * FROM emp_upt;
	