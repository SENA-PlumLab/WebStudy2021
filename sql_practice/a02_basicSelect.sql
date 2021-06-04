/*
# BETWEEN 구문
1. 컬럼명 BETWEEN A AND B
	동일한 결과 내용으로 컬럼명 >= A AND 컬럼명 <= B
*/

-- sal 1000~2000 사이 데이터 출력
SELECT * FROM emp
WHERE sal BETWEEN 1000 AND 2000;
-- ex) empno가 7600~7900 사이의 데이터 출력
SELECT * FROM emp
WHERE empno BETWEEN 7600 AND 7900;

/*
# NULL 데이터 처리
1. 데이터가 할당되지 않는 경우를 의미한다. '' 공백 데이터, 0 숫자 데이터와 null은 다르다.
2. 처리내용
	1) 조건문 처리
		컬럼명 is null : 해당 컬럼에 데이터가 할당되지 않은 경우
		컬럼명 is not null : 데이터 할당 되어있는 경우
	2) 함수 처리 nv1 
		nvl(컬럼명, null일때 나올 데이터)
		숫자형 nvl (comm, 0)
		문자형 nvl (ename, '')
		*/
SELECT sal, comm, sal+comm "합산1",
		sal + nvl(comm,0) "합산2"
FROM emp;
-- 프로그램으로 처리하여 나타날 0과 null을 동일시 하여 처리 조건에도 사용할 수 있다.
SELECT sal, comm
FROM EMP e
WHERE nvl(comm,0) != 0;
-- ex1) 사원명과 관리자번호(mgr) - null인 경우 0으로 출력하세요.
-- ex2) 중복되지 않는 관리자번호를 출력하세요. null이 아닌 경우만. (nvl 함수 이용)
SELECT ename "사원명", nvl(mgr, 0) "관리자번호"
FROM emp;

SELECT DISTINCT mgr "관리자번호"
FROM emp
WHERE nvl(mgr,0) != 0;


/*
# IN 구문
1. 하나의 컬럼을 기준으로 많은 OR 조건을 처리할 때, 효과적이고 간편하게 처리하기 위하여 IN 구문 제송
*/
SELECT ename, deptno
FROM emp
WHERE deptno IN (10, 20);

SELECT empno, ename, deptno
FROM emp
WHERE empno IN (7369, 7521, 7654);
--ex) job이 SALESMAN이거나 MANAGER인 경우를 in 구문으로 출력
SELECT * 
FROM emp
WHERE job IN ('SALESMAN', 'MANAGER');
-- subquery: 수행된 결과값ㅂ을 기준으로 다시 조회 조건을 처리하는 구문
-- 연봉이 최고인 사람의 정보 출력
SELECT max(sal)
FROM emp;

SELECT *
FROM EMP e 
WHERE sal in(SELECT max(sal) FROM emp);

/*
LIKE 키워드 검색

위치 상관없이 검색: 컬럼명 like '%A%'
A로 시작하면 검색: 컬럼명 like 'A%'
N으로 끝나는 검색: 컬럼명 like '%N'
자릿수 위치에 맞는 데이터 검색-세번째 자리에 A: 컬럼명 like '__A%'
*/
SELECT empno, ename FROM emp WHERE ename LIKE '%N';

--ex1
SELECT * FROM emp WHERE job LIKE '%MAN%';
--ex2
SELECT * FROM emp WHERE ename LIKE 'A%' ;
SELECT * FROM emp WHERE ename LIKE '%A%' ;
--ex3
SELECT * FROM emp 
WHERE job LIKE '%E__'
	OR job LIKE '%E_';
	
/*
# 정렬 처리

1. SQL 명령문에서 검색된 결과는 테이블에 데이터가 입력된 순서대로 출력
2. 데이터의 출력 순서를 특정 컬럼을 기준으로 오름차순/내림차순으로 정렬하는 경우가 발생한다.
3. 여러개의 컬럼에 대해 정렬 순서를 지정해서 처리해야 할 경우가 발생한다.
	- 입사일은 오름차순, 금여 기준으로 내림차순..
4. 기본적인 정렬 방법
	- 문자 값을 알파벳순으로 출력, 한글은 가나다라 순으로 출력
	- 숫자 값은 가장 작은 값 먼저 출력
	- 날짜는 과거날짜 순으로 출력
5. 기본 형식
	select *
	from 테이블
	where ...
	order by 컬럼명 [ASC/DESC]
	asc: default 오름차순 정렬
	desc: 역순 정렬
*/
-- 사원번호 역순으로 사원번호와 이름 조회
SELECT empno, ename
FROM emp 
ORDER BY empno DESC;
--ex1
SELECT * FROM emp ORDER BY HIREDATE DESC;
--ex2
SELECT * FROM emp ORDER BY sal ASC;
--ex3
SELECT deptno "부서번호", sal "급여", a.* 
FROM emp a ORDER BY deptno ASC, sal desc;
