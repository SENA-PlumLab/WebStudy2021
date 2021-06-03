/*
package javaexp.a00_exp;


public class A08_0512 {

	
	public static void weaponAttack (Weapon w1) {
		w1.attack();
	}
	
	public static void main(String[] args) {
		
		// 1.==============================
		
		//	1) extends Thread
		C01 c1 = new C01();
		c1.start();
		
		// 	2) implements Runnable
		C02 c2 = new C02();
		Thread t1 = new Thread(c2);
		t1.start();
		
		System.out.println("==========================");
		// 2.==============================
		
		ShoppingBuyer sb1 = new ShoppingBuyer("구매자1", "장난감", 5000, 15);
		ShoppingBuyer sb2 = new ShoppingBuyer("구매자2", "활", 3000, 10);
		ShoppingBuyer sb3 = new ShoppingBuyer("구매자3", "거울", 500, 20);
		
		sb1.start();
		sb2.start();
		sb3.start();
		
		System.out.println("==========================");
		// 3.==============================
		
		
		 * getName(), setName()
		 * getPriority(), setPriority()
		 * 
		 * Thread.MIN_PRIORITY : 최하위 우선순위
		 * Thread.NORM_PRIORITY: 중간 우선순위
		 * Thread.MAX_PRIORITY : 최고위 우선순위

		// 4.==============================
		
		String[] mv1 = {"영화", "드라마", "DVD", "블루레이", "비디오테입"};
		SeeingMovie sm1 = new SeeingMovie(mv1);
		Thread t2 = new Thread(sm1);
		t2.start();
		
		System.out.println("==========================");
		// 5.==============================
		
		
		Weapon w1 = new Weapon() {
			@Override
			public void attack() {
				// TODO Auto-generated method stub
				System.out.println("Attack  (1) 익명객체 생성");
			}
		};
		w1.attack();
		
		weaponAttack(new Weapon() {
			@Override
			public void attack() {
				// TODO Auto-generated method stub
				System.out.println("Attack  (2) 함수 선언 할당");
			}
		});
		
		weaponAttack( () -> {
			System.out.println("Attack  (3) 람다식1 선언 호출");
		});
		
		weaponAttack( () -> 
			System.out.println("Attack  (4) 람다식2 선언 호출")
		);
		
		
	}
	

	
}


class C01 extends Thread {
	
	public void run() {
		for(int i=0; i<10; i++)
		System.out.println(i+") extends Thread");
	}
}

class C02 implements Runnable{
	
	public void run() {
		for(int i=0; i<10; i++) {
		System.out.println(i+") implements Runnable");
		}
	}
}

class ShoppingBuyer extends Thread {
	private String buyer;
	private String product;
	private int price, cnt;
	
	public ShoppingBuyer(String buyer, String product, int price, int cnt) {
		super();
		this.buyer = buyer;
		this.product = product;
		this.price = price;
		this.cnt = cnt;
	}
	
	public void run() {
		for(int i=1; i<=cnt; i++) {
			System.out.println(buyer+"에게서 "+product+"을 "+price+"원에 구매! (총 구매량: "+i+")");
		}
	}
}


class SeeingMovie implements Runnable {
	private String[] movie;
	
	public SeeingMovie(String[] movie) {
		super();
		this.movie = movie;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<movie.length; i++) {
			System.out.println("("+(i+1)+"번째 영화)  "+movie[i]+"를 시청했습니다!");
		}
	}
}


interface Weapon {
	public void attack();
}
*/