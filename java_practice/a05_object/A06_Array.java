package javaexp.a05_object;

public class A06_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] years = {"1학년", "2학년", "3학년"};
		String[][] yearClass = {{"1학년1반","1학년2반"},
									{"2학년1반","2학년2반"},
									{"3학년1반","3학년2반"}};
		
		for(int i=0; i<years.length; i++) {
			System.out.println(years[i]);
		}
		
		for(int i=0; i<yearClass.length;i++) {
			System.out.println(yearClass[i][0]+" "+yearClass[i][1]);
		}
	}

}
