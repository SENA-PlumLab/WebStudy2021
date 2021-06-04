package javaexp.a11_io;

import java.io.IOException;
import java.io.InputStream;

public class A02_InputStreamExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char a = '2';
		System.out.println(Integer.parseInt(""+a));
		// a의 String 표시 값 "2"가 int 화 되어서
		// 2가 출력된다.
		// 즉, Integer.parseInt(""+char변수) 하면 아스키코드 값이 아닌 표시값이 int화 된다.
		// (int)char변수 != Integer.parseInt(""+char변수) 이다.
		InputStream is = null;
		System.out.print(" 정답을.. 입력해보세요(1~4): ");
		is = System.in;
		
		try {
			char char01 = (char)(is.read());
			char randNum = (char)(int)(Math.random()*4+49);
			//System.out.println(char01);
			//System.out.println(randNum);
			if (char01 == randNum) {
				System.out.println(char01+"번 정답입니다!");
			} else {
				System.out.println(char01+"번은.. 오답입니다...");
				System.out.println("정답: "+randNum);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
