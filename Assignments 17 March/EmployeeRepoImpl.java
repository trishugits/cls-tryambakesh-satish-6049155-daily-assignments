package assignment6_17march;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepoImpl implements IEmployeeRepo {

    private Map<Integer, Employee> empMap = new HashMap<>();

    @Override
    public void insert(Employee emp) {
        empMap.put(emp.getEmployeeId(), emp);
    }

    @Override
    public List<Employee> getAll() {
        return new ArrayList<>(empMap.values());
    }

    @Override
    public Employee getById(int id) {
        return empMap.get(id);
    }

    @Override
    public boolean update(Employee emp) {
        if (empMap.containsKey(emp.getEmployeeId())) {
            empMap.put(emp.getEmployeeId(), emp);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return empMap.remove(id) != null;
    }
}