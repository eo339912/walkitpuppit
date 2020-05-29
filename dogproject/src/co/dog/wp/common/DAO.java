package co.dog.wp.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	public Connection conn;
	private String Driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "wp";
	private String password = "wp";
	
	public DAO() {
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
}
