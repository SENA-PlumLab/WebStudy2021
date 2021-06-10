package javaexp.a10_collections;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;

public class A07_PropertiesExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. 절대경로 및 파일정보 가져오기
		String path = A07_PropertiesExp.class.getResource("member.info").getPath();
		// 절대경로: 시스템 기반으로 파일 정보를 가져올 때, 해당 시스템에서 사용하는 파일시스템 구조에 접근할 수 잇는 경로정보
		// 상대경로: 현재 실행 파일의 위치를 기준으로 ../(상위폴더) /폴더명(하위폴더)로 접근하는 경로
		
		//
		System.out.println("member.info의 절대경로: "+path);
		//1) 경로명 decoding 처리하기
			//cf) encoding/decoding: 영문자는 1byte, 그 외 타국문자 보통 2byte, Oracle DB는 한글 3byte
			//		IO가 일어날 때 기본 시스템의 전송단위가 1byte로 처리된다. 
			//		한글을 1byte로 바꾸어 전송하고, 바꾼 1byte를 다시 한글 2byte로 변경하여 처리함.
		try {
			path = URLDecoder.decode(path, "UTF-8");
		
			//2. Properties 객체 생성
			FileReader fr;
		
			fr = new FileReader(path);
		
			// OutStream의 하위 객체
			// FileReader: 2byte 이상의 한글 내용을 읽어올 수 있음
			Properties prop = new Properties();
	
			prop.load(fr);
			System.out.println(prop.getProperty("himan"));
			System.out.println(prop.getProperty("renjun"));
			System.out.println(prop.getProperty("jeno"));

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
