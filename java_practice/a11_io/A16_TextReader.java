package javaexp.a11_io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*

# 파일의 내용 읽고 쓰기
1. 파일 내용 읽기 프로세스...
	1) File 객체 생성: 대상 객체 선언
		ex) new File(경로명, 파일명)
	2) FileReader: 파일의 내용 읽어오는 객체
		new FileReader(new File());
	3) BufferedReader: 입력되어있는 내용을 라인 단위로 읽어올 때 사용되는 객체
		new BufferedReader(new FileReader(new File()));
		.readLine(): 파일에 저장된 데이터를 라인 단위로 읽어 옴..



 */
public class A16_TextReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String path = "C:\\javaexp\\workspace\\javaexp\\src\\main\\java\\javaexp\\a11_io\\z01_fileExp";
		String fname = "GoodNews.txt";
		File f = new File(path, fname);
		try {
			FileReader fr = new FileReader(f);
			BufferedReader bfr = new BufferedReader(fr);
			System.out.println("# 파일에서 읽어온 내용 #");
			String str = null;
			do {
				str = bfr.readLine();
				System.out.println(str);
			}while(str!=null);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
