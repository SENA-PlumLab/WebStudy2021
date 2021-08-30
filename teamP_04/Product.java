package javaexp.a00_exp.teamP_04;

public class Product {
	String memberNum;
	String productNum;
	String imageURL;
	String name;
	int price;
	int countOfUploadedDay;
	String region;
	boolean isSoldout;
	
	public Product(String memberNum, String productNum, String imageURL, String name, int price, int countOfUploadedDay,
			String region) {
		super();
		this.memberNum = memberNum;
		this.productNum = productNum;
		this.imageURL = imageURL;
		this.name = name;
		this.price = price;
		this.countOfUploadedDay = countOfUploadedDay;
		this.region = region;
		this.isSoldout=false;
	}
	
	public boolean isSoldout() {
		return isSoldout;
	}

	public void setSoldout(boolean isSoldout) {
		this.isSoldout = isSoldout;
	}

	public String getMemberNum() {
		return memberNum;
	}

	public String getProductNum() {
		return productNum;
	}

	public String getImageURL() {
		return imageURL;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getCountOfUploadedDay() {
		return countOfUploadedDay;
	}

	public String getRegion() {
		return region;
	}
	
	
}
