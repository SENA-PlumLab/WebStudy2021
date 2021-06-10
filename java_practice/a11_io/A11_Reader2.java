package javaexp.a11_io;

import java.io.InputStreamReader;

public class A11_Reader2 {
	
	public static void main(String[] args) {
		
		InputStreamReader reader = new InputStreamReader(System.in);
		char[] nArr = new char[10];
		char[] pArr = new char[10];
		char[] cArr = new char[10];
		
		try {
			System.out.print("물건 이름 입력: ");
			reader.read(nArr);
			System.out.print("물건 가격 입력: ");
			reader.read(pArr);
			System.out.print("물건 갯수 입력: ");
			reader.read(cArr);
			
			//trim() : 입력되지 않는 공백문자 처리
			String pname = new String(nArr);
			System.out.println("물건명: "+pname.trim());
			
			String prS = new String(pArr);
			int price = Integer.parseInt(prS.trim());
			System.out.println("가격: "+price);
			
			String cnS = new String(cArr);
			int cnt = Integer.parseInt(cnS.trim());
			System.out.println("갯수: "+cnt);
			System.out.println("총계: "+(price*cnt));
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
