package javaexp.a11_io;

import java.io.IOException;
import java.io.InputStream;

/*

# 데이터의 전송을 처리하는 Stream

1. 자바에서는 Stream이라는 api 객체를 통해서, 데이터를 입력하거나 출력하는 등 처리를 하고 있다.
2. System.out.println() 기본적인 자바의 OutputStream을 통해서 console화면에 출력되게 한다.
3. 입력 처리를 하는 InputStream
	1) 주요 메소드
		read() : 문자(char) ==> code 값으로 연결되어 있어서, 저장되는 것은 정수형이라고 할 수 있다.
				이것을 char로 코드값과 연결되어있는 문자로 표현하여 처리한다.



 */



public class A01_Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int codeValue = 65;
		char char01 = (char)codeValue;
		System.out.println(char01);
		
		for ( ; codeValue < 65+26; codeValue++) {
			char01 = (char) codeValue;
			System.out.print(char01+" ");
		}
		
		System.out.println();
		//임의 비밀번호 대문자 4개
		String pass="";
		for (int i = 0; i<4; i++) {
			int randCode = (int)(Math.random()*26+65);
			pass += (char)randCode;
		}
		System.out.println("임의 비밀번호: "+pass);
		
		
		char char02 = 'A';
		System.out.println(char02+"의 코드 값: "+(int)char02);
		System.out.println("=====================");
		
		// console에서 입력받을 수 있는 객체 InputStream
		InputStream is = null;
		System.out.print("데이터를 입력하세요(문자 1개): ");
		is = System.in;
		
		//입력된 글자 한 자를 읽어와서 데이터 할당하고 할당된 내용 출력
		try {
			int num = is.read();
			System.out.println("입력된 문자의 코드 값: "+num);
			System.out.println("입력된 문자: "+(char)num);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 예외 발생과 관계 없이 처리하는 내용
			// Stream 자원을 해제해야 한다!!
			
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
