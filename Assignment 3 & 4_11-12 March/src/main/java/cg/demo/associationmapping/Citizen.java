package cg.demo.associationmapping;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Citizen {
	@Id
	private int adharNo;
	private String name;
	private String address;
	
//	@OneToOne(mappedBy="citizen")
	@OneToOne(cascade=CascadeType.ALL)
	private IndianPassport ip;
	
	public IndianPassport getIp() {
		return ip;
	}
	public void setIp(IndianPassport ip) {
		this.ip = ip;
	}
	public int getAdharNo() {
		return adharNo;
	}
	public void setAdharNo(int adharNo) {
		this.adharNo = adharNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
