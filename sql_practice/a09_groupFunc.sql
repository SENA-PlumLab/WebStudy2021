-- # 그룹함수

SELECT deptno, count(*), max(sal), min(sal), avg(sal)
FROM emp
GROUP BY DEPTNO
ORDER BY deptno;

SELECT deptno, sal
FROM EMP e
ORDER BY deptno, sal;

/*
# 그룹함수
1. 테이블의 전체 행을 하나 이상의 컬럼을 기준으로 그룹화하여 그룹별로 결과를 출력하는 함수
2. 그룹함수는 통계적인 결과를 출력하는데 자주 사용된다.
3. 기본형식
	SELECT 컬럼명, 그룹함수1, 그룹함수2...
	FROM 테이블명
	WHERE 조건
	group by 그룹할 컬럼
	HAVING 그룹함수의 조건;
4. 그룹함수의 종류
	count(): 행의 갯수
	max(): null을 제외한 모든 행의 최대값
	min(): null을 제외한 모든 행의 최소값
	sum(): null을 제외한 모든 행의 합
	avg(): null을 제외한 모든 행의 평균값
	stddev(): null을 제외한 모든 행의 표준편차
	variance(): null을 제외한 모든 행의 분산
5. count 함수
	1) 테이블에서 조건을 만족하는 행의 갯수를 반환하는 함수
	2) 기본형식
		count(*|disrinct|all, expr)
		-*: null을 포함한 모든 행의 갯수
		-distinct: 중복되는 값을 제외한 행의 갯수
		-all: 중복된 값을 포함한 행의 갯수, default
		-expr인수에서 사용 가능한 데이터 타입은 char, varchar2, number, date
*/

--부서번호 10인 comm의 데이터 건수 출력
SELECT count(comm)
FROM EMP e 
WHERE deptno=30;

SELECT *
FROM EMP e ;

--ex: 전체 관리자 갯수 
SELECT count(mgr) -- NULL 제외한 내용 출력
FROM EMP e;
SELECT count(DISTINCT mgr) -- 중복된 내용까지 제외 
FROM emp;

--ex: 2사분기 입사한 사람의 job 갯수
SELECT count(DISTINCT job)
FROM EMP e 
WHERE to_char(hiredate, 'Q') = '2';


/*
합산, 평균, 최소, 최대
*/
SELECT sum(sal), avg(sal), min(sal), max(sal)
FROM EMP e 
WHERE deptno=10;

--ex:연봉 2000~5000 사이의 연봉 합산, 최대, 평균값
SELECT sum(sal), max(sal), avg(sal)
FROM EMP e 
--WHERE sal>=2000 and sal<=5000;
WHERE sal BETWEEN 2000 AND 5000;

--ex2: 2사분기 입사한 사람의 연봉 합산, 최대, 최소, 평균값
SELECT sum(sal), max(sal), min(sal), trunc(avg(sal))
FROM EMP e 
WHERE to_char(hiredate, 'Q') ='2';

/*
# GROUP BY 절
1. 특정 컬럼 값을 기준으로 테이블의 전체 행을 그룹별로 나누기 위한 절
2. 예: 교수 테이블에서 소속 학과별, 직급별로 평균 급여를 구하는 경우
3. GROUP BY 절에 명시되지 않은 컬럼은 그룹 함수와 함께 사용할 수 없음.

# GROUP BY 절 규칙
0. 그룹핑 전에 WHERE 절을 사용하여 그룹 대상 집합을 먼저 선택
1. GROUP BY 절에는 반드시 컬럼 이름을 포함해야하고 컬럼 별명은 사용할 수 없음.
2. 그룹별 출력 순서는 오름차순으로 정렬
3. SELECT 절에서 나열된 컬럼 이름이나 표현식은 GROUP BY 절에서 반드시 명시
4. GROUP BY 절에서 명시한 컬럼 이름은 selevt 절에서 명시하지 않아도 됨.
*/

-- 부서별 평균급여
SELECT deptno, avg(sal)
FROM EMP e 
GROUP BY deptno;

--ex1: 직책(job)별 평균급여와 최대급여
SELECT job, trunc(avg(sal)), max(sal)
FROM EMP e 
GROUP BY job;

--ex2: 분기별 최대급여 최저급여
SELECT to_char(hiredate, 'Q'), max(sal), min(sal)
FROM EMP e
GROUP BY to_char(hiredate, 'Q')
ORDER BY to_char(hiredate, 'Q');

/*
group 함수의 조건을 처리할 때는 having을 활용해서
HAVING 그룹함수의 조건으로 처리한다.
*/
SELECT to_char(hiredate, 'Q'), max(sal), min(sal)
FROM EMP e
GROUP BY to_char(hiredate, 'Q')
HAVING max(sal)>=2000;
--ex1:입사월별 최고 연봉자. 1000이상인 경우만 출력
SELECT to_char(hiredate, 'MM'), max(sal)
FROM EMP e 
GROUP BY TO_char(hiredate, 'MM')
HAVING max(sal)>=1000
ORDER BY TO_char(hiredate, 'MM');
--ex2:직책별 인원 3명이상인 직책과 인원
SELECT job, count(job)
FROM EMP e 
GROUP BY JOB 
HAVING count(job)>=3;