package VerificationRestAPI.DetailsVerifiation;

public class StudentData {
	private int studentid;
	private String studentpassword;
	private String studentname;
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentpassword() {
		return studentpassword;
	}
	public void setStudentpassword(String studentpassword) {
		this.studentpassword = studentpassword;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	@Override
	public String toString() {
		return "StudentData [studentid=" + studentid + ", studentpassword=" + studentpassword + ", studentname="
				+ studentname + "]";
	}
	
}
