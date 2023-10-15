package com.springboot.jpa;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class VehicleServices {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	//FOR SAVING THE DATA WE CALL THE save METHOD FROM REPOSITORY
	//FOR THIS WE HAVE TO CREATE A METHOD
	
	public Vehicle vehicleSave(Vehicle v)
	{
		Vehicle obj = (Vehicle)this.vehicleRepository.save(v);
		System.out.println("Record Saved : " +v.toString());
		return obj;
	}
	
	//FOR RETRIEVING ALL THE VEHICLES AND SHOW IN JSON FORM
	//THROUGH POSTMAN OF FORM (jsp)
	
	public List<Vehicle> vehicleShowAll()
	{
		return (List<Vehicle>) this.vehicleRepository.findAll();
	}
	
	public Optional<Vehicle> vehicleShow(long id)
	{
		Optional<Vehicle> v = this.vehicleRepository.findById(id);
		return v;
	}
	
	public void vehicleDelete(long id)
	{
		this.vehicleRepository.deleteById(id);
	}
	
	public List<Vehicle> vehicleByCost()
	{
		return this.vehicleRepository.showVehicleByCost();
	}
	
	public List<Vehicle> asPerCost(double cost)
	{
		return this.vehicleRepository.showVehicleAsCost(cost);
	}
} 