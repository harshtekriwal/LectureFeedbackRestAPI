package VerificationRestAPI.DetailsVerifiation;

public class StudentLoginResult {
	private Boolean isloginsuccessful;

	@Override
	public String toString() {
		return "StudentLoginResult [isloginsuccessful=" + isloginsuccessful + "]";
	}

	public Boolean getIsloginsuccessful() {
		return isloginsuccessful;
	}

	public void setIsloginsuccessful(Boolean isloginsuccessful) {
		this.isloginsuccessful = isloginsuccessful;
	}
	
}
