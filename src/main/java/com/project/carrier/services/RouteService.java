package com.project.carrier.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.carrier.models.Drivers;
import com.project.carrier.models.Route;
import com.project.carrier.models.Schedules;
import com.project.carrier.models.Vehicles;
import com.project.carrier.repository.DriversRepository;
import com.project.carrier.repository.RouteRepo;
import com.project.carrier.repository.SchedulesRepo;
import com.project.carrier.repository.VehiclesRepository;

@Service
public class RouteService {
	@Autowired
	private RouteRepo routeRepo;
	
	@Autowired
	private DriversRepository driverRepo;
	
	@Autowired
	private VehiclesRepository vehicleRepo;
	
	@Autowired
	private SchedulesRepo scheduleRepo;
	
	public List<Route> getAll(){
		return (List<Route>) routeRepo.findAll();
	}
	
	public Route saveRoute (Route route) {
		Drivers driver = driverRepo.getById(route.getDrivers().getId());
		Vehicles vehicle = vehicleRepo.getById(route.getVehicles().getId());
		return routeRepo.save(route);
	}
	
	public Route getRoute (Long routeId) {
		return routeRepo.findById(routeId).get();
	}
	
	public String deleteRoute (long routeId) {
		List<Schedules>scheduleAssociated = scheduleRepo.schedulesRouteAssociated(routeId);
		if(scheduleAssociated != null && scheduleAssociated.size() > 0) {
			for(Schedules s : scheduleAssociated) {
				scheduleRepo.delete(s);
			}
		}
		routeRepo.deleteById(routeId);
		return "Route deleted";
	}
}
