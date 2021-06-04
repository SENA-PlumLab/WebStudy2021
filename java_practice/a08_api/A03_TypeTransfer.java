package javaexp.a08_api;


/*

args 입력 [사과 3000 2]

# 데이터의 변환
1. 숫자형 문자열은 연산이 불가능하다.
	이 때 숫자형으로 변환이 필요하다.
2. 정수/정수 일 때, 자바에서는 정수형의 몫만 가져올 수 있다.
	 소숫점 이하의 숫자로 가져오기 위해서는 형 변환이 필요하다.
3. 숫자형 데이터를 문자열로 변환하여 처리...
	1) 각 Wrapper 클래스(기본 유형을 개체화한 클래스)
		정수형 Integer.toString(25) -> "25"
		실수형 Double.toString(27.35) -> "27.35"
	2) 간략하게
		""+25 = "25"
		""+27.35 = "27.35"          

 */

public class A03_TypeTransfer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String numStr = "25";
		int num01 = 25;
		//System.out.println(numStr+30);
		System.out.println(Integer.parseInt(numStr)+30);
		System.out.println(num01+30);
		System.out.println("--------------------");
		
		String fname = args[0];
		String fprice = args[1];
		String fcnt = args[2];
		
		System.out.println("물건명: "+fname);
		System.out.println("가격: "+fprice);
		System.out.println("갯수: "+fcnt);
		//System.out.println("총계: "+(fprice * fcnt));
		//숫자 형태의 데이터가 아니어서 연산 불가능
		//숫자형 문자열 -> 숫자
		//1. 정수형: Integer.parseInt("정수형 문자열");
		//2. 실수형: Double.parseDouble("실수형 문자열");
		int price = Integer.parseInt(fprice);
		int cnt = Integer.parseInt(fcnt);
		System.out.println("총계: "+(price*cnt));
		
		double dblNum = Double.parseDouble("180.7");
		System.out.println(dblNum+25.25);
		
	}

}
