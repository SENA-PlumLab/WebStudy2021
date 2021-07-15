/*

5. 날짜형 함수 중에, 월단위로 추가하거나 두 날짜 사이의 개월수을 확인하는 함수를 기본예제와 함께 기술하세요.
6. 날짜/숫자를 처리시, 절삭/반올림/올림 처리하는 경우를 기술하세요.
7. 3/4 분기에 입사한 사원의 이름과 입사년월일 분기를 출력
8. nvl, nvl2, nullif 함수의 차이점을 기술하세요.
9. decode와 case 함수의 기본형식을 기술하세요.
10. 그룹함수를 이용하여 job의 갯수를 중복을 제외하고 출력할려는 sql을 작성하세요.
11. 부서별 최고 연봉자가 3000이상인 부서를 출력하세요.
12. 급여가 2000~3000사이의 부서명, 사원명, 급여를 출력하세요.
13. subquery 종류를 기봉 예제를 통해서 기술하세요.
14. 2등급에 해당하는 사원들의 정보를 출력하세요.

*/

--5
SELECT ADD_MONTHS(sysdate, 3) "3개월 후", trunc(MONTHS_BETWEEN(sysdate, '2000-02-24')) "개월수 차이"
FROM dual;

--6
SELECT sysdate, trunc(sysdate+4), trim(SYSDATE+4), ROUND(SYSDATE+4)
FROM dual;

--7
SELECT to_char(HIREDATE, 'Q') 분기, ename, 
		TO_CHAR(hiredate, 'YYYY')||'년 '||TO_CHAR(HIREDATE, 'MM')||'월 '||TO_CHAR(HIREDATE, 'DD')||'일' 입사일 
FROM EMP e
WHERE TO_NUMBER(to_char(HIREDATE, 'Q')) BETWEEN 3 AND 4
ORDER BY 분기;

--8
/*
nvl(비교대상 데이터, 데이터) 
nvl2(비교할 데이터, null이 아닐때, null일때)
nullif(데이터1, 데이터2)
*/

--9
/*
decode(데이터, case1, case1일때처리할데이터,
				 case2, case2일때처리할데이터,
				 case3, case3일때처리할데이터,
			위 내용에 해당하지 않을 때 데이터)
CASE 컬럼명
		WHEN 데이터1 THEN 처리데이터
		WHEN 데이터2 THEN 처리데이터
		ELSE 그외 데이터
	END
*/

--10
SELECT count(DISTINCT job)
FROM EMP;

--11
SELECT a.deptno, b.dname, a.maxsal
FROM (SELECT deptno, max(sal) maxsal FROM emp GROUP BY deptno) a, dept B
WHERE a.deptno = b.deptno AND maxsal >= 3000;

--12
SELECT b.dname, a.ename, a.sal
FROM (SELECT DEPTNO, ename, sal FROM emp WHERE sal BETWEEN 2000 AND 3000) a, dept b
WHERE a.deptno = b.deptno;

--13
/*
단일행 서브 쿼리: 서브쿼리 결과값이 단일 데이터(1건)로 조건에서 사용할 때 활용 됨
다중행 서브 쿼리: 서브쿼리 결과값이 다중(2건 이상)으로 조건에서 사용할 때 활용 됨
*/
--단일행 서브쿼리
SELECT dname
FROM DEPT d 
WHERE deptno=(SELECT deptno FROM emp WHERE ename='FORD');
--다중행 서브쿼리
SELECT dname
FROM dept
WHERE deptno in (SELECT DISTINCT deptno FROM emp WHERE sal BETWEEN 1000 AND 2000);

--14
SELECT b.grade, a.*
FROM emp a, SALGRADE b 
WHERE a.sal BETWEEN b.losal AND b.hisal
 AND b.grade = 2;
 

--ex1) 분기별 최고 급여자(단, 2000이상)가 소속된 부서정보 출력
SELECT to_char(a.hiredate, 'Q') quarter, b.dname, a.ename, a.sal
FROM emp a, dept b, (SELECT to_char(hiredate, 'Q') quarter, max(sal) sal 
						FROM emp 
						GROUP BY to_char(hiredate, 'Q')) c
WHERE a.sal = c.sal AND a.deptno = b.deptno
	AND c.sal>=2000
ORDER BY quarter;



=



