--a06_func_date


/*
# 날짜함수

1. 날짜형 데이터 타입에 사용하는 함수
	 1970/1/1
	 1/1000초, 1초, (60)1분, (60)1시간, (24)1일(*), (calender 규칙에 의해 28/30/31)1월, (12)1년
2. 기본 연산
	1) 날짜 +- 숫자 : 해당 일자엘 일수 가감
	2) 날짜 +- 1/24: 시간단위 연산처리 (5시간 이후는 +5/24)
cf) sysdate는 현재 날짜시간
*/

SELECT sysdate "현재날짜/시간",
	SYSDATE +1 "24시간 후",
	SYSDATE -1 "24시간 전",
	sysdate+(8/24) "8시간 후"
FROM dual;
--ex
SELECT ename "이름", hiredate "입사일", hiredate+120 "인턴기간", hiredate-(8/24) "입사 8시간전",
		round(sysdate-hiredate) "근무일수"
FROM emp;

/*
# 날짜함수
1. sysdate: 오라클에서 서버시스템의 현재 날짜와 시간
2. months_between(날짜1, 날짜2): 날짜 사이의 개월을 월단위로 계산.
	기준단위 1 ==> 1개월, 0.5 ==> 15일,
	1달을 기준으로 일/시/분/초 단위로 소숫점 계산
3. 소숫점 이하에 대한 처리는 trunc, floor를 이용해서 절삭
	1.5개월을 개월차로 ceil, 개월수는 trunc, floor
 */


SELECT ename, hiredate, sysdate,
	MONTHS_BETWEEN(sysdate, hiredate) "근무개월수1",
	trunc(MONTHS_BETWEEN(sysdate, hiredate)) "근무개월수2",
	TRUNC(MONTHS_BETWEEN(sysdate, hiredate)/12) "근무연한3"
FROM emp;
--ex1: dual로 오늘부터 100일 후 개월 수 출력
SELECT sysdate, trunc(MONTHS_BETWEEN(sysdate+100, sysdate))
FROM dual;
/*
개월수: trunc(MONTHS_BETWEEN(sysdate+1000, sysdate))
연도: trunc(MONTHS_BETWEEN(sysdate+1000, sysdate)/12)
연도를 뺀 개월수: 나머지값(mod)
두 날짜 사이의 @@년 @@개월 차이: MONTHS_BETWEEN, MOD 활용
 */

--ex2: 오늘부터 1000일후의 연한, 개월수. mod 함수 활용
SELECT sysdate, sysdate+1000 "1000일 후",
	trunc(MONTHS_BETWEEN(sysdate+1000, sysdate)/12)||'년 '
		||mod(trunc(MONTHS_BETWEEN(sysdate+1000, sysdate)), 12)||'개월' "1000일후까지"
FROM dual;

/*
4. add_months(날짜형 데이터, 추가개월수) : 해당 날짜에 개월을 덧셈
 */
SELECT sysdate, add_months(sysdate, 4)
FROM dual;
--ex: 사원정보로 인턴기간 정하기. 부서번호 10, 20, 30 ==> 인턴기간 1, 2, 3개월.
--		사원명 부서번호 입사일 인턴기간만료일
SELECT ename, deptno, hiredate "고용날짜",(deptno/10) "인턴기간", add_months(hiredate, (deptno/10)) "인턴기간만료일"
FROM emp;

/*
5. next_day(날짜, '요일'): 대상 '날짜'로부터 첫번째 '요일'에 해당하는 날짜
6. last_day(날짜): 대상날짜 월의 마지막 일자
*/
SELECT sysdate, NEXT_DAY(sysdate, '금'),
		NEXT_DAY(NEXT_DAY(sysdate, '금'), '금'),
		LAST_DAY(sysdate),
		LAST_DAY(SYSDATE)+1
FROM dual;
--ex: 입사일을 기준으로 다가오는 첫번째 월요일 출력, 입사일 기준으로 첫번째 급여는 입사월의 다음월 첫째날.
--		사원명, 입사일, 첫번째 일요일, 첫 급여일
SELECT ename, hiredate, NEXT_DAY(hiredate, '일'), LAST_DAY(hiredate)+1
FROM emp;

