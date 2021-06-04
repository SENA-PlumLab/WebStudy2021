package javaexp.a08_api;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

/*

# System
1. 현재 시스템(서버) 운영체제나 디렉토리에 대한 정보를 가져올 때 활용 됨
2. 지원 메소드
	.getProperty("속성"): 속성은 os.name, user.name, user.home
	.getProperties(): 시스템의 모든 정보들을 Properties 객체로 가져옴.
		--> Properties객체.keySet(): 해당 내용들을 Set 형식의 key 객체들로 가져올 수 있음.

데이터 처리 구조 가운데,
key1=value1 key2=value2 key3=value3 형식으로 되어있는 구조를 Map형 구조라고 한다.

Properties는 현재 운영체제에 대한 정보를 key/value형식으로 저장하고있음.
System.getProperty("key"): key에 해당하는 value 값이 나옴

# 환경변수 확인 부분
System.getenv("환경변수의 key")를 통해 환경변수 설정값을 가져올 수 있다.

 */
public class A10_System {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");
		System.out.println("# 현재 시스템(운영체제)에 대한 정보 #");
		System.out.println("운영체제 이름: "+osName);
		System.out.println("사용자 이름: "+userName);
		System.out.println("사용자 홈디렉토리: "+userHome);
		
		//전체속성 가져오기 (key, value)형식으로 저장되어있음
		Properties props = System.getProperties();
		
		//keySet(): 가지고 있는 속성의 key를 Set객체로 가져올 때
		Set keys = props.keySet(); //Set import 주의 Java.util.Set
		//[Key1, Key2, Key3, ..]
		
		for(Object objKey:keys) {
			String key = (String)objKey;
			String value = System.getProperty(key);
			System.out.println(key+": "+value);
		}
		
		
		//환경변수 확인
		Map maps = System.getenv();
		String path = System.getenv("Path");
		System.out.println("환경변수[Path]: "+path);
		
		
	}

}
