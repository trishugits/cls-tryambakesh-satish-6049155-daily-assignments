package cg.demo.associationmapping;

import jakarta.persistence.*;
import java.util.*;

public class App2 {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("JPA-PU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Department d = new Department();
        d.setDname("IT");
        d.setDmanager("Rahul");

        Employee e1 = new Employee();
        e1.setName("Amit");
        e1.setSalary(50000);
        e1.setD(d);

        Employee e2 = new Employee();
        e2.setName("Rohit");
        e2.setSalary(60000);
        e2.setD(d);

        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);

        d.setEmp(list);

        em.persist(d);

        Department d1 = new Department();
        d1.setDname("HR");
        d1.setDmanager("Aayush Saxena");

        Employee e3 = new Employee();
        e3.setName("Akshat");
        e3.setSalary(23000);
        e3.setD(d1);

        Employee e4 = new Employee();
        e4.setName("Bhavya");
        e4.setSalary(12000);
        e4.setD(d1);

        List<Employee> list2 = new ArrayList<>();
        list2.add(e3);
        list2.add(e4);

        d1.setEmp(list2);

        em.persist(d1);

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Data Inserted Successfully");
    }
}