package app.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class Database {

	// GLOBAL VARIABLES - DECLARATION
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	// MAIN CONSTRUCTOR
	public Database() {
		connectDB();
	}
	
	
	//SETTERS
	
	//CONNECTION
	public void setConn(Connection conn) {
		this.conn = conn;
	}


	//STATEMENT
	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}


	//RESULT
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	//GETTERS

	public Connection getConn() {
		return conn;
	}



	public Statement getStmt() {
		return stmt;
	}



	public ResultSet getRs() {
		return rs;
	}



	// DATABSE CONNECTION
	public void connectDB() {

		try {
			// Load the database driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dbServer = "jdbc:mysql://localhost:3306/ultravision"; 
			String user = "root";
			String password = "";

			// Get a connection to the database
			conn = DriverManager.getConnection(dbServer, user, password);

			// Get a statement from the connection
			stmt = conn.createStatement();

		} catch (SQLException se) {
			System.out.println("SQL Exception:");

			// Loop through the SQL Exceptions
			while (se != null) {
				System.out.println("State  : " + se.getSQLState());
				System.out.println("Message: " + se.getMessage());
				System.out.println("Error  : " + se.getErrorCode());

				se = se.getNextException();
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}