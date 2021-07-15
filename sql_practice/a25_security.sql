/*
# 데이터베이스 보안을 위한 권한 설정
1. 데이터 베이스 관리자(DBA)는 사용자가 데이터베이스 객체 (테이블, view, sequence.. )에 대한
	특정 권한을 가질 수 잇게 하여, 다수의 사용자가 데이터 베이스에 저장된 정보를 공유하면서도
	정보에 대한 보안이 이루어지도록 한다.
2. DB 서버에 접근시 필요한 사용자 계정/암호를 통해 로그인 인증을 받는다.
3. 권한의 역할과 종류
	1) CREATE USER: 사용자를 새롭게 생성하는 권한
	2) DROP USER: 사용자를 삭제하는 권한
	3) DROP ANY TABLE : 테이블 삭제
	4) query rewrite: 함수기반 인덱스 생성 권한
	5) backup ANY TABLE : 테이블 백업
	6) create session: 데이터베이스에 접속할 수 있는 권한
	7) create table/view/sequence/procedure: 데이터베이스의 객체들을 생성하는 권한
	
	
	
	
*/ 