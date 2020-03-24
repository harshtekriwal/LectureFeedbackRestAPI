package VerificationRestAPI.DetailsVerifiation;

public class AverageOverallRatings {
	private float communication;
	private float clarity;
	private float knowledge;
	boolean issuccess;
	int numberofstudents;
	public int getNumberofstudents() {
		return numberofstudents;
	}
	public void setNumberofstudents(int numberofstudents) {
		this.numberofstudents = numberofstudents;
	}
	public float getCommunication() {
		return communication;
	}
	public void setCommunication(float communication) {
		this.communication = communication;
	}
	public float getClarity() {
		return clarity;
	}
	public void setClarity(float clarity) {
		this.clarity = clarity;
	}
	public float getKnowledge() {
		return knowledge;
	}
	public void setKnowledge(float knowledge) {
		this.knowledge = knowledge;
	}
	public boolean isIssuccess() {
		return issuccess;
	}
	public void setIssuccess(boolean issuccess) {
		this.issuccess = issuccess;
	}
	@Override
	public String toString() {
		return "AverageOverallRatings [communication=" + communication + ", clarity=" + clarity + ", knowledge="
				+ knowledge + ", issuccess=" + issuccess + ", numberofstudents=" + numberofstudents + "]";
	}
	
	
}
