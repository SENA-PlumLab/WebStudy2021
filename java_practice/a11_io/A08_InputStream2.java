package javaexp.a11_io;

import java.io.IOException;
import java.io.InputStream;

/*

# 입력스트림 출력스트림
1. 입력스트림: 프로그램을 기준으로 특정한 입력도구나 프로그램을 통해 데이터를 입력받게해주는 객체
	1) 출발지: 키보드, 파일, 프로그램
	2) 도착지: 입력받은 데이터 처리
	3) 입력스트림: 출발지~도착지 사이의 데이터 전달 객체
2. 출력스트림: 프로그램 기준으로 데이터를 대상 출력도구나 프로그램에 전달해주는 객체
	1) 출발지: 프로그램을 통한 명령
	2) 도착지: 모니터, 저장파일, 프로그램
	3) 출력스트림: 출발지~도착지 사이의 데이터 전달 객체
	
3. 바이트 기반/ 문자 기반 스트림
	1) 바이트 기반: 그림, 멀티미디어, 문자 등 모든 종류의 데이터를 받고 보애는 것이 가능한 스트림.
		InputStream(입력) <--- XXXInputStream
		OutputStream(출력) <--- XXXOutputStream
	2) 문자 기반: 문자만 받고 보낼 수 있도록 특화된 스트림.
		Reader(문자입력) <--- XXXReader
		Writer(문자출력) <--- XXXWriter

4. InputStream
	1) 바이트 기반 입력 스트림의 최상 클래스로 추상클래스
	2) 상속관계
		InputStream
		 - FileInputStream
		 - BufferedIputStream
		 - DataInputStream
	3) 주요 메서드
		read(): byte로 입력만 문자 1자 읽기 처리
				(char) 캐스팅을 통해 처리
		read(byte[] b): 입력한 문자열을 byte[]에 담아 처리
		read(byte[] b, int off, int len): 입력한 문자열 byte[]중에서 특정 위치에 있는 부분 추출
		close(): Stream을 통해 처리한 시스템 자원을 반납하고 스트림을 닫는다.
 */
public class A08_InputStream2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. 입력스트림 객체 System.in(자바의 기본 입력처리) 통해 객체 생성
		InputStream is = System.in;
		
		//2. 입력받은 문자열의 크기 지정
		byte[] br = new byte[5];
		
		//3. read(입력받아 저장할 배열)
		try {
			System.out.println("문자를 입력하세요");
			//입력받은 문자열을 byte[] b에 할당
			int n =is.read(br);
			System.out.println("문자 갯수: "+n);
			System.out.print("입력된 문자: ");
			for(byte b: br) {
				System.out.print((char)b);
			}
			System.out.println();
			System.out.println("출력 끝");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		}
	}

}
