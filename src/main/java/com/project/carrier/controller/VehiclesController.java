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

import com.project.carrier.models.Vehicles;
import com.project.carrier.services.VehicleService;


@RestController
@RequestMapping("/secure")
public class VehiclesController {
	@Autowired
	private VehicleService vehiclesService;
	
	@CrossOrigin
	@GetMapping(value = "/vehicleslist")
	public List<Vehicles> allVehicles(){
		return vehiclesService.getAll();
	}
	
	@CrossOrigin
	@PostMapping(value = "/saveVehicle")
	public Vehicles saveVehicles(@RequestBody Vehicles vehicle){
		return vehiclesService.saveVehicle(vehicle);
	}

	@CrossOrigin
	@GetMapping(value = "/deletevehicle")
	public String deleteVehicle(@RequestParam long vehicleId) throws Exception{
		return vehiclesService.deleteVehicle(vehicleId);
	}
}
