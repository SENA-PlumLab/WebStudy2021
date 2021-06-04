package javaexp.z01_vo;

public class Book {
	
	String title;
	int price;
	String author;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Book(String title, int price, String author) {
		super();
		this.title = title;
		this.price = price;
		this.author = author;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
