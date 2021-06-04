package javaexp.a03_Calcu;

import java.util.Scanner;

public class A01_BasicCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*
		
		System.out.print("ID입력: ");
		Scanner sc = new Scanner(System.in);
		String inputID = sc.nextLine();
		if(!inputID.equals("himan")) {
			System.out.println("등록된 사원이 아닙니다.");
		} else {
			System.out.println("등록된 사원입니다.");
		}
		//sc.close();
		
		System.out.println("=====================");
		
		System.out.print("점수 입력해보세요(1~100): ");
		Scanner sc2 = new Scanner(System.in);
		int inputScore = sc2.nextInt();
		if (inputScore>=90 && inputScore<=100) {
			System.out.println(inputScore+"점은 A등급!");
		} else if (inputScore>=80 && inputScore<90) {
			System.out.println(inputScore+"점은 B등급!");
		} else if (inputScore>=70 && inputScore<80) {
			System.out.println(inputScore+"점은 C등급!");
		}else if (inputScore>=0 && inputScore<70) {
			System.out.println(inputScore+"점은 D등급!");
		} else {
			System.out.println("범위 내의 값을 입력하세요.");
		}
		
		//sc2.close();
		System.out.println("======================");
		
		System.out.print("나이 입력: ");
		Scanner sc3 = new Scanner(System.in);
		int inputAge = sc3.nextInt();
		
		if ( inputAge<5 || inputAge>=65) {
			System.out.println("놀이공원 입장료 5000원");
		} else {
			System.out.println("놀이공원 입장료 백만원~~");
		}
		//sc3.close();
		
		*/
		
		
		System.out.print("1~4 중 정답을 입력하세요: ");
		Scanner sc4 = new Scanner(System.in);
		int input4 = sc4.nextInt();
		if(input4 != 3) {
			System.out.println("오답입니다!");
		} else if (input4 == 3) {
			System.out.println("정답입니다!");
		} else {
			System.out.println("범위 내의 값을 입력하세요.");
		}
		
		System.out.println("========================");
		System.out.print("구매금액 입력: ");
		Scanner sc5 = new Scanner(System.in);
		int input5 = sc5.nextInt();
		if(input5 >=10000 && input5 <=30000) {
			System.out.println("VIP고객입니다!");
		} else if ( input5<10000) {
			System.out.println("일반고객입니다.");
		} else {
			System.out.println("30000원 초과 고객");
		}
		
		System.out.println("========================");
		System.out.print("구매금액 입력: ");
		Scanner sc6 = new Scanner(System.in);
		int input6 = sc6.nextInt();
		if (input6<0 || input6>100) {
			System.out.println("범위를 벗어났습니다.");
		} else {
			System.out.println("정상범위 "+input6+"점");
		}

		
		
		
	}

}
