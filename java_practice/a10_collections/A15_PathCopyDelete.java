package javaexp.a10_collections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class A15_PathCopyDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String orgFile = "C:\\javaexp\\workspace\\javaexp\\src\\main\\java\\javaexp\\a11_io\\z01_fileExp\\GoodNews.txt";
		String cpyFile = "C:\\javaexp\\workspace\\javaexp\\src\\main\\java\\javaexp\\a11_io\\z02_fileExp\\GoodNews_cpy.txt";
		Path original = Paths.get(orgFile);
		Path copied = Paths.get(cpyFile);
		
		try {
			Files.copy(original, copied, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("복사 완료!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		//ex
		String orgPerson ="C:\\javaexp\\workspace\\javaexp\\src\\main\\java\\javaexp\\a11_io\\z01_fileExp\\Person.java";
		String cpyPerson = "C:\\javaexp\\workspace\\javaexp\\src\\main\\java\\javaexp\\a11_io\\z02_fileExp\\Person.java";
		Path original2 = Paths.get(orgPerson);
		Path copied2 = Paths.get(cpyPerson);
		
		try {
			Files.copy(original2, copied2, StandardCopyOption.REPLACE_EXISTING);
			System.out.println(original2.getFileName()+" 복사 !");
			Files.delete(original2);
			System.out.println("원본 삭제 완료!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
