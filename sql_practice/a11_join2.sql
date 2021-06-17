/*

# non equi join
1. 조인하는 두개의 테이블 값이 동일하지 않고, 범위로서 join하는 경우를 말함.

 */

SELECT ename, sal
FROM emp;
SELECT *
FROM SALGRADE s ;

SELECT ename, sal, grade
FROM EMP e , SALGRADE s 
WHERE sal BETWEEN losal AND hisal;

--ex1) 4등급 사원의 정보
SELECT e.*, s.GRADE 
FROM EMP e , SALGRADE s 
WHERE sal BETWEEN losal AND hisal
AND grade=4;
--ex2) SMITH의 급여와 등급
SELECT e.ename, e.sal, s.GRADE 
FROM EMP e , SALGRADE s 
WHERE sal BETWEEN losal AND hisal
AND ename='SMITH';
--es3) job이 SALESMAN인 사람의 급여와 등급
SELECT e.ename, e.JOB, e.sal, s.GRADE 
FROM EMP e , SALGRADE s 
WHERE sal BETWEEN losal AND hisal
AND job='SALESMAN';

--ex) 부서별 최고급여와 그 등급
SELECT deptno, msal, grade
FROM (SELECT deptno, max(sal) "MSAL"
		FROM EMP e 
		GROUP BY deptno), salgrade s
WHERE msal BETWEEN losal AND hisal;

select deptno, max(sal) Msal
FROM EMP e 
GROUP BY deptno;



/*
# outer join
1. EQUI JOIN의 조인 조건에서 양측 컬럼 값 중 어느 하나다로 NULL이면 '=' 비교 결과가 거짓이 되어
	NULL값을 가진 행은 조인 결과로 출력할 수 없다.
	NULL에 대해서 어떤 연산을 적용하더라도 연산 결과는 NULL이다...
	ex) 일반적인 EQUI JOIN의 예: 학생 테이블의 학과번호 컬럼과 부서 테이블의 부서번호 컬럼에 대해 EQUI JOIN
							(student.deptno = department.deptno)를 한 경우, 학생 테이블의 deptno컬럼이 NULL이면 결과 출력 없음.
2. EQUI JOIN에서 양측 컬럼 값 중의 하나가 NULL이지만 JOIN 결과로 출력할 필요가 있는 경우에는
	OUTER JOIN을 사용한다.
	ex) OUTER JOIN의 예: 학생테이블과 교수 테이블을 EQUI JOIN하여 학생의 지도교수 이름을 출력할 때, 지도학생을 한명도 배정받지 않는 교수 이름도 반드시 함께 출력
3. (+) 기호를 사용한 OUTER JOIN
	WHERE 절의 조인 조건에서 OUTER JOIN 연산자인 '(+)' 기호 사용.
	조인 조건문에서 NULL이 출력되는 테이블의 갈럼에 (+) 기호 추가
4. 기본 구문
SELECT table1.COLUMN, table2.COLUMN
FROM table1, table2
WHERE table1.column(+) = table2.COLUMN;
	혹은 table1.COLUMN = talbe2.column(+);
*/

SELECT DISTINCT deptno --10, 20, 30
FROM emp;

SELECT *	--deptno 10, 20, 30, 40
FROM dept;

SELECT e.ename, e.deptno, d.deptno, dname
FROM emp e, dept D 
WHERE e.deptno=d.deptno; -->d.deptno 40은 매핑된 emp정보가 없음

SELECT e.ename, e.deptno, d.deptno, dname
FROM emp e, dept D 
WHERE e.deptno(+)=d.deptno; 
--> 이와 같이 dept에는 있으나 emp에 할당되지 않은 데이터도 join현황에서 확인하고자 할 때,
--> outer join을 활용한다.


--ex1) 사원테이블 부서테이블 아웃조인. 사원명, 부서명 출력 (사원이 없는 경우는 '할당된 사원 없음')
SELECT nvl(ename, '할당된 사원 없음') "사원명", dname "부서명"
FROM emp e, dept d
WHERE e.deptno(+)=d.deptno;
--ex2) 부서별 인원수, 할당인원 없으면 0
SELECT dname "부서명", count(e.DEPTNO) "사원 수" --nvl 안써도 0으로 출력 가능
FROM emp e, dept d
WHERE e.deptno(+)=d.deptno
GROUP BY dname;
--> count(e.deptno): e.deptno가 해당 컬럼에 null을 제외한 데이터를 count한다. 
--> 				그러므로 outer join에 의해 할당되지 않는 데이터는 0으로 처리된다.