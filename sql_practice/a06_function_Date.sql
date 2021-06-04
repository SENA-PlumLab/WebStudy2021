--a06_func_date


/*
# 날짜함수
1. 날짜형 데이터 타입에 사용하는 함수
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



SELECT ename, hiredate, sysdate,
	MONTHS_BETWEEN(sysdate, hiredate) "근무개월수1",
	trunc(MONTHS_BETWEEN(sysdate, hiredate)) "근무개월수2",
	TRUNC(MONTHS_BETWEEN(sysdate, hiredate)/12) "근무연한3"
FROM emp;
--ex1: dual로 오늘부터 100일 후 개월 수 출력
SELECT sysdate, trunc(MONTHS_BETWEEN(sysdate+100, sysdate))
FROM dual;
--ex2: 오늘부터 1000일후의 연한, 개월수. mod 함수 활용
SELECT sysdate, sysdate+1000 "1000일 후",
	trunc(MONTHS_BETWEEN(sysdate+1000, sysdate)/12)||'년 '
		||mod(trunc(MONTHS_BETWEEN(sysdate+1000, sysdate)), 12)||'개월' "1000일후까지"
FROM dual;


