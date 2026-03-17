package cg.demo.associationmapping;

import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while(true)
        {
            System.out.println("\n1 Insert Employee");
            System.out.println("2 Fetch All Employees");
            System.out.println("3 Count Employees per Department");
            System.out.println("4 Employees Under Department");
            System.out.println("5 Department Details by Mobile");
            System.out.println("6. Find Employee with Salary Greater Than");
            System.out.println("7 for exit");
            int ch = sc.nextInt();

            switch(ch)
            {

                case 1:

                    Empl e = new Empl();
                    Dept d = new Dept();

                    System.out.println("Enter Employee Name");
                    e.setName(sc.next());

                    System.out.println("Enter Salary");
                    e.setSalary(sc.nextDouble());

                    Set<String> mobiles = new HashSet<>();

                    System.out.println("Enter number of mobiles");
                    int n = sc.nextInt();

                    for(int i=0;i<n;i++)
                    {
                        mobiles.add(sc.next());
                    }

                    e.setMobileNumbers(mobiles);

                    System.out.println("Enter Department Name");
                    d.setName(sc.next());

                    System.out.println("Enter Manager Name");
                    d.setManagerName(sc.next());

                    e.setDept(d);

                    dao.insertEmployee(e);

                    break;

                case 2:

                    List<Empl> list = dao.getAllEmployees();

                    for(Empl emp : list)
                    {
                        System.out.println(
                                emp.getEmpId()+" "+
                                emp.getName()+" "+
                                emp.getSalary()+" "+
                                emp.getDept().getName()+" "+
                                emp.getDept().getManagerName()
                        );
                    }

                    break;

                case 3:

                    List<Object[]> result = dao.countEmployeesPerDept();

                    for(Object[] r : result)
                    {
                        System.out.println(r[0]+" -> "+r[1]);
                    }

                    break;

                case 4:

                    System.out.println("Enter Department Name");

                    List<Empl> emps =
                            dao.employeesByDepartment(sc.next());

                    for(Empl emp : emps)
                    {
                        System.out.println(emp.getName()+" "+emp.getSalary());
                    }

                    break;

                case 5:

                    System.out.println("Enter Mobile Number");

                    List<Object[]> data =
                            dao.findEmployeeByMobile(sc.next());

                    for(Object[] r : data)
                    {
                        System.out.println(
                                "EmpId:"+r[0]+
                                " Name:"+r[1]+
                                " Dept:"+r[2]+
                                " Manager:"+r[3]
                        );
                    }

                    break;
                case 6:
                    System.out.print("Enter salary value: ");
                    int k = sc.nextInt();

                    List<Empl> lis = dao.findEmployeeSalaryGreaterThan(k);

                    for(Empl e1 : lis) {
                        System.out.println(e1);
                        
                    }
                    break;

                case 7:
                	sc.close();
                    System.exit(0);
            }
        }
    }
}