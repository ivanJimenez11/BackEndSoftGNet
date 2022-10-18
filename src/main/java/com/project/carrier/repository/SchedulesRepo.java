package com.project.carrier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.carrier.models.Route;
import com.project.carrier.models.Schedules;


@Repository
public interface SchedulesRepo extends JpaRepository<Schedules, Long> {
	@Query(value = "select r.* from schedules r where r.route_id = :routeId", nativeQuery = true)
	List<Schedules>schedulesRouteAssociated(long routeId);
}
