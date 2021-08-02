package Project_6th.JAVA.z02_vo;


public class Dept {
	/*
	  CREATE TABLE "SCOTT"."DEPT" 
   (	"DEPTNO" NUMBER(2,0), 
	"DNAME" VARCHAR2(14), 
	"LOC" VARCHAR2(13), 
	  
	 */
	private double deptno;
	private String dname;
	private String loc;
	public Dept() {
		super();
	}
	public Dept(String dname, String loc) {
		super();
		this.dname = dname;
		this.loc = loc;
	}
	public Dept(double deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	public double getDeptno() {
		return deptno;
	}
	public void setDeptno(double deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
