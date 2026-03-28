package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.*;
//import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    @NotBlank(message = "Employee name required")
    private String empName;

    @Min(value = 15000, message = "Salary must be >= 15000")
    private double empSal;

    @ElementCollection
    private List<String> empPhone;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    @NotNull(message = "Department required")
    private Department dept;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
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

    public List<String> getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(List<String> empPhone) {
        this.empPhone = empPhone;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }
}