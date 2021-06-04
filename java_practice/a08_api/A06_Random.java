package javaexp.a08_api;

/*

# 랜덤

1. 프로그래밍에서 랜덤으로 수를 퍼리하여, 여러가지 경우에 나타나는 데이터를 처리할 수 있다.
2. 자바에서 기본 Random 처리 api
	1) 0.0 <= Math.random() < 1.0
3. 특정한 범위에 데이터를 처리하기
	0) 공식
		(int)(Math.random()*경우의수 +시작수)
	1) 주사위(1~6)
		0.0 <= Math.random()*6 < 6.0
		1.0 <= (Math.random()*6)+1 < 7.0
		1 <= (int)(Math.random()*6)+1 < 7
 
 */


public class A06_Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		for (int i=1; i<10; i++) {
			System.out.println((int)(Math.random()*6)+1);
		}
		
		int dice1 = (int)(Math.random()*6)+1;
		int dice2 = (int)(Math.random()*6)+1;
		System.out.println("주사위 2개 총합: "+(dice1+dice2));
		
		for (int i=0; i<10; i++) {
			System.out.print(((int)(Math.random()*10)+1)+" ");
		}
	}

}
