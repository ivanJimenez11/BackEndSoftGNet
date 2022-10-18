package com.project.carrier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.carrier.models.Drivers;
import com.project.carrier.models.Vehicles;

@Repository
public interface VehiclesRepository extends JpaRepository<Vehicles, Long>  {

}
