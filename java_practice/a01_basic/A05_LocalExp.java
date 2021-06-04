package javaexp.a01_basic;

public class A05_LocalExp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Product p1 = new Product("마라탕");
		p1.setPriceCnt(8000, 5);
		
		Product p2 = new Product("물감");
		p2.setPriceCnt(3000, 20);
		
		p1.getInfo();
		p2.getInfo();
	}

}

class Product {
	
	private String name;
	private int price, cnt;
	
	public Product(String name) {
		super();
		this.name = name;
	}
	
	public void setPriceCnt (int p, int c) {
		this.price = p;
		this.cnt = c;
	}
	
	public void getInfo() {
		System.out.println(name+"("+price+"원) : 재고 "+cnt+"개");
	}
}