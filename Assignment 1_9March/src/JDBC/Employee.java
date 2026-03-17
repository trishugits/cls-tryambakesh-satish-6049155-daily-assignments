package JDBC;

public class Employee {

    private int id;
    private String ename;
    private double salary;
    private String dept;
    private long phoneNo;

    public Employee() {
    }

    public Employee(int id, String ename, double salary, String dept, long phoneNo) {
        this.id = id;
        this.ename = ename;
        this.salary = salary;
        this.dept = dept;
        this.phoneNo = phoneNo;
    }

    public int getId() {
        return id;
    }

    public String getEname() {
        return ename;
    }

    public double getSalary() {
        return salary;
    }

    public String getDept() {
        return dept;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return id + " " + ename + " " + salary + " " + dept + " " + phoneNo;
    }
}