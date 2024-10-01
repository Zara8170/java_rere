package dbpackage;
import java.sql.Date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class LoginMenuManager {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/ibrary?serverTimeZone=UTC";
	private String id = "root";
	private String pw = "1234";
	
	private Connection conn = null;
	private Statement stmt = null;
	
	public LoginMenuManager() {
	}
	
	public void initDBConnect() {
		try {
			Class.forName(driver);
			this.conn = DriverManager.getConnection(this.url, this.id, this.pw);
			this.stmt = conn.createStatement();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) { 
			e.printStackTrace();
		}
	}
	
	public boolean registerUser(User user) {
		String sql = "insert into user values(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getPhone());
			pstmt.setInt(5, user.getAddress_id());
			pstmt.setDate(6, user.getBirthyear());
			pstmt.executeUpdate();
			return true;
		} catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean loginUser(String email, String password) {
		String sql = "select * from user where email =? and password = ?";
		try (PreparedStatement pstmt = this.conn.prepareStatement(sql);){
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			try (ResultSet rs = pstmt.executeQuery()){
				return rs.next();
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public void releaseDB() {
		try {
			this.conn.close();
			this.stmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
