package model;

import java.sql.*;
import java.util.ArrayList;

public class ArticleDB {
	

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
	

public static void ajouterArticle(Article art) {
	
	Connection cn = getConnection() ; 
	
	try {
		PreparedStatement ps= cn.prepareStatement("insert into articles(nom,prix) values (?,?)");
	    ps.setString(1, art.getNom());
	    ps.setDouble(2, art.getPrix());
	    
	    ps.executeUpdate();
	    
	    cn.close();
	
	
	} catch (SQLException e) {


		e.printStackTrace();
	}
	
	
} ; 
 
public static ArrayList<Article> getAllArticles() {
	
	Connection cn = getConnection() ; 
	ArrayList<Article> liste = new ArrayList<Article>() ; 
	
	
	try {
		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery("select * from articles") ;
		
		while (rs.next()) {
			liste.add(new Article(rs.getInt(1),rs.getString(2),rs.getDouble(3))) ; 
		}
		
		cn.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	} 
	
	return liste ; 
	
	
	
	
} 
public static Article getArticleById(int id) {
	Connection cn =getConnection() ; 
	Article a =null ; 
	
	try {
		PreparedStatement ps = cn.prepareStatement("select * from articles where id =? ") ;
	    ps.setInt(1, id);
	    
	    ResultSet rs = ps.executeQuery();
	    
	    
	    rs.next() ; 
	    
	    a= new Article(rs.getInt(1) , rs.getString(2) , rs.getDouble(3)) ; 
	    
	
	} catch (SQLException e) {
		e.printStackTrace();
	} 
	
	
	
	return a ;
	
} 
public static void updateArticle(Article art) {
	
	Connection cn = getConnection() ; 
	
	try {
		
		PreparedStatement ps = cn.prepareStatement("update articles set nom=? , prix=? where id=?");
		ps.setString(1, art.getNom());
		ps.setDouble(2, art.getPrix());
		ps.setInt(3, art.getId());
		ps.executeUpdate();
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	
} 
public static void supprimerArticle(int id) {
	
	
	Connection cn = getConnection() ; 
	
	try {
		
		PreparedStatement ps = cn.prepareStatement("delete from articles where id=?");
		
		ps.setInt(1, id);
		ps.executeUpdate();
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
} 




}
