package VerificationRestAPI.DetailsVerifiation;

public class LectureDetails {

	String lecturename;
	public String getLecturename() {
		return lecturename;
	}
	public void setLecturename(String lecturename) {
		this.lecturename = lecturename;
	}
	public String getTeachername() {
		return teachername;
	}
	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}
	@Override
	public String toString() {
		return "LectureDetails [lecturename=" + lecturename + ", teachername=" + teachername + ", batch=" + batch
				+ ", semester=" + semester + ", teacherid=" + teacherid + "]";
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	String teachername;
	String batch;
	int semester;
	int teacherid;
}
