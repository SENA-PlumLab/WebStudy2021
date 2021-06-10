package javaexp.a11_io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class A16_TextReaderExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String path = "C:\\javaexp\\workspace\\javaexp\\src\\main\\java\\javaexp\\a11_io\\z02_fileExp";
		String fname = "Person.java";
		File f01 = new File(path, fname);
		
		try {
			BufferedReader bfr = new BufferedReader( new FileReader(f01));
			String str = null;
			/*
			str = bfr.readLine();
			while(str != null) {
				System.out.println(str);
				str = bfr.readLine();
			}
			*/
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
