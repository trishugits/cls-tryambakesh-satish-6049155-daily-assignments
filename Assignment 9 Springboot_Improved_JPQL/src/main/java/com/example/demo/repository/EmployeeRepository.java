package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.EmployeeDeptDTO;
import com.example.demo.dto.EmployeePhoneDTO;
import com.example.demo.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT new com.example.demo.dto.EmployeeDeptDTO(e.empName, d.deptName, d.deptManager) " +
           "FROM Employee e JOIN e.dept d")
    List<EmployeeDeptDTO> fetchAllEmployeeWithDept();

    @Query("SELECT e FROM Employee e JOIN FETCH e.dept d WHERE LOWER(d.deptName) = LOWER(:name)")
    List<Employee> findByDeptName(@Param("name") String name);

    @Query("SELECT new com.example.demo.dto.EmployeePhoneDTO(e.empId, e.empName, d.deptName, d.deptManager) " +
           "FROM Employee e JOIN e.dept d JOIN e.empPhone m WHERE m = :mobile")
    List<EmployeePhoneDTO> findByMobile(@Param("mobile") String mobile);
}