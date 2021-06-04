package javaexp.a13_lambda;

public class A02_LambdaExp {
	
	static void flyFunction(Flyway f1) {
		f1.fly();
	}
	
	static void swimFunction(SwimmingWay s1) {
		s1.swim();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//1. 인터페이스를 상위로, 실제 객체 만들기
		Flyway f1 = new Flyway() {
			@Override
			public void fly() {
				// TODO Auto-generated method stub
				System.out.println("난다~");
			}
		};
		
		f1.fly();
		flyFunction(new Flyway() {
			@Override
			public void fly() {
				// TODO Auto-generated method stub
				System.out.println("세계의 창공을 누비다! (함수)");
			}
		});
		
		//람다식 표현 1단계
		//오버라이딩 된 메소드를 바로 재정의. () -> { 처리내용 }
		flyFunction( () -> {
			System.out.println("우주를 누비다(람다식1)");
		});
		
		//람다식 표현 2단계
		flyFunction( () ->
				System.out.println("넓은 바다 위를 나르다. (람다식2)"));
		
		
		//=====================================
		
		SwimmingWay s1 = new SwimmingWay() {
			@Override
			public void swim() {
				// TODO Auto-generated method stub
				System.out.println("호우에서 수영합니다! ");
			}
		};
		
		s1.swim();
		
		swimFunction(new SwimmingWay() {
			
			@Override
			public void swim() {
				// TODO Auto-generated method stub
				System.out.println("수영을..할까 (객체 생성)");
			}
		});
		
		swimFunction( () -> {
			System.out.println("수영합니당 (람다식1)");
		}	);
		
		swimFunction( () ->
			System.out.println("수영합니다당 (람다식2)")	);
		
		
		
		
		
		
	}


}

interface SwimmingWay{
	void swim();
}

// 인터페이스 선언
interface Flyway{
	void fly();
}
