package Project_6th.JAVA.z0717_project;

import java.util.Date;

public class review {

	private String reviewNum;
	private String restNum;
	private String userNum;
	private int reviewPoint;
	private Date reviewDate;
	private String reviewContent;
	private String reviewImage;
	public review() {
		super();
	}
	
	public review(String restNum) {
		super();
		this.restNum = restNum;
	}

	public review(String reviewNum, String restNum, String userNum, int reviewPoint, Date reviewDate,
			String reviewContent, String reviewImage) {
		super();
		this.reviewNum = reviewNum;
		this.restNum = restNum;
		this.userNum = userNum;
		this.reviewPoint = reviewPoint;
		this.reviewDate = reviewDate;
		this.reviewContent = reviewContent;
		this.reviewImage = reviewImage;
	}

	public String getReviewNum() {
		return reviewNum;
	}

	public void setReviewNum(String reviewNum) {
		this.reviewNum = reviewNum;
	}

	public String getRestNum() {
		return restNum;
	}

	public void setRestNum(String restNum) {
		this.restNum = restNum;
	}

	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public int getReviewPoint() {
		return reviewPoint;
	}

	public void setReviewPoint(int reviewPoint) {
		this.reviewPoint = reviewPoint;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getReviewImage() {
		return reviewImage;
	}

	public void setReviewImage(String reviewImage) {
		this.reviewImage = reviewImage;
	}
	
	
	

	
}


