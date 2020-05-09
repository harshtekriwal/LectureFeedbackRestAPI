package VerificationRestAPI.DetailsVerifiation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("postlecturehistory")
@Produces(MediaType.APPLICATION_JSON)
public class LectureHistoryAPI {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("submit")
	public LectureHistory lecturehistory(TeacherData data) {
	return DatabaseHelper(data);
	}
	
	public LectureHistory DatabaseHelper(TeacherData data) {
	List<LectureReviewDetails> alist= new ArrayList<LectureReviewDetails>();
	LectureHistory history= new LectureHistory();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/lecturereview","root","rambo");
	        Statement st=con.createStatement();
	        String sql="select lectureid,table1.semester,avg(knowledge),avg(communication),avg(clarity),lecturename,datetime,teacherid from (select * from lecture natural join studentreview natural join lecture_Batch)table1,studentdetails where table1.studentroll=studentdetails.Enrollment_no and table1.batch=studentdetails.batch  group by lectureid having teacherid="+data.getTeacherid();
		    ResultSet rs=st.executeQuery(sql);
		    while(rs.next()) {
			    LectureReviewDetails temp= new LectureReviewDetails();
			    Statement st2=con.createStatement();
			    String sql2="select batch from lecture natural join lecture_batch where lectureid="+rs.getInt(1);
			    ResultSet set=st2.executeQuery(sql2);
			    ArrayList<String>b= new ArrayList<String>();
			    while(set.next()) {
			    	System.out.println("wtf thhere is erorr");
			    	b.add(set.getString(1));
			    }
			    temp.setBatch(b);
		    	temp.setSemester(rs.getInt(2));
		    	temp.setKnowledge(rs.getFloat(3));
		    	temp.setClarity(rs.getFloat(5));
		    	temp.setCommunication(rs.getFloat(4));
		    	temp.setLecture_name(rs.getString(6));
		    	temp.setDate(rs.getTimestamp(7));
		    	alist.add(temp);
		    	System.out.println(temp);
		    }
		    history.setSuccess(true);
		    history.setLecture_history(alist);
			return history;

		}
		catch(Exception E){
			E.printStackTrace();
			history.setSuccess(false);
			return history;

	}
	}
}

