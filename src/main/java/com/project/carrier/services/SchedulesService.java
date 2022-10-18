package com.project.carrier.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.carrier.models.Drivers;
import com.project.carrier.models.Route;
import com.project.carrier.models.Schedules;
import com.project.carrier.models.Vehicles;
import com.project.carrier.repository.RouteRepo;
import com.project.carrier.repository.SchedulesRepo;

@Service
public class SchedulesService {
	@Autowired
	private SchedulesRepo schedulesRepo;
	
	@Autowired
	private RouteRepo routeRepo;
	
	public List<Schedules> getAll(){
		return schedulesRepo.findAll();
	}
	
	public Schedules saveSchedules (Schedules schedule) {
		
		if(schedule.getRoute().getId() != null) {
			
			return schedulesRepo.save(schedule);
		}
				
		return schedule;
	}

	public Schedules getSchedules (Long scheduleId) {
		return schedulesRepo.findById(scheduleId).get();
	}
	
	public String deleteSchedule (long scheduleId) {
		schedulesRepo.deleteById(scheduleId);
		return "Schedule deleted";
	}
}
