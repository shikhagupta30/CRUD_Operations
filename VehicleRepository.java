package com.springboot.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle,Long> {
	
	
	@Query(value="select v from Vehicle v where v.cost > 1500000")		//JPQL QUERY LANGUAGE.
	public List<Vehicle> showVehicleByCost();
	
	//@Query(value="select v from Vehicle v where v.cost > ?1")		//JPQL QUERY LANGUAGE.
	@Query(value="select * from vehicle_details where v_cost > :cost", nativeQuery=true)	//SQL QUERY LANGUAGE.
	public List<Vehicle> showVehicleAsCost(double cost);
	
}
