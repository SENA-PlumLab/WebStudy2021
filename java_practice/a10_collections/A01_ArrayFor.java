package javaexp.a10_collections;

import javaexp.z01_vo.Book;
import javaexp.z01_vo.Food;

/*

# 배열과 foreach 구문
1. 배열은 단위 데이터를 묶어서 모아놓은 데이터이다.
	int nums[] = {10, 15, 20};
2. 객체가 모여서, 배열을 이룰 수 있다.
	Person[] parry = {new Person(),
						new Person(),
						new Person()};
3. 상위 객체를 배열하고, 상속받은 하위 객체를 폴리모피즘에 의해서 할당할 수 있다.
	Flyway[] f1 = {new CountryFly(), new WorldFly(), new SpaceFly()};

4. 배열은 for문을 이용래서 for(단위객체:배열객체)로 효과적으로 처리할 수 있다.
5. index와 .length()를 이용하여, 다양한 배열의 데이터를 가져와서 활용할 수 있다.


 */


public class A01_ArrayFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[] = {3000, 4000, 5000};
		String menus[] = {"사과", "바나나", "딸기"};
		//index는 배열의 길이(.length)보다 작다.
		for(int idx=0; idx<prices.length;idx++) {
			System.out.println(menus[idx]+"\t"+prices[idx]);
		}
		
		
		System.out.println("===============");
		
		String foods[] = {"짜장면", "짬뽕", "커피"};
		String loc[] = {"서울", "경기", "인천"};
		
		for(int idx=0; idx<foods.length; idx++) {
			System.out.println(foods[idx]+"\t"+loc[idx]);
		}
		
		//ctrl shit o
		Food[] foodObjArry = {
				new Food("짜장면", 6000, "동대문"),
				new Food("광어회", 20000, "노량진"),
				new Food("소고기", 30000, "마장동") }; 
		
		for(Food f:foodObjArry) {
			System.out.println(f.getName()+"\t"+f.getPrice()+"\t"+f.getLoc())
			;
		System.out.println("======================");
		
		Book[] BookObjArry = {
				new Book("자바의 우웨엑", 12700, "우아악"),
				new Book("뭐시기의 정석", 140020, "개비쌈"),
				new Book("맛(Hot Souce)", 14900, "드림깅" )	};
		
		for(Book b:BookObjArry) {
			System.out.println(b.getTitle()+"\t"+b.getPrice()+"\t"+b.getAuthor());
		}
		
		
		
		
		}
		
	
	}

}
