package VerificationRestAPI.DetailsVerifiation;

public class FeedbackDetails {
	int lectureid;
	@Override
	public String toString() {
		return "FeedbackDetails [lectureid=" + lectureid + ", studentroll=" + studentroll + ", knowledge=" + knowledge
				+ ", communication=" + communication + ", clarity=" + clarity + "]";
	}
	int studentroll;
	int knowledge;
	int communication;
	int clarity;
	public int getLectureid() {
		return lectureid;
	}
	public void setLectureid(int lectureid) {
		this.lectureid = lectureid;
	}
	public int getStudentroll() {
		return studentroll;
	}
	public void setStudentroll(int studentroll) {
		this.studentroll = studentroll;
	}
	public int getKnowledge() {
		return knowledge;
	}
	public void setKnowledge(int knowledge) {
		this.knowledge = knowledge;
	}
	public int getCommunication() {
		return communication;
	}
	public void setCommunication(int communication) {
		this.communication = communication;
	}
	public int getClarity() {
		return clarity;
	}
	public void setClarity(int clarity) {
		this.clarity = clarity;
	}
}
