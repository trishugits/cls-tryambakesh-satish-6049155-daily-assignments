package JDBC;
import java.sql.*;
import java.util.*;
class Employee12 {

	private int id;
	private String name;
	private double salary;
	private String dept;
	private long p_no;
	
	public Employee12() {
	}

	public Employee12(int id, String name, double salary, String dept, long p_no) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dept = dept;
		this.p_no = p_no;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public long getP_no() {
		return p_no;
	}

	public void setP_no(long p_no) {
		this.p_no = p_no;
	}
}

public class Jdbc_Employees {
	 static final String URL = "jdbc:postgresql://localhost:5432/EMPLOYEEDB";
	 static final String USER = "postgres";
	 static final String PASS = "TIGER";

	public static void main(String args[]) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== EMPLOYEE MENU =====");
            System.out.println("1 Display Employees");
            System.out.println("2 Insert Employee");
            System.out.println("3 Delete Employee");
            System.out.println("4 Update Employee");
            System.out.println("5 Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    displayEmployees();
                    break;

                case 2:
                    insertEmployee(sc);
                    break;

                case 3:
                    deleteEmployee(sc);
                    break;

                case 4:
                    updateEmployee(sc);
                    break;

                case 5:
                    System.out.println("Program Exited");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);

        sc.close();
    }

    // DISPLAY
    public static void displayEmployees() {

        String sql = "SELECT * FROM emp";

        try (
                Connection con = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement pstmt = con.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
        ) {

            System.out.println("\n---- Employee Records ----");

            while (rs.next()) {

                Employee12 emp = new Employee12();

                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setDept(rs.getString("dept"));
                emp.setP_no(rs.getLong("p_no"));

                System.out.println(
                        emp.getId() + "\t" +
                        emp.getName() + "\t" +
                        emp.getSalary() + "\t" +
                        emp.getDept() + "\t" +
                        emp.getP_no());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // INSERT
    public static void insertEmployee(Scanner sc) {

        Employee12 emp = new Employee12();

        System.out.print("Enter ID: ");
        emp.setId(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter Name: ");
        emp.setName(sc.nextLine());

        System.out.print("Enter Salary: ");
        emp.setSalary(sc.nextDouble());
        sc.nextLine();

        System.out.print("Enter Department: ");
        emp.setDept(sc.nextLine());

        System.out.print("Enter Phone: ");
        emp.setP_no(sc.nextLong());

        String sql = "INSERT INTO emp VALUES(?,?,?,?,?)";

        try (
                Connection con = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement pstmt = con.prepareStatement(sql);
        ) {

            pstmt.setInt(1, emp.getId());
            pstmt.setString(2, emp.getName());
            pstmt.setDouble(3, emp.getSalary());
            pstmt.setString(4, emp.getDept());
            pstmt.setLong(5, emp.getP_no());

            int rows = pstmt.executeUpdate();

            if (rows > 0)
                System.out.println("Employee Inserted Successfully! at ID: " + emp.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteEmployee(Scanner sc) {

        System.out.print("Enter Employee ID to Delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM emp WHERE id=?";

        try (
                Connection con = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement pstmt = con.prepareStatement(sql);
        ) {

            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();

            if (rows > 0)
                System.out.println("Employee Deleted Successfully!");
            else
                System.out.println("Employee Not Found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

    // UPDATE
    public static void updateEmployee(Scanner sc) {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        System.out.print("Enter New Salary: ");
        double salary = sc.nextDouble();

        String sql = "UPDATE emp SET salary=? WHERE id=?";

        try (
                Connection con = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement pstmt = con.prepareStatement(sql);
        ) {

            pstmt.setDouble(1, salary);
            pstmt.setInt(2, id);

            int rows = pstmt.executeUpdate();

            if (rows > 0)
                System.out.println("Employee Updated Successfully!");
            else
                System.out.println("Employee Not Found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
