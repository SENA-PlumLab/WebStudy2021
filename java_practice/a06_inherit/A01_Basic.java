package javaexp.a06_inherit;

public class A01_Basic {

	
	/*

# 상속은 java 프로그래밍의 핵심이라고 할 수 있다.
1. 객체를 재활용하고 유지보수할 때 다른 소스에 영향이 없으면서
	확장성이 있는 프로그래밍 (응집성 있는 프로그래밍)을 할 때, 반드시 알아야 하는 지식이다.
2. 상속 기본 프로그래밍
	1) 상위 클래스
		class Father{
			String shape = "동글";
			void dancing(){
				System.out.println("날쌔게 춤 춘다!");
			}
		}
		class Son extends Father{
		
		1.외부에서 사용하는 경우 
			Son s1 = new Son();
			s1.running();
		2.내부 구성요소로 호출하는 경우
			System.out.println("모습은 "+shape);
		}
3. 상속의 종류
	1) 상위실제클래스 vs 하위실제클래스 상속
	2) 상위추상클래스 vs 하위실제클래스 상속
	3) 상위인터페이스 vs 하위실제클래스 상속
	
4. 추상클래스
	1) 오버라이딩: 하위에서 상위 메소드 재정의 처리,
		overriding (재정의)
		polymorphism (다형성)
	2) 상속 관계에서 상위에 body({}) 없는 메소드를 정의하면,
		이 메소드는 abstract 붙은 추상 메소드가 된다.
		추상 메소드가 하나라도 있는 클래스는 추상 클래스로 선언이 된다!
	3) 추상 클래스는 단독으로 객체 생성을 하지 못한다.
	


final 필드는 수정 불가능한 변수.
final 클래스는 부모가 될 수 없다. final이 상속이 불가능하게 함.

	 */
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Son s1 = new Son();
		s1.dancing();
		s1.gogo();
		
		System.out.println("---------------");
		
		Daughter d1 = new Daughter();
		d1.baking();
		d1.teaTime();
		System.out.println(d1.mother+", "+d1.daughter);

	}

}


class Mother {
	String mother = "소싯적 오타쿠";
	void baking() {
		System.out.println("스콘 구워서 티타임^^");
	}
}
class Daughter extends Mother{
	String daughter = "지금 굉장한 오타쿠";
	void teaTime() {
		System.out.println("찻잎을 모아서 매일 티타임");
	}
	
	
}


class Father{
	String shape = "동글";
	void dancing(){
		System.out.println("날쌔게 춤 춘다!");
	}
}

class Son extends Father{
	String height = "키가 크다";
	void gogo() {
		System.out.println("모습은 "+shape);
	}
}