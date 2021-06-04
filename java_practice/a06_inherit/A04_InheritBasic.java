package javaexp.a06_inherit;


/*

# 명시적인 부모 생성자 호출
1) super(매개값)
2) 부모 생성자 없다면 컴파일 오류 발생
3) 반드시 자식 생성자의 첫 줄에 위치.

# 메소드 재정의(override)
1. 부모 클래스의 상속 메소드 수정해 자식 클래스에서 재정의 하는 것.
2. 메소드 재종의 조건
	1) ㅂ모 클래스의 메소드와 동일한 이름으로 사용
	2) 접근제한을 더 강하게 재정의 할 수 없다.
		- 상위 메소드가 public 이면 default나 private 재정의 불가
		- 상위 메소드아 default이면 public으로 재정의 가능
	3) 새로운 예외 throws 불가능
3. 부모 메소드와 구분하여 사용.
	1) 자식 클래스에서 재정의되기 전 부모의 메소드를 호출 할 때,
		super.부ㅜ모메소드() 형식으로 선언.
		
#fianl 키워드
1. 필드: 상수로 사용
2. final 클래스명: 하위 상속클래스 선언 불가
3. final 메소드 : 자식클래스에서 재정의 불가



 */




public class A04_InheritBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SpiderMan sp1 = new SpiderMan("크아악");
		sp1.eat();
		sp1.jump();
		sp1.fireWeb();
		
		Tiger t1 = new Tiger("호랑이");
		t1.run();
		t1.hunt();
		t1.eat();
		
	}

}

class Animal {
	String kind;
	
	
	
	public Animal(String kind) {
		super();
		this.kind = kind;
	}
	public void run() {
		System.out.println(kind+" 달리다!");
	}
	public void eat() {
		System.out.println(kind+" 먹다!");
	}
}

class Tiger extends Animal {
	public Tiger(String kind) {
		super(kind);
		// TODO Auto-generated constructor stub
	}
	public void eat() {
		super.eat();
		System.out.println("토끼 고기를 먹다.");
	}
	public void hunt() {
		System.out.println(kind+" 토끼를 사냥하다!");
	}
}




class Person {
	String name;
	
	public Person(String name) {
		super();
		this.name = name;
	}
	public void eat() {
		System.out.println(name+" 먹다!");
	}
	public void jump() {
		System.out.println(name+" 뛰다!");
	}
}

class SpiderMan extends Person {
	public SpiderMan(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	boolean isSpider;
	public void fireWeb() {
		System.out.println(name+" 거미줄 발사!");
	}
}
