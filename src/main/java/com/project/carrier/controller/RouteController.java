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

import com.project.carrier.models.Route;
import com.project.carrier.services.RouteService;


@RestController
@RequestMapping("/secure")
public class RouteController {
	@Autowired
	private RouteService routeService;
	
	@CrossOrigin
	@GetMapping(value = "/routelist")
	public List<Route> allRoute(){
		return routeService.getAll();
	}
	
	@CrossOrigin
	@PostMapping(value = "/saveroute")
	public Route saveRoute(@RequestBody Route route){
		return routeService.saveRoute(route);
	}
	//en caso de que el parámetro sea opcional
	//@RequestParam(required = false)
	
	//@CrossOrigin
	//@GetMapping(value = "/deletedriver")
	//public String deleteDriver(@RequestParam Long driverId) {
		//return driverService.deleteDriver(driverId);
	//}
	
	@CrossOrigin
	@GetMapping(value = "/deleteroute")
	public String deleteRoute(@RequestParam long routeId){
		return routeService.deleteRoute(routeId);
	}
}
