package cg.demo.associationmapping;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;

    private String name;
    private String managerName;

    @OneToMany(mappedBy="dept", cascade=CascadeType.ALL)
    private Set<Empl> employees;

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Set<Empl> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "Department [id=" + deptId +
               ", name=" + name +
               ", manager=" + managerName +
               "]";
    }

	public void setEmployees(Set<Empl> employees) {
        this.employees = employees;
    }
}