package javapack;
import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mysqlaccess {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;


	public static String encryptThisString(String input) 
    { 
        try { 
            // getInstance() method is called with algorithm SHA-512 
            MessageDigest md = MessageDigest.getInstance("SHA-512"); 
  
            // digest() method is called 
            // to calculate message digest of the input string 
            // returned as array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
  
            // Add preceding 0s to make it 32 bit 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
  
            // return the HashText 
            return hashtext; 
        } 
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 
	
	public boolean loginValidation(String user_email, String user_password) throws Exception {
		try {
			user_password = encryptThisString(user_password);
			Class.forName("com.mysql.jdbc.Driver");
			// setup connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/myusers", "root", "stavrosroots");
			statement = connect.createStatement();
			
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from myusers.users where email='" + user_email + "' and password='" + user_password + "'");
			
			if (resultSet.next()) {
				return true;
			}
			return false;

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}

	public boolean signUpValidation(String user_email, String user_password) throws Exception {
		try {
			user_password = encryptThisString(user_password);
			Class.forName("com.mysql.jdbc.Driver");
			// setup connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/myusers", "root", "stavrosroots");
			statement = connect.createStatement();
			
			// Result set get the result of the SQL query
			String query = "insert into myusers.users(email, password, movie_id) VALUES ('" + user_email + "','" + user_password+ "','')";
			String query1 = "select * from myusers.users where email='" + user_email + "'";
			resultSet = statement.executeQuery(query1);

			if (resultSet.next()) {
				return false;
			}
			statement.executeUpdate(query);
			return true;

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}

	public void bookmarkMovie(String user_email, String id) throws Exception {
		if(id=="") return;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// setup connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/myusers", "root", "stavrosroots");
			statement = connect.createStatement();
			
			String query;
			
			// Result set get the result of the SQL query
			String movieIDQuery = "SELECT movie_id FROM users WHERE email='"+ user_email+"'";
			resultSet = statement.executeQuery(movieIDQuery);
			resultSet.next();
			String movie_id = resultSet.getString("movie_id");
			if(!movie_id.contentEquals("")) {
				String appendedMovieID = movie_id.concat(","+id);
				query = "UPDATE users SET movie_id = '" + appendedMovieID + "'  WHERE email='" + user_email + "'";
			}else {
				query= "UPDATE users SET movie_id = '" + id + "'  WHERE email='" + user_email + "'";
			}
			
			statement.executeUpdate(query);

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}
	
	
	public String getBookmarks(String user_email) throws Exception {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			// setup connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/myusers", "root", "stavrosroots");
			statement = connect.createStatement();
			
			// Result set get the result of the SQL query
			String query = "select movie_id from users where email = '" + user_email + "'";
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX   USERS NAME: " + user_email + "   XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			resultSet = statement.executeQuery(query);
			
			String s = "" ;
			if(resultSet.next())
				s = resultSet.getString("movie_id");
			
			
			return s;

		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
		
		
	}
	
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
		}
	}

}
