package javaexp.a00_exp;

import java.util.ArrayList;
import java.util.Scanner;

public class A12_0521 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 1. ====================================
		// 클래스는 선언되어있기만 하고 데이터 할당 되어있지 않음
		// 객체는 이미 정의된 형식으로 실제 데이터가 할당되어있다.
		
		// 2. ====================================
		// default 생성자: 클래스에 따로 정의된 생성자가 없을 때 실행되는 생성자.
		ArrayList<Calcu> clist = new ArrayList<Calcu>();
		for(int i=0; i<4; i++) {
			clist.add(new Calcu((int)(Math.random()*100+1), (int)(Math.random()*100+1)));
			
			System.out.println("== "+clist.get(i).getNum01()+", "+clist.get(i).getNum02()+"의 사칙연산 ==");
			System.out.println("plus:"+clist.get(i).plus()+", minus:"+clist.get(i).minus()
								+", multi:"+clist.get(i).multi()+", div:"+clist.get(i).div());
			
		}
		
		System.out.println("====================================");
		// 3. ====================================
		// 각 클래스의 생성자/메소드는 받는 인자의 종류와 순서를 인식하고 서로 다른 것으로 본다.
		// 생성자 혹은 같은 이름의 메소드를 인자만 다르게 넣는다면 여러번 덧쓸 수 있다.
		Example01 ex1_1 = new Example01(1, 3, 5);
		Example01 ex1_2 = new Example01(1, 3);
		
		ex1_1.say();
		ex1_1.say(10);
	
		System.out.println("====================================");
		// 4. ====================================
		// this()는 클래스 내부를 가리킨다.
		// 생성자에서 parameter로 받은 변수와 클래스 필드를 구분하게 해준다.
		Product p1 = new Product("물건1"); 
		Product p2 = new Product("물건2", 15000); 
		Product p3 = new Product("물건3", 23000, 5); 
		
		
		System.out.println("====================================");
		// 5. ====================================
		Example02 ex2 = new Example02();
		System.out.println("return Int: "+ex2.returnInt());
		System.out.print("return Array: ");
		for(int i=0; i<ex2.returnArry().length; i++) {
			System.out.print(ex2.returnArry()[i]+" ");
		}
		System.out.println();
		System.out.print("return Object: ");
		ex2.returnP1().show();
		
		System.out.println("====================================");
		// 6. ====================================
		Example03 ex03 = new Example03();
		ex03.sayInt(105);
		ex03.sayString("안녕하세요");
		
		System.out.println("====================================");
		// 7. ====================================
		OnLimeLibrary lb1 = new OnLimeLibrary();
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("==== 로그인 하세요 ====");
		System.out.print("ID: ");
		String id = sc1.nextLine();
		System.out.print("pass: ");
		int pass = sc1.nextInt();
		
		lb1.login(new Member(id, pass));
		if(lb1.getIsLoggedIn()) {
			System.out.print("빌릴 책 이름: ");
			String name = sc1.nextLine();
			name = sc1.nextLine();
			lb1.Rent(new Book(name, 14));
		}
		
		System.out.println("====================================");
		// 8. ====================================
		
		MathExp me1 = new MathExp();
		System.out.print("구구단 단수 입력(1~10): ");
		me1.gugu(sc1.nextInt());
		System.out.print("1부터 합산할 수 입력: ");
		me1.totAll(sc1.nextInt());
		System.out.print("주사위 수 입력(1~6): ");
		me1.CoMave1(sc1.nextInt());
		
		
	}//메인 끝

}


//========= 클래스 ==========================


// 1. ====================================

// 2. ====================================

class Calcu {
	private int num01, num02;

	public Calcu(int num01, int num02) {
		super();
		this.num01 = num01;
		this.num02 = num02;
	}
	
	public int getNum01() {		return num01;	}
	public int getNum02() {		return num02;	}

	public int plus() {		return num01+num02;	}
	public int minus() {		return num01-num02;	}
	public int multi() {		return num01*num02;	}
	public int div() {		return num01/num02;	}	
}

// 3. ====================================
class Example01 {
	
	int num01, num02, num03;

	public Example01(int num01, int num02, int num03) {
		super();
		this.num01 = num01;
		this.num02 = num02;
		this.num03 = num03;
		System.out.println(num01+", "+num02+", "+num03+"으로 생성자 호출!");
	}

	public Example01(int num01, int num02) {
		super();
		this.num01 = num01;
		this.num02 = num02;
		System.out.println(num01+", "+num02+"으로 생성자 호출!");

	}
	
	public void say() {
		System.out.println("parameter가 없는 say() 호출!");
	}
	public void say(int i) {
		System.out.println(i+"값을 parameter로 받은 say() 호출!");
	}	
}


//4. ====================================
class Product {
	String name;
	int price, cnt;
	public Product(String name) {
		super();
		this.name = name;
		System.out.println("생성자 호출!: "+name);
	}
	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
		System.out.println("생성자 호출!: "+name+", "+price+"원");

	}
	public Product(String name, int price, int cnt) {
		super();
		this.name = name;
		this.price = price;
		this.cnt = cnt;
		System.out.println("생성자 호출!: "+name+", "+price+"원, "+cnt+"개");
	}
	public void show() {
		System.out.println("Product 출력: "+name+", "+price+"원, "+cnt+"개");
	}
}

//5. ====================================
class Example02 {
	int num01 = 5;
	int[] intArry = {1, 3, 5, 7, 11, 13};
	Product p1 = new Product("마라탕", 13000, 5);
	
	public int returnInt() {
		return num01;
	}
	public int[] returnArry() {
		return intArry;
	}
	public Product returnP1() {
		return p1;
	}
}

//6. ====================================
class Example03 {
	public void sayInt(int num01) {
		System.out.println("== 입력한 Int 값: "+num01+" ==");
	}
	public void sayString(String str) {
		System.out.println("== 입력한 String 값: "+str+" ==");
	}
}


//7. ====================================
class Member {
	String id; 
	int pass;
	public Member(String id, int pass) {
		super();
		this.id = id;
		this.pass = pass;
	}
	public String getId() {
		return id;
	}
	public int getPass() {
		return pass;
	}
}

class Book {
	String name;
	int limit;
	public Book(String name,int limit) {
		super();
		this.name = name;
		this.limit = limit;
	}
	public String getName() {
		return name;
	}
	public int getLimit() {
		return limit;
	}	
}

class OnLimeLibrary {
	Member m;
	boolean isLoggedIn = false;
	public void login(Member m) {
		this.m = m;
		if(m.getId().equals("goodMan") && m.getPass()==7777 ) {
			System.out.println("=== 로그인 성공! ===");
			System.out.println(m.getId()+"님 환영합니다.");
			isLoggedIn = true;
		} else {
			System.out.println("=== 로그인 실패!! ===");
		}
	}
	public void Rent(Book b) {
		if(isLoggedIn) {
			System.out.println("=== "+m.getId()+"님 도서 대출 ====");
			System.out.println("반납 기한: "+b.getLimit()+"일");
			System.out.println("도서명: "+b.getName());
		}
	}
	public boolean getIsLoggedIn() {	return isLoggedIn; }
}

//8. ====================================

class MathExp{
	public void gugu(int dan) {
		if(dan>0 && dan<10) {
			
			for(int i=1; i<=9; i++) {
				for(int j=1; j<=dan; j++) {
					System.out.print(j+"x"+i+"="+(i*j)+"\t");
				}
				System.out.println();
			}
		} else {
			System.out.println("1~10 값을 입력하세요.");
		}	
	}
	
	public void totAll(int def) {
		int total=0;
		for(int i=1; i<=def; i++) {
			total += i;
		}
		System.out.println("1부터 "+def+"까지의 총 합: "+total);
	}
	
	public void CoMave1(int input) {
		if(input>0 && input<7) {
			int enemy = (int)(Math.random()*6+1);
			System.out.println("=== user:"+input+", enemy:"+enemy+" ===");
			if(enemy>input) {
				System.out.println ("== enemy 승리!! ==");
			} else if (enemy<input) {
				System.out.println ("== user 승리!! ==");
			} else {
				System.out.println ("== 무승부!! ==");
			}
		} else {
			System.out.println("1~6 값을 입력하세요.");
		}
	}
}
