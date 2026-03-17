package ORM;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ORM_Operations {

    public static void main(String args[]) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("JPA-PU");

        EntityManager em = emf.createEntityManager();
        Employees emp1=new Employees();
        emp1.setId(101);
        emp1.setName("Broke");
        emp1.setSalary(12345.76);

        em.getTransaction().begin();

        Employees emp = new Employees(105,"Park",12000);
//      Employees emp = new Employees(3,"Clark",56780.678);
        em.persist(emp);
        em.persist(emp1);

        em.getTransaction().commit();

        em.close();
        emf.close();
        System.out.println("Employee Inserted Successfully");
    }
}