package teamP_07;

public class Contents {
	private String cttNum;
	private String memNum;
	private String contents;
	private String income;
	//private int status;
	private String status;
	
	//bbs
	private String bbsTitle;
	private int viewCnt;
	
	//cmt
	private String bbsNum;
	
	//funding
	private String creNum;
	private String fdtitle;
	private String fdImg;
	private String storyImg;
	private String storySum;


	
	public Contents() {
		super();
	}

//bbs
	public Contents(String cttNum, String memNum, String contents, String income, String status, String bbsTitle,
			int viewCnt) {
		super();
		this.cttNum = cttNum;
		this.memNum = memNum;
		this.contents = contents;
		this.income = income;
		this.status = status;
		this.bbsTitle = bbsTitle;
		this.viewCnt = viewCnt;
	}
//comment
	public Contents(String cttNum, String memNum, String contents, String income, String status, String bbsNum) {
		super();
		this.cttNum = cttNum;
		this.memNum = memNum;
		this.contents = contents;
		this.income = income;
		this.status = status;
		this.bbsNum = bbsNum;
	}
//funding	

	public Contents(String cttNum, String memNum, String contents, String income, String status, String creNum, String fdtitle,
			String fdImg, String storyImg, String storySum) {
		super();
		this.cttNum = cttNum;
		this.memNum = memNum;
		this.contents = contents;
		this.income = income;
		this.status = status;
		this.creNum = creNum;
		this.fdtitle = fdtitle;
		this.fdImg = fdImg;
		this.storyImg = storyImg;
		this.storySum = storySum;
		
	}
	
	public String getFdImg() {
		return fdImg;
	}

	public void setFdImg(String fdImg) {
		this.fdImg = fdImg;
	}

	public String getCttNum() {
		return cttNum;
	}

	public String getMemNum() {
		return memNum;
	}

	public String getContents() {
		return contents;
	}

	public String getIncome() {
		return income;
	}

	public String getStatus() {
		return status;
	}

	public String getBbsTitle() {
		return bbsTitle;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public String getBbsNum() {
		return bbsNum;
	}

	public String getCreNum() {
		return creNum;
	}

	public String getFdtitle() {
		return fdtitle;
	}

	public String getStoryImg() {
		return storyImg;
	}

	public String getStorySum() {
		return storySum;
	}

	public void setCttNum(String cttNum) {
		this.cttNum = cttNum;
	}

	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public void setBbsNum(String bbsNum) {
		this.bbsNum = bbsNum;
	}

	public void setCreNum(String creNum) {
		this.creNum = creNum;
	}

	public void setFdtitle(String fdtitle) {
		this.fdtitle = fdtitle;
	}

	public void setStoryImg(String storyImg) {
		this.storyImg = storyImg;
	}

	public void setStorySum(String storySum) {
		this.storySum = storySum;
	}

	
	
	

	

	
}
