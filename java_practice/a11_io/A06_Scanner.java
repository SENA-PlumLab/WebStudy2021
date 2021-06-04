package javaexp.a11_io;

import java.util.Scanner;

/*

# 간단한 데이터 입력을 처리하는 Scanner 객체

!! 이 객체는 IO Stream이 아님 !! 주의..


1. 데이터를 입력하여 처리해주는 util 패키지 하위 객체 활용..
	new Scanner(InputStream 객체)
	1) 기능 메소드
		next(): 공백 전까지 문자열 입력
		nextLine(): enter 입력까지 문자열 입력
		nextInt(): 정수형 데이터 입력


 */
public class A06_Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="";
		int score=0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==성적 등록==");
		System.out.print("이름: ");
		name = sc.nextLine();
		System.out.print("점수: ");
		score = sc.nextInt();
		
		if(score>= 70) {
			System.out.println(name+" 님은 합격입니다!");
			System.out.println("원점수: "+score);
		} else {
			System.out.println(name+" 님은 불합격입니다!");
			System.out.println("원점수: "+score);
		}
		
		//=================================
		System.out.println("==============================");
		
		Scanner sc2 = new Scanner(System.in);
		String pdName="";
		int price=0, cnt=0;
		System.out.println("==구매할 물건 등록==");
		System.out.print("물건명: ");
		pdName=sc2.nextLine();
		System.out.print("가격: ");
		price=sc2.nextInt();
		System.out.print("갯수: ");
		cnt=sc2.nextInt();
		
		System.out.println("구매내역: "+pdName+"을 "+price+"원에 "+cnt+"개 구매!");
		System.out.println("총계: "+(price*cnt)+"원!");

	}

}
