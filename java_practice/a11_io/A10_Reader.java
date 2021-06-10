package javaexp.a11_io;

import java.io.IOException;
import java.io.InputStreamReader;

import javaexp.z01_vo.Product;

/*

# 문자에 대한 처리를 해주는 Reader/Writer 객체
1. 2byte이상의 문자에 대한 처리를 해주는 Stream 객체 //한글가능


 */

public class A10_Reader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		InputStreamReader reader = new InputStreamReader(System.in);
		char[] chArr = new char[10];
		System.out.println("이름을 입력하세요");
		try {
			reader.read(chArr);
			System.out.print("입력된 이름: ");
			for(char c:chArr) {
				System.out.print(c);
			}
			System.out.println();
			System.out.println("출력 끝");
			
			//Stream 자원 해제
			//reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//ex
		
		InputStreamReader reader2 = new InputStreamReader(System.in);
		char[] name= new char[10];
		char[] price = new char[10];
		char[] cnt = new char[10];
		
		try {
			System.out.println("물건이름:");
			reader2.read(name);
			System.out.println("가격:");
			reader2.read(price);
			System.out.println("갯수:");
			reader2.read(cnt);
			
			Product p1 = new Product(new String(name).trim(), Integer.parseInt(new String(price).trim()), Integer.parseInt(new String(cnt).trim()));
			System.out.println(p1.getName()+", "+p1.getPrice()+", "+p1.getCnt());
			
			//Stream 자원 해제
			reader2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
