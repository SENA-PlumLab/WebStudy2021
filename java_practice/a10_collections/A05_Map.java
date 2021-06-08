package javaexp.a10_collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*

# Map 인터페이스 하위객체
1. key, value 형식의 구조를 가진 collection
2. key 값은 중복 허용 X
3. value는 단일 데이터, 객체/배열도 할당 가능.


 */
public class A05_Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		// Map<String, Integer>: key는 문자열, value는 Integer Wrapper 선언
		map.put("이마크", 23);
		map.put("황런쥔", 23);
		map.put("황런쥔", 22); // "황런쥔" key의 value 값 새로 할당. key 중복 허용하지 않음.
		map.put("이제노", 22);
		map.put("이해찬", 22);
		map.put("박지성", 20);
		
		System.out.println("Map의 크기: "+map.size());
		//map의 key 가져오기..
		Set<String> keyset = map.keySet();
		for(String key:keyset) {
			//맵 객체.get("키")
			System.out.println(key+": "+map.get(key));
		}
		
		//물건명과 가격
		Map<String, Integer> pMap = new HashMap<String, Integer>();
		pMap.put("단호박", 8000);
		pMap.put("수박", 15000);
		pMap.put("체리", 9000);
		pMap.put("파인애플", 12000);
		pMap.put("사과", 5000);

		Set<String> keyset2 = pMap.keySet();
		for(String key:keyset2) {
			System.out.println(key+": "+pMap.get(key));
		}
		
		Map<Integer, Product> pMap2 = new HashMap<Integer, Product>();
		pMap2.put(1000, new Product("사과", 3000, 2));
		pMap2.put(2000, new Product("수박", 15000, 6));
		pMap2.put(3000, new Product("체리", 9000, 4));
	
		Set<Integer> keyset3 = pMap2.keySet();
		
		//Unboxing 처리
		for(int key:keyset3) {
			Product p = pMap2.get(key);
			System.out.println(key+": "+p.getName()+", "+p.getPrice()+"원");
		}
	}

}
