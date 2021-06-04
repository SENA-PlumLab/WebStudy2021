package javaexp.a11_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*



 */


public class A05_StreamBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String id="", pass="";
		String[] user1 = {"id123","pass123"};
		
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader buffer2 = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.print("ID: ");
			id = buffer.readLine();
			System.out.print("PASS: ");
			pass = buffer2.readLine();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				buffer.close();
				buffer2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("입력한 ID: "+id+"\t PASS: "+pass);
		System.out.println("=============================");
		if(id.equals(null)||pass.equals(null)) {
			System.out.println("입력하세욧!");
		} else if (id.equals(user1[0]) && pass.equals(user1[1])) {
			System.out.println(id+"님 어서오세용");
		} else {
			System.out.println("로그인 실패");
		}
		
	}

}
