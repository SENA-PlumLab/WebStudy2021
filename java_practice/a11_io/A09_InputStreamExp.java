package javaexp.a11_io;

import java.io.IOException;
import java.io.InputStream;

public class A09_InputStreamExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InputStream is = System.in;
		
		byte[] irr = new byte[8];
		byte[] prr = new byte[8];
		
		try {
			System.out.print("id 입력: ");
			is.read(irr);
			System.out.print("pass 입력: ");
			is.read(prr);
			System.out.print("입력된 id: ");
			for(byte b:irr) {
				System.out.println((char)b);
			}
			System.out.println();
			System.out.print("입력된 pass: ");
			for(byte b:prr) {
				System.out.println((char)b);
			}
			System.out.println();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("# 입출력 끝 #");
	}

}
