package model2.vo;

import java.util.Date;

public class Member {
	/*
	CREATE TABLE member(
			memNum varchar2(8) PRIMARY key, -- mem-0001
			memId varchar2(100), -- @를 포함하게
			mempw varchar2(20), -- 8~12자 영어 숫자 섞어서 + 정규표현식 필요
			meming varchar2(500), -- 링크
			memnick varchar2(50),
			memtext varchar2(500),
			memphone varchar2(13), -- -포함 13자
			memreport number, --신고누적횟수
			memjoinDate date, --가입일자
			memmodDate date, --수정일자
			memgradenum NUMBER  -- 0 활동정지됨, 1 일반회원, 2크리에이터, 3 우수 크리에이터, 10 관리자
		);
	*/
	
	private String memNum;
	private String memId;
	private String memPw;
	private String memIng;
	private String memNick;
	private String memText;
	private String memPhone;
	private int memReport;
	private Date memJoinDate;
	private Date memModDate;
	private int memGradeNum;
	public Member() {
		super();
	}
	//로그인시
	public Member(String memId, String memPw) {
		super();
		this.memId = memId;
		this.memPw = memPw;
	}
	
	//회원가입시
	

	public Member(String memId, String memPw, String memPhone) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.memPhone = memPhone;
	}
	
	public Member(String memNum, String memId, String memPw, String memIng, String memNick, String memText,
			String memPhone, int memReport, Date memJoinDate, Date memModDate, int memGradeNum) {
		super();
		this.memNum = memNum;
		this.memId = memId;
		this.memPw = memPw;
		this.memIng = memIng;
		this.memNick = memNick;
		this.memText = memText;
		this.memPhone = memPhone;
		this.memReport = memReport;
		this.memJoinDate = memJoinDate;
		this.memModDate = memModDate;
		this.memGradeNum = memGradeNum;
	}
	
	
	
	public Member(String memNum) {
		super();
		this.memNum = memNum;
	}
	
	
	
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public String getMemIng() {
		return memIng;
	}
	public void setMemIng(String memIng) {
		this.memIng = memIng;
	}
	public String getMemNick() {
		return memNick;
	}
	public void setMemNick(String memNick) {
		this.memNick = memNick;
	}
	public String getMemText() {
		return memText;
	}
	public void setMemText(String memText) {
		this.memText = memText;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public int getMemReport() {
		return memReport;
	}
	public void setMemReport(int memReport) {
		this.memReport = memReport;
	}
	public Date getMemJoinDate() {
		return memJoinDate;
	}
	public void setMemJoinDate(Date memJoinDate) {
		this.memJoinDate = memJoinDate;
	}
	public Date getMemModDate() {
		return memModDate;
	}
	public void setMemModDate(Date memModDate) {
		this.memModDate = memModDate;
	}
	public int getMemGradeNum() {
		return memGradeNum;
	}
	public void setMemGradeNum(int memGradeNum) {
		this.memGradeNum = memGradeNum;
	}
	
	
	
	
	
	
	
}
