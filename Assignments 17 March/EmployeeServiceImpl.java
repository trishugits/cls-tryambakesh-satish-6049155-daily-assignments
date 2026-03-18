package assignment6_17march;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepoImpl repo;

    @Override
    public void addEmployee(Employee emp) {
        repo.insert(emp);
        System.out.println("Employee added successfully!");
    }

    @Override
    public void displayAll() {
        Collection<Employee> list = repo.getAll();

        if (list.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            list.forEach(System.out::println);
        }
    }

    @Override
    public void displayById(int id) {
        Employee e = repo.getById(id);
        System.out.println(e != null ? e : "Employee not found!");
    }

    @Override
    public void updateEmployee(Employee emp) {
        System.out.println(
            repo.update(emp) ? "Updated successfully!" : "Employee not found!"
        );
    }

    @Override
    public void deleteEmployee(int id) {
        System.out.println(
            repo.delete(id) ? "Deleted successfully!" : "Employee not found!"
        );
    }
}