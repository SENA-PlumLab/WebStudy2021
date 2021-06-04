package javaexp.a08_api;


/*

# 숫자형에서 데이터 변환 처리

1. 숫자형은 종류와 크기에 따라서
	byte, short, int, long (정수형)
	float, double(실수형)
2. 해당 데이터는 작은 데이터에서 큰 데이터 타입으로 할당하는 것을 promote 라고 한다.
	데이터 유실이 없다.	ex) byte -> int, int -> double
	큰 데이터 타입이 작은 데이터 타입으로 할당하면 유실이 발생한다.
	-> 이 때, 명시적으로 작은 데이터형에 맞게 타입을 정해서 할당할 수 있는데
		이 것을 casting이라 한다. 

 */



//입력: 65 72 55.4 80.32

public class A05_TypeCasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		byte num01 = 25;
		int num02 = num01;
		double num03 = num02;
		System.out.println(num02);
		System.out.println(num03);
		System.out.println("=============");
		double num04 = 25.343;
		// int num05 = num04;  double -> int 할당 에러.
		int num05 = (int)num04; // int형으로 casting 하면 에러 X
		System.out.println(num04);
		System.out.println(num05);
		System.out.println("===================");
		
		int num06 = 25;
		int num07 = 5;
		System.out.println("정수형/정수형: "+(num06/num07));
		System.out.println("정수형/실수형: "+(num06/(double)num07));
		System.out.println("=================");
		
		//입력: 65 72 55.4 80.32
		int weight01 = Integer.parseInt(args[0]);
		int weight02 = Integer.parseInt(args[1]);
		double weight03 = Double.parseDouble(args[2]);
		double weight04 = Double.parseDouble(args[3]);
		
		System.out.println("정수형의 평균: "+(weight01+weight02)/2);
		System.out.println("실수형의 평균: "+(weight03+weight04)/2);
		
	}

}
