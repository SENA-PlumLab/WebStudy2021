package javaexp.a05_object;

public class A07_OOP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Z02_Bus b1 = new Z02_Bus();
		
		b1.no=7900;
		b1.from="서울";
		b1.to="수원";
		
		Z03_Computer c1 = new Z03_Computer();
		Z03_Computer c2 = new Z03_Computer();
		
		c1.manufac = "한성컴퓨터";
		c1.cpu = "인텔";
		c1.ram = "8G";
		
		c2.manufac = "LG";
		c2.cpu = "인텔";
		c2.ram = "4G";
		
		System.out.println(c1.manufac+": "+c1.cpu+", "+c1.ram);
		System.out.println(c2.manufac+": "+c2.cpu+", "+c2.ram);
	}

}
