package javaexp.a00_exp;

public class A16_0527 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. ---------------------------------------
		/*	
		 * 	1) 일반 예외: 컴파일 중에 나는 오류. 주로 stream이나 메모리 로딩 등에서 생김.
		 *  2) 실행 예외: 컴파일에서는 문제 없으나 실행중에 생기는 오류.
		 * 		아래 예제의 경우 컴파일에서 오류가 나지 않았으나 실행중에 ArithmeticException이 발생했다.
		 */
		try {
			call01();
		} catch(ArithmeticException e) {
			System.out.println("# 에러 발생 #");
			System.out.println(e.getMessage());
		} finally {
			System.out.println("...아무튼 실행 했습니다.");
		}
		
		
		// 2. ---------------------------------------
		/*	자바는 메소드 단위로 예외를 위임할 수 있다.
		 * 	주로 동일한 예외를 다른 메소드와 함께 처리할 때 사용된다.
		 *  public void 메소드명1() throws 예외클래스1, 예외클래스2 ....{ 예외 발생 가능성이 있는 block}
		 */
		
		try {
			call02();
			call03();
			call04();
		} catch (NullPointerException e) {
			System.out.println("예외 발생: "+ e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("예외 발생: "+ e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println("예외 발생: "+ e.getMessage());
		} catch (Exception e) {
			System.out.println("예외 발생: "+ e.getMessage());
		} finally {
			System.out.println("실행 완료~!!");
		}
		
	
	}
	
	static public void call01(){
		System.out.println(1/0);
	}
	
	static public void call02() throws NullPointerException {
		int[] iarr = null;
		System.out.println(iarr.toString());
	}
	static public void call03() throws ArrayIndexOutOfBoundsException {
		int[] iarr = null;
		System.out.println(iarr[0]);
	}
	static public void call04() throws ArithmeticException {
		System.out.println(1/0);

	}
	
}

