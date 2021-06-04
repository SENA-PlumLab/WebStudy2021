package javaexp.a08_api;

/*

# String

1. 문자열 처리하는 객체
2. 선언 방식
	String 변수명 = "문자열";
	String 변수명 = new String("문자열");
3. 객체이기때문에 heap메모리의 주소에 할당된다.
	1) 첫번째 방식은 문자열만 같으면 같은 주소에 할당된다.
		String name1 = "홍길동";
		String name2 = "홍길동";
		"홍길동"이라는 문자열은 heap 영역의 동일한 주소를 참조하여 설정된다.
		직접 코딩에 의해서 할당이 되어 사용 가능하다. (일반적인 방식은 두번째 방식)
		때문에 name1 == name2 는 서로 동일한 주소값이기 때문에 true가 된다.
	2) 두번째 방식은 문자열이 각각 다른 주소를 만들어서 데이터를 가지고 온다.
		String name3 = new String("홍길동");
		String name4 = new String("홍길동");
		name3 == name4 서로 다른 주소를 가지기 때문에 false가 된다.
		일반적으로 DB에서 불러오거나, network를 통해서 가져오거나, 파일을 통해서 가져오는 데이터는 
		모두 다 내부적으로 이런 방식을 사용한다.
		

 */


public class A01_String {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name1 = "홍길동";
		String name2 = "홍길동";
		String name3 = new String("홍길동");
		String name4 = new String("홍길동");
		
		System.out.println(name1 == name2);
		System.out.println(name3 == name4);
		
		//문자열만 비교해서 데이터를 처리할 때
		//==와 같은 stack영역의 데이터 비교 방식은 문제가 발생한다.
		
		// 자바에서 문자열 데이터를 비교할 때는 stack영역의 주소값이 아닌
		// 문자열 자체를 비교해주는 .equals()메소드를 활용해야한다.
		
		System.out.println(name4.equals(name3));
		
		String id = new String("himan");
		String pw = new String("7777");

		if(id.equals("himan")) {
			System.out.println("등록된 아이디입니다.");
		}else {
			System.out.println("등록 가능한 아이디입니다.");
		}
		
		
		
		
	}

}
