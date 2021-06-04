package javaexp.a04_condition;

import java.util.Scanner;

public class A03_SwitchCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inputNum=0;
		int multx=0;
		
		System.out.print("1~10 입력: ");
		Scanner sc1 = new Scanner(System.in);
		inputNum = sc1.nextInt();
		
		switch(inputNum) {
		
		case 1:
		case 5:
		case 8:
			System.out.println("200% 입니다!!");
			multx=2;
			break;
		case 2:
		case 4:
		case 9:
			System.out.println("300% 입니다!!");
			multx=3;
			break;
		default:
			System.out.println("꽝!");
			multx=1;
		}
		
		int price = 0;
		System.out.print("투자할 금액 입력: ");
		Scanner sc2 = new Scanner(System.in);
		price = sc2.nextInt();
		
		System.out.println("투자 결과: "+(price * multx)+"원");
		
	}

}
