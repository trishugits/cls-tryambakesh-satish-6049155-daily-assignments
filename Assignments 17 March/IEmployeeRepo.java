package assignment6_17march;

import java.util.*;

public interface IEmployeeRepo {
	void insert(Employee emp);

    List<Employee> getAll();

    Employee getById(int id);

    boolean update(Employee emp);

    boolean delete(int id);
}
