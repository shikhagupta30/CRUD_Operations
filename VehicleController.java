package com.springboot.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {

	@Autowired
	private VehicleServices vehicleServices;
	
	@PostMapping("/savevehicle")
	public Vehicle saveVehicle(@RequestBody Vehicle v)
	{
		return this.vehicleServices.vehicleSave(v);
	}
	
	@GetMapping("/allvehicle")
	public List<Vehicle> showAllVehicle()
	{
		return this.vehicleServices.vehicleShowAll();
	}
	
	@GetMapping("/vehicle/{id}")
	public Optional<Vehicle> showVehicle(@PathVariable("id") Long id)
	{
		Optional<Vehicle> v = (Optional<Vehicle>)this.vehicleServices.vehicleShow(id);
		return v;
	}
	
	@PutMapping("/updatevehicle/{id}")
	public Vehicle updateVehicle(@RequestBody Vehicle v, @PathVariable("id") Long id)
	{
		v.setId(id);
		Vehicle obj = (Vehicle)this.vehicleServices.vehicleSave(v);
		System.out.println("Updated Record : " + obj.toString());
		return obj;
	}
	
	@DeleteMapping("remove/{id}")
	public String removeVehicle(@PathVariable("id") long id) 
	{
		this.vehicleServices.vehicleDelete(id);
		return "Record Deleted...!!";
	}
	
	@GetMapping("vehicebycost")
	public List<Vehicle> byCostVehicle()
	{
		return this.vehicleServices.vehicleByCost();
	}
	
	@GetMapping("ascost/{cost}")
	public List<Vehicle> asCostVehicle(@PathVariable("cost") double cost)
	{
		return this.vehicleServices.asPerCost(cost);
	}
	
}
