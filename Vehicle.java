package com.springboot.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicle_details")
public class Vehicle {

	@Id
		//  Why use @GeneratedValue?
		//	By marking the @Id field with @GeneratedValue 
		//	we are now enabling id generation. 
		//	Which means that the persistence layer will generate an Id value for us 
		//	and handle the auto incrementing. 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="v_name", length=30)
	private String name;
	
	@Column(name="v_company" ,length=30)
	private String company;
	
	@Column(name="v_cost")
	private double cost;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(long id, String name, String company, double cost) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
		this.cost = cost;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", name=" + name + ", company=" + company + ", cost=" + cost + "]";
	}
	
	
}
