package com.project.carrier.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.carrier.models.Drivers;
import com.project.carrier.repository.DriversRepository;

@Service
public class DriversService {
    
	@Autowired
	private DriversRepository driverRepo;
	
	public List<Drivers> getAll(String filter){
		filter = (filter == null ? "%" : "%" + filter.toLowerCase() + "%");
		return driverRepo.filterDrivers(filter);
		//return driverRepo.findAll();
	}
	
	public Drivers saveDriver (Drivers driver) {
		return driverRepo.save(driver);
	}
	
	public Drivers getDriver (Long driverId) {
		return driverRepo.findById(driverId).get();
	}
	
	public String deleteDriver (long driverId) {
		driverRepo.deleteById(driverId);
		return "driver deleted";
	}
}
