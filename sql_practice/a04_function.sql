

/*
# 문자열 길이 반환
1. length(데이터/컬럼명): 입력되는 문자열의 길이를 반환하는 함수
2. lengthb(데이터/컬럼명): 입력되는 문자열의 바이트를 반환하는 함수
	한글이나 특수문자는 1글자에 3byte인 경우가 있으므로 글자수 차이가 있을수있다.
cf) dual: 오라클에서 지원되는 가상 테이블로 테스트용으로 한 라인에 데이터와 함수의 적용결과를 확인할 수 있다.
*/
SELECT length('hello') str1, LENGTHB('hello') str2,
		LENGTH ('안녕하세요') str3, LENGTHB('안녕사헤요') str 
FROM dual;
--ex) emp 테이블의 사원명과 직책의 글자수를 각각 표현하되, job의 글자수가 6이상인 경우만 검색 출력.
SELECT ename, LENGTH(ename) "ename 글자수",
		job, LENGTH(job) "job 글자수"
FROM emp
WHERE LENGTHB(job) >= 6 ;

/*
# 기타 문자열 조작함수
1. concat(문자열1, 문자열2): 두 문자열 결합
	문자열1 || 문자열2 동일
	concat(concat(문자열1, 문자열2), '문자열3') -> 문자열1||문자열2||문자열3
	ex) concat('sql','plus') ==> sqlplus
2. substr(문자열데이터, 시작위치, 마지막위치-갯수):
	문자열 데이터를 시작위치와 마지막위치를 기준으로 절삭처리
	ex) substr('sql*plus', 5, 4) ==> 'plus'
	ex) 코드성 데이터 (사번, 학번, 주민번호 등)에는 위치별로 의미가 있기 때문에 추출해서 사용하기 좋음

*/
SELECT concat(ename, concat('-',job)) "이름과 직책"
FROM emp;
SELECT concat(substr(hiredate,0,2)+1900,'년 ')||concat(substr(hiredate,4,2),'월 ')||concat(substr(hiredate,7,2)+0,'일 ') "입사일",
		ename "사원명"
FROM emp;

/*
#instr(지정한 문자열 데이터|컬럼,'검색문자')
1. 특정한 문자열ㅇ르 검색해서 해당 문자열의 위치를 index로 반환해주는 처리
	ex) 주로 대용량의 문자열 데이터를 검색해서 해당 문자의 위치를 index로 찾아 처리할 때 사용
*/
SELECT instr('sq;*pluus','*') FROM dual;

/*
# lpad(left padding) rpad(right padding)
1. 전체 문자의 크기를 지정하고 그 크기보다 못할 때 왼쪽/오른쪽을 특정 문자로 추가하게 함

2. 형식
	lpad(데이터, 크기지정, 덧붙일 문자열)
	rpad(데이터, 크기지정, 덧붙일 문자열)


 */


SELECT lpad(ename, 6, '#') "이름",
		rpad(job, 8, '@') "직책"
FROM emp;


/*
@ ltrim/rtrim
1. 왼쪽 오른쪽 지정 문자열 삭제 처리
*/

SELECT ltrim('****sql*****', '*') s1,
		rtrim('****sql*****', '*') s2
FROM dual;

/*
# 숫자형 처리 함수
1. 숫자형 데이터를 원하는 형태로 수학적 처리나 연산을 처리해주는 함수.
2. 종류
	1) round: 지정한 소숫점 자리로 반올리 처리
		round(데이터, 자릿수) -- 자릿수 +값은 소숫점 이하 자릿수
		ex) round(56.2423, 2) ==> 45.24
		ex) round(2456435, -3) ==> 2456000
	2) trunc: 지정한 소숫점 자리까지 남기고 절삭
		trunc(데이터, 자릿수) cf) floor():정수로 절삭
	3) mod: 데이터베이스에서 산술연산자 %대신 쓰이는 나머지 처리 함수를 말함
		mod(데이터, m): 데이터를 m으로 나눈 나머지값
		ex)mod(10,3) ==> 1
	4) ceil: 지정한 값보다 큰 수 중에서 가장 작은 정수 소숫점이하의 내용에 대하여 올림 정수.
	5) floor: 지정한 값보다 작은 수 중에서 갖아 큰 정수. 소숫점 이하의 내용에 대하여 내림 정수.

*/

SELECT
	round(243323.235, 3),
	round(243323.233, 1),
	round(243325.233, -1),
	round(243323.235, -2), --23이므로 반올림하면 243300
	round(243523.253, -3) --523이므로 반올림하면 244000
FROM dual;
--ex 사원명과 sal, sal은 15%인상금액을 100단위와 소숫점 1자리 단위로 반올림 처리.

SELECT ename "이름", round (sal,-2) "기존 급여",
		round(sal*0.15,1) "인상 금액",
		round (sal*1.15,1) "인상 후 급여"
FROM emp;

--ex
SELECT ename, sal||'에서 '||DEPTNO||'%인상' "인상률" , 
	trunc(sal*(1+(deptno/100)), 2) "인상 후 급여",
	trunc(sal*(1+(deptno/100)), -2) "인상 후 급여"
FROM emp;


/*
mod : %대신 활용 (나머지)
 */
SELECT mod(10,3) s1, mod(10,2) s2,
FROM dual;
--ex 사번 짝수의 데이터
SELECT empno, ename, mod(empno,2) "홀짝" 
FROM EMP e 
WHERE mod(empno,2) = 0;