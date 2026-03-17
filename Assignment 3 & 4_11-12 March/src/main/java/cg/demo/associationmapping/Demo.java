package cg.demo.associationmapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.*;

public class Demo {

    public static void main(String args[]) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Customer c1 = new Customer();
        c1.setCustName("Ronit");

        Set<Product> p = new HashSet<>();

        Product p1 = new Product();
        p1.setpName("Mobile");
        p1.setPrice(100000);

        Product p2 = new Product();
        p2.setpName("Watch");
        p2.setPrice(10000);

        p.add(p1);
        p.add(p2);

        c1.setProducts(p);

        Customer c2 = new Customer();
        c2.setCustName("Akshay");

        Set<Product> ps = new HashSet<>();

        Product p3 = new Product();
        p3.setpName("Headphones");
        p3.setPrice(10004);

        Product p4 = new Product();
        p4.setpName("Microphone");
        p4.setPrice(20000);

        ps.add(p3);
        ps.add(p2);

        c2.setProducts(ps);

        em.persist(c1);
        em.persist(c2);

        em.getTransaction().commit();

        // JPQL Query
        TypedQuery<Customer> query = em.createQuery(
                "SELECT c FROM Customer c JOIN c.products p WHERE p.pName = :pname",
                Customer.class);

        query.setParameter("pname", "Watch");

        List<Customer> result = query.getResultList();

        for (Customer c : result) {
            System.out.println(c.getCustName());
        }
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);

        Root<Customer> root = cq.from(Customer.class);
        Join<Customer, Product> joinCP = root.join("products");

        Predicate pd = cb.equal(joinCP.get("pName"), "Mobile");

        cq.select(root).where(pd).distinct(true);

        TypedQuery<Customer> que = em.createQuery(cq);

        List<Customer> l = que.getResultList();

        for(Customer c : l) {
            System.out.println(c.getCustName());
        }
        
        List<Customer> customers = searchCustomers("Headphones", 0);

        for(Customer c : customers){
            System.out.println("Customer who purchased Headphones: " + c.getCustName());
        }
        List<Customer> cust = searchCustomers("", 10000);

        for(Customer c : cust){
            System.out.println("Customer who purchased above 10000: " + c.getCustName());
        }
        
        em.close();
        emf.close();
    }
    
    
    public static List<Customer> searchCustomers(String pnm, int price) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);

        Root<Customer> root = cq.from(Customer.class);
        Join<Customer, Product> joinCP = root.join("products");

        List<Predicate> pds = new ArrayList<>();

        if (pnm != null && !pnm.isEmpty()) {
            Predicate p = cb.equal(joinCP.get("pName"), pnm);
            pds.add(p);
        }

        if (price != 0) {
            Predicate p = cb.equal(joinCP.get("price"), price);
            pds.add(p);
        }

        cq.select(root)
          .where(pds.toArray(new Predicate[0]))
          .distinct(true);

        TypedQuery<Customer> query = em.createQuery(cq);
        List<Customer> result = query.getResultList();

        em.close();
        emf.close();

        return result;
    }
}