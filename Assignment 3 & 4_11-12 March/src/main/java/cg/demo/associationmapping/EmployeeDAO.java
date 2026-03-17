package cg.demo.associationmapping;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.*;

public class EmployeeDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("JPA-PU");

    EntityManager em = emf.createEntityManager();

    public void insertEmployee(Empl e)
    {
        em.getTransaction().begin();
        em.persist(e.getDept());
        em.persist(e);
        em.getTransaction().commit();
    }

    public List<Empl> getAllEmployees()
    {
    	
    	CriteriaBuilder cb=em.getCriteriaBuilder();
    	CriteriaQuery<Empl> cq=cb.createQuery(Empl.class);
    	Root<Empl> root=cq.from(Empl.class);
    	cq.select(root);
    	TypedQuery<Empl> query=em.createQuery(cq);
    	List<Empl> employee=query.getResultList();
    	return employee;
//        return em.createQuery(
//                "SELECT e FROM Empl e",
//                Empl.class
//        ).getResultList();
    }

	public List<Object[]> countEmployeesPerDept()
    {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

	    Root<Empl> root = cq.from(Empl.class);

	    cq.multiselect(
	            root.get("dept").get("name"),
	            cb.count(root)
	    );

	    cq.groupBy(root.get("dept").get("name"));

	    TypedQuery<Object[]> query = em.createQuery(cq);

	    return query.getResultList();
//        return em.createQuery(
//                "SELECT e.dept.name, COUNT(e) FROM Empl e GROUP BY e.dept.name"
//        ).getResultList();
    }

    public List<Empl> employeesByDepartment(String deptName)
    {
    	
    	CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Empl> cq = cb.createQuery(Empl.class);

        Root<Empl> root = cq.from(Empl.class);

        Predicate p = cb.equal(root.get("dept").get("name"), deptName);

        cq.select(root).where(p);

        TypedQuery<Empl> query = em.createQuery(cq);

        return query.getResultList();
//        return em.createQuery(
//                "SELECT e FROM Empl e WHERE e.dept.name=:d",
//                Empl.class
//        ).setParameter("d", deptName)
//         .getResultList();
    }

//    @SuppressWarnings("unchecked")
	public List<Object[]> findEmployeeByMobile(String mobile)
    {
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

	    Root<Empl> root = cq.from(Empl.class);
	    
	    Join<Empl,String> mobileJoin = root.join("mobileNumbers");

	    Predicate p = cb.equal(mobileJoin, mobile);

	    cq.multiselect(
	            root.get("empId"),
	            root.get("name"),
	            root.get("dept").get("name"),
	            root.get("dept").get("managerName")
	    ).where(p);

	    TypedQuery<Object[]> query = em.createQuery(cq);

	    return query.getResultList();
//        return em.createQuery(
//                "SELECT e.empId,e.name,e.dept.name,e.dept.managerName FROM Empl e JOIN e.mobileNumbers m WHERE m=:mob"
//        ).setParameter("mob", mobile)
//         .getResultList();
    }
	public List<Empl>findEmployeeSalaryGreaterThan(int k){
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<Empl> cq=cb.createQuery(Empl.class);
		Root<Empl> root=cq.from(Empl.class);
		Predicate salp=cb.gt(root.get("salary"),k);
		cq.select(root).where(salp);
		List<Empl>li=em.createQuery(cq).getResultList();
		return li;
	}
}