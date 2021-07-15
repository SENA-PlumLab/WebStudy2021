/*
# SEQUENCE 
1. 유일한 식별자 데이터를 만들기 위한 객체
2. 기본 키 값을 자동으로 생성하기 위하여 일련번호를생성한다.
	ex. 웹 게시판에 KEY 글번호를 순서대로 등록할 때 sequence 활용
3. 여러 테이블에서 공유 가능
4. 기본 형식
	CREATE SEQUENCE 시퀀스명
		INCREMENT BY 증가단위
		START WITH 시작번호
		MAXVALUE 최대값|nomaxvalue
		MINVALUE 최대값|nominvalue
		CYCLE|nocycle -- 반복여부 설정
		cache n | nocache == 속도 개선을 위해 메모리 캐시 시퀀스 수
5. 선언된 시퀀스 사용
	1) 시퀀스명.nextval: 현재 시퀀스 번호를 출력하면서 다음 시퀀스 넘버링 처리
	2) 시퀀스명.currval: 현재 시퀀스 번호 출력
*/

CREATE SEQUENCE seq_01
	INCREMENT BY 1
	START WITH 1
	MINVALUE 1
	MAXVALUE 999999;
SELECT seq_01.nextval, seq_01.currval
FROM dual;

DROP SEQUENCE seq_01;

--ex. 
CREATE SEQUENCE seq_02
	INCREMENT BY 1
	START WITH 1001
	MINVALUE 1001
	MAXVALUE 9999;
CREATE SEQUENCE seq_03
 	INCREMENT BY -1
 	START WITH 8888
 	MINVALUE 8888
 	MAXVALUE 1000;
 CREATE SEQUENCE seq_04
 	INCREMENT BY 5
 	START WITH 1
 	MINVALUE 1
 	MAXVALUE 50;
 SELECT seq_02.nextval, seq_03.nextval, seq_04.nextval
 FROM dual;
