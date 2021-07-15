--ex 6
/*
# SQL 함수 유형
1. 단일 행 함수: 테이블에 저장되어있는 개별 행을 대상으로 함수를 적용해서 하나의 결과를 반환하는 함수
2. 복수 행 함수: 조건에 따라 여러 행을 그룹화하여 그룹별로 결과를 하나씩 반환하는 함수
*/
--ex 7
--  대소문자 구분없이 검색.. 
SELECT *
FROM emp
WHERE upper(ename) LIKE '%' || upper('e') || '%';

SELECT *
FROM emp
WHERE lower(ename) LIKE '%' || lower('a') || '%';