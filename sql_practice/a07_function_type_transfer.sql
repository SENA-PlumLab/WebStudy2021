/*

# 데이터 타입의 변환
  오라클에서 사용하는 데이터 유형은 함수에 의해서 데이터 type을 변경할 수 있따.

# 형변환 유형
  1) 묵시적 데이터 타입 변환
  	 조건문에서 정확하게 해당 type에 맞게 설정하지 않더라도 결과를 검색해주는 경우가 있는데,
  	 이것은 오라클 시스템에서 내부적으로 타입을 변환해주는 것이다.
  	 ex) select * 
  	 	 from emp
  	 	 where sal>='2000';
  	 문제는 시스템에서 index라는 빠르게 검색해주는 내용에 대해서는 묵시적으로 함수가 정용된 형변환을 하기 때문에 효율적으로 처리되지 못한다.
  	 cf) index: DB시스템 내부에 해당 객체를 설정하면 효과적으로 검색을 빠르게 할 수 있다.
  2) 명시적 데이터 타입 변환
  	 일반적으로 데이터베이스는 변환함수를 이용하여 데이터 타입을 변환한다.
  	 1) to_char(문자열로): 숫자/날짜 ==> 문자열
  	 2) to_number(숫자로): 문자열/날짜 ==> 숫자
  	 3) to_date(날짜로): 숫자/문자열 ==> 날짜
 */

SELECT *
FROM emp
WHERE sal>='2000'; --묵시적 형변환
SELECT *
FROM emp
WHERE sal>= to_number('2000'); --명시적 형변환

/*
# to_char
1. 날짜/숫자를 원하는 형식으로 출력할 때 사용됨.
2. 기본 형식: to_char(데이터, '출력할 형식')
3. 날짜형을 문자열로 표현하는 출력형식
	1) CC: 세기
	2) YYYY/YYY/YY/Y: 연도
	3) AD/A.D: AD/BC
	4) Q: 분기
	5) MM/MONTH/MON: 월
	6) WW/W: 연, 월을 주 단위로 표기
	7) DDD/DD/D: 날짜
	8) DY/DAY: 요일
	* 주의: 위 형식에 한글 등 특수문자를 혼합해서 표현할 때는 형식을 'YYYY "년도" MM "월"' 로 "추가문자열" 사용
4. date 타입의 시간 표시 형식
	1) AM/PM: 오전/오후 시간 표시
	2) A.M/P.M: 오전/오후 시각
	3) HH/HH12: 시각(1~12)
	4) HH24: 24시간(0~23)
	5) MI: 분
	6) SS: 초
 */

SELECT ename, hiredate,
	to_char(hiredate, 'CC') "세기",
	to_char(hiredate, 'YYYY') "년도",
	to_char(hiredate, 'Q') "분기",
	to_char(hiredate, 'MM') "월",
	to_char(hiredate, 'YYYY"년 " MM"월 " DD"일 "') "날짜표시1",
	to_char(hiredate, 'CC"세기 " WW"째 주" DAY') "날짜표시2"
FROM emp;
--ex: (사원명)은 @@년 @@월에ㅔ 입사하였습니다.
SELECT ename, hiredate,
	ename||'은 '||TO_CHAR(hiredate, 'YYYY"년 "MM"월"')||'에 입사하였습니다.' "str"
FROM emp;
--ex2: 1/4분기에 입사한 사원의 이름과 입사년월일 분기 출력
SELECT ename, TO_char(hiredate, 'YYYY"년 "MM"월 "DD"일 ("Q"분기)"') "hiredate"
FROM EMP e 
WHERE TO_NUMBER( TO_CHAR(hiredate, 'Q')) = 1; 

SELECT TO_CHAR(sysdate, 'AM HH:MI:SS') "시간"
FROM dual;
--ex3: emp 테이블에서 사원명, 입사일+현재시간표현(24시간표현) YYYY년 MM월 DD일 HH시 MI분 SS초 
SELECT ename, TO_CHAR(hiredate, 'YYYY"년 "MM"월 "DD"일 "HH24"시 "MI"분 "SS"초 "')
FROM emp;

/*

# to_number
1. 매개변수로 받은 데이터를 숫자형으로 변환
2. 기본형식: to_number(데이터)
cf) 주로 자동 형변환이 일어나서 사용되지 않는 경우도 많으나, 명시적인 형변환으로 해당 타입을 구분할 때 사용 됨.

# to_date
1. 숫자와 문자로 구성된 데이터를 날짜데이터로 변환
2. 기본형식: to_date('문자열', '날짜형식')

 */

--ex1: '1000' 문자열을 sal 값과 비교하여 이상인 데이터 조회 (명시적 함수 이용)
SELECT *
FROM EMP e 
WHERE sal >= TO_NUMBER('1000'); 

--ex2: emp01에 사원번호, 사원명, 입사날짜 지정하여 데이터 입력
INSERT INTO emp01(empno, ename, HIREDATE)
VALUES (7900,'홍길동', to_date('2020/12/31 23:59:59', 'YYYY/MM/DD HH24:MI:SS'));

SELECT *
FROM emp01;

INSERT INTO emp01(empno, deptno, ename, HIREDATE)
VALUES (8200, 30, '김이박', to_date('2021/06/09 12:15:25', 'YYYY/MM/DD HH24:MI:SS'));

SELECT *
FROM emp01;