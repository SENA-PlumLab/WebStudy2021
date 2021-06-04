package javaexp.a10_collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/*

# 컬렉션 프레임워크의 주요 인터페이스

1. List: 순서를 유지하고 저장, 중복저장 가능
	ArrayList, Vector, LinkedList
2. Set: 순서유지X, 중복저장X
	HashSer, TreeSet
3. Map: 키-값 쌍으로 저장. 키는 중복저장X
	HashMap, Hashtable, TreeMap, Properities
	
	
	
# List
1. 속성
	인덱스로 관리
	중복해서 객체 저장 가능
2. 구현 클래스
	ArrayList
	Vector : 불확실성이 많은 쓰레드에서 보다 안정적으로 데이터 추가삭제 가능
	LinkedList: 인접 참조를 링크해서 체인처럼 관리. 특정 인덱스에서 객체 제거/추가 하면 앞뒤 링크만 변경
				개체 삽입/삭제 빈도가 높을 수록 효율적임.
3. 공통 메서드
	add(객체): 맨 끝에 추가 됨
	add(지정index, 객체): 지정한 index 위치에 추가됨. 기존 객체들은 추가위치 기준 하나씩 밀림.
	set(지정index, 객체): 지정한 index에 객체를 바꿈
	contains(객체): 해당 객체 있는지 여부 리턴
	get(위치index): 해당 index의 객체 리턴
	isEmpty(): boolean타입
	size(): 전체 객체 수 리턴
	clear(): 저장된 모든 객체 삭제
	remove(index): index 위치의 객체 삭제
	remove(객체): 주어진 객체 삭제



 */
public class A03_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = new ArrayList<String>();
		System.out.println("isEmpty: "+list.isEmpty());
		System.out.println("size: "+list.size());
		list.add("사과");
		list.add("바나나");
		list.add("딸기");
		System.out.println("isEmpty: "+list.isEmpty());
		System.out.println("size: "+list.size());
		list.add(1, "오렌지");
		System.out.println(list);
		System.out.println("세번째: "+list.get(2));
		list.set(2, "수박");
		System.out.println(list);
		System.out.println(list.contains("수박"));
		list.clear();
		System.out.println("isEmpty: "+list.isEmpty());
		System.out.println("size: "+list.size());
		
		System.out.println("================");
		
		ArrayList<String> mlist = new ArrayList<String>();
		mlist.add("이동혁");
		mlist.add("박지성");
		System.out.println(mlist);
		mlist.add(0, "이마크");
		System.out.println(mlist);
		mlist.set(1, "이해찬");
		System.out.println(mlist);		
		System.out.println("size: "+mlist.size());
		System.out.println("박지성? "+mlist.contains("박지성"));
		mlist.remove("이마크");
		System.out.println(mlist);
		mlist.clear();
		System.out.println(mlist);
		
		System.out.println("================");

		Vector<Food> f1 = new Vector<Food>();
		f1.add(new Food("마라탕", 15000, 1));
		f1.add(new Food("두부", 2000, 2));
		f1.add(new Food("버섯", 3000, 5));
		for(Food f:f1) {
			System.out.println(f.getName());
		}
		
		
		// List, LinkedList 추가속도 비교
		ArrayList<String> list1 = new ArrayList<String>();
		LinkedList<String> list2 = new LinkedList<String>();
		long startTime=0, endTime =0;
		
		startTime = System.nanoTime();
		for(int cnt=1; cnt<99999; cnt++) {
			list1.add(0,String.valueOf(cnt));
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList 추가입력시간: "+(endTime-startTime)+"ns");
		
		startTime = System.nanoTime();
		for(int cnt=1; cnt<99999; cnt++) {
			list2.add(0,String.valueOf(cnt));
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList 추가입력시간: "+(endTime-startTime)+"ns");
	}

}
