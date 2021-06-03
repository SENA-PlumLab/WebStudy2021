
-- 1. select문 기본형식
	-- SELECT 컬럼명(혹은*) FROM 테이블명 
-- 2.
SELECT deptno, empno, ename, sal FROM emp;
-- 3.
SELECT empno AS "번호",
		ename AS "이 름",
		sal AS "연 봉"
FROM emp;
--4
SELECT '부서는 '||DEPTNO||'이고, 사원번호는 '||empno||', 급여는 '||sal||', 보너스는 '||deptno*1.5||'입니다.' AS msg FROM emp;
--5
	-- jdbc는 프로그램에 필요한 것들을 자바 class로 만들어 압축한 것.. 라이브러리 같은 역할을 한다.
--6
	-- username, password, port number, driver 설정 등이 필요하다.