package javaexp.a00_exp.teamP_04;

public class ShopReview {
	ShopProfile reviewer;
	String toMemberNum;
	String comment;
	Product product;
	int countOfUploadedDay;
	int starRate;
	
	public ShopReview(ShopProfile reviewer, String toMemberNum, String comment, Product product, int countOfUploadedDay,
			int starRate) {
		super();
		this.reviewer = reviewer;
		this.toMemberNum = toMemberNum;
		this.comment = comment;
		this.product = product;
		this.countOfUploadedDay = countOfUploadedDay;
		this.starRate = starRate;
	}

	public ShopProfile getReviewer() {
		return reviewer;
	}

	public String getToMemberNum() {
		return toMemberNum;
	}

	public String getComment() {
		return comment;
	}

	public Product getProduct() {
		return product;
	}

	public int getCountOfUploadedDay() {
		return countOfUploadedDay;
	}

	public int getStarRate() {
		return starRate;
	}
	
}
