package javaexp.a00_exp;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

public class A17_0601 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 1. System 하위 메소드
		// .getProperty("속성"): 속성은 os.name, user.name, user.home
		// .getProperties(): Properties 객체로 시스템 값들을 받아옴
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");
		System.out.println(osName+", "+userName+", "+userHome);
		Properties props = System.getProperties();
		Set keys = props.keySet();
		for(Object k: keys) {
			String key = (String)k;
			String value = System.getProperty(key);
			System.out.println(key+": "+value);
		}
		
		// 2. 
		//	System.getenv("환경변수의 key") 환경변수 설정값을 받아옴.
		Map maps = System.getenv(); // Map 객체에 환경변수 설정값을 받아오거나
		String path = System.getenv("Path");// 키 값을 지정해서 특정 변수 설정값만 받아옴.
		System.out.println("환경변수[Path]: "+path);
		
		// 3.
		// 숫자값으로 된 것들을 객체에 입력한 뒤 설정된 인코딩과 코드값에 따라 문자로 치환함.
		
		// 4.
		byte[] byte1 = new byte[8];
		for(int i=0; i<8; i++) {
			byte1[i] = (byte)((Math.random()*26)+65);
		}
		String pass = new String(byte1);
		System.out.println("pass: "+pass);
		
		// 5.
		String[] ids = {"14015F", "17021M"}; //14년 1학년 5반 여성
		 //17년 2학년 1반 남성
		for(int i=0; i<ids.length; i++) {
			System.out.print(ids[i].substring(0,2)+"년도 입학, "
							+ids[i].substring(2,4)+"학년, "
							+ids[i].charAt(4)+"반 ");
			switch(ids[i].charAt(5)){
				case 'F': System.out.println("(여성)"); break;
				case 'M': System.out.println("(남성)"); break;
			}
		}
		
		System.out.println("--------");
		// 6.
		String[] menu = {"새우볶음밥","마파두부밥","해물짬뽕","삼선짜장","잡채밥","탕짜면","새송이덮밥"};
		String[] days = {"일","월","화","수","목","금","토"};
		int randDay = (int)(Math.random()*7);
		System.out.println("오늘은 "+days[randDay]+"요일, 오늘의 추천메뉴: "+menu[randDay]);
		for(int i=0; i<menu.length; i++) {
			System.out.println(days[i]+"요일: "+menu[i]);
		}
		
		// 7.
		String str1 = "사과&3000&2/바나나&4000&3/딸기&12000&5";
		
		ArrayList<String[]> slist = new ArrayList<String[]>();
		//String[][] result = new String[3][3];
		StringTokenizer stk1 = new StringTokenizer(str1,"/");
		int count = stk1.countTokens();
		for(int i=0; i<3; i++) {
			String str2 = stk1.nextToken();
			for(int j=0; j<3; j++) {
				slist.add(str2.split("&"));
			}
		}
		System.out.println("===");
		
		for(int i=0; i<slist.size(); i+=slist.get(i).length) {
			for(int j=0; j<3; j++) {
				System.out.print(slist.get(i)[j]+" ");
			}
			System.out.println("");
		}
		
	}

}
