package javaexp.a00_exp;

import javaexp.a05_object.vo.Product2;

public class A14_0525 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1.================================
		// static 클래스 내의 필드에 붙으면, 클래스 공유 변수가 된다.
		// 		동일 클래스로 생성된 여러 객체들이 모두 같은 값을 공유하게 된다.
		// final 클래스 내의 필드에 붙으면, 한번 선언되고 할당된 값에서 변경될 수 없다.
		//		항상 동일한 값을 유지하며 수정될 수 없다.
		// static final 이 붙은 변수는, 처음 선언되고 할당된 값에서 더 이상 수정될 수 없으며,
		//				동일 클래스로 생성된 여러 객체들이 공유하는 변수가 된다.
		EX01 e1 = new EX01("객체1");
		EX01 e2 = new EX01("객체2");
		e1.show();
		e2.show();
		
		
		//final이 없는 일반변수, static변수 새로 정의
		e1.st0 = "일반 변수를 새로 정의했어요!";
		EX01.st1 = "static 변수를 새로 정의했어요! ";
		
		//final이 붙은 변수는 새로운 값 할당에서 에러가 난다.
		//e1.st2 = "final 변수를 새로 정의했어요..?!";
		//e1.st3 = "static final 변수를 새로 정의했어요..?!";
		
		System.out.println();
		e1.show();
		e2.show();
		
		
		// 2.================================
		System.out.println("2.================================");
		
		System.out.println("남은 전력: "+Robot.electricPower_Left);
		Robot r1 = new Robot("로봇청소기", 5);
		Robot r2 = new Robot("AI스피커", 3);
		Robot r3 = new Robot("자동휴지통", 7);
		
		r1.work();		
		r2.work();		
		r3.work();
		r3.work();
		r1.work();
		
		r1.show();
		r2.show();
		r3.show();
		System.out.println("남은 전력: "+Robot.electricPower_Left);
		
		
		// 3.================================
		System.out.println("3.================================");
		//private: 클래스 내에서만 접근 가능.
		//(default): 현재 같은 패키지에 있으면 접근 가능
		//protected: 같은 패키지에 있거나, 상속관계의 외부클래스에서만
		//public: 클래스 내부, 외부 모두 접근 가능
		EX03 ex3 = new EX03();
		
		
		//private는 외부 클래스 main에서 접근할 수 없다.
		//System.out.println(ex3.str1);
		
		//같은 패키지 안에 있으므로 default 변수 접근 가능
		System.out.println(ex3.str2);
		
		//상속관계는 없으나, 같은 패키지에 있으므로 protected 변수 접근 가능
		System.out.println(ex3.str3);
		
		//public 변수는 외부 클래스에서 접근 가능
		System.out.println(ex3.str4);

		
		
	}

}


// 1.================================

class EX01 {
	String name;
	String st0;
	static String st1 = "static 입니다 ^^~";
	final String st2;
	static final String st3 = "static final 변수 입니다 ^^~";
	
	public EX01(String name) {
		super();
		this.name = name;
		st0 = name+"의 일반 변수 입니다 ^^~";
		st2 = name+"의 final 입니다^_^";
	}
	
	public void show() {
		System.out.println("===== "+name+"의 변수들 ======");
		System.out.println("일반변수: "+st0);
		System.out.println("static변수: "+st1);
		System.out.println("final 변수: "+st2);
		System.out.println("static final 변수: "+st3);
	}
}

// 2.================================

class Robot {
	static final String CATEGORY = "기계로봇";
	String kind;
	static int electricPower_Left = 100;
	int neededPower, usedPowerTotal;
	
	public Robot(String kind, int neededPower) {
		super();
		this.kind = kind;
		this.neededPower = neededPower;
		this.usedPowerTotal = 0;
		System.out.println("--- "+kind+"("+CATEGORY+", 소모전력:"+neededPower+")이 등장했습니다. ---");
	}
	public void work() {
		System.out.println(kind+"가 작동하며 전력을 소모합니다.");
		electricPower_Left -= neededPower;
		usedPowerTotal += neededPower;
	}
	public void show() {
		System.out.println("--- "+kind+"의 소모전력 총계:"+usedPowerTotal+" ---");
	}
	
}

//3.================================

class EX03 {
	private String str1 = "private 입니다.";
	String str2 = "default 입니다.";
	protected String str3 = "protected 입니다.";
	public String str4 = "public 입니다.";
	
}