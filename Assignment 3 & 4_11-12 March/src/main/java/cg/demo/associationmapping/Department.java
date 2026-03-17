package cg.demo.associationmapping;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptid;
	private String dname;
	private String dmanager;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="d")
	private List<Employee> emp = new ArrayList<>();
	
	public List<Employee> getEmp() {
		return emp;
	}
	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDmanager() {
		return dmanager;
	}
	public void setDmanager(String dmanager) {
		this.dmanager = dmanager;
	}
}
