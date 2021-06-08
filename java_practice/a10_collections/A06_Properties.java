package javaexp.a10_collections;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;


/*

# Properties
1. 특정한 파일을 호출하여 해당 파일의 내용이 key=value로 되어있는 경우에
2. getProperty("key")로 내용을 문자열로 가져옴.
3. 기능메서드
	.load(new FileReader("파일명/경로명"))
		해당 파일 로딩 처리
	.getProperty(): key로 설정한 값을 가져온다.


 */


public class A06_Properties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		
		
		// 시스템상의 절대경로 가져옴 
		// 메인클래스.class.getResource("메인클래스와 같이 있는 파일명").getPath()
		String path = A06_Properties.class.getResource("database.properties").getPath();
		System.out.println("절대경로와 파일명: "+path); 
		// 경로명에 한글이 포함된다면 decode처리 필요
		try {
			path = URLDecoder.decode(path, "utf-8");
			prop.load(new FileReader(path));
			System.out.println("driver: "+prop.getProperty("driver"));
			System.out.println("url: "+prop.getProperty("url"));
			System.out.println("username: "+prop.getProperty("username"));
			System.out.println("password: "+prop.getProperty("password"));
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ex
		Properties prop2 = new Properties();
		String path2 = A06_Properties.class.getResource("member.info").getPath();
		System.out.println("경로: "+path2);
		
		try {
			prop2.load(new FileReader(path2));
			System.out.println("himan: "+prop2.getProperty("himan"));
			System.out.println("renjun: "+prop2.getProperty("renjun"));
			System.out.println("jeno: "+prop2.getProperty("jeno"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
