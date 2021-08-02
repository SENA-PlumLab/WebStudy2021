package Project_6th.JAVA.z02_vo;

import java.util.Date;
// util에 있는 date 써야함.

public class Emp {
	/*
	CREATE TABLE "SCOTT"."EMP02" 
	   (	"EMPNO" NUMBER(4,0), 
		"ENAME" VARCHAR2(10), 
		"JOB" VARCHAR2(9), 
		"MGR" NUMBER(4,0), 
		"HIREDATE" DATE, 
		"SAL" NUMBER(7,2), 
		"COMM" NUMBER(7,2), 
		"DEPTNO" NUMBER(2,0)
	   )
	   sql의 테이블정보 DDL에서 확인가능
	   
	   sql참고하여 필드 생성.
	   이름과 타입을 맞춰서 생성
	 */
	private int empno;
	private String name;
	private String job;
	private int mgr;
	private Date hiredate; // sql이 아닌 util의 date 써야함
	
	private String hiredateS; // 스트링으로 만들어준다.
	
	private double sal;
	private double comm;
	private int deptno;
	public Emp() {
		super();
	}
	
	public Emp(int empno) {
		super();
		this.empno = empno;
	}

	public Emp(String name, String job) {
		this.name = name;
		this.job = job;
	}

	public Emp(int empno, String name, String job, int mgr, Date hiredate, double sal, double comm, int deptno) {
		super();
		this.empno = empno;
		this.name = name;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	
	public Emp(int empno, String name, String job, int mgr, String hiredateS, double sal, double comm, int deptno) {
		super();
		this.empno = empno;
		this.name = name;
		this.job = job;
		this.mgr = mgr;
		this.hiredateS = hiredateS;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getHiredateS() {
		return hiredateS;
	}

	public void setHiredateS(String hiredateS) {
		this.hiredateS = hiredateS;
	}
	
	

}
