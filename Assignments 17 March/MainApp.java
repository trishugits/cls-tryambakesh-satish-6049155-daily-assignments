package assignment6_17march;


import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Component
public class MainApp {

    @Autowired
    private EmployeeService service;

    public void run() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Insert");
            System.out.println("2. Fetch All");
            System.out.println("3. Fetch By ID");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double sal = sc.nextDouble();

                    service.addEmployee(new Employee(id, name, sal));
                    break;

                case 2:
                    service.displayAll();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    service.displayById(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String uname = sc.nextLine();

                    System.out.print("Enter New Salary: ");
                    double usal = sc.nextDouble();

                    service.updateEmployee(new Employee(uid, uname, usal));
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    service.deleteEmployee(sc.nextInt());
                    break;
            }

        } while (choice != 6);

        sc.close();
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
		ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        MainApp app = context.getBean(MainApp.class);
        app.run();
    }
}