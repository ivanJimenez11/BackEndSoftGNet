package com.project.carrier.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "route")
public class Route {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
	private Long id;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Drivers drivers;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicles vehicles;
	
	@Column(name = "active")
	private Boolean active;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Drivers getDrivers() {
		return drivers;
	}

	public void setDrivers(Drivers drivers) {
		this.drivers = drivers;
	}

	public Vehicles getVehicles() {
		return vehicles;
	}

	public void setVehicles(Vehicles vehicles) {
		this.vehicles = vehicles;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	
}
