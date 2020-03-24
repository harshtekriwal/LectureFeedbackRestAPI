package VerificationRestAPI.DetailsVerifiation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("postaveragerating")
@Produces(MediaType.APPLICATION_JSON)
public class OverallRatingAPI {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("submit")
	public  AverageOverallRatings postfeedback(TeacherData data) {
		
		AverageOverallRatings ratings=databasehelper(data);
		return ratings;
		
	}
	
	public AverageOverallRatings databasehelper(TeacherData data) {
		AverageOverallRatings rating= new AverageOverallRatings();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/lecturereview","root","rambo");
	        Statement st=con.createStatement();
	        String sql="select count(*),avg(knowledge),avg(communication),avg(clarity) from studentreview NATURAL JOIN lecture where teacherid='"+data.getTeacherid()+"'";
		    ResultSet rs=st.executeQuery(sql);
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
