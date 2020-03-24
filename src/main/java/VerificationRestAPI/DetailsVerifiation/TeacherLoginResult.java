package VerificationRestAPI.DetailsVerifiation;

public class TeacherLoginResult {

	private Boolean isloginsuccessful;

	public Boolean getIsloginsuccessful() {
		return isloginsuccessful;
	}

	public void setIsloginsuccessful(Boolean isloginsuccessful) {
		this.isloginsuccessful = isloginsuccessful;
	}
	
	@Override
	public String toString() {
		return "TeacherLoginResult [isloginsuccessful=" + isloginsuccessful + "]";
	}
	
}
