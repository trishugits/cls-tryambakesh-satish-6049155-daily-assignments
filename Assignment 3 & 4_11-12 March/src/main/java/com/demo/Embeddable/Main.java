package com.demo.Embeddable;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        System.out.println("Starting JPA Hibernate Application!!!");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Employee 1
        Employee1234 emp1 = new Employee1234();
        emp1.setName("Chirag");

        Address addr1 = new Address();
        addr1.setStreet("Sector 62");
        addr1.setCity("Noida");
        addr1.setState("UP");
        addr1.setPincode("201301");

        emp1.setAddress(addr1);
        em.persist(emp1);


        // Employee 2
        Employee1234 emp2 = new Employee1234();
        emp2.setName("Rahul");

        Address addr2 = new Address();
        addr2.setStreet("MG Road");
        addr2.setCity("Delhi");
        addr2.setState("Delhi");
        addr2.setPincode("110001");

        emp2.setAddress(addr2);
        em.persist(emp2);


        // Employee 3
        Employee1234 emp3 = new Employee1234();
        emp3.setName("Ananya");

        Address addr3 = new Address();
        addr3.setStreet("Park Street");
        addr3.setCity("Kolkata");
        addr3.setState("West Bengal");
        addr3.setPincode("700016");

        emp3.setAddress(addr3);
        em.persist(emp3);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}