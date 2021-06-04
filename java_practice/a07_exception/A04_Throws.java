package javaexp.a07_exception;

/*

# 예외 위임

1. 자바의 예외는 메소드 단위로 예외를 위임할 수 있다.
2. 동일한 예외를 다른 메소드와 함께 동시에 처리할 때 사용됨.
3. 위임된 예외는 공통적인 예외 처리하는 곳에서 try{}catch(위임된 예외){}로 처리할 수 있따.
4. 기본형식
	public void 메소드명1() throws 예외클래스1, 예외클래스2 ....{
		예외 발생 가능성이 있는 block
	}
	public void 메소드명2() throws 예외클래스1, 예외클래스2 ....{
		예외 발생 가능성이 있는 block
	}
	
	try{
		메소드명1();
		메소드명1();
	}catch(예외클래스1 e){
	}catch(예외클래스2 e){
	}


 */


public class A04_Throws {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		try {
			call1();
			call2();
			call3();
		}catch(ArithmeticException e) {
			e.getMessage();
		}catch(NullPointerException e) {
			e.getMessage();
			
		}catch(ArrayIndexOutOfBoundsException e) {
			e.getMessage();

		}catch (Exception e) {
			// TODO: handle exception
		}
		*/
		
		try {
			findClass1();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}
	
	static void call1() throws ArithmeticException {
		System.out.println(0/1);
	}
	static void call2() throws NullPointerException {
		String s = null;
		System.out.println(s.toLowerCase());
	}
	static void call3() throws ArrayIndexOutOfBoundsException {
		String[] str = {"사과"};
		System.out.println(str[2]);
	}
	
	static void findClass1() throws ClassNotFoundException {
	//	Class cls = Class.forName("java.lang.string1");
	}
	
}

class Class {
	public void findClass1() {
		
	}
}