package com.project.carrier.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.carrier.models.Drivers;
import com.project.carrier.models.Route;
import com.project.carrier.models.Vehicles;
import com.project.carrier.repository.DriversRepository;
import com.project.carrier.repository.RouteRepo;
import com.project.carrier.repository.VehiclesRepository;

@Service
public class VehicleService {

	@Autowired
	private VehiclesRepository VehicleRepo;
	
	@Autowired
	private RouteRepo routeRepo;
	
	public List<Vehicles> getAll(){
		return VehicleRepo.findAll();
	}
	
	public Vehicles saveVehicle (Vehicles vehicle) {
		return VehicleRepo.save(vehicle);
	}
	
	public Vehicles getVehicle (Long vehicleId) {
		return VehicleRepo.findById(vehicleId).get();
	}
	
	public String deleteVehicle (long vehicleId) throws Exception {
		checkVehicle(vehicleId);
		VehicleRepo.deleteById(vehicleId);
		return "Vehicle deleted";
	}
	
	private void checkVehicle (long vehicleId) throws Exception {
		Vehicles vehicle = VehicleRepo.getById(vehicleId);
		List<Route>listRoute = routeRepo.vehicleRouteAssocied(vehicleId);
		if(listRoute != null && listRoute.size() > 0) {
			throw new Exception("This vehicle has associated routes.");
		}
	}
}
