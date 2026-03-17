package cg.demo.associationmapping;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Empl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    private String name;
    private double salary;

    @ElementCollection
    @CollectionTable(name="emp_mobiles", joinColumns=@JoinColumn(name="empId"))
    @Column(name="mobile")
    private Set<String> mobileNumbers;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="dept_id")
    private Dept dept;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
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

    public Set<String> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(Set<String> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    public Dept getDept() {
        return dept;
    }

    @Override
    public String toString() {
        return "Employee [id=" + empId +
               ", name=" + name +
               ", salary=" + salary +
               ", dept=" + dept.getName() +
               "]";
    }

	public void setDept(Dept dept) {
        this.dept = dept;
    }
}