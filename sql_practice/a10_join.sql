/*
# JOIN
1. 하나의 SQL명령문에 의해 여러 테이블에 저장된 데이터를 한번에 조회할 수 있는 기능
2. 관계형 데이터베이스 분야의 표준으로 자리잡고잇다.
3. 두 개 이상의 테이블을 결합한다는 의미
*/

--ex) 조인이 필요하지 않는 경우
--	사원정보 테이블에서 연봉 3000이상인 사원의 부서번호를 통해 부서정보를 출력할 때
	select deptno
	from emp
	where sal>=3000; --> 조회하면 deptno 10, 30만 출력 됨
	SELECT *
	FROM dept
	WHERE deptno IN (10, 30); --> deptno 10, 30의 정보 출력
	
--ex) 조인이 필요한 경우
--	연봉 3000이상인 사원의 정보와, 부서정보를 한번에 확인할 때.
	SELECT e.*, d.*
	FROM emp e, dept d
	WHERE e.deptno = d.deptno --> 두개 테이블의 연관관계 표현
	AND sal>=3000;
	
-- select 에서 중복된 컬럼만 alias이름을 지정해도 된다.
	SELECT empno, ename, job, sal, e.deptno, dname, loc 
	FROM emp e, dept D 
	WHERE e.deptno = d.deptno 
	AND sal>=3000;
-- from 테이블명 별칭, 테이블명 별칭: 조인할 테이블을 별칭과 함께 나열함
-- where 별칭.컬럼명 = 별칭.컬럼명: 두개 테이블에서 공통으로 연결한 컬럼명을 별칭과 함께 join 해준다.
--							==> inner join 이라고 한다.
--							* 반드시 소속된 테이블을 지정해야 함. 
-- and 기타조건: 그 외 조인한 내용의 데이터를 기준으로 조회 조건 설정.

--ex) 부서명, 사원명 조인
	SELECT d.dname, e.ename
	FROM emp e, dept d 
	WHERE e.DEPTNO = d.deptno;
--ex2) 1/4분기에 입사한 사원의 부서명, 부서위치, 사원명, 분기
	SELECT d.dname, d.loc, e.ename, to_char(e.hiredate, 'Q') "분기"
	FROM emp e, dept d 
	WHERE e.DEPTNO = d.deptno
	ORDER BY d.dname, to_char(e.hiredate, 'Q');
--ex3) 부서명이 'SALES'인 사원의 사원명, 부서명
	SELECT d.dname, e.ename
	FROM emp e, dept d 
	WHERE e.DEPTNO = d.deptno
	AND d.dname = 'SALES';

--ex1) 급여 1000~3000 부서명, 사원명, 급여
	SELECT d.dname, e.ename, e.sal
	FROM emp e, dept d 
	WHERE e.DEPTNO = d.deptno
	AND sal BETWEEN 1000 AND 3000;
--ex2) 부서위치별 평균급여
	SELECT d.loc, trunc(avg(e.sal))
	FROM emp e, dept d 
	WHERE e.DEPTNO = d.deptno
	GROUP BY d.loc;
--ex3) 하반기 입사한 사람의 이름과 상/하반기 구분, 부서명, 부서위치
--(CASE WHEN integer_val = 10 THEN 100 ELSE 0 END)
	SELECT e.ename, (CASE WHEN to_number(to_char(hiredate, 'Q'))<=2 THEN '상반기' ELSE '하반기' END) "상/하반기", d.dname, d.loc
	FROM emp e, dept d 
	WHERE e.DEPTNO = d.deptno
	AND to_char(hiredate, 'Q')>=3;

-- ex1) 부서 이름별 최근 입사한 사람의 입사일, 부서이름..
	SELECT d.dname, max(e.hiredate)
	FROM emp e, dept d 
	WHERE e.DEPTNO = d.deptno
	GROUP BY d.dname;
-- ex2) 전체 평균연봉, 평균연봉이상은 상급, 미만은 하금. 부서명,사원명,연봉,연봉구분을 부서번호 10, 20인 경우로 나누어 ㅊㄹ력
	SELECT d.dname, e.ename, e.sal, (CASE WHEN e.sal>=avg(e.sal) THEN '상급' ELSE '하급' END) "연봉구분"
	FROM emp e, dept d 
	WHERE e.DEPTNO = d.deptno
	AND e.deptno!=30
	GROUP BY d.dname, e.ename, e.sal;
	-- 혹은
	SELECT d.dname, ename, sal,
			CASE WHEN sal>=(SELECT avg(Sal) FROM emp) THEN '상급' ELSE '하급' END "연봉구분"
	FROM emp e, dept d 
	WHERE e.DEPTNO = d.deptno
	AND d.deptno IN (10,20);
	
--ex) 연봉 3000미만인 사람의 부서이름, 팀(청/백), 이름 출력 (팀은 사원번호 홀수일 때 청, 짝수일 때 백)
	SELECT d.dname, e.ename, 
			CASE WHEN mod(e.empno, 2)=0 THEN '백' ELSE '청' END "팀(청/백)"
			--decode(MOD(e.empno, 2), 0, '백', 1, '청') "팀(청/백)"
	FROM emp e, dept d 
	WHERE e.DEPTNO = d.deptno
	ORDER BY d.dname ASC, mod(e.empno, 2) DESC;	
/*
전체가 연결을 만들어 하나의 테이블로 사용할 수 있다.
1. sekect로 선택해서 보여주는 컬럼 출력 가능
2. WHERE 조건을 통해서 조회 조건 만들 수 있따.
3. 여러가지 함수나 GROUP 함수 활용 가능

select *
from emp e, dpt d; 
==> emp row 12개, dept row 4개. 해서 총 48개의 row가 나옴
==> where 조건을 통해 관계를 설정해주거나 natural join해야 함. 

# NATURAL JOIN 
테이블1 natural join 테이블2
테이블1과 테이블2의 공통 컬럼을 자동으로 join시켜서 처리해주는 oracle 지원 코드
SQL은 ANSI방식 sql 표준 + 각 DB서버마다 지원하는 sql
*/
SELECT *
FROM EMP e
NATURAL join dept;