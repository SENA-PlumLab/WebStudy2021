package javaexp.a12_thread;

public class A03_OnlineBank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		BankUser u1 = new BankUser("이마크");
		BankUser u2 = new BankUser("황런쥔");
		BankUser u3 = new BankUser("이제노");
		BankUser u4 = new BankUser("이동혁");
		u1.start();
		u2.start();
		u3.start();
		u4.start();
		*/
		
		
		GameUser gu1 = new GameUser("월요일");
		GameUser gu2 = new GameUser("화요일");
		GameUser gu3 = new GameUser("수요일");
		GameUser gu4 = new GameUser("목요일");
		GameUser gu5 = new GameUser("금요일");
		
		//우선순위 추가
		gu5.setPriority(Thread.MAX_PRIORITY);
		gu1.setPriority(Thread.MIN_PRIORITY);
		
		
		gu1.start();
		gu2.start();
		gu3.start();
		gu4.start();
		gu5.start();
		
		
	}

}


class GameUser extends Thread {
	private String name;

	public GameUser(String name) {
		super();
		this.name = name;
	}
	
	public void run() {
		String[] proc = {"게임 사이트 접속", "대화하기", "게임 실행하기", "게임 로그아웃"};
		for (int i=0; i<proc.length; i++) {
			System.out.println(i+"] "+name+": "+proc[i]);
		}
	}
	
	
}





class BankUser extends Thread{
	
	private String name;

	public BankUser(String name) {
		super();
		this.name = name;
	}

	public void run() {
		String[] proc = {"로그인하다", "계좌를 확인하다!", "입금, 출금을 하다.", "로그아웃하다"};
		for (int i=0; i<proc.length; i++) {
			System.out.println(i+"] "+name+": "+proc[i]);
		}
	}
	
}