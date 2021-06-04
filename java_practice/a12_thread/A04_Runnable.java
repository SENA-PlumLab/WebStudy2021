package javaexp.a12_thread;

public class A04_Runnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		FoodEater fe1 = new FoodEater("딸기");
		Thread t1 = new Thread(fe1);
		
		FoodEater fe2 = new FoodEater("오렌지");
		Thread t2 = new Thread(fe2);
		
		FoodEater fe3 = new FoodEater("수박");
		Thread t3 = new Thread(fe3);
		
		
		t1.start();
		t2.start();
		t3.start();
		*/	
		
		LunchMenu me1 = new LunchMenu("마라탕", (int)(Math.random()*20+1));
		LunchMenu me2 = new LunchMenu("라면", (int)(Math.random()*20+1));
		LunchMenu me3 = new LunchMenu("샌드위치", (int)(Math.random()*20+1));
		
		Thread t1 = new Thread(me1);
		Thread t2 = new Thread(me2);
		Thread t3 = new Thread(me3);
		
		t1.start();
		t2.start();
		t3.start();
		
		me1.finish();
		me2.finish();
		me3.finish();
	}

}



class LunchMenu implements Runnable{
	
	private String menu;
	int cnt;
	
	
	public LunchMenu(String menu, int cnt) {
		super();
		this.menu = menu;
		this.cnt = cnt;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1; i<=cnt; i++) {
			System.out.println(menu+"를 "+i+"번째 먹었습니다!");
		}
	}
	
	public void finish() {
		System.out.println("==="+menu+"를 총"+cnt+"번 먹었습니다!===");
	}
	
}


class FoodEater implements Runnable{
	
	private String kind;
	
	public FoodEater(String kind) {
		super();
		this.kind = kind;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=10;i++) {
			System.out.println(kind+"를 "+i+"개 먹다.");
		}

	}
	
	
}
