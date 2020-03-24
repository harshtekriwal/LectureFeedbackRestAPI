package VerificationRestAPI.DetailsVerifiation;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.HashSet;

@Path("login")
@Produces(MediaType.APPLICATION_JSON)
public class PostTeacherLoginResult {

	@POST
	@Path("teacher")
	@Produces(MediaType.APPLICATION_JSON)
	public TeacherLoginResponse checkinDatabase(TeacherData currentteacher) {
		TeacherLoginResult res=new TeacherLoginResult();
		TeacherLoginResponse response=new TeacherLoginResponse();
		Boolean result;
	    result=dbhelperTeacher(currentteacher);
	    res.setIsloginsuccessful(result);
		response.setResult(res);
		response.setData(currentteacher);
		System.out.println(response);
		return response;
	}

	private Boolean dbhelperTeacher(TeacherData currentteacher) {
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/lecturereview","root","rambo");
			Statement st=con.createStatement();
			String sql="select count(*),name from teacherdetails where ID='"+currentteacher.getTeacherid()+"'AND password='"+currentteacher.getTeacherpassword()+"'";
			ResultSet rs=st.executeQuery(sql);
			rs.next();
			int count=rs.getInt(1);
			if(count!=1) {
				return false;
			}
			String teachername=rs.getString(2);
			currentteacher.setTeachername(teachername);
			return true;
		}
		catch(Exception E){
			E.printStackTrace();
			return false;
		}
		
		
	}
}
