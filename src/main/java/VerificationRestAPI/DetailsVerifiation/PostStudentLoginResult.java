package VerificationRestAPI.DetailsVerifiation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("login")
@Produces(MediaType.APPLICATION_JSON)
public class PostStudentLoginResult {

	@POST
	@Path("student")
	@Produces(MediaType.APPLICATION_JSON)
	public StudentLoginResponse checkinDatabase(StudentData currentstudent) {
		
		StudentLoginResult res=new StudentLoginResult();
		StudentLoginResponse response=new StudentLoginResponse();
		Boolean result;
	    result=dbhelperStudent(currentstudent);
	    res.setIsloginsuccessful(result);
		response.setResult(res);
		response.setData(currentstudent);
		System.out.println(response);
		System.out.println("wow");
		return response;

		
		
	}
	private Boolean dbhelperStudent(StudentData currentstudent) {
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/lecturereview","root","rambo");
			Statement st=con.createStatement();
			String sql="select count(*),name from studentdetails where Enrollment_no='"+currentstudent.getStudentid()+"'AND password='"+currentstudent.getStudentpassword()+"'";
			ResultSet rs=st.executeQuery(sql);
			rs.next();
			int count=rs.getInt(1);
			if(count!=1) {
				return false;
			}
			String studentname=rs.getString(2);
			currentstudent.setStudentname(studentname);
			return true;
		}
		catch(Exception E){
			E.printStackTrace();
			return false;
		}
		
		
	
}
}
