/*

1. 기본
	sql1
	집합관련 키워드
	sql2
	** 두 sql 결과의 type, 갯수, 컬럼명이 동일하여야 함
2. 종류
	1) union: 합집합. 두 sql 결과 공통 데이터는 하나만 나옴
	2) union all: 합집합잊만 중볻괸 데이터를 처리결과로 확인할 수 있음
	3) intersect: 교집합.
	4) minus: 먼저 위치한 select 문을 기준으로 다른 select문과 공통된 데이터를 제외한 항목만 추출
	

*/

SELECT '홍길동' name, 75 kor FROM dual;
--intersect 교집합
--연봉 1000~3000, 2000~5000의 교집합
SELECT ename, job, deptno, sal
FROM EMP e WHERE sal BETWEEN 1000 AND 3000
intersect
SELECT ename, job, deptno, SAL 
FROM EMP e2 
WHERE sal BETWEEN 2000 AND 5000;

--ex1) 부서번호 10, 20의 합집합
SELECT * FROM emp WHERE deptno=10
UNION 
SELECT * FROM emp WHERE deptno=20;
--ex2) 연봉 0~3000, 2000~5000인 사람의 중복 상관없는 합집합
SELECT * FROM emp WHERE sal BETWEEN 0 AND 3000
UNION ALL 
SELECT * FROM emp WHERE sal BETWEEN 2000 AND 5000;
--ex3) 상반기 입사, 2/4분기 입사 차집합
SELECT to_char(hiredate, 'Q') quater, e.*
FROM EMP e 
WHERE to_char(hiredate, 'Q') BETWEEN 1 AND 2
MINUS 
SELECT to_char(hiredate, 'Q') quater, e.*
FROM EMP e 
WHERE MOD(to_char(hiredate, 'Q'), 2)=0;
--ex4) 1980년도 입사, 1981 입사. 같은 월인 사람의 교집합
SELECT to_char(hiredate,'MM') mm
FROM EMP e 
WHERE to_char(hiredate,'YYYY') = 1980
INTERSECT 
SELECT to_char(hiredate,'MM') mm
FROM EMP e 
WHERE to_char(hiredate,'YYYY') = 1981
ORDER BY mm;