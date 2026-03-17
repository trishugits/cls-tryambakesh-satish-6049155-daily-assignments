package JDBC;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("unused")
public class Jdbc_Demo {

	public static void main(String args[]) throws ClassNotFoundException, SQLException {

		// Load PostgreSQL Driver
		Class.forName("org.postgresql.Driver");
		/*
		 * 
		 * String url = "jdbc:postgresql://localhost:5432/EMPLOYEEDB";
		 * 
		 * String user = "postgres";
		 * 
		 * String password="TIGER";
		 * 
		 * Connection con = DriverManager.getConnection(url, user, password); *
		 * 
		 * 
		 */
		// Create Connection
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/EMPLOYEEDB", "postgres",
				"TIGER");

		// Check connection
		if (con == null) {
			System.out.println("Connection Not Established!");
		}

//       Statement stmt = con.createStatement();
//       ResultSet rs = stmt.executeQuery("SELECT * FROM emp");     object or result set to store the data from database
		
		
		PreparedStatement pstmt = con.prepareStatement("SELECT * FROM emp");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			System.out.println("ID:" + rs.getInt("id") + "\tName:" + rs.getString("name") + "\tSalary:"
					+ rs.getDouble("salary") + "\tDepartment:" + rs.getString("dept"));
		}
		rs.close();
		
		
		PreparedStatement pstmt1 = con.prepareStatement("Delete from emp where name=?");
		pstmt1.setString(1, "Arjun");
		int rowsUpdated = pstmt1.executeUpdate();    // returns the number of rows affected by the delete operation integer value
		
		
//		String name = "Vikram";
//		int rowsUpdated = stmt.executeUpdate("Delete from emp where name='" + name + "'");
		if (rowsUpdated > 0) {
			System.out.println("Record Deleted Successfully!");
		} else {
			System.out.println("No Record Found!");
		}

// 		Close connection
//		stmt.close();
		
		
		PreparedStatement pstmt2 = con.prepareStatement("INSERT INTO emp (id, name, salary, dept,p_no) VALUES (?, ?, ?, ?,?)");
		pstmt2.setInt(1, 106);
		pstmt2.setString(2, "Arjun");
		pstmt2.setDouble(3, 55000);
		pstmt2.setString(4, "HR");
		pstmt2.setInt(5,1234567890);
		int rowsInserted = pstmt2.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("Record Inserted Successfully!");
		} else {
			System.out.println("Failed to Insert Record!");
		}
		
		PreparedStatement pstmt3 = con.prepareStatement("UPDATE emp SET salary=? WHERE id=?");
		pstmt3.setDouble(1, 65000.23);
		pstmt3.setInt(2, 104);
		int rowsUpdated2 = pstmt3.executeUpdate();
		if (rowsUpdated2 > 0) {
			System.out.println("Record Updated Successfully!");
		} else {
			System.out.println("No Record Found to Update!");
		}
		
		
		pstmt1.close();
		pstmt2.close();
		pstmt.close();
		con.close();
	}
}