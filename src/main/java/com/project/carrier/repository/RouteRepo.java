package com.project.carrier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.carrier.models.Route;

@Repository
public interface RouteRepo extends CrudRepository<Route, Long> {
	
	@Query(value = "select r.* from route r where r.vehicle_id = :vehicleId", nativeQuery = true)
	List<Route>vehicleRouteAssocied(long vehicleId);
	
	@Query(value = "select r from Route r where r.id = :idRoute")
	Route getRouteById(Integer idRoute);

}
