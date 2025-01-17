package model2.vo;

public class PortfoiloDetail {
	/*
	  
		 CREATE TABLE portfolio(
			pfNum varchar2(8) PRIMARY key, -- pfn-0001
			memNum varchar2(8),
			pfTitle varchar2(90),
			pfContent varchar2(3000),
			pfFile varchar2(300),
			pfLink varchar2(300),
			pfStateNum number
		); 
	 */
	
	private String pfNum;
	private String memNum;
	private String pfTitle;
	private String pfContent;
	private String pfFile;
	private String pfLink;
	private int pfStateNum;
	
	public PortfoiloDetail() {
		super();
	}
	

	public PortfoiloDetail(String pfNum) {
		super();
		this.pfNum = pfNum;
	}
	
	
	

	public PortfoiloDetail(String pfTitle, String pfContent, String pfFile, String pfLink, String pfNum) {
		super();
		this.pfTitle = pfTitle;
		this.pfContent = pfContent;
		this.pfFile = pfFile;
		this.pfLink = pfLink;
		this.pfNum = pfNum;
	}


	public PortfoiloDetail(String pfNum, String pfTitle, String pfContent, String pfFile, String pfLink,
			int pfStateNum) {
		super();
		this.pfNum = pfNum;
		this.pfTitle = pfTitle;
		this.pfContent = pfContent;
		this.pfFile = pfFile;
		this.pfLink = pfLink;
		this.pfStateNum = pfStateNum;
	}


	public String getPfNum() {
		return pfNum;
	}

	public void setPfNum(String pfNum) {
		this.pfNum = pfNum;
	}

	public String getMemNum() {
		return memNum;
	}

	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}

	public String getPfTitle() {
		return pfTitle;
	}

	public void setPfTitle(String pfTitle) {
		this.pfTitle = pfTitle;
	}

	public String getPfContent() {
		return pfContent;
	}

	public void setPfContent(String pfContent) {
		this.pfContent = pfContent;
	}

	public String getPfFile() {
		return pfFile;
	}

	public void setPfFile(String pfFile) {
		this.pfFile = pfFile;
	}

	public String getPfLink() {
		return pfLink;
	}

	public void setPfLink(String pfLink) {
		this.pfLink = pfLink;
	}

	public int getPfStateNum() {
		return pfStateNum;
	}

	public void setPfStateNum(int pfStateNum) {
		this.pfStateNum = pfStateNum;
	}
	
	
	
}
