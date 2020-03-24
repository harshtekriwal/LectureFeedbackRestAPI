package VerificationRestAPI.DetailsVerifiation;

import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TeacherLoginResponse {
	@Override
	public String toString() {
		return "TeacherLoginResponse [result=" + result + ", data=" + data + "]";
	}
	private TeacherLoginResult result;
	private TeacherData data;
	public TeacherLoginResult getResult() {
		return result;
	}
	public void setResult(TeacherLoginResult result) {
		this.result = result;
	}
	public TeacherData getData() {
		return data;
	}
	public void setData(TeacherData data) {
		this.data = data;
	}
	
	
}
