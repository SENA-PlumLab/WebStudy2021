package javaexp.a00_exp;

import java.util.ArrayList;
import java.util.Scanner;

public class A13_0524 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		// 1.================================
		// 클래스 구성요소: 필드, 생성자, 메소드
		// 클래스는 필드 변수들과 메소드를 담고있으며 접근제어자나 상속관계에 의해 다방면으로 활용가능
		
		// 2.================================
		Record r1 = new Record(20, "택시비");
		Record r2 = new Record(21, "알바비");
		Record r3 = new Record(24, "야식");
		int total=0;
		total += r1.write("지출", 15000);
		total += r2.write("수입", 50000);
		total += r3.write("지출", 30000);
		System.out.println("===== 가계부 기록 =====");
		r1.show();
		r2.show();
		r3.show();
		System.out.println("===== 총계: "+total+"원 =====");

		// 3.================================
		System.out.println("===================================");
		
		Museum m1 = new Museum();
		m1.visit("가나다", 23);
		m1.visit("도레미", 42);
		m1.visit("박박디라라", 16);
		
		// 4.================================
		System.out.println("===================================");
		
		BookStore bst = new BookStore();
		Scanner sc1 = new Scanner(System.in);
		int input = 1, num=0, cnt=0;
		String title = "";
	
		while (input>0 && input <3) {
			System.out.println("===== "+bst.getName()+"입니다. =====");
			System.out.println("1. 책 구매");
			System.out.println("2. 책 추가");
			System.out.println("0. 종료");
			System.out.println("=====================================");
			System.out.print("입력: ");
			input = sc1.nextInt();
			if(input == 1) {
				bst.show();
				System.out.print("구매할 책 번호: ");
				num = sc1.nextInt();
				System.out.print("몇 권 구매하시겠습니까?: ");
				cnt = sc1.nextInt();
				bst.buy(num, cnt);
			} else if (input == 2 ) {
				System.out.print("책 제목 설정: ");
				title = sc1.nextLine();
				title = sc1.nextLine();
				System.out.print("가격 설정: ");
				num = sc1.nextInt();
				System.out.print("재고 설정: ");
				cnt = sc1.nextInt();
				bst.addBook(title, num, cnt);
			}
		}
		
		
		// 5.================================
		System.out.println("===================================");
		Computer cp1 = new Computer("한성컴퓨터", new Cpu("인텔", "i5-7200U 2.5GHz 듀얼코어"),
									new Ram("삼성", "4G"), new Hdd("씨게이트", "1TB"));
		cp1.showInf();
		System.out.println("=== RAM 부품을 추가합니다! ===");
		cp1.add(new Ram("삼성", "8G"));
		cp1.showInf();
		
		
	}

}
// 1.================================
// 2.================================
class Record{
	int day, price;
	String des;
	boolean isIncome = false;
	
	public Record(int day, String des) {
		super();
		this.day = day;
		this.des = des;
	}
	public int write(String kind, int price) {
		
		if(kind.equals("수입")) {
			isIncome = true;
			this.price = price;
		} else if (kind.equals("지출")) {
			isIncome = false;
			this.price = (-1)*(price);
		} else {
			System.out.println("수입 혹은 지출로 입력하세요.");
		}
		
		return this.price;
	}
	public void show() {
		System.out.print(day+"일 가계부: "+des);
		if(isIncome) {
			System.out.println(" +"+price+"원 (수입)");
		} else {
			System.out.println(" "+price+"원 (지출)");
		}
	}
	
}


// 3.================================

class Visitor {
	private String name;
	private int age;
	public Visitor(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

class Museum {
	private Visitor v;
	
	public void visit(String name, int age) {
		v = new Visitor(name, age);
		System.out.println("=== "+v.getName()+"("+v.getAge()+")님이 박물관에 방문했어요. ===");
	}
}


// 4.================================

class Book1 {
	private String title;
	private int price, cnt;
	//private BookStore bst; 
	public Book1(String title, int price, int cnt) {
		super();
		this.title = title;
		this.price = price;
		this.cnt = cnt;
	}
	public String getTitle() {
		return title;
	}
	public int getPrice() {
		return price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	public void minusCnt(int i) {
		this.cnt -= i;
	}
	public void plusCnt(int i) {
		this.cnt += i;
	}
	
}
class BookStore {
	private String name = "박박디라라 서점";
	private ArrayList<Book1> blist = new ArrayList<Book1>();
	public BookStore() {
		blist.add(new Book1("누가 내 머리에 똥 쌌어", 5000, 5));
		blist.add(new Book1("가나다 기차", 7500, 2));
		blist.add(new Book1("로켓", 16000, 4));
	}
	
	public void show() {
		System.out.println("=== "+this.name+" 책 목록 ===");
		// 책 목록 출력 (재고 0권일 시 SOLDOUT 출력)
		for(int i=0; i<blist.size(); i++) {
			System.out.println((i+1)+") "+blist.get(i).getTitle()+"("+blist.get(i).getPrice()+"원, 재고:"
								+( blist.get(i).getCnt() == 0 ? "SOLDOUT": (blist.get(i).getCnt()+"권)") ));
		}
	}
	public void buy(int num, int cnt) {
		if(blist.get(num-1).getCnt() >= num && num != 0) {
			blist.get(num-1).minusCnt(cnt);
			System.out.println(blist.get(num-1).getTitle()+" "+cnt+"권 구매 성공!");
			System.out.println("지불 금액: "+(blist.get(num-1).getPrice()*cnt));
		} else {
			System.out.println("재고를 확인하세요!");
		}
	}
	
	public void addBook (String title, int price, int cnt) {
		blist.add(new Book1(title, price, cnt));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}


// 5.================================
class FormatOfComp{
	private String manufac, spec;

	public FormatOfComp(String manufac, String spec) {
		super();
		this.manufac = manufac;
		this.spec = spec;
	}

	public String getManufac() {
		return manufac;
	}

	public String getSpec() {
		return spec;
	}
}

class Cpu extends FormatOfComp{
	public Cpu(String manufac, String spec) {
		super(manufac, spec);
		// TODO Auto-generated constructor stub
	}
}
class Ram extends FormatOfComp{
	public Ram(String manufac, String spec) {
		super(manufac, spec);
		// TODO Auto-generated constructor stub
	}
}
class Hdd extends FormatOfComp{
	public Hdd(String manufac, String spec) {
		super(manufac, spec);
		// TODO Auto-generated constructor stub
	}
}
class Computer {
	private String manufac;
	private ArrayList<FormatOfComp> clist = new ArrayList<FormatOfComp>();
	
	public Computer(String manufac, Cpu cpu, Ram ram, Hdd hdd) {
		super();
		this.manufac = manufac;
		clist.add(cpu);
		clist.add(ram);
		clist.add(hdd);
	}
	
	public void add(FormatOfComp comp) {
		clist.add(comp);
	}
	
	public void showInf() {
		System.out.println("===== 부품 출력 =====");
		for(int i=0; i<clist.size(); i++) {
			System.out.println((i+1)+") "+clist.get(i).getSpec()+", 제조사: "+clist.get(i).getManufac());
		}
	}
	
	
}


