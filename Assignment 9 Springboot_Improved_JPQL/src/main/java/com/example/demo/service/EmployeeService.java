package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DeptCountDTO;
import com.example.demo.dto.EmployeeDeptDTO;
import com.example.demo.dto.EmployeePhoneDTO;
import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;
import com.example.demo.exceptions.DepartmentNameNotFoundException;
import com.example.demo.exceptions.MobileNumberDoesNotExistsForEmployeeException;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;

    @Autowired
    private DepartmentRepository deptRepo;

    public Employee addEmployee(Employee emp) {
        int deptId = emp.getDept().getDeptId();

        Department dept = deptRepo.findById(deptId)
                .orElseThrow(() -> new DepartmentNameNotFoundException(
                        "Department not found with id: " + deptId));

        emp.setDept(dept);
        return empRepo.save(emp);
    }

    public List<EmployeeDeptDTO> getAllEmployees() {
        return empRepo.fetchAllEmployeeWithDept();
    }

    public List<DeptCountDTO> getCount() {
        return deptRepo.countEmployees();
    }

    public List<Employee> getByDept(String name) {
        List<Employee> list = empRepo.findByDeptName(name);
        if (list.isEmpty()) {
            throw new DepartmentNameNotFoundException(
                    "No employees found for department: " + name);
        }
        return list;
    }

    public List<EmployeePhoneDTO> getByMobile(String mobile) {
        List<EmployeePhoneDTO> list = empRepo.findByMobile(mobile);
        if (list.isEmpty()) {
            throw new MobileNumberDoesNotExistsForEmployeeException(
                    "No employee found with mobile number: " + mobile);
        }
        return list;
    }
}