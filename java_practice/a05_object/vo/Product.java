package javaexp.a05_object.vo;

public class Product {
	
	public String name;
	public int price;
	public int num;
	
	public Product() {
		System.out.println("물건호출");
	}
	
	public Product(String name, int price, int num) {
		this.name = name;
		this.price = price;
		this.num = num;
	}
	
	public String calling() {
		System.out.println("물건의 메소드");
		return "";
	}
	
	public void buy() {
		System.out.println("구매한 물품:"+this.name+" / 단가:"+this.price+"원"
							+" / 갯수:"+this.num+" / 총 비용:"+(this.price * this.num)+"원");
		
//		System.out.println("단가:"+this.price+"원");
//		System.out.println("갯수:"+this.num);
//		System.out.println("총 비용:"+(this.price * this.num)+"원");
		
	}
	
}
