/*
# 그 외 subquery
1. TABLE 자체에 대한 subquery
2. SELECT 선택열에서 subquery
*/
SELECT *
FROM (SELECT deptno, max(hiredate) hiredate FROM emp GROUP BY deptno) a, emp b
WHERE a.hiredate = b.hiredate
	AND a.deptno = b.deptno
ORDER BY a.deptno;

--ex1) 연봉 2000~4000인 사원의 부서번호, 사원명, 사원번호, 이름의 subquery 테이블과 부서테이블 join
SELECT e.deptno, d.dname, e.empno, e.ename, e.sal
FROM (SELECT * FROM emp WHERE sal BETWEEN 2000 AND 4000) e, dept D
WHERE e.deptno = d.deptno;
--ex2) 부서별 최저연봉의 정보와 부서정보 join활용
SELECT *
FROM (SELECT deptno, min(sal) FROM emp GROUP BY deptno) e, dept D
WHERE e.deptno = d.deptno;

--ex1) 중복되지 않는 관리자 번호 리스트 테이블과 사원테이블을 mgr, empno로 조인하여 관리자번호, 관리자명, 직책 출력
SELECT a.mgr, b.ename, b.job
FROM (SELECT DISTINCT mgr FROM emp )a, emp B 
WHERE a.mgr = b.empno;
--ex2) 부서별 최근 입사자 테이블과 사원 ㅔㅌ이블을 부서번호로 조인하여 출력
SELECT *
FROM (SELECT deptno, max(hiredate) FROM emp GROUP BY deptno) a, dept d
WHERE a.deptno = d.deptno
ORDER BY a.deptno;
--ex3) 연봉 3000~4000에 해당하는 사원 테이블과 부서정보 테이블을 조인하여 출력
SELECT *
FROM (SELECT * FROM emp WHERE sal BETWEEN 3000 AND 4000) e, dept d 
WHERE e.deptno = d.DEPTNO  ;
