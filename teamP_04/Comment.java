package javaexp.a00_exp.teamP_04;

public class Comment {
	String toMemberNum;
	ShopProfile fromMember;
	String comment;
	int countOfUploadedDay;
	int priority;
	
	public Comment(String toMemberNum, ShopProfile fromMember, String comment, int countOfUploadedDay, int priority) {
		super();
		this.toMemberNum = toMemberNum;
		this.fromMember = fromMember;
		this.comment = comment;
		this.priority = priority;
		this.countOfUploadedDay = countOfUploadedDay;
	}
	public String getToMemberNum() {
		return toMemberNum;
	}
	public ShopProfile getFromMember() {
		return fromMember;
	}
	public String getComment() {
		return comment;
	}
	public int getCountOfUploadedDay() {
		return countOfUploadedDay;
	}
	public int getPriority() {
		return priority;
	}
	
	
}
