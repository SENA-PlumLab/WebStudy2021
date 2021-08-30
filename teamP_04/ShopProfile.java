package javaexp.a00_exp.teamP_04;


public class ShopProfile {
	private String memberNum; //고객번호
	private String shopName, shopIntro; //상점이름, 상점소개
	private int countOfOpenDate, countVisit, countSell, countShipping;
	private boolean certified; //본인인증
	private String shopImageURL; //프로필 사진 url
	private int starRate;
	
	public ShopProfile(String memberNum, String shopName, String shopIntro, int countOfOpenDate, int countVisit,
			int countSell, int countShipping, boolean certified) {
		super();
		this.memberNum = memberNum;
		this.shopName = shopName;
		this.shopIntro = shopIntro;
		this.countOfOpenDate = countOfOpenDate;
		this.countVisit = countVisit;
		this.countSell = countSell;
		this.countShipping = countShipping;
		this.certified = certified;
		this.shopImageURL="이미지 없음";
		this.starRate = 5;
	}
	
	public void setStarRate(int starRate) {
		this.starRate = starRate;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public void setShopIntro(String shopIntro) {
		this.shopIntro = shopIntro;
	}

	public void setShopImage(String shopImageURL) {
		this.shopImageURL = shopImageURL;
	}
	
	
	public int getStarRate() {
		return starRate;
	}

	public String getMemberNum() {
		return memberNum;
	}

	public String getShopName() {
		return shopName;
	}

	public String getShopIntro() {
		return shopIntro;
	}

	public int getCountOfOpenDate() {
		return countOfOpenDate;
	}

	public int getCountVisit() {
		return countVisit;
	}

	public int getCountSell() {
		return countSell;
	}

	public int getCountShipping() {
		return countShipping;
	}

	public boolean isCertified() {
		return certified;
	}

	public String getShopImageURL() {
		return shopImageURL;
	}
	
	
}
