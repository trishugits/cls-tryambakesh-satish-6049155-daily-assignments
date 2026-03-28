package com.example.demo.entities;

import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @NotBlank(message = "Employee name cannot be empty")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Employee name must contain only alphabets")
    private String empName;

    @Min(value = 10000, message = "Salary must be at least 10000")
    private double empSal;

    @ElementCollection
    private Set<
        @Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number must be 10 digits and start with 6-9")
        String
    > empPhone;

    @NotNull(message = "Department must be provided")
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department dept;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(double empSal) {
        this.empSal = empSal;
    }

    public Set<String> getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(Set<String> empPhone) {
        this.empPhone = empPhone;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }
}