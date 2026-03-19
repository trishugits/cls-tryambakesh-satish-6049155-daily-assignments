package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Trainee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tId;
	private String tName;
	private String tDomain;
	private String tLocation;

	public Trainee() {};
	
	public Trainee(String tNAme, String tDomain, String tLoaction) {
		super();
		this.tName = tNAme;
		this.tDomain = tDomain;
		this.tLocation = tLoaction;
	}

	public String gettNAme() {
		return tName;
	}

	public void settNAme(String tNAme) {
		this.tName = tNAme;
	}

	public String gettDomain() {
		return tDomain;
	}

	public void settDomain(String tDomain) {
		this.tDomain = tDomain;
	}

	public String gettLoaction() {
		return tLocation;
	}

	public void settLoaction(String tLoaction) {
		this.tLocation = tLoaction;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	@Override
	public String toString() {
		return "Trainee \ntId=" + tId + ", tNAme=" + tName + ", tDomain=" + tDomain + ", tLoaction=" + tLocation;
	}

}
