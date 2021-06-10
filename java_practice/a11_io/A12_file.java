package javaexp.a11_io;

import java.io.File;
import java.io.IOException;

/*

# File 입출력
1. File 클래스(파일 구성요소인 directory와 file 자체에 대한 처리를 하는 객체)
	1) 파일 시스템의 파일을 표현하는 클래스
		- 파일 크기, 속성, 이름등의 정보 제공
		- 파일 생성 및 삭제 기능 제공
		- 디렉토리 생성, 디렉토리에 존재하는 파일 리스트 얻어내는 기능 제공
	2) 파일 객체 생성
		File f01 = new File("경로와 파일명");
	3) 기능 메소드
		.exists(): 해당 파일이 있는지 여부 (물리적 파일)
		.createNewFile(): 해당 경로에 물리적 파일을 생성
		.mkdir(): 새로운 디렉토리 생성
		.mkdirs(): 경로상에 없는 모든 디렉토리 생성
		.delete(): 파일 또는 디렉토리 삭제
		
C:\javaexp\workspace\javaexp\src\main\java\javaexp\a11_io\z01_fileExp\ReadMe.txt
 */
public class A12_file {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String path = "C:\\javaexp\\workspace\\javaexp\\src\\main\\java\\javaexp\\a11_io\\z01_fileExp";
		String fname = "ReadMe.txt";
		File f01 = new File(path, fname);
		System.out.println(f01.getName());
		System.out.println(f01.exists());
		System.out.println(f01.getPath());
		System.out.println(f01.length());
		
		String fname2 = "GoodNews.txt";
		File f02 = new File(path, fname2);
		System.out.println(f02.exists());
		if(!f02.exists()) {
			try {
				f02.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//ex) z02_fileExp 패키지 생성, Person.java 클래스 생성
		//		파일정보출력: 파일이 있는지/파일명/경로명/크기
		//		show.txt: 파일 객체를 생성하고 기능 메서드로 파일 생성
		
		String pathEx = "C:\\javaexp\\workspace\\javaexp\\src\\main\\java\\javaexp\\a11_io\\z02_fileExp";
		String fnameEx = "Person.java";
		File f03 = new File(pathEx, fnameEx);
		System.out.println("f03.getName(): "+f03.getName());
		System.out.println("f03.exists(): "+f03.exists());
		System.out.println("f03.getPath(): "+f03.getPath());
		System.out.println("f03.length(): "+f03.length());
		
		File f04 = new File(pathEx, "show.txt");
		if(!f04.exists()) {
			try {
				f04.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
