package cg.demo.associationmapping;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.CascadeType;

@Entity
public class IndianPassport {
	@Id
	private int passportNo;
	private LocalDate passportExpiryDate;
	
//	@OneToOne(cascade =CascadeType.ALL)
	@OneToOne(mappedBy="ip")
	private Citizen citizen;
	public int getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(int passportNo) {
		this.passportNo = passportNo;
	}
	public LocalDate getPassportExpiryDate() {
		return passportExpiryDate;
	}
	public void setPassportExpiryDate(LocalDate passportExpiryDate) {
		this.passportExpiryDate = passportExpiryDate;
	}
	public Citizen getCitizen() {
		return citizen;
	}
	public void setCititzen(Citizen citizen) {
		this.citizen = citizen;
	}
	
	
}
