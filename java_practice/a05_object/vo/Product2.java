package javaexp.a05_object.vo;

public class Product2 {
	
	private String name;
	private int cnt, price;
	
	public Product2(String name, int cnt, int price) {
		super();
		this.name = name;
		this.cnt = cnt;
		this.price = price;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+"("+price+"원) 재고:"+cnt+"개";
	}

}
