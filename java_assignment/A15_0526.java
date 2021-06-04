package javaexp.a00_exp;

public class A15_0526 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// 1.-------------------------------------
		// toString()은 객체의 값들을 문자열로 return 하는 메소드이다.
		// super.toString() -> 객체가 선언된 후 Stack 영역에서 가지고있는 'Heap데이터 주소값'을 출력한다. 
		
		EX001 e1 = new EX001();
		System.out.println(e1.toString());
		System.out.println("-------------------");

		
		// 2.-------------------------------------
		// super는 상속받은 상위 클래스의 것들에 접근할 수 있게 만드는 키워드이다.
		// super.메소드명(), super.필드명
		// 상위 클래스에서 생성자가 지정되어있을 경우에는 
		// 하위클래스의 생성자에서 가장 첫 줄에 super(변수)를 통해 상위 클래스 생성자를 호출해주어야한다.
		EX002_B e2 = new EX002_B("식물나라");
		e2.say();
		System.out.println("-------------------");

		
		// 3.-------------------------------------
		
		PoliceMan police = new PoliceMan(); //Worker를 상속받음
		police.goWork();
		police.working();
		System.out.println("-------------------");
		FireMan fire = new FireMan();  //Worker를 상속받음
		fire.goWork();
		fire.working();
		System.out.println("-------------------");
		Programmer prog = new Programmer(police, fire); //Worker를 상속받고, PoliceMan, FireMan 객체를 내부필드 선언함.
		prog.goWork();
		prog.working();
		System.out.println("-------------------");
		prog.goHome();
		fire.goHome();
		police.goHome();
		
		// 4.-------------------------------------
		
		/*
		 * 1. Oracle xe 11g를 설치한다. 중간 비밀번호 설정은 1111로 기억하기 쉽게 설정.
		 * 2. Eclipse의 Marketplace에서 DBeaver 21.0.5를 설치한다.
		 * 3. C:\oraclexe\app\oracle\product\11.2.0\server\rdbms\admin 에서
				scott.sql 복사해서
				C:\Users\(계정이름) 에 붙여넣기.
				TIGER로 쓰여진 것을 tiger로 수정하고 저장한다. (총 2곳)
		 * 4. C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib 에서
				ojdbc6.jar 복사
				(프로젝트 폴더)\src\main\webapp\WEB-INF\lib에 붙여넣기
		 * 5. perspective를 DBeaver로 설정한 뒤, Connect to a Database 클릭.
		 		1) Database: xe,
		 			Username: scott,
		 			Password: tiger,
		 			edit driver - Database:xe, user:scott 
		 		2) Libraries 탭 - 기본내역 전부 삭제 후, C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6.jar 추가
		 			이후, Driver class에서 Find Class 버튼 누른 후 
		 			oracle.jdbc.driver.OracleDriver 설정.
		 		3) 위 순서 완료한 뒤 Test Connection으로 연결 여부 확인.
		 		
		 * 
		 */
		
		
		
	}

}

// 1.-------------------------------------

class EX001 {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}


// 2.-------------------------------------

class EX002_A {
	String name;

	public EX002_A(String name) {
		super();
		this.name = name;
		System.out.println("EX002_A의 생성자 호출... name = "+name);
	}
	public void say() {
		System.out.println("EX002_A: "+name+"의 발언 시간");
	}
}

class EX002_B extends EX002_A {
	
	public EX002_B(String name) {
		// TODO Auto-generated constructor stub
		super(name);
		System.out.println("EX002_B의 생성자 호출...");
	}
	public void say() {
		super.say();
		System.out.println("EX002_B: "+super.name+"의 발언 끝!");
	}
}

// 3.-------------------------------------

abstract class Worker {
	private String name;
	
	public Worker(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void goWork() {
		System.out.println(name+" 출근합니다.");
	}
	public void goHome() {
		System.out.println(name+" 퇴근합니다.");
	}
	abstract public void working();
}

class FireMan extends Worker{
	
	public FireMan() {
		// TODO Auto-generated constructor stub
		super("소방대원");
	}
		
	@Override
	public void working() {
		// TODO Auto-generated method stub
		System.out.println(super.getName()+"이 현장에서 열심히 근무합니다.");
	}
}

class PoliceMan extends Worker{
	public PoliceMan() {
		// TODO Auto-generated constructor stub
		super("경찰");
	}
		
	@Override
	public void working() {
		// TODO Auto-generated method stub
		System.out.println(super.getName()+"이 경찰서에서 열심히 근무합니다.");
	}
}
class Programmer extends Worker{
	
	PoliceMan police;
	FireMan firefighter;

	public Programmer(PoliceMan p, FireMan f) {
		// TODO Auto-generated constructor stub
		super("프로그래머");
		police = p;
		firefighter = f;
	}
	@Override
	public void goWork() {
		// TODO Auto-generated method stub
		super.goWork();
		System.out.println(police.getName()+" "+firefighter.getName()+" 프로그래머의 사무실에 방문합니다. ");
	}
		
	@Override
	public void working() {
		// TODO Auto-generated method stub
		System.out.println(police.getName()+" "+firefighter.getName()
							+" "+super.getName()+"가 열심히 근무합니다.");
		
	}
	
	@Override
	public void goHome() {
		// TODO Auto-generated method stub
		super.goHome();
		System.out.println(police.getName()+" "+firefighter.getName()+" 일터로 돌아갑니다. ");
	}
}

