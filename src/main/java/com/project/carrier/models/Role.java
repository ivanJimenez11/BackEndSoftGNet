package com.project.carrier.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity(name = "role")
	@Table(name = "role")
	//@Data
	//@NoArgsConstructor
	//@AllArgsConstructor
	public class Role {
		
		@Id
		//@GeneratedValue(strategy = GenerationType.AUTO)
		@GeneratedValue(strategy = GenerationType.IDENTITY)

		private Long id;
		private String name;
		
		
		public Role() {
		}
		
		public Role(Long id, String name) {
			this.id = id;
			this.name = name;
		}

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		

}