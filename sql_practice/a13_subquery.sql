/*
# subquery
1. 개요
	하나의 SQL 명령문의 결과를 다른 SQL 명령문에 전달하기 위해 두 개 이상의 SQL 명령문을 하나의 SQL명령문으로 연결하여 처리하는 방법.
	필요성 예시: 교수테이블에서 '김박사' 교수와 직급이 동일한 모든 교수의 이름 검색
2. 처리방식
	1) 교수 테이블에서 '김박사' 교수의 직급 검색
	2) 교수 테이블 직급 컬럼에서 1의 결과와 동일한 값의 교수 검색
	3) 1과 2를 통합하여 하나의 SQL 명령문으로 처리

*/

SELECT *
FROM emp
WHERE deptno = (SELECT deptno
				FROM emp
				WHERE ename = 'SMITH');
--ex1) WARD와 같은 직책의 사원정보
SELECT *
FROM EMP e 
WHERE job = (SELECT job FROM emp WHERE ename='WARD');
--ex2) king을 관리자로 둔 사원정보
SELECT *
FROM EMP e 
WHERE mgr = (SELECT empno FROM emp WHERE ename = 'KING');
--ex3) JAMES와 같은 입사월의 사원정보
SELECT *
FROM EMP e2 
WHERE to_char(hiredate, 'MM') = (SELECT to_char(hiredate, 'MM') FROM emp WHERE ename='JAMES');
/*

#서브쿼리 종류
1. 단일행 서브 쿼리
	- 서브쿼리 결과값이 단일 데이터로 조건에서 사용할 때 활용 됨
	- 비교연산자(= > < >= <= !=)등 활용
2. 다중행 서브 쿼리
	- 서브쿼리 결과값이 다중으로 조건에서 사용할 때 활용 됨
	- 다중행 비교연산자: IN, ANY, SOME, ALL EXISTS 등
*/

-- 단일행 ex) 부서 10에서 가장 높은 급여
SELECT *
FROM EMP e 
WHERE sal = (SELECT max(Sal)
			FROM EMP e 
			WHERE deptno=10);
-- ex1) 부서 20에서 가장 적은 연봉보다 같거나 적은 사원들
SELECT *
FROM EMP e 
WHERE sal <= (SELECT min(SAL)
			FROM EMP e2 
			WHERE DEPTNO=20);
--ex2) 2사분기 입사한 사원의 평균급여보다 많은 사원
SELECT *
FROM EMP e 
WHERE sal >= (SELECT avg(sal)
			FROM EMP e2 
			WHERE TO_NUMBER(to_char(hiredate, 'Q')) = 2);
--ex3) comm이 가장 많은 사원 정보
SELECT *
FROM EMP e 
WHERE comm = (SELECT max(COMM)
			FROM EMP e2 );
			
-- 다중행 ex) 연봉 1000~2000 사이 직책에 해당하는 사원 출력
SELECT *
FROM EMP e2 
WHERE job IN (SELECT DISTINCT job
				FROM EMP e 
				WHERE sal BETWEEN 1000 AND 2000);
--ex) 부서별 연봉이 가장 높은 사원의 사원정보				
SELECT *
FROM emp
WHERE (deptno, sal) IN (SELECT deptno, max(sal) FROM emp GROUP BY deptno);


/*
SELECT *
FROM emp
WHERE (sal, deptno) IN (subquery);
두개의 column이 다 해당할 때 처리해주는 내용을 볼 수 있다.
*/
-- ex1) 4~6월 입사한 직원과 같은 직책의 사원 정보
SELECT *
FROM EMP e 
WHERE job IN (SELECT DISTINCT JOB FROM emp WHERE TO_NUMBER(to_char(hiredate, 'MM')) BETWEEN 4 AND 6);
-- ex2) 연봉 2000~3000 사이의 사원들과 같은 부서 사람들
SELECT e.*, d.DNAME
FROM emp E, DEPT d 
WHERE e.deptno = d.DEPTNO 
	AND e.deptno IN (SELECT DISTINCT deptno FROM emp WHERE sal BETWEEN 2000 AND 3000);

-- 부서별로 연봉이 가장 높은 사원 정보
SELECT *
FROM EMP e 
WHERE (deptno, sal) IN (SELECT deptno, max(sal) FROM emp GROUP BY deptno);


--ex1) 부서별 최근 입사자의 정보를 부서번호로 정렬하려 출력
SELECT *
FROM EMP e 
WHERE (hiredate, deptno) IN (SELECT min(hiredate), DEPTNO FROM EMP e2 GROUP BY deptno)
ORDER BY deptno;
--ex2) 직책별 최저 연봉자의 정보를 연봉으로 정렬
SELECT *
FROM EMP e 
WHERE (job, sal) IN (SELECT job, min(sal) FROM EMP e2 GROUP BY job)
ORDER BY sal;
--ex3) 분기별 최고 연봉자의 정보를 분기로 정렬
SELECT e.*, to_char(hiredate, 'Q') "분기"
FROM EMP e 
WHERE (sal, to_char(hiredate, 'Q')) IN (SELECT max(sal), to_char(hiredate, 'Q') "분기" FROM EMP e2 GROUP BY to_char(hiredate, 'Q'))
ORDER BY 분기;


/*
# exists, not exists
1. 서브쿼리에서 검색된 결과가 하나라도 존재하거나 존재하지 않을 때,
	메인쿼리의 조건을 참/거짓으로 처리 함
2. 서브쿼리의 데이터 조최 결과가 있기만 하면 아무런 연관관계 없이 메인쿼리를 수행 함.

 */
SELECT *
FROM EMP e 
WHERE EXISTS (SELECT * FROM emp WHERE comm=500);

SELECT *
FROM EMP e 
WHERE NOT EXISTS (SELECT * FROM emp WHERE comm=2422);