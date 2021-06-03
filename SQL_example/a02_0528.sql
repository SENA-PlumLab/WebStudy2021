
-- 1. 
SELECT ename, job, sal
FROM emp
WHERE job = 'SALESMAN';
-- 2.
SELECT *
FROM emp
WHERE deptno=20 AND sal <= 4000;

-- 3.
SELECT empno "사원번호(empno)", ename "사원명(ename)",job "직책(job)",sal "연봉(sal)"
FROM emp
WHERE (sal>=2000 AND sal<=3000) OR job = 'SALESMAN';

--4
SELECT *
FROM emp
WHERE deptno != 10;
--5
SELECT *
FROM emp
WHERE job != 'CLERK';
--6
SELECT ename, sal, comm, sal+comm "합산 급여"
FROM emp;