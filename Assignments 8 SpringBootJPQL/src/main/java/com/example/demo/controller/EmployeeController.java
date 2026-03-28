package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;
import com.example.demo.exceptions.EmployeeIdNotFoundException;
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

    @PostMapping("/dept")
    public Department addDept(
            @Valid @RequestBody Department dept){

        return deptService.save(dept);
    }

    @PostMapping("/emp")
    public Employee addEmployee(
            @Valid @RequestBody Employee emp){

        return empService.save(emp);
    }

    @GetMapping("/emp")
    public List<Employee> getAll(){
        return empService.getAll();
    }

    @GetMapping("/emp/{id}")
    public Employee getById(@PathVariable Integer id){
        return empService.getById(id);
    }

    @GetMapping("/emp/deptmg")
    public List<Object[]> getEmpDeptMg(){
        return empService.getEmpDeptMg();
    }

    @GetMapping("/emp/countbydept")
    public List<Object[]> getCount(){
        return empService.getCount();
    }

    @GetMapping("/emp/deptname")
    public List<Employee> getByDept(
            @RequestParam String deptName){

        return empService.getByDept(deptName);
    }

    @GetMapping("/emp/byPhone")
    public List<Object[]> getByPhone(
            @RequestParam String phone){

        return empService.getByPhone(phone);
    }

    @ExceptionHandler(EmployeeIdNotFoundException.class)
    public ResponseEntity<String> handleNotFound(
            EmployeeIdNotFoundException ex){

        return new ResponseEntity<>(
                ex.getMessage(),
                HttpStatus.NOT_FOUND);
    }
    

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidation(
            MethodArgumentNotValidException ex){

        Map<String,String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
                    errors.put(error.getField(),error.getDefaultMessage());
                });

        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
}