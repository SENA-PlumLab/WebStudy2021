package javaexp.a07_exception;

/*

# 예외 처리

1. 자바는 프로그램의 안정성 확보를 위해, 예외 처리를 지원하고 있다.
2. 예외 처리를 통해, 예외가 발생하더라도 프로그램이 안전하게 종료 될 수 있도록 한다.
3. 기본형식 
	try{
		예외가 나타날 수 있는 코드..
	} catch(Exception e) {
		예외가 발생했을 때 실행되는 코드..
	}
4. 예외 처리의 계층 구조화 및 finally 블럭
	1) 먼저 최하위의 예외 클래스를 먼저 수행.
	2) 최종적으로 예외의 상위 클래스인 Exception을 수행한다.
	3) 예외가 발생하는 순간, 해당 시점(라인)에서 바로 예외를 던진다.
		예외에 해당하는 block에서 catch로 예외를 잡게된다.
	4) finally 구문은 예외와 관계 없이 꼭 수행 할 필요성이 있는 코드를 선언하여 처리한다.
	
	try{
		1
		2
		3 예외 발생 시 throw를 던진다. 이 다음 라인은 수행X
		4
	}catch(하위 클래스 예외){
		잡은 예외를 수행 처리한다.
	}catch(상위 클래스 예외){
	
	}finally{
	
	}
5. 예외 강제: throw new 예외 클래스()로 처리
6. 예외 위임: 메소드() throws 위임할 예외클래스
	메소드 내부에서 예외를 위임 처리할 수 잇따.
7. 사용자 정의 예외
	class 사용자정의예외 extends Exception{} 형식으로 선언



 */



public class A01_ExceptionBegin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("프로세스1");
			System.out.println("프로세스2");
			System.out.println("프로세스3");
			System.out.println(1/0);
			System.out.println("프로세스4");
			System.out.println("프로세스5");
			System.out.println("프로세스6");
		} catch(Exception e){
			System.out.println("예외 발생!");
			System.out.println(e.getMessage());
		}
		
		System.out.println("프로그램 종료");
		
	}

}
