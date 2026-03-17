package cg.demo.jpahibernate;

import cg.demo.jpahibernate.entities.Employees;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

/**
 * Hello world!
 */
@SuppressWarnings("unused")
public class App {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		System.out.println("Starting JPA Hibernate Application!!!");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		Query query=em.createQuery("SELECT e FROM Employees e");
		query.getResultList().forEach(System.out::println);
//		Employees emp=new Employees();
//        emp.setId(501);
//        emp.setName("Broke");
//        emp.setSalary(12345.76);
//        emp.setDept("Admin");
//        Employees emp=new Employees();
//        emp.setId(501);
//        emp.setName("Park");
//        emp.setSalary(24545.76);
//        emp.setDept("HR");
        em.getTransaction().begin();
//        Employees emp=em.find(Employees.class,501);
//        System.out.println(emp);
		
//		Employees emp = new Employees();
//		emp.setId(51);
//		emp.setName("Clark Stokes");
//		emp.setSalary(56780.678);
//		emp.setDept("IT");
//		System.out.println(em.merge(emp));
		
//        Employees emp=em.find(Employees.class, 501);
//        System.out.println(emp);
//        
//        emp.setSalary(99999.99);
//        emp.setDept("Admin");
//        System.out.println(em.merge(emp));
//        
//        Employees emp1=em.find(Employees.class,51);
//        if(emp1!=null) {
//			em.remove(emp1);
//			System.out.println("Employee Record is Deleted Successfully");
//		}
//        else {
//        	System.out.println("Employee Record is Not Found");
//        }
        
        
//        em.remove(501);
        
        
//        em.persist(emp);
//        System.out.println("Employee Record is Inserted Successfully");
		em.getTransaction().commit();
		System.out.println("Ending JPA Hibernate Application!!!");
		em.close();
		emf.close();
	}
}


/*
package cg.demo.jpahibernate;

import cg.demo.jpahibernate.entities.Employees;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        System.out.println("Starting JPA Hibernate Application!!!");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
        EntityManager em = emf.createEntityManager();

        // Create a detached entity
        Employees emp = new Employees();
        emp.setId(501);
        emp.setName("Clark");
        emp.setSalary(45000);
        emp.setDept("IT");

        em.getTransaction().begin();

            // Trying to remove detached entity
            em.remove(emp);

        
        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Ending JPA Hibernate Application!!!");
    }
}




Starting JPA Hibernate Application!!!
Mar 10, 2026 2:39:31 PM org.hibernate.jpa.internal.util.LogHelper logPersistenceUnitInformation
INFO: HHH000204: Processing PersistenceUnitInfo [name: JPA-PU]
Mar 10, 2026 2:39:32 PM org.hibernate.Version logVersion
INFO: HHH000412: Hibernate ORM core version 6.5.1.Final
Mar 10, 2026 2:39:32 PM org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl lambda$normalizeConnectionAccessUserAndPass$6
WARN: HHH90000021: Encountered deprecated setting [javax.persistence.jdbc.user], use [jakarta.persistence.jdbc.user] instead
Mar 10, 2026 2:39:32 PM org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl lambda$normalizeConnectionAccessUserAndPass$12
WARN: HHH90000021: Encountered deprecated setting [javax.persistence.jdbc.password], use [jakarta.persistence.jdbc.password] instead
Mar 10, 2026 2:39:32 PM org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl normalizeDataAccess
WARN: HHH90000021: Encountered deprecated setting [javax.persistence.jdbc.url], use [jakarta.persistence.jdbc.url] instead
Mar 10, 2026 2:39:32 PM org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl normalizeDataAccess
WARN: HHH90000021: Encountered deprecated setting [javax.persistence.jdbc.driver], use [jakarta.persistence.jdbc.driver] instead
Mar 10, 2026 2:39:32 PM org.hibernate.cache.internal.RegionFactoryInitiator initiateService
INFO: HHH000026: Second-level cache disabled
Mar 10, 2026 2:39:33 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
WARN: HHH10001002: Using built-in connection pool (not intended for production use)
Mar 10, 2026 2:39:33 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001005: Loaded JDBC driver class: org.postgresql.Driver
Mar 10, 2026 2:39:33 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001012: Connecting with JDBC URL [jdbc:postgresql://localhost:5432/EMPLOYEEDB]
Mar 10, 2026 2:39:33 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001001: Connection properties: {password=****, user=postgres}
Mar 10, 2026 2:39:33 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
INFO: HHH10001003: Autocommit mode: false
Mar 10, 2026 2:39:33 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
INFO: HHH10001115: Connection pool size: 20 (min=1)
Mar 10, 2026 2:39:33 PM org.hibernate.engine.jdbc.dialect.internal.DialectFactoryImpl constructDialect
WARN: HHH90000025: PostgreSQLDialect does not need to be specified explicitly using 'hibernate.dialect' (remove the property setting and it will be selected by default)
Mar 10, 2026 2:39:35 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
INFO: HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
Mar 10, 2026 2:39:35 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@2bbb44da] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
Hibernate: select null,e1_0.dept,e1_0.name,e1_0.salary from Employees e1_0 where e1_0.id=?
Exception in thread "main" java.lang.IllegalArgumentException: Removing a detached instance cg.demo.jpahibernate.entities.Employees#501
	at org.hibernate.event.internal.DefaultDeleteEventListener.disallowDeletionOfDetached(DefaultDeleteEventListener.java:313)
	at org.hibernate.event.internal.DefaultDeleteEventListener.performDetachedEntityDeletionCheck(DefaultDeleteEventListener.java:301)
	at org.hibernate.event.internal.DefaultDeleteEventListener.deleteTransientInstance(DefaultDeleteEventListener.java:175)
	at org.hibernate.event.internal.DefaultDeleteEventListener.delete(DefaultDeleteEventListener.java:158)
	at org.hibernate.event.internal.DefaultDeleteEventListener.onDelete(DefaultDeleteEventListener.java:97)
	at org.hibernate.event.internal.DefaultDeleteEventListener.onDelete(DefaultDeleteEventListener.java:84)
	at org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)
	at org.hibernate.internal.SessionImpl.fireDelete(SessionImpl.java:963)
	at org.hibernate.internal.SessionImpl.delete(SessionImpl.java:894)
	at org.hibernate.internal.SessionImpl.remove(SessionImpl.java:2382)
	at cg.demo.jpahibernate.App.main(App.java:94)
*/
