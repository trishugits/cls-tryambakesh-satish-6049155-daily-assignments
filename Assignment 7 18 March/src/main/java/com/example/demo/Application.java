package com.example.demo;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.entities.Trainee;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println("Application Started");

		TraineeServices trs = context.getBean(TraineeServices.class);

		Scanner sc = new Scanner(System.in);
		int choice = 1;

		while (choice != 0) {

			System.out.println("\n--- MENU ---");
			System.out.println("1. Add Trainee");
			System.out.println("2. View All");
			System.out.println("3. Find By Id");
			System.out.println("4. Delete By Id");
			System.out.println("5. Update Trainee");
			System.out.println("0. Exit");

			System.out.print("Enter choice: ");
			choice = sc.nextInt();

			if (choice == 1) {
				System.out.print("Enter Name: ");
				String name = sc.next();

				System.out.print("Enter Domain: ");
				String domain = sc.next();

				System.out.print("Enter Location: ");
				String location = sc.next();

				Trainee t = new Trainee(name, domain, location);
				trs.addTrainee(t);

				System.out.println("Trainee Added");

			} else if (choice == 2) {
				List<Trainee> list = trs.fetchAll();
				list.forEach(System.out::println);

			} else if (choice == 3) {
				System.out.print("Enter ID: ");
				int id = sc.nextInt();

				Optional<Trainee> t = trs.fetchById(id);
				System.out.println(t.orElse(null));

			} else if (choice == 4) {
				System.out.print("Enter ID: ");
				int id = sc.nextInt();

				trs.deleteById(id);
				System.out.println("Deleted");

			} else if (choice == 5) {
				System.out.print("Enter ID to update: ");
				int id = sc.nextInt();

				System.out.print("Enter New Name: ");
				String name = sc.next();

				System.out.print("Enter New Domain: ");
				String domain = sc.next();

				System.out.print("Enter New Location: ");
				String location = sc.next();

				Trainee t = new Trainee(name, domain, location);
				t.settId(id);
				trs.updateTrainee(t);
				System.out.println("Updated");

			} else if (choice == 0) {
				System.out.println("Exiting...");
			} else {
				System.out.println("Invalid choice");
			}
		}

		sc.close();
	}
}