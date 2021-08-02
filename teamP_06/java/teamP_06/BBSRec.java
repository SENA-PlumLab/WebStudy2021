package teamP_06;

public class BBSRec {
	private String restNum;
	private String restTitle;
	private String restAddress;
	
	public BBSRec() {
		super();
	}
	
	public BBSRec(String restNum, String restTitle, String restAddress) {
		super();
		this.restNum = restNum;
		this.restTitle = restTitle;
		this.restAddress = restAddress;
	}

	public String getRestNum() {
		return restNum;
	}

	public String getRestTitle() {
		return restTitle;
	}

	public String getRestAddress() {
		return restAddress;
	}

	public void setRestNum(String restNum) {
		this.restNum = restNum;
	}

	public void setRestTitle(String restTitle) {
		this.restTitle = restTitle;
	}

	public void setRestAddress(String restAddress) {
		this.restAddress = restAddress;
	}
	
	
	
	
}


