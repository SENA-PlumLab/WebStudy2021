package javaexp.a07_exception;


/*

예외의 종류

1. 일반(컴파일체크) 예외
	예외처리 코드 없으면 컴파일 오류 발생
	ex) stream 관련 예외, 메모리 로딩 관련,
		DB 처리 등, io가 발생하는경우 반드시 예외처리를 해야 컴파일이 가능하다. (필수 예외처리)
		
2. 실행 예외 (RuntimeException)
	1) 예외 처리 코드를 생략해도 컴파일이 되는 예외
	2) 예외의 가망성이 있는 코드 작성시 필요
	3) 여러가시 실행 예외의 종류
		NullPointerException : 객체 참조가 없는 상태에서 객체의 멤버를 호출할 때 발생. (객체 생성X)
		ArrayIndexOutOfBoundsException: 배열에서 인덱스 범위를 초과하여 사용할 경우 발생

3. 여러가지 예외 처리
	1) 예외는 계층 구조에 의해 최하위 예외를 먼저 처리하고
	2) 상위 예외를 가장 마지막에 처리한다.
	3) 예외 발생과 상관없이 처리할 구문은 finally{}에서 처리한다.

 */
public class A03_MultiException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* 
		try {
			Class.forName("");
		} catch (ClassNotFoundException e) {
			System.out.println("예외: " + e.getMessage());
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("상위 예외"+e.getMessage());
		} finally {
			System.out.println("예외 상관 없이 수생할 구문");
		}
		
		
		*/
		
		
		int[] arr1 = null;
		String[] arr2 = {"사과", "바나나"};
		
		try {
			System.out.println("arr 길이: "+arr1.length);
			System.out.println("arr[2]: "+arr2[2]);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());

		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			System.out.println("얼레벌레 끝내기");
		}
		
		
	}

}
