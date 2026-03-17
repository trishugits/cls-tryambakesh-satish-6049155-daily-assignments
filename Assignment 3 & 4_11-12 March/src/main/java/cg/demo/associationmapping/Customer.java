package cg.demo.associationmapping;

import jakarta.persistence.*;
import java.util.Set;

// Owner Side object is created first and persisted
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custId;

    private String custName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "cust_pro",
        joinColumns = @JoinColumn(name = "custId"),
        inverseJoinColumns = @JoinColumn(name = "pId")
    )
    private Set<Product> products;

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    @Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", products=" + products + "]";
	}

	public Set<Product> getProducts() {
        return products;
    }
    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}