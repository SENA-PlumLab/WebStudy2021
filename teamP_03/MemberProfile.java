package javaexp.a00_exp.teamP_03;

import java.util.ArrayList;
import java.util.Calendar;

public class MemberProfile {
	private String memberNum; //고객번호
	private member_grade grade; //고객등급
	private String name, phone, pccc, email; //pccc=통관번호
	private String ableToGetInform;
	
	Properties memberProp = new Properties();
	
	public MemberProfile(String memberNum, member_grade grade, String name, String phone, String pccc, String email,
			String ableToGetInform) {
		super();
		this.memberNum = memberNum;
		this.grade = grade;
		this.name = name;
		this.phone = phone;
		this.pccc = pccc;
		this.email = email;
		this.ableToGetInform = ableToGetInform;
	}
	
	
	public Properties getMemberProp() {
		return memberProp;
	}


	public String getMemberNum() {
		return memberNum;
	}


	public member_grade getGrade() {
		return grade;
	}


	public String getName() {
		return name;
	}


	public String getPhone() {
		return phone;
	}

	public String getPccc() {
		return pccc;
	}

	public String getEmail() {
		return email;
	}

	public String isAbleToGetInform() {
		return ableToGetInform;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPccc(String pccc) {
		this.pccc = pccc;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAbleToGetInform(String ableToGetInform) {
		this.ableToGetInform = ableToGetInform;
	}
	
	
	
	
}

class Properties{ //쿠폰+예치금+보증금
	private ArrayList<Coupons> couponList = new ArrayList<Coupons>(); //쿠폰 목록
	private Money deposit = new Money(); //예치금 잔액
	private Money guaranty = new Money(); //보증금 잔액
	private ArrayList<MoneyUsed> depositRecord = new ArrayList<MoneyUsed>(); // 예치금 이용 내역
	private ArrayList<MoneyUsed> guarantyRecord = new ArrayList<MoneyUsed>();// 보증금 이용 내역
	
	public Money getDeposit() {
		return deposit;
	}
	public Money getGuaranty() {
		return guaranty;
	}
	
	public ArrayList<Coupons> getCouponList() {
		return couponList;
	}
	public ArrayList<MoneyUsed> getDepositRecord() {
		return depositRecord;
	}
	public ArrayList<MoneyUsed> getGuarantyRecord() {
		return guarantyRecord;
	}
	public void setDeposit(Money deposit) {
		this.deposit = deposit;
	}
	public void setGuaranty(Money guaranty) {
		this.guaranty = guaranty;
	}
	
	

}

class Coupons {
	private String couponNum;
	private String name, limit; //쿠폰정보, 제한조건
	private coupon_status status; //사용구분
	private String regDate, limitDate; //등록일, 유효기간
	private String usedDate; //사용날짜
	
	
	public Coupons(String couponNum, String name, String limit, coupon_status status, String regDate, String limitDate) {
		super();
		this.couponNum = couponNum;
		this.name = name;
		this.limit = limit;
		this.status = status;
		this.regDate = regDate;
		this.limitDate = limitDate;
	}

	public Coupons(String couponNum, String name, String limit, coupon_status status, String usedDate) {
		super();
		this.couponNum = couponNum;
		this.name = name;
		this.limit = limit;
		this.status = status;
		this.usedDate = usedDate;
	}

	public void use(String usedDate) {
		status = coupon_status.USED;
		this.usedDate = usedDate;
	}


	public String getCouponNum() {
		return couponNum;
	}

	public String getName() {
		return name;
	}


	public String getLimit() {
		return limit;
	}


	public coupon_status getStatus() {
		return status;
	}


	public String getRegDate() {
		return regDate;
	}


	public String getLimitDate() {
		return limitDate;
	}


	public String getUsedDate() {
		return usedDate;
	}
	
	
}

class Money {
	private int balance; //잔액
	
	public void add(int a) {
		balance += a;
	}
	public void refund(int a) {
		balance -= a;
	}
	public void use(int a) {
		balance -= a;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}

class MoneyUsed {
	private money_kind kind; //구분(예치금, 보증금)
	private String usedDate; //일자
	private String productNum; //상품번호
	private String info; //내역
	private int amount; //금액
	public MoneyUsed(money_kind kind, String usedDate, String productNum, String info, int amount) {
		super();
		this.kind = kind;
		this.usedDate = usedDate;
		this.productNum = productNum;
		this.info = info;
		this.amount = amount;
	}
	public money_kind getKind() {
		return kind;
	}
	public String getUsedDate() {
		return usedDate;
	}
	public String getProductNum() {
		return productNum;
	}
	public String getInfo() {
		return info;
	}
	public int getAmount() {
		return amount;
	}
	
}

class Product{
	private String productNum;
	private String name;
	private int price;
	public Product(String productNum, String name, int price) {
		super();
		this.productNum = productNum;
		this.name = name;
		this.price = price;
	}
	public String getProductNum() {
		return productNum;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	
}

class OrderedProduct{
	private String orderDate;
	private String orderNum, produtNum;
	private String name;
	private order_status status;
	public OrderedProduct(Product p, String orderDate, String orderNum, order_status status) {
		super();
		this.orderDate = orderDate;
		this.orderNum = orderNum;
		this.status = status;
		this.name = p.getName();
		this.produtNum = p.getProductNum();
	}
	public String[] show() {
		String[] info = new String[5];
		info[0] = orderDate;
		info[1] = orderNum;
		info[2] = produtNum;
		info[3] = name;
		info[4] = status.toString();
		return info;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public String getProdutNum() {
		return produtNum;
	}
	public String getName() {
		return name;
	}
	public order_status getStatus() {
		return status;
	}
	
	
}

class Inquiry{
	private String title;
	private String date;
	private inquiry_status status;
	public Inquiry(String title, String date, inquiry_status status) {
		super();
		this.title = title;
		this.date = date;
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public String getDate() {
		return date;
	}
	public inquiry_status getStatus() {
		return status;
	}
	
}
enum member_grade {
	GRADE0, //신규회원 (6개월이내 구매 0건)
	GRADE1, // 6개월이내 구매 1건
	GRADE2, // 6개월이내 구매 2건
	GRADE3, // ...
	GRADE4,
	GRADE5,
	GRADE6,
	GRADE7,
	GRADE8,
	GRADE9,
	GRADE10,
	GRADE11ANDOVER //6개월이내 구매 11건 이상
}
enum coupon_status {
	NOTUSED,
	USED,
	EXPIRED
}
enum money_kind {
	DEPOSIT, //예치금
	GUARANTY //보증금
}

enum order_status{
	IN_PROGESS,
	SHIPPED,
	CANCELLED
}

enum inquiry_status{
	WAITING,
	IN_PROGRSS,
	REPLIED
}