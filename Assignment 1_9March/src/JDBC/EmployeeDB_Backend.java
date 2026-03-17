package JDBC;

import java.sql.*;
import java.util.*;

public class EmployeeDB_Backend {

    private Connection con;

    public EmployeeDB_Backend() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/EMPLOYEEDB",
                    "postgres",
                    "TIGER"
            );
        } catch (Exception e) {
            System.err.println("Connection Error: " + e.getMessage());
        }
    }

    public boolean createTableIfNotExists(String tableName) {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (" +
                "ID INT PRIMARY KEY," +
                "NAME VARCHAR(50)," +
                "SALARY DOUBLE PRECISION," +
                "DEPT VARCHAR(50)," +
                "P_NO BIGINT)";
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            return true;
        } catch (Exception e) {
            System.err.println("Table creation error: " + e.getMessage());
            return false;
        }
    }

    public boolean dropTable() {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DROP TABLE IF EXISTS EMP");
            stmt.close();
            return true;
        } catch (Exception e) {
            System.err.println("Drop Table Error: " + e.getMessage());
            return false;
        }
    }

    public List<Employee> fetchAll() {
        List<Employee> list = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM EMP");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getInt("ID"));
                emp.setEname(rs.getString("NAME"));
                emp.setSalary(rs.getDouble("SALARY"));
                emp.setDept(rs.getString("DEPT"));
                emp.setPhoneNo(rs.getLong("P_NO"));
                list.add(emp);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.err.println("Fetch All Error: " + e.getMessage());
        }
        return list;
    }

    public Employee insertEmployee(Employee emp) {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO EMP (ID,NAME,SALARY,DEPT,P_NO) VALUES (?,?,?,?,?) RETURNING *"
            );

            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getEname());
            ps.setDouble(3, emp.getSalary());
            ps.setString(4, emp.getDept());
            ps.setLong(5, emp.getPhoneNo());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Employee inserted = new Employee();
                inserted.setId(rs.getInt("ID"));
                inserted.setEname(rs.getString("NAME"));
                inserted.setSalary(rs.getDouble("SALARY"));
                inserted.setDept(rs.getString("DEPT"));
                inserted.setPhoneNo(rs.getLong("P_NO"));
                rs.close();
                ps.close();
                return inserted;
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            System.err.println("Insert Error: " + e.getMessage());
        }
        return null;
    }
    public double updateSalary(int id, double newSalary) {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE EMP SET SALARY=? WHERE ID=?"
            );
            ps.setDouble(1, newSalary);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            ps.close();
            if (rows > 0) return newSalary;
        } catch (Exception e) {
            System.err.println("Update Error: " + e.getMessage());
        }
        return -1;
    }

    public Employee fetchById(int id) {
        Employee emp = null;
        try {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM EMP WHERE ID=?"
            );
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                emp = new Employee();
                emp.setId(rs.getInt("ID"));
                emp.setEname(rs.getString("NAME"));
                emp.setSalary(rs.getDouble("SALARY"));
                emp.setDept(rs.getString("DEPT"));
                emp.setPhoneNo(rs.getLong("P_NO"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.err.println("Fetch By ID Error: " + e.getMessage());
        }
        return emp;
    }

    public Employee deleteById(int id) {
        Employee emp = fetchById(id);
        if (emp != null) {
            try {
                PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM EMP WHERE ID=?"
                );
                ps.setInt(1, id);
                ps.executeUpdate();
                ps.close();
            } catch (Exception e) {
                System.err.println("Delete Error: " + e.getMessage());
            }
        }
        return emp;
    }

    public void close() {
        try {
            if (con != null) con.close();
        } catch (Exception e) {
            System.err.println("Connection Close Error: " + e.getMessage());
        }
    }
}