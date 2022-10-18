package com.project.carrier.models;

import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "schedules")
public class Schedules {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
	private Long id;
	
	@Column(name = "car_out")
	private String carOut;
	
	@ManyToOne
	@JoinColumn(name = "route_id")
	public Route route;
	
	@Column(name = "week_num")
	private Integer weekNum;
	
	//@Temporal(TemporalType.TIMESTAMP)
	
	//, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	//@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss", timezone = "GMT-5")
	
	
	//@Temporal(TemporalType.TIMESTAMP)
	
	//, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	//@JsonFormat(pattern="dd-MM-yyyy HH:mm:ss", timezone = "GMT-5")
	@Column(name = "car_to")
	private String carto;
	
	@Column(name = "active")
	private boolean active;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route2) {
		this.route = route2;
	}

	public Integer getWeekNum() {
		return weekNum;
	}

	public void setWeekNum(Integer weekNum) {
		this.weekNum = weekNum;
	}

	public String getFrom() {
		return carOut;
	}

	public void setFrom(String from) {
		this.carOut = from;
	}

	public String getTo() {
		return carto;
	}

	public void setTo(String to) {
		this.carto = to;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
