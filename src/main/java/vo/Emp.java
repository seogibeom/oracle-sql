package vo;

//	vo ( value Object 데이터 전송 객체를 구현할 때 사용)
//	Value Object는 주로 데이터를 캡슐화하고, 그 데이터에 대한 불변성을 유지하며, 관련된 메소드를 제공하여 객체를 쉽게 다루도록 도와주는 객체를 의미

//	> DTO ( Date Transfer Object ) ==
//	DTO는 주로 서비스 계층과 데이터 계층 간의 데이터 전달에 사용되는 객체를 의미
//	DTO는 데이터 구조를 간단하게 정의하고 캡슐화하여, 데이터를 쉽게 전달하고 관리할 수 있도록 도와줍
	
//	domain ( 속성값의범위 )	==
//	도메인(속성값의 범위)을 잘 정의하고 관리함으로써 애플리케이션의 데이터 무결성과 안정성을 유지할 수 있음
public class Emp {
	private int empNo;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private double sal;
	private double comm;
	private int deptno;
	private String pw;
	private int grade;
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
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
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
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
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
}
