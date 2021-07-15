/*
# 인덱스


4. 결합 인덱스: 두개 이상의 컬럼을 결합하여 생성하는 인덱스

*/

CREATE TABLE emp35
AS SELECT ename, job, deptno, sal, hiredate FROM emp;

CREATE INDEX idx_emp35_ename_deptno
ON emp35(ename, deptno);

select *
FROM SYS.USER_IND_COLUMNS
WHERE table_name = 'EMP35'; --대문자로 EMP

--ex. 사원정보, 부서정보 조인 테이블에서 empno deptno 제외한 복사테이블 emp36을 만들고
--		ename, dname이 결합된 결합 인덱스를 생성하고 확인
CREATE TABLE emp36
AS select ename, job, mgr, hiredate, sal, comm, dname, loc
FROM emp e, dept D 
WHERE e.deptno=d.deptno;

SELECT * FROM emp36;

CREATE INDEX idx_emp36_ename_dname
ON emp36(ename, dname);

SELECT *
FROM SYS.USER_IND_COLUMNS
WHERE TABLE_NAME ='EMP36';



/*
# descending INDEX
1. 컬럼별로 정렬 순서를 별도로 지정하여 결합 인덱스를 새엇ㅇ하기 위한 방법을 말한다.
2. 형식
	CREATE INDEX 인덱스명 ON 테이블명(컬럼명1 desc, 컬럼2 asc);
*/

CREATE TABLE emp37
as SELECT * FROM emp;
CREATE INDEX idx_emp37_deptno_ename
ON emp37(deptno DESC, ename asc);
SELECT *
FROM user_ind_columns		-- 데이터 딕셔너리에서 확인
WHERE TABLE_NAME ='EMP37';

SELECT * FROM emp;
--ex. emp38을 deptno와 empno를 없애고 만들되 ename 역순 job 역순으로 인덱스 생성
CREATE TABLE emp38
AS SELECT ename, job, mgr, hiredate, sal, comm FROM emp;
CREATE INDEX idx_emp38_ename_job
ON emp38(ename DESC, job desc);
SELECT *
FROM SYS.USER_IND_COLUMNS
WHERE TABLE_NAME ='EMP38';

/*
# 함수 기반 인덱스
1. 컬럼에 대한 연산이나 함수의 계싼 결과를 인덱스로 생성하는 것을 말한다.
2. 함수 기반 인덱스는 insert, update시에 새로운 값을 인덱스에 추가한다.
3. 기본 형식
	create index 인덱스명 on 테이블(함수(컬럼));
*/
CREATE TABLE emp39
AS SELECT * FROM emp;
CREATE INDEX uppcase_idx ON emp39(lower(ename));
SELECT *
FROM SYS.USER_IND_COLUMNS
WHERE TABLE_NAME='EMP39';
SELECT *
FROM emp39
WHERE lower(ename)='king';
--ex. emp40 테이블, 문자열로 검색되는 모든 컬럼을 upper 함수가 적용된 함수기반 index로 만들기
CREATE TABLE emp40
AS SELECT * FROM emp;
CREATE INDEX uppcase_idx ON emp40(upper(ename), upper(job));
SELECT *
FROM SYS.USER_IND_COLUMNS
WHERE TABLE_NAME='EMP40';
SELECT *
FROM emp40
WHERE upper(job)='CLERK';



