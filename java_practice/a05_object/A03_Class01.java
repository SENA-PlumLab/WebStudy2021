package javaexp.a05_object;

import javaexp.a05_object.vo.Book;
import javaexp.a05_object.vo.Person;
import javaexp.a05_object.vo.Product;

public class A03_Class01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//클래스가 객체로 만들어지는 순간입니다리..
		
		// 1. main(String[] args) 메소드 안에서 실행 코드를 입력했을 때.
		// 2. 객체의 선언 방식
		// 		클래스명 참조변수 = new 생성
		//		참조변수 안에는 heap영역의 주소값으로 stack에 할당
		//		new 생성자() heap 영역에서 객체 생성
		// 3. 컴파일을 통해 .class가 만들어지고
		// 4. 실행을 통해 객체가 메모리에 로딩되어 수행된다.
		
		Person p01 = new Person();
		// ctrl + shift + o (외부 패키지 클래스 가져오기)
		
		Product duct01 = new Product();
		duct01.name = "알알알";
		duct01.price = 300;
		duct01.num = 5;
		System.out.println("Product 객체의 필드 name 값:"+duct01.name);
		System.out.println("Product 객체의 필드 price 값:"+duct01.price);
		System.out.println("Product 객체의 필드 num 값:"+duct01.num);
		duct01.calling();
		/*
		Product duct02 = new Product();
		
		Product pro03 = new Product("버블구독", 3800, 5);
		System.out.println(pro03.name+", "+pro03.price+"원, "+pro03.num+"개 구매");
		*/
		Book book01 = new Book("핫소스", "도리무", 14800);
		System.out.println(book01.title+", "+book01.author+", "+book01.price);
		Person p03 = new Person("런진이", 22, "중국 길림성");
		System.out.println(p03.name+", "+p03.age+", "+p03.loc);
		p03.show();
		p03.show();
		
		Product duct02 = new Product("아메리카노", 2500, 2);
		Product duct03 = new Product("수박주스", 3000, 7);
		
		duct01.buy();
		duct02.buy();
		duct03.buy();
		
		
	}

}
