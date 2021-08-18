package teamP_07;

public class Report {
	private String rptNum;
	private String memNum;
	private String memNum2;
	private int statusNum;
	private String eeeNum;
	private String cttnum;
	
	private String income;
	private String edit_date;
	private String emp_name;
	private String emp_pos;
	
	
	public Report() {
		super();
	}
	

	public Report(String rptNum, String memNum, String memNum2, int statusNum, String cttnum) {
		super();
		this.rptNum = rptNum;
		this.memNum = memNum;
		this.memNum2 = memNum2;
		this.statusNum = statusNum;
		this.cttnum = cttnum;
	}


	public Report(String rptNum, String memNum, String memNum2, int statusNum, String eeeNum, String cttnum) {
		super();
		this.rptNum = rptNum;
		this.memNum = memNum;
		this.memNum2 = memNum2;
		this.statusNum = statusNum;
		this.eeeNum = eeeNum;
		this.cttnum = cttnum;
	}
	
	
	public Report(String rptNum, String memNum2, String cttnum, int statusNum, String income, String edit_date, String emp_name,
			String emp_pos) {
		super();
		this.rptNum = rptNum;
		this.memNum2 = memNum2;
		this.cttnum = cttnum;
		this.statusNum = statusNum;
		this.income = income;
		this.edit_date = edit_date;
		this.emp_name = emp_name;
		this.emp_pos = emp_pos;
	}


	public String getIncome() {
		return income;
	}


	public String getEdit_date() {
		return edit_date;
	}


	public String getEmp_name() {
		return emp_name;
	}


	public String getEmp_pos() {
		return emp_pos;
	}


	public void setIncome(String income) {
		this.income = income;
	}


	public void setEdit_date(String edit_date) {
		this.edit_date = edit_date;
	}


	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}


	public void setEmp_pos(String emp_pos) {
		this.emp_pos = emp_pos;
	}


	public String getRptNum() {
		return rptNum;
	}


	public String getMemNum() {
		return memNum;
	}


	public String getMemNum2() {
		return memNum2;
	}


	public int getStatusNum() {
		return statusNum;
	}


	public String getEeeNum() {
		return eeeNum;
	}


	public String getCttnum() {
		return cttnum;
	}


	public void setRptNum(String rptNum) {
		this.rptNum = rptNum;
	}


	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}


	public void setMemNum2(String memNum2) {
		this.memNum2 = memNum2;
	}


	public void setStatusNum(int statusNum) {
		this.statusNum = statusNum;
	}


	public void setEeeNum(String eeeNum) {
		this.eeeNum = eeeNum;
	}


	public void setCttnum(String cttnum) {
		this.cttnum = cttnum;
	}
	
	
	
	
}
