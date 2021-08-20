package teamP_07;

public class Log {
	private String logNum;
	private String kind;
	private String memo;
	private String date;

	
	public Log() {
		super();
	}
	

	public Log(String logNum, String memo, String date) {
		super();
		this.logNum = logNum;
		this.memo = memo;
		this.date = date;
	}


	public Log(String logNum, String kind, String memo, String date) {
		super();
		this.logNum = logNum;
		this.kind = kind;
		this.memo = memo;
		this.date = date;
	}


	public String getLogNum() {
		return logNum;
	}


	public String getKind() {
		return kind;
	}


	public String getMemo() {
		return memo;
	}


	public String getDate() {
		return date;
	}


	public void setLogNum(String logNum) {
		this.logNum = logNum;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}


	public void setMemo(String memo) {
		this.memo = memo;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
	
}
