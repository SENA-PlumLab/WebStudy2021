package javaexp.a08_api;

import java.util.ArrayList;

/*

# Wrapper 객체
1. 기본타입(byte, char, short, int, long, 
		float, double, boolean)값을 내부에 두고 포장하는 객체
	객체로 전환되는 순간 여러가지 기능 메소드가 지원되므로 데이터 변환이나 기능처리를 할 수 있다.		
2. 포장 클래스
	대부분 대분자로 시작하여 처리하는 객체
	char ==> Character
	int ==>Integer
3. 박싱(Boxing) 언박싱(Unboxing)
	1) 박싱: 기본타입의 값을 포장 객체로 만드는 과정
	2) 언박싱: 포장 객체에서 기본타입의 값을 얻는 과정
	

 */
public class A13_Wrapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//생성자를 통해 박싱처리
		//1) 기본타입을 생성자에 할당
		//2) 문자열형 기본타입을 생성자에 할당
						//deplicated: 사용자제권고
		int i01 = new Integer("10");
		System.out.println(i01);
		
		
		//main함수 args에 정수, 실수 받아서 출력
		// ==> 우클릭 - run as - run configurations 에서 값 입력
		Integer obj09 = new Integer(args[0]);
		Integer obj10 = Integer.parseInt(args[1]);
		Double obj11 = Double.parseDouble(args[2]);
		
		System.out.println("obj09: "+obj09);
		System.out.println("obj10: "+obj10);
		System.out.println("obj11: "+obj11);
		
		
		
		//Autoboxing
		ArrayList<String> slist = new ArrayList<String>();
		ArrayList<Integer> ilist = new ArrayList<Integer>();
		ArrayList<Double> dlist = new ArrayList<Double>();
		slist.add(new String("이마크"));
		slist.add(new String("나재민"));
		slist.add(new String("박지성"));
		ilist.add(new Integer(23));
		ilist.add(new Integer(22));
		ilist.add(new Integer(20));
		dlist.add(new Double("12.7"));
		dlist.add(new Double("8.2"));
		dlist.add(new Double("2.5"));
		
		for(int i=0; i<slist.size(); i++) {
			System.out.println(slist.get(i)+"("+ilist.get(i)+"): "+dlist.get(i));
		}
	}

}
