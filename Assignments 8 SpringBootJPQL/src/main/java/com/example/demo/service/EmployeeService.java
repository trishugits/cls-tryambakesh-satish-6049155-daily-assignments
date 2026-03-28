package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;
import com.example.demo.exceptions.EmployeeIdNotFoundException;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;
    
    @Autowired
    private DepartmentRepository deptRepo;

    public Employee save(Employee emp){

        Integer deptId = emp.getDept().getDeptId();

        Department dept = deptRepo.findById(deptId).orElseThrow(() ->
                        new RuntimeException("Department not found"));
        emp.setDept(dept);
        return repo.save(emp);
    }

    public List<Employee> getAll(){
        return repo.findAll();
    }

    public Employee getById(Integer id){

        Optional<Employee> emp = repo.findById(id);

        if(emp.isPresent())
            return emp.get();
        else
            throw new EmployeeIdNotFoundException(
                    "Employee not found  with id : " + id);
    }

    public List<Object[]> getEmpDeptMg(){
        return repo.getEmpDeptMg();
    }

    public List<Object[]> getCount(){
        return repo.getEmpCountByDept();
    }

    public List<Employee> getByDept(String dept){
        return repo.getEmpByDeptName(dept);
    }

    public List<Object[]> getByPhone(String phone){
        return repo.getEmpByPhone(phone);
    }
}