/*

# view란?

1. 하나 이상의 기본 테이블이나 다른 뷰를 이용하여 생성되는 가상 테이블을 말한다.
2. 장점
	1) 데이터를 보호하기 위해 활용 됨(보안적 필요성)
		- 지정된 권한이 있는 사람만이 전테 체이블의 컬럼을 확인/활용할 수 있음. 그 외 사람은 뷰를 통해 허용된 컬럼만 조회 가능.
	2) 사용자 편의성 지원
		- query의 결과를 뷰로 만들었기 때문에 다른 테이블과 조인하거나 GROUP 함수를 통해 출력한 query를 view라는 가상 테이블로 간단하게 SQL 조회할 수 있음.
		- 복잡한 sql을 하나의 가상 테이블로 간단하게 만들어 사용 가능하다.
3. 뷰의 종류
	1) 단순 뷰: 하나의 기본 테이블에 의해 정의 된 뷰
		그룹 함수 사용 불가 (실제 테이블의 데이터가 아니므로)
		distinct 사용일 때 불가능
		dml(insert update delete) 사용가능
	2) 복합 뷰: 두개 이상의 기본 테이블로 구성한 뷰
			여러 테이블의 조인관계를 통한 결과를 처리한 뷰
			여러개의 테이블로 생성, 그룹함수 가능, distinct 가능, dml 불가능
4. 뷰의 한계
	1) 제한적 사용: 부결성 제약조건, 표현식, GROUP BY 유무에 따라 DML명령문은 제한적으로 사용 됨.
	2) 수행 불가능: DISTINCT, 그룹함수, GROUP BY, START WITH, connect BY, rownum은 포함할 수 없다.
5. 뷰 생성 기본
	1) CREATE[or REPLACE] VIEW 뷰이름
		AS (subquery - select * from ***)
	2) 옵션
		OR replace: 뷰 생성할 때, 이미 생성된 뷰가 있으면 동일한 이름 뷰 재생성
		force: 기본 테이블 존재 여부에 상관 없이 뷰 생성
		noforce: 기본 테이블이 존재 할 경우에만 뷰 생성 [기본값]



*/

CREATE VIEW v_emp
AS SELECT deptno, empno, ename, sal
FROM emp
WHERE to_char(hiredate, 'YYYY')='1981';

SELECT * FROM v_emp;

-- 복합 뷰 연습. 
-- ex. 사원정보+급여등급+부서정보 복합뷰
CREATE VIEW v_emp2
AS SELECT a.*, b.grade, c.dname
FROM emp a, salgrade b, dept C 
WHERE a.sal BETWEEN b.LOSAL AND b.HISAL
AND a.deptno=c.deptno;
SELECT * FROM v_emp2;