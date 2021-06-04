package javaexp.a01_basic;

public class A02_ClassBound {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calcu cal = new Calcu((int)(Math.random()*100+1),(int)(Math.random()*100+1));
		
		cal.plus();
		cal.minus();
		cal.multiple();
		cal.divide();
		
	}

}

class Calcu{
	
	private int a, b;

	public Calcu(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	public void plus () {
		System.out.println(a+" + "+b+" = "+(a+b));
	}
	public void minus () {
		System.out.println(a+" - "+b+" = "+(a-b));
	}
	public void multiple () {
		System.out.println(a+" * "+b+" = "+(a*b));
	}
	public void divide () {
		System.out.println(a+" / "+b+" = "+(a/b));
	}
}
