package VerificationRestAPI.DetailsVerifiation;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("generatecode")
@Produces(MediaType.APPLICATION_JSON)
public class PostLectureCode {

	@POST
	@Path("seecode")
	@Produces(MediaType.APPLICATION_JSON)
	public int getlectureCode(LectureDetails lecture) {
		
		int code=databasehelper(lecture);
		return code;
		
	}
	private int databasehelper(LectureDetails lecture) {
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/lecturereview","root","rambo");
	        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	        PreparedStatement stmt=con.prepareStatement("insert into lecture (lecturename,teachername,teacherid,datetime,semester) values(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);  
			stmt.setString(1, lecture.getLecturename());
			stmt.setString(2, lecture.getTeachername());
			stmt.setInt(3,lecture.getTeacherid());
			stmt.setTimestamp(4, timestamp);
			stmt.setInt(5,lecture.getSemester());
			stmt.executeUpdate(); 
			ResultSet rs;
			rs = stmt.getGeneratedKeys();
            rs.next();
            int code=rs.getInt(1);
            for(String b:lecture.getBatch()) {
            stmt=con.prepareStatement("insert into lecture_batch (lectureid,batch) values (?,?)");
            stmt.setInt(1,code);
            stmt.setString(2,b);
            stmt.executeUpdate();
            }
            return code;
		}
		catch(Exception E){
			E.printStackTrace();
			return -1;
		}
			}

}
