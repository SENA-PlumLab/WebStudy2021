package teamP_07;

public class Portfolio {
	private String pfNum;
	private String memNum;
	private String title;
	private String contents;
	private String pffile;
	private String pflink;
	private int status;
	private String status_name;
	

	public Portfolio() {
		super();
	}
	

	public String getPfNum() {
		return pfNum;
	}


	public String getMemNum() {
		return memNum;
	}


	public String getTitle() {
		return title;
	}


	public String getContents() {
		return contents;
	}


	public String getPffile() {
		return pffile;
	}


	public String getPflink() {
		return pflink;
	}


	public int getStatus() {
		return status;
	}


	public String getStatus_name() {
		return status_name;
	}


	public void setPfNum(String pfNum) {
		this.pfNum = pfNum;
	}


	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public void setPffile(String pffile) {
		this.pffile = pffile;
	}


	public void setPflink(String pflink) {
		this.pflink = pflink;
	}


	public void setStatus(int status) {
		this.status = status;
		switch(status) {
		case 0:
			status_name="등록중(0)";
			break;
		case 1:
			status_name="제출(1)";
			break;
		case 2:
			status_name="심사완료-통과(2)";
			break;
		case 3:
			status_name="심사완료-반려(3)";
			break;
		}
	}


	
}
