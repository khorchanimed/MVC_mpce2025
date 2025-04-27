package model ; 

import java.sql.*;

public class UserDB { 
 
private static Connection getConnection() {
	
	Connection cn =null ; 
	
	try {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "");
	} catch (Exception e) {
		e.printStackTrace();
	} 
	
	return cn ; 
	
} ; 
public static User getUser(String login, String pwd) {
	Connection cn =getConnection() ; 
	User u =null ; 
	
	try {
		PreparedStatement ps = cn.prepareStatement("select * from users where login =? and pwd =? ") ;
	    ps.setString(1, login);
	    ps.setString(2, pwd);
	    
	    ResultSet rs = ps.executeQuery();
	    
	    
	   if( rs.next())
	    
	    u = new User(rs.getInt(1) , rs.getString(2) , rs.getString(3),rs.getString(4), rs.getString(5)) ; 
	    
	    
	
	} catch (SQLException e) {
		e.printStackTrace();
	} 
	
	
	
	return u ;
	
} 
 
}