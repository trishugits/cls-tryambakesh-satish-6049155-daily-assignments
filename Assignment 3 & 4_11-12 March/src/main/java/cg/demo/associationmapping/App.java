package cg.demo.associationmapping;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
//        IndianPassport ip1 = new IndianPassport();
//        ip1.setPassportNo(123456);
//        ip1.setPassportExpiryDate(LocalDate.of(2030, 10, 12));
//        Citizen c1 = new Citizen();
//        c1.setAdharNo(123456789);
//        c1.setName("Ronit");
//        c1.setAddress("128/32 Pune");
//        ip1.setCititzen(c1);
//        
//        em.persist(ip1);
//        
//        
//        IndianPassport ip2 = new IndianPassport();
//        ip2.setPassportNo(651234);
//        ip2.setPassportExpiryDate(LocalDate.of(2033, 10, 12));
//        Citizen c2 = new Citizen();
//        c2.setAdharNo(234563629);
//        c2.setName("Akshay");
//        c2.setAddress("12/2 Delhi");
//        ip2.setCititzen(c2);
//        
//        em.persist(ip2);
//        
        
        
        Citizen c1 = new Citizen();
        c1.setAdharNo(123456789);
        c1.setName("Ronit");
        c1.setAddress("128/32 Pune");

        IndianPassport ip1 = new IndianPassport();
        ip1.setPassportNo(123456);
        ip1.setPassportExpiryDate(LocalDate.of(2030, 10, 12));

        c1.setIp(ip1);

        em.persist(c1);
        
        
        Citizen c2 = new Citizen();
        c2.setAdharNo(234563629);
        c2.setName("Akshay");
        c2.setAddress("12/2 Delhi");

        IndianPassport ip2 = new IndianPassport();
        ip2.setPassportNo(651234);
        ip2.setPassportExpiryDate(LocalDate.of(2033, 10, 12));

       c2.setIp(ip2);

        em.persist(c2);
        
        
        em.getTransaction().commit();
    }
}
