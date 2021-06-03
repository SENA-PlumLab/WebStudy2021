/*
#과제#
1. 함수란 무엇이며, 함수에 단일행 함수와 다중행 함수의 차이점을 예시를 통해서 설명하세요.
2. 문자 함수가 사용되는 용도에서 웹화면에 물품명을 대소문자 관련없이 검색한다고 가정할 때,
    product(테이블명), pname(검색할 물건명) 을 기준으로 sql을 작성하세요.
     물건명 [      ] [검색] 검색클릭시, 대소문자 관련 없이 키워드 검색이 되게 처리할려면
     어떤 sql를 작성할지 기술하세요.
3. length와 lengthb를 차이를 기술하고,  dual을 이용해서 한글과 영문을 비교하세요.
4. ||, substr  이용하여  [ename(deptno)의 직책은 job 입니다. ] 형식으로 출력하세요.   
    ename : 앞에서 3자 추출
    job :뒤에서 5자 추출
5. lpad와 ltrim의 기본적인 형식을 기본예제와 함께 기술하세요.
6. 숫자형 함수의 종류와 기능상 특징을 기술하세요.
7. 사원 번호의 3으로 나누어 %로 해서, 0 ==> 0%, 1 ==>10%, 2==>20%
   보너스를 정하여, sal기준으로 원금+보너스 합산을 출력하되,
   10자리단위로 반올림 처리하여 출력하세요
   사원명, 급여, 보너스(%), 보너스, 총계
8. 관리자 번호가 짝수인 사번과 관리자 번호와 급여를 출력하되, 급여는 100자리 수로 절삭하여 처리하세요.
*/

--ex1
/*
1. 단일 행 함수: 데이터값 조작에 주로 사용됨. 값 하나 받아서, 값 하나 내보냄.
	ex) upper('keword') ==> 'KEYWORD'
2. 복수 행 함수: 여러 데이터를 받아 하나씩 값을 반환한다.

*/

--ex2
-- product 테이블에서 대소문자 구문 없이 keyword로 pname 검색
SELECT *
FROM product
WHERE upper(pname) LIKE '%' || upper('keyword') || '%';

--ex3
-- length: 문자열의 문자 갯수
-- lengthb: 문자열의 바이트 크기 (언어마다 1글자당 값이 다를 수 있음)
SELECT length('안녕') "length", lengthb('안녕') "lengthb"
FROM dual;

--ex4
SELECT SUBSTR(ename,0,3)||'('||deptno||')의 직책은 '|| SUBSTR(job,LENGTH(job)-4,LENGTH(job))||'입니다.' "str"
FROM emp;

--ex5
-- lpad(데이터, 크기지정, 덧붙일 문자열)
-- ltrim(대상 문자열, 잘라낼 문자)
SELECT lpad('hello', 10, '@') "lpad",
		ltrim('**안녕하세요**','*') "ltrim"
FROM dual;

--ex6
/*
숫자형 데이터를 원하는 형태로 수학적 처리나 연산을 처리해주는 함수.
round, trunc, mod, ceil, floor
 */

--ex7
SELECT ename "사원명", sal "급여", mod(empno,3)*10||'%' "보너스(%)", 
				round(sal*(mod(empno,3)/100), -1) "보너스", 
				sal+round(sal*(mod(empno,3)/100), -1) "총계"
FROM emp;

--ex8
SELECT empno"사원번호", mgr "관리자번호", trunc(sal,-2) "월급"
FROM emp
WHERE MOD(mgr,2) = 0;





















