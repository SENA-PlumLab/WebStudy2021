package javaexp.z01_vo;



public class Food {

	
	private String name;
	private int price;
	private String loc;
	public Food() {
		super(); //상위 객체의 생성자. 모든 객체의 상위 객체인 Object의 생성자.
		// TODO Auto-generated constructor stub
	}
	public Food(String name, int price, String loc) {
		super();
		this.name = name;
		this.price = price;
		this.loc = loc;
	}
	
	//field에 대한 직접적인 접근은 불가하지만, 간접적으로 입력/호출 메소드를 분리시켜 처리하게 함.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
