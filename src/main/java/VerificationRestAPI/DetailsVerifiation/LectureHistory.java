package VerificationRestAPI.DetailsVerifiation;

import java.util.ArrayList;
import java.util.List;

public class LectureHistory {


@Override
	public String toString() {
		return "LectureHistory [lecture_history=" + lecture_history + ", isSuccess=" + isSuccess + "]";
	}
List<LectureReviewDetails> lecture_history;
	 boolean isSuccess;
	public List<LectureReviewDetails> getLecture_history() {
		return lecture_history;
	}
	public void setLecture_history(List<LectureReviewDetails> lecture_history) {
		this.lecture_history = lecture_history;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
}
