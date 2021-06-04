package javaexp.a08_api;

import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

/*
 * 
# String

1. 문자열 처리 객체
2. 생성자로 byte[]를 받아서 처리
3. 여러 기능 메소드
	1) charAt(index): 특정 index 위치에 있는 문자를 리턴받음
	2) getBytes(): 문자열의 byte 배열을 가져온다.
		이 때, 매개변수값으로 EUC-KR이나 UTF-8로 한들 encoding 형식을 지정할 수 있다.
	3) indexof("찾을문자열"): 문자열의 인덱스 찾아줌
	4)
	5) "대상문자열".replace("찾는 문자열", "변경할 문자열");
	6) "문자열".substring(추출시작위치, 추출마지막위치)
		문자열에서 특정 문자을 추출할 때 사용 
	7) 문자열.split("구분자"): 특정 문자열에서 구분자에 의해 구분된 데이터를 배열로 할당.
	
# StringTokenizer("문자열","구분자")
1. 기능 메소드
	countTokens(): 구분자를 통해 나온 데이터의 건수
	nextToken(): 구분자를 통해서 나온 각 데이터 하나씩. 호출시마다 하나씩 데이터 가져옴
	hasMoreTokens(): 해당 데이터가 있을때 true, 다음데이터 단위로 변
 */
public class A11_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		byte[] bytes= {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};
		String str1= new String(bytes);
		System.out.println(str1);
		
		for(int code=64; code<=128; code++) {
			System.out.println(code+": "+(char)code);
		}
		
		
		System.out.println(str1.charAt(6));
		System.out.println(str1.getBytes());
		
		try {
			byte[] byte4 = str1.getBytes("EUC-KR");
			String str5 = new String(byte4);
			System.out.println("문자열5(EUC-KR): "+str5);
			
			byte[] byte5 = str1.getBytes("UTF-8");
			String str6 = new String(byte5);
			System.out.println("문자열6(UTF-8): "+str6);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println("==============================");
		//ex) =============================
		String strA = "오늘도 즐겁고 감사한 하루!!";
		System.out.println("문자열A: "+strA);
		
		try {
			byte[] byteA = strA.getBytes("EUC-KR");
			String strB = new String(byteA);
			System.out.println("문자열B: "+strB+"(EUC-KR)");
			
			byte[] byteB = strA.getBytes("UTF-8");
			String strC = new String(byteB);
			System.out.println("문자열C: "+strC+"(UTF-8)");
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String target = "자바는 객체지향 프로그램입니다.\n"+"자바는 풍부한 API를 지원합니다.^^";
		String newStr = target.replace("자바", "JAVA");
		System.out.println("기존: "+target);
		System.out.println("변경후: "+newStr);
		String subStr = target.substring(4, 12);
		System.out.println("추출: "+subStr);
		
		//7.
		String data01 = "사과&바나나&딸기";
		String[] fruits = data01.split("&");
		for(String fruit:fruits) {
			System.out.println(fruit);
		}
		String data02 = "서울-대구-대전-부산";
		String[] locals = data02.split("-");
		for(String local:locals) {
			System.out.println(local);
		}
		StringTokenizer st = new StringTokenizer("오렌지&수박&딸기","&");
		int count = st.countTokens();
		System.out.println("# Token #");
		for(int cnt=1; cnt<=count; cnt++) {
			String token = st.nextToken();
			System.out.println(token);
		}
		StringTokenizer st2 = new StringTokenizer("마라탕@15000@33","@");
		System.out.println("# Token2 #");
		int count2 = st2.countTokens();
		for(int i=1; i<=count2; i++) {
			String token2 = st2.nextToken();
			System.out.println(token2);
		}
		while (st2.hasMoreTokens()) {
			String token3 = st2.nextToken();
			System.out.println(token3);
		}
		
		
	}

}
