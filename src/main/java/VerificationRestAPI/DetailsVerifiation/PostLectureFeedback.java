package VerificationRestAPI.DetailsVerifiation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("postfeedback")
@Produces(MediaType.APPLICATION_JSON)
public class PostLectureFeedback {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("submit")
	public  FeedbackProblem postfeedback(FeedbackDetails feedback) {
		
		FeedbackProblem result=databasehelper(feedback);
		return result;
		
	}
	
	FeedbackProblem databasehelper(FeedbackDetails feedback) {
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/lecturereview","root","rambo");
	        Statement st=con.createStatement();
	       
			String sql="select count(*) from lecture where lectureid='"+feedback.getLectureid()+"'";
		    ResultSet rs=st.executeQuery(sql);
			rs.next();
		    int count=rs.getInt(1);
			if(count<=0) {
				return FeedbackProblem.WRONGCODE;
			}
			sql="select count(*) from studentreview where studentroll='"+feedback.getStudentroll()+"'AND lectureid='"+feedback.getLectureid()+"'";
			rs=st.executeQuery(sql);
			rs.next();
			count=rs.getInt(1);
			if(count>0) {
				return FeedbackProblem.ALREADYRATED;
			}
			sql="select studentdetails.batch as b , studentdetails.semester as sem ,lecture.semester as semm from studentdetails,lecture where lecture.lectureid='"+feedback.getLectureid()+"' and studentdetails.Enrollment_no='"+feedback.getStudentroll()+"'";
			rs=st.executeQuery(sql);
			rs.next();
			String b1=rs.getString(1);
			int sem1=rs.getInt(2);
			int sem2=rs.getInt(3);
			if(sem1!=sem2) {
				return FeedbackProblem.WRONGSEMBATCH;
			}
		
			sql="select batch from lecture_batch where lectureid="+feedback.getLectureid();
			rs=st.executeQuery(sql);
			boolean checkbatch=false;
			while(rs.next()) {
				System.out.println(rs.getString(1));
				if(rs.getString(1).equals(b1)) {
					checkbatch=true;
					break;
				}
			}
			if(checkbatch==false) {
				return FeedbackProblem.WRONGSEMBATCH;
			}
			Timestamp currenttime = new Timestamp(System.currentTimeMillis());
		    Timestamp lecturetime;
			sql="select datetime from lecture where lectureid='"+feedback.getLectureid()+"'";
			rs=st.executeQuery(sql);
			rs.next();
			lecturetime=rs.getTimestamp(1);
			long diff = currenttime.getTime() - lecturetime.getTime();
			long diffMinutes = diff / (60 * 1000);
			System.out.println(diffMinutes);
			if(diffMinutes>10) {
				return FeedbackProblem.TIMEEXCEEDED;
			}

	        PreparedStatement stmt=con.prepareStatement("insert into studentreview (lectureid,studentroll,knowledge,communication,clarity) values(?,?,?,?,?)");  
			stmt.setInt(1, feedback.getLectureid());
			stmt.setInt(2,feedback.getStudentroll());
			stmt.setInt(3,feedback.getKnowledge());
			stmt.setInt(4,feedback.getCommunication());
			stmt.setInt(5, feedback.getClarity());
			int i=stmt.executeUpdate(); 
			return FeedbackProblem.NOPROBLEM;
		}
		catch(Exception E){
			E.printStackTrace();
			return FeedbackProblem.SQLERROR;
		}
			}

	}


