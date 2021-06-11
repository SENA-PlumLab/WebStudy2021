/*
# 중첩함수
1. 가장 내부에있는 함수 f1의 결과값을 다음 함수 f2에 인수로 적용하고,
	다시 f2의 결과값을 f3에 인수로 사용할 때 활용하는 함수 형태.
	f3(f2(f1(데이터, 매개변수), 매개변수), 매개변수)
	- 특정한 데이터에서 여러 함수의 기능을 처리하고잘 할 때 활용 됨.
*/

-- 현재 데이터의 입사년돌를 올해년도로 변경하여 출력
SELECT ename, to_char(sysdate, 'YYYY') "올해연도", to_char(hiredate, 'MMDD') "입사월일",
		to_char(sysdate, 'YYYY')||to_char(hiredate, 'MMDD') "올해입사년월",
		to_date(to_char(sysdate, 'YYYY')||to_char(hiredate, 'MMDD'), 'YYYYMMDD') "날짜형데이터"
FROM emp;
--ex: 입사 분기 1~4에 따라 보너스 (급여의)10~40%
SELECT ename, hiredate, sal, to_char(hiredate, 'Q')*10 "보너스(%)", sal*(1+to_char(hiredate, 'Q')*0.1) "최종금액"
FROM emp;

/*
2. nvl2 
nvl(비교대상 데이터, 데이터) 
nvl2(비교할 데이터, null이 아닐때, null일때)
 */
-- ex) comm이 null이면 sal의 15%, null이 아닐 때는 comm에서 sal5% 더함
SELECT sal, comm, nvl2(comm, comm+sal*0.05, sal*0.15) "보너스", nvl2(comm, sal*1.05+comm, sal*1.15) "합계"
FROM emp;

/*
3. nullif(데이터1, 데이터2)
두개의 매개변수를 비교해 동일하면 NULL, 동일하지 안흥면 첫번째 데이터1 반환
*/
SELECT nullif('a', 'a') show1,
		nullif('a', 'b') show2,
		nvl(nullif('a', 'a'), '동일') show1,
		nvl(nullif('a', 'b'), '동일') show2
FROM dual;

-- ex) 일괄보너스가 60일 때, 연봉의 5%(10단위 절삭)과 같으면 그대로 60, 다르면 연봉의 5%로 처리

SELECT trunc(sal*0.05, -1) "연봉의 5%",
		NULLIF(60, trunc(sal*0.05, -1)) "연봉의 5%와 같은지",
		nvl2(NULLIF(60, trunc(sal*0.05, -1)), trunc(sal*0.05, -1), 60)
FROM emp;


/*
decode 함수
1. 프로그래밍 언어의 if문이나 case문으로 표현되는 내용을 하나의 함수로처리할 수 있게 해준다.
2. 기본형식
	decode(데이터, case1, case1일때처리할데이터,
				 case2, case2일때처리할데이터,
				 case3, case3일때처리할데이터,
			위 내용에 해당하지 않을 때 데이터)
*/

SELECT ename, deptno, decode(deptno, 10, '인사과', 20, '총무', 30, '회계', '부서정하지않음') "부서명"
FROM emp;

-- 사원번호 짝수 홍팀 홀수 청팀
SELECT ename, empno, decode(MOD(empno, 2), 0, '홍팀', 1, '청팀', '없음') "팀"
FROM emp;

-- 입사일의 분기ㅇ를 기준으로 1:부산, 2:광주, 3:제주, 그외:x 으로 출장 간다.
-- 사원명, 입사일, 분기, 출장지 출력
SELECT ename "이름", hiredate "입사일", TO_CHAR(hiredate, 'Q') "분기",
		decode(TO_CHAR(hiredate, 'Q'), 1, '부산', 2, '광주', 3, '제주', '없음') "출장지"
FROM emp;


/*
# 일반 함수 CASE
1. decode의 확장된 함수 형식은 표현식 또는 컬럼 값 '=' 비교를 통해 조건에 일치하는 경우에만 다른 값으로 대치하지만,
	CASE 함수에서는 산술, 관계, 논리 연산과 같은 다양한 비교가 가능하다.
2. 기본 형식
	1) 조건문 형태 활용
	CASE WHEN 논리|상술|관계 THEN 처리할 데이터
		 WHEN 논리|상술|관계 THEN 처리할 데이터
		 ELSE 기타 처리할 데이터
	2) switch CASE 형태
	CASE 컬럼명
		WHEN 데이터1 THEN 처리데이터
		WHEN 데이터2 THEN 처리데이터
		ELSE 그외 데이터
	END
*/
--부서번호에 따라 처리하는 데이터를 다르게 할 때
SELECT ename, deptno, 
	CASE WHEN deptno=10 THEN sal*0.2
		 WHEN deptno=20 THEN sal*0.6
		 WHEN deptno=30 THEN sal*0.7
		 ELSE sal*1.2
	END show
FROM emp;
SELECT ename, deptno, 
	CASE deptno
		 WHEN 10 THEN sal*0.2
		 WHEN 20 THEN sal*0.6
		 WHEN 30 THEN sal*0.7
		 ELSE sal*1.2
	END show
FROM emp;

--ex) case문으로 분기별 보너스 금액을 급여의 30%, 20%, 10%, 5%로 지정.
--		사원명 입사일 입사분기 급여 보너스
SELECT ename "사원명", hiredate "입사일", to_char(hiredate, 'Q') "입사분기", sal "급여",
		CASE to_char(hiredate, 'Q')
			WHEN '1' THEN sal*0.3
			WHEN '2' THEN sal*0.2
			WHEN '3' THEN sal*0.1
			WHEN '4' THEN sal*0.05
			ELSE 0
		END "보너스"
FROM emp;

/*
비교연산자 sal >= 5000, sal>=4000
*/

-- 등급표시 5000~ A등급, 4000~5000미만 B등급 ... 0~1000미만 F등급.. 그 외 .
-- case when 활용
SELECT ename, sal, 
		CASE WHEN sal>=5000 then 'A등급'
			 WHEN sal>=4000 then 'B등급'
			 WHEN sal>=3000 then 'C등급'
			 WHEN sal>=2000 then 'D등급'
			 WHEN sal>=1000 then 'E등급'
			 ELSE 'F등급'
		END "등급"
FROM emp;

-- 사원명, 입사일, 입사월, 입사월기준구분(상/하반기 구분표시)
SELECT ename, hiredate, TO_NUMBER(TO_CHAR(hiredate, 'MM')) "입사월", 
	CASE WHEN TO_NUMBER(TO_CHAR(hiredate, 'MM')) >=6  THEN '하반기'
		else '상반기'
	END "상/하반기"
FROM emp;