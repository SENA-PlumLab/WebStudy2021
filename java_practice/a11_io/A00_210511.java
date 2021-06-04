package javaexp.a11_io;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class A00_210511 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 1. -----------------------------
		Worker[] worker = { new PoliceMan(), new FireMan(), new Programmer()};
		for(Worker wk:worker ) {
			wk.hi();
			wk.working();
			wk.bye();
		}
		
		System.out.println("=====================");
		// 2. -----------------------------
		/*
		 * Collection 하위 객체 3가지
		 * Set, List, Map
		 * Set: 중복X, 순서저장X
		 * List: 중복O, 순서저장O, index로 순서 지정 가능, 데이터 추가/변경/삭제 가능
		 * Map: 데이터를 key값과 함께 저장. key 값으로 일치하는 데이터를 추출할 수 있다.
		 */
		
		// 3. -----------------------------

		Set set = new HashSet();
		set.add(new Fruit("오렌지", "주황"));
		set.add(new Fruit("자몽", "빨강"));
		set.add(new Fruit("바나나", "노랑"));
		set.add(new Fruit("오렌지", "주황"));
		System.out.println("-set 입력 내용-");
		Iterator it = set.iterator();
		while(it.hasNext()) {
			Fruit f = (Fruit) it.next();
			System.out.println(f.getName()+"은 "+f.getColor()+"색이다.");
		}
		
		
		System.out.println("=====================");
		// 4. -----------------------------
		
		List std = new ArrayList<Student>(); //이름, 국, 영, 수
		std.add(new Student("이제노", 20, 30, 40));
		std.add(new Student("황런쥔", 40, 80, 20));
		std.add(new Student("나재민", 35, 51, 85));
		std.add(new Student("이동혁", 86, 63, 19));
		
		it = null;
		it = std.iterator();
		while(it.hasNext()) {
			Student s = (Student) it.next();
			System.out.println(s.getName()+": 국어 "+s.getKor()+"점, 영어 "+s.getEng()+"점, 수학 "+s.getMath()+"점.");
		}
		
		System.out.println("=====================");
		// 5. -----------------------------
		/*
		 * Map 하위 기능 메소드
		 * put("key", value객체) : 값 입력
		 * keyset(): 전체에 중복되지 않는 key를 가져올 수 있다.
		 * get(key값): key값에 해당되는 데이터를 가져온다.
		 * 
		 */
		
		// 6. -----------------------------
		/*
		 * InputStream 기본 형식과 메소드
		 * 
		 * Console에서 데이터를 입력받는 객체이다.
		 * 
		 * InputStream 변수명 = null;
		 * 변수명 = System.in;
		 * 
		 * 변수명.read(); // 1byte 읽어오기
		 * 
		 * 메소드 사용 시 예외 처리가 필요할 수 있다.
		 * Stream 사용 후에는 .close(); 메소드로 해제해야 한다.
		 * 
		 */
		
		// 7. -----------------------------

		
		String pass="";
		for (int i=0; i<7; i++) {
			switch ((int)(Math.random()*3+1)) {
			case 1: //숫자
				pass += (char)(int)(Math.random()*10+48);
				break;
			case 2: //대문자
				pass += (char)(int)(Math.random()*26+65);
				break;
			case 3: //소문자
				pass += (char)(int)(Math.random()*65+97);
				break;
			}
		}
		System.out.println("임시 비밀번호: "+pass);
		
		System.out.println("=====================");
		// 8. -----------------------------
		
		Player[] player = {new Player(), new Player(), new Player()};
		for(int i=0; i<player.length; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.print("선수 이름: ");
			player[i].setName(sc.nextLine());
			System.out.print("성적: ");
			player[i].setScore(sc.nextInt());
			//sc.close();
		}
		for (Player p : player) {
			System.out.println(p.getName()+": "+p.getScore()+"점");
		}
		System.out.println();
		
	}

}

class Player {
	String name;
	int score;
	public Player(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public Player() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}

class Student{
	String name;
	int kor, eng, math;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public Student(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	
}

class Fruit {
	String name, color;

	public Fruit(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}



abstract class Worker {
	void hi() {
		System.out.println("-출근했습니다!-");
	}
	void bye() {
		System.out.println("-퇴근했습니다!-");
	}
	abstract void working();
}

class PoliceMan extends Worker {
	@Override
	void working() {
		// TODO Auto-generated method stub
		System.out.println("경찰 업무...");
	}
}

class FireMan extends Worker {
	@Override
	void working() {
		// TODO Auto-generated method stub
		System.out.println("소방 업무...");
	}
}

class Programmer extends Worker {
	@Override
	void working() {
		// TODO Auto-generated method stub
		System.out.println("프로그래밍 업무...");
	}
}