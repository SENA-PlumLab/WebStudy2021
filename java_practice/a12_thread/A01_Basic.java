package javaexp.a12_thread;



/*

# Thread 프로그래밍

1. 하나의 프로세스(프로그래밍 단위) 안에서 여러 개의 쓰레드를 통해 한번에 여러 작업을 할 수 있게 하는 프로그래밍 방식.
2. 기본 형식
	1) Thread를 직접 상속받아서 처리해주는 방식
		class 클래스명 extends Thread{
			void run(){
				xx....
			}
		}
		클래스명 참조변수 = new 생성자();
		참조변수.start(); ==> 정의된 run()를 life cycle에 의해서 호출한다.
		
		장점) 바로 객체를 start()에 의해 생성해서 사용할 수 있다.
		단점) extends를 이용해서 Thread를 상속했기 때문에 추후 추가상속 불가능
		
		
	2) Runnable 인터페이스를 implements 받아서 처리해주는 방식
		class 클래스명 implements Runnable{
			void run(){}
		}
		클래스명 참조변수 = new 생성자();
		Thread t1 = new Thread(참조변수);
		t1.start();
		
		장점) implements 이기 때문에 다른 클래스를 상속하여 사용할 수 있다.
		단점) Thread를 다시 만들어서 참조변수로 넣어야하는 불편함이 있다.
		
3. 쓰레드 설정 기본 메소드
	1) getName() : 쓰레드의 고유명을 가져온다
	2) getPriority() : 쓰레드의 우선 순위 설정된 내용을 가져온다.
		- 쓰레드 우선순위 설정 상수
			Thread.MAX_PRIORITY : 최우선 쓰레드 처리
			Thread.NORM_PRIORITY: 중간 우선 쓰레드 처리
			Thread.MIN_PRIORITY : 최하위 우선 쓰레드 처리 
		
		
		
	언제 쓰레드 프로그래밍이 필요할까?
		1) 웹 서버 기준..
			cpu를 분할해서 한번에 여러 프로그래밍을 처리해주므로 여러 쓰레드를 이용하여 효과적으로 프로그램을 동시에 처리해줄 수 있는 장점이 있따.


 */



public class A01_Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GoThread g1 = new GoThread();
		ComeThread c1 = new ComeThread();
		g1.setName("첫번째 쓰레드");
		c1.setName("두번째 쓰레드");
		
		
		//우선순위 설정
		g1.setPriority(Thread.MIN_PRIORITY);
		c1.setPriority(Thread.MAX_PRIORITY);
		
		
		System.out.println("##"+g1.getName()+"##");
		g1.start();
		System.out.println("##"+c1.getName()+"##");
		c1.start();
		
	}

}

class Go{
	public void run() {
		for(int i=1; i<=1000; i++)
		System.out.println("gogo!! [쓰레드 없는 프로그램]");
	}
}

class Come{
	public void run() {
		for(int i=1; i<=1000; i++)
		System.out.println("come!! [쓰레드 없는 프로그램]");
	}
}
class GoThread extends Thread{
	public void run() {
		for(int i=1; i<=1000; i++)
		System.out.println(i+"] gogo!! [쓰레드 프로그램]");
	}
}

class ComeThread extends Thread{
	public void run() {
		for(int i=1; i<=1000; i++)
		System.out.println(i+"] come!! [쓰레드 프로그램]");
	}
}

