package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Employee;

public interface EmployeeRepository 
        extends JpaRepository<Employee, Integer>{

    @Query("SELECT e FROM Employee e JOIN FETCH e.dept WHERE e.empId = :id")
    Optional<Employee> findByIdWithDept(@Param("id") Integer id);

    
    @Query("SELECT e FROM Employee e JOIN FETCH e.dept")
    List<Employee> findAllWithDept();


    @Query("SELECT e.empName, d.deptManager, d.deptName " +
           "FROM Employee e JOIN e.dept d")
    List<Object[]> getEmpDeptMg();


    @Query("SELECT COUNT(e), d.deptName " +
           "FROM Employee e JOIN e.dept d GROUP BY d.deptName")
    List<Object[]> getEmpCountByDept();


    @Query("SELECT e FROM Employee e JOIN e.dept d " +
           "WHERE d.deptName = :deptName")
    List<Employee> getEmpByDeptName(
            @Param("deptName") String deptName);


    @Query("SELECT e.empId, e.empName, d.deptName " +
           "FROM Employee e JOIN e.dept d " +
           "JOIN e.empPhone p WHERE p = :phone")
    List<Object[]> getEmpByPhone(
            @Param("phone") String phone);
}