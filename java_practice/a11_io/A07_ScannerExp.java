package javaexp.a11_io;

import java.util.Scanner;

public class A07_ScannerExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
