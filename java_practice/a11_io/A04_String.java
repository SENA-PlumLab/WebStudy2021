package javaexp.a11_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

# Stream 객체를 통해서 문자열을 입력 처리 . . .

1. Stream 객체의 기능적으로 추가되는 기능은
 	생성자를 통해 확장된 기능이 만들어지는 패턴으로 구성되어있다.
	InputStream : char ==> char[]
		1byte의 문자만 처리 (한글, 특수, 입력 불가능)
2. 기능적으로 확장된 객체는 InputStream을 상속 받은 하위 객체들이다.
3. 하위 객체를 독립적으로 혼자 써서 기능을 구현하지는 못하고, 
	new 최하위(하위객체(상위객체))
	와 같은 생성자를 통해 상위객체를 가지고 기능을 추가/처리한다.
4. InputStream 하위 객체들..
	1) InputStreamReader : 2byte 이상 문자를 처리해준다.
	2) BufferedReader : 객체에서는 입력된 내용을 효율적으로 사용하기 위해 Buffer메모리를 사용하는데,
						readLine() 메소드를 통해서 문자를 하나하나 다 받아서 문자열을 만들고
						enter키를 단위 데이터로 입력받아 처리한다.
		ex) InputStream is = System.in; 이던 것을				
		ex) BufferedSReader buffer =
				new BufferedReader(new InputStreamReader(System.in)); 으로 씀.
		

 */


public class A04_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("등록 아이디 입력: ");
		BufferedReader buffer =
					new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String id = buffer.readLine();
			System.out.println("등록된 아이디는 "+id+" 입니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				buffer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
	}

}
