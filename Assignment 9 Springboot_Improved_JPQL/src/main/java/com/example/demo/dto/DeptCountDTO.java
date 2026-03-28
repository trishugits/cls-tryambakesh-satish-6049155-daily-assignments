package com.example.demo.dto;

public class DeptCountDTO {

    private String deptName;
    private long count;

    public DeptCountDTO(String deptName, long count) {
        this.deptName = deptName;
        this.count = count;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}