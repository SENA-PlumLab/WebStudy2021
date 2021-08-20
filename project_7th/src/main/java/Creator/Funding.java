package Creator;

public class Funding {
	private String fdNum;  
	private String creNum;
	private String creNM;
	private int fdThemeNum;
	private String fdProjectNM;  
	private int fdTargetPrice;
	private String fdImg;  
	private int fdCategoryNum; 
	private String fdRegiDT; 
	private String fdExpDT; 
	private String fdTags; 
	private String fdStoryImg;  
	private String fdStorySum; 
	private String fdStory;  
	private String fdRefund; 
	private String fdPolicy;  
	private int statusnum; 
	private String fdingprice;
	private String FDTHEMENM;
	private String FDCATEGORYNM;
	
	
	
	
	
	
	public Funding(String creNum) {
		super();
		this.creNum = creNum;
	}




	public Funding(String fdNum, String creNum, String creNM, String fDTHEMENM, String fdProjectNM, int fdTargetPrice, String fdingprice,
			String fdImg, String fDCATEGORYNM, String fdExpDT) {
		super();
		this.fdNum = fdNum;
		this.creNum = creNum;
		this.creNM = creNM;
		this.FDTHEMENM = fDTHEMENM;
		this.fdProjectNM = fdProjectNM;
		this.fdTargetPrice = fdTargetPrice;
		this.fdingprice = fdingprice;
		this.fdImg = fdImg;
		this.FDCATEGORYNM = fDCATEGORYNM;
		this.fdExpDT = fdExpDT;
	}




	public String getCreNM() {
		return creNM;
	}




	public void setCreNM(String creNM) {
		this.creNM = creNM;
	}




	public String getFDTHEMENM() {
		return FDTHEMENM;
	}




	public void setFDTHEMENM(String fDTHEMENM) {
		FDTHEMENM = fDTHEMENM;
	}




	public String getFDCATEGORYNM() {
		return FDCATEGORYNM;
	}




	public void setFDCATEGORYNM(String fDCATEGORYNM) {
		FDCATEGORYNM = fDCATEGORYNM;
	}




	public Funding(String fdRefund, String fdPolicy) {
		super();
		this.fdRefund = fdRefund;
		this.fdPolicy = fdPolicy;
	}




	public Funding(String creNum, int fdThemeNum) {
		super();
		this.creNum = creNum;
		this.fdThemeNum = fdThemeNum;
	}
	
	


	public Funding(String fdStoryImg, String fdStorySum, String fdStory) {
		super();
		this.fdStoryImg = fdStoryImg;
		this.fdStorySum = fdStorySum;
		this.fdStory = fdStory;
	}





	public Funding(String fdProjectNM, int fdTargetPrice, String fdImg, int fdCategoryNum, String fdExpDT,
			String fdTags) {
		super();
		this.fdProjectNM = fdProjectNM;
		this.fdTargetPrice = fdTargetPrice;
		this.fdImg = fdImg;
		this.fdCategoryNum = fdCategoryNum;
		this.fdExpDT = fdExpDT;
		this.fdTags = fdTags;
	}





	public String getFdNum() {
		return fdNum;
	}
	public void setFdNum(String fdNum) {
		this.fdNum = fdNum;
	}
	public String getCreNum() {
		return creNum;
	}
	public void setCreNum(String creNum) {
		this.creNum = creNum;
	}
	public int getFdThemeNum() {
		return fdThemeNum;
	}
	public void setFdThemeNum(int fdThemeNum) {
		this.fdThemeNum = fdThemeNum;
	}
	public String getFdProjectNM() {
		return fdProjectNM;
	}
	public void setFdProjectNM(String fdProjectNM) {
		this.fdProjectNM = fdProjectNM;
	}
	public int getFdTargetPrice() {
		return fdTargetPrice;
	}
	public void setFdTargetPrice(int fdTargetPrice) {
		this.fdTargetPrice = fdTargetPrice;
	}
	public String getFdImg() {
		return fdImg;
	}
	public void setFdImg(String fdImg) {
		this.fdImg = fdImg;
	}
	public int getFdCategoryNum() {
		return fdCategoryNum;
	}
	public void setFdCategoryNum(int fdCategoryNum) {
		this.fdCategoryNum = fdCategoryNum;
	}
	public String getFdRegiDT() {
		return fdRegiDT;
	}
	public void setFdRegiDT(String fdRegiDT) {
		this.fdRegiDT = fdRegiDT;
	}
	public String getFdExpDT() {
		return fdExpDT;
	}
	public void setFdExpDT(String fdExpDT) {
		this.fdExpDT = fdExpDT;
	}
	public String getFdTags() {
		return fdTags;
	}
	public void setFdTags(String fdTags) {
		this.fdTags = fdTags;
	}
	public String getFdStoryImg() {
		return fdStoryImg;
	}
	public void setFdStoryImg(String fdStoryImg) {
		this.fdStoryImg = fdStoryImg;
	}
	public String getFdStorySum() {
		return fdStorySum;
	}
	public void setFdStorySum(String fdStorySum) {
		this.fdStorySum = fdStorySum;
	}
	public String getFdStory() {
		return fdStory;
	}
	public void setFdStory(String fdStory) {
		this.fdStory = fdStory;
	}
	public String getFdRefund() {
		return fdRefund;
	}
	public void setFdRefund(String fdRefund) {
		this.fdRefund = fdRefund;
	}
	public String getFdPolicy() {
		return fdPolicy;
	}
	public void setFdPolicy(String fdPolicy) {
		this.fdPolicy = fdPolicy;
	}
	public int getStatusnum() {
		return statusnum;
	}
	public void setStatusnum(int statusnum) {
		this.statusnum = statusnum;
	}
	public String getFdingprice() {
		return fdingprice;
	}
	public void setFdingprice(String fdingprice) {
		this.fdingprice = fdingprice;
		
	}

	
	
}
