package JDBC;

import java.util.*;

public class EmployeeDB_UI {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDB_Backend db = new EmployeeDB_Backend();
        int choice = 0;

        while (choice != 8) {

            System.out.println("\n1. Create Table");
            System.out.println("2. Insert Employee");
            System.out.println("3. View All Employees");
            System.out.println("4. Fetch Employee by ID");
            System.out.println("5. Update Salary");
            System.out.println("6. Delete Employee");
            System.out.println("7. Drop Table");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:

                System.out.print("Enter table name: ");
                String tableName = sc.next();

                if (!db.createTableIfNotExists(tableName))
                    System.out.println("Table created or already exists");

                break;

                case 2:

                    Employee emp = new Employee();

                    System.out.print("ID: ");
                    emp.setId(sc.nextInt());

                    System.out.print("Name: ");
                    emp.setEname(sc.next());

                    System.out.print("Salary: ");
                    emp.setSalary(sc.nextDouble());

                    System.out.print("Dept: ");
                    emp.setDept(sc.next());

                    System.out.print("Phone: ");
                    emp.setPhoneNo(sc.nextLong());

                    Employee inserted = db.insertEmployee(emp);

                    if (inserted != null)
                        System.out.println("Inserted: " + inserted);

                    break;

                case 3:

                    List<Employee> all = db.fetchAll();

                    if (all.isEmpty()) {
                        System.out.println("No Employees Found");
                    } else {
                        for (Employee e : all) {
                            System.out.println(e);
                        }
                    }

                    break;

                case 4:

                    System.out.print("Enter ID: ");
                    int fid = sc.nextInt();

                    Employee fetched = db.fetchById(fid);

                    if (fetched != null)
                        System.out.println(fetched);
                    else
                        System.out.println("Employee Not Found");

                    break;

                case 5:

                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();

                    Employee empToUpdate = db.fetchById(uid);

                    if (empToUpdate != null) {

                        System.out.print("New Salary: ");
                        double newSal = sc.nextDouble();

                        double updated = db.updateSalary(uid, newSal);

                        if (updated != -1) {

                            Employee updatedEmp = db.fetchById(uid);
                            System.out.println("Updated Record:");
                            System.out.println(updatedEmp);
                        }

                    } else {
                        System.out.println("Employee Not Found");
                    }

                    break;

                case 6:

                    System.out.print("Enter ID: ");
                    int did = sc.nextInt();

                    Employee deleted = db.deleteById(did);

                    if (deleted != null)
                        System.out.println("Deleted: " + deleted.getId());
                    else
                        System.out.println("Employee Not Found");

                    break;

                case 7:

                    if (db.dropTable())
                        System.out.println("Table dropped successfully");

                    break;

                case 8:

                    db.close();
                    System.out.println("Exited");

                    break;

                default:
                    System.err.println("Invalid Choice");
            }
        }

        sc.close();
    }
}