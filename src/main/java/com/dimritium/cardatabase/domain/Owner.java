package com.dimritium.cardatabase.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7692137826219170169L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ownerid;
	private String firstname, lastname;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	@JsonIgnore
	private List<Car> cars;
	
	public List<Car> getCars() {
		return cars;
	}
//
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
//	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "car_owner", joinColumns = { @JoinColumn(name = "ownerid")}, inverseJoinColumns = {@JoinColumn(name="id")})
//	private Set<Car> cars = new HashSet<Car>(0);
//
//	public Set<Car> getCars() {
//		return cars;
//	}
//
//	public void setCars(Set<Car> cars) {
//		this.cars = cars;
//	}

	public Owner() {
	
	}

	public Owner(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
