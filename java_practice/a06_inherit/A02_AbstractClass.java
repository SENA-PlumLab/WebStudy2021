package javaexp.a06_inherit;

public class A02_AbstractClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 추상 클래스는 단독으로 객체생성이 안됨.
		//Vehicle v1 = new Vehicle();
		
		//2.하위클래스 생성은 가능
		Car c1  = new Car();
		c1.drive();
		c1.speedUp();
		
		//3.다형성(상위클래스를 참조로 하위클래스 생성)
		Vehicle v2 = new Trucker();
		v2.drive();
		v2.speedUp();
		
		Worker w1 = new PoliceMan();
		w1.working();
		
		Worker w2 = new FireMan();
		w2.working();
		
	}

}

abstract class Worker {
	abstract void working();
	void goWork() {System.out.println("출근!");}
	void goHome() {System.out.println("퇴근!");}
}

class PoliceMan extends Worker {
	
	void working() {
		System.out.println("치안을 유지하다.");
	}
}
class FireMan extends Worker {
	
	void working() {
		System.out.println("불을 끄다.");
	}
}





abstract class Vehicle{
	void drive() {
		System.out.println("운행하다~!!!");
	}
	
	//추상메소드
	abstract void speedUp();
} // 추상메소드 1개라도 있으면 추상 클래스가 된다.


// !! 추상클래스를 상속받은 하위 클래스는 추상 메소드를 반드시 재정의 해야 함!!
class Car extends Vehicle {
	void speedUp() {
		System.out.println("자동차는 속도가 20km/h씩 증가한다.");
	}
}
class Trucker extends Vehicle{
	void speedUp() {
		System.out.println("트럭은 속도가 10km/h씩 증가한다.");
	}
	
}