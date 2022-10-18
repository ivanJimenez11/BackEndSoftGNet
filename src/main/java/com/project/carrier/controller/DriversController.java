package com.project.carrier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.carrier.models.Drivers;
import com.project.carrier.services.DriversService;

@RestController
@RequestMapping("/secure")
public class DriversController {
	 
	@Autowired
	private DriversService driverService;
	
	@CrossOrigin
	@GetMapping(value = "/driverlist")
	public List<Drivers> allDrivers(@RequestParam(required = false, value = "filter") String filter){
		return driverService.getAll(filter);
	}
	
	@CrossOrigin
	@PostMapping(value = "/savedriver")
	public Drivers saveDrivers(@RequestBody Drivers driver){
		return driverService.saveDriver(driver);
	}
	//en caso de que el parámetro sea opcional
	//@RequestParam(required = false)
	
	//@CrossOrigin
	//@GetMapping(value = "/deletedriver")
	//public String deleteDriver(@RequestParam Long driverId) {
		//return driverService.deleteDriver(driverId);
	//}
	
	@CrossOrigin
	@GetMapping(value = "/deletedriver")
	public String deleteDriver(@RequestParam long driverId){
		return driverService.deleteDriver(driverId);
	}
}
