package javaexp.a05_object.vo;

import javaexp.a05_object.Z01_Person;

public class A05_AcessModifier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Z01_Person p01 = new Z01_Person();
		
		//System.out.println(p01.name); //private는 외부 클래스에서 호출해서 사용할 수 없다.
		//System.out.println(p01.address); // package가 서로 달라서 접근 불가
		//System.out.println(p01.inherit); // 상속관계 없고, package도 다름. 접근 물
		System.out.println(p01.announce); //public 믿고있었다구~~
		
		
	}
}
