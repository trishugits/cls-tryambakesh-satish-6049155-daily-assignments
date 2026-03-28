package com.example.demo.dto;

public class EmployeePhoneDTO {

    private int empId;
    private String empName;
    private String deptName;
    private String managerName;

    public EmployeePhoneDTO(int empId, String empName, String deptName, String managerName) {
        this.empId = empId;
        this.empName = empName;
        this.deptName = deptName;
        this.managerName = managerName;
    }

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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}