/*
1) 그룹함수의 기본 형식
	SELECT 컬럼명1, 그룹함수1, 그룹함수2...
	FROM 테이블명1
	WHERE 조건...
	group by 컬럼명1
	HAVING 그룹함수의 조건;
2) 그룹함수의 종류와 내용 예제
	max, min: 최댓값, 최소값
	sum, abg: 합계와 평균
	stddev, variance: 표준편차, 분산
*/
SELECT d.dname, e.deptno, count(empno), max(sal), min(sal), sum(Sal), 
		avg(sal), STDDEV(sal), VARIANCE(sal) 
FROM emp e, dept d 
WHERE e.DEPTNO = d.deptno
GROUP BY d.dname, e.DEPTNO;

SELECT count(empno), max(sal), min(sal), sum(Sal), 
		avg(sal), STDDEV(sal), VARIANCE(sal) 
FROM emp e, dept d 
WHERE e.DEPTNO = d.deptno;
/*
3) 전체에 대한 그룹함수와 특정 컬럼 기준의 그룹함수
- 전체에 대한 그룹함수는 조건없이 해당 컬럼의 모든 값에 대한 연산을 하기 때문에 결과값도 1개만 나옴.
- 특정 컬럼을 그룹으로 묶으면 해당 컬럼 값이 같은 데이터만 따로 모아 연산하기 때문에 결과값이 여러개 나올 수 있다.

4)입사월별 인원수 출력 
*/
SELECT count(empno)||'명' "인원수", to_char(hiredate, 'MM')||'월 입사' "입사월"
FROM EMP e 
GROUP BY TO_CHAR(hiredate, 'MM')
ORDER BY TO_CHAR(hiredate, 'MM');
--ex1) 사원번호별 짝수 홀수
SELECT CASE WHEN mod(empno, 2)=0 THEN '짝수' else '홀수' END  "홀짝", count(empno)
FROM emp
GROUP BY (CASE WHEN mod(empno, 2)=0 THEN '짝수' else '홀수' END);
--> 간단하니까 decode 쓸 수 있음. 
--> group by 에서는 mod만 사용해도 가능.
SELECT decode(mod(empno, 2), 0, '짝수', '홀수') "홀짝", count(empno)
FROM emp
GROUP BY mod(empno, 2);
--ex2) 입사분기별 건수
SELECT to_char(hiredate, 'Q') "분기", count(empno)
FROM EMP e 
GROUP BY to_char(hiredate, 'Q')
ORDER BY 분기;



--5) 직책(job)별 최고 급여자가 2000이상인 경우
SELECT job, max(sal)
FROM EMP e 
GROUP BY JOB 
having max(sal)>=2000;
/*
--6) 조인테이블의 연결이 없는 카티시안 조인과 equi join의 차이점
	카티시안: 조인 조건이 적절하지 않거나 없어서 해당 테이블에 대한 모든 데이터를 전부 가져옴.
	equi: 서로 다른 테이블에서 특정 컬럼이 같다고 선언하며 join하는 것
--> 카티시안 조인: 테이블간의 공통 컬럼 연결 없이 조회
				데이터 건수가 테이블건수x테이블건수로 나타남.
	equi 조인: 테이블간의 공통 컬럼을 연결하여 조회
				데이터 건수는 두 테이블간의 연결된 데이터를 기준으로 나타남.
*/	

--7) 급여 2000~4000 사이의 사원번호, 이름, 부서명
SELECT e.empno, e.ename, d.dname
FROM EMP e , DEPT d 
WHERE e.sal BETWEEN 2000 AND 4000;

/*
--8) non equi란
		어떤 범위에 대해 등급을 지정하고, 해당 범위 내 값일 경우 등급으로 데이터를 표현하는 것.
--> 두개 테이블의 데이터를 비교하여 = (비교연산자)가 아닌 범위 혹은 다른 형태로 데이터를 비교하여 join하는 것.
--> ex) 급여 등급 테이블과 사원 테이블의 급여를 between으로 비교
*/

--9) salgrade의 1, 2등급에 해당하는 사원 정보
SELECT s.grade, e.*
FROM SALGRADE s , EMP e 
WHERE e.sal BETWEEN s.losal AND s.hisal
AND grade IN (1,2);