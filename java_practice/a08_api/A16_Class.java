package javaexp.a08_api;

import javaexp.z01_vo.Book;
import javaexp.z01_vo.Food;
import javaexp.z01_vo.Product;

/*

# Class

1. 클래스와 인터페이스의 메타 데이터 관리
	메타데이터: 
	1) getName()
	2) getSimpleName()
	3) getPackage().getName()
	
2. Class의 객체 얻기
	1) getClass()
	2) Class.forName("문자열클래스정보")
	
3. .Class를 통한 객체 생성
	.newInstance()


 */
public class A16_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class c1 = Class.forName("javaexp.z01_vo.Book");
			System.out.println(c1.getName());
			System.out.println(c1.getSimpleName());
			System.out.println(c1.getPackage().getName());
			Book b1 = (Book) c1.newInstance(); //Object 타입이므로 타입캐스팅 필요.
			b1.setTitle("자바기초");
			System.out.println(b1.getTitle());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		try {
			Product p1 = new Product("콜라", 1500, 2);
			Class c2 = p1.getClass();
			System.out.println(c2.getName());
			
			Class c3 = Class.forName("javaexp.z01_vo.Food");
			System.out.println(c3.getName());
			
			Food f1 = (Food) c3.newInstance();
			f1.setName("사이다");
			System.out.println(f1.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
