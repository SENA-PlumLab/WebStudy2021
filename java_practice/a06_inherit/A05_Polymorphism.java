package javaexp.a06_inherit;

import java.util.ArrayList;

/*

# 다형성
1. 같은 부모로 여러 형태의 하위 클래스를 선언하는 것을 말한다.
2. 부모 타입에는 모든 자식 객체가 대입 가능하다.
3. 자동 타입 변환(promote)
	부모클래스 변수 = 자식 객체 생성자;



 */
public class A05_Polymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Robot r1 = new Mzz();
		r1.attack();
		
		ArrayList<Robot> rlist = new ArrayList<Robot>();
		rlist.add(r1);
		rlist.add(new Tv());
		rlist.add(new Degan());
		
		for(Robot r:rlist) {
			r.attack();
			r.defend();
			r.fly();
		}
	}

}


abstract class Robot{
	abstract public void attack();
	abstract public void defend();
	public void fly() {
		System.out.println("날아요~");
	}
	
}

class Mzz extends Robot {
	
	public void attack() {
		System.out.println("Mz 어택!");
	}

	public void defend() {
		System.out.println("Mz 방어!");
	}
}
class Tv extends Robot {
	public void attack() {
		System.out.println("Tv 어택!");
	}
	public void defend() {
		System.out.println("Tv 방어!");
	}
}
class Degan extends Robot {
	public void attack() {
		System.out.println("Degan 어택!");
	}
	public void defend() {
		System.out.println("Degan 방어!");
	}
}

