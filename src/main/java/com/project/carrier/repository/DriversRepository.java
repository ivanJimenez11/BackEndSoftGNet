package com.project.carrier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.carrier.models.Drivers;
import com.project.carrier.models.Route;

@Repository
public interface DriversRepository extends JpaRepository<Drivers, Long>{
	@Query(value = "select r.* from drivers r where r.last_name ilike :filter", nativeQuery = true)
	List<Drivers>filterDrivers(String filter);

}
