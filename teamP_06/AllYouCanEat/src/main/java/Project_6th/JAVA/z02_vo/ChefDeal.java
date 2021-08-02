package Project_6th.JAVA.z02_vo;

public class ChefDeal {
	private String cdNum;
	private String dName;
	private String dImage;
	private String restTitle;
	private String address;
	private int dPricebf;
	private int dPercent;
	private int	dPriceaf;
	private int sPoint;
	private String toDate;
	private String restText;
	private String mndetail;

	
	
	
	
	
	
	public ChefDeal() {
		super();
		// TODO Auto-generated constructor stub
	}










	public ChefDeal(String address) {
		super();
		this.address = address;
	}














	public ChefDeal(String cdNum, String dName, String dImage, String restTitle, String address, int dPricebf,
			int dPercent, int dPriceaf, int sPoint, String toDate, String restText, String mndetail) {
		super();
		this.cdNum = cdNum;
		this.dName = dName;
		this.dImage = dImage;
		this.restTitle = restTitle;
		this.address = address;
		this.dPricebf = dPricebf;
		this.dPercent = dPercent;
		this.dPriceaf = dPriceaf;
		this.sPoint = sPoint;
		this.toDate = toDate;
		this.restText = restText;
		this.mndetail = mndetail;
	}










	public String getAddress() {
		return address;
	}










	public void setAddress(String address) {
		this.address = address;
	}










	public String getCdNum() {
		return cdNum;
	}










	public void setCdNum(String cdNum) {
		this.cdNum = cdNum;
	}










	public String getdName() {
		return dName;
	}










	public void setdName(String dName) {
		this.dName = dName;
	}










	public String getdImage() {
		return dImage;
	}










	public void setdImage(String dImage) {
		this.dImage = dImage;
	}










	public String getRestTitle() {
		return restTitle;
	}










	public void setRestTitle(String restTitle) {
		this.restTitle = restTitle;
	}










	public int getdPricebf() {
		return dPricebf;
	}










	public void setdPricebf(int dPricebf) {
		this.dPricebf = dPricebf;
	}










	public int getdPercent() {
		return dPercent;
	}










	public void setdPercent(int dPercent) {
		this.dPercent = dPercent;
	}










	public int getdPriceaf() {
		return dPriceaf;
	}










	public void setdPriceaf(int dPriceaf) {
		this.dPriceaf = dPriceaf;
	}










	public int getsPoint() {
		return sPoint;
	}










	public void setsPoint(int sPoint) {
		this.sPoint = sPoint;
	}










	public String getToDate() {
		return toDate;
	}










	public void setToDate(String toDate) {
		this.toDate = toDate;
	}










	public String getRestText() {
		return restText;
	}










	public void setRestText(String restText) {
		this.restText = restText;
	}










	public String getMndetail() {
		return mndetail;
	}










	public void setMndetail(String mndetail) {
		this.mndetail = mndetail;
	}
	
	
	
	
}
