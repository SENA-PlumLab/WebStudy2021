package javaexp.a10_collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*

# 배열 객체의 한계와 collection 객체

1. 배열은 한 번 크기가 설정이 되어 만들어지면 배열의 크기를 동적으로 변경이 불가능하다. (확장/축소)
	새로운 메모리로 배열을 다시 만들어야 하는 단점을 가지고 있다.
	
2. java에서는 이러한 배열형에 대한 동적인 구조를 처리하기위해 
	3가지 형태의 기본적인 데이터처리 구조를 만들어 사용한다.
	
3. Collection 객체 3가지
	1) Set 인터페이스 하위 객체
		순서가 확보되지 못하고 중복을 허용하지 못함.
	2) List 인터페이스 하위 객체
		순서가 index에 의해 확보 되고, 다양한 기능 메소드를 통해서 데이터를 처리하고 있다.
		add(추가)
		add(index, 추가) : 특정 위치 이후에 추가
		set(index, 변경) : 특정 위치에 변경
		get(index): 특정 위치의 데이터 가져오기
		remove(index): 특정 위치의 데이터 삭제
		size() : 해당 list 객체의 크기
	3) Map 인터페이스 하위 객체
		key, value 형식의 데이터를 할당하여 중복되지 않는 key를 기준으로 데이터를 처리할 수 있다.
		put("key", value객체);	--> key, value 값 할당.
		keyset();	--> 전체 중복되지 않는 key를 가져올 수 있다.
		get(key값); 	--> Map 객체에 포함된 key에 해당하는 값을 가져올 수 있다.
	
	
 */


public class A02_Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//	1) Set 인터페이스 하위 객체
		Set set = new HashSet();
		set.add("사과");
		set.add("바나나");
		set.add("바나나");
		set.add("바나나");
		set.add("수박");
		System.out.println("set 구조 확인: "+set);
		System.out.println("순서 확보 X, 중복 X");
		System.out.println("=====================");

		//	2) List 인터페이스 하위 객체
		List list = new ArrayList();
		list.add("오렌지");
		list.add("사과");
		list.add("수박");
		list.add("수박");
		list.add("수박");
		list.add("키위");
		System.out.println("list 구조 확인: "+list);
		System.out.println("순서 확보 O, 중복 O");
		System.out.println("=====================");
		
		list.add(0, "망고");
		list.remove(list.size()-1);
		for (int i=0; i<list.size(); i++) {
			System.out.println((i+1)+":"+list.get(i));
		}
		
		
		
		System.out.println("=====================");

		List Beverage = new ArrayList();
		Beverage.add("웰치스");
		Beverage.add("커피");
		Beverage.add("커피");
		Beverage.add("커피");
		Beverage.add("녹차");
		Beverage.add("우롱차");
		System.out.println("좋아하는 음료: "+ Beverage);
		
		Beverage.add(2, "세번째?");
		System.out.println("수정한 음료: "+ Beverage);
		Beverage.remove(0);
		Beverage.set(3, "네번째");
		System.out.println("수정한 음료: "+ Beverage);

		System.out.println("=====================");
		
		//객체 단위로 데이터 추가 변경
		//ArrayList로 generic하게 Product 객체만 할당할 수 있따.
		List<Product> plist = new ArrayList<Product>();
		//객체 단위로 추가...
		plist.add(new Product("사과", 3000, 2));
		plist.add(new Product("바나나", 2000, 5));
		plist.add(new Product("수박", 8000, 3));
		plist.add(new Product("키위", 6000, 2));
		plist.add(new Product("딸기", 8500, 1));
		
		for(Product pd:plist) {
			System.out.println(pd.getName()+"는 1개에 "+pd.getPrice()+"원이고, "+pd.getCnt()+"개 구매합니다.");
		}
		
		System.out.println("=====================");

		//List<Food> : 리스트 객체에 기본 데이터 유형인 Object에서
		//				특정한 데이터 유형 Food만 구성 요소로 들어 올 수 있게해서 
		//				반복문에서 typecasting 없이 바로 객체를 사용할 수 있게 한다.
		
		List<Food> flist = new ArrayList<Food>();
		//객체 단위로 추가...
		flist.add(new Food("마라탕", 8000, 2));
		flist.add(new Food("밥", 2000, 5));
		flist.add(new Food("반찬", 8000, 3));
		
		for(Food fd:flist) {
			System.out.println(fd.getName()+"는 1개에 "+fd.getPrice()+"원이고, "+fd.getCnt()+"개 구매합니다.");
		}
		System.out.println("=====================");

		
		
		
		// 3) Map 인터페이스 하위 객체
		Map<String, String> map = new Hashtable<String, String>();
		map.put("name", "이제노");
		map.put("age", "22");
		map.put("loc", "청담 사옥");
		System.out.println("Map의 name 값: "+map.get("name"));
		System.out.println("Map의 age 값: "+map.get("age"));
		System.out.println("Map의 loc 값: "+map.get("loc"));
		
		Map<String, String> duct1 = new Hashtable<String, String>();
		duct1.put("name", "정규 앨범");
		duct1.put("price", "16000");
		duct1.put("cnt", "10");
		System.out.println(duct1.get("name")+"을 "+duct1.get("price")+"원에 "+duct1.get("cnt")+"개 샀다.");
	}

}

class Food extends Product{

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Food(String name, int price, int cnt) {
		super(name, price, cnt);
		// TODO Auto-generated constructor stub
	}
	
}


class Product {
	String name;
	int price;
	int cnt;
	public Product(String name, int price, int cnt) {
		super();
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
}
