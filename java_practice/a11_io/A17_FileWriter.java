package javaexp.a11_io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*

# File 쓰기 처리
1. 주요 처리 절차
	1) 대상 file 지정
	2) System.in 으로 입력
		InputStream ==> InputStreamReader ==> BufferedReader
	3) PrintWriter로 출력 객체 활용
	4) File ==> FileWriter ==> PrintWriter
		입력된 내용을 PRintWriter의 out.print()를 활용해서 출력


 */
public class A17_FileWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader buffer = new BufferedReader(new InputStreamReader (System.in));
		System.out.println("# 입력할 내용 #");
		
		//1. 출력할 File 객체 생성
		String path = "C:\\javaexp\\workspace\\javaexp\\src\\main\\java\\javaexp\\a11_io\\z02_fileExp";
		String fname = "show.txt";
		File f = new File(path, fname);
		
		
		PrintWriter out = null;
		try {
			FileWriter writer = new FileWriter(f);
			out = new PrintWriter(writer);
			
			//해당 파일에 쓰기
			out.write(buffer.readLine());
			
			
			//읽기
			String str = null;
			do {
				str = buffer.readLine();
				System.out.println(str);
			}while(str!=null);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				buffer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.close();
		}
		
		
		
	}

}
