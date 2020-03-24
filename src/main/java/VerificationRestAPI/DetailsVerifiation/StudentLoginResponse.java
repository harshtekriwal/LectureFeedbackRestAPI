package VerificationRestAPI.DetailsVerifiation;

public class StudentLoginResponse {
	private StudentLoginResult result;
	private StudentData data;
	public StudentLoginResult getResult() {
		return result;
	}
	public void setResult(StudentLoginResult result) {
		this.result = result;
	}
	public StudentData getData() {
		return data;
	}
	public void setData(StudentData data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "StudentLoginResponse [result=" + result + ", data=" + data + "]";
	}
	

}
