package VerificationRestAPI.DetailsVerifiation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("postindividualrating")
@Produces(MediaType.APPLICATION_JSON)
public class PostIndividualLectureFeedback {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("submit")
	public  AverageOverallRatings postfeedback(IndividualLectureDetails details) {
		
		AverageOverallRatings ratings=databasehelper(details);
		return ratings;
		
	}
	public AverageOverallRatings databasehelper(IndividualLectureDetails details) {
		AverageOverallRatings rating= new AverageOverallRatings();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/lecturereview","root","rambo");
	        Statement st=con.createStatement();
	       // String sql="select count(*),avg(knowledge),avg(communication),avg(clarity) from studentreview NATURAL JOIN lecture where datetime like'"+details.getYear()+"'-'"+details.getMonth()+"'-'"+details.getDay()+"'%";
	        System.out.println(details.getMonth());
	        System.out.println(details.getDay());
	        System.out.println(details.getYear());
	        String sql="select count(*) from lecture natural join lecture_batch where lecturename='"+details.getLecturename()+"' and teacherid="+details.getTeacherid()+" and batch='"+details.getBatch()+"' and semester="+details.getSemester()+" and datetime like '"+details.getYear()+"-"+details.getMonth()+"-"+details.getDay()+"%'";
		    ResultSet rs=st.executeQuery(sql);
		    rs.next();
		    if(rs.getInt(1)==0) {
		    	rating.setIssuccess(false);
		    	return rating;
		    }
 
	        sql="select count(*),avg(knowledge),avg(communication),avg(clarity) from (select * from studentreview NATURAL JOIN lecture natural join lecture_batch)table1,studentdetails where table1.batch=studentdetails.batch and table1.studentroll=studentdetails.Enrollment_no and lecturename='"+details.getLecturename()+"' and teacherid="+details.getTeacherid()+" and table1.batch='"+details.getBatch()+"' and table1.semester="+details.getSemester()+" and datetime like '"+details.getYear()+"-"+details.getMonth()+"-"+details.getDay()+"%'";
		    rs=st.executeQuery(sql);
			rs.next();
			rating.setIssuccess(true); 
			rating.setNumberofstudents(rs.getInt(1));
			rating.setKnowledge(rs.getFloat(2));
			rating.setCommunication(rs.getFloat(3));
			rating.setClarity(rs.getFloat(4));
			System.out.println("SUCCESS");
	        return rating;
		}
		catch(Exception E){
			E.printStackTrace();
			rating.setIssuccess(false);
			return rating;
		}
		
	}
}
