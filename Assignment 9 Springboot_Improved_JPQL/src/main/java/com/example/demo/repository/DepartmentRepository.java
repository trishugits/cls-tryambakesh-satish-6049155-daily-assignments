package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.DeptCountDTO;
import com.example.demo.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department findByDeptNameIgnoreCase(String deptName);

    @Query("SELECT new com.example.demo.dto.DeptCountDTO(d.deptName, COUNT(e)) " +
           "FROM Department d LEFT JOIN d.employees e GROUP BY d.deptName")
    List<DeptCountDTO> countEmployees();
}