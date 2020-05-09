package VerificationRestAPI.DetailsVerifiation;

import java.util.ArrayList;

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
	
	public ArrayList<String> getBatch() {
		return batch;
	}
	public void setBatch(ArrayList<String> batch) {
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
	ArrayList<String> batch;
	int semester;
	int teacherid;
}
