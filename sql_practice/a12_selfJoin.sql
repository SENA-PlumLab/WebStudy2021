/*
# SELF JOIN
1. 개요
	하나의 테이블 내에 있는 컬럼끼리 연결하는 조인
	조인 대상 테이블이 자신 하나라는 것 외에는 EQUI JOIN과 동일하다.
2. WHERE절을 사용한 SELF JOIN
	하나의 테이블에서 두 개의 컬럼을 연결하여 EQUI JOIN
	FROM절에서 하나의 테이블에 별명 지정
	ex) 부서테이블에서 where 절을 사용하여 self join
3. 형식
	select a.*, b.*
	from 테이블1 a, 테이블1 b
	where a.컬럼1 = b.컬럼2;
*/

--사원정보, 사원의 관리자 정보.
SELECT e.empno "사번", e.ename "사원 이름" , e.mgr "관리자 사번", m.empno "관리자 사번", m.ename "관리자 이름"
FROM emp e, emp M 
WHERE e.mgr = m.empno;

--ex) 연봉 **인 사원 **의 관리자**의 연봉은 **입니다. (self 조인)
SELECT '연봉 '||e.sal||'원 사원 '||e.ename||'의 관리자 '||m.ename||'는 연봉이 '||m.sal||'원 입니다.' "msg"
FROM emp e, emp m
WHERE e.mgr = m.empno;

--ex) 테이블 만들고 출력
DROP TABLE family;
CREATE TABLE family(
	NO NUMBER,
	pos varchar2(20),
	name varchar2(20),
	parno number
);
INSERT INTO family values(1, '할아버지', '홍말순', 0);
INSERT INTO family values(2, '아버지', '홍판서', 1);
INSERT INTO family values(3, '아들1', '홍진희', 2);
INSERT INTO family values(4, '아들2', '홍길동', 2);
SELECT f.name||'의 부모는 '||a.name||'입니다' "msg"
FROM family f, family a
WHERE f.parno = a.NO;

