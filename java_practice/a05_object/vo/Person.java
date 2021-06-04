package javaexp.a05_object.vo;


//하나의 클래스, 객체를 위한 도면과 같은 역할
public class Person {
	
	//클래스에서 사용되는 필드 (구성요소1)
	// 클래스의 특정 속성을 나타낸다.
	public String name;
	public int age;
	public String loc;
	
	//클래스에서는 클래스와 동일한 명칭을 가진 기능 함수가 있는데 이것을 생성자라고 한다. (구성요소2)
	//생성자를 일반적으로 속성(필드)를 초기한다. 그래서 리턴값이 없다.
	//Person p01 = new Person();의 Person()부분을 지칭한다
	public Person(){
		System.out.println("생성자 호출!");
	}
	
	public Person(String name, int age, String loc) {
		//입력 매개변수와 this.필드의 속성으로 구분하여 데이터를 초기화한다.
		//매개변수로 들어오는 데이터는 생성자에서만 사용할 수 있는 지역변수 이다.
		this.name = name;
		this.age = age;
		this.loc = loc;
	}
	
	
	//클래스 내에서 기능을 ㅓ리하는 메소드 (구성요소2)
	String call() {
		System.out.println("기능 메서드 호출...");
		return "문자열리턴";
	}
	
	//main()에서 생성자는 한번만 호출, 메소드는 여러번 호출 가능.
	
	public void show() {
		System.out.println("기능 메소드 호출");
		System.out.println(this.name);
		System.out.println(this.age);
		System.out.println(this.loc);
		
	}
	
	
	

}
