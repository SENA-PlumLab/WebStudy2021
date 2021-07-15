/*
# 데이터 무결성 제약조건의 개념
1. ㅔㄷ이터의 정확성과 일관성을 보장
2. 데이터의 정확성을 유지하여 다양한 종류의 업무규칙을 고려함
	1) student 테이블에서 학년 데이터는 1, 2, 3, 4 중 하나만 입력
	2) 모든 학번은 유일하게 처리
	3) srudent 테이블의 지도교수 법ㄴ호는 ㅔrofessor 테이블의 교수번호 중 하나와 반드시 일치
3. 데이터 부결성 제약조선의 장점
	1) 테이블 생성시 부결성 제약조건 정의 가능
		- 생성 후 제약조선 설정도 가능
	2) 테이블에 대해 정의, 데이터 딕셔너리에 저장되므로 응용 프로그램에서 입력된 모든 데이터에 대해 동일하게 적용
	3) 제약조건을 활성화, 비활성화 할 수 있는 융통성이 있다.
4. 무결성 제약조건의 종류
	1) NOT NULL: 열이 NULL을 포함할 수 없음
	2) UNIQUE KEY: 테이블의 모든 행에서 고유한 값을 갖는 열 또는 열 조합을 지정해야 함 (ex. 학번, 주민번호, 사원번호 중복 X)
	3) PRIMARY KEY: 해당 컬럼 값은 반드시 존재해야하며 유일해야한다. NOT NULL이면서 unique가 결합된 형태
	4) FOREIGN KEY: 한 열과 참조된 테이블의 열 간에 외래 키 관계를 설정하고 시행 (ex. 사원 테이블의 부서번호는 반드시 부서테이블에 있는 부서번호여야 함)
	5) CHECK: 해당 컬럼에 저장 가능한 데이터 값의 범위나 조건을 지정처리. (ex. student 테이블의 학년을 1, 2, 3, 4만 데이터로 넣을 수 있다.)
5. 설정 형식
	1) 컬럼명 데이터타입 CONSTRAINT 제약조건명 제약조건
	2) PRIMARY KEY 지정.
		ex. CREATE TABLE dtudent ( 
							stuno number constraint student_stuno_pk primary key );
		제약조건 이름: 테이블명_컬럼명_제약조건종류(pk, uq, nn, fk)
*/


--not null
CREATE TABLE student01(
	name varchar2(30) CONSTRAINT student01_name_nn NOT null
);
INSERT INTO student01 VALUES ('홍길동');
INSERT INTO student01 VALUES (null); -- 에러발생

--ex.
CREATE TABLE student02(
	stuno number(8) CONSTRAINT student02_stuno_nn NOT NULL,
	name varchar2(30),
	kor NUMBER
);
INSERT INTO student02 values(12345678,'김이박', null);
INSERT INTO student02 values(12345678, null, null);
INSERT INTO student02 values(null, '김이박', null); --cannot insert NULL into ("SCOTT"."STUDENT02"."STUNO")
DROP TABLE student02;


--unique: 다른 데이터와 식별되게 입력, 동일한 데이터 입력시 에러 발생
CREATE TABLE student03(
	sno number(5) CONSTRAINT student03_sno_uq unique
);
INSERT INTO student03 VALUES (12345);
INSERT INTO student03 VALUES (null);
INSERT INTO student03 VALUES (12345); --에러O
INSERT INTO student03 VALUES (null); --에러XX
--ex
CREATE TABLE employee04(
	empno number(8) CONSTRAINT employee04_empno_uq UNIQUE,
	name varchar2(30) CONSTRAINT employee04_name_nn NOT NULL,
	sal number
);
INSERT INTO employee04 values(12345678, '홍길동이', null);
INSERT INTO employee04 values(12345678, '홍길동이다', null);--에러
--unique constraint (SCOTT.EMPLOYEE04_EMPNO_UQ) violated
INSERT INTO employee04 values(12345611, null, null);--에러
-- cannot insert NULL into ("SCOTT"."EMPLOYEE04"."NAME")


--primary key
CREATE TABLE employee06(
	empno NUMBER CONSTRAINT employee06_empno_pl PRIMARY key
);
INSERT INTO employee06 VALUES (1001);
INSERT INTO employee06 VALUES (null); --에러
INSERT INTO employee06 VALUES (1001); --에러
--ex
CREATE TABLE student04(
	sno number(8) CONSTRAINT student04_sno_pk PRIMARY KEY,
	name varchar2(30) CONSTRAINT student04_name_nn NOT NULL,
	kor NUMBER,
	eng NUMBER,
	math number
);
INSERT INTO student04 values(12345678, '김이박', 80, 60, null);
INSERT INTO student04 values(11211111,  null, 5, 64, 22);
--cannot insert NULL into ("SCOTT"."STUDENT04"."NAME")
INSERT INTO student04 values(12345678, '최승현', 80, 60, null);
--unique constraint (SCOTT.STUDENT04_SNO_PK) violated
INSERT INTO student04 values(null, '최승현', 80, 60, null);
--cannot insert NULL into ("SCOTT"."STUDENT04"."SNO")
DROP TABLE STUDENT04 ;