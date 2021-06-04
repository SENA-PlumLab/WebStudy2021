package javaexp.a04_condition;

import java.util.Scanner;

public class A02_DoubleIF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String inputID="", inputPass="";
		
		System.out.print("ID: ");
		Scanner sc1 = new Scanner(System.in);
		inputID=sc1.nextLine();
		
		System.out.print("Pass: ");
		Scanner sc2 = new Scanner(System.in);
		inputPass=sc2.nextLine();
		
		if(inputID.equals("himan")) {
			if(inputPass.equals("7777")) {
				System.out.println("인증 완료");
			}
			else {
				System.out.println("패스워드를 확인하세요");
			}
		} else if (inputPass.equals("7777")) {
			System.out.println("ID를 확인하세요");
		} else {
			System.out.println("아이디, 패스워드 다 틀렸습니다.");
		}
	}

}
