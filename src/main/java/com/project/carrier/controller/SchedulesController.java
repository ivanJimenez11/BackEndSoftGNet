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

import com.project.carrier.models.Schedules;
import com.project.carrier.services.SchedulesService;

@RestController
@RequestMapping("/secure")
public class SchedulesController {
	@Autowired
	private SchedulesService scheduleService;
	
	@CrossOrigin
	@GetMapping(value = "/schedulelist")
	public List<Schedules> allSchedules(){
		return scheduleService.getAll();
	}
	
	@CrossOrigin
	@PostMapping(value = "/saveschedule")
	public Schedules saveSchedule(@RequestBody Schedules schedule){
		System.out.print("Objeto: " + schedule);
		return scheduleService.saveSchedules(schedule);
	}
	//en caso de que el parámetro sea opcional
	//@RequestParam(required = false)
	
	//@CrossOrigin
	//@GetMapping(value = "/deletedriver")
	//public String deleteDriver(@RequestParam Long driverId) {
		//return driverService.deleteDriver(driverId);
	//}
	
	@CrossOrigin
	@GetMapping(value = "/deleteSchedule")
	public String deleteSchedule(@RequestParam long scheduleId){
		return scheduleService.deleteSchedule(scheduleId);
	}
}
