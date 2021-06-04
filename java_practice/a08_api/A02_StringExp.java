package javaexp.a08_api;



// 우클릭 - Run as - Run Configuration - argument - Program argument 칸에 입력, 공백으로 구분
// 여기 입력은 [himan 7777]

public class A02_StringExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(args[0]);
		System.out.println(args[1]);
		
		String id = new String("himan");
		String pw = new String("7777");

		if(id.equals("himan")) {
			System.out.println("등록된 아이디입니다.");
		}else {
			System.out.println("등록 가능한 아이디입니다.");
		}
		
		if(id.equals(args[0]) && pw.equals(args[1])) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
	}

}
