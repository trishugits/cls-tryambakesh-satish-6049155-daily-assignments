package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.EmployeeDeptDTO;
import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @Autowired
    private DepartmentService deptService;

    @PostMapping("/department")
    public ResponseEntity<?> addDepartment(@RequestBody @Valid Department dept) {
        Department saved = deptService.addDepartment(dept);
        return new ResponseEntity<>("Department added successfully with ID: " + saved.getDeptId(), HttpStatus.CREATED);
    }

    @PostMapping("/employee")
    public ResponseEntity<?> addEmployee(@RequestBody @Valid Employee emp) {

        Employee saved = empService.addEmployee(emp);

        return new ResponseEntity<>(
                "Employee added successfully with ID: " + saved.getEmpId(),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmployees() {
        List<EmployeeDeptDTO> list = empService.getAllEmployees();
        if (list.isEmpty()) {
            return new ResponseEntity<>("No employees found", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<?> getCount() {
        return new ResponseEntity<>(empService.getCount(), HttpStatus.OK);
    }

    @GetMapping("/department/{name}")
    public ResponseEntity<?> getByDepartment(@PathVariable String name) {
        return new ResponseEntity<>(empService.getByDept(name), HttpStatus.OK);
    }

    @GetMapping("/mobile/{number}")
    public ResponseEntity<?> getByMobile(@PathVariable String number) {
        return new ResponseEntity<>(empService.getByMobile(number), HttpStatus.OK);
    }
}